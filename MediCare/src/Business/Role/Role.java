/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author shalini
 */
public abstract class Role {
    private String name;
    public enum RoleType{
        Admin("Admin Type"),
        Manager("Manager Type"),
        Coordinator("Coordinator Type"),
        Guest("Guest Type"),
        System("System Type"),
        Applicant("Applicant Type"),
        CareTaker("CareTaker Type"),
        Doctor("Doctor Type");
        
        private String value;
        
        private RoleType(String value){
            this.value =value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value; //To change body of generated methods, choose Tools | Templates.
        }
    }
    public Role(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract JPanel createWorkArea(JPanel userProcessContainer, EcoSystem business, DB4OUtil dB4OUtil, UserAccount userAccount, Organization organization, Enterprise enterprise);

    @Override
    public String toString() {
        return name;
    }
    
}
