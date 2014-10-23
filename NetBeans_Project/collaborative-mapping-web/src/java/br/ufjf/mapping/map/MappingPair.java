/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.mapping.map;

/**
 *
 * @author Guilherme Martins
 */
public class MappingPair {
    private String first;
    private String second;
    private int idPair;

    /**
     * @return the first
     */
    public String getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(String first) {
        this.first = first;
    }

    /**
     * @return the second
     */
    public String getSecond() {
        return second;
    }

    /**
     * @param second the second to set
     */
    public void setSecond(String second) {
        this.second = second;
    }

    /**
     * @return the idPair
     */
    public int getIdPair() {
        return idPair;
    }

    /**
     * @param idPair the idPair to set
     */
    public void setIdPair(int idPair) {
        this.idPair = idPair;
    }
     
    /**
     *
     * @param idPair
     */
    public void createPairGeneric(int idPair){
        this.first = "fist"+idPair;
        this.second = "second"+idPair;
        this.idPair = idPair;
    }
    
    /**
     *
     * @param first
     * @param second
     * @param idPair
     */
    public void createPair(String first, String second, int idPair){
        this.first = first;
        this.second = second;
        this.idPair = idPair;
    }
}
