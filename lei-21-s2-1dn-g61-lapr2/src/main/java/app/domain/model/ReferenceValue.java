package app.domain.model;

import java.io.Serializable;

/**
 * Represents a reference value, provided by an external module
 * 
 * @author renan
 */
public class ReferenceValue implements Serializable {
    /**
     * RefValue's parameter code
     */
    private final String code;

    /**
     * RefValue's min value
     */
    private final Double min;

    /**
     * RefValue's max value
     */
    private final Double max;

    /**
     * RefValue's metric
     */
    private final String usedMetric;

    /**
     * RefValue's creation date
     */
    private final Date date;

    /**
     * Creates a Reference Value
     *
     * @param code RefValue's parameter code
     * @param metric RefValue's metric
     * @param min RefValue's min value
     * @param max RefValue's max value
     * @param date RefValue's creation date
     */
    public ReferenceValue(String code, String metric, double min, double max, Date date){
        this.code = code;
        this.min = min;
        this.max = max;
        this.usedMetric = metric;
        this.date = date;
    }

    /**
     * Gets the min reference value
     *
     * @return this RefValue's min value
     */
    public double getMinRefVal(){
        return this.min;
    }

    /**
     * Gets the max reference value
     *
     * @return this RefValue's max value
     */
    public double getMaxRefVal(){
        return this.max;
    }

    /**
     * Creates a String with information concerning the ref value
     *
     * @return The String
     */
    @Override
    public String toString(){
        return String.format("Parameter Code: %s\n"+
                             "Min reference value: %f\n" +
                             "Max reference value: %f\n" +
                             "Used Metric: %s\n" +
                             "Date: %s",this.code, this.min, this.max, this.usedMetric, this.date.toString());
    }
}