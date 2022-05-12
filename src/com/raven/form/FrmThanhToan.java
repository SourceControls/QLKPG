/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import PDF.PhieuThuTienPDF;
import csdl.CsdlTT;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import com.raven.main.FrmMain;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.DungChung;
import model.QLKH;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import model.DKDV;

/**
 *
 * @author anhtu
 */
public class FrmThanhToan extends javax.swing.JDialog {

    private Connection conn = FrmMain.conn;
    private String maPDK = "";
    public String maKH = "";
    private String trangThaiPDK = "";

    public static CsdlTT csdlTT = new CsdlTT();
    private DefaultTableModel dtblPTT;

    int soThangConNo;
    int soTienThanhToanToiThieu;

    /**
     * Creates new form FrmThanhToan1
     */
    public FrmThanhToan(String maPDK, String maKH, String trangThaiPDK) {

        super(FrmMain.f, true);

        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.maPDK = maPDK;
        this.maKH = maKH;
        this.trangThaiPDK = trangThaiPDK;
        devInit();
        this.setVisible(true);
    }

    public void devInit() {

        dtblPTT = (DefaultTableModel) tblLichSuThanhToan.getModel();
        this.setLocationRelativeTo(com.raven.main.FrmMain.f);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        txtNgayThu.setText((formatter.format(new Date())));

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        if (FrmMain.modelNV.isQuanli()) {
            TableColumn col = new TableColumn(dtblPTT.getColumnCount());
            col.setHeaderValue("Người Lập");
            tblLichSuThanhToan.addColumn(col);
            dtblPTT.addColumn("Người Lập");
        }
        DungChung.fillTable(dtblPTT, csdlTT.selectAllPTT(maPDK));
        showThongTinKhach();
        getThongTinThanhToan();
    }

    public void showThongTinKhach() {
        try {
            ResultSet rs = QLKH.csdlQLKH.selectKhachHang(null, maKH);
            if (rs.next()) {
                lbMaKhachHang.setText(rs.getString(1));
            }
            lbHoTen.setText(rs.getString(2));
            lbSDT.setText(rs.getString(3));
        } catch (SQLException ex) {

        }
    }

    public void getThongTinThanhToan() {
        ResultSet rs = csdlTT.selectThongTinTraGop(maPDK);
        txtGhiChu.setText("");
        txtHanLanToi.setText("");
        txtTienConNo.setText("");
        txtTienKhachPhaiTra.setText("");
        txtGhiChu.setText("");
        cbSoThang.removeAllItems();
        try {
            rs.next();
            soThangConNo = rs.getInt(1);
            soTienThanhToanToiThieu = rs.getInt(2);
            for (int i = 1; i <= soThangConNo; i++) {
                cbSoThang.addItem(String.valueOf(i));
            }
        } catch (SQLException ex) {
        }
        if (soThangConNo == 0) {
            JOptionPane.showMessageDialog(this, "Khách Đã Thanh Toán Xong");
            txtGhiChu.setEditable(false);
            btnThanhToan.setEnabled(false);
            return;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new com.raven.swing.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLichSuThanhToan = new com.raven.swing.TableColumn();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtHanLanToi = new com.raven.swing.TextFieldRound();
        lbTienConNo = new javax.swing.JLabel();
        txtTienKhachPhaiTra = new com.raven.swing.TextFieldRound();
        txtTienConNo = new com.raven.swing.TextFieldRound();
        jLabel7 = new javax.swing.JLabel();
        txtNgayThu = new com.raven.swing.TextFieldRound();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbHoTen = new javax.swing.JLabel();
        lbMaKhachHang = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        lbSDT = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jButton1 = new com.raven.swing.KButton();
        btnThanhToan = new com.raven.swing.KButton();
        cbSoThang = new com.raven.swing.ComboBoxSuggestion();
        jLabel8 = new javax.swing.JLabel();
        btnThanhToan1 = new com.raven.swing.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(245, 245, 245));
        jScrollPane1.setBorder(null);

        tblLichSuThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        tblLichSuThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        tblLichSuThanhToan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã PTT", "Ngày thu", "Tiền khách trả", "Còn nợ", "Hạn lần tới", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLichSuThanhToan.setEndColorBtnFix(new java.awt.Color(255, 0, 38));
        tblLichSuThanhToan.setHasBtn(false);
        tblLichSuThanhToan.setStartColorBtnFix(new java.awt.Color(255, 180, 48));
        tblLichSuThanhToan.setStartColorBtnSignUp(new java.awt.Color(0, 243, 92));
        tblLichSuThanhToan.setTextBTN1("");
        tblLichSuThanhToan.setTextBTN2("");
        tblLichSuThanhToan.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tblLichSuThanhToanMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tblLichSuThanhToanMouseMoved(evt);
            }
        });
        tblLichSuThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLichSuThanhToanMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblLichSuThanhToanMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblLichSuThanhToan);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lịch Sử Thanh Toán ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Thanh Toán");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Số tiền cần trả");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Hạn Lần Tới");

        txtHanLanToi.setEditable(false);

        lbTienConNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTienConNo.setText("Tiền Còn Nợ");

        txtTienKhachPhaiTra.setEditable(false);

        txtTienConNo.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Ghi Chú");

        txtNgayThu.setEditable(false);

        txtGhiChu.setColumns(20);
        txtGhiChu.setLineWrap(true);
        txtGhiChu.setRows(5);
        jScrollPane2.setViewportView(txtGhiChu);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Ngày Thu");

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel16.setText("Mã KH:");

        lbHoTen.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbHoTen.setText("NULL");

        lbMaKhachHang.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbMaKhachHang.setText("NULL");

        jLabel33.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel33.setText("Họ Tên:");

        lbSDT.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbSDT.setText("NULL");

        jLabel34.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel34.setText("SĐT:");

        jButton1.setText("Thoát");
        jButton1.setkEndColor(new java.awt.Color(255, 51, 255));
        jButton1.setkHoverEndColor(new java.awt.Color(153, 153, 255));
        jButton1.setkHoverForeGround(new java.awt.Color(255, 0, 255));
        jButton1.setkHoverStartColor(new java.awt.Color(104, 109, 224));
        jButton1.setkStartColor(new java.awt.Color(224, 86, 253));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.setkEndColor(new java.awt.Color(153, 153, 255));
        btnThanhToan.setkStartColor(new java.awt.Color(104, 109, 224));
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        cbSoThang.setEditable(false);
        cbSoThang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSoThangItemStateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Số tháng");

        btnThanhToan1.setText("In Phiếu Thanh Toán");
        btnThanhToan1.setkEndColor(new java.awt.Color(153, 153, 255));
        btnThanhToan1.setkStartColor(new java.awt.Color(104, 109, 224));
        btnThanhToan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToan1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(15, 15, 15)
                        .addComponent(lbHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(lbMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(lbSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(86, 86, 86)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(lbTienConNo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTienKhachPhaiTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTienConNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8)
                            .addComponent(cbSoThang, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(132, 132, 132))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNgayThu, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHanLanToi, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnThanhToan1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(131, 131, 131))))
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(lbMaKhachHang)
                            .addComponent(cbSoThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel33)
                            .addComponent(lbHoTen))
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel34)
                                    .addComponent(lbSDT)))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTienKhachPhaiTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTienConNo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTienConNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHanLanToi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgayThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThanhToan1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 898, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblLichSuThanhToanMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLichSuThanhToanMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_tblLichSuThanhToanMouseDragged

    private void tblLichSuThanhToanMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLichSuThanhToanMouseMoved

    }//GEN-LAST:event_tblLichSuThanhToanMouseMoved

    private void tblLichSuThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLichSuThanhToanMouseClicked

    }//GEN-LAST:event_tblLichSuThanhToanMouseClicked

    private void tblLichSuThanhToanMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLichSuThanhToanMouseReleased

    }//GEN-LAST:event_tblLichSuThanhToanMouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        if (trangThaiPDK.toUpperCase().trim().equals("ĐÃ HỦY")) {
            JOptionPane.showMessageDialog(this, "Phiếu Đăng Kí Đã Hủy Không Thể Thanh Toán");
            return;
        }
        if (trangThaiPDK.toUpperCase().trim().equals("HẾT HẠN")) {
            JOptionPane.showMessageDialog(this, "Phiếu Đăng Kí Đã Hết Hạn Không Thể Thanh Toán");
            return;
        }

        Vector vec = new Vector();
        vec.add(csdlTT.getMaPTT());
        vec.add(txtNgayThu.getText());
        vec.add(txtTienKhachPhaiTra.getText());
        vec.add(txtTienConNo.getText());
        vec.add(txtHanLanToi.getText());
        vec.add(txtGhiChu.getText());
        vec.add(maPDK);
        vec.add(com.raven.main.FrmMain.modelNV.getManv());
        if (csdlTT.insertPTT(vec)) {
            JOptionPane.showMessageDialog(this, "Thanh Toán thành công !");
            getThongTinThanhToan();
            DungChung.fillTable(com.raven.form.FrmPDK.dtblPDK, DKDV.csdlDKDV.selectAllPDK());
            DungChung.fillTable(dtblPTT, csdlTT.selectAllPTT(maPDK));
        }

    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void cbSoThangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSoThangItemStateChanged

        if (soThangConNo == 0 || cbSoThang.getItemCount() == 0) {
            return;
        }

        int soThangKhachTra = Integer.parseInt(cbSoThang.getSelectedItem().toString());
        double tienPhaiTra = soThangKhachTra * soTienThanhToanToiThieu;
        txtTienKhachPhaiTra.setText(String.valueOf(tienPhaiTra));
        if (soThangKhachTra == soThangConNo) {
            txtTienConNo.setText("");
            txtHanLanToi.setText("");
        } else {

            String hanLanToi = txtNgayThu.getText();
            if (dtblPTT.getRowCount() > 0) {
                hanLanToi = dtblPTT.getValueAt(dtblPTT.getRowCount() - 1, 4).toString();
            }
            if (hanLanToi.isEmpty()) {
                return;
            }
            hanLanToi = DungChung.dateAdd(hanLanToi, soThangKhachTra * FrmMain.DAY_PER_MONTH);
            txtHanLanToi.setText(hanLanToi);
            double tienConNo = soTienThanhToanToiThieu * soThangConNo - tienPhaiTra;
            txtTienConNo.setText(String.valueOf(tienConNo));
        }
    }//GEN-LAST:event_cbSoThangItemStateChanged

    private void btnThanhToan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToan1ActionPerformed
        try {
            // TODO add your handling code here:
            int row = tblLichSuThanhToan.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Chọn phiếu thanh toán để in");
                return;
            }
            String maPTT = (String) dtblPTT.getValueAt(row, 0);
            PhieuThuTienPDF pdf = new PhieuThuTienPDF(maPTT);
        } catch (IOException ex) {
            Logger.getLogger(FrmThanhToan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmThanhToan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThanhToan1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                oldFrmThanhToan dialog = new oldFrmThanhToan(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.KButton btnThanhToan;
    private com.raven.swing.KButton btnThanhToan1;
    private com.raven.swing.ComboBoxSuggestion cbSoThang;
    private com.raven.swing.KButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbHoTen;
    private javax.swing.JLabel lbMaKhachHang;
    private javax.swing.JLabel lbSDT;
    private javax.swing.JLabel lbTienConNo;
    private com.raven.swing.PanelRound panelRound1;
    private com.raven.swing.TableColumn tblLichSuThanhToan;
    private javax.swing.JTextArea txtGhiChu;
    private com.raven.swing.TextFieldRound txtHanLanToi;
    private com.raven.swing.TextFieldRound txtNgayThu;
    private com.raven.swing.TextFieldRound txtTienConNo;
    private com.raven.swing.TextFieldRound txtTienKhachPhaiTra;
    // End of variables declaration//GEN-END:variables
}
