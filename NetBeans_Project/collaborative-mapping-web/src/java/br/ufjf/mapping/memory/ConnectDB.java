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
        try { // Carregando o JDBC Driver padrão 
            String driverName = "com.mysql.jdbc.Driver"; 
            Class.forName(driverName); // Configurando a nossa conexão com um banco de dados// 
            String serverName = "localhost"; //caminho do servidor do BD 
            String mydatabase = "collaborative"; //nome do seu banco de dados 
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase; 
            String username = "root"; //nome de um usuário de seu BD 
            String password = "root"; //sua senha de acesso 
            connection = DriverManager.getConnection(url, username, password); //Testa sua conexão// 
            if (connection != null) { 
                status = ("<br>STATUS--->Success Connected!");
            }else{ 
                status = ("<br>STATUS--->Not connected!");
            } 
            return connection; 
        } catch (ClassNotFoundException e) { //Driver não encontrado 
            System.out.println("Error driver.");
            return null; 
        } catch (SQLException e) { //Não conseguindo se conectar ao banco 
            System.out.println("Error connection."); 
            return null; 
        } 
    } 

    //Método que retorna o status da sua conexão// 
 
    /**
     *
     * @return
     */
    public static String statusConnection() { 
       return status; 
    } 

    //Método que fecha sua conexão// 
 
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

    //Método que reinicia sua conexão// 
 
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
