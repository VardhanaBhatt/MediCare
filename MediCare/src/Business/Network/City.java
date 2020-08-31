/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;
/**
 *
 * @author Vardhana Bhatt
 */
public class City extends Network{
    private EnterpriseDirectory enterpriseDirectory;
    
    public City() {
        super(NetworkType.City.getValue());
        enterpriseDirectory = new EnterpriseDirectory();
    }
    
    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }
}
