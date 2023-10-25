package service;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import model.ContoCorrente;
import model.Correntista;
import model.HibernateUtil;
import model.Movimenti;


public class Dao {
	
	
public static Correntista selectCor(String email){
		 
	Correntista cor;
		Session session =HibernateUtil.openSession();
		  cor=(Correntista)session.createQuery("FROM Correntista where email ='"+ 
				email+"'" ).uniqueResult();
		
		 		
		session.close();
		return cor;
	}
public static ContoCorrente selectConto(){
		
		Session session =HibernateUtil.openSession();
		ContoCorrente nconto=(ContoCorrente)session.createQuery("FROM ContoCorrente where busy = false").list().get(0);
		session.close();
		return nconto;
	}
	
	public static boolean insertCor(Correntista c,ContoCorrente conto )
	{
	  boolean ok= true;
		
		Session session =HibernateUtil.openSession();
		Transaction tx = null;

		try {
			
		 
		   tx = session.beginTransaction();
		   
		   session.save(c);
		   conto.setBusy(true);
		   updateConto(conto);
		   
		   tx.commit();
		}

		catch (Exception e) {
			ok= true;
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		} finally {
		   session.close();
		}

		return ok;
		
	}
	
public static boolean updateConto(ContoCorrente conto){
	boolean ok = true;
	Session session = HibernateUtil.openSession();
	Transaction tx = null;

	try {
		tx = session.beginTransaction();
		
		session.update(conto);
		
		tx.commit();
	}

	catch (Exception e) {

		if (tx != null) {
			tx.rollback();
			ok = false;
		}
		e.printStackTrace();
	} finally {
		session.close();

	}
	return ok;
	}


public static ContoCorrente selectConto(String  nconto){
	ContoCorrente ok=null;
	Session session =HibernateUtil.openSession();
	   
		ok=(ContoCorrente)session.createQuery("FROM ContoCorrente where numeroconto = '"+ 
				nconto+"'" ).uniqueResult(); 
	 	
		 session.close();
	 
      return ok;
	}
public static ContoCorrente selectConto(String txt1, String txt2){
	ContoCorrente ok=null;
	Session session =HibernateUtil.openSession();
	 
 try {
	
	  
		ok=(ContoCorrente)session.createQuery("FROM ContoCorrente where numeroconto = '"+ 
		txt1+"'"+ "and pin= '" + txt2 + "'" ).uniqueResult(); 
		 
	}

	catch (Exception e) {
	  
	   e.printStackTrace(); 
	} finally {
	
		 session.close();
	}
      return ok;
	}
		


public static List<Movimenti> selectMov(String nconto){
	 
	List<Movimenti> mov=new ArrayList<Movimenti>();
	Session session =HibernateUtil.openSession();
	Transaction tx = null;
	
		try {
			
		 
		   tx = session.beginTransaction();
	 		mov= session.createQuery("FROM Movimenti where numerocc = '"+ nconto+"'" ).list();  
	 		 
	}

	catch (Exception e) {
	  
	   e.printStackTrace(); 
	} finally {
	
		 session.close();
	}
      return mov;
	}

public static List<Movimenti> selectMov(Correntista nconto){
	 
	List<Movimenti> mov=new ArrayList<Movimenti>();
	Session session =HibernateUtil.openSession();
	Transaction tx = null;
	
		try {
			
		 
		   tx = session.beginTransaction();
	 		mov= session.createQuery("FROM Movimenti where numerocc = '"+ nconto.getNumerocc().getNumeroconto()+"'" ).list();  
	 		 
	}

	catch (Exception e) {
	  
	   e.printStackTrace(); 
	} finally {
	
		 session.close();
	}
      return mov;
	}

public static boolean AggiornaMov(Movimenti mov, ContoCorrente conto  )
{
	boolean ok= true;
	
	Session session =HibernateUtil.openSession();
	Transaction tx = null;

	try {
		
	 
	   tx = session.beginTransaction();
	   
	   session.save(mov);
	    
	   updateConto(conto);
	   
	   
	   tx.commit();
	}

	catch (Exception e) {
		e.getMessage();
		ok= false;
	   if (tx!=null) tx.rollback();
	   e.printStackTrace(); 
	} finally {
	   session.close();
	}

	return ok;
}

		
} 