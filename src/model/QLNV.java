/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.raven.form.FrmNV;
import com.raven.main.FrmMain;
import com.raven.swing.KButton;
import csdl.CsdlQLNV;
import java.awt.Component;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author anhtu
 */
public class QLNV {

    JTable tblNV;
    JTextField txtMaNhanVien;
    JTextField txtHoTen;
    JTextField txtCMND;
    JRadioButton rbtnNu;
    JRadioButton rbtnNam;
    JTextField txtNgaySinh;
    JTextField txtSDT;
    JTextField txtDiaChi;
    JTextField txtEmail;
    JLabel lbHinhAnhNV;
    JButton btnChonAnh;
    JButton btnHuy;
    JButton btnThem;
    JButton btnLuu;
    JTextField txtTimKiemNhanvien;
    JComboBox cbLocNV;
    JRadioButton rbtnConLam;
    JRadioButton rbtnKhongPT;
    JRadioButton rbtnKhongQuanLi;
    JRadioButton rbtnLaPT;
    JRadioButton rbtnLaQuanLi;
    JRadioButton rbtnNghilam;
    JLabel lbLinkHinhAnh;
    JPanel panelMainTextFieldQLNV;
    JPanel panelMainBtnQLNV;
    JPanel panelBtnLuuQLNV;
    KButton btnCapTK;
    KButton btnKhoaTK;
    KButton btnMoKhoaTK;
    public static CsdlQLNV csdlQLNV = new CsdlQLNV();
    private Connection conn = FrmMain.conn;
    private Frame f = FrmMain.f;

    public void getDataForTbDanhSachNV() {
        DungChung.fillTable(FrmNV.dtblDSNV, csdlQLNV.selectAllNhanVien(f));
    }

    public void khoaTaiKhoan() {
        int row = tblNV.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(f, "Chọn nhân viên ở trên");
            return;
        }
        String maNV = (String) FrmNV.dtblDSNV.getValueAt(row, 0);
        String tenNV = (String) FrmNV.dtblDSNV.getValueAt(row, 1);
        int result = JOptionPane.showConfirmDialog(f,"Khóa Tài Khoản Của Nhân Viên ?", "Thông báo",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
        if(result!=JOptionPane.YES_OPTION) return;
        try {
            System.out.println(maNV);
            csdlQLNV.khoaTaiKhoan(maNV);
            JOptionPane.showMessageDialog(f, "Khóa tài khoản thành công");
            getDataForTbDanhSachNV();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }
    }

    public void dumpDataFromTblDSNVToFields() {
        int row = tblNV.getSelectedRow();
        if (row >= 0) {
            ResultSet rs;
            try {
                String id = (String) tblNV.getValueAt(row, 0);
                rs = csdlQLNV.selectNhanVien(f, id);
                if (rs.next()) {
                    txtMaNhanVien.setText(rs.getString("MANV").trim());
                    txtCMND.setText(rs.getString("CMND"));
                    txtHoTen.setText(rs.getString("HOTEN"));
                    String gt = rs.getString("GIOITINH");
                    if (!gt.equals("NAM")) {
                        rbtnNu.setSelected(true);
                    } else {
                        rbtnNam.setSelected(true);
                    }
                    if (rs.getBoolean("PT")) {
                        rbtnLaPT.setSelected(true);
                    } else {
                        rbtnKhongPT.setSelected(true);
                    }
                    if (rs.getBoolean("QUANLY")) {
                        rbtnLaQuanLi.setSelected(true);
                    } else {
                        rbtnKhongQuanLi.setSelected(true);
                    }
                    if (rs.getBoolean("NGHILAM")) {
                        rbtnNghilam.setSelected(true);
                    } else {
                        rbtnConLam.setSelected(true);
                    }
                    txtNgaySinh.setText(rs.getString("NGAYSINH"));
                    txtSDT.setText(rs.getString("SDT"));
                    txtDiaChi.setText(rs.getString("DIACHI"));
                    txtEmail.setText(rs.getString("EMAIL"));

                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmNV.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
            try {
                String imgURL = rs.getString("HINHANH");
                lbLinkHinhAnh.setText(imgURL);
                if (imgURL != null && !imgURL.isEmpty()) {
                    DungChung.readImg(lbHinhAnhNV, imgURL);
                } else {
                    DungChung.readImg(lbHinhAnhNV, "/anhNV/default.png");
                }
            } catch (SQLException ex) {
                lbHinhAnhNV.removeAll();
                System.out.println(ex.getMessage());
            }
            
//            if(tblNV.getValueAt(row, 11).toString().indexOf("Khóa") >0) {
//                System.out.println("aaa");
//                btnCapTK.setEnabled(false);
//                btnMoKhoaTK.setEnabled(true);
//                btnKhoaTK.setEnabled(false);
//            }else {
//                 btnCapTK.setEnabled(true);
//                btnMoKhoaTK.setEnabled(false);
//                btnKhoaTK.setEnabled(true);
//            }
//            
//            if(row >0){
//                    
//                    if(FrmMain.modelNV.getManv().toLowerCase().trim().equals(manv.toLowerCase().trim())){
//                        btnCapTK.setEnabled(false);
//                        btnKhoaTK.setEnabled(false);
//                        btn
//                    }else if(tblNV.getValueAt(row, 11).toString().indexOf("Khóa") >0){
//                       
//                    }else{
//                        btnCapTK.setEnabled(true);
//                        btnMoKhoaTK.setEnabled(false);
//                        btnKhoaTK.setEnabled(true);
//                    }
//                }
            String manv=tblNV.getValueAt(tblNV.getSelectedRow(), 0).toString();
            if(tblNV.getValueAt(row, 10).toString().equals("true") || FrmMain.modelNV.getManv().toLowerCase().trim().equals(manv.toLowerCase().trim())){
                btnCapTK.setEnabled(false);
                btnMoKhoaTK.setEnabled(false);
                btnKhoaTK.setEnabled(false);
            }else if(tblNV.getValueAt(row, 11).toString().indexOf("Khóa") >0){
                        btnCapTK.setEnabled(false);
                        btnMoKhoaTK.setEnabled(true);
                        btnKhoaTK.setEnabled(false);
            }else if(!tblNV.getValueAt(row, 11).toString().isEmpty()){
                btnCapTK.setEnabled(true);
                btnMoKhoaTK.setEnabled(false);
                btnKhoaTK.setEnabled(true);
            }else{
                btnCapTK.setEnabled(true);
                btnMoKhoaTK.setEnabled(false);
                btnKhoaTK.setEnabled(false);
            }
        
        
        }   
    }

    public boolean inputThemNhanvienHopLe() {

        String CMND = txtCMND.getText().trim();
        String SDT = txtSDT.getText().trim();
        String email = txtEmail.getText().trim();
        if (CMND.length() != 0 & csdlQLNV.tonTaiCMND(f, txtCMND.getText())) {
            JOptionPane.showMessageDialog(f, "CMND đã được đăng kí");
            return false;
        }

        if (csdlQLNV.tonTaiSDT(f, SDT)) {
            JOptionPane.showMessageDialog(f, "Số điện thoại đã được đăng kí");
            return false;
        }
        if (!email.isEmpty() & csdlQLNV.tonTaiEmail(f, email)) {
            JOptionPane.showMessageDialog(f, "Email đã được đăng kí");
            return false;
        }

        return true;
    }

    public boolean inputThongTinNhanvienHopLe() {
        if (txtHoTen.getText().equals("")) {
            JOptionPane.showMessageDialog(f, "Họ tên không được trống");
            return false;
        }
        String SDT = txtSDT.getText().trim();
        if (SDT.length() != 10) {
            JOptionPane.showMessageDialog(f, "SDT có 10 số");
            return false;
        }
        if (!SDT.matches("0[0-9]{9}")) {
            JOptionPane.showMessageDialog(f, "Số điện thoại không đúng định dạng");
            return false;
        }
        String CMND = txtCMND.getText().trim();
        if (!CMND.matches("[0-9]{9}") && !CMND.matches("[0-9]{12}") && CMND.length() != 0) {
            JOptionPane.showMessageDialog(f, "CMND không đúng");
            return false;
        }

        String email = txtEmail.getText().trim();
        if (email.length() == 0) {
            JOptionPane.showMessageDialog(f, "Nhập email");
            return false;
        }
        if (email.length() != 0 && !email.matches("^(.+)@(.+)$")) {
            JOptionPane.showMessageDialog(f, "Email không đúng định dạng");
            return false;
        }
        if (txtNgaySinh.getText().equals("")) {
            JOptionPane.showMessageDialog(f, "Chọn ngày sinh");
            return false;
        }

        return true;
    }

    public String getLinkHinhAnh() {
        if (lbLinkHinhAnh.getText().contains(":")) {  //nếu là đường dẫn đi từ gốc thì set lại link
            return "/anhNV/" + txtMaNhanVien.getText() + lbLinkHinhAnh.getText().substring(lbLinkHinhAnh.getText().indexOf("."));
        }
        return lbLinkHinhAnh.getText();
    }

    public void addNhanvien() {

        if (!inputThongTinNhanvienHopLe() | !inputThemNhanvienHopLe()) {
            return;
        }
        Vector vec = new Vector();
        String gioiTinh = "NAM";
        String PT = "0";
        String Quanli = "0";
        if (rbtnNu.isSelected()) {
            gioiTinh = "NỮ";
        }
        if (rbtnLaPT.isSelected()) {
            PT = "1";
        }
        if (rbtnLaQuanLi.isSelected()) {
            Quanli = "1";
        }
        vec.add(txtMaNhanVien.getText());
        vec.add(txtHoTen.getText());
        vec.add(txtSDT.getText());
        vec.add(txtCMND.getText());
        vec.add(txtNgaySinh.getText());
        vec.add(txtDiaChi.getText());
        vec.add(gioiTinh);
        vec.add(txtEmail.getText());
        vec.add(PT);
        vec.add(Quanli);
        vec.add("0");
        vec.add(getLinkHinhAnh());
        if (csdlQLNV.insertNhanVien(f, vec)) {
            DungChung.fillTable(FrmNV.dtblDSNV, csdlQLNV.selectAllNhanVien(f));
            saveImg();
            FrmNV.themMoi = false;
            rbtnNghilam.setEnabled(true);
            lockPanelBtnLuu();
            lamTrangTextNV();

            JOptionPane.showMessageDialog(f, "Thêm mới nhân viên thành công!");
            tblNV.getSelectionModel().setSelectionInterval(0, 0);
        } else {
            JOptionPane.showMessageDialog(f, "Thêm mới nhân viên thất bại!");
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
            os = new FileOutputStream(new File("src/anhNV/" + txtMaNhanVien.getText() + lbLinkHinhAnh.getText().substring(lbLinkHinhAnh.getText().indexOf("."))));
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

    public boolean inputChinhSuaThongTinNhanVienHopLe() {
        String CMND = txtCMND.getText().trim();
        String SDT = txtSDT.getText().trim();
        String email = txtEmail.getText().trim();
        String maNV = txtMaNhanVien.getText().trim();
        if (CMND.length() != 0 & csdlQLNV.tonTaiCMNDNgoaiTru(f, CMND, maNV)) {
            JOptionPane.showMessageDialog(f, "CMND đã được đăng kí");
            return false;
        }

        if (csdlQLNV.tonTaiSDTNgoaiTru(f, SDT, maNV)) {
            JOptionPane.showMessageDialog(f, "Số điện thoại đã được đăng kí");
            return false;
        }

        if (!email.isEmpty() & csdlQLNV.tonTaiEmailNgoaiTru(f, email, maNV)) {
            JOptionPane.showMessageDialog(f, "Email đã được đăng kí");
            return false;
        }

        return true;

    }

    public void capTaiKhoan() {
        int row = tblNV.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(f, "Chọn Nhân Viên ở bảng trên");
            return;
        }
        System.out.println(tblNV.getValueAt(row, 11));
        if(tblNV.getValueAt(row, 10).toString().equals("true")){
            JOptionPane.showMessageDialog(f, "Nhân viên đã nghỉ làm");
            return;
        }
        if(!tblNV.getValueAt(row, 11).toString().equals("")){
            int result = JOptionPane.showConfirmDialog(f,"Nhân viên đã có tài khoản, đổi mật khẩu ?", "Thông báo",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
            if(result!=JOptionPane.YES_OPTION) return;
        }
        String maNV = txtMaNhanVien.getText();
                String matKhau="";
                String[] options = {"OK"};
                JPanel panel = new JPanel();
                JLabel lbl = new JLabel("Nhập Mật Khẩu: ");
                JPasswordField txt = new JPasswordField(50);
                panel.add(lbl);
                panel.add(txt);
                int selectedOption = JOptionPane.showOptionDialog(null, panel, "", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);

                if(selectedOption == 0)
                {
                    matKhau = String.valueOf(txt.getPassword()).trim();
                    System.out.println(matKhau);
                    if(matKhau.equals("")) {
                        JOptionPane.showMessageDialog(f, "Mật Khẩu Không Được Để Trống");
                        return;
                    }
                }else return;


                try {
                    csdlQLNV.insertTaiKhoan(maNV, matKhau);
                    JOptionPane.showMessageDialog(f, "Cấp tài khoản thành công");
                    getDataForTbDanhSachNV();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(f, "Cấp tài khoản thất bại! \n" + ex.getMessage());
                }

    }

    public void luuChinhSuaNhanVien() {

        if (!inputThongTinNhanvienHopLe() | !inputChinhSuaThongTinNhanVienHopLe()) {
            return;
        }

        Vector vec = new Vector();
        String gioiTinh = "NAM";
        String PT = "0";
        String Quanli = "0";
        String NghiLam = "0";
        if (rbtnNu.isSelected()) {
            gioiTinh = "NỮ";
        }
        if (rbtnLaPT.isSelected()) {
            PT = "1";
        }
        if (rbtnLaQuanLi.isSelected()) {
            Quanli = "1";
        }
        if (rbtnNghilam.isSelected()) {
            NghiLam = "1";
        }

        vec.add(txtHoTen.getText());
        vec.add(txtSDT.getText());
        vec.add(txtCMND.getText());
        vec.add(txtNgaySinh.getText());
        vec.add(txtDiaChi.getText());
        vec.add(gioiTinh);
        vec.add(txtEmail.getText());
        vec.add(PT);
        vec.add(Quanli);
        vec.add(NghiLam);
        vec.add(getLinkHinhAnh());
        vec.add(txtMaNhanVien.getText());
        if (csdlQLNV.updateNV(f, vec)) {
            saveImg();
            getDataForTbDanhSachNV();
            lockPanelBtnLuu();
            lamTrangTextNV();
            JOptionPane.showMessageDialog(f, "Cập nhật thành công");
        } else {
            JOptionPane.showMessageDialog(f, "Cập nhật thất bại");
        }
    }

    public String getAutoMaNV() {
        int max = 0;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("EXEC get_ID 'NHANVIEN'");
            if (rs.next()) {
                return rs.getString(1).trim();
            }

        } catch (NumberFormatException | SQLException ex) {
            System.out.println("Lỗi cài đặt mã nhân viên");
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
            DungChung.readImg(lbHinhAnhNV, fileName);
            lbLinkHinhAnh.setText(fileName);
        }
    }

//    public void txtTimKiemNhanVienKeyReleased() {
//        String key = txtTimKiemNhanvien.getText().trim();
//        while (key.contains("  ")) {
//            key = key.replace("  ", " ");
//        }
//        lamTrangTextNV();
//        DungChung.fillTable(FrmNV.dtblDSNV, csdlQLNV.findByKey(key,String filterKey));
//    }

    public void btnThemMoiNVClicked() {
        txtMaNhanVien.setText(getAutoMaNV());
        unlockPanelBtnLuu();
        FrmNV.themMoi = true;
    }

    public void lamTrangTextNV() {
        txtMaNhanVien.setText("");
        txtHoTen.setText("");
        txtCMND.setText("");
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtSDT.setText("");
        rbtnNam.setSelected(true);
        rbtnConLam.setSelected(true);
        rbtnKhongPT.setSelected(true);
        rbtnKhongQuanLi.setSelected(true);
        txtNgaySinh.setText("");
        lbHinhAnhNV.setIcon(new ImageIcon(""));
        lbLinkHinhAnh.setText("");
    }

    public void unlockPanelBtnLuu() {

        for (Component component : panelBtnLuuQLNV.getComponents()) {
            component.setEnabled(true);
        }

        for (Component component : panelMainTextFieldQLNV.getComponents()) {
            component.setEnabled(true);

        }

        for (Component component : panelMainBtnQLNV.getComponents()) {
            component.setEnabled(false);
        }

        //tblDSKH.clearSelection();
        //tblDSKH.setEnabled(false);
        btnChonAnh.setEnabled(true);
        txtMaNhanVien.setEnabled(false);
        
    }

    public void lockPanelBtnLuu() {

        for (Component component : panelBtnLuuQLNV.getComponents()) {
            component.setEnabled(false);
        }

        for (Component component : panelMainTextFieldQLNV.getComponents()) {
            component.setEnabled(false);
        }

        for (Component component : panelMainBtnQLNV.getComponents()) {
            component.setEnabled(true);
        }

        //tblDSKH.setEnabled(true);
        btnChonAnh.setEnabled(false);

    }

    public void filterNV() {
        String key = txtTimKiemNhanvien.getText().trim();
        while (key.contains("  ")) {
            key = key.replace("  ", " ");
        }
//        if (cbLocNV.getSelectedItem().toString().toLowerCase().equals("tất cả")) {
//            getDataForTbDanhSachNV();
//            return;
//        }
        if(cbLocNV.getSelectedIndex()==0)
            DungChung.fillTable(FrmNV.dtblDSNV, csdlQLNV.findByKey(key,null));
        else DungChung.fillTable(FrmNV.dtblDSNV, csdlQLNV.findByKey(key,cbLocNV.getSelectedItem().toString()));
        if(tblNV.getRowCount()>0) tblNV.setRowSelectionInterval(0, 0);
    }
    public void moKhoaTaiKhoan(){
                int row = tblNV.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(f, "Chọn nhân viên ở trên");
            return;
        }
        String maNV = (String) FrmNV.dtblDSNV.getValueAt(row, 0);
        try {
            System.out.println(maNV);
            csdlQLNV.moKhoaTaiKhoan(maNV);
            JOptionPane.showMessageDialog(f, "Mở Khóa tài khoản thành công");
            getDataForTbDanhSachNV();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f, ex.getMessage());
        }
    }

    public QLNV(JTable tblNV, JTextField txtMaNhanVien, JTextField txtHoTen, JTextField txtCMND, JRadioButton rbtnNu, JRadioButton rbtnNam, JTextField txtNgaySinh, JTextField txtSDT, JTextField txtDiaChi, JTextField txtEmail,
            JLabel lbHinhAnhNV, JButton btnChonAnh, JButton btnHuy, JButton btnThem, JButton btnLuu, JTextField txtTimKiemNhanvien, JComboBox cbLocNV,
            JRadioButton rbtnConLam, JRadioButton rbtnKhongPT, JRadioButton rbtnKhongQuanLi, JRadioButton rbtnLaPT, JRadioButton rbtnLaQuanLi, JRadioButton rbtnNghilam, JLabel lbLinkHinhAnh,
            JPanel panelMainTextFieldQLNV, JPanel panelMainBtnQLNV, JPanel panelBtnLuuQLNV,KButton btnCapTK,KButton btnKhoaTK,KButton btnMoKhoaTK) {
        this.tblNV = tblNV;
        this.txtMaNhanVien = txtMaNhanVien;
        this.txtHoTen = txtHoTen;
        this.txtCMND = txtCMND;
        this.rbtnNu = rbtnNu;
        this.rbtnNam = rbtnNam;
        this.txtNgaySinh = txtNgaySinh;
        this.txtSDT = txtSDT;
        this.txtDiaChi = txtDiaChi;
        this.txtEmail = txtEmail;
        this.lbHinhAnhNV = lbHinhAnhNV;
        this.btnLuu = btnLuu;
        this.btnHuy = btnHuy;
        this.btnThem = btnThem;
        this.btnChonAnh = btnChonAnh;
        this.txtTimKiemNhanvien = txtTimKiemNhanvien;
        this.cbLocNV = cbLocNV;
        this.rbtnConLam = rbtnConLam;
        this.rbtnKhongPT = rbtnKhongPT;
        this.rbtnKhongQuanLi = rbtnKhongQuanLi;
        this.rbtnLaPT = rbtnLaPT;
        this.rbtnLaQuanLi = rbtnLaQuanLi;
        this.rbtnNghilam = rbtnNghilam;
        this.cbLocNV = cbLocNV;
        this.lbLinkHinhAnh = lbLinkHinhAnh;
        this.panelBtnLuuQLNV = panelBtnLuuQLNV;
        this.panelMainBtnQLNV = panelMainBtnQLNV;
        this.panelMainTextFieldQLNV = panelMainTextFieldQLNV;
        this.btnCapTK=btnCapTK;
        this.btnKhoaTK=btnKhoaTK;
        this.btnMoKhoaTK=btnMoKhoaTK;
    }
}
