package dev.giuliopime;

import dev.giuliopime.http.clients.AgeClient;
import dev.giuliopime.http.clients.GenderClient;
import dev.giuliopime.http.clients.NationClient;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AnalizzaNome extends HttpServlet {
    @Override
    public void init() {
        System.out.println("Inizializzata servlet per l'analisi dei nomi");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("Richiesta GET: " + req.getRequestURI());
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String nome = req.getParameter("nome");

            if (nome == null) {
                System.out.println("Parametro nome non trovato");
                resp.sendRedirect(Environment.ERROR_FILE);
            } else {
                // Avvio le tre richieste http in tre thread diversi per eseguirle in contemporanea
                Thread r1 = new Thread(() ->
                {
                    try {
                        AttributiCondivisi.getInstance().setEta(
                                new AgeClient().get(nome).getAge()
                        );
                    } catch (UnknownError e) {
                        throw new RuntimeException(e);
                    }
                }
                );

                Thread r2 = new Thread(() -> {
                    try {
                        AttributiCondivisi.getInstance().setGenere(
                                new GenderClient().get(nome).getGenderString()
                        );
                    } catch (UnknownError e) {
                        throw new RuntimeException(e);
                    }
                });

                Thread r3 = new Thread(() -> {
                    try {
                        AttributiCondivisi.getInstance().setNazione(
                                new NationClient().get(nome)
                                        .getCountries()
                                        .get(0)
                                        .getCountry()
                        );
                    } catch (UnknownError e) {
                        throw new RuntimeException(e);
                    }
                });

                ArrayList<Thread> threads = new ArrayList<>(Arrays.asList(r1, r2, r3));

                threads.forEach(Thread::start);

                try {
                    // Aspetto che tutti e tre i thread finiscano di eseguire le richieste
                    for (Thread thread : threads) {
                        thread.join();

                        if (thread.getStackTrace().length > 0) {
                            resp.sendRedirect(Environment.ERROR_FILE);
                            return;
                        }
                    }

                    AttributiCondivisi attributiCondivisi = AttributiCondivisi.getInstance();

                    req.setAttribute("eta", attributiCondivisi.getEta());
                    req.setAttribute("nazione", attributiCondivisi.getNazione());
                    req.setAttribute("genere", attributiCondivisi.getGenere());

                    req.getRequestDispatcher(Environment.SUCCESS_FILE)
                            .forward(req, resp);
                } catch (InterruptedException e) {
                    resp.sendRedirect(Environment.ERROR_FILE);
                }
            }
        } catch (Exception e) {
            try {
                System.out.println("Errore nella servlet");
                System.out.println(e);
                resp.sendRedirect(Environment.ERROR_FILE);
            } catch (IOException exception) {
                System.out.println("Errore servlet");
                System.out.println(exception);
            }
        }
    }
}
