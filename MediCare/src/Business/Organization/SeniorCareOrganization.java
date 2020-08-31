/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;
import Business.Role.CareTakerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Karishma Murde
 */
public class SeniorCareOrganization extends Organization  {
    
public SeniorCareOrganization() {
       super(OrgType.SeniorCare.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CareTakerRole());
        return roles;
    }
    
}
