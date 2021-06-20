/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author renan
 */
public class GeneratePasswordTest {
    
    public GeneratePasswordTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of GeneratePassword method, of class GeneratePassword.
     */
    @Test
    public void testGeneratePassword() {
        GeneratePassword gp = new GeneratePassword();
    }
    
    /**
     * Mutation Test of generatePassword method, of class GeneratePassword. i--
     */
    @Test
    public void generatePassword1(){
        String ps=GeneratePassword.generatePassword();
        int result = ps.length();
        assertEquals(10, result);
    }
    
}
