/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.raven.form.FrmQVT;
import static com.raven.form.FrmQVT.dtblLSQVT;
import csdl.*;
import java.awt.Frame;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TuanHung
 */
public class QLQVT {

    public QLQVT(JLabel lbCMND, JLabel lbDiaChi, JLabel lbEmail, JLabel lbGioiTinh, JLabel lbHangKhachHang,
            JLabel lbHoTen, JLabel lbMaKhachHang, JLabel lbNgaySinh, JLabel lbSDT, JLabel lbHinhAnhKhach, JLabel lbDichVu,
            JLabel lbNgayBatDau, JLabel lbNgayDangKi, JLabel lbNgayKetThuc, JButton btnGiaLapVaoRa, JTable tblLSQVT,
            JButton btnLoc, JTextField txtTuNgay, JTextField txtDenNgay) {

        this.lbCMND = lbCMND;
        this.lbDiaChi = lbDiaChi;
        this.lbEmail = lbEmail;
        this.lbGioiTinh = lbGioiTinh;
        this.lbHangKhachHang = lbHangKhachHang;
        this.lbHoTen = lbHoTen;
        this.lbMaKhachHang = lbMaKhachHang;
        this.lbNgaySinh = lbNgaySinh;
        this.lbSDT = lbSDT;
        this.lbHinhAnhKhach = lbHinhAnhKhach;
        this.lbDichVu = lbDichVu;
        this.lbNgayBatDau = lbNgayBatDau;
        this.lbNgayDangKi = lbNgayDangKi;
        this.lbNgayKetThuc = lbNgayKetThuc;
        this.btnGiaLapVaoRa = btnGiaLapVaoRa;
        this.tblLSQVT = tblLSQVT;
        this.btnLoc = btnLoc;
        this.txtTuNgay = txtTuNgay;
        this.txtDenNgay = txtDenNgay;
    }

    public void gia1VanTay() {
        String maVT = JOptionPane.showInputDialog(this, "Nhập Mã Vân Tay");

        if (maVT == null) {
            return;
        }
        if(maVT.isEmpty()){
            return;
        }
        int maVanTay = Integer.parseInt(maVT);
        try {
            csdlQLQVT.insert1KhachQuetVanTay(maVanTay);
            getDataForTblLichSuQuetVanTay();
            tblLSQVT.getSelectionModel().setSelectionInterval(0, 0);
            tblLSQVT.scrollRectToVisible(new Rectangle(tblLSQVT.getCellRect(0, 0, true)));
            getDataForLabelThongTinKhachHang();
            JOptionPane.showMessageDialog(f, "Quẹt Vân Tay Thành Công");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());

        }

    }

    public void getDataForTblLichSuQuetVanTay() {
        DungChung.fillTable(FrmQVT.dtblLSQVT, csdlQLQVT.selectAllQuetVanTay(f));
    }

    public void getDataForLabelThongTinKhachHang() {
        int row = tblLSQVT.getSelectedRow();
        if (row == -1) {
            return;
        }
        String STT = tblLSQVT.getValueAt(row, 0).toString();
        ResultSet rs = csdlQLQVT.selectKhachHang(f, STT);
        try {
            if (rs.next()) {
                lbMaKhachHang.setText((String) rs.getObject(1));
                lbHoTen.setText((String) rs.getObject(2));
                lbCMND.setText((String) rs.getObject(3));
                lbGioiTinh.setText((String) rs.getObject(4));
                if (rs.getObject(5) != null) {
                    lbNgaySinh.setText(rs.getObject(5).toString());
                }
                lbSDT.setText((String) rs.getObject(6));
                lbEmail.setText((String) rs.getObject(7));
                lbDiaChi.setText((String) rs.getObject(8));
                lbHangKhachHang.setText((String) rs.getObject(9));
                DungChung.readImg(lbHinhAnhKhach, (String) rs.getObject(10));

            }
        } catch (SQLException ex) {
            Logger.getLogger(QLQVT.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        getDataForLabelThongTinDichVuKhachDK(STT, row);

    }

    public void getDataForLabelThongTinDichVuKhachDK(String STT, int row) {
        String dichVu = tblLSQVT.getValueAt(row, 3).toString();
        ResultSet rs = csdlQLQVT.selectPDK(f, STT);

        try {
            if (rs.next()) {
                lbDichVu.setText(dichVu);
                lbNgayDangKi.setText(rs.getObject(2).toString());
                lbNgayBatDau.setText(rs.getObject(3).toString());
                lbNgayKetThuc.setText(rs.getObject(4).toString());

            }
        } catch (SQLException ex) {
            Logger.getLogger(QLQVT.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void giaLapNhieuMauTin() {
        ResultSet rs;
        try {
            for (int i = 0; i < 10; i++) {
                rs = csdlQLQVT.insertNhieuKhachQuetVanTay();
            }
//            if (rs.next()) {
//                JOptionPane.showMessageDialog(f, "Có " + rs.getString(1)
//                        + " người vừa quẹt vân tay!");
//            }
            getDataForTblLichSuQuetVanTay();
        } catch (SQLException ex) {
            Logger.getLogger(QLQVT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String randTimeOfCurrentDay() {

        //trả về thời gian với ngày là ngày hiện tại, nhưng ngẫu nhiên giờ, phút
        String hour = String.valueOf((int) ((Math.random()) * ((22 - 4) + 1)) + 4);;
        String minute = String.valueOf((int) ((Math.random()) * ((59 - 0) + 1)) + 0);;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd " + hour + ":" + minute + ":00");
        return formatter.format(new Date());
    }

    public void huyLoc() {

        txtTuNgay.setText("1900-01-01");
        txtDenNgay.setText(java.time.LocalDate.now().toString());
        DungChung.fillTable(FrmQVT.dtblLSQVT, csdlQLQVT.selectAllQuetVanTay(f));

    }

    public void loc() {
        String tuNgay = txtTuNgay.getText();
        String denNgay = txtDenNgay.getText();
        denNgay = DungChung.dateAdd(denNgay, 1);
        DungChung.fillTable(dtblLSQVT, csdlQLQVT.selectKhachQuetVanTayTrongKhoang(f, tuNgay, denNgay));
    }

    private Connection conn;
    private Frame f;
    private javax.swing.JLabel lbCMND;
    private javax.swing.JLabel lbDiaChi;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbGioiTinh;
    private javax.swing.JLabel lbHangKhachHang;
    private javax.swing.JLabel lbHoTen;
    private javax.swing.JLabel lbMaKhachHang;
    private javax.swing.JLabel lbNgaySinh;
    private javax.swing.JLabel lbSDT;
    private javax.swing.JLabel lbHinhAnhKhach;
    private javax.swing.JLabel lbDichVu;
    private javax.swing.JLabel lbNgayBatDau;
    private javax.swing.JLabel lbNgayDangKi;
    private javax.swing.JLabel lbNgayKetThuc;
    private JButton btnGiaLapVaoRa;
    private JTable tblLSQVT;
    private JButton btnLoc;
    private JTextField txtTuNgay;
    private JTextField txtDenNgay;
    private CsdlQLQVT csdlQLQVT = new CsdlQLQVT();

}
