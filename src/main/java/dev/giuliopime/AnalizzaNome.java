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
    private static final String errorFile = Environment.ERROR_FILE;
    private static final String successFile = Environment.SUCCESS_FILE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");

        if (nome == null)
            req.getRequestDispatcher(errorFile).forward(req, resp);
        else {
            Thread r1 = new Thread(() ->
            {
                try {
                    req.setAttribute("ageBean", new AgeClient().get(nome));
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
            );

            Thread r2 = new Thread(() -> {
                try {
                    req.setAttribute("genderBean", new GenderClient().get(nome));
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            });

            Thread r3 = new Thread(() -> {
                try {
                    req.setAttribute("nationBean", new NationClient().get(nome));
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            });

            ArrayList<Thread> threads = new ArrayList<>(Arrays.asList(r1, r2, r3));

            threads.forEach(Thread::start);

            try {
                for (Thread thread : threads) {
                    thread.join();

                    if (thread.getStackTrace().length > 0) {
                        req.getRequestDispatcher(errorFile).forward(req, resp);
                        return;
                    }
                }

                req.getRequestDispatcher(successFile)
                        .forward(req, resp);
            } catch (InterruptedException e) {
                req.getRequestDispatcher(errorFile).forward(req, resp);
            }
        }
    }
}
