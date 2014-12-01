<%-- 
    Document   : databaseTest
    Created on : 16/10/2014, 17:46:11
    Author     : Guilherme Martins
--%>

<%@page import="br.ufjf.mapping.map.MappingPairSuggestion"%>
<%@page import="br.ufjf.mapping.memory.FileDB"%>
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
            FileDB fdb = new FileDB();
        %>
        
        <%
            out.println(fdb.getConnectDB().teste()+"<BR><BR>");
        %>
          
        <%
            out.println(fdb.getReadDB().query()+"<BR><BR>");
        %>
        
        <%
            out.println("Ultimo IdPair: "+fdb.getReadDB().lastIdPair()+"<BR><BR>");
            out.println("IdMappingFile: "+fdb.getReadDB().idMappingFile("TestFeature", "TestOntology")+"<BR><BR>");
            out.println("IdDocument: "+fdb.getReadDB().idDocument("TestOntology")+"<BR><BR>");
            out.println("IdUser: "+fdb.getReadDB().authenticationUser("guilherme.martins", "guilherme")+"<BR><BR>");
            out.println("IdUser: "+fdb.getReadDB().authenticationUser("guilherme.martins", "gui")+"<BR><BR>");
            out.println("Users: "+fdb.getReadDB().mappingByUser(1)+"<BR><BR>");
            
            /*
            fdb.getReadDB().pairSuggestion(1);
            String listPair = "";
            for(MappingPairSuggestion mps: fdb.getReadDB().pairSuggestion(1)){
            listPair = listPair + mps.getIdPair() + " = " +
                    mps.getFirst() + " :: " + mps.getSecond() + " :: " + 
                    mps.getValidaty() + " :: " + mps.getComment() +
                    "<BR>";
            }          
            out.println("Pares Lidos:<BR>" + listPair);
            */
        %>
        
        <%
            //out.println(fdb.getStoryDB().save("edu")+"<BR><BR>");
            //out.println(fdb.getStoryDB().saveDocument("DocTest", "Test")+"<BR><BR>");
        %>
        
        <p><a href="index.jsp">Collaborative Mapping - Homepage</a></p>
    </body>
</html>
