/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.domain.model.Company;
import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.domain.model.ParameterCategoryStore;
import app.domain.model.ParameterStore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Goncalo
 */
public class CreateParameterController {

    /**
     * The company that creates parameters
     */
    private Company company;
    /**
     * The parameter that is created
     */
    private Parameter p;
    /**
     * The ParameterCategoryStore is used to list categories that parameter uses to categorise itself
     */
    private ParameterCategoryStore store;
    /**
     * The ParameterStore that is used to create and save the parameter
     */
    private ParameterStore store2;
    /**
     * Creates a controller getting the Company information from App
     */
    public CreateParameterController() throws IOException, ClassNotFoundException {
        this(App.getInstance().getCompany());
    }
    
    /**
     * Creates a controller from the Company, having it as a parameter
     * @param company The company responsible for knowing the categories 
     */
    public CreateParameterController(Company company) {
        this.company = company;
        this.p = null;
    }
    
    /**
     *
     * @param code The code of the added parameter
     * @param description The description of the added category collected by the UI
     * @param category of this parameter collected by the UI
     * @return True if the new parameter category was added successfully to the company's database
     */
    public boolean createParameter( String code, String description, ParameterCategory category) {
       this.store2 = this.company.getParameterStore();
       this.p = this.store2.createParameter(code, description, category);
       category.addPCParameter(this.p);
       return this.store2.validateParameter(p);
    }
    
    /**
     * 
     * @return Validation if the parameter category does not already exists in the company
     */
    public boolean saveParameter() {
        return this.store2.saveParameter(p);
    }

     /**
     * 
     * @return Company's list of parameter categories
     */
    public List<ParameterCategory> getParameterCatergoryList(){
        this.store = this.company.getParameterCategoryStore();
        return new ArrayList<>(this.store.getParameterCategories());
    }
    
    
    /**
     * 
     * @param code
     * @return the category that is identified by the code passed by parameter
     */
    public ParameterCategory getCategoryByCode(String code) {
        ParameterCategory cat1 = new ParameterCategory("12345","ddd","12345");
        this.store = this.company.getParameterCategoryStore();
        for(ParameterCategory category : this.store.getParameterCategories()){
            if(category.getCodePC().compareTo(code)==0){
                cat1 = category;
            }
        }
        return cat1;
    }
    
    
     /**
     * 
     * @return list of registered parameters 
     */
    public List<Parameter> parameterList(){
        this.store2 = this.company.getParameterStore();
        return new ArrayList<>(this.store2.getParameters());
    }
    
  
}
