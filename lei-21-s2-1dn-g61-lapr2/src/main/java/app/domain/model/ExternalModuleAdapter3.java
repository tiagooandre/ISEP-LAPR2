package app.domain.model;
import com.example2.ExternalModule2API;
import com.example2.EMRefValue;

public class ExternalModuleAdapter3 implements ExternalModule{

    /**
     * API in charge of Blood reference values
     */
    private ExternalModule2API bloodAPI;

    /**
     * Creates an instance of the adapter
     */
    public ExternalModuleAdapter3(){
        this.bloodAPI = new ExternalModule2API();
    }

    /**
     * Gets the reference values of a parameter
     *
     * @param param the parameter being tested
     * @return ReferenceValue for the parameter
     */
    @Override
    public ReferenceValue getReferenceValue(Parameter param) {
        EMRefValue refs = bloodAPI.getReferenceFor(param.getCodeP());

        String paramCode = refs.getParameterID();
        String usedMetric = refs.getMetric();
        double min = refs.getMinValue();
        double max = refs.getMaxValue();
        Date date = new Date();

        return new ReferenceValue(paramCode, usedMetric, min, max, date);
    }
}
