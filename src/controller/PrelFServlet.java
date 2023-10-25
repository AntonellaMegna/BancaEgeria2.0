package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ContoCorrente;
import model.Movimenti;

/**
 * Servlet implementation class PrelFServlet
 */
@WebServlet("/PrelFServlet")
public class PrelFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrelFServlet() {
        super();
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
		// TODO Auto-generated method stub
		 HttpSession session = request.getSession();
		 
		   ContoCorrente conto = service.Dao.selectConto((String)session.getAttribute("nconto"));
	  
	       Movimenti mov= new Movimenti("Prelievo",(new BigDecimal(request.getParameter("amount"))), LocalDate.now(),LocalTime.now(),conto);
	       conto.setAmount(conto.getAmount().subtract(new BigDecimal(request.getParameter("amount"))));
	      if(service.Dao.AggiornaMov(mov, conto)== true){
		     
	    	  response.sendRedirect("prelievo.jsp");
	       }else{
	    	 
	    	 request.getSession().setAttribute("msg", "Prelievo non riuscito");
			 response.sendRedirect("errore.jsp");	  
	      }
	  
		
	}
 

}
