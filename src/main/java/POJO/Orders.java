/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;
import java.sql.Date;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.BatchSize;
/**
 *
 * @author Admin
 */
@Entity
@Table(name="orders")
public class Orders {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OrderID;
    @ManyToOne
    @JoinColumn(name="CustomerID")
    private Customers customers;
    private Date Date;
    private float Total;
    private String Note;
    @BatchSize(size = 20)
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> listOrderDetail;

    public List<OrderDetail> getListOrderDetail() {
        return listOrderDetail;
    }

    public void setListOrderDetail(List<OrderDetail> listOrderDetail) {
        this.listOrderDetail = listOrderDetail;
    }

    public Orders() {
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }


    

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }
    
}
