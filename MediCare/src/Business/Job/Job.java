/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Job;
import Business.Enterprise.Enterprise;

/**
 *
 * @author Karishma Murde
 */
public class Job {
    private String name;
    private int id;
    private static int count = 1;
    private Enterprise enterprise;

    public Job() {
        id = count;
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
