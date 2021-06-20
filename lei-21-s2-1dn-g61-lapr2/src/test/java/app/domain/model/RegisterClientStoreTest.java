package app.domain.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RegisterClientStoreTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createClient() {
        System.out.println("createClient");
        String name="Joana";
        String cc = "1234567890123456";
        String birth = "18/05/2001";
        String nhsid = "1234567890";
        String tin = "1234567890";
        String phone = "12345678901";
        String sex = "Female";
        String email = "contribute@geeksforgeeks.org";

        List<Client> list=null;
        RegisterClientStore instance = new RegisterClientStore(list);
        Client cl = new Client("Joana","1234567890123456","18/05/2001","1234567890","1234567890","contribute@geeksforgeeks.org","12345678901","Female");
        Client result = instance.createClient(name,cc,birth,nhsid,tin,email,phone,sex);

        assertEquals(0, result.toString().compareTo(cl.toString()));
    }

    @Test
    public void createClient2() {
        System.out.println("createClient");
        String name="Joana";
        String cc = "1234567890123456";
        String birth = "18/05/2001";
        String nhsid = "1234567890";
        String tin = "1234567890";
        String phone = "12345678901";
        String email = "contribute@geeksforgeeks.org";

        List<Client> list=null;
        RegisterClientStore instance = new RegisterClientStore(list);
        Client cl = new Client("Joana","1234567890123456","18/05/2001","1234567890","1234567890","contribute@geeksforgeeks.org","12345678901");
        Client result = instance.createClient(name,cc,birth,nhsid,tin,email,phone);

        assertEquals(0, result.toString().compareTo(cl.toString()));
    }

    /**
     * Test of validateClient method, of class ResgisterClientStore, cl is null
     */
    @Test
    public void validateClient() {
        System.out.println("validateClient");

        List<Client> list = null;
        RegisterClientStore rc = new RegisterClientStore(list);
        Client cl = null;

        assertFalse(rc.validateClient(cl));
    }
    /**
     * Test of createClient method, of class RegisterClientStore, c not valid
     */
    @Test
    public void testValidateClient2() {
        System.out.println("validateClient");

        List<Client> list = new ArrayList<>();
        RegisterClientStore rc = new RegisterClientStore(list);
        Client c = new Client("Andre Silva", "3728392947236251", "23/07/1990", "4637893063", "7546678433", "andre@gmail.com", "83627830462", "Male");
        list.add(c);

        assertFalse(rc.validateClient(c));
    }
    /**
     * Test of createClient method, of class RegisterClientStore, c valid
     */
    @Test
    public void testValidateClient3() {
        System.out.println("validateClient");

        List<Client> list = new ArrayList<>();
        RegisterClientStore rc = new RegisterClientStore(list);
        Client c = new Client("Ruben Silva", "3427592947236251", "23/03/1990", "4634593063", "7539678433", "ruben@gmail.com", "83345898742", "Female");
        list.add(c);

        assertFalse(rc.validateClient(c));
    }
    /**
     * Test of saveClient method, of class RegisterClientStore, cl valid
     */
    @Test
    public void saveClient() {
        System.out.println("saveClient");

        List<Client> list = new ArrayList<>();
        RegisterClientStore rc = new RegisterClientStore(list);
        Client c = new Client("Andre Silva", "3728392947236251", "23/07/1990", "4637893063", "7546678433", "andre@gmail.com", "83627830462", "Male");

        assertTrue(rc.saveClient(c));
    }
    /**
     * Test of saveClinical method, of class ResgisterClinicalStore, cl not valid
     */
    @Test
    public void saveClient2() {
        System.out.println("saveClient");

        List<Client> list = new ArrayList<>();
        RegisterClientStore rc = new RegisterClientStore(list);
        Client c = new Client("Ruben Silva", "3427592947236251", "23/03/1990", "4634593063", "7539678433", "ruben@gmail.com", "83345898742", "Female");
        list.add(c);

        assertFalse(rc.saveClient(c));
    }
    
    @Test
    public void testGetClients() {
        System.out.println("getClients");

        List<Client> expected = new ArrayList<>();
        RegisterClientStore rc = new RegisterClientStore(expected);
        Client c = new Client("Ruben Silva", "3427592947236251", "23/03/1990", "4634593063", "7539678433", "ruben@gmail.com", "83345898742", "Female");
        expected.add(c);

        List<Client> result = rc.getClients();
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testGetClientById() {
        System.out.println("getClientById");

        List<Client> cList = new ArrayList<>();
        RegisterClientStore rc = new RegisterClientStore(cList);
        Client expected = new Client("Ruben Silva", "3427592947236251", "23/03/1990", "4634593063", "7539678433", "ruben@gmail.com", "83345898742", "Female");
        cList.add(expected);
        
        Client result = rc.getClientByTIN("7539678433");
        
        assertEquals(expected, result);

        Client result2 = rc.getClientByTIN("7533478433");

        assertNull(result2);
    }

    @Test
    public void testGetClientByEmail() {
        System.out.println("getClientByEmail");

        List<Client> cList = new ArrayList<>();
        RegisterClientStore rc = new RegisterClientStore(cList);
        Client expected = new Client("Ruben Silva", "3427592947236251", "23/03/1990", "4634593063", "7539678433", "ruben@gmail.com", "83345898742", "Female");
        cList.add(expected);

        Client result = rc.getClientByEmail("ruben@gmail.com");

        assertEquals(expected, result);

        Client result2 = rc.getClientByEmail("ruben34@gmail.com");

        assertNull(result2);
    }
}