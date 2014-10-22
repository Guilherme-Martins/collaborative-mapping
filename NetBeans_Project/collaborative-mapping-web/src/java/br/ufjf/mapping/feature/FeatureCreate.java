/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.mapping.feature;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Guilherme Martins
 */
public class FeatureCreate {

    /**
     *
     * @param nameFile
     * @return
     */
    public String createFileFeature(String nameFile){
        
        FeatureStruct featureArray = new FeatureStruct();        
        featureArray.setElement(new ArrayList<FeatureElement>());
        featureArray.setNameFeature("testeCreate");
        
        for(int i = 1; i <= 3; i++){
            FeatureElement e = new FeatureElement();
            FeatureChildElements ce = new FeatureChildElements();
            
            ce.setChild(new ArrayList<FeatureChild>());
            
            for(int j = 1; j <=2; j++){
                FeatureChild c = new FeatureChild();
                c.setId(i+j);
                c.setOptional("false");
                ce.getChild().add(c);
            }
            
            e.setId(i);
            e.setName("nameFeature-"+i);
            e.setType("feature");
            e.setOptional("false");
            e.setChildElements(ce);
            
            featureArray.getElement().add(e);
        }
                
        String res = "Fail Features Model Create!";
        
        try {
            File file = new File("E:/RepositoryGIT/collaborative-mapping/NetBeans_Project/files/features-models/"+nameFile+".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(FeatureStruct.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(featureArray, file);
            jaxbMarshaller.marshal(featureArray, System.out);
            
            res = "Features Model Create!<BR>"+
                    "E:/RepositoryGIT/collaborative-mapping/NetBeans_Project/files/features-models/"+
                    nameFile+
                    ".xml";

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        
        return res;
    }
}
