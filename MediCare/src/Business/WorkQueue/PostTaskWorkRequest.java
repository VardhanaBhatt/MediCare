/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Project.Project;
/**
 *
 * @author Vardhana Bhatt
 */
public class PostTaskWorkRequest extends WorkRequest{
    private Project project;
    private String task;
    private String workDone;

    public PostTaskWorkRequest(){
        super(WorkRequest.WorkRequestType.PostTask.getValue());
    }
     
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getWorkDone() {
        return workDone;
    }

    public void setWorkDone(String workDone) {
        this.workDone = workDone;
    }
    
    @Override
    public String toString(){
        return project.getName();
    }
}
