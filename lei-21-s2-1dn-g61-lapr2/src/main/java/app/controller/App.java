package app.controller;

import app.domain.model.*;
import app.domain.shared.Constants;
import auth.AuthFacade;
import auth.UserSession;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class App {

    private Company company;
    private AuthFacade authFacade;
    private static final String PWD = "12345";
    private static final String PATH = "resources\\config.properties";

    private App() throws IOException, ClassNotFoundException {
        Properties props = getProperties();
        this.company = new Company(props.getProperty(Constants.PARAMS_COMPANY_DESIGNATION));
        this.authFacade = this.company.getAuthFacade();
        bootstrap();
    }

    public Company getCompany()
    {
        return this.company;
    }


    public UserSession getCurrentUserSession()
    {
        return this.authFacade.getCurrentUserSession();
    }

    public boolean doLogin(String email, String pwd)
    {
        return this.authFacade.doLogin(email,pwd).isLoggedIn();
    }

    public void doLogout()
    {
        this.authFacade.doLogout();
    }

     private Properties getProperties()
    {
        Properties props = new Properties();

        // Add default properties and values
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "Many Labs");


        // Read configured values
       try(InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);)
        {
            props.load(in);
        }
        catch(IOException ex) {

        }
        return props;
    }


    private void bootstrap()
    {
        //User Roles
        this.authFacade.addUserRole(Constants.ROLE_ADMIN,Constants.ROLE_ADMIN);
        this.authFacade.addUserRole(Constants.ROLE_CLINICALCHEMISTRYTECHNOLOGIST,Constants.ROLE_CLINICALCHEMISTRYTECHNOLOGIST);
        this.authFacade.addUserRole(Constants.ROLE_SPECIALISTDOCTOR,Constants.ROLE_SPECIALISTDOCTOR);
        this.authFacade.addUserRole(Constants.ROLE_LABORATORYCOORDINATOR,Constants.ROLE_LABORATORYCOORDINATOR);
        this.authFacade.addUserRole(Constants.ROLE_MEDICALLABTECHNICIAN,Constants.ROLE_MEDICALLABTECHNICIAN);
        this.authFacade.addUserRole(Constants.ROLE_RECEPTIONIST,Constants.ROLE_RECEPTIONIST);
        this.authFacade.addUserRole(Constants.ROLE_CLIENT,Constants.ROLE_CLIENT);

        this.authFacade.addUserWithRole("Main Specialist Doctor","sp@ola.pt", PWD,Constants.ROLE_SPECIALISTDOCTOR);
        this.authFacade.addUserWithRole("Main Administrator", "adm@ola.pt", PWD,Constants.ROLE_ADMIN);
        this.authFacade.addUserWithRole("Main Recepcionist","rep@ola.pt", PWD,Constants.ROLE_RECEPTIONIST);
        this.authFacade.addUserWithRole("Main Lab Coordinator","labc@ola.pt", PWD,Constants.ROLE_LABORATORYCOORDINATOR);
        this.authFacade.addUserWithRole("Main Medical Lab Technician","mlt@ola.pt", PWD,Constants.ROLE_MEDICALLABTECHNICIAN);
        this.authFacade.addUserWithRole("Main Clinical Chemistry Technologist","cct@ola.pt", PWD,Constants.ROLE_CLINICALCHEMISTRYTECHNOLOGIST);
    }

    // Extracted from https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static App singleton = null;
    public static App getInstance() throws IOException, ClassNotFoundException {
        if(singleton == null)
        {
            synchronized(App.class)
            {
                singleton = new App();
            }
        }
        return singleton;
    }

    public static ExternalModule getBloodAPI() throws IOException {
        Properties props = new Properties();

        try(FileInputStream in = new FileInputStream("resources/config.properties")){
            props.load(in);
        }catch(IOException ex) {
            ex.printStackTrace();
        }

        String value = props.getProperty("bloodAPI");
        ExternalModule em = null;

        if(value.compareTo("1")==0)
            em = new ExternalModuleAdapter2();
        if(value.compareTo("2")==0)
            em = new ExternalModuleAdapter3();

        return em;
    }

    public static ExternalModuleBarcode getBarcodeAPI() throws IOException {
        Properties props = new Properties();

        try(FileInputStream in = new FileInputStream("resources/config.properties")){
            props.load(in);
        }catch(IOException ex) {
            ex.printStackTrace();
        }

        String value = props.getProperty("barcodeAPI");
        ExternalModuleBarcode em = null;

        if(value.compareTo("1")==0)
            em = new GenerateBarcode();

        return em;
    }
   public static SortingAl sort1() throws IOException{
       Properties props = new Properties();

       try(FileInputStream in = new FileInputStream("resources/config.properties")){
           props.load(in);
       }catch(IOException ex) {
           ex.printStackTrace();
       }

       String value = props.getProperty("sort");
       SortingAl em = null;

       if(value.compareTo("1")==0)
           em = new SortingAlName();
       if(value.compareTo("2")==0)
           em = new SortingAlTIN();

       return em;
   }
   public static SortingDateValid sortD() throws IOException{
       Properties props = new Properties();

       try(FileInputStream in = new FileInputStream("resources/config.properties")){
           props.load(in);
       }catch(IOException ex) {
           ex.printStackTrace();
       }

       String value = props.getProperty("sortDate");
       SortingDateValid em = null;

       if(value.compareTo("1")==0)
           em = new SortingDateValid();

       return em;
   }
   }


