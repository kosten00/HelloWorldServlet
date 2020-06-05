package ru.academits;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HelloWorldServlet extends HttpServlet {
    private final String DEFAULT_STRING = "Hello from HelloWorldServlet";

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getOutputStream().write(DEFAULT_STRING.getBytes(StandardCharsets.UTF_8));
        resp.getOutputStream().flush();
        resp.getOutputStream().close();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String postedString = req.getParameter("postedString");

        if (postedString.length() == 0) {
            postedString = DEFAULT_STRING;
        }

        resp.getOutputStream().write(postedString.getBytes(StandardCharsets.UTF_8));
        resp.getOutputStream().flush();
        resp.getOutputStream().close();
    }
}