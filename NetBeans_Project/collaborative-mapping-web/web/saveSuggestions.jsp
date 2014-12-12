<%-- 
    Document   : saveSuggestions
    Created on : 12/11/2014, 16:33:38
    Author     : Guilherme Martins
--%>

<%@page import="br.ufjf.mapping.suggestion.SuggestionPair"%>
<%@page import="br.ufjf.mapping.map.FileMapping"%>
<%@page import="br.ufjf.mapping.memory.FileDB"%>
<%@page import="br.ufjf.mapping.map.MappingPairSuggestion"%>
<%@page import="br.ufjf.mapping.map.MappingListPairSuggestion"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Collaborative Mapping - Suggestion Validity</title>
    </head>
    <body>
        <div align=center>
        <h1 align=center>Collaborative Mapping - Suggestions for Syntactic Validation</h1>
        
        <%
            MappingListPairSuggestion mlps = new MappingListPairSuggestion();
            MappingListPairSuggestion mlps_modified = new MappingListPairSuggestion();
            FileMapping fm = new FileMapping();
            SuggestionPair sp = new SuggestionPair();
            FileDB fdb = new FileDB();
            
            int idUser, idMappingFile;
            String nameMappingFile, nameFile1, nameFile2;
            
            idUser = (int) session.getAttribute("idUser");
            idMappingFile = (int) session.getAttribute("idMappingFile");
            nameMappingFile = (String) session.getAttribute("nameMappingFile");
            nameFile1 = (String) session.getAttribute("nameFile1");
            nameFile2 = (String) session.getAttribute("nameFile2");
        %>
        
        <%
            //Recupera os pares sugeridos armazenados no Banco de Dados.
            mlps.setMappingListPairSuggestion(fdb.getReadDB().pairSuggestion(idMappingFile, idUser));
            
            //Recupera o último "idPair" do Banco de Dados. (Necessário se novos pares forem incluídos)
            mlps.setIdPair(fdb.getReadDB().lastIdPair());
            
            //
            for(MappingPairSuggestion pair : mlps.getMappingListPairSuggestion()){
                MappingPairSuggestion p = new MappingPairSuggestion();
                
                p.setIdPair(pair.getIdPair());
                p.setFirst(pair.getFirst());
                p.setSecond(pair.getSecond());                
                p.setValidity(Integer.parseInt(request.getParameter("validity_"+pair.getIdPair())));
                p.setComment(request.getParameter("comment_"+pair.getIdPair()));
                
                mlps_modified.getMappingListPairSuggestion().add(p);
            }
        %>
        
        <%
            //Atualiza o Banco de Dados de agordo com os valores preenchido no formulário.
            fdb.getStoryDB().updatePairs(idUser, idMappingFile, mlps_modified);
            
            out.println("<BR>IdUser: "+ idUser + " IdMapping: " + idMappingFile + "  " + "<BR>");
            
            //Cria o Arquivo de Mapeamento com os pares válidos.
            out.println("<BR>STATUS<BR>" + fm.getMappingCreate().createFileMapping(nameMappingFile, nameFile1, nameFile2, sp.validitySugestins(mlps_modified))+"<BR><BR>");
        %>
        
        <table border="0" align=center>
            
            <tr>
                <th colspan="5" align=center>Mapping File: <%out.println(nameMappingFile);%></td>
            </tr>
            <tr>
                <th>ID Pair</th>
                <th>Element Document 1</th>
                <th>Element Document 2</th>
                <th>Validity?</th>
                <th>Comment</th>
            </tr>

            <%
                String listPair = "";
                for(MappingPairSuggestion mps: mlps_modified.getMappingListPairSuggestion()){
                    listPair = "<tr><td align=center>" + mps.getIdPair() + "</td>" +
                                "<td align=center>" + mps.getFirst() + "</td>" + 
                                "<td align=center>" + mps.getSecond() + "</td>";
                    
                    if(mps.getValidity() == 1)
                        listPair = listPair + "<td align=center>Yes</td>";
                    if(mps.getValidity() == 0)
                        listPair = listPair + "<td align=center>No</td>";
                    
                    listPair = listPair + "<td align=center>" + mps.getComment() + "</td></tr>";
       
                    out.println(listPair);
                }
            %>
                
        </table>
        
        <% 
            //out.println("Começou<BR><BR>");
            //MappingListPairSuggestion m = new MappingListPairSuggestion();
            
            /* FUNCIONA 
            out.println("CO: "+ request.getParameter("comment_3")+"<BR>");
            out.println("CO: "+ request.getParameter("comment_4")+"<BR>");
            out.println("CO: "+ request.getParameter("comment_5")+"<BR>");
            out.println("CO: "+ request.getParameter("comment_6")+"<BR>");
            */
            
            /* NÃO FUNCIONA
            for (MappingPairSuggestion pair : m.getMappingListPairSuggestion()) {
                out.println("<BR>Entrou<BR>");
                out.println(request.getParameter("comment_5"));
                out.println(request.getParameter("comment_" + pair.getIdPair()));
            }
            */
            
            //out.println("<BR>Terminou<BR>");  
        %>  
        
        <p><a href="index2.jsp">Collaborative Mapping - Homepage</a></p><BR>
        <p><a href="index.jsp">EXIT</a></p>
        </div>
    </body>
</html>
