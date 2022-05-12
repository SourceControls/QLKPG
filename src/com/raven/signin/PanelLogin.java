package com.raven.signin;

import java.awt.event.ActionListener;

public class PanelLogin extends javax.swing.JPanel {

    public PanelLogin() {
        initComponents();
        setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUser = new com.raven.swing.TextField();
        jLabel1 = new javax.swing.JLabel();
        txtPass = new com.raven.swing.PasswordField();
        cmd = new com.raven.swing.Button();
        button1 = new com.raven.swing.Button();

        txtUser.setText("nv01");
        txtUser.setLabelText("Tên tài khoản");

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(79, 79, 79));
        jLabel1.setText("Đăng nhập");

        txtPass.setText("123");
        txtPass.setLabelText("Mật khẩu");

        cmd.setBackground(new java.awt.Color(104, 109, 224));
        cmd.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cmd.setForeground(new java.awt.Color(255, 255, 255));
        cmd.setText("Đăng nhập");
        cmd.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        cmd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdActionPerformed(evt);
            }
        });

        button1.setBackground(new java.awt.Color(224, 86, 253));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Thoát");
        button1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 138, Short.MAX_VALUE))
                    .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(cmd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_button1ActionPerformed

    public void addEventLogin(ActionListener event) {
        cmd.addActionListener(event);
    }

    public boolean checkUser() {
        boolean action = true;
        if (txtUser.getText().trim().equals("")) {
            txtUser.setHelperText("Nhập tài khoản");
            action = false;
        }else txtUser.setHelperText("");
        if (String.valueOf(txtPass.getPassword()).trim().equals("")) {
            txtPass.setHelperText("Nhập mật khẩu");
            action = false;
        }else txtPass.setHelperText("");
        return action;
    }

    public String getUserName() {
        return txtUser.getText().trim();
    }

    public String getPassword() {
        return String.valueOf(txtPass.getPassword()).trim();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button button1;
    private com.raven.swing.Button cmd;
    private javax.swing.JLabel jLabel1;
    private com.raven.swing.PasswordField txtPass;
    private com.raven.swing.TextField txtUser;
    // End of variables declaration//GEN-END:variables
}
