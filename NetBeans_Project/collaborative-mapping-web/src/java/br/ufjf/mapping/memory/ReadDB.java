/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.mapping.memory;

import br.ufjf.mapping.map.MappingPairSuggestion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Guilherme Martins
 */
public class ReadDB {
    
    
    /************************************************ USER ************************************************/
    
    /**
     * Retorna o nome de um usuário.
     * @param idUser ID do usuário.
     * @return String com o nome do usuário.
     */
    public String getNameUser(int idUser){
        String result = "";

        Statement s = null;
        Connection connection = ConnectDB.getConnectDB();
        try {
            s = (Statement) connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet r = null;
        try {
            r = s.executeQuery("select name from user where idUser = " + idUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(r.next()){
                result = r.getString("name");
            }
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
        try {
              r.close();
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
        return result;
    }
    
    /**
     * Realiza a validação de um usuário quando este for realizar login no sistema.
     * @param nameUser
     * @param password
     * @return int (-1 caso não possua cadastro, o ID do usuário caso contrário).
     */
    public int authenticationUser(String nameUser, String password){
        String result = "";

        Statement s = null;
        Connection connection = ConnectDB.getConnectDB();
        try {
            s = (Statement) connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "select idUser " +
            "from user " +
            "where login like \"" + nameUser + "\" " +
                "and password like \"" + password + "\"";
        
        ResultSet r = null;
        try {
            r = s.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
            if(r.next()){
                result = r.getString("idUser");
            }
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
        try {
              r.close();
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
                
        if(result != null && !result.isEmpty())
            return Integer.parseInt(result);
        else
            return -1;
    }
    
    /************************************************ PAIR MAPPING ************************************************/
    
    /**
     * Retorna o ID do último par salvo no Banco de Dados.
     * @return
     */
    public int lastIdPair(){
        String result = "";

        Statement s = null;
        Connection connection = ConnectDB.getConnectDB();
        try {
            s = (Statement) connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet r = null;
        try {
            r = s.executeQuery("select p.idPairMap from pairmap as p order by idPairMap desc limit 1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
            if(r.next()){
                result = r.getString("p.idPairMap");
            }
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
        try {
              r.close();
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
                
        if(result != null && !result.isEmpty())
            return Integer.parseInt(result);
        else
            return 0;
    }
    
    /************************************************ MAPPING FILE ************************************************/
    
    /**
     * Retorna o ID de um arquivo de mapeamento dado os nomes dos arquivos que ele mapeia.
     * @param nameFile1
     * @param nameFile2
     * @return
     */
    public int idMappingFile(String nameFile1, String nameFile2){
        String result = "";

        Statement s = null;
        Connection connection = ConnectDB.getConnectDB();
        try {
            s = (Statement) connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "select m.idMappingFile " +
            "from mappingfile as m, document as d1, document as d2 " +
            "where m.idDocument1 = d1.idDocument and " +
            "m.idDocument2 = d2.idDocument and " +
            "d1.name like \"" + nameFile1 + "\" and " +
            "d2.name like \""+ nameFile2 + "\"";
        
        ResultSet r = null;
        try {
            r = s.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
            if(r.next()){
                result = r.getString("m.idMappingFile");
            }
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
        try {
              r.close();
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
                
        if(result != null && !result.isEmpty())
            return Integer.parseInt(result);
        else
            return -1;
    }
    
    /**
     * Retorna o ID de um arquivo de mapeamento dado o seu nome.
     * @param nameMappingFile
     * @return
     */
    public int idMappingFile(String nameMappingFile){
        String result = "";

        Statement s = null;
        Connection connection = ConnectDB.getConnectDB();
        try {
            s = (Statement) connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "select m.idMappingFile " +
            "from mappingfile as m " +
            "where m.name like '"+ nameMappingFile + "'";
        
        ResultSet r = null;
        try {
            r = s.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
            if(r.next()){
                result = r.getString("m.idMappingFile");
            }
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
        try {
              r.close();
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
                
        if(result != null && !result.isEmpty())
            return Integer.parseInt(result);
        else
            return -1;
    }
    
    /**
     * Retorna o nome de um arquivo de mapeamento dado o seu ID.
     * @param idMappingFile
     * @return
     */
    public String nameMappingFile(int idMappingFile){
        String result = "";

        Statement s = null;
        Connection connection = ConnectDB.getConnectDB();
        try {
            s = (Statement) connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "select m.name " +
            "from mappingfile as m " +
            "where m.idMappingFile = " + idMappingFile;

        ResultSet r = null;
        try {
            r = s.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
            if(r.next()){
                result = r.getString("m.name");
            }
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
        try {
              r.close();
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
                
        if(result != null && !result.isEmpty())
            return result;
        else
            return null;
    }
    
    /**
     * Retorna uma lista dos pares pertencentes a um arquivo de mapeamento.
     * @param idMappingFile
     * @param idUser
     * @return
     */
    public ArrayList<MappingPairSuggestion> pairSuggestion(int idMappingFile, int idUser){

        ArrayList<MappingPairSuggestion> mappingListPairSuggestion = new ArrayList<>();
        
        Statement s = null;
        Connection connection = ConnectDB.getConnectDB();
        try {
            s = (Statement) connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "select * from pairmap as p where "  + 
                            "p.idMappinfFile = " + idMappingFile +
                            " and p.idUser = " + idUser;
        
        ResultSet r = null;
        try {
            r = s.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (r.next()){
                MappingPairSuggestion mps = new MappingPairSuggestion();
                mps.setIdPair(Integer.parseInt(r.getString("idPairMap")));
                mps.setFirst(r.getString("element1"));
                mps.setSecond(r.getString("element2"));
                mps.setValidity(Integer.parseInt(r.getString("validity")));
                mps.setComment(r.getString("description"));
                
                mappingListPairSuggestion.add(mps);
            }
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
        try {
              r.close();
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
        
        return mappingListPairSuggestion;
    }
    
    /**
     * Retorna uma lista dos pares pertencentes a um arquivo de mapeamento.
     * @param idMappingFile
     * @return
     */
    public ArrayList<MappingPairSuggestion> pairSuggestion(int idMappingFile){

        ArrayList<MappingPairSuggestion> mappingListPairSuggestion = new ArrayList<>();
        
        Statement s = null;
        Connection connection = ConnectDB.getConnectDB();
        try {
            s = (Statement) connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "select * from pairmap as p where "  + 
                            "p.idMappinfFile = " + idMappingFile +
                            " group by p.idPairMap";
        
        ResultSet r = null;
        try {
            r = s.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (r.next()){
                MappingPairSuggestion mps = new MappingPairSuggestion();
                mps.setIdPair(Integer.parseInt(r.getString("idPairMap")));
                mps.setFirst(r.getString("element1"));
                mps.setSecond(r.getString("element2"));
                mps.setValidity(Integer.parseInt(r.getString("validity")));
                mps.setComment(r.getString("description"));
                
                mappingListPairSuggestion.add(mps);
            }
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
        try {
              r.close();
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
        
        return mappingListPairSuggestion;
    }
    
    /**
     * Retorna os IDs dos usuários dado o ID de um arquivo de mapeamento.
     * @param idMappingFile
     * @return - Lista com os IDs dos usuários.
     */
    public ArrayList<Integer> mappingByUser(int idMappingFile){

        ArrayList<Integer> idUsers = new ArrayList<>();
        
        Statement s = null;
        Connection connection = ConnectDB.getConnectDB();
        try {
            s = (Statement) connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "select p.idUser from pairmap as p where p.idMappinfFile = "+
                idMappingFile + " group by p.idUser";
        
        ResultSet r = null;
        try {
            r = s.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (r.next()){
                int idUser = Integer.parseInt(r.getString("p.idUser"));               
                idUsers.add(idUser);
            }
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
        try {
              r.close();
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
        
        return idUsers;
    }
    
    /**
     * Retorna a quantidade de validações POSITIVAS dado o ID de um arquivo de mapeamento.
     * @param idMappingFile
     * @return
     */
    public int getPositiveQuantity(int idMappingFile){
        String result = "";

        Statement s = null;
        Connection connection = ConnectDB.getConnectDB();
        try {
            s = (Statement) connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet r = null;
        try {
            r = s.executeQuery("select count(distinct idPairMap) as positive from pairmap where idMappinfFile = " + idMappingFile + " and validity = 1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
            if(r.next()){
                result = r.getString("positive");
            }
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
        try {
              r.close();
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
                
        if(result != null && !result.isEmpty())
            return Integer.parseInt(result);
        else
            return 0;
    }
    
    /**
     * Retorna a quantidade de validações NEGATIVAS dado o ID de um arquivo de mapeamento.
     * @param idMappingFile
     * @return
     */
    public int getNegativeQuantity(int idMappingFile){
        String result = "";

        Statement s = null;
        Connection connection = ConnectDB.getConnectDB();
        try {
            s = (Statement) connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet r = null;
        try {
            r = s.executeQuery("select count(distinct idPairMap) as positive from pairmap where idMappinfFile = " + idMappingFile + " and validity = 0");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
            if(r.next()){
                result = r.getString("positive");
            }
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
        try {
              r.close();
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
                
        if(result != null && !result.isEmpty())
            return Integer.parseInt(result);
        else
            return 0;
    }
    
    /**
     * Retorna a quantidade de validações TOTAL dado o ID de um arquivo de mapeamento e o ID de um usuário.
     * @param idMappingFile
     * @param idUser
     * @return
     */
    public int getQuantityByUser(int idMappingFile, int idUser){
        String result = "";

        Statement s = null;
        Connection connection = ConnectDB.getConnectDB();
        try {
            s = (Statement) connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet r = null;
        try {
            r = s.executeQuery("select count(distinct idPairMap) as positive from pairmap where idMappinfFile = " + 
                    idMappingFile + " and idUser = " + idUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
            if(r.next()){
                result = r.getString("positive");
            }
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
        try {
              r.close();
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
                
        if(result != null && !result.isEmpty())
            return Integer.parseInt(result);
        else
            return 0;
    }
    
    /**
     * Retorna a quantidade de validações POSITIVAS dado o ID de um arquivo de mapeamento e o ID de um usuário.
     * @param idMappingFile
     * @param idUser
     * @return
     */
    public int getPositiveQuantityByUser(int idMappingFile, int idUser){
        String result = "";

        Statement s = null;
        Connection connection = ConnectDB.getConnectDB();
        try {
            s = (Statement) connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet r = null;
        try {
            r = s.executeQuery("select count(distinct idPairMap) as positive from pairmap where idMappinfFile = " + 
                    idMappingFile + " and idUser = " + idUser + " and validity = 1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
            if(r.next()){
                result = r.getString("positive");
            }
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
        try {
              r.close();
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
                
        if(result != null && !result.isEmpty())
            return Integer.parseInt(result);
        else
            return 0;
    }
    
    /**
     * Retorna a quantidade de validações NEGATIVAS dado o ID de um arquivo de mapeamento e o ID de um usuário.
     * @param idMappingFile
     * @param idUser
     * @return
     */
    public int getNegativeQuantityByUser(int idMappingFile, int idUser){
        String result = "";

        Statement s = null;
        Connection connection = ConnectDB.getConnectDB();
        try {
            s = (Statement) connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet r = null;
        try {
            r = s.executeQuery("select count(distinct idPairMap) as positive from pairmap where idMappinfFile = " + 
                    idMappingFile + " and idUser = " + idUser + " and validity = 0");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
            if(r.next()){
                result = r.getString("positive");
            }
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
        try {
              r.close();
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
                
        if(result != null && !result.isEmpty())
            return Integer.parseInt(result);
        else
            return 0;
    }
    
    /**
     * Retorna os comentários deixados pelos usuário.
     * @param idMappingFile
     * @param idPair
     * @return - String com os comentários.
     */
    public String getDescriptionByUser(int idMappingFile, int idPair){
        String result = "";

        Statement s = null;
        Connection connection = ConnectDB.getConnectDB();
        try {
            s = (Statement) connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "select u.name, p.description, p.method from pairmap as p, user as u " +
            "where p.idMappinfFile = " + idMappingFile + 
            " and p.idPairMap = " + idPair + " and p.idUser = u.idUser";

        ResultSet r = null;
        try {
            r = s.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
            while(r.next()){
                result = result + r.getString("u.name") + ": " + r.getString("p.description") + "<BR>";
            }
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
        try {
              r.close();
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
                
        if(result != null && !result.isEmpty())
            return result;
        else
            return null;
    }
    
    /**
     * Retorna o método utilizado para criar o arquivo de mapeamento.
     * @param idMappingFile
     * @param idUser
     * @return
     */
    public String getMethodValidation(int idMappingFile, int idUser){
        String result = "";

        Statement s = null;
        Connection connection = ConnectDB.getConnectDB();
        try {
            s = (Statement) connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "select distinct p.method from pairmap as p" +
                " where p.idMappinfFile = " + idMappingFile + 
                " and p.idUser = " + idUser;
        
        ResultSet r = null;
        try {
            r = s.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
            if(r.next()){
                result = r.getString("p.method");
            }
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
        try {
              r.close();
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
               
        return result;
    }
    
    /************************************************ DOCUMENT ************************************************/
    
    /**
     * Retorna o ID de um documento dado o seu nome.
     * @param nameFile
     * @return - Inteiro com o ID de um documewnto.
     */
    public int idDocument(String nameFile){
        String result = "";

        Statement s = null;
        Connection connection = ConnectDB.getConnectDB();
        try {
            s = (Statement) connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "select d.idDocument " +
            "from document as d " +
            "where d.name like \"" + nameFile + "\"";
        
        ResultSet r = null;
        try {
            r = s.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
            if(r.next()){
                result = r.getString("d.idDocument");
            }
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
        try {
              r.close();
        } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
                
        if(result != null && !result.isEmpty())
            return Integer.parseInt(result);
        else
            return -1;
    }
}