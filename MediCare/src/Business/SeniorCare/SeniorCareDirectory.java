/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.SeniorCare;
import java.util.ArrayList;

/**
 *
 * @author Karishma Murde
 */
public class SeniorCareDirectory {
    private ArrayList<SeniorCare> seniorCareList;
    
    public SeniorCareDirectory(){
        this.seniorCareList = new ArrayList<>();
    }

    public ArrayList<SeniorCare> getSeniorCareList() {
        return seniorCareList;
    }

    public void setSeniorCareList(ArrayList<SeniorCare> seniorCareList) {
        this.seniorCareList = seniorCareList;
    }
    
    public SeniorCare createSeniorCare(String name, boolean illness){
        SeniorCare senior = new SeniorCare();
        senior.setName(name);
        senior.setIllness(illness);
        senior.setStatus(false);
        seniorCareList.add(senior);
        return senior;
    }
    
    public void removeSeniorCare(SeniorCare senior){
        seniorCareList.remove(senior);
    }    
}
