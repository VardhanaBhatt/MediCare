/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Applicant.ApplicantDirectory;
import Business.Network.Country;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author shalini
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    
    //Ecosystem has applicant directory for the entire network.
    private ApplicantDirectory applicantDirectory;
    private ArrayList<Country> networkList;
    
    private EcoSystem() {
        super(null);
        networkList = new ArrayList<>();
        applicantDirectory = new ApplicantDirectory();
    }
    
    public static EcoSystem getInstance()
    {
        if(business == null){
            business = new EcoSystem();
        }
        
        return business;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    public ArrayList<Country> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Country> networkList) {
        this.networkList = networkList;
    }
    
    public Country createAndAddNetwork()
    {
        Country network = new Country();
        networkList.add(network);
        return network;
    }
    
    public void removeNetwork(Country country)
    {
        networkList.remove(country);
    }

    public ApplicantDirectory getApplicantDirectory() {
        return applicantDirectory;
    }

    public void setApplicantDirectory(ApplicantDirectory applicantDirectory) {
        this.applicantDirectory = applicantDirectory;
    }
    
     public boolean checkIfUserNameIsUnique(String username){
        
        if(!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)){
            return false;
        }
        return true;
        
    }
     
    @Override
    public String toString(){
        return "Ecosystem";
    }
}
