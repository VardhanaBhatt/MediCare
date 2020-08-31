package Business.Role;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import javax.swing.JPanel;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.DoctorWorkArea.DoctorHomeJPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shalini
 */
public class DoctorRole extends Role {
    public DoctorRole(){
        super(Role.RoleType.Doctor.getValue());
    }
     @Override
    public JPanel createWorkArea(JPanel userProcessContainer, EcoSystem business, DB4OUtil dB4OUtil, UserAccount userAccount, Organization organization, Enterprise enterprise) {
        return new DoctorHomeJPanel(userProcessContainer, business, dB4OUtil, userAccount, organization, enterprise);
    }
}
