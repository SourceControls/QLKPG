package com.raven.form;
import com.raven.chart.ModelChart;
import static com.raven.form.Form1.f;
import com.raven.swing.ScrollBarCustom;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Frame;
import java.sql.Connection;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.DungChung;
import model.QLNV;

public class Form4 extends javax.swing.JPanel {
    
    int hoveredRow;
    int hoveredColumn;

    public static final int DAY_PER_MONTH = 30;

    public static Connection conn;
    public static Frame f;
    public static view.FrmDangNhap frmDangNhap = null; //new FrmDangNhap();


    public static DefaultTableModel dtblDSNV;
    private QLNV qlnv;
    public static String hoTenNV = "";
    public static String maNV = "NV01";
    public static boolean quanLy = false;

    public static boolean themMoi = false;
    public Form4() {
        initComponents();
        setOpaque(false);
        init();
        fixTable(jScrollPane3);
    }
    private void init() {
        setEnableText(false);
        DefaultTableModel model = (DefaultTableModel) tblNV.getModel();
        tblNV.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                qlnv.dumpDataFromTblDSNVToFields();
            }
        });
    }
    public void showData(){
        dtblDSNV = (DefaultTableModel) tblNV.getModel();
        qlnv = new QLNV(tblNV, txtMaNhanVien, txtHoTen, txtCMND, rbtnNu, rbtnNam, txtNgaySinh, txtSDT, 
                txtDiaChi, txtEmail,lbHinhAnhNV, btnChonAnh, btnHuy,btnSua,btnLuu, txtTimKiemNhanvien,cbLocNV
                ,rbtnConLam,rbtnKhongPT,rbtnKhongQuanLi,rbtnLaPT,rbtnLaQuanLi,rbtnNghilam,lbLinkHinhAnh,
                panelMainTextFieldQLNV,panelMainBtnQLNV,panelBtnLuuQLNV);
        qlnv.getDataForTbDanhSachNV();
    }
    public void setEnableText(boolean a){
        txtHoTen.setEnabled(a);
        txtSDT.setEnabled(a);
        txtEmail.setEnabled(a);
        rbtnNam.setEnabled(a);
        rbtnNu.setEnabled(a);
        txtNgaySinh.setEnabled(a);
        rbtnConLam.setEnabled(a);
        rbtnKhongPT.setEnabled(a);
        rbtnKhongQuanLi.setEnabled(a);
        rbtnLaPT.setEnabled(a);
        rbtnLaQuanLi.setEnabled(a);
        rbtnNghilam.setEnabled(a);
        txtCMND.setEnabled(a);
        txtDiaChi.setEnabled(a);
        btnChonAnh.setEnabled(a);
    }
    public void fixTable(JScrollPane scroll){
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel p = new JPanel();
        p.setBackground(new Color(245,245,245));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER,p);
        scroll.setBorder(new EmptyBorder(5,10,5,10));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        cbLocNV = new com.raven.swing.ComboBoxSuggestion();
        txtTimKiemNhanvien = new com.raven.swing.TextFieldAnimation();
        panelRound1 = new com.raven.swing.PanelRound();
        panelMainTextFieldQLNV = new javax.swing.JPanel();
        txtEmail = new com.raven.swing.TextFieldRound();
        jLabel9 = new javax.swing.JLabel();
        rbtnConLam = new com.raven.swing.RadioButtonCustom();
        jLabel1 = new javax.swing.JLabel();
        rbtnNghilam = new com.raven.swing.RadioButtonCustom();
        txtNgaySinh = new com.raven.swing.TextFieldRound();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaNhanVien = new com.raven.swing.TextFieldRound();
        txtSDT = new com.raven.swing.TextFieldRound();
        txtHoTen = new com.raven.swing.TextFieldRound();
        txtDiaChi = new com.raven.swing.TextFieldRound();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCMND = new com.raven.swing.TextFieldRound();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        rbtnLaPT = new com.raven.swing.RadioButtonCustom();
        rbtnKhongPT = new com.raven.swing.RadioButtonCustom();
        rbtnLaQuanLi = new com.raven.swing.RadioButtonCustom();
        rbtnKhongQuanLi = new com.raven.swing.RadioButtonCustom();
        rbtnNam = new com.raven.swing.RadioButtonCustom();
        rbtnNu = new com.raven.swing.RadioButtonCustom();
        lbHinhAnhNV = new javax.swing.JLabel();
        btnChonAnh = new com.raven.swing.KButton();
        lbLinkHinhAnh = new javax.swing.JLabel();
        panelMainBtnQLNV = new javax.swing.JPanel();
        btnThem = new com.raven.swing.KButton();
        btnSua = new com.raven.swing.KButton();
        panelBtnLuuQLNV = new javax.swing.JPanel();
        btnLuu = new com.raven.swing.KButton();
        btnHuy = new com.raven.swing.KButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblNV = new com.raven.swing.TableColumn();
        btnLamMoi = new com.raven.swing.KButton();

        dateChooser1.setTextRefernce(txtNgaySinh);
        dateChooser1.getAccessibleContext().setAccessibleParent(txtNgaySinh);

        cbLocNV.setEditable(false);
        cbLocNV.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "Quản lí", "Nhân viên" }));
        cbLocNV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLocNVItemStateChanged(evt);
            }
        });

        txtTimKiemNhanvien.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        txtTimKiemNhanvien.setHintText("Tìm nhân viên...");
        txtTimKiemNhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemNhanvienActionPerformed(evt);
            }
        });
        txtTimKiemNhanvien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemNhanvienKeyReleased(evt);
            }
        });

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));

        panelMainTextFieldQLNV.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Trạng thái: ");

        buttonGroup1.add(rbtnConLam);
        rbtnConLam.setSelected(true);
        rbtnConLam.setText("Còn làm");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Họ tên");

        buttonGroup1.add(rbtnNghilam);
        rbtnNghilam.setText("Nghỉ");

        txtNgaySinh.setEditable(false);
        txtNgaySinh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNgaySinhKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("CMND");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Giới tính");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Địa chỉ");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setText("Mã nhân viên");

        txtMaNhanVien.setEnabled(false);

        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Ngày sinh");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Số điện thoại");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Email");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("PT:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Quản lí:");

        buttonGroup2.add(rbtnLaPT);
        rbtnLaPT.setSelected(true);
        rbtnLaPT.setText("Có");

        buttonGroup2.add(rbtnKhongPT);
        rbtnKhongPT.setText("Không");

        buttonGroup3.add(rbtnLaQuanLi);
        rbtnLaQuanLi.setSelected(true);
        rbtnLaQuanLi.setText("Có");

        buttonGroup3.add(rbtnKhongQuanLi);
        rbtnKhongQuanLi.setText("Không");
        rbtnKhongQuanLi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnKhongQuanLiActionPerformed(evt);
            }
        });

        buttonGroup4.add(rbtnNam);
        rbtnNam.setSelected(true);
        rbtnNam.setText("Nam");

        buttonGroup4.add(rbtnNu);
        rbtnNu.setText("Nữ");

        javax.swing.GroupLayout panelMainTextFieldQLNVLayout = new javax.swing.GroupLayout(panelMainTextFieldQLNV);
        panelMainTextFieldQLNV.setLayout(panelMainTextFieldQLNVLayout);
        panelMainTextFieldQLNVLayout.setHorizontalGroup(
            panelMainTextFieldQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainTextFieldQLNVLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(panelMainTextFieldQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(panelMainTextFieldQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainTextFieldQLNVLayout.createSequentialGroup()
                        .addGroup(panelMainTextFieldQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMainTextFieldQLNVLayout.createSequentialGroup()
                                .addComponent(rbtnNam, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnNu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMainTextFieldQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(84, 84, 84)
                        .addGroup(panelMainTextFieldQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMainTextFieldQLNVLayout.createSequentialGroup()
                                .addGroup(panelMainTextFieldQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9))
                                .addGap(30, 30, 30)
                                .addGroup(panelMainTextFieldQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbtnConLam, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rbtnKhongPT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelMainTextFieldQLNVLayout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(rbtnKhongQuanLi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelMainTextFieldQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnLaQuanLi, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbtnLaPT, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbtnNghilam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelMainTextFieldQLNVLayout.createSequentialGroup()
                        .addGroup(panelMainTextFieldQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        panelMainTextFieldQLNVLayout.setVerticalGroup(
            panelMainTextFieldQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainTextFieldQLNVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainTextFieldQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainTextFieldQLNVLayout.createSequentialGroup()
                        .addGroup(panelMainTextFieldQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMainTextFieldQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtMaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMainTextFieldQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelMainTextFieldQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMainTextFieldQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                .addComponent(rbtnNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbtnNu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelMainTextFieldQLNVLayout.createSequentialGroup()
                        .addGroup(panelMainTextFieldQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMainTextFieldQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                .addComponent(rbtnConLam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbtnNghilam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(panelMainTextFieldQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMainTextFieldQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rbtnKhongPT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rbtnLaPT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(panelMainTextFieldQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbtnKhongQuanLi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbtnLaQuanLi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(panelMainTextFieldQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainTextFieldQLNVLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMainTextFieldQLNVLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelMainTextFieldQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        lbHinhAnhNV.setBackground(new java.awt.Color(255, 255, 255));
        lbHinhAnhNV.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lbHinhAnhNV.setOpaque(true);

        btnChonAnh.setText("Chọn ảnh");
        btnChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnhActionPerformed(evt);
            }
        });

        panelMainBtnQLNV.setBackground(new java.awt.Color(255, 255, 255));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMainBtnQLNVLayout = new javax.swing.GroupLayout(panelMainBtnQLNV);
        panelMainBtnQLNV.setLayout(panelMainBtnQLNVLayout);
        panelMainBtnQLNVLayout.setHorizontalGroup(
            panelMainBtnQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainBtnQLNVLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(panelMainBtnQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelMainBtnQLNVLayout.setVerticalGroup(
            panelMainBtnQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainBtnQLNVLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        panelBtnLuuQLNV.setBackground(new java.awt.Color(255, 255, 255));

        btnLuu.setText("Lưu");
        btnLuu.setEnabled(false);
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.setEnabled(false);
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBtnLuuQLNVLayout = new javax.swing.GroupLayout(panelBtnLuuQLNV);
        panelBtnLuuQLNV.setLayout(panelBtnLuuQLNVLayout);
        panelBtnLuuQLNVLayout.setHorizontalGroup(
            panelBtnLuuQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBtnLuuQLNVLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(panelBtnLuuQLNVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBtnLuuQLNVLayout.setVerticalGroup(
            panelBtnLuuQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnLuuQLNVLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLinkHinhAnh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(lbHinhAnhNV, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addComponent(btnChonAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)))
                .addComponent(panelMainTextFieldQLNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(panelMainBtnQLNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBtnLuuQLNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelMainBtnQLNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelBtnLuuQLNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelMainTextFieldQLNV, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(lbHinhAnhNV, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbLinkHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnChonAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8_filter_20px_1.png"))); // NOI18N

        jScrollPane3.setBackground(new java.awt.Color(245, 245, 245));
        jScrollPane3.setBorder(null);

        tblNV.setBackground(new java.awt.Color(255, 255, 255));
        tblNV.setForeground(new java.awt.Color(255, 255, 255));
        tblNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Họ tên", "Giới tính", "CMND", "Ngày sinh", "PT", "Quản lí", "Nghỉ làm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNV.setGridColor(new java.awt.Color(204, 204, 204));
        tblNV.setHasBtn(false);
        tblNV.setPreferredScrollableViewportSize(new java.awt.Dimension(10, 400));
        tblNV.setTextBTN1("Thanh toán");
        tblNV.setTextBTN2("Hủy đk");
        tblNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNVMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblNV);

        btnLamMoi.setText("Làm mới");
        btnLamMoi.setkEndColor(new java.awt.Color(104, 109, 224));
        btnLamMoi.setkStartColor(new java.awt.Color(165, 94, 234));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTimKiemNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(669, 669, 669)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(cbLocNV, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1486, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiemNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbLocNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbLocNVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLocNVItemStateChanged
        qlnv.filterNV();
    }//GEN-LAST:event_cbLocNVItemStateChanged

    private void txtTimKiemNhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemNhanvienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemNhanvienActionPerformed

    private void txtTimKiemNhanvienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemNhanvienKeyReleased
       qlnv.txtTimKiemNhanVienKeyReleased();
        cbLocNV.setSelectedIndex(0);
    }//GEN-LAST:event_txtTimKiemNhanvienKeyReleased

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
      qlnv.unlockPanelBtnLuu();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txtNgaySinhKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNgaySinhKeyPressed
        dateChooser1.showPopup();
    }//GEN-LAST:event_txtNgaySinhKeyPressed

    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiActionPerformed

    private void rbtnKhongQuanLiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnKhongQuanLiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnKhongQuanLiActionPerformed

    private void btnChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAnhActionPerformed
      
    }//GEN-LAST:event_btnChonAnhActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
            if (themMoi) {
            qlnv.addNhanvien();
        } else {
            qlnv.luuChinhSuaNhanVien();
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        qlnv.lockPanelBtnLuu();
        btnThem.setEnabled(true);
        if (tblNV.getSelectedRow() > 0) {
            btnSua.setEnabled(true);
        }
        qlnv.lamTrangTextNV();
        themMoi = false;
        System.out.println(tblNV.getSelectedRow());
        if(tblNV.getSelectedRow()>=0)  qlnv.dumpDataFromTblDSNVToFields();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        qlnv.lamTrangTextNV();
        qlnv.btnThemMoiNVClicked();
        btnSua.setEnabled(false);
        DungChung.readImg(f, lbHinhAnhNV, "");
        lbLinkHinhAnh.setText("/anhKH/default.png");
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNVMouseClicked

    }//GEN-LAST:event_tblNVMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        qlnv.getDataForTbDanhSachNV();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.KButton btnChonAnh;
    private com.raven.swing.KButton btnHuy;
    private com.raven.swing.KButton btnLamMoi;
    private com.raven.swing.KButton btnLuu;
    private com.raven.swing.KButton btnSua;
    private com.raven.swing.KButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private com.raven.swing.ComboBoxSuggestion cbLocNV;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbHinhAnhNV;
    private javax.swing.JLabel lbLinkHinhAnh;
    private javax.swing.JPanel panelBtnLuuQLNV;
    private javax.swing.JPanel panelMainBtnQLNV;
    private javax.swing.JPanel panelMainTextFieldQLNV;
    private com.raven.swing.PanelRound panelRound1;
    private com.raven.swing.RadioButtonCustom rbtnConLam;
    private com.raven.swing.RadioButtonCustom rbtnKhongPT;
    private com.raven.swing.RadioButtonCustom rbtnKhongQuanLi;
    private com.raven.swing.RadioButtonCustom rbtnLaPT;
    private com.raven.swing.RadioButtonCustom rbtnLaQuanLi;
    private com.raven.swing.RadioButtonCustom rbtnNam;
    private com.raven.swing.RadioButtonCustom rbtnNghilam;
    private com.raven.swing.RadioButtonCustom rbtnNu;
    private com.raven.swing.TableColumn tblNV;
    private com.raven.swing.TextFieldRound txtCMND;
    private com.raven.swing.TextFieldRound txtDiaChi;
    private com.raven.swing.TextFieldRound txtEmail;
    private com.raven.swing.TextFieldRound txtHoTen;
    private com.raven.swing.TextFieldRound txtMaNhanVien;
    private com.raven.swing.TextFieldRound txtNgaySinh;
    private com.raven.swing.TextFieldRound txtSDT;
    private com.raven.swing.TextFieldAnimation txtTimKiemNhanvien;
    // End of variables declaration//GEN-END:variables
}
