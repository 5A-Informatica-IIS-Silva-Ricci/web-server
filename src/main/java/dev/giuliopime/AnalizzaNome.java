package dev.giuliopime;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.giuliopime.http.clients.AgeClient;
import dev.giuliopime.http.clients.GenderClient;
import dev.giuliopime.http.clients.NationClient;

import javax.servlet.ServletException;
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
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String nome = req.getParameter("nome");

            if (nome == null)
                req.getRequestDispatcher(Environment.ERROR_FILE).forward(req, resp);
            else {
                Thread r1 = new Thread(() ->
                {
                    try {
                        req.setAttribute("ageBean", new AgeClient().get(nome));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                );

                Thread r2 = new Thread(() -> {
                    try {
                        req.setAttribute("genderBean", new GenderClient().get(nome));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

                Thread r3 = new Thread(() -> {
                    try {
                        req.setAttribute("countryBean", new NationClient().get(nome).getCountries().get(0));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

                ArrayList<Thread> threads = new ArrayList<>(Arrays.asList(r1, r2, r3));

                threads.forEach(Thread::start);

                try {
                    for (Thread thread : threads) {
                        thread.join();

                        if (thread.getStackTrace().length > 0) {
                            req.getRequestDispatcher(Environment.ERROR_FILE).forward(req, resp);
                            return;
                        }
                    }

                    req.getRequestDispatcher(Environment.SUCCESS_FILE)
                            .forward(req, resp);
                } catch (InterruptedException e) {
                    req.getRequestDispatcher(Environment.ERROR_FILE).forward(req, resp);
                }
            }
        } catch (Exception e) {
            try {
                req.getRequestDispatcher(Environment.ERROR_FILE).forward(req, resp);
            } catch (ServletException | IOException exception) {
                System.out.println("Errore servlet");
                System.out.println(exception);
            }
        }
    }
}
