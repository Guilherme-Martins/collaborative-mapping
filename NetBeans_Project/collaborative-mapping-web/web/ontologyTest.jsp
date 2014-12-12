<%-- 
    Document   : ontologyTest
    Created on : 16/10/2014, 17:45:29
    Author     : Guilherme Martins
--%>

<%@page import="br.ufjf.mapping.ontology.FileOntology"%>
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
            FileOntology fo = new FileOntology();
        %>

        <%
            //String URI = "https://github.com/Guilherme-Martins/collaborative-mapping/blob/master/NetBeans_Project/files/ontologies/SequenceAligningOntologyv1b.owl";
            String URI = "file:///E:/RepositoryGIT/collaborative-mapping/NetBeans_Project/files/ontologies/SequenceAligningOntologyv1b.owl";
            fo.getOntologyRead().setONTOLOGY_URI(URI);
            fo.getOntologyRead().setBASE_URI();
        %>
        
        <%
            //out.println(fo.getOntologyRead().teste()+"<BR><BR>");
        %>
            
        <%
            out.println(fo.getOntologyRead().getAllSubClasses("application_type").toString()+"<BR><BR>");
            out.println(fo.getOntologyRead().getAllSubClasses("bioinformatics_concept").toString()+"<BR><BR>");
            out.println(fo.getOntologyRead().getAllSubClasses("bioinformatics_algorithm").toString()+"<BR><BR>");
            //out.println(fo.getOntologyRead().getSubClasses("bioinformatics_concept")+"<BR><BR>");
            out.println(fo.getOntologyRead().getSubClasses()+"<BR><BR>");
            
            //out.println(fo.getOntologyRead().getIndividuals("CAP3").toString()+"<BR><BR>");
            
            /* NÃO FOI FEITO*/
            //out.println(fo.getOntologyRead().getDatasIndividuals("CAP3")+"<BR><BR>");
            
            //out.println(fo.getOntologyRead().getClasses().toString()+"<BR><BR>");
            
            //out.println(fo.getOntologyRead().getONTOLOGY_URI()+"<BR><BR>");
            //out.println(fo.getOntologyRead().getBASE_URI()+"<BR><BR>");
            //out.println(fo.getOntologyRead().getBaseURI()+"<BR><BR>");
        %>
        
        
        <p><a href="index2.jsp">Collaborative Mapping - Homepage</a></p> <BR>
        <p><a href="index.jsp">EXIT</a></p>
    </body>
</html>
