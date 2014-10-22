/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.mapping.feature;

import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Guilherme Martins
 */
public class FeatureChildElements {
    
    private ArrayList<FeatureChild> child = new ArrayList<>();

    /**
     * @return the child
     */
    public ArrayList<FeatureChild> getChild() {
        return child;
    }

    /**
     * @param child the child to set
     */
    public void setChild(ArrayList<FeatureChild> child) {
        this.child = child;
    }
    
}
