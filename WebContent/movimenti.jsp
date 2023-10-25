<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import ="model.Correntista" %>   
     <%@ page import ="model.Movimenti" %>  
      <%@ page import ="service.Dao" %>  
     <%@ page import="java.util.ArrayList" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" integrity="sha384-y3tfxAZXuh4HwSYylfB+J125MxIs6mR5FOHamPBG064zB+AFeWH94NdvaCBm8qnd" crossorigin="anonymous">
<title>Lista Movimenti</title>
</head>
<body>
 <%
   Correntista d=(Correntista)session.getAttribute("nconto");
   ArrayList<Movimenti> movimenti= (ArrayList)Dao.selectMov(d.getNumerocc().getNumeroconto());
%>


  <h1 style="font-style: italic; font-family: 'Courier New', Courier, monospace;" >righe Tot.<%=movimenti.size() %>  </h1>

 
 
    
  <table class="table">
  <thead>
    <tr>
      <th>Data</th>
      <th>Tipo Op </th>
      <th>Amaunt</th>
    </tr>
  </thead>
 <tbody>
		<%for(Movimenti m:movimenti){ %>
		<tr>
			 <th><%=m.getDatam() %></th> 
			 <th><%=m.getTipo() %></th> 
			 <th><%=m.getAmount()%></th>
		</tr>
          <%} %>
		</tbody>
</table>
 
 
 

</body>
 
</html>