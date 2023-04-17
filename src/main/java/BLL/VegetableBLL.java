/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import POJO.Vegetable;
import DAL.VegetableDAL;
import POJO.Category;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class VegetableBLL {
    private VegetableDAL vegDAL;

    public VegetableBLL() {
        vegDAL = new VegetableDAL();
    }
    public List loadVegetable(){
        List list;
        list = vegDAL.loadVegetable();
        return list;
    }
    public Object[][] convertList(List<Vegetable> list){
        int rows = list.size();
        int cols = 7;
        Object[][] obj = new Object[rows][cols];
        for(int i = 0 ; i < rows ; i++){
            obj[i][0] = list.get(i).getVegetableID();
            obj[i][1] = list.get(i).getCategory();
            obj[i][2] = list.get(i).getVegetable_Name();
            obj[i][3] = list.get(i).getUnit();
            obj[i][4] = list.get(i).getAmount();
            obj[i][5] = list.get(i).getImage();
            obj[i][6] = list.get(i).getPrice();
        }
        return obj;
    }
    public Object[][] convertListCompact(List<Vegetable> list){
        int rows = list.size();
        int cols = 5;
        Object[][] obj = new Object[rows][cols];
        for(int i = 0 ; i < rows ; i++){
            obj[i][0] = list.get(i).getVegetableID();
            obj[i][1] = list.get(i).getVegetable_Name();
            obj[i][2] = list.get(i).getUnit();
            obj[i][3] = list.get(i).getAmount();
            obj[i][4] = list.get(i).getPrice();
        }
        return obj;
    }
    public Object[] convertItemCompactToTbSP(Vegetable v){
        int cols = 5;
        Object[] obj = new Object[cols];
        obj[0] = v.getVegetableID();
        obj[1] = v.getVegetable_Name();
        obj[2] = v.getUnit();
        obj[3] = 1;
        obj[4] = v.getPrice();

        return obj;
    }
    public Object[] convertItemCompact(Vegetable v){
        int cols = 5;
        Object[] obj = new Object[cols];
        obj[0] = v.getVegetableID();
        obj[1] = v.getVegetable_Name();
        obj[2] = v.getUnit();
        obj[3] = v.getAmount();
        obj[4] = v.getPrice();

        return obj;
    }
    public int[] listID(List<Vegetable> list){
        int[] listID = new int[list.size()];
        for (int i = 0 ; i < list.size() ; i++){
            listID[i] = list.get(i).getVegetableID();
        }
        return listID;
    }
    
    public void newVegetable(Vegetable v){
        vegDAL.addVegetable(v);
    }
    public void updateVegetable(Vegetable v){
        vegDAL.updateVegetable(v);
    }
    public void deleteVegetable(Vegetable v){
        vegDAL.deleteVegetable(v);
        
    }
    public Vegetable getVegetable(int VegetableID){
        Vegetable v = vegDAL.getVegetable(VegetableID);
        return v;
    }
    public List searchVegetable(String str){
        return vegDAL.searchVegetable(str);
    }
}
