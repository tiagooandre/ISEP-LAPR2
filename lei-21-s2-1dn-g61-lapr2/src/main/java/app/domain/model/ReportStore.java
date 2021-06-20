/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.model;

import java.util.List;

/**
 *
 * @author Gon�alo
 */
public class ReportStore {
    
    //User Story: Create new report for diagnosis 

    /**
     * List of Reports 
     */
    private final List<Report> reportList;
    
    /**
     * Report Store constructor
     * @report list
     */
    
    public ReportStore(List<Report> list){
        this.reportList = list;
    }
    
    /**
     * @param text text used to describe the diagnosis done 
     * @param diagnosis diagnosis made by the doctor
     * @return report report that has the text and the diagnosis
     */
    public Report createReport(String text, Diagnosis diagnosis){
        return new Report(text,diagnosis);
    }
    
    /**
     * @param r The report to be validated
     * @return Validation if the report does not already exists
     */
    public boolean validateReport(Report r){
        if (r == null){
            return false;
        } else {
            return ! this.reportList.contains(r);
        }
    }
    
    /**
     * @param r The report to be added to the list of reports
     * @return True if the new report was added successfully
     */
    public boolean saveReport(Report r){
        if (!validateReport(r))
            return false;

        return this.reportList.add(r);
    }
    
    
    /**
     * Returns the list of reports
     * @return reports list
     */
    public List<Report> getReports(){
        return this.reportList;
    }
    
    
    
    
    
    
}
