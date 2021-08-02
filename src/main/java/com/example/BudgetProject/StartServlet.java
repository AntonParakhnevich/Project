package com.example.BudgetProject;

import Project.Entity.Family;
import Project.Service.FamilyService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by .
 */
@WebServlet("/start")
public class StartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/start.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FamilyService familyService = new FamilyService();
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        System.out.println(login);
        System.out.println(password);

        if(familyService.findLoginAndPassword(login,password)){
            System.out.println("true"); // если ты хочешь логировать какие-то действия, то ты потом глядя на логи программы должен четко понимать как и что отработало. Этот лог не говорит ни о чем. Можно написать что-то типа Login and password were applied
            Family family = familyService.getByLoginAndPassword(login, password);
            HttpSession session = req.getSession();
            session.setAttribute("family",family);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/hello-servlet");
            requestDispatcher.forward(req,resp);

        }else {
            System.out.println("false");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/start.jsp");
            requestDispatcher.forward(req,resp);
        }

    }
}
