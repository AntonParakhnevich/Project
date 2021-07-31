package com.example.BudgetProject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by .
 */
@WebServlet("/language")
public class LanguageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/language.jsp");
        requestDispatcher.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String language = req.getParameter("language");
        HttpSession session = req.getSession();
        session.setAttribute("language",language);
//        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/start.jsp");
//        requestDispatcher.forward(req,resp);
        resp.sendRedirect("http://localhost:8080/BudgetProject_war_exploded/start");

    }
}
