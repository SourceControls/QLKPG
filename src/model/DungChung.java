/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Frame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author TuanHung
 */
public class DungChung {

    public static void readImg(Frame f, JLabel lbHinhAnh, String imgURL) {

        int width = 190;
        int height = 255;
        if(imgURL.isEmpty())
            imgURL = "/anhKH/default.png";
        try {
            BufferedImage img;
            if (imgURL.contains(":")) //nếu là đường dẫn từ gốc, tức là chọn mới hình ảnh 
            {
                img = ImageIO.read(new File(imgURL));
            } else {
                img = ImageIO.read(DungChung.class.getResource(imgURL));
            }
            lbHinhAnh.setIcon(new ImageIcon(img.getScaledInstance(width, height, Image.SCALE_SMOOTH)));

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }
    }

    public static boolean checkDateFormat(String date) {
        if (date.matches("[0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2}")) {
            return true;
        }
        if (date.matches("[0-9]{4}[/]{1}[0-9]{2}[/]{1}[0-9]{2}")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            sdf.setLenient(false);
            try {
                Date d1 = sdf.parse(date);
                return true;
            } catch (ParseException e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void fillTable(DefaultTableModel dtbl, ResultSet rs) {

        dtbl.setRowCount(0);
        ResultSetMetaData rsmd;
        Vector vec;
        if (rs == null) {
            return;
        }
        try {
            rsmd = rs.getMetaData();
            while (rs.next()) {
                vec = new Vector();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    vec.add(rs.getObject(i));
                }
                dtbl.addRow(vec);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLQVT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String dateAdd(String date, int day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar c = Calendar.getInstance();
        String output = "";
        try {
            c.setTime(sdf.parse(date));
            c.add(Calendar.DATE, day);  // number of days to add
            output = sdf.format(c.getTime());  // dt is now the new date
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return output;
    }
}
