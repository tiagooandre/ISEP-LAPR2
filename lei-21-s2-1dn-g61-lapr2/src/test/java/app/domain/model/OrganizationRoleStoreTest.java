package app.domain.model;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OrganizationRoleStoreTest {

    @Test
    public void testCreateOrganizationRole() {
        System.out.println("createOrganizationRole");
        OrganizationRole or = new OrganizationRole("ADMIN","ADMINISTRATOR","Administrator");
        OrganizationRoleStore ors = new OrganizationRoleStore();
        OrganizationRole result = ors.create("ADMIN","ADMINISTRATOR","Administrator");
        assertEquals(result, or);
    }

    @Test
    public void addOrganizationRole() {
        System.out.println("addOrganizationRole");
        OrganizationRoleStore ors = new OrganizationRoleStore();
        assertTrue(ors.addOrganizationRole("ADMIN","ADMINISTRATOR","Administrator"));
    }

    @Test
    public void remove() {
        System.out.println("removeOrganizationRole");
        OrganizationRoleStore ors = new OrganizationRoleStore();
        ors.addOrganizationRole("ADMIN","ADMINISTRATOR","Administrator");
        OrganizationRole org = ors.create("ADMIN","ADMINISTRATOR","Administrator");
        assertTrue(ors.remove(org));
    }

    @Test
    public void getRoleById() {
        System.out.println("getRole");
        OrganizationRoleStore ors = new OrganizationRoleStore();
        OrganizationRole or = new OrganizationRole("ADMIN","ADMINISTRATOR","Administrator");
        ors.addOrganizationRole("ADMIN","ADMINISTRATOR","Administrator");
        OrganizationRole result = ors.getRoleById("ADMIN");
        assertEquals(result, or);
    }

    @Test
    public void testExists1() {
        System.out.println("exists");
        OrganizationRoleStore ors = new OrganizationRoleStore();
        ors.addOrganizationRole("ADMIN","ADMINISTRATOR","Administrator");
        assertTrue(ors.exists("ADMIN"));
    }

    @Test
    public void testExists2() {
        System.out.println("exists");
        OrganizationRoleStore ors = new OrganizationRoleStore();
        OrganizationRole or = new OrganizationRole("ADMIN","ADMINISTRATOR","Administrator");
        ors.addOrganizationRole("ADMIN","ADMINISTRATOR","Administrator");
        assertTrue(ors.exists(or));
    }
    
    @Test
    public void testGetRole(){
        OrganizationRoleStore ors = new OrganizationRoleStore();
        List<OrganizationRole> result = ors.getRoles();
        assertNotNull(result);
    }
    
    @Test
    public void testExists(){
        OrganizationRoleStore ors = new OrganizationRoleStore();
        String s = null;
        assertFalse(ors.exists(s));
    }
    
    @Test
    public void testGetRoleById(){
        OrganizationRoleStore ors = new OrganizationRoleStore();
        String s = null;
        OrganizationRole result = ors.getRoleById(s);
        assertEquals(null, result);
    }
    
    @Test
    public void testRemove(){
        OrganizationRoleStore ors = new OrganizationRoleStore();
        OrganizationRole role = null;
        assertFalse(ors.remove(role));
    }
    
    @Test
    public void testAddOrganizationRole(){
        OrganizationRoleStore ors = new OrganizationRoleStore();
        ors.addOrganizationRole("ADMIN","ADMINISTRATOR","Administrator");
        assertFalse(ors.addOrganizationRole("ADMIN","ADMINISTRATOR","Administrator"));
    }

}