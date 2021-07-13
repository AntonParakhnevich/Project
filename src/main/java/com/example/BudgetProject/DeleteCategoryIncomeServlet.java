package com.example.BudgetProject;

import Project.Service.CategoryCostService;
import Project.Service.CategoryIncomeService;

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
@WebServlet("/deleteIncome")
public class DeleteCategoryIncomeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryIncomeService categoryIncomeService = new CategoryIncomeService();
        long id = Long.parseLong(req.getParameter("id"));
        categoryIncomeService.delete(id);
        req.setAttribute("idMonth",req.getParameter("idMonth"));

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/month");
        requestDispatcher.forward(req,resp);
    }
}
