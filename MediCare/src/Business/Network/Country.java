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
public class Country extends Network{
    private ArrayList<State> stateList;
    
    public Country() {
        super(NetworkType.Country.getValue());
        stateList = new ArrayList<>();
    }

    public ArrayList<State> getStateList() {
        return stateList;
    }

    public void setStateList(ArrayList<State> stateList) {
        this.stateList = stateList;
    }
    
    public State createState(){
        State state = new State();
        stateList.add(state);
        return state;
    }
    
    public void removeState(State state){
        stateList.remove(state);
    }
}
