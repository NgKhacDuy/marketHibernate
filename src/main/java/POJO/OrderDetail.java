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
@Table(name="OrderDetail")
public class OrderDetail implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name="OrderID")
    private Orders order;
    @Id
    @ManyToOne
    @JoinColumn(name="VegetableID")
    private Vegetable vegetable;
    
    private int Quantity;
    private float Price;

    public OrderDetail() {
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Vegetable getVegetable() {
        return vegetable;
    }

    public void setVegetable(Vegetable vegetable) {
        this.vegetable = vegetable;
    }
    

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }
    
}
