package eu.karols.servlets;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import eu.karols.dao.ArticleDAO;

public class ArticleControllerServlet extends HttpServlet {
     
    private static final long serialVersionUID = 1L;
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
        String articleTitle = request.getParameter("articleTitle");
        String articleText = request.getParameter("ArticleText");
 
        HttpSession session = request.getSession(true);
        try {
            ArticleDAO articleDAO = new ArticleDAO();
            articleDAO.addArticleDetails(articleTitle, articleText);
            response.sendRedirect("Success");
        } catch (Exception e) {
 
            e.printStackTrace();
        }
 
    }
}