<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    String todayDate = sdf.format(new Date());
%>

<!DOCTYPE html>
<html>
<body>
<h1> Benvenuto Utente Curioso, questa e' la mia prima JSP. </h1>
<p> Oggi e' il giorno <%= todayDate %> </p>

<p>Autore: <a href="author.jsp">link</a> </p>


</body>
</html>
