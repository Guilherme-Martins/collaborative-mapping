/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.mapping.memory;

/**
 *
 * @author Guilherme Martins
 */
public class FileDB {
    
    private ConnectDB connectDB = new ConnectDB();
    private ReadDB readDB = new ReadDB();
    private StoreDB storyDB = new StoreDB();

    /**
     * @return the connectDB
     */
    public ConnectDB getConnectDB() {
        return connectDB;
    }

    /**
     * @param connectDB the connectDB to set
     */
    public void setConnectDB(ConnectDB connectDB) {
        this.connectDB = connectDB;
    }

    /**
     * @return the readDB
     */
    public ReadDB getReadDB() {
        return readDB;
    }

    /**
     * @param readDB the readDB to set
     */
    public void setReadDB(ReadDB readDB) {
        this.readDB = readDB;
    }

    /**
     * @return the storyDB
     */
    public StoreDB getStoryDB() {
        return storyDB;
    }

    /**
     * @param storyDB the storyDB to set
     */
    public void setStoryDB(StoreDB storyDB) {
        this.storyDB = storyDB;
    }
    
}
