<%-- 
    Document   : suggestionValidaty
    Created on : 12/11/2014, 15:52:26
    Author     : Guilherme Martins
--%>

<%@page import="br.ufjf.mapping.memory.FileDB"%>
<%@page import="br.ufjf.mapping.map.FileMapping"%>
<%@page import="br.ufjf.mapping.suggestion.SuggestionPair"%>
<%@page import="br.ufjf.mapping.map.MappingListPair"%>
<%@page import="br.ufjf.mapping.map.MappingPairSuggestion"%>
<%@page import="br.ufjf.mapping.map.MappingListPairSuggestion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.ufjf.mapping.suggestion.Suggestion"%>
<%@page import="br.ufjf.mapping.feature.FileFeature"%>
<%@page import="br.ufjf.mapping.ontology.FileOntology"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Collaborative Mapping</title>
    </head>
    <body>
        <h1 align=center>Collaborative Mapping - Suggestion Validity</h1>
        
        <form action='saveSuggestions.jsp' method="POST">        
            <%
                Suggestion s = new Suggestion();
                FileFeature ff = new FileFeature();
                FileOntology fo = new FileOntology();
                FileDB fdb = new FileDB();
                FileMapping fm = new FileMapping();

                MappingListPairSuggestion mlps = new MappingListPairSuggestion();
            %>

            <%
                String URI = "file:///E:/RepositoryGIT/collaborative-mapping/NetBeans_Project/files/ontologies/SequenceAligningOntologyv1b.owl";
                fo.getOntologyRead().setONTOLOGY_URI(URI);
                fo.getOntologyRead().setBASE_URI();         

                //Lista de features do "Modelo de Features".
                ArrayList<String> list_1 = ff.getFeatureRead().getElementNames(ff.getFeatureRead().readFeatureFile("SequenceAligningFeatureModelv1b"));
                //Lista de classes da "Ontologia".
                ArrayList<String> list_2 = fo.getOntologyRead().getClasses();
                
                //Nomes dos arquivos, onde "file1" é o nome do Modelo de Features e "file2" é o nome da Ontologia.
                String file1 = "SequenceAligningFeatureModelv1b.xml";
                String typeFile1 = "Feature";
                String file2 = "SequenceAligningOntologyv1b.owl";
                String typeFile2 = "Ontology";
                
                String nameMappingFile = "";
                
                //Recupera o ID do usuário
                int idUser = (int) session.getAttribute("idUser");
            %>

            <%
                //Recupera o ID do "Arquivo de Mapeamento" no Banco de Dados referênte aos arquivos especificados (lidos).
                //Retorna o ID caso exista, em caso contrário, retorna "-1".                
                int idMappingFile = fdb.getReadDB().idMappingFile(file1, file2);
        
                //Caso o Arquivo de mapeamento NÃO exista.
                if(idMappingFile == -1){
                    
                    //Recupera o último par existente no Banco de Dados.
                    int lastPair = s.getFileDB().getReadDB().lastIdPair();

                    //Gera lista de "Pares Sugeridos".
                    mlps = s.getSuggestionPairText().listSuggestionPair(list_1, list_2, lastPair);
                    
                    //Requisita um "nome" para o "Arquivo de Mapeamento".
                    nameMappingFile = "TesteGeral_v01";
                    
                    //Cria arquivo de Mapeamento SEM os "Pares".
                    fm.getMappingCreate().createEmptyFileMapping(nameMappingFile, file1, file2);
                    
                    //Verifica se os documentos existem no Banco de Dados.
                    //Retorna o ID caso exista, em caso contrário, retorna "-1".
                    int idFile1, idFile2;
                    idFile1 = fdb.getReadDB().idDocument(file1);
                    idFile2 = fdb.getReadDB().idDocument(file2);
                    
                    //Verifica se o documento existe no Banco de Dados, em caso negativo o documento é adicionado e seu ID recuperado.
                    if(idFile1 == -1){
                        fdb.getStoryDB().saveDocument(file1, typeFile1);
                        idFile1 = fdb.getReadDB().idDocument(file1);
                    }
                    
                    //Verifica se o documento existe no Banco de Dados, em caso negativo o documento é adicionado e seu ID recuperado.
                    if(idFile2 == -1){
                        fdb.getStoryDB().saveDocument(file2, typeFile2);
                        idFile2 = fdb.getReadDB().idDocument(file2);
                    }
                            
                    //Salva arquivo de mapeamento no "Banco de Dados".
                    fdb.getStoryDB().saveFileMapping(nameMappingFile, idFile1, idFile2);
                    
                    //Recupera o ID do "Arquivo de Mapeamento" no Banco de Dados referênte aos arquivos especificados (lidos).
                    idMappingFile = fdb.getReadDB().idMappingFile(file1, file2);
                    
                    //Salva os "Pares Sugeridos" no Banco de Dados.
                    fdb.getStoryDB().savePairs(idUser, idMappingFile, mlps);
                    
                    out.println("<h2>" + nameMappingFile + "</h2><BR><BR>");
                    
                } else { //Caso o Arquivo de Mapeamento exista.
                    
                    boolean verifyUser = false;
                    
                    for(int user: fdb.getReadDB().mappingByUser(idMappingFile)){
                        if(user == idUser){
                            verifyUser = true;
                            break;
                        }
                    }
                    
                    //Caso o Arquivo de Mapeamento exista para o usuário logado.
                    if(verifyUser){
                        
                        //Retorna o nome do "Arquivo de Mapeamento" dado o seu ID.
                        nameMappingFile = fdb.getReadDB().nameMappingFile(idMappingFile);

                        //Recupera os pares sugeridos armazenados no Banco de Dados, DEPENDENTE do usuário.
                        mlps.setMappingListPairSuggestion(fdb.getReadDB().pairSuggestion(idMappingFile, idUser));

                        //Recupera o último "idPair" do Banco de Dados. (Necessário se novos pares forem incluídos)
                        mlps.setIdPair(fdb.getReadDB().lastIdPair());
                    } else {
                        
                        //Recupera os pares sugeridos armazenados no Banco de Dados, INDEPENDENTE do usuário.
                        mlps.setMappingListPairSuggestion(fdb.getReadDB().pairSuggestion(idMappingFile));
                        
                        //Salva os "Pares Sugeridos" no Banco de Dados.
                        fdb.getStoryDB().savePairs(idUser, idMappingFile, mlps);
                        
                        //Recupera o último "idPair" do Banco de Dados. (Necessário se novos pares forem incluídos)
                        mlps.setIdPair(fdb.getReadDB().lastIdPair());
                    }
                }
                
                //Armazena dados na sessão. ("nameMappingFile", "idMappingFile", "idUser", "nameFile2", "nameFile2")
                session.setAttribute("nameMappingFile", nameMappingFile);
                session.setAttribute("idMappingFile", idMappingFile);
                //session.setAttribute("idUser", idUser);
                session.setAttribute("nameFile1", file1);
                session.setAttribute("nameFile2", file2);
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
                //Utilizado para criar os campos para validação no formulário.
                String listPair = "";
                
                //Cria o formulário para validação dos pares. 
                for(MappingPairSuggestion mps: mlps.getMappingListPairSuggestion()){
                    listPair = "<tr>" + 
                                    "<td align=center>" + mps.getIdPair() + "</td>" +
                                    "<td align=center>" + mps.getFirst() + "</td>" + 
                                    "<td align=center>" + mps.getSecond() + "</td>" +
                                    "<td align=center>" + "<input type=\"radio\" name=\"validity_" + mps.getIdPair() + "\" value=\"1\"> Yes " + 
                                        "<input type=\"radio\" name=\"validity_" + mps.getIdPair() + "\" value=\"0\" checked> No" + "</td>" +
                                    "<td align=center>" + "<input type=\"text\" name=\"comment_" + mps.getIdPair() + "\"  size=\"50\" />" + "</td>" +
                                "</tr>";
                    out.println(listPair);
                }
                
            %>
                <tr>   
                    <td colspan="5" align=center><input type="submit" value="Save"></td>
                </tr>
            </table>
            
            <%
                /* FUNCIONA
                                
                MappingListPair mlp = new MappingListPair();
                SuggestionPair sp = new SuggestionPair();
                FileMapping fm = new FileMapping();
                
                //Cria um arquivo de mapeamento contendo todas as sugestões.
                mlp = sp.validitySugestinsTESTE(mlps);               
                out.println("<BR>STATUS<BR>" + fm.getMappingCreate().createFileMapping("TesteMap01", file1, file2, mlp)+"<BR><BR>");
                
                //Cria um arquivo de mapeamento contendo APENAS as sugestões validadas.
                out.println("<BR>STATUS<BR>" + fm.getMappingCreate().createFileMapping("TesteMap02", file1, file2, sp.validitySugestins(mlps))+"<BR><BR>");
                */
            %>
            
            <BR>

               
        </form>
        
        <BR><BR>
        
        <p><a href="index2.jsp">Collaborative Mapping - Homepage</a></p>
        <p><a href="index.jsp">EXIT</a></p>
    </body>
</html>
