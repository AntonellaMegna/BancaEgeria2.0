<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="model.Correntista" %>   
<%@ page import ="model.Movimenti" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deposito</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" integrity="sha384-y3tfxAZXuh4HwSYylfB+J125MxIs6mR5FOHamPBG064zB+AFeWH94NdvaCBm8qnd" crossorigin="anonymous">
 
</head>
 <body >
 <%
   Correntista d=(Correntista)session.getAttribute("x");
  
%>

      <header class="masthead ">
        <div class="inner">
          <h3 class="masthead-brand">Sign. <%=d.getCognome() %></h3>
            <br>
        </div>
      </header>


<form action="DepServlet" method="post">
    <div style="text-align: center" class="dropdown position-fixed bottom-0 end-0 mb-3 me-3 bd-mode-toggle">
     <div >  
     <h1 >Deposita</h1>
        <input type="number"  name ="amount" required="true"  ></div>
       
        <p class="lead">
        <br>
           <input type="submit" value ="Carica" class="w-100 btn btn-lg btn-primary" >
         
           <a href=scelta.jsp class="w-100 btn btn-lg btn-primary " tabindex="-1" role="button" 
           aria-disabled="true"><b>Annulla/Esci</b></a>
        </p>
      
      </div>
</form>
</body>
</html>