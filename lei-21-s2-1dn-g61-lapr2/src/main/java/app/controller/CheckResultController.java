package app.controller;

import app.domain.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.*;
/**
 *
 * @author Miguel Chen 1190897
 */
public class CheckResultController {
    /**
     * the TestValideStore is used to validate and save the test
     */
    private TestValideStore store1;

    /**
     * the company that validates the work
     */
    private Company company;
    /**
     * the test that is validated
     */
    private Test t;
    /**
     * the client which the test is corresponded
     */
    private Client c;


    /**
     * Creates a controller getting the Company information from App
     */
    public CheckResultController() throws IOException, ClassNotFoundException {
        this(App.getInstance().getCompany());
        this.store1 = this.company.getValidationStore();
    }

    /**
     * Creates a controller from the Company, having it as a parameter
     *
     * @param company
     */
    public CheckResultController(Company company) {
        this.company = company;
    }

    /**
     * sorts the list of clients by name or tin
     * @return client list sorted by Name or TIN
     * @throws IOException
     */
    public List<Client> sortList() throws IOException {

        this.store1 = this.company.getValidationStore();
        List<Test> list = this.store1.getTestsValids();
        List<Client> listC = new ArrayList<>();
        for (Test t : list){
            listC.add(t.getClient());
        }

        //this.c.sorting(listC);
        SortingAl sa = App.sort1();
        Collections.sort(listC,sa);



        return listC;


    }

    /**
     * shows the list of clients
     * @param cl client list
     */
    public void showSort(List<Client> cl){
        int ind = 0;

        for (Client c : cl) {

            out.println(ind + ")" + c.getName() + " : " + c.getTin());

            ind++;

        }
    }

    /**
     * gets clients test result using client
     * @param c client
     * @return clients test
     */
    public List<Test> getTestFromCL(Client c) {
        return c.getLstTestComplete();

    }

    /**
     * converts the list items into an String
     * @param cl list of client
     * @return list of client in String
     */
    public String convert(List<Client> cl){
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (Client c : cl){
            sb.append(i +"-"+c.getName() +" "+c.getTin()+"\n");
            i++;
        }
        return sb.toString();
    }

    /**
     * converts the list items into a String
     * @param clTest list of test from client
     * @return String of the items in the list
     */
    public String convert2(List<Test> clTest){

        StringBuilder sb = new StringBuilder();
        for (Test t : clTest){
            sb.append("Client Name: " + t.getClient().getName() +"\n"+

                    "Client TIN: " + t.getClient().getTin() +"\n"+

                    "Test Code: " + t.getCode() +"\n"+

                    "Test NHS code: " + t.getNHScode() + "\n" +

                    "Test Result: " + t.getResults().toString());

        }
        return sb.toString();
    }
    public int sizeMatters(List<Client> cl){
        return cl.size();
    }

    /**
     * Shows the Clients test in a format
     * @param clTest list of test of the client
     */
    public void showTest(List<Test> clTest){
        for (Test t : clTest) {

            out.println("Client Name: " + t.getClient().getName() +"\n"+

                    "Client TIN: " + t.getClient().getTin() +"\n"+

                    "Test Code: " + t.getCode() +"\n"+

                    "Test NHS code: " + t.getNHScode() + "\n" +

                    "Test Result: " + t.getResults().toString());

        }

    }

}
