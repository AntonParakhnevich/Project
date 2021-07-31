package com.example.BudgetProject;

import Project.Service.YearService;

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
@WebServlet("/deleteMonth")
public class DeleteMonthServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        YearService yearService = new YearService();
        long id = Long.parseLong(req.getParameter("idMonth"));
        req.setAttribute("idMonth", req.getParameter("idMonth"));
        yearService.deleteMonth(id);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/year");
        requestDispatcher.forward(req, resp);


    }
}
