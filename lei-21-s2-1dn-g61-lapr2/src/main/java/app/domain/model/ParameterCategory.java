/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author renan
 */
public class ParameterCategory implements Serializable{
    /**
     * category code
     */
    private String code;
    /**
     * category description
     */
    private String description;
    /**
     * category nhs id
     */
    private String nhsId;
    /**
     * list of parameters
     */
    private final List<Parameter> pcParameters = new ArrayList<>();
    
    /**
     * Creates an instance of parameter category
     * @param code Code used to identify a category
     * @param description The description of the added category
     * @param nhsId NHS id number for this category
     */
    public ParameterCategory(String code, String description, String nhsId) {
        checkCodeRulesPC(code);
        checkDescriptionRulesPC(description);
        checkNHSRulesPC(nhsId);
        this.code = code;
        this.description = description;
        this.nhsId = nhsId;
    }
    
    /**
     * Check that code is not empty and has 4 to 8 chars
     * @param code Code must have 4 to 8 chars
     */
    private void checkCodeRulesPC(String code) {
        if ( (code.length() < 4) || (code.length() > 8))
            throw new IllegalArgumentException("Code must have 4 to 8 chars.");
        if (StringUtils.isBlank(code))
            throw new IllegalArgumentException("Code cannot be blank.");
    }
    
    /**
     * Check that description is not empty and has 1 to 40 chars
     * @param description Description must have 1 to 40 chars
     */
    private void checkDescriptionRulesPC(String description){
        if ( (description.length() < 1) || (description.length() > 40))
            throw new IllegalArgumentException("Description must have 1 to 40 chars.");
        if (StringUtils.isBlank(description))
            throw new IllegalArgumentException("Description cannot be blank.");
    }
    
    /**
     * Check that code is not empty and has 4 to 8 chars
     * @param nhs Code must have 4 to 8 chars
     */
    private void checkNHSRulesPC(String nhs) {
        if ( (nhs.length() < 4) || (nhs.length() > 8))
            throw new IllegalArgumentException("NHS id must have 4 to 8 chars.");
        if (StringUtils.isBlank(nhs))
            throw new IllegalArgumentException("NHS id cannot be blank.");
    }
    
    /**
     * Changes the parameter category code if it is valid
     * @param code New code for this parameter category
     */
    public void setCodePC(String code){
        checkCodeRulesPC(code);
        this.code=code;
    }
    /**
     * Changes the parameter category code if it is valid
     * @param description New description for this parameter category
     */
    public void setDescriptionPC(String description){
        checkDescriptionRulesPC(description);
        this.description=description;
    }
    /**
     * Changes the parameter category NHS id
     * @param nhs New NHS id for this parameter category
     */
    public void setNHSPC(String nhs){
        checkNHSRulesPC(nhs);
        this.nhsId=nhs;
    }
    
    /**
     * Gets the parameter category code
     * @return This parameter category's code
     */
    public String getCodePC(){
        return this.code;
    }
    /**
     * Gets the parameter category description
     * @return This parameter category's description
     */
    public String getDescriptionPC(){
        return this.description;
    }
    /**
     * Gets the parameter category NHS id
     * @return This parameter category's NHS id
     */
    public String getNHSPC(){
        return this.nhsId;
    }
    /**
     * Gets the list of parameters presented under this category
     * @return ll parameters used in this test type
     */
    public List<Parameter> getParameters(){
        return this.pcParameters;
    }
    /**
     * Adds a new parameter under this category
     * @param p The new parameter for this test type
     */
    public void addPCParameter(Parameter p){
        this.pcParameters.add(p);
    }
    
    /**
     * Prints a string containing information concerning the category
     * @return This parameter category's attributes information
     */
    @Override
    public String toString(){
        return String.format("Parameter Category #%s\n"
                           + "%s\n"
                           + "NHS id:%s", this.code, this.description, this.nhsId);
    }
    
    
}