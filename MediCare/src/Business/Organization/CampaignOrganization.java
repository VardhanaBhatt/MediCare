/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;
import Business.Role.Role;
import Business.Role.CoordinatorRole;
import java.util.ArrayList;

/**
 *
 * @author Karishma Murde
 */
public class CampaignOrganization extends Organization {
    public CampaignOrganization() {
        super(OrgType.Campaign.getValue());
    }

    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CoordinatorRole());
        return roles;
    }
}
