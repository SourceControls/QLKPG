/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdl;

import com.raven.main.FrmMain;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author TuanHung
 */
public class CsdlThongKe {

    private Connection conn = FrmMain.conn;

    public ResultSet selectAllThongKeDoanhThu() throws SQLException {
        String sql = "exec sp_get_thong_ke_doanh_thu";

        Statement st = conn.createStatement();
        return st.executeQuery(sql);

    }
    public ResultSet thongKeGioiTinh() throws SQLException {
        String sql = "EXEC SP_THONG_KE_GIOI_TINH";
        Statement st = FrmMain.conn.createStatement();
        return st.executeQuery(sql);
    }

    public ResultSet thongKeDoTuoi() throws SQLException {
        String sql = "EXEC SP_THONG_KE_DO_TUOI";
        Statement st = FrmMain.conn.createStatement();
        return st.executeQuery(sql);
    }

    public ResultSet selectAllThongKeKhachHang() throws SQLException {
        String sql = "exec SP_THONG_KE_KHACH_HANG";
        Statement st = conn.createStatement();
        return st.executeQuery(sql);

    }

    public ResultSet selectAllThongKeVaoRa() throws SQLException {
        String sql = "exec SP_THONG_KE_VAO_RA";
        Statement st = conn.createStatement();
        return st.executeQuery(sql);

    }

    public ResultSet selectAllDoanhThuTrongKhoang(String tuNgay, String denNgay) throws SQLException {
        String sql = "exec sp_get_thong_ke_doanh_thu_theo_khoang ?,?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setObject(1, tuNgay);
        pst.setObject(2, denNgay);
        return pst.executeQuery();

    }
}
