package app.domain.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void setName() {
        System.out.println("setName");
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        Employee emp = new Employee(or, "Miguel", "rua da saude", "12345678901", "map2001@iol.pt", "Hello");
        emp.setNameEmployee("Marisa");
        assertEquals("Marisa", emp.getNameEmployee());
    }

    @Test
    public void setAddress() {
        System.out.println("setAddress");
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        Employee emp = new Employee(or, "Miguel", "rua da saude", "12345678901", "map2001@iol.pt", "Hello");
        emp.setAddressEmployee("rua da felicidade");
        assertEquals("rua da felicidade", emp.getAddressEmployee());
    }

    @Test
    public void setPhoneNumber() {
        System.out.println("setPhoneNumber");
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        Employee emp = new Employee(or, "Miguel", "rua da saude", "12345678901", "map2001@iol.pt", "Hello");
        emp.setPhoneNumberEmployee("21212121213");
        assertEquals("21212121213", emp.getPhoneNumberEmployee());
    }

    @Test
    public void setCodeSOC() {
        System.out.println("setCodeSOC");
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        Employee emp = new Employee(or, "Miguel", "rua da saude", "12345678901", "map2001@iol.pt", "Hello");
        emp.setCodeSOCEmployee("adeus");
        assertEquals("adeus", emp.getCodeSOCEmployee());
    }

    @Test
    public void setEmployeeID() {
        System.out.println("setEmployeeID");
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        Employee emp = new Employee(or, "Miguel", "rua da saude", "12345678901", "map2001@iol.pt", "Hello");
        Employee emp2 = new Employee(or, "Miguello", "rua da saude", "98745678901", "map2001@iol.pt", "Hello");
        emp.setEmployeeID("Marisa Aguiar pereira");
        emp2.setEmployeeID("Marisa Aguiar pereira");
        assertEquals(emp.getEmployeeID(), emp2.getEmployeeID());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testName1() {
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        Employee emp = new Employee(or, "MiguelMiguelMiguelMiguelMiguelMiguelMiguel", "rua da saude", "12345678901", "map2001@iol.pt", "Hello");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testName2() {
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        Employee emp = new Employee(or, null, "rua da saude", "12345678901", "map2001@iol.pt", "Hello");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddress() {
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        Employee emp = new Employee(or, "Miguel", null, "12345678901", "map2001@iol.pt", "Hello");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPhoneNumber1() {
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        Employee emp = new Employee(or, "Miguel", "rua da saude", "12345678901212121221", "map2001@iol.pt", "Hello");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPhoneNumber2() {
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        Employee emp = new Employee(or, "Miguel", "rua da saude", null, "map2001@iol.pt", "Hello");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmail1() {
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        Employee emp = new Employee(or, "Miguel", "rua da saude", "12345678901", null, "Hello");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmail2() {
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        Employee emp = new Employee(or, "Miguel", "rua da saude", "12345678901", "jude@", "Hello");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCodeSOC1() {
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        Employee emp = new Employee(or, "Miguel", "rua da saude", "12345678901", "map2001@iol.pt", "Hello world");
    }


    @Test(expected = IllegalArgumentException.class)
    public void testCodeSOC2() {
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        Employee emp = new Employee(or, "MiguelMiguelMiguelMiguelMiguelMiguelMiguel", "rua da saude", "12345678901", "map2001@iol.pt", "Hey");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCodeSOC3() {
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        Employee emp = new Employee(or, "MiguelMiguelMiguelMiguelMiguelMiguelMiguel", "rua da saude", "12345678901", "map2001@iol.pt", null);
    }

    /*
    @Test
    public void testGetEmployeeID() {
        System.out.println("getEmployeeID()");

        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        Employee emp = new Employee(or, "Tiago Pinto", "rua da saude", "12345678901", "map2001@iol.pt", "Hello");
        Employee emp2 = new Employee(or, "Tiago Pinto", "rua da fac", "12345672901", "map2000@iol.pt", "Hello!");

        String expRes = "TP00000";
        String expRes2 = "TP00001";

        assertEquals(expRes, emp.getEmployeeID());
        assertEquals(expRes2, emp2.getEmployeeID());
    }*/

}