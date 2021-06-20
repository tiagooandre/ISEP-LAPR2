package app.controller;

import app.domain.model.Company;

import java.io.IOException;

public class SerialController {
    /**
     * The company that knows the objects
     */
    private Company company;

    /**
     * Creates a controller getting the Company information from App
     */
    public SerialController() throws IOException, ClassNotFoundException {
        this(App.getInstance().getCompany());
    }

    /**
     * Creates a controller from the Company, having it as a parameter
     * @param company The company responsible for knowing the categories
     */
    public SerialController(Company company) {
        this.company = company;
    }

    public void serializeList() throws IOException {
        this.company.serializeList();
    }
}
