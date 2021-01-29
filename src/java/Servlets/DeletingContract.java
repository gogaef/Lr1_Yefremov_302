/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import classes.ManagerQuery;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "ProcessDeletingAgreement", urlPatterns = {"/ProcessDeletingAgreement"})
public class ProcessDeletingAgreement extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("Cp1251");
        response.setContentType("text/html");
        PrintWriter outer = response.getWriter();
        ManagerQuery q = (ManagerQuery)request.getSession().getAttribute("ManagerQuery");
        int id = new Integer(request.getParameter("idAgreement"));
        if(q.DeleteAgreement(id)==1)
        {
            outer.write("<h3>Ваша страховка успешно аннулированна</h3>");
            outer.write("<a style = \"background:blueviolet; color:white; text-decoration:none; padding: 1rem 1.5rem;\" href=\"WelcomeUser.jsp\"> Назад </a>");
        }
        
    }

}
