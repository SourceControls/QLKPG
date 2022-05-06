/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdl;

import static com.raven.main.FrmMain.conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.raven.main.FrmMain;

/**
 *
 * @author TuanHung
 */
public class CsdlDN {

    public CsdlDN() {
    }

    public static ResultSet dangNhap(String tenDangNhap, String matKhau) throws SQLException {
        String sql = "EXEC SP_NV_DANGNHAP ?, ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setObject(1, tenDangNhap);
        pst.setObject(2, matKhau);
        return pst.executeQuery();
    }
}
