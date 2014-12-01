/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.mapping.ontology;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Guilherme Martins
 */
public class OntologyRead {
    //private final String BASE_URI = "http://plscience.superdignus.com/SequenceAligningOntology#";
    //private final String ONTOLOGY_URI = "file:///E:/RepositoryGIT/collaborative-mapping/NetBeans_Project/files/ontologies/SequenceAligningOntologyv1b.owl";
    private String BASE_URI;
    private String ONTOLOGY_URI;

    
    /* TENTATIVA DE ACESSAR A ONTOLOGIA ONLINE - NÃO DEU CERTO*/
    //private final String ONTOLOGY_URI = "https://github.com/Guilherme-Martins/collaborative-mapping/tree/master/NetBeans_Project/files/ontologies/SequenceAligningOntologyv1b.owl";
    
    /**
     *
     * @return List of Strings with the ontology classes.
     */
    public ArrayList<String> getClasses() { 
        OntModel ontModel = ModelFactory.createOntologyModel();
        ontModel.read(ONTOLOGY_URI);

        ArrayList<String> classes = new ArrayList<>();
        
        for (Iterator i = ontModel.listClasses(); i.hasNext();){
            
            String uri = i.next().toString();
            String name[] = uri.split("#");
            
            if(name.length > 1)
                classes.add(name[1]);
        }
        
        return classes;
    }
    
    /**
     * Returns all subclasses of a ontology class, if any. 
     * @param nameClass - class name
     * @return List of String with the subclasses.
     */
    public ArrayList<String> getAllSubClasses(String nameClass) { 
        OntModel ontModel = ModelFactory.createOntologyModel();
        ontModel.read(ONTOLOGY_URI);
               
        OntClass classOntology = ontModel.getOntClass(BASE_URI + nameClass);
        ArrayList<String> subClasses = new ArrayList<>();
        
        for(Iterator i = classOntology.listSubClasses(); i.hasNext();)
        {
            OntClass Class = (OntClass) i.next(); 
            String uri = Class.getURI();
            String name[] = uri.split("#");
            subClasses.add(name[1]);                     
        }        
        return subClasses;
    }
    
    /**
     * Returns the subclasses of "Thing" class, if any.
     * @param nameClass
     * @return List of String with the "Thing" subclasses.
     */
    public String getSubClasses(String nameClass) { 
        OntModel ontModel = ModelFactory.createOntologyModel();
        ontModel.read(ONTOLOGY_URI);
               
        //OntClass classOntology = ontModel.getOntClass("http://www.w3.org/2002/07/owl#Thing");
        //ArrayList<String> subClasses = new ArrayList<>();
                       
        String queryString =                    
            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
            "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
            "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
            "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
            "PREFIX me: <" + BASE_URI + ">\n" +
            "SELECT ?subClass\n" +
            "WHERE {?subClass  rdfs:subClassOf me:" + nameClass + ".\n" +
            "}\n";

        Query query = QueryFactory.create(queryString);
        
        //Execute the query and obtain results
        QueryExecution qe = QueryExecutionFactory.create(query, ontModel);
        ResultSet results =  qe.execSelect();
        /*
        for(Iterator i = results; i.hasNext();)
        {
            OntClass Class = (OntClass) i.next(); 
            String uri = Class.getURI();
            String name[] = uri.split("#");
            subClasses.add(name[1]);                     
        }
        */
        //Output query results            
        String listIndividuals = ResultSetFormatter.asText(results);
        
        System.out.println(listIndividuals);
        
        return listIndividuals;
        //return subClasses;
    }
    
    public String getSubClasses() { 
        OntModel ontModel = ModelFactory.createOntologyModel();
        ontModel.read(ONTOLOGY_URI);
               
        //OntClass classOntology = ontModel.getOntClass("http://www.w3.org/2002/07/owl#Thing");
        //ArrayList<String> subClasses = new ArrayList<>();
                       
        String queryString =                    
            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
            "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
            "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
            "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
            "PREFIX me: <" + BASE_URI + ">\n" +
            "SELECT ?subClass\n" +
            "WHERE {?subClass  rdfs:subClassOf owl:Thing.\n" +
            "}\n";

        Query query = QueryFactory.create(queryString);
        
        //Execute the query and obtain results
        QueryExecution qe = QueryExecutionFactory.create(query, ontModel);
        ResultSet results =  qe.execSelect();
        /*
        for(Iterator i = results; i.hasNext();)
        {
            OntClass Class = (OntClass) i.next(); 
            String uri = Class.getURI();
            String name[] = uri.split("#");
            subClasses.add(name[1]);                     
        }
        */
        //Output query results            
        String listIndividuals = ResultSetFormatter.asText(results);
        
        System.out.println(listIndividuals);
        
        return listIndividuals;
        //return subClasses;
    }
    
    /**
     * Returns the individuals of a class if the class and the individuals exists.
     * @param nameClass (nome da Classe)
     * @return List of Strings with the class' individuals.
     */
    public ArrayList<String> getIndividuals(String nameClass) {
        OntModel ontModel = ModelFactory.createOntologyModel();
        ontModel.read(ONTOLOGY_URI);
               
        OntClass individuals = ontModel.getOntClass(BASE_URI + nameClass);
        ArrayList<String> listIndividuals = new ArrayList<>();
        
        for(Iterator i = individuals.listInstances();i.hasNext();)
        {
            String uri = i.next().toString();
            String individual[] = uri.split("#");
            
            if(individual.length > 1)
                listIndividuals.add(individual[1]);         
        }
        return listIndividuals;
    }
    
    public String getBaseURI() {
        OntModel ontModel = ModelFactory.createOntologyModel();
        ontModel.read(ONTOLOGY_URI);
        
        String baseURI = "";
        
        for (Iterator i = ontModel.listClasses(); i.hasNext();){
            
            String uri = i.next().toString();
            String name[] = uri.split("#");
            
            if(name.length > 1){
                baseURI = name[0]+"#";
                break;
            }
        }
                
        return baseURI;
    }
    
    /* PODE SER UZADO FUTURAMENTE */
    
    /* NÃO GERA ERRO, CONTUDO NÃO RETORNA RESULTADO. DEVE SER REPENSADO.
    public String getDatasIndividuals(String nameClass) {
        OntModel ontModel = ModelFactory.createOntologyModel();
        ontModel.read(ONTOLOGY_URI);
               
        String queryString =                    
            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
            "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
            "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
            "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
            "PREFIX me: <" + BASE_URI + ">\n" +
            "SELECT DISTINCT ?individual ?data ?value\n" +
            "WHERE {?data  rdfs:domain me:" + nameClass + ".\n" +
		"?subClass1 rdfs:subPropertyOf owl:topDataProperty.\n" +
		"?data rdfs:subPropertyOf ?subClass1.\n" +
		"?individual ?data ?value.\n" +
		"{{?individual  rdf:type me:" + nameClass + ".}\n" +
		"UNION\n" +
		"{?individual  rdf:type ?subClass2.\n" +
		"?subClass2 rdfs:subClassOf me:" + nameClass + ".}}\n" +
            "} ORDER BY ?individual\n";
        
        Query query = QueryFactory.create(queryString);
        
        // Execute the query and obtain results
        QueryExecution qe = QueryExecutionFactory.create(query, ontModel);
        ResultSet results =  qe.execSelect();
        
        // Output query results            
        String listIndividuals = ResultSetFormatter.asText(results);
        
        return listIndividuals;
    }
    */    

    /**
     * @return the BASE_URI
     */
    public String getBASE_URI() {
        return BASE_URI;
    }

    /**
     * 
     */
    public void setBASE_URI() {
        if(!ONTOLOGY_URI.isEmpty())
            this.BASE_URI = getBaseURI();
    }

    /**
     * @return the ONTOLOGY_URI
     */
    public String getONTOLOGY_URI() {
        return ONTOLOGY_URI;
    }

    /**
     * @param ONTOLOGY_URI the ONTOLOGY_URI to set
     */
    public void setONTOLOGY_URI(String ONTOLOGY_URI) {
        this.ONTOLOGY_URI = ONTOLOGY_URI;
    }
}
