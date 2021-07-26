package com.example.BudgetProject;

import Project.Entity.Family;
import Project.Entity.Month;
import Project.Service.FamilyService;
import Project.Service.YearService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by .
 */
@WebServlet("/year")
public class YearServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FamilyService familyService = new FamilyService();
        YearService yearService = new YearService();
        Long year = Long.parseLong(req.getParameter("year"));
        req.setAttribute("year", year);
        Family family = (Family) req.getSession().getAttribute("family");
        req.getSession().setAttribute("family", familyService.getFamily(family.getId()));
        List<Month> allMonth = yearService.getAllMonth(year);
        req.setAttribute("months", allMonth);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Year.jsp");
        dispatcher.forward(req, resp);
    }
}
