/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;
/**
 *
 * @author Vardhana Bhatt
 */
public class WorkQueue {
    private ArrayList<WorkRequest> workRequestList;
    
    public WorkQueue(){
        workRequestList = new ArrayList();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
    
    private ArrayList<AgencyWorkRequest> agencyWorkRequestList;
    private ArrayList<IssueWorkRequest> issueWorkRequestList;
    private ArrayList<JobWorkRequest> jobWorkRequestList;
    private ArrayList<PostTaskWorkRequest> postTaskWorkRequestList;
    private ArrayList<SeniorCareWorkRequest> seniorCareWorkRequestList;
    private ArrayList<SeniorMedicalWorkRequest> seniorMedicalWorkRequestList;

    public ArrayList<AgencyWorkRequest> getAgencyWorkRequestList() {
        return agencyWorkRequestList;
    }

    public void setAgencyWorkRequestList(ArrayList<AgencyWorkRequest> agencyWorkRequestList) {
        this.agencyWorkRequestList = agencyWorkRequestList;
    }

    public ArrayList<IssueWorkRequest> getIssueWorkRequestList() {
        return issueWorkRequestList;
    }

    public void setIssueWorkRequestList(ArrayList<IssueWorkRequest> issueWorkRequestList) {
        this.issueWorkRequestList = issueWorkRequestList;
    }

    public ArrayList<JobWorkRequest> getJobWorkRequestList() {
        return jobWorkRequestList;
    }

    public void setJobWorkRequestList(ArrayList<JobWorkRequest> jobWorkRequestList) {
        this.jobWorkRequestList = jobWorkRequestList;
    }

    public ArrayList<PostTaskWorkRequest> getPostTaskWorkRequestList() {
        return postTaskWorkRequestList;
    }

    public void setPostTaskWorkRequestList(ArrayList<PostTaskWorkRequest> postTaskWorkRequestList) {
        this.postTaskWorkRequestList = postTaskWorkRequestList;
    }

    public ArrayList<SeniorCareWorkRequest> getSeniorCareWorkRequestList() {
        return seniorCareWorkRequestList;
    }

    public void setSeniorCareWorkRequestList(ArrayList<SeniorCareWorkRequest> seniorCareWorkRequestList) {
        this.seniorCareWorkRequestList = seniorCareWorkRequestList;
    }

    public ArrayList<SeniorMedicalWorkRequest> getSeniorMedicalWorkRequestList() {
        return seniorMedicalWorkRequestList;
    }

    public void setSeniorMedicalWorkRequestList(ArrayList<SeniorMedicalWorkRequest> seniorMedicalWorkRequestList) {
        this.seniorMedicalWorkRequestList = seniorMedicalWorkRequestList;
    }    
}
