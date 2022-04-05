/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdl;

import java.awt.Frame;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import com.raven.main.FrmMain;
/**
 *
 * @author TuanHung
 */
public class CsdlQLQVT {
    
    private Connection conn = FrmMain.conn;

    public ResultSet selectAllQuetVanTay(Frame f) {
        String sql = "SELECT *FROM V_KHACHQUETVANTAY oder by STT DESC";
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

    public ResultSet selectPDK(Frame f,String STT) {
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

    public ResultSet selectKHCoPDKHopLe(Frame f) {
        String sql = "EXEC SP_DSPDK_HOPLE";
        ResultSet rs = null;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }
        return rs;
    }
    
    public boolean insertKhachQuetVanTay(Frame f, String ngayGio, String maPDK){
         String sql = "INSERT INTO KHACHQUETVANTAY(NGAYGIO,MAPDK) VALUES(?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            System.out.println(ngayGio + " " + maPDK);
            pst.setObject(1, ngayGio);
            pst.setObject(2, maPDK);
            return pst.executeUpdate() >0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }
        return false;
    }
    
    public ResultSet selectKhachQuetVanTayTrongKhoang(Frame f, String tuNgay, String denNgay){
        String sql = "SELECT * FROM V_KHACHQUETVANTAY WHERE NGAYGIO between ? AND ? ";
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
