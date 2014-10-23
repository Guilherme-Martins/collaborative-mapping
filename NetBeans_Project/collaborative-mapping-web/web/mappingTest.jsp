<%-- 
    Document   : mappingTest
    Created on : 16/10/2014, 17:45:49
    Author     : Guilherme Martins
--%>

<%@page import="br.ufjf.mapping.map.MappingListPair"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.ufjf.mapping.map.MappingPair"%>
<%@page import="br.ufjf.mapping.map.FileMapping"%>
<%@page import="br.ufjf.mapping.map.MappingRead"%>
<%@page import="br.ufjf.mapping.map.MappingCreate"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Collaborative Mapping</title>
    </head>
    <body>
        <h1>Collaborative Mapping - Mapping</h1>
        
        <%
            MappingCreate mc = new MappingCreate();
            MappingRead mr = new MappingRead();
            MappingPair mp = new MappingPair();
            FileMapping fm = new FileMapping();
            
            MappingListPair mlp = new MappingListPair();
        %>
        
        <%
            //out.println(mc.createFileMapping("XmlMappingFile")+"<BR><BR>");
            //out.println(mr.extractDatas(mr.readMappingFile("XmlMappingFile"))+"<BR><BR>");
            
            //out.println(mr.extractDatas(mr.readMappingFile("SequenceAligningMappingv1c"))+"<BR><BR>");
        %>
        
        <%
            //out.println(fm.getMappingRead().extractDatas(fm.getMappingRead().readMappingFile("SequenceAligningMappingv1c"))+"<BR><BR>");
        %>
        
        <%
            out.println(fm.getMappingCreate().createFileMapping("XmlMappingFile_v02", mlp)+"<BR><BR>");
        %>
        
        <p><a href="index.jsp">Collaborative Mapping - Homepage</a></p>
    </body>
</html>
