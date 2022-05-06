/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import PDF.DoThongSoPDF;
import csdl.CsdlDTS;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;
import com.raven.main.FrmMain;
import model.DungChung;
import java.text.SimpleDateFormat;
import java.util.Vector;
import com.raven.swing.ScrollBarCustom;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author anhtu
 */
public class FrmDoThongSo extends javax.swing.JDialog {

    private MigLayout layout;
    public static String maKH;
    public static String hoTen;
    private String SDT;
    public static  String gioiTinh;
    public static  String ngaySinh;
    private String imgURL;
    private Connection conn = FrmMain.conn;
    public static CsdlDTS csdlDTS = new CsdlDTS();
    public static DefaultTableModel dtblThongSo;

    public FrmDoThongSo(String maKH, String hoTen, String SDT,String gioiTinh, String ngaySinh, String imgURL) {

        super(FrmMain.f, true); //java.awt.Frame parent, boolean modal
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.SDT = SDT;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.imgURL = imgURL;
        initComponents();
        devInit();
        this.setVisible(true);
    }


    public void devInit() {

        lbMaKhachHang.setText(maKH);
        lbHoTen.setText(hoTen);
        lbSDT.setText(SDT);
        lbGioiTinh.setText(gioiTinh);
        lbNgaySinh.setText(ngaySinh);
        dtblThongSo = (DefaultTableModel) tblThongSo.getModel();
        DungChung.readImg(lbHinhAnhKhach, imgURL);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DungChung.fillTable(dtblThongSo, csdlDTS.selectAllThongSo(maKH));
        fixTable(jScrollPane1);
    }



    public void fixTable(JScrollPane scroll) {
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel p = new JPanel();
        p.setBackground(new Color(245, 245, 245));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        scroll.setBorder(new EmptyBorder(5, 10, 5, 10));
    }


    public String getRand(int max, int min) {
        return String.format("%.2f", ((Math.random()) * ((max - min) + 1)) + min);
    }

    public String getRand(double min, double max) {
        return String.format("%.2f", ((Math.random()) * ((max - min) + 1)) + min);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new com.raven.swing.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbMaKhachHang = new javax.swing.JLabel();
        lbHoTen = new javax.swing.JLabel();
        lbSDT = new javax.swing.JLabel();
        lbHinhAnhKhach = new javax.swing.JLabel();
        btnBatDauDo = new com.raven.swing.KButton();
        btnInLichSu = new com.raven.swing.KButton();
        jButton1 = new com.raven.swing.KButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbNgaySinh = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbGioiTinh = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongSo = new com.raven.swing.TableColumn();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setText("Mã khách hàng");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("Họ tên");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setText("SĐT");

        lbMaKhachHang.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbMaKhachHang.setText("jLabel4");

        lbHoTen.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbHoTen.setText("jLabel5");

        lbSDT.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbSDT.setText("jLabel6");

        lbHinhAnhKhach.setBackground(new java.awt.Color(255, 255, 255));
        lbHinhAnhKhach.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lbHinhAnhKhach.setOpaque(true);

        btnBatDauDo.setText("Giả Dữ Liệu");
        btnBatDauDo.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnBatDauDo.setkEndColor(new java.awt.Color(153, 153, 255));
        btnBatDauDo.setkHoverEndColor(new java.awt.Color(255, 51, 255));
        btnBatDauDo.setkStartColor(new java.awt.Color(104, 109, 224));
        btnBatDauDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatDauDoActionPerformed(evt);
            }
        });

        btnInLichSu.setText("Xem Ở Dạng Biểu Đồ");
        btnInLichSu.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnInLichSu.setkEndColor(new java.awt.Color(153, 153, 255));
        btnInLichSu.setkHoverEndColor(new java.awt.Color(255, 51, 255));
        btnInLichSu.setkStartColor(new java.awt.Color(104, 109, 224));
        btnInLichSu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInLichSuActionPerformed(evt);
            }
        });

        jButton1.setText("Thoát");
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
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

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Đo Thông Số");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setText("Ngày Sinh");

        lbNgaySinh.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbNgaySinh.setText("jLabel5");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setText("Giới Tính");

        lbGioiTinh.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbGioiTinh.setText("jLabel6");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel3))
                .addGap(34, 34, 34)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbMaKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(34, 34, 34)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addComponent(btnBatDauDo, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbHinhAnhKhach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(btnInLichSu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(91, 91, 91))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addComponent(jLabel21)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(lbMaKhachHang))
                                .addGap(34, 34, 34)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(lbHoTen))
                                .addGap(30, 30, 30)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(lbSDT)))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(lbNgaySinh))
                                .addGap(30, 30, 30)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(lbGioiTinh)))))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbHinhAnhKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBatDauDo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInLichSu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblThongSo.setAutoCreateRowSorter(true);
        tblThongSo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Ngày Đo", "Chiều cao (cm)", "Cân nặng (kg)", "Tỉ lệ mỡ (%)", "Khối Lượng Cơ (kg)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThongSo.setHasBtn(false);
        jScrollPane1.setViewportView(tblThongSo);
        if (tblThongSo.getColumnModel().getColumnCount() > 0) {
            tblThongSo.getColumnModel().getColumn(1).setMinWidth(150);
        }

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Lịch Sử Đo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 973, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBatDauDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatDauDoActionPerformed
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        String date = "2020-01-01";
        Vector vec;
        for (int i = 1; i <= 6; i++) {
            vec = new Vector();
            date = DungChung.dateAdd(date, 30);
            vec.add(lbMaKhachHang.getText());
            vec.add(date + " 01:00:00.0");  //ngaydo
            vec.add(getRand(165, 170));   //chieu cao
            vec.add(getRand(40, 100));  //can nang
            vec.add(getRand(25, 50));  //tilemo
            vec.add(getRand(15, 80));   //khoiluongco
            if (csdlDTS.insertThongSo(vec)) {
                dtblThongSo.addRow(vec);
            }else return;
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(FrmDoThongSo.class.getName()).log(Level.SEVERE, null, ex);
        }
        tblThongSo.repaint();


    }//GEN-LAST:event_btnBatDauDoActionPerformed

    private void btnInLichSuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInLichSuActionPerformed
        // TODO add your handling code here:
        int row = tblThongSo.getSelectedRow();
        if(row == -1)
            row = 0;
        DoThongSoPDF dts = new DoThongSoPDF(dtblThongSo.getValueAt(row, 1).toString());
    }//GEN-LAST:event_btnInLichSuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);        //f.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmDoThongSo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDoThongSo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDoThongSo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDoThongSo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                FrmDoThongSo dialog = new FrmDoThongSo(new javax.swing.JFrame(), true);
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
    private com.raven.swing.KButton btnBatDauDo;
    private com.raven.swing.KButton btnInLichSu;
    private com.raven.swing.KButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbGioiTinh;
    private javax.swing.JLabel lbHinhAnhKhach;
    private javax.swing.JLabel lbHoTen;
    private javax.swing.JLabel lbMaKhachHang;
    private javax.swing.JLabel lbNgaySinh;
    private javax.swing.JLabel lbSDT;
    private com.raven.swing.PanelRound panelRound1;
    private com.raven.swing.TableColumn tblThongSo;
    // End of variables declaration//GEN-END:variables
}
