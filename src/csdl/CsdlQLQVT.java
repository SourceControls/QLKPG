/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdl;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import com.raven.main.FrmMain;

/**
 *
 * @author TuanHung
 */
public class CsdlQLQVT {

    private Connection conn = FrmMain.conn;

    public ResultSet selectAllQuetVanTay(Frame f) {
        String sql = "SELECT *FROM V_KHACHQUETVANTAY order by STT DESC";
        ResultSet rs = null;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }

        return null;    
    }

    public ResultSet selectKhachHang(Frame f, String STT) {
        String sql = "EXEC SP_TIMKH_FROM_KHACHQUETVANTAY ?";
        ResultSet rs = null;

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setObject(1, STT);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }
        return rs;
    }

    public ResultSet selectPDK(Frame f, String STT) {
        String sql = "EXEC SP_TIMPDK_FROM_KHACHQUETVANTAY ?";
        ResultSet rs = null;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setObject(1, STT);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }
        return rs;
    }



    public boolean insert1KhachQuetVanTay(int maVanTay) throws SQLException {
        String sql = "exec SP_INSERT_VANTAY_VAORA ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setObject(1, maVanTay);
        return pst.execute();

    }

    public ResultSet insertNhieuKhachQuetVanTay() throws SQLException {
        String sql = "EXEC SP_INSERT_NHIEU_VANTAY_VAORA";
        PreparedStatement pst = conn.prepareStatement(sql);
        return pst.executeQuery();

    }

    public ResultSet selectKhachQuetVanTayTrongKhoang(Frame f, String tuNgay, String denNgay) {
        String sql = "SELECT * FROM V_KHACHQUETVANTAY WHERE NGAYGIO between ? AND ?  order by stt desc";
        ResultSet rs = null;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setObject(1, tuNgay);
            pst.setObject(2, denNgay);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }
        return rs;
    }

}
