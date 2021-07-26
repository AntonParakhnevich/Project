package com.example.BudgetProject;

import Project.Entity.Expenses;
import Project.Entity.Income;
import Project.Entity.Month;
import Project.Service.YearService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.YearMonth;

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
        YearMonth month = YearMonth.parse(req.getParameter("month"));

        YearService yearService = new YearService();

        Month monthNew = Month.builder()
                .name(month.getMonth().name())
                .income(Income.builder().build())
                .expenses(Expenses.builder().build())
                .build();

        yearService.addMonth(monthNew, year);
        req.setAttribute("year",year);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/year");
        requestDispatcher.forward(req, resp);
    }
}
