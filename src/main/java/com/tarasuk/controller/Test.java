package com.tarasuk.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/")
public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Boolean isLog = (Boolean) session.getAttribute("Role");
        if (isLog != null) {
            isLog = true;
        } else {
            isLog = false;
        }
        req.setAttribute("isLog", isLog);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
