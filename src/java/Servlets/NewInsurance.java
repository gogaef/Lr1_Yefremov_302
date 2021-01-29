/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Interfaces.IUser;
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
@WebServlet(name = "ProcessCreatingIsurance", urlPatterns = {"/ProcessCreatingIsurance"})
public class ProcessCreatingIsurance extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setCharacterEncoding("Cp1251");
        
        try {
            IUser user = (IUser)request.getSession().getAttribute("user");
            ManagerQuery q = (ManagerQuery)request.getSession().getAttribute("ManagerQuery");
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            ResultSet agent =  q.selectWhereOne("Agent","id",request.getParameter("agentId") );
            Integer summ = new Integer(request.getParameter("price"));
            Integer idClient = new Integer(user.getValues().get("idContract"));
            Integer idAgent = agent.getInt(1);
            Float agentProcent = new Float(agent.getFloat(5)*summ );

            if(q.insertAgreement(idClient,idAgent,summ,agentProcent )==1)
           {
            
                out.print("<h3>Заявка на новую страховку принята</h3>");
                out.print("<a style = \"background:lime; color:white; text-decoration:none; padding: 1rem 1.5rem;\" href=\"WelcomeUser.jsp\"> Меню</a>");
           }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProcessCreatingIsurance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

}
