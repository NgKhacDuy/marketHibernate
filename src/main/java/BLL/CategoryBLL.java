/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import POJO.Category;
import DAL.CategoryDAL;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CategoryBLL {
    private CategoryDAL cateDAL;

    public CategoryBLL() {
        cateDAL = new CategoryDAL();
    }
    public List<Category> loadCategory(){
        List list;
        list = cateDAL.loadCategory();
        return list;
    }
    public Object[][] convertList(List<Category> list){
        int rows = list.size();
        int cols = 4;
        Object[][] obj = new Object[rows][cols];
        for(int i = 0 ; i < rows ; i++){
            obj[i][0] = list.get(i).getCategoryID();
            obj[i][1] = list.get(i).getName();
            obj[i][2] = list.get(i).getDescription();
            obj[i][3] = list.get(i).getListVegetable().size();
        }
        return obj;
    }
    public int[] listID(List<Category> list){
        int[] listID = new int[list.size()];
        for (int i = 0 ; i < list.size() ; i++){
            listID[i] = list.get(i).getCategoryID();
        }
        return listID;
    }
    public void newCategory(Category c){
        cateDAL.addCategory(c);
    }
    public Category getCategory(int CategoryID){
        Category c = cateDAL.getCategory(CategoryID);
        return c;
    }
    public void updateCategory(Category c){
        cateDAL.updateCategory(c);
    }
    public void deleteCategory(Category c){
        cateDAL.deleteCategory(c);
    }
    public List<Category> searchCategory(String str){
        return cateDAL.searchCategory(str);
    }
}
