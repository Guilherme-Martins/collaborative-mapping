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
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author Guilherme Martins
 */
public class FeatureChild {
    private String optional;
    private int id;

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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
