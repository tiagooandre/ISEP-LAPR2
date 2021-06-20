package app.controller;

import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.model.RegisterClientStore;
import auth.domain.model.Email;
import auth.domain.model.Password;

import java.io.IOException;

public class ClientInformationController {
    /**
     * The company that knows the tests
     */
    private final Company company;

    /**
     * Client who do the test
     */
    private Client client;


    /**
     * The client store to get the client
     */
    private RegisterClientStore store;

    /**
     * Creates a controller getting the Company information from App
     */
    public ClientInformationController() throws IOException, ClassNotFoundException {this(App.getInstance().getCompany());}

    /**
     * Creates a controller
     */
    public ClientInformationController(Company company){
        this.company=company;
    }


    /**
     * this method return client by email, from the login
     * @return client by email
     */
    public void getClient(){
        this.store=this.company.getClientStore();
        this.client = this.store.getClientByEmail(this.company.getAuthFacade().getCurrentUserSession().getUserId().toString());
    }

    /**
     * Gets the current user data
     *
     * @return String with all the attributes from teh client
     */
    public String clientData(){
        String p = this.company.getAuthFacade().getCurrentUserSession().getUserPassword().passString();
        return this.client.clientData(p);
    }

    /**
     * Changes an attribute
     *
     * @param i The attribute to be changed
     * @param info The new attribute
     */
    public void changeData(int i, String info){
        switch(i){
            case 1: this.client.setName(info);
                    break;

            case 2: this.client.setBirth(info);
                    break;

            case 3: this.client.setNhsid(info);
                    break;

            case 4: this.client.setPhonenumber(info);
                    break;

            case 5: Email e = new Email(info);
                    this.client.setEmail(e);
                    this.company.getAuthFacade().getCurrentUserSession().changeEmail(e);
                    break;

            case 6: this.client.setSex(info);
                break;

            case 7:
                Password p = new Password(info);
                this.company.getAuthFacade().getCurrentUserSession().changePassword(p);
                break;

            default:
                break;
        }
    }

}
