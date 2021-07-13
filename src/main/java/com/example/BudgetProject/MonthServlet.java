package com.example.BudgetProject;

import Project.DAO.ImplCategoryCostDao;
import Project.DAO.ImplCategoryIncomeDao;
import Project.DAO.ImplExpensesDao;
import Project.Entity.CategoryCost;
import Project.Entity.CategoryIncome;
import Project.Service.CategoryCostService;
import Project.Service.CategoryIncomeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by .
 */
@WebServlet("/month")
public class MonthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long month = Long.parseLong(req.getParameter("idMonth"));
        Long year = Long.parseLong(req.getParameter("year"));

        req.setCharacterEncoding("UTF-8");
        CategoryIncomeService categoryIncomeService = new CategoryIncomeService();
        List<CategoryIncome> allCategoriesIncome = categoryIncomeService.getAll(month);

        CategoryCostService categoryCostService = new CategoryCostService();
        List<CategoryCost> allCategoriesCost = categoryCostService.getAllCategory(month);

        req.setAttribute("categoriesCost", allCategoriesCost);
        req.setAttribute("idMonth",month);
        req.setAttribute("categoriesIncome", allCategoriesIncome);
        req.setAttribute("year",year);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/month.jsp");
        requestDispatcher.forward(req, resp);
    }
}
