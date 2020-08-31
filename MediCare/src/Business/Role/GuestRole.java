/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import javax.swing.JPanel;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;

/**
 *
 * @author shalini
 */
public class GuestRole  extends Role{
    public GuestRole(){
        super(Role.RoleType.Guest.getValue());
    }

  
   @Override
    public JPanel createWorkArea(JPanel userProcessContainer, EcoSystem business, DB4OUtil dB4OUtil, UserAccount userAccount, Organization organization, Enterprise enterprise) {
       // return new GuestHomeJPanel(userProcessContainer, business, dB4OUtil);
        return null;
    }
    
    
    
}
