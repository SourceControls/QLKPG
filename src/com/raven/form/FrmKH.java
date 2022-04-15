package com.raven.form;

import javax.swing.table.DefaultTableModel;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Rectangle;
import java.sql.Connection;
import model.DKDV;
import model.QLKH;
import model.QLQVT;
import com.raven.form.*;
import javax.swing.ImageIcon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.DungChung;

public class FrmKH extends javax.swing.JPanel {

    int hoveredRow;
    int hoveredColumn;

    public static final int DAY_PER_MONTH = 30;
    
    public static Connection conn;
    public static Frame f;
    private QLKH qlkh;
    public static DefaultTableModel dtblDSKH;
    public FrmDoThongSo frmDoThongSo = null;
    public FrmDangKiDichVu frmDangKiDichVu = null;
    public FrmThanhToan frmThanhToan = null;

    public static String hoTenNV = "";
    public static String maNV = "NV01";
    public static boolean quanLy = false;

    public static boolean themMoi = false;
    //dùng để đăng nhập

    public FrmKH() {
        
        initComponents();
        setOpaque(false);
        init();
    }

    private void init() {
        setEnableText(false);
        DefaultTableModel model = (DefaultTableModel) tblDSKH.getModel();
        tblDSKH.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                qlkh.dumpDataFromTblDSKHToFields();
            }
        });
    }

    public void setEnableText(boolean a) {

        txtHoTen.setEnabled(a);
        txtSDT.setEnabled(a);
        txtEmail.setEnabled(a);
        rbtnNam.setEnabled(a);
        rbtnNu.setEnabled(a);
        txtHangKhachHang.setEnabled(a);
        txtCMND.setEnabled(a);
        txtDiaChi.setEnabled(a);
        btnChonAnh.setEnabled(a);
    }

    public void setCusor2Btn() {

        Point tableLocation = tblDSKH.getLocation();
        int xEnd = tableLocation.x + tblDSKH.getWidth();
        Rectangle rec1 = tblDSKH.getTableHeader().getHeaderRect(tblDSKH.getColumnCount() - 2);
        int xStart = rec1.x;
        int yStart = rec1.y + rec1.height;
        Point point = new Point(xStart, yStart + 60);
        Rectangle rec = new Rectangle(point, new Dimension(xEnd - xStart, getHeight() - 449));
        try {

            Point p = getMousePosition();// set cusor bàn tay cho nút sửa và đk trên table
            if (rec.contains(p)) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            } else {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                tblDSKH.setRowHoverred(-1);
                tblDSKH.setColHoverred(-1);
                tblDSKH.repaint();
            }

        } catch (Exception ex) {
        }

    }

    public void showData() {
        dtblDSKH = (DefaultTableModel) tblDSKH.getModel();
        qlkh = new QLKH(tblDSKH, txtMaKhachHang, txtHoTen, txtCMND, rbtnNu, rbtnNam, txtNgaySinh, txtSDT, txtDiaChi, txtEmail,
                txtHangKhachHang, lbLinkHinhAnh, lbHinhAnhKhachQLKH, btnChonAnh, btnHuyDangKi,
                btnThemMoi, btnDoThongSo, btnChonAnh, panelMainTextFieldQLKH, panelMainBtnQLKH, panelBtnLuuQLKH,
                txtTimKiemKhachHang, cbHangKH);
        qlkh.getDataForTbDanhSachKhachHang();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        dateChooser1 = new com.raven.datechooser.DateChooser();
        panelRound1 = new com.raven.swing.PanelRound();
        jPanel2 = new javax.swing.JPanel();
        lbHinhAnhKhachQLKH = new javax.swing.JLabel();
        btnChonAnh = new com.raven.swing.KButton();
        lbLinkHinhAnh = new javax.swing.JLabel();
        panelMainTextFieldQLKH = new javax.swing.JPanel();
        txtDiaChi = new com.raven.swing.TextFieldRound();
        jLabel8 = new javax.swing.JLabel();
        txtCMND = new com.raven.swing.TextFieldRound();
        txtHangKhachHang = new com.raven.swing.TextFieldRound();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNgaySinh = new com.raven.swing.TextFieldRound();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaKhachHang = new com.raven.swing.TextFieldRound();
        txtSDT = new com.raven.swing.TextFieldRound();
        txtHoTen = new com.raven.swing.TextFieldRound();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new com.raven.swing.TextFieldRound();
        rbtnNam = new com.raven.swing.RadioButtonCustom();
        rbtnNu = new com.raven.swing.RadioButtonCustom();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        panelBtnLuuQLKH = new javax.swing.JPanel();
        btnLuu = new com.raven.swing.KButton();
        btnHuyDangKi = new com.raven.swing.KButton();
        panelMainBtnQLKH = new javax.swing.JPanel();
        btnThemMoi = new com.raven.swing.KButton();
        btnDoThongSo = new com.raven.swing.KButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSKH = new com.raven.swing.TableColumn();
        scrollBar1 = new com.raven.swing.ScrollBar();
        jPanel4 = new javax.swing.JPanel();
        btnLamMoi = new com.raven.swing.KButton();
        txtTimKiemKhachHang = new com.raven.swing.TextFieldAnimation();
        jPanel5 = new javax.swing.JPanel();
        cbHangKH = new com.raven.swing.ComboBoxSuggestion();
        jLabel11 = new javax.swing.JLabel();

        dateChooser1.setTextRefernce(txtNgaySinh);

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lbHinhAnhKhachQLKH.setBackground(new java.awt.Color(255, 255, 255));
        lbHinhAnhKhachQLKH.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lbHinhAnhKhachQLKH.setOpaque(true);

        btnChonAnh.setText("Chọn ảnh");
        btnChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbLinkHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbHinhAnhKhachQLKH, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addGap(114, 114, 114))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(btnChonAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(lbHinhAnhKhachQLKH, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLinkHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChonAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelMainTextFieldQLKH.setBackground(new java.awt.Color(255, 255, 255));

        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Ngày sinh");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Hạng: ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Họ tên");

        txtNgaySinh.setEnabled(false);
        txtNgaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaySinhActionPerformed(evt);
            }
        });
        txtNgaySinh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNgaySinhKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Giới tính");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setText("Mã khách hàng");

        txtMaKhachHang.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Số điện thoại");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Email");

        buttonGroup1.add(rbtnNam);
        rbtnNam.setSelected(true);
        rbtnNam.setText("Nam");

        buttonGroup1.add(rbtnNu);
        rbtnNu.setText("Nữ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("CMND");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Địa chỉ");

        javax.swing.GroupLayout panelMainTextFieldQLKHLayout = new javax.swing.GroupLayout(panelMainTextFieldQLKH);
        panelMainTextFieldQLKH.setLayout(panelMainTextFieldQLKHLayout);
        panelMainTextFieldQLKHLayout.setHorizontalGroup(
            panelMainTextFieldQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainTextFieldQLKHLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelMainTextFieldQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(panelMainTextFieldQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainTextFieldQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelMainTextFieldQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelMainTextFieldQLKHLayout.createSequentialGroup()
                            .addGroup(panelMainTextFieldQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelMainTextFieldQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(txtHangKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelMainTextFieldQLKHLayout.createSequentialGroup()
                        .addComponent(rbtnNam, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnNu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMainTextFieldQLKHLayout.setVerticalGroup(
            panelMainTextFieldQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainTextFieldQLKHLayout.createSequentialGroup()
                .addGroup(panelMainTextFieldQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelMainTextFieldQLKHLayout.createSequentialGroup()
                        .addGroup(panelMainTextFieldQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMainTextFieldQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(txtMaKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHangKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelMainTextFieldQLKHLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMainTextFieldQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelMainTextFieldQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(rbtnNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbtnNu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMainTextFieldQLKHLayout.createSequentialGroup()
                        .addGroup(panelMainTextFieldQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelMainTextFieldQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainTextFieldQLKHLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMainTextFieldQLKHLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMainTextFieldQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        panelBtnLuuQLKH.setBackground(new java.awt.Color(255, 255, 255));

        btnLuu.setText("Lưu");
        btnLuu.setEnabled(false);
        btnLuu.setkEndColor(new java.awt.Color(104, 109, 224));
        btnLuu.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnLuu.setkStartColor(new java.awt.Color(199, 236, 238));
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnHuyDangKi.setText("Hủy");
        btnHuyDangKi.setEnabled(false);
        btnHuyDangKi.setkEndColor(new java.awt.Color(104, 109, 224));
        btnHuyDangKi.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnHuyDangKi.setkStartColor(new java.awt.Color(199, 236, 238));
        btnHuyDangKi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyDangKiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBtnLuuQLKHLayout = new javax.swing.GroupLayout(panelBtnLuuQLKH);
        panelBtnLuuQLKH.setLayout(panelBtnLuuQLKHLayout);
        panelBtnLuuQLKHLayout.setHorizontalGroup(
            panelBtnLuuQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnLuuQLKHLayout.createSequentialGroup()
                .addGroup(panelBtnLuuQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelBtnLuuQLKHLayout.setVerticalGroup(
            panelBtnLuuQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnLuuQLKHLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnHuyDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        panelMainBtnQLKH.setBackground(new java.awt.Color(255, 255, 255));

        btnThemMoi.setText("Thêm mới");
        btnThemMoi.setkEndColor(new java.awt.Color(104, 109, 224));
        btnThemMoi.setkStartColor(new java.awt.Color(165, 94, 234));
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });

        btnDoThongSo.setText("Đo BMI");
        btnDoThongSo.setEnabled(false);
        btnDoThongSo.setkEndColor(new java.awt.Color(153, 153, 0));
        btnDoThongSo.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnDoThongSo.setkStartColor(new java.awt.Color(255, 204, 102));
        btnDoThongSo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoThongSoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMainBtnQLKHLayout = new javax.swing.GroupLayout(panelMainBtnQLKH);
        panelMainBtnQLKH.setLayout(panelMainBtnQLKHLayout);
        panelMainBtnQLKHLayout.setHorizontalGroup(
            panelMainBtnQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainBtnQLKHLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDoThongSo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panelMainBtnQLKHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMainBtnQLKHLayout.setVerticalGroup(
            panelMainBtnQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainBtnQLKHLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnDoThongSo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMainBtnQLKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelBtnLuuQLKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBtnLuuQLKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelMainBtnQLKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelMainTextFieldQLKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(panelMainTextFieldQLKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        jPanel1.setBackground(new java.awt.Color(241, 241, 241));

        jScrollPane1.setBackground(new java.awt.Color(245, 245, 245));
        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBar(scrollBar1);

        tblDSKH.setAutoCreateRowSorter(true);
        tblDSKH.setBackground(new java.awt.Color(240, 240, 240));
        tblDSKH.setForeground(new java.awt.Color(255, 255, 255));
        tblDSKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã kh", "Họ tên", "SĐT", "Giới tính", "Ngày sinh", "CMND", "Email", "Địa chỉ", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSKH.setEndColorBtnFix(new java.awt.Color(255, 0, 38));
        tblDSKH.setStartColorBtnFix(new java.awt.Color(255, 180, 48));
        tblDSKH.setStartColorBtnSignUp(new java.awt.Color(0, 243, 92));
        tblDSKH.setTextBTN1("Sửa");
        tblDSKH.setTextBTN2("ĐKDV");
        tblDSKH.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tblDSKHMouseMoved(evt);
            }
        });
        tblDSKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSKHMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblDSKHMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSKH);
        if (tblDSKH.getColumnModel().getColumnCount() > 0) {
            tblDSKH.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblDSKH.getColumnModel().getColumn(8).setMaxWidth(80);
            tblDSKH.getColumnModel().getColumn(9).setMaxWidth(80);
        }

        scrollBar1.setBackground(new java.awt.Color(245, 245, 245));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(scrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );

        btnLamMoi.setText("Làm mới");
        btnLamMoi.setkEndColor(new java.awt.Color(104, 109, 224));
        btnLamMoi.setkStartColor(new java.awt.Color(165, 94, 234));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        txtTimKiemKhachHang.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        txtTimKiemKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemKhachHangActionPerformed(evt);
            }
        });
        txtTimKiemKhachHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKhachHangKeyReleased(evt);
            }
        });

        cbHangKH.setEditable(false);
        cbHangKH.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none", "ĐỒNG", "BẠC", "VÀNG", "KIM CƯƠNG" }));
        cbHangKH.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbHangKHItemStateChanged(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8_filter_20px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(10, 10, 10)
                .addComponent(cbHangKH, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbHangKH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(txtTimKiemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(687, 687, 687)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimKiemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemKhachHangActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        setCusor2Btn();
    }//GEN-LAST:event_formMouseMoved

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    private void tblDSKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSKHMouseClicked
        qlkh.dumpDataFromTblDSKHToFields();
    }//GEN-LAST:event_tblDSKHMouseClicked

    private void tblDSKHMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSKHMouseMoved

        setCusor2Btn();

        /////////////////////
        int row = tblDSKH.rowAtPoint(evt.getPoint());
        int col = tblDSKH.columnAtPoint(evt.getPoint());
        if (row >= 0 && col == tblDSKH.getColumnCount() - 2) { //di chuyen chuot vao nut sua
            tblDSKH.setBtn1Hoverred(true);
            tblDSKH.setBtn2Hoverred(false);
            tblDSKH.setRowHoverred(row);
            tblDSKH.setColHoverred(col);
            tblDSKH.repaint();
            //////////

        } else if (row >= 0 && col == tblDSKH.getColumnCount() - 1) { //di chuyen chuot vao nut dk
            tblDSKH.setBtn1Hoverred(false);
            tblDSKH.setBtn2Hoverred(true);
            tblDSKH.setRowHoverred(row);
            tblDSKH.setColHoverred(col);
            tblDSKH.repaint();
        } else {
            tblDSKH.setRowHoverred(-1);
            tblDSKH.setColHoverred(-1);
            tblDSKH.repaint();
        }


    }//GEN-LAST:event_tblDSKHMouseMoved

    private void tblDSKHMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSKHMouseReleased

        btnDoThongSo.setEnabled(true);
        int row = tblDSKH.rowAtPoint(evt.getPoint());
        int col = tblDSKH.columnAtPoint(evt.getPoint());
        if (row >= 0 && col == tblDSKH.getColumnCount() - 2) { //an vao nut sua
            setEnableText(true);
            tblDSKH.setBtn1Selected(true);
            tblDSKH.setBtn2Selected(false);
            tblDSKH.setRowSelected(row);
            tblDSKH.setColSelected(col);
            tblDSKH.repaint();
            ////////////////////////////////////////////////////////
            qlkh.unlockPanelBtnLuu();
            themMoi = false;
        } else if (row >= 0 && col == tblDSKH.getColumnCount() - 1) { //an vao nut dk

            tblDSKH.setBtn2Selected(true);
            tblDSKH.setBtn1Selected(false);
            tblDSKH.setRowSelected(row);
            tblDSKH.setColSelected(col);
            tblDSKH.repaint();

            ////////////////////////////////
            //if(frmDangKiDichVu == null) System.out.println("null");
            qlkh.dangKiDichVu(frmDangKiDichVu);
            themMoi = false;

        } else {
            tblDSKH.setRowSelected(-1);
            tblDSKH.setColSelected(-1);
            tblDSKH.repaint();

        }
        if (btnLuu.isEnabled() && col != 8) {
            qlkh.lockPanelBtnLuu();
        }
    }//GEN-LAST:event_tblDSKHMouseReleased
    public void resetBtnFix() {
        tblDSKH.setBtn2Selected(false);
        tblDSKH.setBtn1Selected(false);
        tblDSKH.setRowSelected(-1);
        tblDSKH.setColSelected(-1);
        tblDSKH.repaint();
    }
    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        qlkh.lamTrangTextKH();
        qlkh.btnThemMoiKhachClicked();
        btnDoThongSo.setEnabled(false);
        tblDSKH.setRowSelected(-1);
        tblDSKH.repaint();
        DungChung.readImg(f, lbHinhAnhKhachQLKH, "");
        lbLinkHinhAnh.setText("/anhKH/default.png");
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        if (themMoi) {
            qlkh.addKhachHang();
        } else {
            qlkh.luuChinhSuaKhachHang();
        }
        tblDSKH.setRowSelected(-1);
        tblDSKH.setColSelected(-1);
        tblDSKH.repaint();
        btnDoThongSo.setEnabled(false);

    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAnhActionPerformed
        qlkh.selectImg();
    }//GEN-LAST:event_btnChonAnhActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // setCusor2Btn(isAddingCus);
    }//GEN-LAST:event_formComponentResized

    private void btnDoThongSoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoThongSoActionPerformed
        if (tblDSKH.getSelectedRow() > 0) {
            qlkh.openDoThongSo(frmDoThongSo);
            //sf.setVisible(true);
        }
    }//GEN-LAST:event_btnDoThongSoActionPerformed

    private void btnHuyDangKiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyDangKiActionPerformed
        qlkh.lockPanelBtnLuu();
        btnThemMoi.setEnabled(true);
        if (tblDSKH.getSelectedRow() >= 0) {
            btnDoThongSo.setEnabled(true);
        }
        qlkh.lamTrangTextKH();
        tblDSKH.setRowSelected(-1);
        tblDSKH.repaint();
        themMoi = false;
    }//GEN-LAST:event_btnHuyDangKiActionPerformed

    private void txtTimKiemKhachHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKhachHangKeyReleased
        qlkh.txtTimKiemKhachHangKeyReleased();
        cbHangKH.setSelectedIndex(0);
    }//GEN-LAST:event_txtTimKiemKhachHangKeyReleased

    private void cbHangKHItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbHangKHItemStateChanged
        qlkh.filterKH();
    }//GEN-LAST:event_cbHangKHItemStateChanged

    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiActionPerformed

    private void txtNgaySinhKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNgaySinhKeyPressed
//        dateChooser1.showPopup();
    }//GEN-LAST:event_txtNgaySinhKeyPressed

    private void txtNgaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaySinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinhActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        qlkh.getDataForTbDanhSachKhachHang();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.KButton btnChonAnh;
    private com.raven.swing.KButton btnDoThongSo;
    private com.raven.swing.KButton btnHuyDangKi;
    private com.raven.swing.KButton btnLamMoi;
    private com.raven.swing.KButton btnLuu;
    private com.raven.swing.KButton btnThemMoi;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.raven.swing.ComboBoxSuggestion cbHangKH;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbHinhAnhKhachQLKH;
    private javax.swing.JLabel lbLinkHinhAnh;
    private javax.swing.JPanel panelBtnLuuQLKH;
    private javax.swing.JPanel panelMainBtnQLKH;
    private javax.swing.JPanel panelMainTextFieldQLKH;
    private com.raven.swing.PanelRound panelRound1;
    private com.raven.swing.RadioButtonCustom rbtnNam;
    private com.raven.swing.RadioButtonCustom rbtnNu;
    private com.raven.swing.ScrollBar scrollBar1;
    private com.raven.swing.TableColumn tblDSKH;
    private com.raven.swing.TextFieldRound txtCMND;
    private com.raven.swing.TextFieldRound txtDiaChi;
    private com.raven.swing.TextFieldRound txtEmail;
    private com.raven.swing.TextFieldRound txtHangKhachHang;
    private com.raven.swing.TextFieldRound txtHoTen;
    private com.raven.swing.TextFieldRound txtMaKhachHang;
    private com.raven.swing.TextFieldRound txtNgaySinh;
    private com.raven.swing.TextFieldRound txtSDT;
    private com.raven.swing.TextFieldAnimation txtTimKiemKhachHang;
    // End of variables declaration//GEN-END:variables
}
