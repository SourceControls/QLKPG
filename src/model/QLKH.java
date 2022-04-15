package model;

import com.raven.form.FrmKH;
import csdl.*;
import java.awt.Component;
import java.awt.Frame;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.DungChung;
import com.raven.form.FrmDangKiDichVu;
import com.raven.form.FrmDoThongSo;
import com.raven.main.FrmMain;
import java.awt.FileDialog;
import java.awt.image.ImageFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author TuanHung
 */
public class QLKH {

    public static CsdlQLKH csdlQLKH = new CsdlQLKH();
    private Connection conn = FrmMain.conn;
    private Frame f = FrmMain.f;

    public void getDataForTbDanhSachKhachHang() {
        DungChung.fillTable(FrmKH.dtblDSKH, csdlQLKH.selectAllKhachHang(f));
    }

    public void dumpDataFromTblDSKHToFields() {
        int row = tblDSKH.getSelectedRow();
        if (row >= 0) {
            ResultSet rs;
            try {
                String id = (String) tblDSKH.getValueAt(row, 0);
                rs = csdlQLKH.selectKhachHang(f, id);
                if (rs.next()) {
                    txtMaKhachHang.setText(rs.getString("MAKH").trim());
                    txtCMND.setText(rs.getString("CMND"));
                    txtHoTen.setText(rs.getString("HOTEN"));
                    String gt = rs.getString("GIOITINH");
                    if (!gt.equals("NAM")) {
                        rbtnNu.setSelected(true);
                    } else {
                        rbtnNam.setSelected(true);
                    }
                    txtNgaySinh.setText(rs.getString("NGAYSINH"));
                    txtSDT.setText(rs.getString("SDT"));
                    txtDiaChi.setText(rs.getString("DIACHI"));
                    txtEmail.setText(rs.getString("EMAIL"));
                    txtHangKhachHang.setText(rs.getString("HANGKH"));

                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmKH.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
            try {
                String imgURL = rs.getString("HINHANH");
                lbLinkHinhAnh.setText(imgURL);
                DungChung.readImg(f, lbHinhAnhKhachQLKH, imgURL);
            } catch (Exception ex) {
                lbHinhAnhKhachQLKH.removeAll();
                lbLinkHinhAnh.setText("");
            }
        }
    }

    public boolean inputThemKhachHangHopLe() {

        String CMND = txtCMND.getText().trim();
        String SDT = txtSDT.getText().trim();
        String email = txtEmail.getText().trim();
        if (CMND.length() != 0 & csdlQLKH.tonTaiCMND(f, txtCMND.getText())) {
            JOptionPane.showMessageDialog(f, "CMND đã được đăng kí");
            return false;
        }

        if (csdlQLKH.tonTaiSDT(f, SDT)) {
            JOptionPane.showMessageDialog(f, "Số điện thoại đã được đăng kí");
            return false;
        }
        if (!email.isEmpty() & csdlQLKH.tonTaiEmail(f, email)) {
            JOptionPane.showMessageDialog(f, "Email đã được đăng kí");
            return false;
        }

        return true;
    }

    public boolean inputThongTinKhachHangHopLe() {
        if (txtHoTen.getText().equals("")) {
            JOptionPane.showMessageDialog(f, "Họ tên không được trống");
            return false;
        }
        if (txtSDT.getText().equals("")) {
            JOptionPane.showMessageDialog(f, "Số điện thoại không được để trống");
            return false;
        }
        String CMND = txtCMND.getText().trim();
        if (CMND.length() != 0 & CMND.length() != 9 & CMND.length() != 12) {
            JOptionPane.showMessageDialog(f, "CMND có 9 hoặc 12 số");
            return false;
        }
        String SDT = txtSDT.getText().trim();
        if (SDT.length() != 0 & !SDT.startsWith("0")) {
            JOptionPane.showMessageDialog(f, "Số điện thoại không đúng định dạng");
            return false;
        }
        String email = txtEmail.getText().trim();
        if (email.length() != 0 && !email.matches("^(.+)@(.+)$")) {
            JOptionPane.showMessageDialog(f, "Email không đúng định dạng");
            return false;
        }

        return true;
    }

    public String getLinkHinhAnh() {
        if (lbLinkHinhAnh.getText().contains(":")) {  //nếu là đường dẫn đi từ gốc thì set lại link
            return "/anhKH/" + txtMaKhachHang.getText() + lbLinkHinhAnh.getText().substring(lbLinkHinhAnh.getText().indexOf("."));
        }
        return lbLinkHinhAnh.getText();
    }

    public void addKhachHang() {

        if (!inputThongTinKhachHangHopLe() | !inputThemKhachHangHopLe()) {
            return;
        }
        Vector vec = new Vector();
        String gioiTinh = "NAM";
        if (rbtnNu.isSelected()) {
            gioiTinh = "NỮ";
        }
        vec.add(txtMaKhachHang.getText());
        vec.add(txtHoTen.getText());
        vec.add(txtSDT.getText());
        vec.add(gioiTinh);
        vec.add(txtNgaySinh.getText());
        vec.add(txtCMND.getText());
        vec.add(txtEmail.getText());
        vec.add(txtDiaChi.getText());
        vec.add(txtHangKhachHang.getText()); //hạng khách hàng

        vec.add(getLinkHinhAnh());

        if (csdlQLKH.insertKhachHang(f, vec)) {
            DungChung.fillTable(FrmKH.dtblDSKH, csdlQLKH.selectAllKhachHang(f));
            saveImg();
            FrmKH.themMoi = false;
            lockPanelBtnLuu();
            lamTrangTextKH();

            JOptionPane.showMessageDialog(f, "Thêm mới khách thành công!");
        } else {
            JOptionPane.showMessageDialog(f, "Thêm mới khách thất bại!");
        }

    }

    public void saveImg() {
        //copy img vào project
        if (!lbLinkHinhAnh.getText().contains(":")) {
            return;
        }
        FileInputStream is = null;
        FileOutputStream os = null;
        try {
            is = new FileInputStream(new File(lbLinkHinhAnh.getText()));
            os = new FileOutputStream(new File("src/anhKH/" + txtMaKhachHang.getText() + lbLinkHinhAnh.getText().substring(lbLinkHinhAnh.getText().indexOf("."))));
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(QLKH.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(QLKH.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (is != null) {
                is.close();
            }
            if (os != null) {
                os.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(QLKH.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean inputChinhSuaThongTinKhachHangHopLe() {
        String CMND = txtCMND.getText().trim();
        String SDT = txtSDT.getText().trim();
        String email = txtEmail.getText().trim();
        String maKH = txtMaKhachHang.getText().trim();
        if (CMND.length() != 0 & csdlQLKH.tonTaiCMNDNgoaiTru(f, CMND, maKH)) {
            JOptionPane.showMessageDialog(f, "CMND đã được đăng kí");
            return false;
        }

        if (csdlQLKH.tonTaiSDTNgoaiTru(f, SDT, maKH)) {
            JOptionPane.showMessageDialog(f, "Số điện thoại đã được đăng kí");
            return false;
        }

        if (!email.isEmpty() & csdlQLKH.tonTaiEmailNgoaiTru(f, email, maKH)) {
            JOptionPane.showMessageDialog(f, "Email đã được đăng kí");
            return false;
        }

        return true;

    }

    public void luuChinhSuaKhachHang() {

        if (!inputThongTinKhachHangHopLe() | !inputChinhSuaThongTinKhachHangHopLe()) {
            return;
        }

        Vector vec = new Vector();
        String gioiTinh = "NAM";
        if (rbtnNu.isSelected()) {
            gioiTinh = "NỮ";
        }

        vec.add(txtHoTen.getText());
        vec.add(txtCMND.getText());
        vec.add(gioiTinh);
        vec.add(txtNgaySinh.getText());
        vec.add(txtSDT.getText());
        vec.add(txtEmail.getText());
        vec.add(txtDiaChi.getText());
        vec.add(getLinkHinhAnh());
        vec.add(txtMaKhachHang.getText());
        if (csdlQLKH.updateKhachHang(f, vec)) {
            saveImg();
            getDataForTbDanhSachKhachHang();
            lockPanelBtnLuu();
            lamTrangTextKH();
            JOptionPane.showMessageDialog(f, "Cập nhật thành công");
        } else {
            JOptionPane.showMessageDialog(f, "Cập nhật thất bại");
        }
    }

    public String getAutoMaKH() {
        int max = 0;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("EXEC get_ID 'KHACHHANG'");
            if (rs.next()) {
                return rs.getString(1).trim();
            }

        } catch (NumberFormatException | SQLException ex) {
            System.out.println("Lỗi cài đặt mã khách hàng");
        }

        return null;
    }

    public void selectImg() {
        FileDialog fd;
        fd = new java.awt.FileDialog((java.awt.Frame) null, "Chọn Ảnh", FileDialog.LOAD);
        fd.setFile("*.jpg;*.jpeg;*.png");
        fd.setVisible(true);
        if (fd.getFile() != null) {
            String fileName = fd.getDirectory() + fd.getFile();
            DungChung.readImg(f, lbHinhAnhKhachQLKH, fileName);
            lbLinkHinhAnh.setText(fileName);
        }
    }

    public void txtTimKiemKhachHangKeyReleased() {

        lamTrangTextKH();
        DungChung.fillTable(FrmKH.dtblDSKH, csdlQLKH.findByKey(f, txtTimKiemKhachHang.getText()));
    }

    public void btnThemMoiKhachClicked() {
        txtMaKhachHang.setText(getAutoMaKH());
        unlockPanelBtnLuu();
        FrmKH.themMoi = true;
    }

    public void openDoThongSo(FrmDoThongSo frmDoThongSo) {

        int row = tblDSKH.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(f, "Chọn khách hàng ở bảng trên");
            return;
        }

        frmDoThongSo = new FrmDoThongSo(txtMaKhachHang.getText(), txtHoTen.getText(), txtSDT.getText(), lbLinkHinhAnh.getText());

    }

    public void lamTrangTextKH() {
        txtMaKhachHang.setText("");
        txtHoTen.setText("");
        txtCMND.setText("");
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtHangKhachHang.setText("");
        txtSDT.setText("");
        rbtnNam.setSelected(true);
        txtNgaySinh.setText("");
        lbHinhAnhKhachQLKH.setIcon(new ImageIcon(""));
        lbLinkHinhAnh.setText("");
    }

    public void unlockPanelBtnLuu() {

        for (Component component : panelBtnLuuQLKH.getComponents()) {
            component.setEnabled(true);
        }

        for (Component component : panelMainTextFieldQLKH.getComponents()) {
            component.setEnabled(true);

        }

        for (Component component : panelMainBtnQLKH.getComponents()) {
            component.setEnabled(false);
        }

        //tblDSKH.clearSelection();
        //tblDSKH.setEnabled(false);
        btnChonAnh.setEnabled(true);

        txtMaKhachHang.setEnabled(false);
        txtHangKhachHang.setEnabled(false);
    }

    public void lockPanelBtnLuu() {

        for (Component component : panelBtnLuuQLKH.getComponents()) {
            component.setEnabled(false);
        }

        for (Component component : panelMainTextFieldQLKH.getComponents()) {
            component.setEnabled(false);
        }

        for (Component component : panelMainBtnQLKH.getComponents()) {
            component.setEnabled(true);
        }

        //tblDSKH.setEnabled(true);
        btnChonAnh.setEnabled(false);

    }

    public void filterKH() {
        if (cbHangKhachHang.getSelectedItem().toString().toLowerCase().equals("none")) {
            getDataForTbDanhSachKhachHang();
            return;
        }
        DungChung.fillTable(FrmKH.dtblDSKH, csdlQLKH.selectKHByHang(cbHangKhachHang.getSelectedItem().toString()));
    }

    public void dangKiDichVu(FrmDangKiDichVu frmDangKiDichVu) {

        int row = tblDSKH.getSelectedRow();
        if (row >= 0) {
            try {
                PreparedStatement pst = conn.prepareStatement("EXEC SP_CHECK_KHACH_CO_THE_DANG_KI ?");
                pst.setObject(1, tblDSKH.getValueAt(row, 0));
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(f, "Khách hàng đã có phiếu đăng kí hợp lệ trước đó");
                    return;
                }

                frmDangKiDichVu = new FrmDangKiDichVu(tblDSKH.getValueAt(row, 0).toString());

            } catch (SQLException ex) {
                Logger.getLogger(DKDV.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(f, "Chọn 1 hàng trên bảng !");
        }
    }

    public QLKH(JTable tblDSKH, JTextField txtMaKhachHang, JTextField txtHoTen, JTextField txtCMND, JRadioButton rbtnNu, JRadioButton rbtnNam, JTextField txtNgaySinh, JTextField txtSDT, JTextField txtDiaChi, JTextField txtEmail, JTextField txtHangKhachHang, JLabel lbLinkHinhAnh, JLabel lbHinhAnhKhachQLKH, JButton btnLuuChinhSua, JButton btnHuyChinhSua, JButton btnThemMoi, JButton btnDoThongSo, JButton btnChonAnh, JPanel panelMainTextFieldQLKH, JPanel panelMainBtnQLKH, JPanel panelBtnLuuQLKH, JTextField txtTimKiemKhachHang, JComboBox cbHangKhachHang) {
        this.tblDSKH = tblDSKH;
        this.txtMaKhachHang = txtMaKhachHang;
        this.txtHoTen = txtHoTen;
        this.txtCMND = txtCMND;
        this.rbtnNu = rbtnNu;
        this.rbtnNam = rbtnNam;
        this.txtNgaySinh = txtNgaySinh;
        this.txtSDT = txtSDT;
        this.txtDiaChi = txtDiaChi;
        this.txtEmail = txtEmail;
        this.txtHangKhachHang = txtHangKhachHang;
        this.lbLinkHinhAnh = lbLinkHinhAnh;
        this.lbHinhAnhKhachQLKH = lbHinhAnhKhachQLKH;
        this.btnLuuChinhSua = btnLuuChinhSua;
        this.btnHuyChinhSua = btnHuyChinhSua;
        //this.btnSuaThongTin = btnSuaThongTin;
        //this.btnDangKi = btnDangKi;
        this.btnThemMoi = btnThemMoi;
        this.btnDoThongSo = btnDoThongSo;
        this.btnChonAnh = btnChonAnh;
        this.panelMainTextFieldQLKH = panelMainTextFieldQLKH;
        this.panelMainBtnQLKH = panelMainBtnQLKH;
        this.panelBtnLuuQLKH = panelBtnLuuQLKH;
        this.txtTimKiemKhachHang = txtTimKiemKhachHang;
        this.cbHangKhachHang = cbHangKhachHang;
    }

    JTable tblDSKH;
    JTextField txtMaKhachHang;
    JTextField txtHoTen;
    JTextField txtCMND;
    JRadioButton rbtnNu;
    JRadioButton rbtnNam;
    JTextField txtNgaySinh;
    JTextField txtSDT;
    JTextField txtDiaChi;
    JTextField txtEmail;
    JTextField txtHangKhachHang;
    JLabel lbLinkHinhAnh;
    JLabel lbHinhAnhKhachQLKH;
    JButton btnLuuChinhSua;
    JButton btnHuyChinhSua;
    //JButton btnSuaThongTin;
    //JButton btnDangKi;
    JButton btnThemMoi;
    JButton btnDoThongSo;
    JButton btnChonAnh;
    JPanel panelMainTextFieldQLKH;
    JPanel panelMainBtnQLKH;
    JPanel panelBtnLuuQLKH;
    JTextField txtTimKiemKhachHang;
    JComboBox cbHangKhachHang;
}
