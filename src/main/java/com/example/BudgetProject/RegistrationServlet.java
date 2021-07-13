package com.example.BudgetProject;

import Project.Entity.Budget;
import Project.Entity.CategoryCost;
import Project.Entity.Family;
import Project.Service.CategoryCostService;
import Project.Service.ExpensesService;
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
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FamilyService familyService = new FamilyService();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if(login==null || password ==null){
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp");
            requestDispatcher.forward(req, resp);
        }
        else
        {
            Budget budget = Budget.builder().build();
            Family family = Family.builder().login(login).password(password).budget(budget).build();
            budget.setFamily(family);
            familyService.save(family);
            resp.sendRedirect("http://localhost:8080/BudgetProject_war_exploded/start");

        }


    }
}
