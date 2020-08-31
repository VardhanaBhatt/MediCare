/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Agency;
import java.util.ArrayList;

/**
 *
 * @author shalini
 */
public class AgencyDirectory {
    private ArrayList <Agency> agencyList;
    
       public AgencyDirectory(){
        this.agencyList = new ArrayList<>();
    }
   
    public ArrayList<Agency> getAgencyList() {
        return agencyList;
    }

    public void setAgencyList(ArrayList<Agency> agencyList) {
        this.agencyList = agencyList;
    }
  
    public Agency createAgency(String name, int amount){
        Agency agency = new Agency();
        agency.setName(name);
        agency.setAmount(amount);
        agency.setStatus(false);
        agencyList.add(agency);
        return agency;
    }
     public void removeAgency(Agency agency){
        agencyList.remove(agency);
    }
}
