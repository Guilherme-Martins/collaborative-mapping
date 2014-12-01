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
public class MappingPairSuggestion {
    
    private String first;
    private String second;
    private int idPair;
    private int validity = 0;
    private String comment = "";

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
    
    /**
     *
     * @param first
     * @param second
     * @param idPair
     * @param validaty
     * @param comment
     */
    public void createPair(String first, String second, int idPair, int validaty, String comment){
        this.first = first;
        this.second = second;
        this.idPair = idPair;
        this.validity = validity;
        this.comment = comment;
    }
    
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
        this.first = "first"+idPair;
        this.second = "second"+idPair;
        this.idPair = idPair;
    }
    
    /**
     * @return the validaty
     */
    public int getValidity() {
        return validity;
    }

    /**
     * @param validaty the validaty to set
     */
    public void setValidity(int validity) {
        this.validity = validity;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
