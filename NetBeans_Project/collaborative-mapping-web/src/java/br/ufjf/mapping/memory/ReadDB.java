/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.mapping.memory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            result = result + r.getString("idUser") + " " + r.getString("nameUser") + "<br>";
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
}
