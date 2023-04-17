/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;
import java.util.List;
import javax.persistence.*;
/**
 *
 * @author Admin
 */
@Entity
@Table(name="customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CustomerID;
    private String  Password;
    private String Fullname;
    private String Address;
    private String City;
    @OneToMany(mappedBy = "customers")
    private List<Orders> listOrder;
    @Override
    public String toString(){
        return this.Fullname;
    }

    public List<Orders> getListOrder() {
        return listOrder;
    }

    public void setListOrder(List<Orders> listOrder) {
        this.listOrder = listOrder;
    }
    public Customers() {
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

}
