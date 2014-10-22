/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.mapping.memory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Guilherme Martins
 */
public class ConnectDB {
    
    /**
     *
     */
    public static String status = "Connecting...<BR>";
    
    /**
     *
     */
    public ConnectDB() {}
    
    /**
     *
     * @return
     */
    public static java.sql.Connection getConnectDB() { 
        Connection connection = null; //atributo do tipo Connection 
        try { // Carregando o JDBC Driver padr�o 
            String driverName = "com.mysql.jdbc.Driver"; 
            Class.forName(driverName); // Configurando a nossa conex�o com um banco de dados// 
            String serverName = "localhost"; //caminho do servidor do BD 
            String mydatabase = "collaborative"; //nome do seu banco de dados 
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase; 
            String username = "root"; //nome de um usu�rio de seu BD 
            String password = "root"; //sua senha de acesso 
            connection = DriverManager.getConnection(url, username, password); //Testa sua conex�o// 
            if (connection != null) { 
                status = ("<br>STATUS--->Success Connected!");
            }else{ 
                status = ("<br>STATUS--->Not connected!");
            } 
            return connection; 
        } catch (ClassNotFoundException e) { //Driver n�o encontrado 
            System.out.println("Error driver.");
            return null; 
        } catch (SQLException e) { //N�o conseguindo se conectar ao banco 
            System.out.println("Error connection."); 
            return null; 
        } 
    } 

    //M�todo que retorna o status da sua conex�o// 
 
    /**
     *
     * @return
     */
    public static String statusConnection() { 
       return status; 
    } 

    //M�todo que fecha sua conex�o// 
 
    /**
     *
     * @return
     */
    public static boolean closeConnect() { 
        try { 
            ConnectDB.getConnectDB().close(); 
            return true; 
        } catch (SQLException e) { 
            return false; 
        } 
    } 

    //M�todo que reinicia sua conex�o// 
 
    /**
     *
     * @return
     */
        public static java.sql.Connection restartConnection() { 
        closeConnect(); 
        return ConnectDB.getConnectDB(); 
    } 
    
    /**
     *
     * @return
     */
    public String teste(){
        return "OK";
    }
}
