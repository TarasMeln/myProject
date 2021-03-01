package com.tarasuk.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/main-page")
public class MainPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Boolean isLog = (Boolean) session.getAttribute("isLog");
        if (isLog == null) {
            isLog = false;
        }
        req.setAttribute("isLog", isLog);
        req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
    }
}
