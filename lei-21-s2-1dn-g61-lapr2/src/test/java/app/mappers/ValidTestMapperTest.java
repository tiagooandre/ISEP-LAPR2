package app.mappers;

import app.domain.model.Date;
import app.mappers.dto.TestDateDTO;
import org.junit.Test;
import java.awt.font.FontRenderContext;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
/**
 *
 * @author miguel
 */
public class ValidTestMapperTest {
    @Test
    public void testToDTO1() {
        System.out.println("toDTO1");

        ValidTestMapper vtm = new ValidTestMapper();

        app.domain.model.Test tt = new app.domain.model.Test("123456789012");
        tt.setDateChemAnalysis();
        tt.setDateDiagnosis();
        tt.setDateSample();
        tt.setTimeDiagnosis();
        tt.setTimeSample();
        tt.setTimeChemAnalysis();

        String expected = new TestDateDTO(tt.getCode(),tt.getDateSample(),tt.getTimeSample(),tt.getDateChemAnalysis(),tt.getTimeChemAnalysis(),tt.getDateDiagnosis(),tt.getTimeDiagnosis()).toString();
        String result = vtm.toDTO1(tt).toString();
        System.out.println(result);
        assertEquals(expected,result);
    }
    @Test
    public void testToDTO() {
        System.out.println("ToDTO");
        ValidTestMapper vtm = new ValidTestMapper();
        List<app.domain.model.Test> tests = new ArrayList<>();

        app.domain.model.Test t1 = new app.domain.model.Test("000000000001");
        t1.getCode();
        t1.setDateSample();
        t1.setDateDiagnosis();
        t1.setDateChemAnalysis();
        t1.setTimeChemAnalysis();
        t1.setTimeDiagnosis();
        t1.setTimeSample();
        tests.add(t1);


        List<TestDateDTO> list = vtm.toDTO(tests);
        System.out.println(list.size());
        System.out.println(list);
        String d1 = t1.getDateSample();
        String d2 = t1.getDateChemAnalysis();
        String d3 = t1.getDateDiagnosis();
        String t11 = t1.getTimeSample();
        String t12 = t1.getTimeChemAnalysis();
        String t13 = t1.getTimeDiagnosis();

        String expected = new TestDateDTO(t1.getCode(),d1,t11,d2,t12,d3,t13).toString();
        String result = list.get(0).toString();
        assertEquals(expected,result);

    }

}