/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Account;

import java.util.ArrayList;

/**
 *
 * @author shalini
 */
public class AccountDirectory {
    private int total;
    private int balance;
    private ArrayList<Account> accountList;
    
    
    public AccountDirectory() {
        this.accountList = new ArrayList<>();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }
  
    
     public Account addAccount(Account account){
        accountList.add(account);
        return account;
    }

}
