/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;
import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author Admin
 */
@Entity
@Table(name="Vegetable")
public class Vegetable implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int VegetableID;
    @ManyToOne
    @JoinColumn(name="CatagoryID")
    private Category category;
    private String Vegetable_Name;
    private String Unit;
    private int Amount;
    private String Image;
    private float Price;

    public Vegetable() {
    }

    public int getVegetableID() {
        return VegetableID;
    }

    public void setVegetableID(int VegetableID) {
        this.VegetableID = VegetableID;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    

    public String getVegetable_Name() {
        return Vegetable_Name;
    }

    public void setVegetable_Name(String Vegetable_Name) {
        this.Vegetable_Name = Vegetable_Name;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }
    
}
