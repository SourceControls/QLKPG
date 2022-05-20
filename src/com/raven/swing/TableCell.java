package com.raven.swing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class TableCell extends JLabel {

    private final CellType cellType;
    private boolean selected;
    public static Color startColorBtnFix = new Color(104,109,224);
    public static Color startColorBtnSignUp = new Color(224,86,253);
    public static Color endColorBtnFix = new Color(153,153,255);
    public static Color endColorBtnSignUp = new Color(255,51,255);
    public TableCell(Object obj) {
        //  This for column header jtable
        setFont(new Font("sansserif", 1, 12));
        this.cellType = CellType.EMPTY;
        if (obj != null) {
            setText(obj.toString());
        }
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setForeground(new Color(80, 80, 80));
    }
    public TableCell(Object obj,int col) {
        //  This for column header jtable
        setFont(new Font("sansserif", 1, 12));
        this.cellType = CellType.EMPTY;
        if (obj != null) {
            setText(obj.toString());
        }
        setBorder(new EmptyBorder(10, 10, 10, 10));
        
        
    }

    public TableCell(Object obj, boolean selected, CellType cellType,int col,String text) {
        
        //  This for cell jtable
        this.selected = selected;
        this.cellType = cellType;
        this.setText(text);
        if (obj != null) {
            setText(obj.toString());
            if(obj.toString().equals("false")){
                setIcon(new ImageIcon("src/com/raven/icon/daux.png"));
                setText("");
            }
            if(obj.toString().equals("true")){
                setIcon(new ImageIcon("src/com/raven/icon/dauok.png"));
                setText("");
            }
        }
        
        setBorder(new EmptyBorder(10, 10, 10, 10));
        if(obj != null && (obj.toString().equals("SẮP HẾT HẠN") ||obj.toString().equals("SẮP TỚI HẠN NỘP TIỀN")))
            setForeground(Color.red);
        else setForeground(new Color(80, 80, 80));
        
    }
    public TableCell(Object obj, boolean selected, CellType cellType,int col) {
        
        //  This for cell jtable
        this.selected = selected;
        this.cellType = cellType;
        
        if (obj != null) {
            setText(obj.toString());
            if(obj.toString().equals("false")){
                setIcon(new ImageIcon("src/com/raven/icon/daux.png"));
                setText("");
            }
            if(obj.toString().equals("true")){
                setIcon(new ImageIcon("src/com/raven/icon/dauok.png"));
                setText("");
            }
        }
        
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setForeground(new Color(80, 80, 80));
    }
//    public void setStartColorBtnFix(Color startColorBtnFix) {
//        this.startColorBtnFix = startColorBtnFix;
//    }
//
//    public void setStartColorBtnSignUp(Color startColorBtnSignUp) {
//        this.startColorBtnSignUp = startColorBtnSignUp;
//    }
//
//    public static void setEndColorBtnFix(Color endColorBtnFix) {
//        TableCell.endColorBtnFix = endColorBtnFix;
//    }
//
//    public static void setEndColorBtnSignUp(Color endColorBtnSignUp) {
//        TableCell.endColorBtnSignUp = endColorBtnSignUp;
//    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        int width = getWidth() + 5;
        int height = getHeight() - 4;
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        if (cellType == CellType.LEFT) {
            g2.fillRoundRect(0, 2, width, height, 6, 6);
            if (selected) {
                g2.setColor(new Color(137, 215, 255));
                g2.setStroke(new BasicStroke(2f));
                g2.drawRoundRect(1, 2, width, height, 6, 6);
            }
        } else if (cellType == CellType.RIGHT) {
           
            g2.fillRoundRect(-5, 2, width, height, 6, 6);
            if (selected) {
                g2.setColor(new Color(137, 215, 255));
                g2.setStroke(new BasicStroke(2f));
                g2.drawRoundRect(-5, 2, width - 2, height, 6, 6);
            }
        } else if (cellType == CellType.CENTER) {
            g2.fillRect(0, 2, width, height);
            if (selected) {
                g2.setColor(new Color(137, 215, 255));
                g2.setStroke(new BasicStroke(2f));
                g2.drawRect(-5, 2, width + 2, height);
            }
        }else if (cellType == CellType.BTN1) {
            g2.fillRect(0, 2, width, height);
            setHorizontalAlignment(SwingConstants.CENTER);
            setVerticalAlignment(SwingConstants.CENTER);
            setForeground(Color.white);
            setFont(new Font("sansserif", Font.BOLD, 14));
            /////////// đổ màu gradient cho 2 btn
            GradientPaint gp = new GradientPaint(5, 7, startColorBtnFix, width-20, height-10, endColorBtnFix);
            g2.setPaint(gp);
            g2.fillRoundRect(5, 7, width-20, height-10,10,10);
            ///////////
            if (selected) {
                g2.setColor(new Color(137, 215, 255));
                g2.setStroke(new BasicStroke(2f));
                g2.drawRect(-5, 2, width+9, height);
            }
        }else if (cellType == CellType.BTN2) {
            g2.fillRoundRect(-5, 2, width, height, 6, 6);
            setHorizontalAlignment(SwingConstants.CENTER);
            setVerticalAlignment(SwingConstants.CENTER);
            setForeground(Color.white);
            setFont(new Font("sansserif", Font.BOLD, 14));
//            g2.setColor(startColorBtnSignUp);
//            g2.fillRoundRect(5, 7, width-20, height-10,10,10);
            GradientPaint gp = new GradientPaint(5, 7, startColorBtnSignUp, width-20, height-10, endColorBtnSignUp);
            g2.setPaint(gp);
            g2.fillRoundRect(5, 7, width-20, height-10,10,10);
            if (selected) {
                g2.setColor(new Color(137, 215, 255));
                g2.setStroke(new BasicStroke(2f));
                g2.drawRoundRect(-5, 2, width-2 , height, 6, 6);
            }
        }else if (cellType == CellType.BTN1SELECTED) {
            g2.fillRoundRect(-5, 2, width, height, 6, 6);
            setHorizontalAlignment(SwingConstants.CENTER);
            setVerticalAlignment(SwingConstants.CENTER);
            setForeground(Color.white);
            setFont(new Font("sansserif", Font.BOLD, 14));
            g2.setColor(new Color(192,192,192));
            g2.fillRoundRect(5, 7, width-20, height-10,10,10);
            if (selected) {
                g2.setColor(new Color(137, 215, 255));
                g2.setStroke(new BasicStroke(2f));
                g2.drawRoundRect(-5, 2, width+9 , height, 6, 6);
            }
        }else if (cellType == CellType.BTN2SELECTED) {
            g2.fillRoundRect(-5, 2, width, height, 6, 6);
            setHorizontalAlignment(SwingConstants.CENTER);
            setVerticalAlignment(SwingConstants.CENTER);
            setForeground(Color.white);
            setFont(new Font("sansserif", Font.BOLD, 14));
            GradientPaint gp = new GradientPaint(5, 7, startColorBtnSignUp, width-20, height-10, endColorBtnSignUp);
            g2.setPaint(gp);
            g2.fillRoundRect(5, 7, width-20, height-10,10,10);
            if (selected) {
                g2.setColor(new Color(137, 215, 255));
                g2.setStroke(new BasicStroke(2f));
                g2.drawRoundRect(-5, 2, width-2 , height, 6, 6);
            }
        }else if (cellType == CellType.BTN1HOVERED) {
            g2.fillRoundRect(-5, 2, width, height, 6, 6);
            setHorizontalAlignment(SwingConstants.CENTER);
            setVerticalAlignment(SwingConstants.CENTER);
            setForeground(new Color(153,153,255));
            setFont(new Font("sansserif", Font.BOLD, 14));
            g2.setColor(new Color(153,153,255));
            g2.fillRoundRect(5, 7, width-20, height-10,10,10);
            g2.setColor(new Color(255,255,255));
            g2.fillRoundRect(8, 10, width-25, height-15,10,10);
            if (selected) {
                g2.setColor(new Color(137, 215, 255));
                g2.setStroke(new BasicStroke(2f));
                g2.drawRoundRect(-5, 2, width+9 , height, 6, 6);
            }
        }else if (cellType == CellType.BTN2HOVERED) {
            g2.fillRoundRect(-5, 2, width, height, 6, 6);
            setHorizontalAlignment(SwingConstants.CENTER);
            setVerticalAlignment(SwingConstants.CENTER);
            setForeground(new Color(224,86,253));
            setFont(new Font("sansserif", Font.BOLD, 14));
            g2.setColor(new Color(224,86,253));
            g2.fillRoundRect(5, 7, width-20, height-10,10,10);
            g2.setColor(new Color(255,255,255));
            g2.fillRoundRect(7, 10, width-25, height-15,10,10);
            if (selected) {
                g2.setColor(new Color(137, 215, 255));
                g2.setStroke(new BasicStroke(2f));
                g2.drawRoundRect(-5, 2, width-2 , height, 6, 6);
            }
        }
        else {
            g2.setColor(new Color(245, 245, 245));
            g2.fillRect(0, 0, getWidth(), getHeight());
        }
        super.paintComponent(grphcs);
    }

    public static enum CellType {
        LEFT, RIGHT, CENTER, EMPTY,BTN1,BTN2,BTN1SELECTED,BTN2SELECTED,BTN1HOVERED,BTN2HOVERED
    }
}
