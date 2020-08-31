/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;
import Business.Organization.Organization.OrgType;
import java.util.ArrayList;
/**
 *
 * @author Karishma Murde
 */
public class OrganizationDirectory {
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(OrgType type){
        Organization organization = null;
        if (type.getValue().equals(OrgType.Admin.getValue())){
            organization = new AdminOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(OrgType.Manager.getValue())){
            organization = new ManagerOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(OrgType.Campaign.getValue())){
            organization = new CampaignOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(OrgType.Welfare.getValue())){
            organization = new WelfareOrganization();
            organizationList.add(organization);
        } 
        else if (type.getValue().equals(OrgType.SeniorCare.getValue())){
            organization = new SeniorCareOrganization();
            organizationList.add(organization);
        } 
        else if (type.getValue().equals(OrgType.Medical.getValue())){
            organization = new MedicalOrganization();
            organizationList.add(organization);
        } 
//        else if (type.getValue().equals(OrgType.Applicant.getValue())){
//            organization = new ApplicantOrganization();
//            organizationList.add(organization);
//        }
        return organization;
    }
    
    public void deleteOrganization(Organization organization){
      organizationList.remove(organization);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
