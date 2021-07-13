package com.example.BudgetProject;

import Project.DAO.ImplDaoYear;
import Project.Entity.Family;
import Project.Entity.Year;
import Project.Service.YearService;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try {
            doPost(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        YearService yearService = new YearService();

        HttpSession session = req.getSession();
        Family family = (Family) session.getAttribute("family");
        req.setAttribute("family", family);

        List<Year> allYears = yearService.getAllYears(family.getLogin());
        req.setAttribute("allYears", allYears);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
        requestDispatcher.forward(req, resp);
    }
}