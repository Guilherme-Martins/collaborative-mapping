<%-- 
    Document   : statisticsValidity
    Created on : 13/12/2014, 17:44:10
    Author     : Guilherme Martins
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="br.ufjf.mapping.memory.FileDB"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Collaborative Mapping</title>
    </head>
    <body>
        <div align=center>
            <h1>Collaborative Mapping - Statistics</h1>
            <BR>
            
            <%
                FileDB fdb = new FileDB();
            %>
            
            <%
                String fileMappingName;
                int fileMappingID;
                boolean mapExist = false;
                
                //Recupera os dados do formulário. 
                if(request.getParameter("fileMappingName") != null && request.getParameter("fileMappingName") != ""){
                    fileMappingName = request.getParameter("fileMappingName");
                } else {
                    fileMappingName = "";
                }            
                if(request.getParameter("fileMappingID") != null && request.getParameter("fileMappingID") != ""){
                    fileMappingID = Integer.parseInt(request.getParameter("fileMappingID"));
                } else {
                    fileMappingID = -1;
                }
                
                //Verifica os dados do formulário.
                if(fileMappingName == "" && fileMappingID != -1){
                    fileMappingName = fdb.getReadDB().nameMappingFile(fileMappingID);
                    if(fileMappingName != null){
                        mapExist = true;
                    }
                } else {
                    if(fileMappingName != "" && fileMappingID == -1){
                        fileMappingID = fdb.getReadDB().idMappingFile(fileMappingName);
                        if(fileMappingID != -1){
                            mapExist = true;
                        }
                    } 
                }
            %>

            <%
                if(mapExist){
                    //Cabeçalho
                    out.println("<h2>Name Mapping File: " + fileMappingName + "</h2><h3>ID: " + fileMappingID + "</h3><BR>");
                    
                    //Usuários que realizaram o mapeamento.
                    ArrayList<Integer> users = fdb.getReadDB().mappingByUser(fileMappingID);
                    
            %> 
            
            <table border="1" align=center cellspacing=0 cellpadding=2 bordercolor="000000">
            
                <tr>
                    <th>User Name</th>
                    <th>Total Pairs</th>
                    <th>Positive Validation</th>
                    <th>Negative Validation</th>
                    <th>Suggesting Method</th>
                </tr>                
            <%       
                    //Usuário : Total : Positivos : Negativos : Método
                    double total, positive, negative;
                    total = positive = negative = 0;
                    
                    String method = "";
                    
                    DecimalFormat df = new DecimalFormat("0.00");
                    
                    for(int user: users){

                        method = fdb.getReadDB().getMethodValidation(fileMappingID, user);
                        total = fdb.getReadDB().getQuantityByUser(fileMappingID, user, method);
                        positive = fdb.getReadDB().getPositiveQuantityByUser(fileMappingID, user);
                        negative = fdb.getReadDB().getNegativeQuantityByUser(fileMappingID, user);
                        
                        out.println("<tr><td align=center>" + fdb.getReadDB().getNameUser(user) + "</td>" 
                                + "<td align=center>" + (int) total + "</td>"
                                + "<td align=center>" + (int) positive + " (" + df.format(positive*100/total) + "%)" + "</td>"
                                + "<td align=center>" + (int) negative + " (" + df.format(negative*100/total) + "%)" + "</td>"
                                + "<td align=center>" + method + "</td></tr>");
                    }
                } else {
                    out.println("<b>Mapping file doesn't exist!</b>");
                }
            %>
            
            </table>
            
            <BR><BR>
            <p><a href="statisticsIndex.jsp">Collaborative Mapping - Statistics</a></p>
            <p><a href="index2.jsp">Collaborative Mapping - Homepage</a></p>
        </div>
    </body>
