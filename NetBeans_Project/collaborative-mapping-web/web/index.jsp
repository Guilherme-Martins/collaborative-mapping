<%-- 
    Document   : index
    Created on : 14/10/2014, 10:25:24
    Author     : Guilherme Martins
--%>

<%@page import="br.ufjf.mapping.feature.FeatureCreate"%>
<%@page import="br.ufjf.mapping.feature.FeatureRead"%>
<%@page import="br.ufjf.mapping.map.MappingCreate"%>
<%@page import="br.ufjf.mapping.files.FileOntology"%>
<%@page import="br.ufjf.mapping.memory.ConnectDB"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Collaborative Mapping</title>
    </head>
    <body>
        <h1>Collaborative Mapping - Homepage</h1>
        <BR>
        
        <p><a href="databaseTest.jsp">Collaborative Mapping - Database</a></p>
        <p><a href="mappingTest.jsp">Collaborative Mapping - Mapping</a></p>
        <p><a href="featureTest.jsp">Collaborative Mapping - Features Model</a></p>
        <p><a href="ontologyTest.jsp">Collaborative Mapping - Ontology</a></p>
    </body>
</html>
