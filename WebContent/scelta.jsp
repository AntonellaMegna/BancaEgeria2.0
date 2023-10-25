<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import ="model.Correntista" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" integrity="sha384-y3tfxAZXuh4HwSYylfB+J125MxIs6mR5FOHamPBG064zB+AFeWH94NdvaCBm8qnd" crossorigin="anonymous">
<title>Scelta Operazione</title>

</head>
<body>
<% Correntista d=(Correntista)session.getAttribute("x"); %>  

  <h1 style="font-style: italic; font-family: 'Courier New', Courier, monospace;" >Benvenuto Sign. <%=d.getNome()+" "+d.getCognome() %> </h1>
 
        <div  style="margin-top: 100px;">
             
        <a style=" font-style: italic; font-size: larger;font-family: 'Courier New', Courier, monospace;" href="movimenti.jsp" class="btn btn-primary btn-lg btn-block " tabindex="-1" role="button" 
        aria-disabled="true"><b>Lista Movimenti</b></a>
        <a style=" font-style: italic; font-size: larger;font-family: 'Courier New', Courier, monospace;" href="deposito.jsp" class="btn btn-success btn-lg btn-block " tabindex="-1" role="button" 
        aria-disabled="true"><b>Deposito</b></a>
        <a style=" font-style: italic; font-size: larger;font-family: 'Courier New', Courier, monospace;" href="prelievo.jsp" class="btn btn-warning btn-lg btn-block " tabindex="-1" role="button" 
        aria-disabled="true"><b>Prelievo</b></a>
        <a style=" font-style: italic; font-size: larger;font-family: 'Courier New', Courier, monospace;" href="prelFast.jsp" class="btn btn-info btn-lg btn-block" tabindex="-1" role="button" 
        aria-disabled="true"><b>Prelievo Fast</b></a>
        <a style=" font-style: italic; font-size: larger;font-family: 'Courier New', Courier, monospace;" href=login.html class="btn btn-alert btn-lg btn-block" tabindex="-1" role="button" 
        aria-disabled="true"><b>Esci</b></a>
      </div>
      <input type="hidden" value=<%=session.getAttribute("nconto") %>>
</body>
</html>