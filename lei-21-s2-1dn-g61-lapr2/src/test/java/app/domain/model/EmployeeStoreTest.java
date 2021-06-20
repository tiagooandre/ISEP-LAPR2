package app.domain.model;

import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeStoreTest {

    @Test
    public void testvalidateEmployee1() {
        System.out.println("validateEmployee");
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        Employee emp = new Employee(or, "Miguel", "rua da saude", "12345678901", "map2001@iol.pt", "Hello");
        EmployeeStore es = new EmployeeStore();
        assertTrue(es.validateEmployee(emp));
    }

    @Test
    public void testvalidateEmployee2() {
        System.out.println("validateEmployee");
        Employee emp = null;
        EmployeeStore es = new EmployeeStore();
        assertFalse(es.validateEmployee(emp));
    }

    @Test
    public void testsaveEmployee1() {
        System.out.println("saveEmployee");
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        Employee emp = new Employee(or, "Miguel", "rua da saude", "12345678901", "map2001@iol.pt", "Hello");
        EmployeeStore es = new EmployeeStore();
        assertTrue(es.saveEmployee(emp));
    }

    @Test
    public void testsaveEmployee2() {
        System.out.println("saveEmployee");
        Employee emp = null;
        EmployeeStore es = new EmployeeStore();
        assertFalse(es.saveEmployee(emp));
    }

    @Test
    public void testvalidateEmployeeAttributes1() {
        System.out.println("validateEmployeeAttributes");
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        Employee emp = new Employee(or, "Miguel", "rua da saude", "12345678901", "map2001@iol.pt", "Hello");
        EmployeeStore es = new EmployeeStore();
        es.saveEmployee(emp);
        Employee emp2 = new Employee(or, "Miguel", "rua da saude", "12345678971", "map2002@iol.pt", "Hello");
        assertTrue(es.validateEmployeeAttributes(emp2));
    }

    @Test
    public void testremove1() {
        System.out.println("validateEmployeeAttributes - PhoneNumber is the same");
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        Employee emp = new Employee(or, "Miguel", "rua da saude", "12345678901", "map2001@iol.pt", "Hello");
        EmployeeStore es = new EmployeeStore();
        es.saveEmployee(emp);
        assertTrue(es.remove(emp));
    }

    @Test
    public void testremove2() {
        System.out.println("validateEmployeeAttributes - PhoneNumber is the same");
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        Employee emp = new Employee(or, "Miguel", "rua da saude", "12345678901", "map2001@iol.pt", "Hello");
        EmployeeStore es = new EmployeeStore();;
        assertFalse(es.remove(emp));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testvalidateEmployeeAttributes2() {
        System.out.println("validateEmployeeAttributes - Email is the same");
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        Employee emp = new Employee(or, "Miguel", "rua da saude", "12345678901", "map2001@iol.pt", "Hello");
        EmployeeStore es = new EmployeeStore();
        es.saveEmployee(emp);
        Employee emp2 = new Employee(or, "Miguel", "rua da saude", "12345678971", "map2001@iol.pt", "Hello");
        es.validateEmployeeAttributes(emp2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testvalidateEmployeeAttributes3() {
        System.out.println("validateEmployeeAttributes - PhoneNumber is the same");
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        Employee emp = new Employee(or, "Miguel", "rua da saude", "12345678901", "map2001@iol.pt", "Hello");
        EmployeeStore es = new EmployeeStore();
        es.saveEmployee(emp);
        Employee emp2 = new Employee(or, "Miguel", "rua da saude", "12345678901", "map2002@iol.pt", "Hello");
        es.validateEmployeeAttributes(emp2);
    }

    @Test
    public void testGetEmployeeList() {
        System.out.println("getEmployeeList()");

        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "Class");
        Employee emp = new Employee(or, "Miguel", "rua da saude", "12345678901", "map2001@iol.pt", "Hello");
        Employee emp2 = new Employee(or, "Miguello", "rua da saude", "98745678901", "map2001@iol.pt", "Hello");
        emp.setEmployeeID("Marisa Aguiar pereira");
        emp2.setEmployeeID("Marisa Aguiar pereira");

        List<Employee> list = new ArrayList<>();
        list.add(emp);
        list.add(emp2);

        EmployeeStore store = new EmployeeStore();
        store.saveEmployee(emp);
        store.saveEmployee(emp2);

        assertEquals(list, store.getEmployeeList());
    }

}