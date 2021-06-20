/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.mappers;

import app.domain.model.TestType;
import app.mappers.dto.TestTypeDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author renan
 */
public class TestTypeMapperTest {
    
    public TestTypeMapperTest() {
    }

    /**
     * Test of toDTO method, of class TestTypeMapper.
     */
    @Test
    public void testToDTO() {
        System.out.println("toDTO");
        System.out.println("toDTO");
        TestTypeMapper ttm = new TestTypeMapper();
        
        TestType tt = new TestType("tt009", "Urine", "123456");

        
        String expected = new TestTypeDTO("tt009", "Urine", "copo").toString();
        String result = ttm.toDTO(tt).toString();
        
        assertEquals(expected, result);
    }

    /**
     * Test of testTypeToDTO method, of class TestTypeMapper.
     */
    @Test
    public void testTestTypeToDTO() {
        System.out.println("testTypeToDTO");
        TestTypeMapper ttm = new TestTypeMapper();
        List<TestType> categories = new ArrayList<>();
        
        TestType pc1 = new TestType("tt013", "Urine", "urine");
        TestType pc2 = new TestType("tt015", "Saliva", "saliva");
        TestType pc3 = new TestType("tt017", "Vision", "tear");
          
        categories.add(pc1);
        categories.add(pc2);
        categories.add(pc3);
        
        List<TestTypeDTO> pcList = ttm.testTypeToDTO(categories);
        
        String expected = new TestTypeDTO("tt017", "Vision", "chinelo").toString();
        String result = pcList.get(2).toString();
        
        assertEquals(expected, result);
    }
    
}
