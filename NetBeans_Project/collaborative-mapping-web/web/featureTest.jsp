<%-- 
    Document   : featureTest
    Created on : 16/10/2014, 17:17:30
    Author     : Guilherme Martins
--%>

<%@page import="br.ufjf.mapping.feature.FileFeature"%>
<%@page import="br.ufjf.mapping.feature.FeatureCreate"%>
<%@page import="br.ufjf.mapping.feature.FeatureRead"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Collaborative Mapping</title>
    </head>
    <body>
        <h1>Collaborative Mapping - Features Model</h1>
        
        <%
            FeatureCreate fc = new FeatureCreate();
            FeatureRead fr = new FeatureRead();
            FileFeature ff = new FileFeature();
        %>
        
        <%       
            //out.println(fc.createFileFeature("testCreate")+"<BR><BR>");
        %>
        
        <%
            //out.println(fr.extractDatas(fr.readFeatureFile("testRead"))+"<BR><BR>");
            //out.println(fr.getElementNames(fr.readFeatureFile("testRead")).toString()+"<BR><BR>");
            
            //out.println(fr.extractDatas(fr.readFeatureFile("SequenceAligningFeatureModelv1b"))+"<BR><BR>");
            //out.println(fr.getElementNames(fr.readFeatureFile("SequenceAligningFeatureModelv1b")).toString()+"<BR><BR>");
            
            //out.println(fr.getNameFeaturesModel(fr.readFeatureFile("testRead")).toString()+"<BR><BR>");
            
            //out.println(fr.getSpecificElementName(fr.readFeatureFile("testRead"), 2).toString()+"<BR><BR>");
            //out.println(fr.getSpecificElementName(fr.readFeatureFile("testRead"), 0).toString()+"<BR><BR>");
            
            //out.println(fr.getChildsElements(fr.readFeatureFile("testRead"), 2).toString()+"<BR><BR>");
            //out.println(fr.getOptionalElement(fr.readFeatureFile("testRead"), 2)+"<BR><BR>");        
        %>
        
        <%
            out.println(ff.getFeatureCreat().createFileFeature("testCreate")+"<BR><BR>");
            out.println(ff.getFeatureRead().extractDatas(fr.readFeatureFile("testRead"))+"<BR><BR>");
        %>
        
        <p><a href="index.jsp">Collaborative Mapping - Homepage</a></p>
    </body>
</html>
