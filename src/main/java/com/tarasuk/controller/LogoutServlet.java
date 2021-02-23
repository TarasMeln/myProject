package com.tarasuk.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
//        Cookie cookie1 = new Cookie("IdUserBD", "");
//        Cookie cookie2 = new Cookie("Role", "");
//        cookie1.setMaxAge(0);
//        cookie2.setMaxAge(0);
//        resp.addCookie(cookie1);
//        resp.addCookie(cookie2);
        req.getRequestDispatcher("WEB-INF/view/logout.jsp").forward(req, resp);

    }
}
