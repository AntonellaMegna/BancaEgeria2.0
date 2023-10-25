package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import model.Correntista;
 

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 Correntista cor= service.Dao.selectCor(request.getParameter("email"));
		 HttpSession session = request.getSession();
		
		 if(cor==null){
			 request.getSession().setAttribute("msg", "Email inesistente");
			 response.sendRedirect("errore.jsp");
		 }
		 else{
			  if(cor.getPwd().equals(request.getParameter("pwd"))== false){
				  request.getSession().setAttribute("msg", "pwd errata");
					 response.sendRedirect("errore.jsp");
			  }else{
				  String c= cor.getNumerocc().getNumeroconto();
				  session.setAttribute("nconto", cor.getNumerocc().getNumeroconto());;
				  request.getSession().setAttribute("x", cor);
				  response.sendRedirect("scelta.jsp");
				   
				  
			  }
		 }
		
		 

			
		 
	}

}
