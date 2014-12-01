<%-- 
    Document   : suggestionTest
    Created on : 22/10/2014, 18:34:44
    Author     : Guilherme Martins
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="br.ufjf.mapping.ontology.FileOntology"%>
<%@page import="br.ufjf.mapping.feature.FileFeature"%>
<%@page import="br.ufjf.mapping.suggestion.Suggestion"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Collaborative Mapping</title>
    </head>
    <body>
        <h1>Collaborative Mapping - Suggestion</h1>
        
        <%
            Suggestion s = new Suggestion();
            FileFeature ff = new FileFeature();
            FileOntology fo = new FileOntology();
        %>
        
        <%
            //out.println(s.getSuggestionPairText().equalString("A", "B")+"<BR><BR>");
            //out.println(s.getSuggestionPairText().equalString("A", "A")+"<BR><BR>");
            //out.println(s.getSuggestionPairText().equalString("A", "a")+"<BR><BR>");
            
            //out.println(s.getSuggestionPairText().containString("AAAABAA", "B")+"<BR><BR>");
            //out.println(s.getSuggestionPairText().containString("AAA", "A")+"<BR><BR>");
            //out.println(s.getSuggestionPairText().containString("AAa", "a")+"<BR><BR>");
            //out.println(s.getSuggestionPairText().containString("AA", "a")+"<BR><BR>");
        %>
        
        <%
            String URI = "file:///E:/RepositoryGIT/collaborative-mapping/NetBeans_Project/files/ontologies/SequenceAligningOntologyv1b.owl";
            fo.getOntologyRead().setONTOLOGY_URI(URI);
            fo.getOntologyRead().setBASE_URI();         
            
            ArrayList<String> list_1 = ff.getFeatureRead().getElementNames(ff.getFeatureRead().readFeatureFile("SequenceAligningFeatureModelv1b"));
            ArrayList<String> list_2 = fo.getOntologyRead().getClasses();
            
            int lastPair = s.getFileDB().getReadDB().lastIdPair();
            
            out.println(s.getSuggestionPairText().listSuggestionPair(list_1, list_2, lastPair).printMappingListPairSuggestion()+"<BR><BR>");
        %>
        
        <p><a href="index.jsp">Collaborative Mapping - Homepage</a></p>
    </body>
</html>
