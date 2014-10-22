/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.mapping.feature;

/**
 *
 * @author Guilherme Martins
 */
public class FileFeature {
    
    private FeatureStruct featureStruct = new FeatureStruct();
    private FeatureRead featureRead = new FeatureRead();
    private FeatureCreate featureCreat = new FeatureCreate();

    /**
     * @return the featureStruct
     */
    public FeatureStruct getFeatureStruct() {
        return featureStruct;
    }

    /**
     * @param featureStruct the featureStruct to set
     */
    public void setFeatureStruct(FeatureStruct featureStruct) {
        this.featureStruct = featureStruct;
    }

    /**
     * @return the featureRead
     */
    public FeatureRead getFeatureRead() {
        return featureRead;
    }

    /**
     * @param featureRead the featureRead to set
     */
    public void setFeatureRead(FeatureRead featureRead) {
        this.featureRead = featureRead;
    }

    /**
     * @return the featureCreat
     */
    public FeatureCreate getFeatureCreat() {
        return featureCreat;
    }

    /**
     * @param featureCreat the featureCreat to set
     */
    public void setFeatureCreat(FeatureCreate featureCreat) {
        this.featureCreat = featureCreat;
    }
    
    
    
}
