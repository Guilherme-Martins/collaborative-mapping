/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.mapping.map;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guilherme Martins
 */
@XmlRootElement
public class MappingStruct {
    
    private ArrayList<Mapping> mapping = new ArrayList<>();
    private String mapName;

    /**
     *
     * @return
     */
    public ArrayList<Mapping> getMapping() {
        return mapping;
    }

    /**
     *
     * @param mapping
     */
    public void setMapping(ArrayList<Mapping> mapping) {
        this.mapping = mapping;
    }  

    /**
     * @return the mapName
     */
    @XmlAttribute(name = "name")
    public String getMapName() {
        return mapName;
    }

    /**
     * @param mapName the mapName to set
     */
    public void setMapName(String mapName) {
        this.mapName = mapName;
    }
}
