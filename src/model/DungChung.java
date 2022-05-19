/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import com.raven.main.FrmMain;
import java.awt.AWTException;
import java.awt.Component;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Robot;
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
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TuanHung
 */
public class DungChung {

    public static void readImg(JLabel lbHinhAnh, String imgURL){
        int width = 190;
        int height = 255;
        if (imgURL.isEmpty() || imgURL == null) {
            imgURL = "/anhKH/default.png";
        }
        try {
            BufferedImage img;
            if (imgURL.contains(":")) //nếu là đường dẫn từ gốc, tức là chọn mới hình ảnh 
            {
                img = ImageIO.read(new File(imgURL));
            } else {
                img = ImageIO.read(DungChung.class.getResource(imgURL));
            }
            lbHinhAnh.setIcon(new ImageIcon(img.getScaledInstance(width, height, Image.SCALE_SMOOTH)));

        } catch (Exception ex) {
            BufferedImage img;
            try {
                img = ImageIO.read(DungChung.class.getResource("/anhKH/default.png"));
                lbHinhAnh.setIcon(new ImageIcon(img.getScaledInstance(width, height, Image.SCALE_SMOOTH)));
            } catch (IOException ex1) {
                Logger.getLogger(DungChung.class.getName()).log(Level.SEVERE, null, ex1);
            }
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
                for (int i = 1; i <= dtbl.getColumnCount() & i <= rsmd.getColumnCount() ; i++) {
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
        if (date.contains("-")) {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        }
        Calendar c = Calendar.getInstance();
        String output = "";
        try {
            c.setTime(sdf.parse(date));
            c.add(Calendar.DATE, day);  // number of days to add
            output = sdf.format(c.getTime());  // dt is now the new date
        } catch (ParseException ex) {
            System.out.println(ex.toString());
        }
        return output;
    }

    public static void componentToImg(Component com, String targetFile) {
        Robot robot;
        try {
            TimeUnit.SECONDS.sleep(1);
            robot = new Robot();
            Point p = com.getLocationOnScreen();
            BufferedImage bi = robot.createScreenCapture(new Rectangle((int) p.getX(), (int) p.getY(), com.getWidth(), com.getHeight()));
            ImageIO.write(bi, "png", new File(targetFile));
        } catch (AWTException | IOException | InterruptedException ex) {
        }

    }

    public static String selectTargetFile(String fileName) {
        System.out.println(fileName);
        FileDialog fd;
        fd = new java.awt.FileDialog((java.awt.Frame) null, "Chọn Nơi Lưu Tệp", FileDialog.SAVE);
        fd.setFile(fileName);
        fd.setVisible(true);
        return fd.getDirectory() + fd.getFile();
    }



}
