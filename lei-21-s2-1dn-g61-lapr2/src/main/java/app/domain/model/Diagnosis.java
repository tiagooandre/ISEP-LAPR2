package app.domain.model;

import java.io.Serializable;
import java.util.List;

public class Diagnosis implements Serializable {

    private List<TestParameter> list;
    /**
     * @param list is used to describe the diagnosis done
     */
    public Diagnosis(List<TestParameter> list ){
        this.list = list;
    }

    public List<TestParameter> getList() {
        return list;
    }

    public String toString(){
        return "### Diagnosis ### \n" + "Diagnosis: " + this.list + "\n" ;
    }
}

