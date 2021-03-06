/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import com.raven.main.FrmMain;
import csdl.CsdlDoiMatKhau;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.CheckInput;

/**
 *
 * @author anhtu
 */
public class FrmDoiMatKhau extends javax.swing.JPanel {

    public static CsdlDoiMatKhau dmk = new CsdlDoiMatKhau();

    /**
     * Creates new form FrmDoiMatKhau
     */
    public FrmDoiMatKhau() {
        initComponents();
        txtMatKhauCu.setDocument(new CheckInput(20, true, true, true));
        txtMatKhauMoi.setDocument(new CheckInput(20, true, true, true));
        txtNhapLaiMatKhauMoi.setDocument(new CheckInput(20, true, true, true));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtMatKhauCu = new com.raven.swing.PasswordField();
        txtMatKhauMoi = new com.raven.swing.PasswordField();
        txtNhapLaiMatKhauMoi = new com.raven.swing.PasswordField();
        btnLuu = new com.raven.swing.KButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));
        add(jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtMatKhauCu.setLabelText("Mật Khẩu Cũ");
        txtMatKhauCu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatKhauCuActionPerformed(evt);
            }
        });

        txtMatKhauMoi.setLabelText("Mật Khẩu Mới");
        txtMatKhauMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatKhauMoiActionPerformed(evt);
            }
        });

        txtNhapLaiMatKhauMoi.setLabelText("Nhập Lại Mật Khẩu Mới");
        txtNhapLaiMatKhauMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNhapLaiMatKhauMoiActionPerformed(evt);
            }
        });

        btnLuu.setText("Lưu");
        btnLuu.setkEndColor(new java.awt.Color(153, 153, 255));
        btnLuu.setkStartColor(new java.awt.Color(104, 109, 224));
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Đổi Mật Khẩu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtMatKhauCu, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtNhapLaiMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(txtMatKhauCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(txtNhapLaiMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel1);
        add(jPanel3);
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
        
        txtMatKhauCu.setHelperText("");
        txtMatKhauCu.repaint();
        txtMatKhauMoi.setHelperText("");
        txtNhapLaiMatKhauMoi.setHelperText("");
        
        
        if (matKhauCu.isEmpty() | matKhauMoi.isEmpty() | nhapLaiMK.isEmpty()) {
            if(matKhauMoi.isEmpty()) txtMatKhauMoi.setHelperText("Nhập mật khẩu mới");
            if(nhapLaiMK.isEmpty()) txtNhapLaiMatKhauMoi.setHelperText("Nhập lại mật khẩu mới");
            if(matKhauCu.isEmpty()) txtMatKhauCu.setHelperText("Nhập mật khẩu cũ");
            return;
        }
        if(!matKhauCu.equals(FrmMain.getModelNV().getPassword()))  {
            txtMatKhauCu.setHelperText("Mật khẩu cũ không đúng");
            return;
        }
//        if(matKhauMoi.length() <= 6 | matKhauMoi.length() >=20){
//                JOptionPane.showMessageDialog(this, "Mật Khẩu Có Độ Dài Từ 6 đến 20 kí tự");
//            return;        
//        }
        if (matKhauMoi.contains(" ")) {
            txtMatKhauMoi.setHelperText("Mật khẩu không chứa kí tự khoảng trắng");
            return;
        }else txtMatKhauMoi.setHelperText("");
        if (!matKhauMoi.equals(nhapLaiMK)) {
            txtNhapLaiMatKhauMoi.setHelperText("Mật khẩu nhập lại không khớp");
            return;
        }else txtNhapLaiMatKhauMoi.setHelperText("");
        
        int result = JOptionPane.showConfirmDialog(this,"Xác Nhận Đổi Mật Khẩu?", "Thông báo",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION){
            try {
            dmk.doiMatKhau(matKhauCu, matKhauMoi);
            txtMatKhauCu.setText("");
            txtMatKhauMoi.setText("");
            txtNhapLaiMatKhauMoi.setText("");
            JOptionPane.showMessageDialog(this, "Đổi Mật Khẩu Thành Công");
            FrmMain.getModelNV().setPassword(matKhauMoi);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Đổi Mật Khẩu Thất Bại\n" + ex.getMessage());
                return;
            }
        };
        

    }//GEN-LAST:event_btnLuuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.KButton btnLuu;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private com.raven.swing.PasswordField txtMatKhauCu;
    private com.raven.swing.PasswordField txtMatKhauMoi;
    private com.raven.swing.PasswordField txtNhapLaiMatKhauMoi;
    // End of variables declaration//GEN-END:variables
}
