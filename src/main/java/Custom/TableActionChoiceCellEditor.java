/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Custom;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import Custom.TableActionEvent;

/**
 *
 * @author Admin
 */
public class TableActionChoiceCellEditor  extends DefaultCellEditor{
    private TableActionEvent event;

    public TableActionChoiceCellEditor(TableActionEvent event) {
        super(new JCheckBox());
        this.event = event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        ButtonRadius btn = new ButtonRadius();
        PanelChoiceAction action = new PanelChoiceAction();
        action.initEvent(event, row);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }

}
