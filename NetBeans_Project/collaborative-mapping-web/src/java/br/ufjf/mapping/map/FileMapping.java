/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.mapping.map;

/**
 *
 * @author Guilherme Martins
 */
public class FileMapping {
    
    private MappingCreate mappingCreate = new MappingCreate();
    private MappingRead mappingRead = new MappingRead();
    private MappingStruct mappingStruct = new MappingStruct();

    /**
     * @return the mappingCreate
     */
    public MappingCreate getMappingCreate() {
        return mappingCreate;
    }

    /**
     * @param mappingCreate the mappingCreate to set
     */
    public void setMappingCreate(MappingCreate mappingCreate) {
        this.mappingCreate = mappingCreate;
    }

    /**
     * @return the mappingRead
     */
    public MappingRead getMappingRead() {
        return mappingRead;
    }

    /**
     * @param mappingRead the mappingRead to set
     */
    public void setMappingRead(MappingRead mappingRead) {
        this.mappingRead = mappingRead;
    }

    /**
     * @return the mappingStruct
     */
    public MappingStruct getMappingStruct() {
        return mappingStruct;
    }

    /**
     * @param mappingStruct the mappingStruct to set
     */
    public void setMappingStruct(MappingStruct mappingStruct) {
        this.mappingStruct = mappingStruct;
    }  
}
