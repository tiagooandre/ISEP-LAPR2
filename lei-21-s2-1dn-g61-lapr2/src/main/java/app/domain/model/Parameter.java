/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.model;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 *
 * @author Goncalo
 */
public class Parameter implements Serializable {
    
    private String code;
    private String description;
    private ParameterCategory category;
    
    /**
     *
     * @param description The description of the added parameter
     * @param category The category the parameter fits in 
     */
    public Parameter(String code, String description, ParameterCategory category) {
        checkCodeRules(code);
        checkDescriptionRules(description);
       this.code = code;
        this.description = description;
        this.category = category;
    }
    
    /**
     * 
     * @param code Code must have 4 to 8 chars
     */
    private void checkCodeRules(String code) {
        if (StringUtils.isBlank(code))
            throw new IllegalArgumentException("Code cannot be blank.");
        if ( (code.length() < 4) || (code.length() > 8))
            throw new IllegalArgumentException("Code must have 4 to 8 chars.");
    }
    
    /**
     * 
     * @param description Description must have 1 to 40 chars
     */
    private void checkDescriptionRules(String description){
        
        if ( (description.length() < 1) || (description.length() > 40))
            throw new IllegalArgumentException("Description must have 1 to 40 chars.");
        if (StringUtils.isBlank(description))
            throw new IllegalArgumentException("Code cannot be blank.");
    }
    
   
    /**
     * 
     * @param description New description for this parameter 
     */
    public void setDescriptionP(String description){
        checkDescriptionRules(description);
        this.description=description;
    }

    /**
     * return this parameter's code 
    */
    public String getCodeP() {
        return code;
    }

    /**
     * New code to this parameter 
     * @param code 
     */
    public void setCodeP(String code) {
        this.code = code;
    }

    
    /**
     * @return This parameter's category 
     */
    public ParameterCategory getCategoryP() {
        return category;
    }

    /**
     * @param category New category for this parameter  
     */
    public void setCategoryP(ParameterCategory category) {
        this.category = category;
    }
    
    
    /**
     * 
     * @return This parameter category's description
     */
    public String getDescriptionP(){
        return this.description;
    }
   
    
    /**
     * 
     * @return This parameter category's attributes information
     */
    @Override
    public String toString(){
        return "Parameter \n" + "Code: " + this.code + "   Description: " + this.description +
                "  Category id: " + this.category.getCodePC();
    }
    
    

}
