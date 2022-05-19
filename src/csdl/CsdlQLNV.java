/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdl;

import com.raven.form.FrmKH;
import com.raven.form.FrmNV;
import com.raven.main.FrmMain;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author anhtu
 */
public class CsdlQLNV {

    private static Connection conn = FrmMain.conn;

    public ResultSet selectAllNhanVien(Frame f) {

        
        String selectAllKhachHang = "SELECT *FROM v_nhan_vien order by manv desc";
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
        String select = "SELECT MANV FROM NHANVIEN WHERE CMND=?";

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

        String selectNgoaiTru = "SELECT MANV FROM NHANVIEN WHERE CMND = ? AND MANV != ?";

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
        String select = "SELECT MANV FROM NHANVIEN WHERE SDT=?";
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
        String select = "SELECT MANV FROM NHANVIEN WHERE SDT=? AND MANV !=?";
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
        String select = "SELECT MANV FROM NHANVIEN WHERE EMAIL=? AND MANV != ?";
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

//    public ResultSet selectNVByChucVu(String nghiepVu) {
//        String sql = "SELECT * FROM V_NHAN_VIEN WHERE quanly = 'true'";
//        if (nghiepVu.toLowerCase().equals("nhân viên")) {
//            sql = "SELECT * FROM V_NHAN_VIEN WHERE quanly = 'false'";
//        } else if (nghiepVu.toLowerCase().equals("huấn luyện viên")) {
//            sql = "SELECT * FROM V_NHAN_VIEN WHERE PT = 'true'";
//        } else if (nghiepVu.toLowerCase().equals("còn làm")) {
//            sql = "SELECT * FROM V_NHAN_VIEN WHERE nghilam = 'false'";
//        } else if (nghiepVu.toLowerCase().equals("đã nghỉ")) {
//            sql = "SELECT * FROM V_NHAN_VIEN WHERE nghilam = 'true'";
//        }
//        try {
//            PreparedStatement pst = conn.prepareStatement(sql);
//            return pst.executeQuery();
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(FrmMain.f, ex.getMessage());
//
//        }
//
//        return null;
//    }

    public boolean tonTaiEmail(Frame f, String email) {
        String select = "SELECT MANV FROM NHANVIEN WHERE EMAIL=?";
        try {
            PreparedStatement sql = conn.prepareStatement(select);
            sql.setObject(1, email);
            return sql.executeQuery().next();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }
        return false;
    }

    public boolean updateNV(Frame f, Vector vec) {
        String update = "update NHANVIEN set HOTEN=?, SDT=?,CMND=?,NGAYSINH=?,DIACHI=?,GIOITINH=?,EMAIL=?,PT=?,QUANLY=?,NGHILAM=?,HinhAnh=? where MANV=?";

        try {
            PreparedStatement sql = conn.prepareStatement(update);
            for (int i = 1; i <= 12; i++) {
                sql.setObject(i, vec.get(i - 1));
            }
            return sql.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(FrmNV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public boolean insertNhanVien(Frame f, Vector vec) {
        String insertNV = "Insert into NHANVIEN VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement sql = conn.prepareStatement(insertNV);
            for (int i = 1; i <= 12; i++) {

                sql.setObject(i, vec.get(i - 1));

            }
            if (vec.get(3).toString().isEmpty() || vec.get(5).toString().isEmpty()) {
                sql.setNull(6, java.sql.Types.NVARCHAR);
            }
            if (vec.get(4).toString().isEmpty()) {
                sql.setNull(5, java.sql.Types.DATE);
            }
            return sql.executeUpdate() > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.toString());
            Logger.getLogger(FrmNV.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;

    }

    public void insertTaiKhoan(String tenDangNhap, String matKhau) throws SQLException {
        String sql = "exec sp_tao_tk_NV ?,?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, tenDangNhap);
        pst.setString(2, matKhau);
        pst.execute();
    }

    public ResultSet selectNhanVien(Frame f, String MAKH) {
        String findById = " select * from  v_NHAN_VIEN WHERE MANV =?";
        try {
            PreparedStatement sql = conn.prepareStatement(findById);
            sql.setObject(1, MAKH);
            return sql.executeQuery();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }
        return null;
    }

    public ResultSet findByKey(String key,String filterKey) {
        String sql ;
        System.out.println(filterKey==null);
        if(filterKey==null){
            sql = "SELECT * FROM V_NHAN_VIEN WHERE hoten like N'%" + key + "%' or sdt like '%" + key + "%' order by manv desc";
            
        }else{
             sql = "SELECT * FROM V_NHAN_VIEN WHERE quanly = 'true' and  (hoten like N'%" + key + "%' or sdt like '%" + key + "%') order by manv desc";
            if (filterKey.toLowerCase().equals("nhân viên")) {
                sql = "SELECT * FROM V_NHAN_VIEN WHERE quanly = 'false' and  (hoten like N'%" + key + "%' or sdt like '%" + key + "%') order by manv desc";
            } else if (filterKey.toLowerCase().equals("huấn luyện viên")) {
                sql = "SELECT * FROM V_NHAN_VIEN WHERE PT = 'true'  and  (hoten like N'%" + key + "%' or sdt like '%" + key + "%') order by manv desc";
            } else if (filterKey.toLowerCase().equals("còn làm")) {
                sql = "SELECT * FROM V_NHAN_VIEN WHERE nghilam = 'false' and (hoten like N'%" + key + "%' or sdt like '%" + key + "%') order by manv desc";
            } else if (filterKey.toLowerCase().equals("đã nghỉ")) {
                sql = "SELECT * FROM V_NHAN_VIEN WHERE nghilam = 'true' and  (hoten like N'%" + key + "%' or sdt like '%" + key + "%') order by manv desc";
            }
        }
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            return pst.executeQuery();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(FrmMain.f, ex.getMessage());

        }

        return null;
        
//        String sql = "select * from "
//                + "V_nhan_vien where hoten like N'%" + key + "%' or sdt like '%" + key + "%' order by manv desc";
//        try {
//            Statement st = conn.createStatement();
//            return st.executeQuery(sql);
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(f, ex.getMessage());
//        }
//        return null;
    }
    public void moKhoaTaiKhoan(String maNV) throws SQLException{
          String sql = "Exec SP_MO_KHOA_TK_NV ?";
        PreparedStatement pst;
        pst = conn.prepareStatement(sql);
        pst.setObject(1, maNV);
        pst.executeQuery();      
    }
        public void khoaTaiKhoan(String maNV) throws SQLException {
        String sql = "Exec SP_KHOA_TK_NV ?";
        PreparedStatement pst;
        pst = conn.prepareStatement(sql);
        pst.setObject(1, maNV);
        pst.executeQuery();
    }

}
