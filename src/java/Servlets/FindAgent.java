/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import classes.ManagerQuery;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "ProcessSearchAgent1", urlPatterns = {"/ProcessSearchAgent1"})
public class ProcessSearchAgent1 extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        String column1 = "age";
        String column2 = "expirience";
        String column3 = "procent";
        
        String value1 = "BETWEEN " + request.getParameter("ageFrom") + " AND " + request.getParameter("ageTo");
        String value2 = "BETWEEN " + request.getParameter("raFrom") + " AND " + request.getParameter("raTo");
        String value3 = "BETWEEN " + request.getParameter("procFrom") + " AND " + request.getParameter("procTo");
        
        ManagerQuery q = (ManagerQuery)request.getSession().getAttribute("ManagerQuery");
        ResultSet result = q.selectWhereThree("Agent", column1, value1, column2, value2, column3, value3);
        if(result==null)
        {
            out.print("<h3>Агентов не найдено</h3>");
        }
        request.setAttribute("resultAgent", result);
        
        getServletContext().getRequestDispatcher("/ResultAgent.jsp").forward(request, response);
    }

    

}
