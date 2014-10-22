<%-- 
    Document   : ontologyTest
    Created on : 16/10/2014, 17:45:29
    Author     : Guilherme Martins
--%>

<%@page import="br.ufjf.mapping.files.FileOntology"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Collaborative Mapping</title>
    </head>
    <body>
        <h1>Collaborative Mapping - Ontology</h1>
        
        <%
            FileOntology f = new FileOntology();
        %>
        
        <%
            out.println(f.teste());
            out.println(f.getSubClasses("IG_format"));
            //out.println(f.teste());
        %>
        
        
        <p><a href="index.jsp">Collaborative Mapping - Homepage</a></p>
    </body>
</html>
