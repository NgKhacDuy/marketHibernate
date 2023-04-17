/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Custom;

/**
 *
 * @author Admin
 */
public interface TableActionEvent {
    public void onEdit(int row);

    public void onDelete(int row);

    public void onView(int row);
    
    public void choice(int row);
    
    public void add(int row);    
    public void minus(int row);

}
