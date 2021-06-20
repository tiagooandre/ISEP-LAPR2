package app.domain.model;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class CSVReaderTest {
    private CSVReader reader = new CSVReader();

    String expRes = "123456654321";

    @Test
    public void testCSVReader1() {
        System.out.println("CSVReader1");

        assertEquals(expRes, reader.createTestFromFile("test1.txt", 0)[0]);
    }

    @Test()
    public void testCSVReader2() {
        System.out.println("CSVReader2");
        String[] result = reader.createTestFromFile("client.csv", 1);

        assertTrue(result==null);
    }

    @Test
    public void testCSVReader3() {
        System.out.println("CSVReader3");
        String[] result = reader.createTestFromFile("client33.csv", 0);

        assertTrue(result==null);
    }

}
