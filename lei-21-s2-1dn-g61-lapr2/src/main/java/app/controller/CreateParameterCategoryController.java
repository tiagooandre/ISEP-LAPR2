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
 * @author renan
 */
public class CreateParameterCategoryController {
    /**
     * The company that creates parameter categories
     */
    private Company company;
    /**
     * The parameter category that is created
     */
    private ParameterCategory pc;
    /**
     * The ParameterCategoryStore used to create and save the category
     */
    private ParameterCategoryStore store;
    /**
     * The ParameterCategoryStore used to list the parameters to be added to category
     */
    private ParameterStore store2;


    /**
     * Creates a controller getting the Company information from App
     */
    public CreateParameterCategoryController() throws IOException, ClassNotFoundException {
        this(App.getInstance().getCompany());
        this.store2 = this.company.getParameterStore();
    }
    
    /**
     * Creates a controller from the Company, having it as a parameter 
     * @param company The company responsible for knowing the categories 
     */
    public CreateParameterCategoryController(Company company) {
        this.company = company;
        this.pc = null;
    }
    
    /**
     * Creates a parameter category based on information given by the UI
     * @param code Code used to identify a category collected by the UI
     * @param description The description of the added category collected by the UI
     * @param nhsId NHS id number for this category collected by the UI
     * @return True if the new parameter category was added successfully to the company's database
     */
    public boolean createParameterCategory(String code, String description, String nhsId) {
        this.store = this.company.getParameterCategoryStore();    
        this.pc = this.store.createParameterCategory(code, description, nhsId);
        return this.store.validateParameterCategory(pc);
    }
    
    /**
     * Tells the parameter category store to save a parameter category
     * @return Validation if the parameter category does not already exists in the company
     */
    public boolean saveParameterCategory() {
        return this.store.saveParameterCategory(pc);
    }
    
    /**
     * Gets the list of categories known by the Company
     * @return All registered test types
     */
    public List<ParameterCategory> showAllParameterCategories(){
        return new ArrayList<>(this.store.getParameterCategories());
    }
    
    /**
     * Gets the list of parameters know by the Company
     * @return list of registered parameters 
     */
    public List<Parameter> parameterList(){
        this.store2 = this.company.getParameterStore();
        return new ArrayList<>(this.store2.getParameters());
    }
    
    /**
     * Adds a new parameter to the category
     * @param p Parameter to be added
     */
    public void fillParameterList(Parameter p){
            this.pc.addPCParameter(p);
    }
}