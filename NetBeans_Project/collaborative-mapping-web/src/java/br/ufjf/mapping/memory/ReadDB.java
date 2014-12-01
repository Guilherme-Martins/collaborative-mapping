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
    
    
    /**
     *
     * @return
     */
    public static String query(){
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
            r = s.executeQuery("select * from user");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        result = "<br>NOMES:<br>";
        try {
            while (r.next()){
                result = result + r.getString("idUser") + " : " + r.getString("name") + " : " + r.getString("email") + "<br>";
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
     *
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
    
    /**
     *
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
    
    /**
     *
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
     *
     * @param nameUser
     * @param password
     * @return
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
}
