/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.mapping.ontology;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Guilherme Martins
 */
public class FileOntology {
    private static final String BASE_URI = "http://plscience.superdignus.com/SequenceAligningOntology#";
    private static final String ONTOLOGY_URI = "file:///E:/RepositoryGIT/collaborative-mapping/NetBeans_Project/files/ontologies/SequenceAligningOntologyv1b.owl";

    /**
     * Retorna as Subclasses de uma Classe da ontologia, caso exista. 
     * @param nameClass (nome da Classe)
     * @return String com as Subclasses
     */
    public String getSubClasses(String nameClass) { 
        OntModel ontModel = ModelFactory.createOntologyModel();
        ontModel.read(ONTOLOGY_URI);
               
        OntClass classOntology = ontModel.getOntClass(BASE_URI + nameClass);
        String subClasses = nameClass + "<BR>";
        
        //int num = 1;     
        //for(Iterator i = classOntology.listSubClasses(); i.hasNext() && num < 10; num++)
        for(int num = 1; num < 10; num++)
        {
            try{
                //OntClass Class = (OntClass) i.next(); 
                //String uriCompleta = Class.getURI();
                //String auxName[] = uriCompleta.split("#");
                //subClasses = subClasses + auxName[1] + "<BR>";
                //subClasses = subClasses + num + i.next().toString() + "<BR>";
                
                subClasses = subClasses + num + "<BR>";
            }
            catch(Exception e){
                subClasses = subClasses + "Falha<BR>";
            }
            //subClasses = subClasses + num + "<BR>";
        } 
        
        /*
        for(Iterator i = classOntology.listSubClasses(); i.hasNext();)
        {
            try{
                OntClass Class = (OntClass) i.next(); 
                String uriCompleta = Class.getURI();
                String auxName[] = uriCompleta.split("#");
                subClasses = subClasses + auxName[1] + "\n";
            }
            catch(Exception e){
                subClasses = subClasses + "Falha\n";
            }            
        }
        */
                
        return "<BR>" + subClasses;
    }
    
    /**
     *
     * @return
     */
    public String teste(){
        return "Ok";
    }
}
