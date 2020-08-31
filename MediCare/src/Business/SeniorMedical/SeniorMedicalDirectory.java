/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.SeniorMedical;
import java.util.ArrayList;

/**
 *
 * @author Karishma Murde
 */
public class SeniorMedicalDirectory {
     private ArrayList<SeniorMedical> seniorMedicalList;
    
    public SeniorMedicalDirectory(){
        this.seniorMedicalList = new ArrayList<>();
    }

    public ArrayList<SeniorMedical> getseniorMedicalList() {
        return seniorMedicalList;
    }

    public void setSeniorMedicalDirectory(ArrayList<SeniorMedical> seniorMedicalList) {
        this.seniorMedicalList = seniorMedicalList;
    }
    
    public SeniorMedical createSeniorMedical(String name, boolean illness){
        SeniorMedical senior = new SeniorMedical();
        senior.setName(name);
        senior.setIllness(illness);
        senior.setStatus(false);
        seniorMedicalList.add(senior);
        return senior;
    }
    
    public void removeSeniorMedical(SeniorMedical senior){
        seniorMedicalList.remove(senior);
    }
}
