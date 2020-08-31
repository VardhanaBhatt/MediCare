/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Project;

import java.util.ArrayList;

/**
 *
 * @author Vardhana Bhatt
 */
public class ProjectDirectory {
    private ArrayList<Project> projectList;
    
    public ProjectDirectory(){
        this.projectList = new ArrayList<>();
    }

    public ArrayList<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(ArrayList<Project> projectList) {
        this.projectList = projectList;
    }
    
    public Project addProject(Project project){
        projectList.add(project);
        return project;
    }
    
    public void RemoveProject(Project project){
        projectList.remove(project);
    }
}
