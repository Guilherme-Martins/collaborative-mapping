/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.mapping.ontology;

/**
 *
 * @author Guilherme Martins
 */
public class FileOntology {
    
   private OntologyRead ontologyRead = new OntologyRead();

    /**
     * @return the ontologyRead
     */
    public OntologyRead getOntologyRead() {
        return ontologyRead;
    }

    /**
     * @param ontologyRead the ontologyRead to set
     */
    public void setOntologyRead(OntologyRead ontologyRead) {
        this.ontologyRead = ontologyRead;
    }
}
