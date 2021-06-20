/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth.domain.model;

import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

/**
 *
 * @author Goncalo
 */
public class ListParameters implements Serializable{
    
    /**
     * List of Parameters
     */
    private final List<Parameter> lstParameters = new ArrayList<>();

    /**
     * Method to create a new test parameter.
     *
     * 
     * @param strDescription description of the parameter
     * @param category category of the parameter 
     * @return Parameter : new parameter with id, description and category
     */
    public Parameter newParameter( String code, String strDescription, ParameterCategory category) {
        return new Parameter( code,strDescription,category);
    }

    /**
     * Method to return the list of parameters.
     *
     * @return lstParameters: list of parameters
     */
    public List<Parameter> getParamters() {
        return this.lstParameters;
    }

   

    /**
     * Method to get a parameter by description passed through parameter.
     *
     * @param description: description of the parameter
     * @return cat: if the description exists or null: if the description doens't exists
     */
    public Parameter getParameterByDescription(String description) {
        for (Parameter cat : this.lstParameters) {
            if (cat.getDescriptionP().trim().equalsIgnoreCase(description.trim())) {
                return cat;
            }
        }
        return null;
    }

    
    /**
     * Method to get a parameter by an id passed through parameter.
     *
     * @param category: category of the parameter
     * @return p: if the category exists or null: if the category doens't exists
     */
    public Parameter getParameterByCategory(ParameterCategory category){
        for(Parameter p : this.lstParameters){
            if(p.getCategoryP().getCodePC().compareTo(category.getCodePC())==0){
                return p;
            }
        }
        return null;
    }
    /**
     * Method to register a Parameter.
     *
     * @param oParameter: parameter to register
     * @return true: if the parameter is added to list of parameters or false: if
     * the parameter isn't valid
     *
     */
    public boolean registerParameter(Parameter oParameter) {
        if (this.validateParameter(oParameter)) {
            return this.lstParameters.add(oParameter);
        } else {
            out.println("Parameter " + oParameter.toString() + " already exists");
            return false;
        }
    }

    /**
     * Method to validate a parameter.
     *
     * @param oParameter: parameter to validate
     * @return return true: if the parameter is valid or false: if the parameter
     * isn't valid
     */
    public boolean validateParameter(Parameter oParameter) {
        boolean bRet = true;
        for (Parameter cat : this.lstParameters) {
            if (cat.getDescriptionP().equalsIgnoreCase(oParameter.getDescriptionP())) {
                bRet = false;
            }
        }
        return bRet;
    }
}
