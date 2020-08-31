/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

/**
 *
 * @author Vardhana Bhatt
 */
public abstract class Network {
   private String name;
   private String networkName;
    
    public enum NetworkType{
        Country("Country"), State("State"), City("City");

        private String value;
        private NetworkType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }
        
        @Override
        public String toString(){
            return value;
        }
    }
    
    public Network(String networkName){
        this.networkName = networkName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    @Override
    public String toString() {
        return name;
    }  
}
