package app.domain.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author renan
 */
public class ExternalModuleTest {

    public ExternalModuleTest() {
    }

    @Test
    public void testExternalModule1(){
        ExternalModule em = new ExternalModuleAdapter1();

        ParameterCategory pc1 = new ParameterCategory("pc001", "ddd", "124567");
        Parameter p1 = new Parameter("IgGAN", "ddd", pc1);

        ParameterCategory pc2 = new ParameterCategory("pc002", "ccc", "7654321");
        Parameter p2 = new Parameter("IgGAN", "ccc", pc2);

        ReferenceValue rv1 = em.getReferenceValue(p1);
        ReferenceValue rv2 = em.getReferenceValue(p2);


        assertEquals(rv1.toString(), rv2.toString());
    }

    @Test
    public void testExternalModule2(){
        ExternalModule em = new ExternalModuleAdapter2();

        ParameterCategory pc1 = new ParameterCategory("pc001", "ddd", "124567");
        Parameter p1 = new Parameter("RBC00", "ddd", pc1);

        ParameterCategory pc2 = new ParameterCategory("pc002", "ccc", "7654321");
        Parameter p2 = new Parameter("RBC00", "ccc", pc2);

        ReferenceValue rv1 = em.getReferenceValue(p1);
        ReferenceValue rv2 = em.getReferenceValue(p2);


        assertEquals(rv1.toString(), rv2.toString());
    }

    @Test
    public void testExternalModule3(){
        ExternalModule em = new ExternalModuleAdapter3();

        ParameterCategory pc1 = new ParameterCategory("pc001", "ddd", "124567");
        Parameter p1 = new Parameter("RBC00", "ddd", pc1);

        ParameterCategory pc2 = new ParameterCategory("pc002", "ccc", "7654321");
        Parameter p2 = new Parameter("RBC00", "ccc", pc2);

        ReferenceValue rv1 = em.getReferenceValue(p1);
        ReferenceValue rv2 = em.getReferenceValue(p2);

        assertEquals(rv1.toString(), rv2.toString());
    }


}