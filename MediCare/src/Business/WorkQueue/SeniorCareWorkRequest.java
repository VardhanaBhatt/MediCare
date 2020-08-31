/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.SeniorCare.SeniorCare;
/**
 *
 * @author Vardhana Bhatt
 */
public class SeniorCareWorkRequest extends WorkRequest{
    private SeniorCare senior;
    
    public SeniorCareWorkRequest(){
        super(WorkRequest.WorkRequestType.SeniorCare.getValue());
    }

    public SeniorCare getSenior() {
        return senior;
    }

    public void setSenior(SeniorCare senior) {
        this.senior = senior;
    }
    
    @Override
    public String toString(){
        return senior.getName();
    }
}
