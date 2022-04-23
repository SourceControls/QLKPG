package com.raven.swing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class TableColumn extends JTable {
    boolean hasBtn=true;
    boolean btn1Selected=false;
    boolean btn2Selected=false;
    boolean btn1Hoverred=false;
    boolean btn2Hoverred=false;
    int rowHoverred=-1;
    int colHoverred=-1;
    int rowSelected=0;
    int colSelected=0;
    boolean isAddingCus=false;
    String textBTN1;
    String textBTN2;

    public TableColumn() {
        
        getTableHeader().setReorderingAllowed(false);
        setBackground(new Color(245, 245, 245));
        setRowHeight(40);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) { // ấn vào từng dòng
                //PanelSua.setSelected(true);
                
               // System.out.println(getSelectedColumn());
            }
        });
        //get
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int row, int col) {
                
                return new TableCell(o,col);
            }
            
        });
        
    }

    public boolean isHasBtn() {
        return hasBtn;
    }

    public boolean isBtn1Hoverred() {
        return btn1Hoverred;
    }

    public boolean isBtn2Hoverred() {
        return btn2Hoverred;
    }

    public int getRowHoverred() {
        return rowHoverred;
    }

    public int getColHoverred() {
        return colHoverred;
    }

    public boolean isIsAddingCus() {
        return isAddingCus;
    }

    public void setHasBtn(boolean hasBtn) {
        this.hasBtn = hasBtn;
    }

    public void setIsAddingCus(boolean isAddingCus) {
        this.isAddingCus = isAddingCus;
    }

    public void setBtn1Selected(boolean btn1Selected) {
        this.btn1Selected = btn1Selected;
    }

    public void setBtn2Selected(boolean btn2Selected) {
        this.btn2Selected = btn2Selected;
    }

    public void setBtn1Hoverred(boolean btn1Hoverred) {
        this.btn1Hoverred = btn1Hoverred;
    }
    public void setBtn2Hoverred(boolean btn2Hoverred) {
        this.btn2Hoverred = btn2Hoverred;
    }
    public void setRowSelected(int rowSelected) {
        this.rowSelected = rowSelected;
    }

    public void setColSelected(int colSelected) {
        this.colSelected = colSelected;
    }

    public void setRowHoverred(int rowHoverred) {
        this.rowHoverred = rowHoverred;
    }

    public void setColHoverred(int colHoverred) {
        this.colHoverred = colHoverred;
    }

    
    
    
    public boolean isBtn1Selected() {
        return btn1Selected;
    }

    public boolean isBtn2Selected() {
        return btn2Selected;
    }

    

    public int getRowSelected() {
        return rowSelected;
    }

    public int getColSelected() {
        return colSelected;
    }

    public void setStartColorBtnFix(Color startColorBtnFix) {
        TableCell.startColorBtnFix=startColorBtnFix;
    }

    public void setStartColorBtnSignUp(Color startColorBtnSignUp) {
        TableCell.startColorBtnSignUp=startColorBtnSignUp;
    }
    public void setEndColorBtnFix(Color endColorBtnFix) {
        TableCell.endColorBtnFix=endColorBtnFix;
    }
    public void setEndColorBtnSignUp(Color endColorBtnSignUp) {
        TableCell.endColorBtnSignUp=endColorBtnSignUp;
    }
//    public void setBtn1Hoverred(boolean btn1Hoverred) {
//        TableCell.BTN1HOVERED=btn1Hoverred;
//        this.btn1Hoverred = btn1Hoverred;
//    }

    public String getTextBTN1() {
        return textBTN1;
    }

    public String getTextBTN2() {
        return textBTN2;
    }

    public void setTextBTN1(String textBTN1) {
        this.textBTN1 = textBTN1;
    }

    public void setTextBTN2(String textBTN2) {
        this.textBTN2 = textBTN2;
    }

    
    @Override
    public Component prepareRenderer(TableCellRenderer tcr, int i, int i1) {
       
        TableCell.CellType celLType = TableCell.CellType.CENTER;
        if(hasBtn){
            if (i1 == 0) {
                celLType = TableCell.CellType.LEFT;
            }else if (btn1Selected && i==rowSelected && i1==colSelected){
                celLType = TableCell.CellType.BTN1SELECTED;
            }else if (btn1Hoverred && i==rowHoverred && i1==colHoverred){
                celLType = TableCell.CellType.BTN1HOVERED;
            }else if (btn2Hoverred && i==rowHoverred && i1==colHoverred){
                celLType = TableCell.CellType.BTN2HOVERED;
            }else if (btn2Selected && i==rowSelected && i1==colSelected){
                celLType = TableCell.CellType.BTN2SELECTED;
            }else if (i1 == getColumnCount() - 2){
                celLType = TableCell.CellType.BTN1;
            }else if (i1 == getColumnCount() - 1){
                celLType = TableCell.CellType.BTN2;
            }
        }else{
            if (i1 == 0) {
                celLType = TableCell.CellType.LEFT;
            }else if (i1 == getColumnCount() - 1){
                celLType = TableCell.CellType.RIGHT;
            }
        }
        if(i1 == getColumnCount() - 1) return new TableCell(getValueAt(i, i1), isCellSelected(i, i1), celLType,i1,textBTN2);
        else if(i1 == getColumnCount() - 2) return new TableCell(getValueAt(i, i1), isCellSelected(i, i1), celLType,i1,textBTN1);
        return new TableCell(getValueAt(i, i1), isCellSelected(i, i1), celLType,i1);
    }
}
