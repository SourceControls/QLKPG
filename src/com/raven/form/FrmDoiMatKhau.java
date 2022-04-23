/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;
import csdl.csdlDoiMatKhau;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author anhtu
 */
public class FrmDoiMatKhau extends javax.swing.JPanel {
    public static csdlDoiMatKhau dmk = new csdlDoiMatKhau();
    /**
     * Creates new form FrmDoiMatKhau
     */
    public FrmDoiMatKhau() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtMatKhauCu = new com.raven.swing.PasswordField();
        txtMatKhauMoi = new com.raven.swing.PasswordField();
        txtNhapLaiMatKhauMoi = new com.raven.swing.PasswordField();
        btnLuu = new com.raven.swing.KButton();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 245, 245));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMatKhauCu.setLabelText("Mật Khẩu Cũ");
        txtMatKhauCu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatKhauCuActionPerformed(evt);
            }
        });
        jPanel1.add(txtMatKhauCu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 94, 330, -1));

        txtMatKhauMoi.setLabelText("Mật Khẩu Mới");
        txtMatKhauMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatKhauMoiActionPerformed(evt);
            }
        });
        jPanel1.add(txtMatKhauMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 169, 330, -1));

        txtNhapLaiMatKhauMoi.setLabelText("Nhập Lại Mật Khẩu Mới");
        txtNhapLaiMatKhauMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNhapLaiMatKhauMoiActionPerformed(evt);
            }
        });
        jPanel1.add(txtNhapLaiMatKhauMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 244, 330, -1));

        btnLuu.setText("Lưu");
        btnLuu.setkEndColor(new java.awt.Color(153, 153, 255));
        btnLuu.setkStartColor(new java.awt.Color(104, 109, 224));
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });
        jPanel1.add(btnLuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 97, 36));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Đổi Mật Khẩu");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 31, -1, 26));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 350, 410));
    }// </editor-fold>//GEN-END:initComponents

    private void txtMatKhauCuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatKhauCuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatKhauCuActionPerformed

    private void txtMatKhauMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatKhauMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatKhauMoiActionPerformed

    private void txtNhapLaiMatKhauMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNhapLaiMatKhauMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNhapLaiMatKhauMoiActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        String matKhauCu = new String(txtMatKhauCu.getPassword());
        String matKhauMoi = new String(txtMatKhauMoi.getPassword());
        String nhapLaiMK = new String(txtNhapLaiMatKhauMoi.getPassword());
        System.out.println(matKhauMoi + " " + nhapLaiMK);
        if(!matKhauMoi.equals(nhapLaiMK)){
            JOptionPane.showMessageDialog(this, "Mật khẩu mới không khớp");
            return;
        }
        try {
            dmk.doiMatKhau(matKhauCu, matKhauMoi);
            JOptionPane.showMessageDialog(this, "Đổi Mật Khẩu Thành Công");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Đổi Mật Khẩu Thất Bại\n" + ex.getMessage());
            return;
        }

    }//GEN-LAST:event_btnLuuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.KButton btnLuu;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private com.raven.swing.PasswordField txtMatKhauCu;
    private com.raven.swing.PasswordField txtMatKhauMoi;
    private com.raven.swing.PasswordField txtNhapLaiMatKhauMoi;
    // End of variables declaration//GEN-END:variables
}
