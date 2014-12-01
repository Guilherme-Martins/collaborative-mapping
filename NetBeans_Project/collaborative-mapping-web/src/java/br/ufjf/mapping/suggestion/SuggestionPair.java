/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.mapping.suggestion;

import br.ufjf.mapping.map.MappingListPair;
import br.ufjf.mapping.map.MappingListPairSuggestion;
import br.ufjf.mapping.map.MappingPair;
import br.ufjf.mapping.map.MappingPairSuggestion;
import java.util.ArrayList;

/**
 *
 * @author Guilherme Martins
 */
public class SuggestionPair {
    
    public MappingListPair validitySugestins(MappingListPairSuggestion mlps){
        
        MappingListPair mlp = new MappingListPair();
        
        for(MappingPairSuggestion mps: mlps.getMappingListPairSuggestion()){
            if(mps.getValidity() != 0){
                MappingPair mp = new MappingPair();

                mp.createPair(mps.getFirst(), mps.getSecond(), mps.getIdPair());
                mlp.getMappingListPair().add(mp);
            }
        }
        
        return mlp;
    }
    
    public MappingListPair validitySugestinsTESTE(MappingListPairSuggestion mlps){
        
        MappingListPair mlp = new MappingListPair();
        
        for(MappingPairSuggestion mps: mlps.getMappingListPairSuggestion()){
           
            MappingPair mp = new MappingPair();

            mp.createPair(mps.getFirst(), mps.getSecond(), mps.getIdPair());
            mlp.getMappingListPair().add(mp);
        }
        
        return mlp;
    }
}
