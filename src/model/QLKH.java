package model;

import com.raven.form.FrmDangKiDichVu;
import com.raven.form.FrmDoThongSo;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.raven.swing.TableColumn;
import com.raven.form.FrmDangKiDichVu;
import com.raven.form.FrmPDK;
import com.raven.main.FrmMain;
import java.awt.FileDialog;
import java.awt.Rectangle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TuanHung
 */
public class QLKH {

    public static CsdlQLKH csdlQLKH = new CsdlQLKH();
    private Connection conn = FrmMain.conn;
    private Frame f = FrmMain.f;

    public void giaVanTay() {
        int row = tblDSKH.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(f, "Chọn khách ở trên");
            return;
        }
        String maKH = (String) FrmKH.dtblDSKH.getValueAt(row, 0);
        try {
            System.out.println(maKH);
            ResultSet rs = csdlQLKH.insertVanTay(maKH);
            if (rs.next()) {
                JOptionPane.showMessageDialog(f, "Thêm vân tay thành công,họ tên: " + (String) FrmKH.dtblDSKH.getValueAt(row, 1)+"\nMã vân tay: " + rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QLKH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getDataForTbDanhSachKhachHang() {
        DungChung.fillTable(FrmKH.dtblDSKH, csdlQLKH.selectAllKhachHang(f));
    }

    public void dumpDataFromTblDSKHToFields() {
        int row = tblDSKH.getSelectedRow();
        if (row >= 0) {
            ResultSet rs;
            try {
                String id = (String) tblDSKH.getValueAt(row, 0);
                rs = csdlQLKH.selectKhachHang(null, id);
                if (rs.next()) {
                    txtMaKhachHang.setText(rs.getString("MAKH").trim());
                    txtHoTen.setText(rs.getString("HOTEN"));
                    String gt = rs.getString("GIOITINH").trim();
                    if (!gt.equals("NAM")) {
                        rbtnNu.setSelected(true);
                    } else {
                        rbtnNam.setSelected(true);
                    }
                    if (rs.getString("NGAYSINH") != null) {
                        txtNgaySinh.setText(rs.getString("NGAYSINH"));
                    } else {
                        txtNgaySinh.setText("");
                    }
                    if (rs.getString("CMND") != null) {
                        txtCMND.setText(rs.getString("CMND"));
                    } else {
                        txtCMND.setText("");
                    }
                    if (rs.getString("DIACHI") != null) {
                        txtDiaChi.setText(rs.getString("DIACHI"));
                    } else {
                        txtDiaChi.setText("");
                    }
                    if (rs.getString("EMAIL") != null) {
                        txtEmail.setText(rs.getString("EMAIL"));
                    } else {
                        txtEmail.setText("");
                    }
                    txtSDT.setText(rs.getString("SDT"));
                    txtHangKhachHang.setText(rs.getString("HANGKH"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmKH.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
            try {
                String imgURL = rs.getString("HINHANH");
                lbLinkHinhAnh.setText(imgURL);
                DungChung.readImg(lbHinhAnhKhachQLKH, imgURL);
            } catch (Exception ex) {
                System.out.println(ex.toString());
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
        if (!txtNgaySinh.getText().equals("")) {
            String ngaySinh = txtNgaySinh.getText();
            int now = java.time.LocalDate.now().getYear();
            if (now - Integer.parseInt(ngaySinh.substring(0, 4)) <= 6) {
                JOptionPane.showMessageDialog(f, "Ngày Sinh Không Hợp Lệ, Người Đăng Kí Dịch Vụ Phải Trên 6 Tuổi!");
                return false;
            }
        }
//         if (txtNgaySinh.getText().equals("")) {  //tại bên kia dùng toString nên nó bị null á, dùng ép kiểu nên hết bị rồi
//            JOptionPane.showMessageDialog(f, "Ngày sinh không để trống");// để trống thì lỗi ở cái bảng quét vân tay 
//        }
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
        if (!email.matches("^(.+)@(.+)$") && email.length() != 0) {
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
            
            tblDSKH.scrollRectToVisible(new Rectangle(tblDSKH.getCellRect(0, 0, true)));
            JOptionPane.showMessageDialog(f, "Thêm mới khách thành công!");
            tblDSKH.getSelectionModel().setSelectionInterval(0, 0);
           
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
        int row=tblDSKH.getSelectedRow();
        if (!inputThongTinKhachHangHopLe() || !inputChinhSuaThongTinKhachHangHopLe()) {
            return;
        }
        Vector vec = new Vector();
        String gioiTinh = "NAM";
        if (rbtnNu.isSelected()) {
            gioiTinh = "NỮ";
        }

        vec.add(txtHoTen.getText());
        vec.add(txtSDT.getText());
        vec.add(gioiTinh);
        vec.add(txtNgaySinh.getText());
        vec.add(txtCMND.getText());
        vec.add(txtEmail.getText());
        vec.add(txtDiaChi.getText());
        vec.add(getLinkHinhAnh());
        vec.add(txtMaKhachHang.getText());
        if (csdlQLKH.updateKhachHang(f, vec)) {
            saveImg();
            getDataForTbDanhSachKhachHang();
            lockPanelBtnLuu();
            lamTrangTextKH();

            tblDSKH.repaint();
            tblDSKH.setColSelected(0);
            JOptionPane.showMessageDialog(f, "Cập nhật thành công");
        } else {
            JOptionPane.showMessageDialog(f, "Cập nhật thất bại");
            tblDSKH.getSelectionModel().setSelectionInterval(row, row);
        }
        tblDSKH.getSelectionModel().setSelectionInterval(row, row);
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
            DungChung.readImg(lbHinhAnhKhachQLKH, fileName);
            lbLinkHinhAnh.setText(fileName);
        }
    }

//    public void txtTimKiemKhachHangKeyReleased() {
//        String key = txtTimKiemKhachHang.getText().trim();
//        while (key.contains("  ")) {
//            key = key.replace("  ", " ");
//        }
//        lamTrangTextKH();
//        if(cbHangKhachHang.getSelectedIndex()==0)
//            DungChung.fillTable(FrmKH.dtblDSKH, csdlQLKH.findAndFilter(f, key,null));
//        else DungChung.fillTable(FrmKH.dtblDSKH, csdlQLKH.findAndFilter(f, key,cbHangKhachHang.getSelectedItem().toString()));
//        if(tblDSKH.getRowCount()>0)
//        tblDSKH.getSelectionModel().setSelectionInterval(0, 0);
//    }

    public void btnThemMoiKhachClicked() {
        lamTrangTextKH();
        txtMaKhachHang.setText(getAutoMaKH());
        unlockPanelBtnLuu();
        FrmKH.themMoi = true;
        btnDoThongSo.setEnabled(false);
        tblDSKH.clearSelection();
        tblDSKH.repaint();
        DungChung.readImg(lbHinhAnhKhachQLKH, "");
        lbLinkHinhAnh.setText("/anhKH/default.png");
    }

    public void openDoThongSo() {

        int row = tblDSKH.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(f, "Chọn khách hàng ở bảng trên");
            return;
        }
        String gioiTinh = "NAM";
        if (rbtnNu.isSelected()) {
            gioiTinh = "NỮ";
        }
        FrmMain.frmDoThongSo = new FrmDoThongSo(txtMaKhachHang.getText(), txtHoTen.getText(), txtSDT.getText(), gioiTinh, txtNgaySinh.getText(), lbLinkHinhAnh.getText());

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
        //txtTimKiemKhachHang.setText("");
//        if (cbHangKhachHang.getSelectedItem().toString().toLowerCase().equals("tất cả")) {
//            getDataForTbDanhSachKhachHang();
//            return;
//        }
        String key = txtTimKiemKhachHang.getText().trim();
        while (key.contains("  ")) {
            key = key.replace("  ", " ");
        }
        if(cbHangKhachHang.getSelectedIndex()==0)
            DungChung.fillTable(FrmKH.dtblDSKH, csdlQLKH.findAndFilter(f, key,null));
        else DungChung.fillTable(FrmKH.dtblDSKH, csdlQLKH.findAndFilter(f, key,cbHangKhachHang.getSelectedItem().toString()));
        //DungChung.fillTable(FrmKH.dtblDSKH, csdlQLKH.findAndFilter(cbHangKhachHang.getSelectedItem().toString()));
        if(tblDSKH.getRowCount()>0)
        tblDSKH.getSelectionModel().setSelectionInterval(0, 0);
    }

    public void dangKiDichVu() {

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

                FrmMain.frmDangKiDichVu = new FrmDangKiDichVu(tblDSKH.getValueAt(row, 0).toString());

            } catch (SQLException ex) {
                Logger.getLogger(DKDV.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(f, "Chọn 1 hàng trên bảng !");
        }
    }

    public QLKH(TableColumn tblDSKH, JTextField txtMaKhachHang, JTextField txtHoTen, JTextField txtCMND, JRadioButton rbtnNu, JRadioButton rbtnNam, JTextField txtNgaySinh, JTextField txtSDT, JTextField txtDiaChi, JTextField txtEmail, JTextField txtHangKhachHang, JLabel lbLinkHinhAnh, JLabel lbHinhAnhKhachQLKH, JButton btnLuuChinhSua, JButton btnHuyChinhSua, JButton btnThemMoi, JButton btnDoThongSo, JButton btnChonAnh, JPanel panelMainTextFieldQLKH, JPanel panelMainBtnQLKH, JPanel panelBtnLuuQLKH, JTextField txtTimKiemKhachHang, JComboBox cbHangKhachHang) {
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

    TableColumn tblDSKH;
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
