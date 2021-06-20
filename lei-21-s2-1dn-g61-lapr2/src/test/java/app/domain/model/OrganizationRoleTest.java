package app.domain.model;

import app.mappers.dto.EmployeeDTO;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrganizationRoleTest {

    @Test
    public void createEmployee1() {
        System.out.println("createEmployee");
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "app.domain.model.Employee");
        EmployeeDTO empDTO = new EmployeeDTO("ADMIN", "Miguel", "rua da saude", "12345678901", "map2001@iol.pt", "Hello", 0);
        Employee emp = or.createEmployee(empDTO);
        assertNotNull(emp);
    }

    @Test
    public void createEmployee2() {
        System.out.println("createSpecialistDoctor");
        OrganizationRole or = new OrganizationRole("SD", "ADMIN", "app.domain.model.SpecialistDoctor");
        EmployeeDTO empDTO = new EmployeeDTO("ADMIN", "Miguel", "rua da saude", "12345678901", "map2001@iol.pt", "Hello", 21);
        SpecialistDoctor emp = new SpecialistDoctor(or, "Miguel", "rua da saude", "12345678901", "map2001@iol.pt", "Hello", 21);
        assertNotNull(emp);
    }

    @Test
    public void testgetId() {
        System.out.println("getId");
        OrganizationRole or = new OrganizationRole("SD", "ADMIN", "app.domain.model.SpecialistDoctor");
        String result = or.getId();
        assertEquals("SD", result);
    }

    @Test
    public void testgetDescription() {
        System.out.println("getDescription");
        OrganizationRole or = new OrganizationRole("SD", "ADMIN", "app.domain.model.SpecialistDoctor");
        String result = or.getDescription();
        assertEquals("ADMIN", result);
    }
    
    @Test
    public void testToString(){
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "app.domain.model.Employee");
        String expected = "Id: ADMIN    Description: ADMIN";
        String result = "";
        result = or.toString();
        assertEquals(expected, result);
    }
    
    @Test
    public void testEquals1(){
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "app.domain.model.Employee");
        String test = "wa";

        assertNotEquals(or, test);
    }
    
    @Test
    public void testEquals2(){
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "app.domain.model.Employee");

        assertNotEquals(null, or);
    }
    
    @Test
    public void testEquals3(){
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "app.domain.model.Employee");

        assertEquals(or, or);
    }
    
    @Test
    public void testHasId3(){
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "app.domain.model.Employee");
        
        assertFalse(or.hasId(""));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testOrganizationRole1(){
        OrganizationRole or = new OrganizationRole("", "ADMIN", "app.domain.model.Employee");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testOrganizationRole2(){
        OrganizationRole or = new OrganizationRole("ADMIN", "", "app.domain.model.Employee");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testOrganizationRole3(){
        OrganizationRole or = new OrganizationRole("ADMIN", "ADMIN", "");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testOrganizationRole4(){
        OrganizationRole or = new OrganizationRole("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "ADMIN", "app.domain.model.Employee");
    }
    @Test
    public void testOrganizationRole5(){
        try{
            OrganizationRole or = new OrganizationRole("AAAAAAAAAAAAAAA", "ADMIN", "app.domain.model.Employee");
        }
        catch(IllegalArgumentException e){
            fail("IllegalArgumentException");
        }
    }

}