package app.domain.model;
import com.example3.CovidReferenceValues1API;

/**
 * Adapter for the CovidReferenceValues API
 */
public class ExternalModuleAdapter1 implements ExternalModule{

    /**
     * API in charge of Covid reference values
     */
    private CovidReferenceValues1API covidAPI;

    public ExternalModuleAdapter1(){
        this.covidAPI = new CovidReferenceValues1API();
    }

    /**
     * Gets the reference values of a parameter
     *
     * @param param the parameter being tested
     * @return ReferenceValue for the parameter
     */
    @Override
    public ReferenceValue getReferenceValue(Parameter param) {
        String paramCode = param.getCodeP();
        String usedMetric = this.covidAPI.usedMetric(param.getCodeP(), 12345);
        double min = this.covidAPI.getMinReferenceValue(param.getCodeP(), 12345);
        double max = this.covidAPI.getMaxReferenceValue(param.getCodeP(), 12345);
        Date date = new Date();

        return new ReferenceValue(paramCode, usedMetric, min, max, date);
    }
}
