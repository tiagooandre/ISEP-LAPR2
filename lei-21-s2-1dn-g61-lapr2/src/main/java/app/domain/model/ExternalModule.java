/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.model;

/**
 *
 * @author renan
 */
public interface ExternalModule {
    /**
     *
     * @param param The parameter tested
     * @return Reference Values for that parameter
     */
    public ReferenceValue getReferenceValue(Parameter param);
}
