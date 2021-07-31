package com.example.BudgetProject;

import Project.Service.BudgetService;
import Project.Service.FamilyService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by .
 */
@WebServlet("/calculate")
public class CalculateAccumulateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/calculate.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int years = Integer.parseInt(req.getParameter("years"));
        int income = Integer.parseInt(req.getParameter("income"));
        int cost = Integer.parseInt(req.getParameter("cost"));
        Integer accumulation = BudgetService.calculationAccumulationForTheTime(years, income, cost);

        req.setAttribute("years",years);
        req.setAttribute("income",income);
        req.setAttribute("cost",cost);
        req.setAttribute("accumulation",accumulation);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/resultCalculate.jsp");
        requestDispatcher.forward(req,resp);

    }
}
