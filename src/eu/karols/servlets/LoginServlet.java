package eu.karols.servlets;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
  
import eu.karols.dao.LoginDao;  
  
public class LoginServlet extends HttpServlet{  
  
    private static final long serialVersionUID = 1L;  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {    
  
        response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
          
        String n=request.getParameter("username");    
        String p=request.getParameter("userpass");   
          
        HttpSession session = request.getSession(false);  
        if(session!=null)  
        session.setAttribute("name", n);  
  
        if(LoginDao.validate(n, p)){    
            RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");    
            rd.forward(request,response);    
        }    
        else{    
        	out.println("<div class=\"login-alert-background\"><div class=\"login-alert col-sm-8 col-sm-offset-2 alert alert-warning alert-danger\" role=\"alert\"><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Warning!</strong> Better check your username and password.</div></div>");
        	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");    
            rd.include(request,response);    
        }    
  
        out.close();    
    }    
}   
