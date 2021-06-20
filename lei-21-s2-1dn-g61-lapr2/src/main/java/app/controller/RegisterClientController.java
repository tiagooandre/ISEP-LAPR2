package app.controller;

import app.domain.model.*;
import app.domain.shared.Constants;
import auth.domain.model.Email;
import auth.domain.model.User;

import java.io.IOException;
import java.util.Map;

public class RegisterClientController {
    /**
     * the company that registers client
     */
    private Company company;
    /**
     * thr RgesterClientStore that creates and saves the registered client
     */
    private RegisterClientStore store;
    /**
     * the client that is registered
     */
    private Client cl;
    /**
     * the user that is created using the client
     */
    private User user;
    /**
     * email from client used to send a email to the client
     */
    private Email e;
    /**
     * password that is created randomly for the user
     */
    public static final String PSW = GeneratePassword.generatePassword();

    /**
     * Creates a controller getting the Company information from App
     */
    public RegisterClientController() throws IOException, ClassNotFoundException {
        this(App.getInstance().getCompany());
    }
    /**
     *Creates a controller from the Company, having it as a parameter
     * @param company The company responsible for knowing the test types
     */
    public RegisterClientController (Company company) {
        this.company = company;
        this.cl = null;
        this.user=new User();
        this.e=new Email();
    }

    /**
     * @param name
     * @param cc
     * @param birth
     * @param nhsid
     * @param tin
     * @param email
     * @param phonenumber
     * @param sex
     * @return Client already validated
     */
    public boolean createCliente(String name, String cc, String birth, String nhsid, String tin, String email, String phonenumber, String sex)  {
        this.store = this.company.getClientStore();
        this.cl = this.store.createClient(name,cc,birth,nhsid,tin,email,phonenumber,sex);
        return this.store.validateClient(cl);
    }
    /**
     * @return true if the client was saved successfully
     */
    public boolean saveClient() {
        if (this.company.getAuthFacade().addUserWithRole(this.cl.getName(), this.cl.getEmail(), PSW, Constants.ROLE_CLIENT)) {
            this.user.addUserMap(PSW, cl);
            return this.store.saveClient(cl);
        }
        return false;
    }

    /**
     * @return Clients
     */
   public Map<String, Client> showAllUser(){
      return this.user.getUserMap();
   }

    /**
     *sends eamil with the message
     * @param email
     * @throws IOException
     */
    public void sendEmail (String email) throws IOException {
        String message =  "Hello. Your email is:"+ email +"\n" +
                "Your registration was successful and you can now start using the system.\n" +
                "Your password to login is as follows: " + PSW +"\n" +
                "Thank you, best regards.";
        EmailNotification.sendEmailToClient(message);
    }

    /**
     * @param name
     * @param cc
     * @param birth
     * @param nhsid
     * @param tin
     * @param email
     * @param phone
     * @return Client already validated
     */
    public boolean createCliente(String name, String cc, String birth, String nhsid, String tin, String email, String phone) {
        this.store = this.company.getClientStore();
        this.cl = this.store.createClient(name,cc,birth,nhsid,tin,email,phone);
        return this.store.validateClient(cl);
    }

}
