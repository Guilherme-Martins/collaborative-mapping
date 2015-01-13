/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.mapping.suggestion;

import br.ufjf.mapping.map.MappingListPairSuggestion;
import br.ufjf.mapping.map.MappingPairSuggestion;
import java.util.ArrayList;

/**
 *
 * @author Guilherme Martins
 */
public class SuggestionPairStructural {
    public MappingListPairSuggestion listSuggestionPair(ArrayList<String> list_1, ArrayList<String> list_2, int lastPair){
        
        MappingListPairSuggestion mlps = new MappingListPairSuggestion();
        
        mlps.setIdPair(lastPair + 1);
        
        //CASAMENTO_1: relaciona os elementos das duas listas se eles possuirem a mesma grafia.
        for(String s1: list_1){
            for(String s2: list_2){
                if(equalString(s1, s2)){
                    MappingPairSuggestion mps = new MappingPairSuggestion();
                    String e1 = s1;
                    String e2 = s2;
                    
                    mps.createPair(e1, e2, mlps.getLastIdPair());
                    mlps.updateIdPair();
                    mlps.getMappingListPairSuggestion().add(mps);
                }
            }
        }
        
        //Remove da lista os elementos adicionados no CASAMENTO_1.
        for(MappingPairSuggestion mps: mlps.getMappingListPairSuggestion()){
            for(String s1: list_1){
                if(mps.getFirst().equals(s1)){
                    list_1.remove(s1);
                    break;
                }
            }
            for(String s2: list_2){
                if(mps.getSecond().equals(s2)){
                    list_2.remove(s2);
                    break;
                }
            }
        }
        
        //CASAMENTO_2: relaciona os elementos em que seus nomes forem uma 'substring' um do outro, ou o inverso.
        /*
        for(String s1: list_1){
            for(String s2: list_2){
                if(containString(s1, s2)){
                    MappingPairSuggestion mps = new MappingPairSuggestion();
                    String e1 = s1;
                    String e2 = s2;
                    
                    mps.createPair(e1, e2, mlps.getLastIdPair());
                    mlps.updateIdPair();
                    mlps.getMappingListPairSuggestion().add(mps);
                }
            }
        }
        */
        
        return mlps;
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
