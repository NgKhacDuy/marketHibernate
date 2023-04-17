/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import POJO.Customers;
import POJO.Vegetable;
import DAL.CustomersDAL;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CustomersBLL {
    private CustomersDAL cusDAL;

    public CustomersBLL() {
        cusDAL = new CustomersDAL();
    }
    public List loadCustomers(){
        List list;
        list = cusDAL.loadCustomers();
        return list;
    }
    public Object[][] convertList(List<Customers> list){
        int rows = list.size();
        int cols = 6;
        Object[][] obj = new Object[rows][cols];
        for(int i = 0 ; i < rows ; i++){
            obj[i][0] = list.get(i).getCustomerID();
            obj[i][1] = list.get(i).getPassword();
            obj[i][2] = list.get(i).getFullname();
            obj[i][3] = list.get(i).getAddress();
            obj[i][4] = list.get(i).getCity();
            obj[i][5] = list.get(i).getListOrder().size();
        }
        return obj;
    }
    public void newCustomers(Customers v){
        cusDAL.addCustomers(v);
    }
    public Customers getCustomers(int CustomerID){
        Customers v = cusDAL.getCustomers(CustomerID);
        return v;
    }
    public void updateCustomer(Customers c){
        cusDAL.updateCustomers(c);
    }
    public List searchCustomer(String str){
        return cusDAL.searchCustomer(str);
    }
    public void deleteCustomer(Customers c){
        cusDAL.deleteCustomers(c);
    }
    public int[] listID(List<Customers> list){
        int[] listID = new int[list.size()];
        for (int i = 0 ; i < list.size() ; i++){
            listID[i] = list.get(i).getCustomerID();
        }
        return listID;
    }
}
