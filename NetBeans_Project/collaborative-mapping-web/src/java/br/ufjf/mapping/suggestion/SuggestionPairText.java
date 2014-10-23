/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.mapping.suggestion;

import br.ufjf.mapping.map.MappingListPair;
import br.ufjf.mapping.map.MappingPair;
import java.util.ArrayList;

/**
 *
 * @author Guilherme Martins
 */
public class SuggestionPairText {
    
    public MappingListPair listSuggestionPair(ArrayList<String> list_1, ArrayList<String> list_2){
        
        MappingListPair mlp = new MappingListPair();
        
        for(String s1: list_1){
            for(String s2: list_2){
                if(equalString(s1, s2)){
                    MappingPair mp = new MappingPair();
                    mp.createPair(s1, s2, mlp.getLastIdPair());
                    mlp.updateIdPair();
                    mlp.getMappingListPair().add(mp);
                }
            }
        }
        
        return mlp;
    }
    
    public boolean equalString(String text_1, String text_2){
        boolean equal = false;
        
        if(text_1.equalsIgnoreCase(text_2))
            equal = true;
            
        return equal;
    }
    
    public boolean containString(String text_1, String text_2){
        boolean equal = false;
        
        text_1 = text_1.toLowerCase();
        text_2 = text_2.toLowerCase();
        
        if(text_1.contains(text_2) || text_2.contains(text_1))
            equal = true;
            
        return equal;
    }
}

