package com.example.BudgetProject;

import Project.Entity.CategoryCost;
import Project.Service.CategoryCostService;
import Project.Service.ExpensesService;

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
@WebServlet("/deleteCost")
public class DeleteCategoryCostServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryCostService categoryCostService = new CategoryCostService();
        long id = Long.parseLong(req.getParameter("id"));
        categoryCostService.delete(id);
        req.setAttribute("idMonth",req.getParameter("idMonth"));

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/month");
        requestDispatcher.forward(req,resp);
    }
}
