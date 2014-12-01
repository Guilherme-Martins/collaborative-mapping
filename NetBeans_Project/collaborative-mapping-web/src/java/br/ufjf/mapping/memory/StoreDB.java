/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.mapping.memory;

import br.ufjf.mapping.map.MappingListPairSuggestion;
import br.ufjf.mapping.map.MappingPair;
import br.ufjf.mapping.map.MappingPairSuggestion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Guilherme Martins
 */
public class StoreDB {
    
    public String save(String name) throws SQLException{
        
        String save = "Erro de Gravação!";
        // cria um preparedStatement
        try ( // conectando
            Connection con = ConnectDB.getConnectDB()) {
            // cria um preparedStatement
            String sql = "insert into user" +
                    " (nameUser)" +
                    " values (?)";
            // preenche os valores
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                // preenche os valores
                stmt.setString(1, name);              
                
                // executa
                stmt.execute();
                
                stmt.close();
                con.close();
                
                save = "Gravado!";
            }
            
        }
        return save;
    }
    
    public String saveDocument(String nameFile, String type) throws SQLException{
        
        String save = "Erro de Gravação!";
        // cria um preparedStatement
        try ( // conectando
            Connection con = ConnectDB.getConnectDB()) {
            // cria um preparedStatement
            String sql = "insert into document" +
                    " (name, type)" +
                    " values (?, ?)";
            // preenche os valores
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                // preenche os valores
                stmt.setString(1, nameFile);              
                stmt.setString(2, type);
                
                // executa
                stmt.execute();
                
                stmt.close();
                con.close();
                
                save = "Gravado!";
            }
        }
        return save;
    }
    
    public String savePairs(int idUser, int idMappingFile, MappingListPairSuggestion mlps) throws SQLException{
        
        String save = "Erro de Gravação!";
        // cria um preparedStatement
        try ( // conectando
            Connection con = ConnectDB.getConnectDB()) {
            // cria um preparedStatement
            String sql = "insert into pairmap" +
                    " (idPairMap, idUser, idMappinfFile, element1, element2, description, validity)" +
                    " values (?, ?, ?, ?, ?, ?, ?)";
            
            for(MappingPairSuggestion mps: mlps.getMappingListPairSuggestion()){
            
                // preenche os valores
                try (PreparedStatement stmt = con.prepareStatement(sql)) {
                    // preenche os valores
                    stmt.setInt(1, mps.getIdPair());                           
                    stmt.setInt(2, idUser);
                    stmt.setInt(3, idMappingFile); 
                    stmt.setString(4, mps.getFirst());
                    stmt.setString(5, mps.getSecond());
                    stmt.setString(6, mps.getComment());
                    stmt.setInt(7, mps.getValidity());

                    // executa
                    stmt.execute();

                    stmt.close();
                    
                    save = "Gravado!";
                }
            }
            con.close();
        }
        return save;
    }
    
    public String updatePairs(int idUser, int idMappingFile, MappingListPairSuggestion mlps) throws SQLException{
        
        String save = "Erro de Gravação!";
        // cria um preparedStatement
        try ( // conectando
            Connection con = ConnectDB.getConnectDB()) {
            // cria um preparedStatement
            String sql = "UPDATE pairmap SET description = ?, validity = ? " +
                    "WHERE idPairMap = ? AND idUser = " + idUser + " AND idMappinfFile = " + idMappingFile;
            
            for(MappingPairSuggestion mps: mlps.getMappingListPairSuggestion()){
            
                // preenche os valores
                try (PreparedStatement stmt = con.prepareStatement(sql)) {
                    // preenche os valores                          
                    stmt.setString(1, mps.getComment());
                    stmt.setInt(2, mps.getValidity());
                    stmt.setInt(3, mps.getIdPair());
                    
                    // executa
                    stmt.execute();

                    stmt.close();
                    
                    save = "Gravado!";
                }
            }
            con.close();
        }
        return save;
    }
    
    public String saveFileMapping(String nameMappingFile, int idFile1, int idFile2) throws SQLException{
        
        String save = "Erro de Gravação!";
        
        // cria um preparedStatement
        try ( // conectando
            Connection con = ConnectDB.getConnectDB()) {
            // cria um preparedStatement
            String sql = "insert into mappingfile" +
                    " (idDocument1, idDocument2, name)" +
                    " values (?, ?, ?)";
            // preenche os valores
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                // preenche os valores
                stmt.setInt(1, idFile1);
                stmt.setInt(2, idFile2);
                stmt.setString(3, nameMappingFile);
                
                // executa
                stmt.execute();
                
                stmt.close();
                con.close();
                
                save = "Gravado!";
            }
        }
        return save;
    }
    
    
}
