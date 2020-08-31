/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.AdminOrganization;
import Business.Organization.Organization;
import Business.Role.AdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Vardhana Bhatt
 */
public class UserAccountDirectory {
    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password, Employee employee, Role role){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public void deleteUserAccount(UserAccount userAccount){
        userAccountList.remove(userAccount);
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (UserAccount ua : userAccountList){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
    
    public boolean checkIfAdminExists(Organization org){
        
        for(UserAccount userAccount : org.getUserAccountDirectory().getUserAccountList()){
            if(userAccount.getRole().getName().equals("Admin Type")){
                return true;
            } 
        }
        return false;
    }
    
     public boolean checkIfManagerExists(Organization org){
        
        for(UserAccount userAccount : org.getUserAccountDirectory().getUserAccountList()){
            if(userAccount.getRole().getName().equals("Manager Type")){
                return true;
            }
        }
        return false;
    }
     
     public boolean checkIfCareTakerExists(Organization org){
        
        for(UserAccount userAccount : org.getUserAccountDirectory().getUserAccountList()){
            if(userAccount.getRole().getName().equals("CareTaker Type")){
                return true;
            }
        }
        return false;
    }
     
    public boolean checkIfDoctorExists(Organization org){
        
        for(UserAccount userAccount : org.getUserAccountDirectory().getUserAccountList()){
            if(userAccount.getRole().getName().equals("Doctor Type")){
                return true;
            }
        }
        return false;
    }
}
