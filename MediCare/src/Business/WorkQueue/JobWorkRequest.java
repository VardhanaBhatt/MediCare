/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Job.Job;
/**
 *
 * @author Vardhana Bhatt
 */
public class JobWorkRequest extends WorkRequest{
    private Job job;

    public JobWorkRequest(){
        super(WorkRequest.WorkRequestType.Job.getValue());
    }
     
    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
