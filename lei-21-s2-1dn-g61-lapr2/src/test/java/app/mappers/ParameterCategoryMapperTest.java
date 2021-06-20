/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.mappers;

import app.domain.model.ParameterCategory;
import app.mappers.dto.ParameterCategoryDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author renan
 */
public class ParameterCategoryMapperTest {
    
    public ParameterCategoryMapperTest() {
    }

    /**
     * Test of toDTO method, of class ParameterCategoryMapper.
     */
    @Test
    public void testToDTO() {
        System.out.println("toDTO");
        ParameterCategoryMapper pcm = new ParameterCategoryMapper();
        
        ParameterCategory pc = new ParameterCategory("pc013", "Urine", "123456");
        String expected = new ParameterCategoryDTO("pc013", "Urine").toString();
        String result = pcm.toDTO(pc).toString();
        
        assertEquals(expected, result);
    }

    /**
     * Test of parameterToDTO method, of class ParameterCategoryMapper.
     */
    @Test
    public void testParameterToDTO() {
        System.out.println("parameterToDTO");
        ParameterCategoryMapper pm = new ParameterCategoryMapper();
        List<ParameterCategory> categories = new ArrayList<>();
        
        ParameterCategory pc1 = new ParameterCategory("pc013", "Urine", "123456");
        ParameterCategory pc2 = new ParameterCategory("pc015", "Saliva", "654456");
        ParameterCategory pc3 = new ParameterCategory("pc017", "Vision", "663366");
          
        categories.add(pc1);
        categories.add(pc2);
        categories.add(pc3);
        
        List<ParameterCategoryDTO> pcList = pm.parameterToDTO(categories);
        
        String expected = new ParameterCategoryDTO("pc017", "Vision").toString();
        String result = pcList.get(2).toString();
        
        assertEquals(expected, result);   
    }
    
}
