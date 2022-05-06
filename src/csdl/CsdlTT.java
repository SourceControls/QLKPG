/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdl;

import com.raven.form.FrmThanhToan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.Types;
import javax.swing.JOptionPane;
import com.raven.main.FrmMain;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;


/**
 *
 * @author TuanHung
 */
public class CsdlTT {

    private Connection conn = FrmMain.conn;

    public ResultSet selectThongTinTraGop(String maPDK) {
        String sql = "exec SP_THONGTIN_TRAGOP ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, maPDK);
            return pst.executeQuery();
        } catch (SQLException ex) {
            printStackTrace();
        }
        return null;
    }

    public ResultSet selectAllPTT(String maPDK) {
        String sql = "select * FROM V_PTT where mapdk = ? ORDER BY MAPTT DESC";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, maPDK);
            return pst.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(FrmMain.f, ex.getMessage());
        }
        return null;
    }

    public boolean insertPTT(Vector vec) {
        String sql = "insert into phieuthutien values (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            for (int i = 1; i <= vec.size(); i++) {
                if (i == 5 & vec.get(i - 1).toString().isEmpty()) {
                    pst.setNull(i, Types.DATE);
                } else {
                    pst.setObject(i, vec.get(i - 1));
                }
            }
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(FrmMain.f, ex.getMessage());
        }

        return false;
    }
    

    public String getMaPTT() {
        String sql = "exec get_id 'PHIEUTHUTIEN' ";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(FrmMain.f, ex.getMessage());
        }

        return null;
    }
}
