package app.domain.model;
import com.example1.ExternalModule3API;

/**
 * Adapter for the BloodReferenceValues API 1
 */
public class ExternalModuleAdapter2 implements ExternalModule{

    /**
     * API in charge of Blood reference values
     */
    private ExternalModule3API bloodAPI;

    /**
     * Creates an instance of the adapter
     */
    public ExternalModuleAdapter2(){
        this.bloodAPI = new ExternalModule3API();
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
        String usedMetric = this.bloodAPI.usedMetric(param.getCodeP(), 12345);
        double min = this.bloodAPI.getMinReferenceValue(param.getCodeP(), 12345);
        double max = this.bloodAPI.getMaxReferenceValue(param.getCodeP(), 12345);
        Date date = new Date();

        return new ReferenceValue(paramCode, usedMetric, min, max, date);
    }
}