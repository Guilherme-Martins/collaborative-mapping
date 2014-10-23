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
public class MappingListPair {
    
    private ArrayList<MappingPair> mappingListPair = new ArrayList<>();
    private int idPair = 1;

    /**
     * @return the mappingListPair
     */
    public ArrayList<MappingPair> getMappingListPair() {
        return mappingListPair;
    }

    /**
     * @param mappingListPair the mappingListPair to set
     */
    public void setMappingListPair(ArrayList<MappingPair> mappingListPair) {
        this.mappingListPair = mappingListPair;
    }

    /**
     * @return the idPair
     */
    public int getLastIdPair() {
        return idPair;
    }
    
    /**
     *
     */
    public void updateIdPair(){
        this.idPair = this.idPair + 1;
    }
    
    public String printMappingListPair(){
        String listPair = "";
        
        for(MappingPair mp: this.mappingListPair){
            listPair = listPair + mp.getIdPair() + " = " +
                    mp.getFirst() + " :: " + mp.getSecond() +
                    "<BR>";
        }   
        return listPair;
    }
}
