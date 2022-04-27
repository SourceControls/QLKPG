/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdl;

import com.raven.form.FrmDangKiDichVu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.DKDV;
import com.raven.main.FrmMain;

/**
 *
 * @author TuanHung
 */
public class CsdlDK {

    private static Connection conn = FrmMain.conn;
    
    public boolean insertPDK(String maPDK,String ngaydk, String tongtien, String ghichu,String makh, String manv, String madv, String thue, String khuyenMai) {
        //không cần set ngày bắt đầu, ngày kết thúc và trạng thái, trong db đã có trigger auto
        ResultSet rs = null;
        try {

            PreparedStatement ps = conn.prepareStatement("insert into phieudk values (?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, maPDK);
            ps.setString(2, ngaydk);

            ps.setNull(3, java.sql.Types.DATE);
            ps.setNull(4, java.sql.Types.DATE);

            ps.setString(5, tongtien);
            ps.setString(6, "CHỜ KÍCH HOẠT");
            ps.setString(7, ghichu);

            ps.setString(8, makh);
            ps.setString(9, manv);
            ps.setString(10, madv);
            ps.setString(11, thue);
            ps.setString(12, khuyenMai);
            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(FrmMain.f, "Đăng kí thất bại" + ex.toString());
        }
        return false;
    }
    

    
   public String maPDKtuTang() {

        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("EXEC get_ID 'PHIEUDK'");
            if (rs.next()) {
                return rs.getString(1);
            }

        } catch (Exception ex) {
            System.out.println("maPDKtuTang: " + ex.toString());
        }

        return null;
    }

 public ResultSet rsKhuyenMai(String maKH) {
        String sql = "EXEC SP_KM_THEO_KH ?";
        System.out.println(maKH);
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setObject(1, maKH);
            return pst.executeQuery();
        } catch (Exception ex) {
            System.out.println(ex.toString());
            JOptionPane.showMessageDialog(FrmDangKiDichVu.f, ex.toString()); 

        }
        return null;
    }
    public ResultSet rsDichVu() {
       
        ResultSet rs = null;
        try {
            Statement st = conn.createStatement();
            rs = st.executeQuery("select * from dichvu order by songaysudung");            
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return rs;
    }
    
}
