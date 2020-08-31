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
import UserInterface.ManagerWorkArea.ManagerHomeJPanel;
import javax.swing.JPanel;

/**
 *
 * @author shali
 */
public class ManagerRole extends Role{
     public ManagerRole(){
        super(Role.RoleType.Manager.getValue());
    }
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, EcoSystem business, DB4OUtil dB4OUtil, UserAccount userAccount, Organization organization, Enterprise enterprise){
        return new ManagerHomeJPanel(userProcessContainer, business, dB4OUtil, userAccount, organization, enterprise);
    }
    
}
