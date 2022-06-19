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

/**
 *
 * @author TuanHung
 */
public class CsdlDTS {

    private Connection conn = FrmMain.conn;

    public ResultSet selectAllThongSo(String maKH) {
        String selectALLThongSo = "SELECT * FROM DOTHONGSOCOTHE WHERE MAKH = ? order by ngay desc";

        try {
            PreparedStatement sql = conn.prepareStatement(selectALLThongSo);
            sql.setObject(1, maKH);
            ResultSet rs = sql.executeQuery();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(FrmMain.f, ex.getMessage());
        }
        return null;
    }

    public ResultSet selectThongSo(String maKH, String ngay) {
        String selectALLThongSo = "SELECT * FROM DOTHONGSOCOTHE WHERE MAKH = ? AND NGAY = ?";
        try {
            PreparedStatement sql = conn.prepareStatement(selectALLThongSo);
            sql.setObject(1, maKH);
                        sql.setObject(2, ngay);

            ResultSet rs = sql.executeQuery();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(FrmMain.f, ex.getMessage());
        }
        return null;
    }

    public boolean insertThongSo(Vector vec) {
        String insertThongSo = "INSERT INTO DOTHONGSOCOTHE VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement sql = conn.prepareStatement(insertThongSo);
            for (int i = 0; i < vec.size(); i++) {
                sql.setObject(i + 1, vec.get(i));
            }
            return sql.executeUpdate() > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(FrmMain.f, ex.getMessage());
        }
        return false;

    }

    public boolean dolaiThongso(String makh, String ngay) {
        String insertThongSo = "delete DOTHONGSOCOTHE where makh=? and ngay=?";
        try {
            PreparedStatement sql = conn.prepareStatement(insertThongSo);
            sql.setObject(1, makh);
            sql.setObject(2, ngay);

            return sql.executeUpdate() > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(FrmMain.f, "xóa kết quả trước thất bại !\n " + ex.getMessage());
        }
        return false;

    }

    public ResultSet getBMI(String maKH) {
        String selectALLThongSo = "EXEC SP_GET_BMI ?";

        try {
            PreparedStatement sql = conn.prepareStatement(selectALLThongSo);
            sql.setObject(1, maKH);
            ResultSet rs = sql.executeQuery();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(FrmMain.f, ex.getMessage());
        }
        return null;
    }

    public ResultSet getBMI(Frame f, String maKH, int thang, int nam) {
        String selectALLThongSo = "EXEC SP_LAY_BMI_CUA_KH_GROUP_BY_TUAN ?,?,?";

        try {
            PreparedStatement sql = conn.prepareStatement(selectALLThongSo);
            sql.setObject(1, maKH);
            sql.setObject(2, thang);
            sql.setObject(3, nam);
            ResultSet rs = sql.executeQuery();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(FrmMain.f, ex.getMessage());
        }
        return null;
    }

}
