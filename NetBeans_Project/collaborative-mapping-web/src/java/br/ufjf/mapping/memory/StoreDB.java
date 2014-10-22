/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.mapping.memory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Guilherme Martins
 */
public class StoreDB {
    
    public String save(String name, String lastName) throws SQLException{
        
        String save = "Erro de Gravação!";
        // cria um preparedStatement
        try ( // conectando
            Connection con = ConnectDB.getConnectDB()) {
            // cria um preparedStatement
            String sql = "insert into teste" +
                    " (nome,sobrenome)" +
                    " values (?,?)";
            // preenche os valores
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                // preenche os valores
                stmt.setString(1, name);
                stmt.setString(2, lastName);
                
                // executa
                stmt.execute();
                
                stmt.close();
                con.close();
            }
            
            save = "Gravado!";
        }
        return save;
    }
    
}
