/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Agency.Agency;
/**
 *
 * @author Vardhana Bhatt
 */
public class AgencyWorkRequest extends WorkRequest{
    private Agency agency;

    public AgencyWorkRequest(){
        super(WorkRequest.WorkRequestType.Agency.getValue());
    }
    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }
    
    @Override
    public String toString(){
        return agency.getName();
    }
}
