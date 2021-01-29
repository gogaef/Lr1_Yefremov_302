
package Servlets;

import Interfaces.IUser;
import annotations.User;
import classes.ManagerQuery;
import com.sun.org.apache.bcel.internal.generic.Select;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jboss.weld.SimpleCDI;


@WebServlet(name = "Autentification", urlPatterns = {"/Autentification"})
public class Autentification extends HttpServlet  {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try {
            ManagerQuery q = new ManagerQuery("jdbc:sqlite://C:/sqlite/mySqLite.db");
            String userPermission = request.getParameter("user");
            ResultSet result = q.select(userPermission);
            PrintWriter out=response.getWriter();
            request.getSession().setAttribute("user", null);
            while(result.next())
            {
                        
                if(result.getString(3).equals(request.getParameter("password")))
                {
                    User u = new User() {
                        @Override
                        public String value() {
                            return userPermission;
                        }
                        
                        @Override
                        public Class<? extends Annotation> annotationType() {
                            return User.class;
                        }
                    };
                    
                    IUser user=SimpleCDI.current().select(IUser.class,u).get();
                    user.Inicialization(result);
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    session.setAttribute("ManagerQuery", q);
                    response.addCookie(new Cookie("permission",userPermission));
                    break;
                }
            }
            
            if(request.getSession().getAttribute("user")==null)
            {
                response.sendRedirect("WrongPassword.jsp");
            }
            else
            {
                response.sendRedirect("WelcomeUser.jsp");
            }
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Autentification.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
