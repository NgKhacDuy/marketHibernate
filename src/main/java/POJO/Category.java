/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
/**
 *
 * @author Admin
 */
@Entity
@Table(name="category")
public class Category implements Serializable{
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CatagoryID")
    private int categoryID;
    
    private String Name;
    
    private String Description;

    @OneToMany (mappedBy = "category")
    private List<Vegetable> listVegetable;
    @Override
    public String toString(){
        return this.Name;
    }

    public List<Vegetable> getListVegetable() {
        return listVegetable;
    }

    public void setListVegetable(List<Vegetable> listVegetable) {
        this.listVegetable = listVegetable;
    }
    public Category() {
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
}
