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

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * @author renan
 */
public class EmailNotificationTest {

    public EmailNotificationTest() {
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
     * Test of sendEmailToClient method, of class EmailNotification.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testSendEmailToClient() throws Exception {
        EmailNotification en = new EmailNotification();
        en.sendEmailToClient("ola");
        String result = "";
        try {
            result = new String(Files.readAllBytes(Paths.get("emailAndSMSMessages.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals("ola", result);
    }

}
