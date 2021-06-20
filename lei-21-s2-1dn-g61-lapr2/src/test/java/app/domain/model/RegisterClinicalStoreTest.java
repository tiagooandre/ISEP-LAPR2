package app.domain.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

/**
 *
 * @author Miguel Chen 1190897
 */

public class RegisterClinicalStoreTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    /**
     * Test of createClinical method, of class ResgisterClinicalStore.
     */
     @Test
    public void testCreateClinical() {
        System.out.println("createClinical");
        String lid = "lb123";
        String name = "lab";
        String address = "Rua 1";
        String pn = "12345678901";
        String tin = "1234567890";

        List<ClinicalAnalysisLaboratory> list= null;
        RegisterClinicalStore rc = new RegisterClinicalStore(list);
        ClinicalAnalysisLaboratory cl = new ClinicalAnalysisLaboratory("lb123", "lab", "Rua 1", "12345678901", "1234567890");
        ClinicalAnalysisLaboratory result = rc.createClinical(lid,name,address,pn,tin);

        assertEquals(0, result.toString().compareTo(cl.toString()));
    }
    /**
     * Test of validateClinical method, of class ResgisterClinicalStore, cl is null
     */
    @Test
    public void validateClinical() {
        System.out.println("validateClinical");

        List<ClinicalAnalysisLaboratory> list = null;
        RegisterClinicalStore rc = new RegisterClinicalStore(list);
        ClinicalAnalysisLaboratory cl = null;

        assertFalse(rc.validateClinical(cl));
    }
    /**
     * Test of createClinical method, of class ResgisterClinicalStore, cl not valid
     */
    @Test
    public void testValidateClinical2() {
        System.out.println("validateClinical");

        List<ClinicalAnalysisLaboratory> list = new ArrayList<>();
        RegisterClinicalStore rc = new RegisterClinicalStore(list);
        ClinicalAnalysisLaboratory cl = new ClinicalAnalysisLaboratory("lb123", "Lab", "Rua 1", "12345678901", "1234567890");
        list.add(cl);

        assertFalse(rc.validateClinical(cl));
    }
    /**
     * Test of createClinical method, of class ResgisterClinicalStore, cl valid
     */
    @Test
    public void testValidateClinical3() {
        System.out.println("validateClinical");

        List<ClinicalAnalysisLaboratory> list = new ArrayList<>();
        RegisterClinicalStore rc = new RegisterClinicalStore(list);
        ClinicalAnalysisLaboratory cl = new ClinicalAnalysisLaboratory("lb123", "Lab", "Rua 1", "12345678901", "1234567890");

        assertTrue(rc.validateClinical(cl));
    }
    /**
     * Test of saveClinical method, of class ResgisterClinicalStore, cl valid
     */
    @Test
    public void testSaveClinical1() {
        System.out.println("saveClinical");

        List<ClinicalAnalysisLaboratory> list = new ArrayList<>();
        RegisterClinicalStore rc = new RegisterClinicalStore(list);
        ClinicalAnalysisLaboratory cl = new ClinicalAnalysisLaboratory("lb123", "Lab", "Rua 1", "12345678901", "1234567890");

        assertTrue(rc.saveClinical(cl));
    }
    /**
     * Test of saveClinical method, of class ResgisterClinicalStore, cl not valid
     */
    @Test
    public void testSaveClinical2() {
        System.out.println("saveClinical");

        List<ClinicalAnalysisLaboratory> list = new ArrayList<>();
        RegisterClinicalStore rc = new RegisterClinicalStore(list);
        ClinicalAnalysisLaboratory cl = new ClinicalAnalysisLaboratory("lb123", "Lab", "Rua 1", "12345678901", "1234567890");

        list.add(cl);

        assertFalse(rc.saveClinical(cl));
    }
    @Test
    public void testExits(){
        System.out.println("exitsClinical");

        List<ClinicalAnalysisLaboratory> list = new ArrayList<>();
        RegisterClinicalStore rc = new RegisterClinicalStore(list);
        ClinicalAnalysisLaboratory cl = new ClinicalAnalysisLaboratory("lb123", "Lab", "Rua 1", "12345678901", "1234567890");
        ClinicalAnalysisLaboratory cl1 = new ClinicalAnalysisLaboratory("lb123", "Lab", "Rua 2", "12345678902", "1234567891");
        list.add(cl);

        assertFalse(rc.existsSame(list,cl1));

    }
    @Test
    public void testExits1(){
        System.out.println("exitsClinical");

        List<ClinicalAnalysisLaboratory> list = new ArrayList<>();
        RegisterClinicalStore rc = new RegisterClinicalStore(list);
        ClinicalAnalysisLaboratory cl = new ClinicalAnalysisLaboratory("lb123", "Lab", "Rua 1", "12345678901", "1234567890");
        ClinicalAnalysisLaboratory cl1 = new ClinicalAnalysisLaboratory("lb124", "Lab", "Rua 1", "12345678902", "1234567891");
        list.add(cl);

        assertFalse(rc.existsSame(list,cl1));

    }
    @Test
    public void testExits2(){
        System.out.println("exitsClinical");

        List<ClinicalAnalysisLaboratory> list = new ArrayList<>();
        RegisterClinicalStore rc = new RegisterClinicalStore(list);
        ClinicalAnalysisLaboratory cl = new ClinicalAnalysisLaboratory("lb123", "Lab", "Rua 1", "12345678901", "1234567890");
        ClinicalAnalysisLaboratory cl1 = new ClinicalAnalysisLaboratory("lb124", "Lab", "Rua 2", "12345678901", "1234567891");
        list.add(cl);

        assertFalse(rc.existsSame(list,cl1));


    }
    @Test
    public void testExits3(){
        System.out.println("exitsClinical");

        List<ClinicalAnalysisLaboratory> list = new ArrayList<>();
        RegisterClinicalStore rc = new RegisterClinicalStore(list);
        ClinicalAnalysisLaboratory cl = new ClinicalAnalysisLaboratory("lb123", "Lab", "Rua 1", "12345678901", "1234567890");
        ClinicalAnalysisLaboratory cl1 = new ClinicalAnalysisLaboratory("lb124", "Lab", "Rua 2", "12345678902", "1234567890");
        list.add(cl);

        assertFalse(rc.existsSame(list,cl1));


    }
    @Test
    public void testExits4() {
        System.out.println("exitsClinical");

        List<ClinicalAnalysisLaboratory> list = new ArrayList<>();
        RegisterClinicalStore rc = new RegisterClinicalStore(list);
        ClinicalAnalysisLaboratory cl = new ClinicalAnalysisLaboratory("lb123", "Lab", "Rua 1", "12345678901", "1234567890");
        ClinicalAnalysisLaboratory cl1 = new ClinicalAnalysisLaboratory("lb124", "Lab", "Rua 2", "12345678902", "1234567891");
        list.add(cl);

        assertTrue(rc.existsSame(list, cl1));
    }



}
