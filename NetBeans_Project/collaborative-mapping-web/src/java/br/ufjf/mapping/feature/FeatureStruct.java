/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.mapping.feature;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guilherme Martins
 */
@XmlRootElement(name = "plm")
public class FeatureStruct {
    private ArrayList<FeatureElement> element = new ArrayList<>();    
    private String nameFeature;

    /**
     * @return the element
     */
    public ArrayList<FeatureElement> getElement() {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(ArrayList<FeatureElement> element) {
        this.element = element;
    }

    /**
     * @return the nameFeature
     */
    @XmlAttribute(name = "name")
    public String getNameFeature() {
        return nameFeature;
    }

    /**
     * @param nameFeature the nameFeature to set
     */
    public void setNameFeature(String nameFeature) {
        this.nameFeature = nameFeature;
    }    
}
