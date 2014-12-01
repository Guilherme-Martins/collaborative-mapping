/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.mapping.map;

import java.util.ArrayList;

/**
 *
 * @author Guilherme Martins
 */
public class MappingListPairSuggestion {
    
    private ArrayList<MappingPairSuggestion> mappingListPairSuggestion = new ArrayList<>();
    private int idPair;

    /**
     * @return the mappingListPairSuggestion
     */
    public ArrayList<MappingPairSuggestion> getMappingListPairSuggestion() {
        return mappingListPairSuggestion;
    }

    /**
     * @param mappingListPairSuggestion
     */
    public void setMappingListPairSuggestion(ArrayList<MappingPairSuggestion> mappingListPairSuggestion) {
        this.mappingListPairSuggestion = mappingListPairSuggestion;
    }

    /**
     * @return the idPair
     */
    public int getLastIdPair() {
        return idPair;
    }
    
    /**
     *
     * @param idPair
     */
    public void setIdPair( int idPair){
        this.idPair = idPair;
    }
    
    /**
     *
     */
    public void updateIdPair(){
        this.idPair = this.idPair + 1;
    }
    
    /**
     *
     * @return
     */
    public String printMappingListPairSuggestion(){
        String listPair = "PAIRS:<BR><BR>";
        
        for(MappingPairSuggestion mps: this.mappingListPairSuggestion){
            listPair = listPair + mps.getIdPair() + " = " +
                    mps.getFirst() + " :: " + mps.getSecond() + " :: " + 
                    mps.getValidity() + " :: " + mps.getComment() +
                    "<BR>";
        }
        return listPair;
    }
    
    /**
     *
     * @return
     */
    public String printMappingListPairSuggestionTESTE(){
        String listPair = "PAIRS:<BR><BR>";
        
        for(MappingPairSuggestion mps: this.mappingListPairSuggestion){
            listPair = listPair + mps.getIdPair() + " = " +
                    mps.getFirst() + " :: " + mps.getSecond() + " :: " + 
                    mps.getValidity() + " :: " +
                    "<input type=\"text\" name=\"comment_" + mps.getIdPair() + "\" />" +
                    "<BR>";
        }
        return listPair;
    }
}
