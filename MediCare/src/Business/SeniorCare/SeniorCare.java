/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.SeniorCare;

/**
 *
 * @author Karishma Murde
 */
public class SeniorCare {
    private int id;
    private boolean status;
    private static int count = 1;
    private String country;
    private String state, city;
    private String name;
    private boolean illness;
    private boolean medicines;
    
    public SeniorCare(){
        id = count;
        count++;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isIllness() {
        return illness;
    }

    public void setIllness(boolean illness) {
        this.illness = illness;
    }

    public boolean isMedicines() {
        return medicines;
    }

    public void setMedicines(boolean medicines) {
        this.medicines = medicines;
    }
       
    @Override
    public String toString() {
        return name;
    }
    
}
