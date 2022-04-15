/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import csdl.*;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import com.raven.form.FrmDangKiDichVu;
import com.raven.main.FrmMain;
import com.raven.form.FrmPDK;
import com.raven.form.FrmThanhToan;
import com.raven.swing.TableColumn;

/**
 *
 * @author TuanHung
 */
public class DKDV {

    
    private Connection conn = FrmMain.conn;
    public static CsdlDKDV csdlDKDV = new CsdlDKDV();

    public void getDataForTblDangKiDichVu() {
        DungChung.fillTable(FrmPDK.dtblPDK, csdlDKDV.selectAllPDK());
    }

    public void huyDangKi() {
        int row = tblPDK.getSelectedRow();
        if (row == -1) {
            return;
        }
        String trangThaiPDK = tblPDK.getValueAt(row, 10).toString();
        if (trangThaiPDK.equals("ĐÃ HỦY") | trangThaiPDK.equals("HẾT HẠN")) {
            JOptionPane.showMessageDialog(f, "Phiếu đã hết hạn hoặc đã hủy trước đó!");
            return;
        }
        if (csdlDKDV.huyPDK(tblPDK.getValueAt(row, 0).toString())) {
            JOptionPane.showMessageDialog(f, "Hủy Phiếu Đăng Kí Thành Công");
            getDataForTblDangKiDichVu();
        }

    }

    public String maPTTtuTang() {

        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("EXEC get_ID 'PHIEUTHUTIEN'");
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception ex) {
            System.out.println("maPTT: " + ex.toString());
        }
        return null;
    }


    public void dumpDataFromTblPDKToFields() {
        int row = tblPDK.getSelectedRow();
        if (row != -1) {
            try {

                ResultSet rs = QLKH.csdlQLKH.selectKhachHang(f, tblPDK.getValueAt(row, 1).toString());

                if (rs.next()) {

                    DungChung.readImg(f, lbHinhAnhKhachQLDK, rs.getString("HINHANH"));
                    lbMaKhachHang.setText(rs.getString("MAKH"));
                    lbHoTen.setText(rs.getString("HOTEN"));
                    lbCMND.setText(rs.getString("CMND"));
                    lbGioiTinh.setText(rs.getString("GIOITINH"));
                    lbNgaySinh.setText(rs.getString("NGAYSINH"));
                    lbSDT.setText(rs.getString("SDT"));
                    lbEmail.setText(rs.getString("EMAIL"));
                    lbDiaChi.setText(rs.getString("DIACHI"));
                    lbHangKhachHang.setText(rs.getString("HANGKH"));
                }

                rs = csdlDKDV.selectPDK(f, tblPDK.getValueAt(row, 0).toString());
                if (rs.next()) {
                    txtGhiChuQLDK.setText(rs.getString("GHICHU"));
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(f, ex.getMessage());
            }
        }

    }

    public void txtTimKiemDangKiKeyReleased() {
        lamTrangTextPDK();
        DungChung.fillTable(FrmPDK.dtblPDK, csdlDKDV.selectPDKByKey(txtTimKiemDangKi.getText()));
    }

    public void lamTrangTextPDK() {
        lbMaKhachHang.setText("");
        lbHoTen.setText("");
        lbCMND.setText("");
        lbDiaChi.setText("");
        lbEmail.setText("");
        lbHangKhachHang.setText("");
        lbSDT.setText("");
        lbGioiTinh.setText("");
        lbNgaySinh.setText("");
        lbHinhAnhKhachQLDK.setIcon(new ImageIcon(""));
    }

    public void thanhToan(FrmThanhToan frmThanhToan) {
        int row = tblPDK.getSelectedRow();
        if(tblPDK.getValueAt(tblPDK.getSelectedRow(),10).toString().equals("ĐÃ HỦY")){
            JOptionPane.showMessageDialog(frmThanhToan, "Phiếu đã hủy !");
            return;
        }
        System.out.println(tblPDK.getValueAt(tblPDK.getSelectedRow(),10).toString() );
        if (row != -1) {

            frmThanhToan = new FrmThanhToan(tblPDK.getValueAt(row, 0).toString(),
                    tblPDK.getValueAt(row, 1).toString(),
                    tblPDK.getValueAt(row, 10).toString());

        }
    }

    public void luuGhiChuDangKi() {
        try {
            PreparedStatement ps = conn.prepareStatement("update phieudk set ghichu=N'" + txtGhiChuQLDK.getText() + "' where mapdk='" + tblPDK.getValueAt(tblPDK.getSelectedRow(), 0).toString()
                    + "' ");
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(f, "Lưu thành công !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }
    }



    public void filterPDK() {
        if (cbTrangThaiPDK.getSelectedItem().toString().equals("None")) {
            getDataForTblDangKiDichVu();
            return;
        }
        DungChung.fillTable(FrmPDK.dtblPDK, csdlDKDV.selectPDKByTrangThai(cbTrangThaiPDK.getSelectedItem().toString()));
    }
    Frame f;
    
    JTable tblPDK;
    JLabel lbHinhAnhKhachQLDK;
    JLabel lbMaKhachHang;
    JLabel lbHoTen;
    JLabel lbCMND;
    JLabel lbGioiTinh;
    JLabel lbNgaySinh;
    JLabel lbEmail;
    JLabel lbSDT;
    JLabel lbDiaChi;
    JLabel lbHangKhachHang;
    JTextArea txtGhiChuQLDK;

    JTextField txtTimKiemDangKi;
    JLabel lbLinkHinhAnh;
    JComboBox cbTrangThaiPDK;

    public DKDV(TableColumn tblPDK, JLabel lbHinhAnhKhachQLDK, JLabel lbMaKhachHang, JLabel lbHoTen, JLabel lbCMND, JLabel lbGioiTinh, JLabel lbNgaySinh, JLabel lbEmail, JLabel lbSDT, JLabel lbDiaChi, JLabel lbHangKhachHang, JTextArea txtGhiChuQLDK,JTextField txtTimKiemDangKi, JLabel lbLinkHinhAnh, JComboBox cbTrangThaiPDK) { //JRadioButton rbtnNam, JRadioButton rbtnNu, JTextField txtSDT, JTextField txtDiaChi, JTextField txtEmail, JTextField txtHangKhachHang, JTable tblDSKH,
        
        this.tblPDK = tblPDK;
        this.lbHinhAnhKhachQLDK = lbHinhAnhKhachQLDK;
        this.lbLinkHinhAnh = lbLinkHinhAnh;
        this.lbMaKhachHang = lbMaKhachHang;
        this.lbHoTen = lbHoTen;
        this.lbCMND = lbCMND;
        this.lbGioiTinh = lbGioiTinh;
        this.lbNgaySinh = lbNgaySinh;
        this.lbEmail = lbEmail;
        this.lbSDT = lbSDT;
        this.lbDiaChi = lbDiaChi;
        this.lbHangKhachHang = lbHangKhachHang;
        this.txtGhiChuQLDK = txtGhiChuQLDK;
        this.txtTimKiemDangKi = txtTimKiemDangKi;
        this.cbTrangThaiPDK = cbTrangThaiPDK;
    }

}
