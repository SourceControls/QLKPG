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
import model.DKDV;
import model.QLQVT;
public class Form2 extends javax.swing.JPanel {
    public static DefaultTableModel dtblPDK;
    private QLQVT qlqvt;
    private QLKH qlkh;
    private DKDV dkdv;
    public com.raven.form.FrmThanhToan frmThanhToan = null;
    public Form2() {
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
                if (row >= 0 && (col == 8 || col==9) ) {
                    System.out.println(row+" "+ col);

                }
            }   
        });
        tblPDK.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                dkdv.dumpDataFromTblPDKToFields();
            }
        });
    }
    public void showData(){
        frmThanhToan = new com.raven.form.FrmThanhToan();
        dtblPDK = (DefaultTableModel) tblPDK.getModel();
        dkdv = new DKDV(tblPDK, lbHinhAnhKhachQLDK, lbMaKhachHang, lbHoTen ,lbCMND, lbGioiTinh, lbNgaySinh, lbEmail, lbSDT,
            lbDiaChi, lbHangKhachHang, txtGhiChuQLDK, txtTimKiemDangKi, lbLinkHinhAnh,cbTrangThaiPDK);
        dkdv.getDataForTblDangKiDichVu();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGhiChuQLDK = new javax.swing.JTextArea();
        btnLuuGhiChuDangKi = new com.raven.swing.KButton();
        btnThanhToan = new com.raven.swing.KButton();
        btnHuyDangKi = new com.raven.swing.KButton();
        lbLinkHinhAnh = new javax.swing.JLabel();
        scrollBar1 = new com.raven.swing.ScrollBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPDK = new com.raven.swing.TableColumn();
        jLabel11 = new javax.swing.JLabel();
        cbTrangThaiPDK = new com.raven.swing.ComboBoxSuggestion();
        txtTimKiemDangKi = new com.raven.swing.TextFieldAnimation();

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
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbMaKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                    .addComponent(lbSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbCMND, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(27, 27, 27)
                                .addComponent(lbGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbHangKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(lbHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addGap(315, 315, 315)))
        );
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
                    .addComponent(lbEmail))
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
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(68, 68, 68)
                    .addComponent(lbHoTen)
                    .addContainerGap(280, Short.MAX_VALUE)))
        );

        lbHinhAnhKhachQLDK.setBackground(new java.awt.Color(255, 255, 255));
        lbHinhAnhKhachQLDK.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lbHinhAnhKhachQLDK.setOpaque(true);

        txtGhiChuQLDK.setColumns(20);
        txtGhiChuQLDK.setRows(5);
        jScrollPane2.setViewportView(txtGhiChuQLDK);

        btnLuuGhiChuDangKi.setText("Lưu");
        btnLuuGhiChuDangKi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuGhiChuDangKiActionPerformed(evt);
            }
        });

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnHuyDangKi.setText("Hủy đăng kí");
        btnHuyDangKi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyDangKiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbLinkHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbHinhAnhKhachQLDK, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addGap(60, 60, 60)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLuuGhiChuDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuyDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbHinhAnhKhachQLDK, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound1Layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnLuuGhiChuDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnHuyDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLinkHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 11, Short.MAX_VALUE))
        );

        scrollBar1.setBackground(new java.awt.Color(245, 245, 245));

        jScrollPane1.setBackground(new java.awt.Color(245, 245, 245));
        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBar(scrollBar1);

        tblPDK.setBackground(new java.awt.Color(255, 255, 255));
        tblPDK.setForeground(new java.awt.Color(255, 255, 255));
        tblPDK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã PĐK", "Mã KH", "Họ tên", "SĐT", "Dịch vụ", "Ngày đăng kí", "Ngày bắt đầu", "Ngày kết thúc", "Thuế", "Tổng tiền", "Trạng thái"
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

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8_filter_20px_1.png"))); // NOI18N

        cbTrangThaiPDK.setEditable(false);
        cbTrangThaiPDK.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "CHỜ KÍCH HOẠT", "ĐÃ KÍCH HOẠT", "SẮP HẾT HẠN", "HẾT HẠN", "SẮP TỚI HẠN NỘP TIỀN", "ĐÃ HỦY" }));
        cbTrangThaiPDK.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTrangThaiPDKItemStateChanged(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTimKiemDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbTrangThaiPDK, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 188, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimKiemDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbTrangThaiPDK, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(scrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemDangKiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemDangKiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemDangKiActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        dkdv.thanhToan(frmThanhToan);
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void tblPDKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPDKMouseClicked
        
    }//GEN-LAST:event_tblPDKMouseClicked

    private void btnLuuGhiChuDangKiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuGhiChuDangKiActionPerformed
       dkdv.luuGhiChuDangKi();
    }//GEN-LAST:event_btnLuuGhiChuDangKiActionPerformed

    private void txtTimKiemDangKiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemDangKiKeyReleased
        dkdv.txtTimKiemDangKiKeyReleased();
        cbTrangThaiPDK.setSelectedIndex(0);
    }//GEN-LAST:event_txtTimKiemDangKiKeyReleased

    private void btnHuyDangKiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyDangKiActionPerformed
        dkdv.huyDangKi();
    }//GEN-LAST:event_btnHuyDangKiActionPerformed

    private void cbTrangThaiPDKItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTrangThaiPDKItemStateChanged
        dkdv.filterPDK();
    }//GEN-LAST:event_cbTrangThaiPDKItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.KButton btnHuyDangKi;
    private com.raven.swing.KButton btnLuuGhiChuDangKi;
    private com.raven.swing.KButton btnThanhToan;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.raven.swing.ComboBoxSuggestion cbTrangThaiPDK;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
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
    private com.raven.swing.TableColumn tblPDK;
    private javax.swing.JTextArea txtGhiChuQLDK;
    private com.raven.swing.TextFieldAnimation txtTimKiemDangKi;
    // End of variables declaration//GEN-END:variables
}
