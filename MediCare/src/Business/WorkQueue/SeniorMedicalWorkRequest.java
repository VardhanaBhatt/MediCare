/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.SeniorMedical.SeniorMedical;
/**
 *
 * @author Vardhana Bhatt
 */
public class SeniorMedicalWorkRequest extends WorkRequest{
    private SeniorMedical senior;
    
    public SeniorMedicalWorkRequest(){
        super(WorkRequest.WorkRequestType.SeniorMedical.getValue());
    }

    public SeniorMedical getSenior() {
        return senior;
    }

    public void setSenior(SeniorMedical senior) {
        this.senior = senior;
    }
    
    @Override
    public String toString(){
        return senior.getName();
    }
}
