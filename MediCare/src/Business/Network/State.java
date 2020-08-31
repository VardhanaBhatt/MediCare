/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import java.util.ArrayList;
/**
 *
 * @author Vardhana Bhatt
 */
public class State extends Network{
    private ArrayList<City> cityList;

    public State() {
        super(NetworkType.Country.getValue());
        cityList = new ArrayList<>();
    }

    public ArrayList<City> getCityList() {
        return cityList;
    }

    public void setCityList(ArrayList<City> cityList) {
        this.cityList = cityList;
    }

     public City createCity(){
        City city = new City();
        cityList.add(city);
        return city;
    }
     
      public void removeCity(City city){
        cityList.remove(city);
    }
}
