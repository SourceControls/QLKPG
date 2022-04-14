/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdl;

import com.raven.form.Form1;
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
public class CsdlQLKH {

    private static Connection conn = FrmMain.conn;

    public ResultSet selectAllKhachHang(Frame f) {
        
        Form1.dtblDSKH.setRowCount(0);
        
        String selectAllKhachHang = "SELECT MAKH,HOTEN, SDT,GIOITINH,NGAYSINH,CMND,EMAIL,DIACHI FROM dbo.[KHACHHANG]";
        Statement st;
        try {
            st = FrmMain.conn.createStatement();
            return st.executeQuery(selectAllKhachHang);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }
        return null;

    }

    public boolean tonTaiCMND(Frame f, String cmnd) {
        String select = "SELECT MAKH FROM KHACHHANG WHERE CMND=?";

        try {
            PreparedStatement sql = conn.prepareStatement(select);
            sql.setObject(1, cmnd);
            return sql.executeQuery().next();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }
        return false;
    }

    public boolean tonTaiCMNDNgoaiTru(Frame f, String cmnd, String maKH) {

        String selectNgoaiTru = "SELECT MAKH FROM KHACHHANG WHERE CMND = ? AND MAKH != ?";

        try {
            PreparedStatement sql = conn.prepareStatement(selectNgoaiTru);
            sql.setObject(1, cmnd);
            sql.setObject(2, maKH);
            return sql.executeQuery().next();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }
        return false;
    }

    public boolean tonTaiSDT(Frame f, String SDT) {
        String select = "SELECT MAKH FROM KHACHHANG WHERE SDT=?";
        try {
            PreparedStatement sql = conn.prepareStatement(select);
            sql.setObject(1, SDT);
            return sql.executeQuery().next();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }
        return false;
    }

    public boolean tonTaiSDTNgoaiTru(Frame f, String SDT, String maKH) {
        String select = "SELECT MAKH FROM KHACHHANG WHERE SDT=? AND MAKH !=?";
        try {
            PreparedStatement sql = conn.prepareStatement(select);
            sql.setObject(1, SDT);
            sql.setObject(2, maKH);
            return sql.executeQuery().next();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }
        return false;
    }

    public boolean tonTaiEmailNgoaiTru(Frame f, String email, String maKH) {
        String select = "SELECT MAKH FROM KHACHHANG WHERE EMAIL=? AND MAKH != ?";
        try {
            PreparedStatement sql = conn.prepareStatement(select);
            sql.setObject(1, email);
            sql.setObject(2, maKH);
            return sql.executeQuery().next();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }
        return false;
    }
    public ResultSet selectKHByHang(String hangKH){
        String findById = " select *from  KHACHHANG WHERE HANGKH =?";
        try {
            PreparedStatement sql = conn.prepareStatement(findById);
            sql.setObject(1, hangKH);
            return sql.executeQuery();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(FrmMain.f, ex.getMessage());

        }

        return null;        
    }
    public boolean tonTaiEmail(Frame f, String email) {
        String select = "SELECT MAKH FROM KHACHHANG WHERE EMAIL=?";
        try {
            PreparedStatement sql = conn.prepareStatement(select);
            sql.setObject(1, email);
            return sql.executeQuery().next();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }
        return false;
    }

    public boolean updateKhachHang(Frame f, Vector vec) {
        String update = "update KHACHHANG set HOTEN=?, CMND=?, GIOITINH=?, NGAYSINH=?, SDT=?, EMAIL=?, DIACHI=?,HINHANH = ? where MAKH=?";

        try {
            PreparedStatement sql = conn.prepareStatement(update);
            for (int i = 1; i <= 9; i++) {
                sql.setObject(i, vec.get(i-1));
            }
            return sql.executeUpdate() > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }   
        return false;

    }

    public boolean insertKhachHang(Frame f, Vector vec) {
        String insertKhachHang = "Insert into KHACHHANG VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement sql = conn.prepareStatement(insertKhachHang);
            for (int i = 1; i <= 10; i++) {
               
                sql.setObject(i, vec.get(i - 1));

            }
            if(vec.get(5).toString().isEmpty())
                     sql.setNull(6, java.sql.Types.NVARCHAR);
            if(vec.get(4).toString().isEmpty())
                    sql.setNull(5, java.sql.Types.DATE);
            return sql.executeUpdate() > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());

        }
        return false;

    }

    public ResultSet selectKhachHang(Frame f, String MAKH) {
        String findById = " select *from  KHACHHANG WHERE MAKH =?";
        try {
            PreparedStatement sql = conn.prepareStatement(findById);
            sql.setObject(1, MAKH);
            return sql.executeQuery();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }
        return null;
    }

    public ResultSet findByKey(Frame f, String key){
        String sql = "select makh,hoten,sdt,gioitinh,ngaysinh,cmnd,email,diachi from khachhang where hoten like N'%" + key + "%' or sdt like '%" + key + "%'";
        try {

            Statement st = conn.createStatement();
            return st.executeQuery(sql);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }
        return null;
    }
    

}
