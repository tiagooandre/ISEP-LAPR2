package app.domain.model;

import java.util.List;

/**
 *
 * @author Miguel Chen 1190897
 */

public class RegisterClinicalStore {
    /**
     * ;list of the labs
     */
    private final List<ClinicalAnalysisLaboratory> clinicalList;

    /**
     * creates RegisterClinicalStore with Labs already registered
     * @param list list of labs
     */
    public RegisterClinicalStore(List<ClinicalAnalysisLaboratory> list){
        this.clinicalList= list;
    }
    /**
     * creates lab using the constructor from ClinicalAnalysisLaboratory
     * @param laboratoryID
     * @param name
     * @param address
     * @param phoneNumber
     * @param numberTIN
     * @return new ClinicalAnalysisLaboratory
     */
    public ClinicalAnalysisLaboratory createClinical(String laboratoryID, String name, String address, String phoneNumber, String numberTIN){
        return new ClinicalAnalysisLaboratory(laboratoryID,name,address,phoneNumber,numberTIN);
    }
    /**
     * @param cl The laboratory to be validated
     * @return Validation if the laboratory does not exist
     */
    public boolean validateClinical(ClinicalAnalysisLaboratory cl) {
        if (cl == null)
            return false;
        return  existsSame(this.clinicalList,cl);
    }

    /**
     * checks if hte same lab already exists?
     * @param list lab list
     * @param c lab
     * @return true if the lab does not already exist in the list
     */
    public boolean existsSame(List<ClinicalAnalysisLaboratory> list, ClinicalAnalysisLaboratory c){
        for(ClinicalAnalysisLaboratory cl : list){
            if(cl.getLaboratoryID().compareTo(c.getLaboratoryID())==0 || cl.getAdress().compareTo(c.getAdress())==0 || cl.getNumberTIN().compareTo(c.getNumberTIN())==0 || cl.getPhoneNumber().compareTo(c.getPhoneNumber())==0)
                return false;
        }
        return true;
    }
    /**
     * @param cl The laboratory to be added to the List of ClinicalAnalysisLaboratory
     * @return true if the laboratory was added successfully
     */
    public boolean saveClinical(ClinicalAnalysisLaboratory cl) {
        if (!validateClinical(cl))
            return false;
        return this.clinicalList.add(cl);
    }


    /**
     * Gets a lab by its id
     *
     * @param id Lab id
     * @return The lab
     */
    public ClinicalAnalysisLaboratory getClinicById(String id){
        for(ClinicalAnalysisLaboratory t : this.clinicalList){
            if((t.getLaboratoryID().compareTo(id))==0) {
                return t;
            }
        }
        return null;
    }

}
