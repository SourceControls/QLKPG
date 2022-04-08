/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdl;

import java.awt.Frame;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import com.raven.main.FrmMain;
import java.sql.Connection;
import com.raven.form.FrmDoThongSo;

/**
 *
 * @author TuanHung
 */
public class CsdlDTS {
    
    private Connection conn = FrmMain.conn;
    
    
       public ResultSet selectAllThongSo(Frame f, String maKH) {
        String selectALLThongSo = "SELECT * FROM DOTHONGSOCOTHE WHERE MAKH = ?";

        try {
            PreparedStatement sql = conn.prepareStatement(selectALLThongSo);
            sql.setObject(1, maKH);
            ResultSet rs = sql.executeQuery();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }
        return null;
    }
          public boolean insertThongSo(Frame f, Vector vec) {
        String insertThongSo = "INSERT INTO DOTHONGSOCOTHE VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement sql = conn.prepareStatement(insertThongSo);
            for (int i = 0; i < vec.size(); i++) {
                sql.setObject(i + 1, vec.get(i));
            }
            return sql.executeUpdate() > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, "Lưu thất bại! " + ex.getMessage());
        }
        return false;

    }

     public ResultSet getBMI(Frame f,String maKH, String nam){
        String selectALLThongSo = "EXEC SP_LAY_BMI_CUA_KH_GROUP_BY_THANG ?,?";

        try {
            PreparedStatement sql = conn.prepareStatement(selectALLThongSo);
            sql.setObject(1, maKH);
            sql.setObject(2, nam);
            ResultSet rs = sql.executeQuery();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }
        return null;         
     }
          
}
