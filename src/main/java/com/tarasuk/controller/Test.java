package com.tarasuk.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/test")
public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookie = req.getCookies();
        ArrayList<String> myString = new ArrayList<>();
        for (int i = 0; i < cookie.length; i++)
            myString.add(cookie[i].getValue());
        req.setAttribute("cookie", myString);
        req.getRequestDispatcher("WEB-INF/view/test.jsp").forward(req, resp);

    }
}
