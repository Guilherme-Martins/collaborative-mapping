/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.mapping.map;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Guilherme Martins
 */
public class MappingRead {
    
    /**
     *
     * @param nameFile
     * @return
     */
    public MappingStruct readMappingFile(String nameFile){
        MappingStruct map = null;
        
        try {
            File file = new File("E:/RepositoryGIT/collaborative-mapping/NetBeans_Project/files/mapping/"+nameFile+".xml");
            
            JAXBContext jaxbContext = JAXBContext.newInstance(MappingStruct.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            map = (MappingStruct) jaxbUnmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return map;
    }
   
    /**
     *
     * @param mapping
     * @return
     */
    public String extractDatas (MappingStruct mapping){
        String mappingRes = "Nothing!<BR>";
        
        if(mapping != null){
            mappingRes = mapping.getMapName() + "<BR>" + "Feature - Class<BR>";
            for(Mapping m: mapping.getMapping()){
                mappingRes = mappingRes + 
                        "ID: " + m.getId() +
                        " -- " + m.getFeatureName() + 
                        " :: " + m.getClassName() + "<BR>";                
            }
        }
        
        return "DATAS: " + mappingRes;  
    }
}
