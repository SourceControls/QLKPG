/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PDF;

import com.raven.form.FrmThongKe;
import com.raven.main.FrmMain;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import model.DungChung;

/**
 *
 * @author TuanHung
 */
public class testFunct {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException, SQLException {
//        connectDatabase();
//        PhieuDangKiPDF pdk = new PhieuDangKiPDF("PDK00001");
//        PhieuThuTienPDF ptt = new PhieuThuTienPDF("PTT0001");

//     DoThongSo d = new DoThongSo("KH001","Bùi Tuấn Hùng","2021-05-09","NAM","2001-05-09");

     
//        FrmThongKe frmThongKe = new FrmThongKe();
        
    }

    public static void connectDatabase() {
        String host = "jdbc:sqlserver://localhost:1433; databasename = QLKPG";
        String uname = "sa";
        String upass = "123";
        try {
            FrmMain.conn = (java.sql.Connection) DriverManager.getConnection(host, uname, upass);
            //conn = conn;
            if (FrmMain.conn != null) {
                System.out.println("Ket noi server thanh cong !");
            }

        } catch (Exception ex) {
            System.out.println("connectDatabase: " + ex.toString());
        }
    }

}
