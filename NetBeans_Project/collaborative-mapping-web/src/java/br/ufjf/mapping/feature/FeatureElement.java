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
public class FeatureElement {
    private FeatureChildElements childElements = new FeatureChildElements();
    
    private String name;
    private String type;
    private String optional;
    private int id;

    /**
     * @return the name
     */
    @XmlAttribute
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    @XmlAttribute
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    @XmlAttribute
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the childElements
     */
    public FeatureChildElements getChildElements() {
        return childElements;
    }

    /**
     * @param childElements the childElements to set
     */
    public void setChildElements(FeatureChildElements childElements) {
        this.childElements = childElements;
    }

    /**
     * @return the optional
     */
    @XmlAttribute
    public String getOptional() {
        return optional;
    }

    /**
     * @param optional the optional to set
     */
    public void setOptional(String optional) {
        this.optional = optional;
    }
}
