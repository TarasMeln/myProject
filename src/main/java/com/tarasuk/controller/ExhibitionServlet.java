package com.tarasuk.controller;

import com.tarasuk.db.entity.Exhibition;
import com.tarasuk.util.ExhibitionUtil;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/exhibition")
public class ExhibitionServlet extends HttpServlet {
    private ExhibitionUtil exhibitionUtil;
    @Resource(name = "jdbc/mydatabase")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String theCommand = req.getParameter("command");
            if (theCommand == null) {
                theCommand = "LIST";
            }
            switch (theCommand) {
                case "LIST":
                    listExhibition(req, resp);
                    break;
                case "SORT_BY_THEME":
                    sortByTheme(req, resp);
                    break;
                case "SORT_BY_DATE":
                    sortByDate(req, resp);
                    break;
                case "SORT_BY_PRICE":
                    sortByPrice(req, resp);
                    break;
                case "ADD":
                    addExhibition(req, resp);
                    break;
                case "LOAD":
                    loadUpdateFormExhibition(req, resp);
                    break;
                case "UPDATE":
                    updateExhibition(req, resp);
                    break;
                case "DELETE":
                    deleteExhibition(req, resp);
                    break;
                case "BUY":
                    buyExhibition(req, resp);
                    break;
                case "STATISTICS":
                    exhibitionStatistics(req, resp);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sortByDate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Exhibition> exhibitions = exhibitionUtil.sortBy("Date");
        req.setAttribute("Exhibition_List", exhibitions);
        req.getRequestDispatcher("WEB-INF/view/exhibition-list.jsp").forward(req, resp);
    }

    private void sortByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Exhibition> exhibitions = exhibitionUtil.sortBy("Price");
        req.setAttribute("Exhibition_List", exhibitions);
        req.getRequestDispatcher("WEB-INF/view/exhibition-list.jsp").forward(req, resp);
    }

    private void sortByTheme(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Exhibition> exhibitions = exhibitionUtil.sortBy("Theme");
        req.setAttribute("Exhibition_List", exhibitions);
        req.getRequestDispatcher("WEB-INF/view/exhibition-list.jsp").forward(req, resp);
    }


    private void buyExhibition(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        Boolean isAdmin = (Boolean) session.getAttribute("Role");
        if (isAdmin != null) {
            String exId = req.getParameter("exhibitionId");
            long exhibitionId = Long.parseLong(exId);
            long userId = (Long) session.getAttribute("IdUserBD");
            exhibitionUtil.buyTicket(exhibitionId, userId);
            listExhibition(req, resp);
        } else {
            req.getRequestDispatcher("WEB-INF/view/error.jsp").forward(req, resp);
        }


    }


    private void deleteExhibition(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        Boolean isAdmin = (Boolean) session.getAttribute("Role");
        if (isAdmin != null) {
            if (isAdmin) {
                String exhibitionId = req.getParameter("exhibitionId");
                exhibitionUtil.deleteExhibition(exhibitionId);
                listExhibition(req, resp);
            } else {
                req.getRequestDispatcher("WEB-INF/view/error.jsp").forward(req, resp);
            }
        } else {
            req.getRequestDispatcher("WEB-INF/view/error.jsp").forward(req, resp);
        }


    }

    private void exhibitionStatistics(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        Boolean isAdmin = (Boolean) session.getAttribute("Role");
        if (isAdmin != null) {
            if (isAdmin) {
                String exhibitionId = req.getParameter("exhibitionId");
                Exhibition exhibition = exhibitionUtil.getExhibitionById(exhibitionId);
                req.setAttribute("THE_EXHIBITION", exhibition);
                int purchasedTickets = exhibitionUtil.statistics(exhibition.getId());
                req.setAttribute("PURCHASED_TICKETS", purchasedTickets);
                req.getRequestDispatcher("/statistics-exhibition-form.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("WEB-INF/view/error.jsp").forward(req, resp);
            }
        } else {
            req.getRequestDispatcher("WEB-INF/view/error.jsp").forward(req, resp);
        }


    }

    private void updateExhibition(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        long id = Long.parseLong(req.getParameter("exhibitionId"));
        String theme = req.getParameter("theme");
        long hall = Long.parseLong(req.getParameter("hall"));
        Timestamp date = Timestamp.valueOf(req.getParameter("date"));
        double ticketPrice = Double.parseDouble(req.getParameter("ticketPrice"));
        Exhibition exhibition = new Exhibition(id, theme, hall, date, ticketPrice);
        exhibitionUtil.updateExhibition(exhibition);
        listExhibition(req, resp);
    }

    private void loadUpdateFormExhibition(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        Boolean isAdmin = (Boolean) session.getAttribute("Role");
        if (isAdmin != null) {
            if (isAdmin) {
                String exhibitionId = req.getParameter("exhibitionId");
                Exhibition exhibition = exhibitionUtil.getExhibitionById(exhibitionId);
                req.setAttribute("THE_EXHIBITION", exhibition);
                req.getRequestDispatcher("/update-exhibition-form.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("WEB-INF/view/error.jsp").forward(req, resp);
            }
        } else {
            req.getRequestDispatcher("WEB-INF/view/error.jsp").forward(req, resp);
        }


    }

    private void addExhibition(HttpServletRequest req, HttpServletResponse resp) throws Exception { //something went wrong, check it , even code logic bad , think about
        HttpSession session = req.getSession();
        Boolean isAdmin = (Boolean) session.getAttribute("Role");
        if (isAdmin != null) {
            if (isAdmin) {
                String theme = req.getParameter("theme");
                long hall = Long.parseLong(req.getParameter("hall"));
                Timestamp date = Timestamp.valueOf(req.getParameter("date"));
                double ticketPrice = Double.parseDouble(req.getParameter("ticketPrice"));
                Exhibition exhibition = new Exhibition(theme, hall, date, ticketPrice);
                exhibitionUtil.addExhibition(exhibition);
                listExhibition(req, resp);
            } else {
                req.getRequestDispatcher("WEB-INF/view/error.jsp").forward(req, resp);
            }
        } else {
            req.getRequestDispatcher("WEB-INF/view/error.jsp").forward(req, resp);
        }

    }

    private void listExhibition(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Exhibition> exhibitions = exhibitionUtil.findAllExhibition();
        req.setAttribute("Exhibition_List", exhibitions);

        HttpSession session = req.getSession();
        Boolean isAdmin = (Boolean) session.getAttribute("Role");
        Boolean isLog;
        if (isAdmin != null) {
            isLog = true;
            req.setAttribute("Log", isLog);
            req.setAttribute("Role", isAdmin);
        } else {
            isLog=false;
            req.setAttribute("Log", isLog);
        }

        req.getRequestDispatcher("WEB-INF/view/exhibition-list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            exhibitionUtil = new ExhibitionUtil(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
