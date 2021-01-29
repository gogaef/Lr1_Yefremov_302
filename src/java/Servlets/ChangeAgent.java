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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "ProcessChangingAgent", urlPatterns = {"/ProcessChangingAgent"})
public class ProcessChangingAgent extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setCharacterEncoding("Cp1251");
        PrintWriter outer = response.getWriter();
        response.setContentType("text/html");
        
        try {
            ManagerQuery q = (ManagerQuery)request.getSession().getAttribute("ManagerQuery");
            ResultSet agreement = q.selectWhereOne("Agreement", "id", request.getParameter("id"));
            
            Integer summa = new Integer (agreement.getInt(4));
            
            ResultSet newAgent = q.selectWhereOne("Agent", "id", request.getParameter("agentId"));

            Float procentNewAgent = new Float(newAgent.getFloat(5)*summa );
            
            if(q.updateAgent(newAgent.getInt(1), procentNewAgent, agreement.getInt(1))==1)
            {
                outer.write("<h3>Вы успешно сменили агента</h3>");
                outer.write("<a style = \"background:blueviolet; color:white; text-decoration:none; padding: 1rem 1.5rem;\" href=\"WelcomeUser.jsp\"> Назад </a>");
            }
           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProcessChangingAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    

}
