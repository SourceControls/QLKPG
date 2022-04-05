package com.raven.form;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import com.raven.*;
import java.awt.Cursor;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.QLKH;
import model.QLQVT;


public class Form3 extends javax.swing.JPanel {
    public static DefaultTableModel dtblLSQVT;
    private QLQVT qlqvt;
    public Form3() {
        initComponents();
        setOpaque(false);
        init();
        
    }

    private void init() {
        tblLSQVT.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                qlqvt.getDataForLabelThongTinKhachHang();
            }
        });
        
      
        
    }
    public void showData() {
        dtblLSQVT = (DefaultTableModel) tblLSQVT.getModel();
        qlqvt = new QLQVT(lbCMNDQLQVT, lbDiaChiQLQVT, lbEmailQLQVT, lbGioiTinhQLQVT, lbHangKhachHangQLQVT, lbHoTenQLQVT,
                lbMaKhachHangQLQVT, lbNgaySinhQLQVT, lbSDTQLQVT, lbHinhAnhKhachQLQVT, lbDichVuQLQVT, lbNgayBatDauQLQVT,
                lbNgayDangKiQLQVT, lbNgayKetThucQLQVT, btnGiaLapVaoRa, tblLSQVT, btnLocQLQVT, txtTuNgay, txtDenNgay);
        qlqvt.getDataForTblLichSuQuetVanTay();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        dateChooserTuNgay = new com.raven.datechooser.DateChooser();
        dateChooserDenNgay = new com.raven.datechooser.DateChooser();
        panelRound1 = new com.raven.swing.PanelRound();
        jPanel13 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        lbHinhAnhKhachQLQVT = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        lbDiaChiQLQVT = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        lbCMNDQLQVT = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        lbHangKhachHangQLQVT = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLSQVT = new com.raven.swing.TableColumn();
        lbGioiTinhQLQVT = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbEmailQLQVT = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbSDTQLQVT = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbNgaySinhQLQVT = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        lbHoTenQLQVT = new javax.swing.JLabel();
        lbMaKhachHangQLQVT = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        scrollBar1 = new com.raven.swing.ScrollBar();
        jLabel17 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btnLocQLQVT = new com.raven.swing.KButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbDichVuQLQVT = new javax.swing.JLabel();
        jlabelx = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        btnGiaLapVaoRa = new com.raven.swing.KButton();
        lbNgayBatDauQLQVT = new javax.swing.JLabel();
        lbNgayDangKiQLQVT = new javax.swing.JLabel();
        lbNgayKetThucQLQVT = new javax.swing.JLabel();
        txtDenNgay = new com.raven.swing.TextFieldRound();
        txtTuNgay = new com.raven.swing.TextFieldRound();

        dateChooserTuNgay.setForeground(new java.awt.Color(102, 102, 255));
        dateChooserTuNgay.setTextRefernce(txtTuNgay);

        dateChooserDenNgay.setForeground(new java.awt.Color(102, 102, 255));
        dateChooserDenNgay.setTextRefernce(txtDenNgay);

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel47.setText("Hình Ảnh");

        lbHinhAnhKhachQLQVT.setBackground(new java.awt.Color(255, 255, 255));
        lbHinhAnhKhachQLQVT.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lbHinhAnhKhachQLQVT.setOpaque(true);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbHinhAnhKhachQLQVT, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel47)
                .addGap(18, 18, 18)
                .addComponent(lbHinhAnhKhachQLQVT, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Địa chỉ:");

        lbDiaChiQLQVT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbDiaChiQLQVT.setText("NULL");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setText("CMND:");

        lbCMNDQLQVT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbCMNDQLQVT.setText("NULL");

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setText("Ngày Sinh");

        lbHangKhachHangQLQVT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbHangKhachHangQLQVT.setText("NULL");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Thông Tin Khách Hàng");

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setText("SĐT:");

        jScrollPane1.setBackground(new java.awt.Color(245, 245, 245));
        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBar(scrollBar1);

        tblLSQVT.setBackground(new java.awt.Color(255, 255, 255));
        tblLSQVT.setForeground(new java.awt.Color(255, 255, 255));
        tblLSQVT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Ngày giờ", "Họ tên", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLSQVT.setHasBtn(false);
        tblLSQVT.setTextBTN1("Thanh toán");
        tblLSQVT.setTextBTN2("Hủy đk");
        tblLSQVT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLSQVTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLSQVT);
        if (tblLSQVT.getColumnModel().getColumnCount() > 0) {
            tblLSQVT.getColumnModel().getColumn(0).setMinWidth(55);
            tblLSQVT.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblLSQVT.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        lbGioiTinhQLQVT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbGioiTinhQLQVT.setText("NULL");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Email:");

        lbEmailQLQVT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbEmailQLQVT.setText("NULL");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Giới Tính:");

        lbSDTQLQVT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbSDTQLQVT.setText("NULL");
        lbSDTQLQVT.setPreferredSize(new java.awt.Dimension(100, 17));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Mã KH:");

        lbNgaySinhQLQVT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNgaySinhQLQVT.setText("NULL");

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel41.setText("Họ Tên:");

        lbHoTenQLQVT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbHoTenQLQVT.setText("NULL");
        lbHoTenQLQVT.setPreferredSize(new java.awt.Dimension(100, 17));

        lbMaKhachHangQLQVT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbMaKhachHangQLQVT.setText("NULL");
        lbMaKhachHangQLQVT.setPreferredSize(new java.awt.Dimension(100, 17));

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setText("Hạng Khách Hàng:");

        scrollBar1.setBackground(new java.awt.Color(245, 245, 245));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Lịch Sử Quẹt Vân Tay");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Từ ngày:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Đến ngày:");

        btnLocQLQVT.setText("Lọc");
        btnLocQLQVT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocQLQVTActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Ngày Đăng Kí:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Ngày Bắt Đầu:");

        lbDichVuQLQVT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbDichVuQLQVT.setText("NULL");

        jlabelx.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlabelx.setText("Ngày Kết Thúc:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Thông Tin Dịch Vụ Khách Đăng Kí");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Dịch Vụ:");

        btnGiaLapVaoRa.setText("Giả lập vào ra");
        btnGiaLapVaoRa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaLapVaoRaActionPerformed(evt);
            }
        });

        lbNgayBatDauQLQVT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNgayBatDauQLQVT.setText("NULL");

        lbNgayDangKiQLQVT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNgayDangKiQLQVT.setText("NULL");

        lbNgayKetThucQLQVT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNgayKetThucQLQVT.setText("NULL");

        txtDenNgay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDenNgayMousePressed(evt);
            }
        });
        txtDenNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDenNgayActionPerformed(evt);
            }
        });

        txtTuNgay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTuNgayMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTuNgayMousePressed(evt);
            }
        });
        txtTuNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTuNgayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound1Layout.createSequentialGroup()
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbDiaChiQLQVT, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel26)
                                    .addGroup(panelRound1Layout.createSequentialGroup()
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbDichVuQLQVT, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel24)
                                            .addComponent(jLabel25)
                                            .addComponent(jlabelx))))
                                .addGap(18, 18, 18)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNgayBatDauQLQVT, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbNgayKetThucQLQVT, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbNgayDangKiQLQVT, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addComponent(btnGiaLapVaoRa, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbHangKhachHangQLQVT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbEmailQLQVT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbGioiTinhQLQVT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbNgaySinhQLQVT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbSDTQLQVT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                    .addComponent(lbHoTenQLQVT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbMaKhachHangQLQVT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbCMNDQLQVT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLocQLQVT, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelRound1Layout.createSequentialGroup()
                                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(panelRound1Layout.createSequentialGroup()
                                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel18)
                                                    .addComponent(lbMaKhachHangQLQVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel41)
                                                    .addComponent(lbHoTenQLQVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel42)
                                                    .addComponent(lbSDTQLQVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel43))
                                            .addComponent(lbNgaySinhQLQVT))
                                        .addGap(18, 18, 18)
                                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel19)
                                            .addComponent(lbGioiTinhQLQVT))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel20))
                                    .addComponent(lbEmailQLQVT, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel44)
                                    .addComponent(lbCMNDQLQVT))
                                .addGap(21, 21, 21)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbHangKhachHangQLQVT)
                                    .addComponent(jLabel46)))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(lbDiaChiQLQVT))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel26)
                        .addGap(30, 30, 30)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel27)
                            .addComponent(lbDichVuQLQVT)
                            .addComponent(lbNgayDangKiQLQVT))
                        .addGap(21, 21, 21)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(lbNgayBatDauQLQVT))
                        .addGap(26, 26, 26)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlabelx)
                            .addComponent(lbNgayKetThucQLQVT))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDenNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLocQLQVT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(scrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGiaLapVaoRa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblLSQVTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLSQVTMouseClicked
        
    }//GEN-LAST:event_tblLSQVTMouseClicked

    private void btnGiaLapVaoRaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaLapVaoRaActionPerformed
        qlqvt.giaLapVaoRa();
    }//GEN-LAST:event_btnGiaLapVaoRaActionPerformed

    private void btnLocQLQVTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocQLQVTActionPerformed
        qlqvt.locLichSuQuetVanTay();
    }//GEN-LAST:event_btnLocQLQVTActionPerformed

    private void txtTuNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTuNgayActionPerformed
       
    }//GEN-LAST:event_txtTuNgayActionPerformed

    private void txtDenNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDenNgayActionPerformed
        
    }//GEN-LAST:event_txtDenNgayActionPerformed

    private void txtTuNgayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTuNgayMouseClicked
         
    }//GEN-LAST:event_txtTuNgayMouseClicked

    private void txtTuNgayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTuNgayMousePressed
        dateChooserTuNgay.showPopup();
    }//GEN-LAST:event_txtTuNgayMousePressed

    private void txtDenNgayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDenNgayMousePressed
        dateChooserDenNgay.showPopup();
    }//GEN-LAST:event_txtDenNgayMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.KButton btnGiaLapVaoRa;
    private com.raven.swing.KButton btnLocQLQVT;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.raven.datechooser.DateChooser dateChooserDenNgay;
    private com.raven.datechooser.DateChooser dateChooserTuNgay;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabelx;
    private javax.swing.JLabel lbCMNDQLQVT;
    private javax.swing.JLabel lbDiaChiQLQVT;
    private javax.swing.JLabel lbDichVuQLQVT;
    private javax.swing.JLabel lbEmailQLQVT;
    private javax.swing.JLabel lbGioiTinhQLQVT;
    private javax.swing.JLabel lbHangKhachHangQLQVT;
    private javax.swing.JLabel lbHinhAnhKhachQLQVT;
    private javax.swing.JLabel lbHoTenQLQVT;
    private javax.swing.JLabel lbMaKhachHangQLQVT;
    private javax.swing.JLabel lbNgayBatDauQLQVT;
    private javax.swing.JLabel lbNgayDangKiQLQVT;
    private javax.swing.JLabel lbNgayKetThucQLQVT;
    private javax.swing.JLabel lbNgaySinhQLQVT;
    private javax.swing.JLabel lbSDTQLQVT;
    private com.raven.swing.PanelRound panelRound1;
    private com.raven.swing.ScrollBar scrollBar1;
    private com.raven.swing.TableColumn tblLSQVT;
    private com.raven.swing.TextFieldRound txtDenNgay;
    private com.raven.swing.TextFieldRound txtTuNgay;
    // End of variables declaration//GEN-END:variables
}
