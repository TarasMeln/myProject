package com.tarasuk.controller;

import com.tarasuk.db.Model.User;
import com.tarasuk.util.UserUtil;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private UserUtil userUtil;
    @Resource(name = "jdbc/mydatabase")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String theCommand = req.getParameter("command");
            if (theCommand == null) {
                theCommand = "PAGE";
            }
            switch (theCommand) {
                case "PAGE":
                    loginPage(req, resp);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loginPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/view/login.jsp").forward(req, resp);
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (userUtil.login(email, password)) {
            session.setAttribute("Role", userUtil.UserIsAdmin(email, password));
            session.setAttribute("IdUserBD", userUtil.getUserId(email, password));
            req.getRequestDispatcher("WEB-INF/view/index.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("WEB-INF/view/wrong-login.jsp").forward(req, resp);
        }
    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User(email, password);
        userUtil.addUser(user);

        loginPage(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String theCommand = req.getParameter("command");
            if (theCommand == null) {
                theCommand = "PAGE";
            }
            switch (theCommand) {
                case "ADD":
                    addUser(req, resp);
                    break;
                case "LOGIN":
                    login(req, resp);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            userUtil = new UserUtil(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
