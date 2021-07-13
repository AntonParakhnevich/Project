package com.example.BudgetProject;

import Project.DAO.ImplCategoryCostDao;
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
@WebServlet("/createCost")
public class CreateCategoryCostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/createCategoryCost.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryCostService categoryCostService = new CategoryCostService();
        ExpensesService expensesService = new ExpensesService();

        try {
            Long idMonth = Long.parseLong(req.getParameter("idMonth"));
            String name = req.getParameter("name");
            int price = Integer.parseInt(req.getParameter("price"));
            int binding = Integer.parseInt(req.getParameter("binding"));
            CategoryCost categoryCost = CategoryCost.builder().name(name).price(price).binding(binding).build();
            categoryCostService.save(categoryCost);

            req.setAttribute("idMonth", idMonth);

            expensesService.addCategoryCost(categoryCost, idMonth);

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/month");
            requestDispatcher.forward(req, resp);
        } catch (Exception e) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/createCategoryCost.jsp");
            requestDispatcher.forward(req, resp);
        }


    }
}
