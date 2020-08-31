/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;
/**
 *
 * @author Vardhana Bhatt
 */
public abstract class WorkRequest {
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private String workRequestName;
   
    
    public WorkRequest(String name){
        requestDate = new Date();
        this.workRequestName = workRequestName;
    }
    
    public enum WorkRequestType{
        Agency("Agency Work Request"), 
        Issue("Issue Work Request"),
        Job("Job Work Request"), 
        PostTask("Post Task Work Request"),
        SeniorCare("SeniorCare Work Request"),
        SeniorMedical("Medication Work Request");

        private String value;
        private WorkRequestType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }
        
        @Override
        public String toString(){
            return value;
        }
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }
    
    @Override
    public String toString() {
        return status;
    }
}
