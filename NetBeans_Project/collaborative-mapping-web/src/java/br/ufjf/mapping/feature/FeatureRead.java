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
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Guilherme Martins
 */
public class FeatureRead {
    
    /**
     *
     * @param nameFile
     * @return
     */
    public FeatureStruct readFeatureFile(String nameFile){
        FeatureStruct feature = null;
        
        try {
            File file = new File("E:/RepositoryGIT/collaborative-mapping/NetBeans_Project/files/features-models/"+nameFile+".xml");
            
            JAXBContext jaxbContext = JAXBContext.newInstance(FeatureStruct.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            feature = (FeatureStruct) jaxbUnmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return feature;
    }
    
    /**
     *
     * @param feature
     * @return
     */
    public String extractDatas (FeatureStruct feature){
        String featureRes = "Nothing!<BR>";
        
        if(feature != null){
            featureRes = feature.getNameFeature() + "<BR>";
            for(FeatureElement e: feature.getElement()){
                featureRes = featureRes + 
                        "ID: " + e.getId() + 
                        " -- Name: " + e.getName() + 
                        " -- Type: " + e.getType() +
                        " -- Optional Element: " + e.getOptional();
                for(FeatureChild c: e.getChildElements().getChild()){
                    featureRes = featureRes + 
                        " -- Child: " + c.getId() + 
                        " -- Optional Child: " + c.getOptional();
                }
                featureRes = featureRes + "<BR>";
            }
        }
        
        return "DATAS: " + featureRes;  
    }
    
    /**
     *
     * @param feature
     * @return
     */
    public ArrayList<String> getElementNames (FeatureStruct feature){
        ArrayList<String> namesFeatures = new ArrayList<>();
                
        if(feature != null){
            for(FeatureElement e: feature.getElement()){
                namesFeatures.add(e.getName());
            }
        } else {
            namesFeatures.add("Nothing!");
        }
        
        return namesFeatures;  
    }
    
    /**
     *
     * @param feature
     * @param idElement
     * @return
     */
    public String getSpecificElementName (FeatureStruct feature, int idElement){
        String nameElement = "Nothing!";
        
        if(feature != null){
            for(FeatureElement e: feature.getElement()){
                if(e.getId() == idElement){
                    nameElement = e.getName();
                    break;
                }
            }
        }
        
        return nameElement;
    }
    
    /**
     *
     * @param feature
     * @param idElement
     * @return
     */
    public ArrayList<String> getChildsElements (FeatureStruct feature, int idElement){
        ArrayList<String> nameChilds = new ArrayList<>();
        String nameElement;
        
        if(feature != null){
            for(FeatureElement e: feature.getElement()){
                if(e.getId() == idElement){
                    for(FeatureChild c: e.getChildElements().getChild()){
                        nameElement = getSpecificElementName(feature, c.getId());
                        nameChilds.add(nameElement);
                    }
                    break;
                }
            }
        } else {
            nameChilds.add("Nothing!");
        }
        
        return nameChilds;
    }
    
    /**
     *
     * @param feature
     * @param idElement
     * @return
     */
    public String getOptionalElement (FeatureStruct feature, int idElement){
        String optionalElement = "";
        
         if(feature != null){
            for(FeatureElement e: feature.getElement()){
                if(e.getId() == idElement){
                    optionalElement = e.getOptional();
                    break;
                }
            }
        } else {
            optionalElement = "Nothing!";
        }
        
        return optionalElement;
    }
    
    /**
     *
     * @param feature
     * @return nameFeaturesModel - 
     */
    public String getNameFeaturesModel (FeatureStruct feature){
        String nameFeaturesModel = feature.getNameFeature();

        return nameFeaturesModel;
    }
    
}
