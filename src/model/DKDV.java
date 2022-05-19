/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import csdl.*;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
        if (!trangThaiPDK.equals("CHỜ KÍCH HOẠT")) {
            JOptionPane.showMessageDialog(f, "Chỉ hủy phiếu đang chờ kích hoạt!");
            return;
        }
        if (trangThaiPDK.equals("ĐÃ HỦY") | trangThaiPDK.equals("HẾT HẠN")) {
            JOptionPane.showMessageDialog(f, "Phiếu đã hết hạn hoặc đã hủy trước đó!");
            return;
        }
        String ghiChu = JOptionPane.showInputDialog("Nhập Lý Do: ");
        if(ghiChu == null)
            return;
        txtGhiChuQLDK.setText(ghiChu);
        luuGhiChuDangKi();
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

                ResultSet rs = QLKH.csdlQLKH.selectKhachHang(null, tblPDK.getValueAt(row, 1).toString());

                if (rs.next()) {

                    DungChung.readImg(lbHinhAnhKhachQLDK, rs.getString("HINHANH"));
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

    public void thanhToan(boolean fromFrmKH) {
        if (fromFrmKH){
            getDataForTblDangKiDichVu();
             tblPDK.setRowSelectionInterval(FrmMain.formPDK.tblPDK.getRowCount() - 1, FrmMain.formPDK.tblPDK.getRowCount() - 1);
        }
        int row = tblPDK.getSelectedRow();
        if (row != -1) {
            if (FrmMain.frmThanhToan == null || !FrmMain.frmThanhToan.maKH.equals(lbMaKhachHang.getText())) {
                FrmMain.frmThanhToan = new FrmThanhToan(tblPDK.getValueAt(row, 0).toString(),
                        tblPDK.getValueAt(row, 1).toString(),
                        tblPDK.getValueAt(row, 10).toString());
            } else {
                FrmMain.frmThanhToan.setVisible(true);
            }

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
        String key =   txtTimKiemDangKi.getText().trim();
        while(key.contains("  "))
            key = key.replace("  ", " ");
        lamTrangTextPDK();
        if(cbTrangThaiPDK.getSelectedIndex()==0){
            DungChung.fillTable(FrmPDK.dtblPDK, csdlDKDV.findAndFilter(key,null));
        }else DungChung.fillTable(FrmPDK.dtblPDK, csdlDKDV.findAndFilter(key,cbTrangThaiPDK.getSelectedItem().toString()));
        if(tblPDK.getRowCount()>0)
        tblPDK.getSelectionModel().setSelectionInterval(0, 0);
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

    public DKDV(TableColumn tblPDK, JLabel lbHinhAnhKhachQLDK, JLabel lbMaKhachHang, JLabel lbHoTen, JLabel lbCMND, JLabel lbGioiTinh, JLabel lbNgaySinh, JLabel lbEmail, JLabel lbSDT, JLabel lbDiaChi, JLabel lbHangKhachHang, JTextArea txtGhiChuQLDK, JTextField txtTimKiemDangKi, JLabel lbLinkHinhAnh, JComboBox cbTrangThaiPDK) { //JRadioButton rbtnNam, JRadioButton rbtnNu, JTextField txtSDT, JTextField txtDiaChi, JTextField txtEmail, JTextField txtHangKhachHang, JTable tblDSKH,

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
