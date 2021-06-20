/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.model;

import java.util.List;

/**
 *
 * @author Goncalo
 */
public class ParameterStore {
    
    
    //User Story 10: Create new Parameter
    /**
     *  List of Parameters available for the tests
     */
    private final List<Parameter> parameterList;
   
    
    /**
     * Parameter Store constructor 
     * @param list 
     */
    public ParameterStore(List<Parameter> list ){
        this.parameterList = list;
    }
    
    /**
     * @param code Code used to identify a parameter 
     * @param description Description of the parameter created 
     * @param category Category that the parameter fits in 
     * @return A new parameter 
     */
    public Parameter createParameter( String code, String description, ParameterCategory category){
        return new Parameter(code,description,category);
    }
    
    /**
     * @param p The parameter to be validated
     * @return Validation if the parameter does not already exists 
     */
    public boolean validateParameter(Parameter p){
        if (p == null)
            return false;
        return ! this.parameterList.contains(p);
    }
    
    /**
     * @param p The parameter to be added to the list of parameters
     * @return true if the new parameter was added successfully
     */
    public boolean saveParameter(Parameter p){
        if (!validateParameter(p))
            return false;
        return this.parameterList.add(p);
    }
    
    /**
     * Returns the list of parameters
     * @return the list of parameters
     */
    public List<Parameter> getParameters(){
        return this.parameterList;
    }
    
    public Parameter getParameterByCode(String pCode){
        Parameter p = null;
        for(Parameter param : this.parameterList){
            if(param.getCodeP().compareTo(pCode)==0)
                p=param;
        }
        return p;
    }
}
