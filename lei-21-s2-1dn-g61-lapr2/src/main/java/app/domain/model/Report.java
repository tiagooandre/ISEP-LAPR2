/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.model;

import java.io.Serializable;

import static java.lang.System.*;

/**
 *
 * @author Goncalo
 */
public class  Report implements Serializable {
    /**
     * text for report
     */
    private String text;
    /**
     * Test Diagnosis
     */
    private Diagnosis diagnosis;
    
    
    /**
     * creates an Report instance with atributes text and diagnosis and checks is the text is 400 words or less
     * @param text is used to describe the diagnosis done
     * @param diagnosis is what was done to "test" the patient
     */
    public Report(String text, Diagnosis diagnosis){
        checkText(text);
        this.text = text;
        this.diagnosis = diagnosis;
    }

    /**
     * get the text for report
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * changing the text for report
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * get the diagnosis for report
     * @return diagnosis
     */
    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    /**
     * changing the diagnosis for test
     * @param diagnosis
     */
    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    /**
     * get the data in string form
     * @return string with the data of report
     */
    public String toString(){
        return "### Report ### \n" + "Text: " + this.text + "\n" + "Diagnosis: " + this.diagnosis + "\n";
    }

    /**
     * checks if text has 400 or less words
     * @param text
     */
    public void checkText(String text){
        int cont = text.split(" ",-1).length -1; //pega a quantidade de espaços em branco
        String[] array = new String[cont];//define o vetor que conterá as palavras separadas da string
        array = text.split(" ");//separa a string colocando as palavras no vetor
        //out.println(array.length);
        if (array.length > 400)
            throw new IllegalArgumentException("Text Field must be 400 words or less");



    }

}
