package com.raven.form;

import PDF.PhieuDangKiPDF;
import com.raven.main.FrmMain;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import model.QLKH;
import model.DKDV;
import model.QLQVT;

public class FrmPDK extends javax.swing.JPanel {

    public static DefaultTableModel dtblPDK;
    public QLQVT qlqvt;
    public QLKH qlkh;
    public DKDV dkdv;
    public FrmThanhToan frmThanhToan = null;
    public static JTable tbl;
    public FrmPDK() {
        initComponents();
        setOpaque(false);
        init();
    }

    private void init() {

        DefaultTableModel model = (DefaultTableModel) tblPDK.getModel();

        tblPDK.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tblPDK.rowAtPoint(evt.getPoint());
                int col = tblPDK.columnAtPoint(evt.getPoint());
                if (row >= 0 && (col == 8 || col == 9)) {
                    System.out.println(row + " " + col);

                }
            }
        });
        tblPDK.getSelectionModel().setSelectionInterval(0,0);
        tblPDK.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                dkdv.dumpDataFromTblPDKToFields();
            }
        });
                if(!FrmMain.modelNV.isQuanli())
                    btnHuyDangKi.setEnabled(false);

    }

    public void showData() {
        dtblPDK = (DefaultTableModel) tblPDK.getModel();
        dkdv = new DKDV(tblPDK, lbHinhAnhKhachQLDK, lbMaKhachHang, lbHoTen, lbCMND, lbGioiTinh, lbNgaySinh, lbEmail, lbSDT,
                lbDiaChi, lbHangKhachHang, txtGhiChuQLDK, txtTimKiemDangKi, lbLinkHinhAnh, cbTrangThaiPDK);
        if (FrmMain.modelNV.isQuanli()) {
            TableColumn col = new TableColumn(dtblPDK.getColumnCount());
         col.setHeaderValue("Người Lập");
        tblPDK.addColumn(col);
        dtblPDK.addColumn("Người Lập");
        }
    

        dkdv.getDataForTblDangKiDichVu();
        tblPDK.getSelectionModel().setSelectionInterval(0, 0);
        tbl=tblPDK;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        btnLamMoi = new com.raven.swing.KButton();
        txtTimKiemDangKi = new com.raven.swing.TextFieldAnimation();
        jPanel4 = new javax.swing.JPanel();
        cbTrangThaiPDK = new com.raven.swing.ComboBoxSuggestion();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        scrollBar1 = new com.raven.swing.ScrollBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPDK = new com.raven.swing.TableColumn();
        panelRound1 = new com.raven.swing.PanelRound();
        jPanel8 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lbMaKhachHang = new javax.swing.JLabel();
        lbSDT = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        lbDiaChi = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbHangKhachHang = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lbNgaySinh = new javax.swing.JLabel();
        lbCMND = new javax.swing.JLabel();
        lbGioiTinh = new javax.swing.JLabel();
        lbHoTen = new javax.swing.JLabel();
        lbHinhAnhKhachQLDK = new javax.swing.JLabel();
        lbLinkHinhAnh = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGhiChuQLDK = new javax.swing.JTextArea();
        btnHuyDangKi = new com.raven.swing.KButton();
        btnThanhToan = new com.raven.swing.KButton();
        btnLuuGhiChuDangKi = new com.raven.swing.KButton();
        btnThanhToan1 = new com.raven.swing.KButton();

        btnLamMoi.setText("Làm mới");
        btnLamMoi.setkEndColor(new java.awt.Color(153, 153, 255));
        btnLamMoi.setkStartColor(new java.awt.Color(104, 109, 224));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        txtTimKiemDangKi.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        txtTimKiemDangKi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemDangKiActionPerformed(evt);
            }
        });
        txtTimKiemDangKi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemDangKiKeyReleased(evt);
            }
        });

        jPanel4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel4FocusGained(evt);
            }
        });

        cbTrangThaiPDK.setEditable(false);
        cbTrangThaiPDK.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất Cả", "CHỜ KÍCH HOẠT", "ĐÃ KÍCH HOẠT", "SẮP HẾT HẠN", "HẾT HẠN", "SẮP TỚI HẠN NỘP TIỀN", "ĐÃ HỦY" }));
        cbTrangThaiPDK.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTrangThaiPDKItemStateChanged(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8_filter_20px_1.png"))); // NOI18N

        jLabel1.setText("Lọc Theo Trạng Thái Phiếu:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTrangThaiPDK, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbTrangThaiPDK, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Danh Sách Phiếu Đăng Kí");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiemDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(512, 512, 512)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(512, 512, 512)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiemDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        scrollBar1.setBackground(new java.awt.Color(245, 245, 245));

        jScrollPane1.setBackground(new java.awt.Color(245, 245, 245));
        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBar(scrollBar1);

        tblPDK.setAutoCreateRowSorter(true);
        tblPDK.setBackground(new java.awt.Color(240, 240, 240));
        tblPDK.setForeground(new java.awt.Color(255, 255, 255));
        tblPDK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã PĐK", "Mã KH", "Họ tên", "SĐT", "Dịch vụ", "Ngày đăng kí", "Ngày bắt đầu", "Ngày kết thúc", "Thuế(%)", "Tổng tiền(VNĐ)", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPDK.setHasBtn(false);
        tblPDK.setTextBTN1("Thanh toán");
        tblPDK.setTextBTN2("Hủy đk");
        tblPDK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPDKMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPDK);
        if (tblPDK.getColumnModel().getColumnCount() > 0) {
            tblPDK.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblPDK.getColumnModel().getColumn(1).setMinWidth(95);
            tblPDK.getColumnModel().getColumn(1).setMaxWidth(100);
            tblPDK.getColumnModel().getColumn(2).setMinWidth(150);
            tblPDK.getColumnModel().getColumn(8).setMaxWidth(60);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1496, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scrollBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
        );

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel33.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel33.setText("Họ Tên:");

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel13.setText("Mã KH:");

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel15.setText("Email:");

        jLabel34.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel34.setText("SĐT:");

        jLabel36.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel36.setText("CMND:");

        jLabel37.setText("Địa chỉ");

        jLabel38.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel38.setText("Hạng Khách Hàng:");

        lbMaKhachHang.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbMaKhachHang.setText("NULL");

        lbSDT.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbSDT.setText("NULL");

        lbEmail.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbEmail.setText("NULL");

        lbDiaChi.setText("NULL");

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel14.setText("Giới Tính:");

        lbHangKhachHang.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbHangKhachHang.setText("NULL");

        jLabel35.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel35.setText("Ngày Sinh:");

        lbNgaySinh.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbNgaySinh.setText("NULL");

        lbCMND.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbCMND.setText("NULL");

        lbGioiTinh.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbGioiTinh.setText("NULL");

        lbHoTen.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbHoTen.setText("NULL");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbHangKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCMND, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbGioiTinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbCMND, lbEmail, lbGioiTinh, lbHangKhachHang, lbHoTen, lbMaKhachHang, lbNgaySinh, lbSDT});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lbHangKhachHang)
                    .addComponent(jLabel38)
                    .addComponent(lbMaKhachHang))
                .addGap(39, 39, 39)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel15)
                    .addComponent(lbEmail)
                    .addComponent(lbHoTen))
                .addGap(40, 40, 40)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(lbSDT)
                    .addComponent(jLabel36)
                    .addComponent(lbCMND))
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(lbNgaySinh)
                    .addComponent(jLabel14)
                    .addComponent(lbGioiTinh))
                .addGap(157, 157, 157)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(lbDiaChi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbHinhAnhKhachQLDK.setBackground(new java.awt.Color(255, 255, 255));
        lbHinhAnhKhachQLDK.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lbHinhAnhKhachQLDK.setOpaque(true);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        txtGhiChuQLDK.setColumns(20);
        txtGhiChuQLDK.setRows(5);
        jScrollPane2.setViewportView(txtGhiChuQLDK);

        btnHuyDangKi.setText("Hủy đăng kí");
        btnHuyDangKi.setkEndColor(new java.awt.Color(255, 51, 255));
        btnHuyDangKi.setkHoverEndColor(new java.awt.Color(153, 153, 255));
        btnHuyDangKi.setkHoverForeGround(new java.awt.Color(255, 0, 255));
        btnHuyDangKi.setkHoverStartColor(new java.awt.Color(104, 109, 224));
        btnHuyDangKi.setkStartColor(new java.awt.Color(224, 86, 253));
        btnHuyDangKi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyDangKiActionPerformed(evt);
            }
        });

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.setkEndColor(new java.awt.Color(153, 153, 255));
        btnThanhToan.setkStartColor(new java.awt.Color(104, 109, 224));
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnLuuGhiChuDangKi.setText("Lưu Ghi Chú");
        btnLuuGhiChuDangKi.setkEndColor(new java.awt.Color(153, 153, 255));
        btnLuuGhiChuDangKi.setkStartColor(new java.awt.Color(104, 109, 224));
        btnLuuGhiChuDangKi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuGhiChuDangKiActionPerformed(evt);
            }
        });

        btnThanhToan1.setText("Xuất ra File PDF");
        btnThanhToan1.setkEndColor(new java.awt.Color(153, 153, 255));
        btnThanhToan1.setkStartColor(new java.awt.Color(104, 109, 224));
        btnThanhToan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToan1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(btnLuuGhiChuDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnHuyDangKi, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(btnThanhToan1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThanhToan1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(btnLuuGhiChuDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbLinkHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbHinhAnhKhachQLDK, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addGap(54, 54, 54)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHinhAnhKhachQLDK, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLinkHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemDangKiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemDangKiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemDangKiActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int row=tblPDK.getSelectedRow();
        dkdv.thanhToan(false);
        tblPDK.getSelectionModel().setSelectionInterval(row, row);
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void tblPDKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPDKMouseClicked

    }//GEN-LAST:event_tblPDKMouseClicked

    private void btnLuuGhiChuDangKiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuGhiChuDangKiActionPerformed
        dkdv.luuGhiChuDangKi();
    }//GEN-LAST:event_btnLuuGhiChuDangKiActionPerformed

    private void txtTimKiemDangKiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemDangKiKeyReleased
        dkdv.filterPDK();
    }//GEN-LAST:event_txtTimKiemDangKiKeyReleased

    private void btnHuyDangKiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyDangKiActionPerformed
        dkdv.huyDangKi();
    }//GEN-LAST:event_btnHuyDangKiActionPerformed

    private void cbTrangThaiPDKItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTrangThaiPDKItemStateChanged
        dkdv.filterPDK();
    }//GEN-LAST:event_cbTrangThaiPDKItemStateChanged

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        txtTimKiemDangKi.setText("");
        cbTrangThaiPDK.setSelectedIndex(0);
        dkdv.getDataForTblDangKiDichVu();
        tblPDK.getSelectionModel().setSelectionInterval(0, 0);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void jPanel4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel4FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4FocusGained

    private void btnThanhToan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToan1ActionPerformed
        // TODO add your handling code here:
        int row = tblPDK.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn phiếu đăng kí ở trên");
            return;
        }
        String maPDK = (String) dtblPDK.getValueAt(row, 0);
        try {
            PhieuDangKiPDF pdk = new PhieuDangKiPDF(maPDK);
        } catch (IOException ex) {
            Logger.getLogger(FrmPDK.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmPDK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThanhToan1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.KButton btnHuyDangKi;
    private com.raven.swing.KButton btnLamMoi;
    private com.raven.swing.KButton btnLuuGhiChuDangKi;
    public com.raven.swing.KButton btnThanhToan;
    public com.raven.swing.KButton btnThanhToan1;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.raven.swing.ComboBoxSuggestion cbTrangThaiPDK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCMND;
    private javax.swing.JLabel lbDiaChi;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbGioiTinh;
    private javax.swing.JLabel lbHangKhachHang;
    private javax.swing.JLabel lbHinhAnhKhachQLDK;
    private javax.swing.JLabel lbHoTen;
    private javax.swing.JLabel lbLinkHinhAnh;
    private javax.swing.JLabel lbMaKhachHang;
    private javax.swing.JLabel lbNgaySinh;
    private javax.swing.JLabel lbSDT;
    private com.raven.swing.PanelRound panelRound1;
    private com.raven.swing.ScrollBar scrollBar1;
    public com.raven.swing.TableColumn tblPDK;
    private javax.swing.JTextArea txtGhiChuQLDK;
    private com.raven.swing.TextFieldAnimation txtTimKiemDangKi;
    // End of variables declaration//GEN-END:variables
}
