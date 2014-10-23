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
    private String firstFileName;
    private String secondFileName;

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
    @XmlAttribute(name = "nameMap")
    public String getMapName() {
        return mapName;
    }

    /**
     * @param mapName the mapName to set
     */
    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    /**
     * @return the firstFileName
     */
    @XmlAttribute(name = "nameFile1")
    public String getFirstFileName() {
        return firstFileName;
    }

    /**
     * @param firstFileName the firstFileName to set
     */
    public void setFirstFileName(String firstFileName) {
        this.firstFileName = firstFileName;
    }

    /**
     * @return the secondFileName
     */
    @XmlAttribute(name = "nameFile2")
    public String getSecondFileName() {
        return secondFileName;
    }

    /**
     * @param secondFileName the secondFileName to set
     */
    public void setSecondFileName(String secondFileName) {
        this.secondFileName = secondFileName;
    }
}
