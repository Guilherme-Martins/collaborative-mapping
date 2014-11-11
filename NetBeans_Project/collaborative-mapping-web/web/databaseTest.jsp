<%-- 
    Document   : databaseTest
    Created on : 16/10/2014, 17:46:11
    Author     : Guilherme Martins
--%>

<%@page import="br.ufjf.mapping.memory.StoreDB"%>
<%@page import="br.ufjf.mapping.memory.ReadDB"%>
<%@page import="br.ufjf.mapping.memory.ConnectDB"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Collaborative Mapping</title>
    </head>
    <body>
        <h1>Collaborative Mapping - Database</h1>
        
        <%
            ConnectDB cdb = new ConnectDB();
            ReadDB rdb = new ReadDB();
            StoreDB sdb = new StoreDB();
        %>
        
        <%
            out.println(cdb.teste()+"<BR><BR>");
        %>
          
        <%
            out.println(rdb.query()+"<BR><BR>");
        %>
        
        <%
            //out.println(sdb.save("edu")+"<BR><BR>");
        %>
        
        <p><a href="index.jsp">Collaborative Mapping - Homepage</a></p>
    </body>
</html>
