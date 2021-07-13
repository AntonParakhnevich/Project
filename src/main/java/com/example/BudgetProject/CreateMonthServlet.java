package com.example.BudgetProject;

import Project.Entity.Expenses;
import Project.Entity.Family;
import Project.Entity.Income;
import Project.Entity.Month;
import Project.Entity.Year;
import Project.Service.YearService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Set;

/**
 * Created by .
 */
@WebServlet("/createMonth")
public class CreateMonthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/createMonth.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Long year = Long.parseLong(req.getParameter("year"));
        String month = req.getParameter("month");
        System.out.println(month);

        YearService yearService = new YearService();

        Month monthNew = Month.builder()
                .name(month)
                .income(Income.builder().build())
                .expenses(Expenses.builder().build())
                .build();

        yearService.addMonth(monthNew, year);
        req.setAttribute("year",year);
        System.out.println(year);
//        resp.sendRedirect("http://localhost:8080/BudgetProject_war_exploded/year");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/year");
        requestDispatcher.forward(req, resp);
    }
}
