/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdl;

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
import javax.swing.table.DefaultTableModel;
import model.DKDV;
import com.raven.main.FrmMain;

public class CsdlDKDV {

    private Connection conn = FrmMain.conn;
    public ResultSet selectAllPDK() {
      
        String sql = "SELECT * FROM V_PDK order by mapdk desc";
       
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(FrmMain.f, ex.getMessage());
        }

        return null;
    }

//    public ResultSet selectPDKByTrangThai(String trangThai) {
//        String sql = "SELECT * FROM V_PDK WHERE TRANGTHAI = ? order by mapdk desc";
//        try {
//            PreparedStatement pst = conn.prepareStatement(sql);
//            pst.setObject(1, trangThai);
//            return pst.executeQuery();
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(FrmMain.f, ex.getMessage());
//        }
//        return null;
//    }

    public boolean huyPDK(String maPDK) {
        String sql = "UPDATE PHIEUDK SET TRANGTHAI = N'ĐÃ HỦY' WHERE MAPDK = ?";
        

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setObject(1, maPDK);
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(FrmMain.f, ex.getMessage());
        }
        return false;
    }





    public ResultSet timKiem(String key) {
        String sql = "select * from KHACHHANG where (makh like '%" + key + "%')  or (hoten like N'%" + key + "%') or (sdt like '%" + key + "%')";
        try {
            Statement st = conn.createStatement();
            return st.executeQuery(sql);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(FrmMain.f, ex.getMessage());
        }
        return null;
    }

    public ResultSet selectPDK(Frame f, String maPDK) {
        String sql = "select * from PHIEUDK where MAPDK = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, maPDK);
            return pst.executeQuery();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }
        return null;
    }

    public ResultSet findAndFilter(String key,String trangthai) {
        String sql;
        
        
        try {
            PreparedStatement pst;
            if(trangthai==null){
                sql = "select V_PDK.* " +
                "from V_PDK inner join " +
                "	(select MAKH from khachhang where hoten like Concat('%','"+key+"','%') or sdt like Concat('%','"+key+"','%')) KH" +
                "	on V_PDK.MAKH = kh.MAKH order by mapdk desc";
            }else {
                sql= "select V_PDK.* " +
                "from V_PDK inner join " +
                "	(select MAKH from khachhang where hoten like Concat('%','"+key+"','%') or sdt like Concat('%','"+key+"','%')) KH" +
                "	on V_PDK.MAKH = kh.MAKH and trangthai=N'"+trangthai+"' order by mapdk desc" ;
            }
            pst = conn.prepareStatement(sql);
            return pst.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(FrmMain.f, ex.getMessage());
        }
        return null;
    }

}
