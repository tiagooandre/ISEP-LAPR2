/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.mappers;

import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.mappers.dto.ParameterCategoryDTO;
import app.mappers.dto.ParameterDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author renan
 */
public class ParameterMapperTest {

    /**
     * Test of toDTO method, of class ParameterMapper.
     */
    @Test
    public void testToDTO() {
        System.out.println("toDTO");
        ParameterMapper pm = new ParameterMapper();
        
        ParameterCategory pc = new ParameterCategory("pc013", "Urine", "123456");
        Parameter p = new Parameter("p0013", "Urine", pc);
        
        String expected = new ParameterDTO("p0013", "Urine", "Urine").toString();
        String result = pm.toDTO(p).toString();
        
        assertEquals(expected, result);
    }

    /**
     * Test of parameterToDTO method, of class ParameterMapper.
     */
    @Test
    public void testParameterToDTO() {
        System.out.println("parameterToDTO");

        ParameterMapper pm = new ParameterMapper();
        List<Parameter> parameters = new ArrayList<>();
        
        ParameterCategory pc1 = new ParameterCategory("pc013", "Urine", "123456");
        ParameterCategory pc2 = new ParameterCategory("pc015", "Saliva", "654456");
        ParameterCategory pc3 = new ParameterCategory("pc017", "Vision", "663366");
        
        Parameter p1 = new Parameter("p0013", "Urine", pc1);
        Parameter p2 = new Parameter("p0015", "Saliva", pc2);
        Parameter p3 = new Parameter("p0017", "Vision", pc3);
        
        parameters.add(p1);
        parameters.add(p2);
        parameters.add(p3);
        
        List<ParameterDTO> pList = pm.parameterToDTO(parameters);
        
        String expected = new ParameterDTO("p0017", "Vision", "Vision").toString();
        String result = pList.get(2).toString();
        
        assertEquals(expected, result);   
    }
    
}
