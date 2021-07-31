package com.example.BudgetProject;

import Project.Entity.Expenses;
import Project.Entity.Income;
import Project.Entity.Month;
import Project.Service.YearService;
import Project.Util.MonthNameRus;

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
        Long year = Long.parseLong(req.getParameter("year"));
        java.time.Month month = YearMonth.parse(req.getParameter("month")).getMonth();

        YearService yearService = new YearService();

        Month monthNew = Month.builder()
                .name(MonthNameRus.getNameMonth(month))
                .income(Income.builder().build())
                .expenses(Expenses.builder().build())
                .build();

        yearService.addMonth(monthNew, year);
        req.setAttribute("year", year);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/year");
        requestDispatcher.forward(req, resp);
    }

}



