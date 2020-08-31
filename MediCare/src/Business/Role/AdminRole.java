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
import UserInterface.AdminWorkArea.AdminHomeJPanel;
import javax.swing.JPanel;

/**
 *
 * @author shalini
 */
public class AdminRole extends Role{
    public AdminRole(){
        super(Role.RoleType.Admin.getValue());
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, EcoSystem business, DB4OUtil dB4OUtil, UserAccount userAccount, Organization organization, Enterprise enterprise) {
        return new AdminHomeJPanel(userProcessContainer, business, dB4OUtil, userAccount, enterprise);
    }
}
