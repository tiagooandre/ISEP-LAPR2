/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.model;

import java.util.List;

/**
 *
 * @author renan
 */
public class ParameterCategoryStore {   
    private final List<ParameterCategory> parameterCategoryList;
    
    /**
     * Creates a parameter category store that contains all categories registered
     * @param list The list containing the categories known by the Company
     */
    public ParameterCategoryStore(List<ParameterCategory> list){
        this.parameterCategoryList= list;
    }
    
    /**
     * Creates a parameter category store that contains all parameter categories registered
     * @param code Code used to identify a category
     * @param description The description of the added category
     * @param nhsId NHS id number for this category
     * @return A new parameter category
     */
    public ParameterCategory createParameterCategory(String code, String description, String nhsId) {
        return new ParameterCategory(code, description, nhsId);
    }
    
    /**
     * Validates the created parameter category
     * @param pc The parameter category to be validated
     * @return Validation if the parameter category does not already exists
     */
    public boolean validateParameterCategory(ParameterCategory pc) {
        if (pc == null)
            return false;
        return pcExists(this.parameterCategoryList, pc);
    }
    
    /**
     * Saves the parameter category if it is valid
     * @param pc The parameter category to be added to the list of parameter categories
     * @return true if the new parameter category was added successfully
     */
    public boolean saveParameterCategory(ParameterCategory pc) {
        if (!validateParameterCategory(pc))
            return false;
        return this.parameterCategoryList.add(pc);
    }
    
    /**
     * Checks if the category code is valid for creation
     * @param list List containing all known categories
     * @param pc The category to be validated
     * @return 
     */
    public boolean pcExists(List<ParameterCategory> list, ParameterCategory pc){
        for(ParameterCategory p : list){
            if(p.getCodePC().compareTo(pc.getCodePC())==0)
                return false;
        }
        return true;
    }
    
    /**
     * Returns the list of categories
     * @return the list of categories
     */
    public List<ParameterCategory> getParameterCategories(){
        return this.parameterCategoryList;
    }
    
    /**
     * Gets a ParameterCategory by its code
     * 
     * @param pcCode category's code
     * @return The ParameterCategory
     */
    public ParameterCategory getCategoryByCode(String pcCode){
        ParameterCategory pc = null;
        for(ParameterCategory c : this.parameterCategoryList){
            if(c.getCodePC().compareTo(pcCode)==0)
                pc = c;
        }
        return pc;
    }
}
