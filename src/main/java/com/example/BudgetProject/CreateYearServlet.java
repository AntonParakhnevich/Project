package com.example.BudgetProject;

import Project.Entity.Family;
import Project.Entity.Year;
import Project.Service.BudgetService;
import Project.Service.YearService;

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
@WebServlet("/createYear")
public class CreateYearServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/createYear.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BudgetService budgetService = new BudgetService();
        HttpSession session = req.getSession();
        Family family = (Family) session.getAttribute("family");
        Long idBudget = family.getBudget().getId();
        int year = Integer.parseInt(req.getParameter("year"));

        Year year1 = Year.builder().year(year).build();

        budgetService.addYear(year1,idBudget);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/hello-servlet");
        requestDispatcher.forward(req, resp);
    }
}
