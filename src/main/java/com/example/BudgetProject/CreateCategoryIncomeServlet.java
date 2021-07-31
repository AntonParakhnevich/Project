package com.example.BudgetProject;

import Project.Entity.CategoryCost;
import Project.Entity.CategoryIncome;
import Project.Service.CategoryCostService;
import Project.Service.CategoryIncomeService;
import Project.Service.ExpensesService;
import Project.Service.IncomeService;

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
@WebServlet("/createIncome")
public class CreateCategoryIncomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/createCategoryIncome.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryIncomeService categoryIncomeService = new CategoryIncomeService();
        IncomeService incomeService = new IncomeService();

        try {
            Long idMonth = Long.parseLong(req.getParameter("idMonth"));
            String name = req.getParameter("name");
            int price = Integer.parseInt(req.getParameter("price"));

            req.setAttribute("idMonth", idMonth);

            CategoryIncome categoryIncome = CategoryIncome.builder().name(name).value(price).build();
            categoryIncomeService.save(categoryIncome);
            incomeService.addCategoryCost(categoryIncome, idMonth);

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/month");
            requestDispatcher.forward(req, resp);
        }
        catch (Exception e) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/createCategoryIncome.jsp");
            requestDispatcher.forward(req, resp);
        }


    }
}
