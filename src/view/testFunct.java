/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author TuanHung
 */
public class testFunct {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        for (int i = 1; i <= 12; i++) {
            System.out.println(tuDongTinhHanLanToi("2001/09/05", i));
         
        }
        
    }
   public static String tuDongTinhHanLanToi(String ngayThu, int sothang) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(ngayThu));
            c.add(Calendar.DATE, sothang * 30);  // number of days to add
            ngayThu = sdf.format(c.getTime());  // dt is now the new date
            // txtNgayKetThuc.setText(dt);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return ngayThu;
    }
}
