/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.mapping.suggestion;

import br.ufjf.mapping.feature.FileFeature;
import br.ufjf.mapping.map.FileMapping;
import br.ufjf.mapping.ontology.FileOntology;

/**
 *
 * @author Guilherme Martins
 */
public class Suggestion {
    private FileMapping fileMapping = new FileMapping();
    private FileFeature fileFeature = new FileFeature();
    private FileOntology fileOntology = new FileOntology();
    private SuggestionPairText suggestionPairText = new SuggestionPairText();

    /**
     * @return the fileMapping
     */
    public FileMapping getFileMapping() {
        return fileMapping;
    }

    /**
     * @param fileMapping the fileMapping to set
     */
    public void setFileMapping(FileMapping fileMapping) {
        this.fileMapping = fileMapping;
    }

    /**
     * @return the fileFeature
     */
    public FileFeature getFileFeature() {
        return fileFeature;
    }

    /**
     * @param fileFeature the fileFeature to set
     */
    public void setFileFeature(FileFeature fileFeature) {
        this.fileFeature = fileFeature;
    }

    /**
     * @return the fileOntology
     */
    public FileOntology getFileOntology() {
        return fileOntology;
    }

    /**
     * @param fileOntology the fileOntology to set
     */
    public void setFileOntology(FileOntology fileOntology) {
        this.fileOntology = fileOntology;
    }

    /**
     * @return the suggestionPairText
     */
    public SuggestionPairText getSuggestionPairText() {
        return suggestionPairText;
    }

    /**
     * @param suggestionPairText the suggestionPairText to set
     */
    public void setSuggestionPairText(SuggestionPairText suggestionPairText) {
        this.suggestionPairText = suggestionPairText;
    }
    
}