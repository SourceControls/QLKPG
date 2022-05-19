/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdl;

import com.raven.form.FrmKH;
import java.awt.Frame;
import java.util.Vector;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import com.raven.main.FrmMain;
import javax.swing.JFrame;

/**
 *
 * @author TuanHung
 */
public class CsdlQLKH {

    private static Connection conn = FrmMain.conn;

    public ResultSet selectAllKhachHang(Frame f) {

        FrmKH.dtblDSKH.setRowCount(0);

        String selectAllKhachHang = "SELECT MAKH,HOTEN, SDT,GIOITINH,NGAYSINH,CMND,EMAIL,DIACHI,HANGKH FROM dbo.[KHACHHANG] order by makh desc";
        Statement st;
        try {
            st = FrmMain.conn.createStatement();
            return st.executeQuery(selectAllKhachHang);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }
        return null;

    }

    public ResultSet insertVanTay(String maKH) throws SQLException {
        String sql = "INSERT INTO VANTAYKHACH(MAKH) VALUES(?)";

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setObject(1, maKH);
        if (pst.executeUpdate() > 0) {
            sql = "select max(IDVANTAY) from VANTAYKHACH";
            pst = conn.prepareStatement(sql);
            return pst.executeQuery();
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

//    public ResultSet selectKHByHang(String hangKH) {
//        String findById = " select MAKH,HOTEN, SDT,GIOITINH,NGAYSINH,CMND,EMAIL,DIACHI,HANGKH from  KHACHHANG WHERE HANGKH =? order by makh desc";
//        try {
//            PreparedStatement sql = conn.prepareStatement(findById);
//            sql.setObject(1, hangKH);
//            return sql.executeQuery();
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(FrmMain.f, ex.getMessage());
//
//        }
//
//        return null;
//    }

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
        String update = "update KHACHHANG set HOTEN=?, SDT=?, GIOITINH=?, NGAYSINH=?, CMND=?, EMAIL=?, DIACHI=?,HINHANH = ? where MAKH=?";

        try {
            PreparedStatement sql = conn.prepareStatement(update);
            for (int i = 1; i <= 9; i++) {
                sql.setObject(i, vec.get(i - 1));
            }
            if (vec.get(3).toString().isEmpty()) {
                sql.setNull(4, java.sql.Types.DATE);
            }
            for (int i = 4; i < vec.size() - 1; i++) {
                if (vec.get(i).toString().isEmpty()) {
                    sql.setNull(i + 1, java.sql.Types.NVARCHAR);
                }
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

            if (vec.get(4).toString().isEmpty()) {
                sql.setNull(5, java.sql.Types.DATE);
            }
            for (int i = 5; i < vec.size(); i++) {
                if (vec.get(i).toString().isEmpty()) {
                    sql.setNull(i + 1, java.sql.Types.NVARCHAR);
                }

            }
            return sql.executeUpdate() > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());

        }
        return false;

    }

    public ResultSet selectKhachHang(JFrame f, String MAKH) {
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

    public ResultSet findAndFilter(Frame f, String key,String hang) {
        String sql;
        if(hang != null)
            sql = "select makh,hoten,sdt,gioitinh,ngaysinh,cmnd,email,diachi,hangkh from khachhang where (hoten like N'%" + key + "%' or sdt like '%" + key + "%') and hangkh=N'"+hang+"'order by makh desc";
        else  
            sql="select makh,hoten,sdt,gioitinh,ngaysinh,cmnd,email,diachi,hangkh from khachhang where hoten like N'%" + key + "%' or sdt like '%" + key + "%' order by makh desc";
        try {
            Statement st = conn.createStatement();
            return st.executeQuery(sql);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }
        return null;
    }

}
