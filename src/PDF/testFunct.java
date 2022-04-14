/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PDF;

import com.raven.main.FrmMain;
import java.awt.Color;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author TuanHung
 */
public class testFunct {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws IOException, SQLException {
        connectDatabase();
//        PhieuDangKi pdk = new PhieuDangKi("PDK00001");
        PhieuThuTien ptt = new PhieuThuTien("PTT0001");
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
