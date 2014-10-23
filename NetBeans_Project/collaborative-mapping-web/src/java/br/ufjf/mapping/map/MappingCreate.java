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
import javax.xml.bind.Marshaller;

/**
 *
 * @author Guilherme Martins
 */
public class MappingCreate {
    
    /**
     *
     * @param nameFile
     * @param mappingPair
     * @return
     */
    public String createFileMapping(String nameFile, MappingListPair mappingListPair){
        
        MappingStruct mappingStruct = new MappingStruct();        
        mappingStruct.setMapping(new ArrayList<Mapping>());
        
        for(int j = 1; j <= 20; j++){
            MappingPair map = new MappingPair();
            map.createPairGeneric(mappingListPair.getLastIdPair());
            mappingListPair.updateIdPair();
            mappingListPair.getMappingListPair().add(map);
        }
        
        mappingStruct.setMapName(nameFile);
        mappingStruct.setFirstFileName(nameFile+"-01");
        mappingStruct.setSecondFileName(nameFile+"-02");
        
        for(MappingPair mp: mappingListPair.getMappingListPair()){
            Mapping m = new Mapping();
            
            m.setId(mp.getIdPair());            
            m.setClassName(mp.getFirst());
            m.setFeatureName(mp.getSecond());
            
            mappingStruct.getMapping().add(m);        
        }
                
        String res = "Fail Mapping Create!";
        
        try {
            File file = new File("E:/RepositoryGIT/collaborative-mapping/NetBeans_Project/files/mapping/"+nameFile+".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(MappingStruct.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(mappingStruct, file);
            jaxbMarshaller.marshal(mappingStruct, System.out);
            
            res = "Mapping Create!<BR>"+
                    "E:/RepositoryGIT/collaborative-mapping/NetBeans_Project/files/mapping/"+
                    nameFile+
                    ".xml";

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        
        return res;
    }
    
    
}
