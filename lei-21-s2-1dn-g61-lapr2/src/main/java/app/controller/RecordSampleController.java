package app.controller;


import app.domain.model.Company;
import app.domain.model.Sample;
import app.domain.model.Test;
import app.domain.model.TestStore;
import app.mappers.TestsMapper;
import app.mappers.dto.TestDTO;

import java.io.IOException;
import java.util.List;

public class RecordSampleController {

    private Company company;
    private TestStore ts;
    private Test test;

    public RecordSampleController() throws IOException, ClassNotFoundException {
        this.company = App.getInstance().getCompany();
        this.ts = this.company.getTestStore();
    }

    /**
     * @param company
     */
    public RecordSampleController(Company company) {
        this.company = company;
        this.ts = this.company.getTestStore();
    }

    /**
     * @return List of testsDTO
     */
    public List<TestDTO> getTests() {
        List<Test> tests = this.ts.getTests();
        TestsMapper tm = new TestsMapper();
        return tm.toDTO(tests);
    }

    /**
     * @param testdto
     */
    public void getTest(TestDTO testdto) {
        this.test = ts.getTestByCode(testdto.getCode());
    }

    /**
     * Associates the barcodes generated to the test
     * @return if the sample where added correctly to the test
     */
    public Boolean generateBarcode() {
        return this.test.createSample();
    }

    public List<Sample> getSamples(){
        return this.test.getSamples();
    }

    public void setSampleData() {
        this.test.setDateSample();
        this.test.setTimeSample();
    }
}
