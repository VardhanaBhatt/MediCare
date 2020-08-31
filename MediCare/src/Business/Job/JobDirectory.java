/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Job;
import java.util.ArrayList;

/**
 *
 * @author Karishma Murde
 */
public class JobDirectory {
     private ArrayList<Job> jobList;

    public JobDirectory() {
        this.jobList = new ArrayList<>();
    }

    public ArrayList<Job> getJobList() {
        return jobList;
    }
    
    public void setJobList(ArrayList<Job> jobList) {
        this.jobList = jobList;
    }

    
    public Job createJob(String name){
        Job job = new Job();
        job.setName(name);
        jobList.add(job);
        return job;
    }
    
    public void removeJob(Job job){
        jobList.remove(job);
    }
    
}
