/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;
import Business.Role.DoctorRole;
import Business.Role.Role;
import java.util.ArrayList;
/**
 *
 * @author Karishma Murde
 */
public class MedicalOrganization extends Organization {
     public MedicalOrganization() {
       super(OrgType.Medical.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new DoctorRole());
        return roles;
    }
    
}
