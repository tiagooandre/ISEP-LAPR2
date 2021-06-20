package app.mappers;

import app.domain.model.TestType;
import app.mappers.dto.TestDateDTO;
import app.mappers.dto.TestReporDTO;
import app.mappers.dto.TestTypeDTO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
/**
 *
 * @author miguel
 */
public class TestReportMapperTest {
    @Test
    public void testToDTO1() {
        System.out.println("toDTO");

        TestReportMapper trm = new TestReportMapper();
        String nh = "000000000006";
        app.domain.model.Test t1 = new app.domain.model.Test(nh);

        String expected = new TestReporDTO(t1.getCode()).toString();
        String result = trm.toDTO1(t1).toString();
        assertEquals(expected, result);
    }
    @Test
    public void testToDTO() {
        System.out.println("ToDTO");

        List<app.domain.model.Test> tests = new ArrayList<>();
        TestReportMapper trm = new TestReportMapper();
        String nh = "000000000006";
        app.domain.model.Test t1 = new app.domain.model.Test(nh);

        t1.getCode();
        t1.setDateSample();
        t1.setDateChemAnalysis();
        tests.add(t1);

        List<TestReporDTO> list = trm.toDTO(tests);
        System.out.println(list.size());
        System.out.println(list);

        String expected = new TestReporDTO(t1.getCode()).toString();
        String result = list.get(0).toString();
        assertEquals(expected,result);

    }

}