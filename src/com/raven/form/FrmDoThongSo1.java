/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import com.raven.chart.ModelChart;
import com.raven.chart.blankchart.BlankPlotChart;
import csdl.CsdlDTS;
import java.awt.BorderLayout;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;
import com.raven.main.FrmMain;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.DungChung;
import static com.raven.form.FrmDoThongSo.dtblThongSo;
import java.text.SimpleDateFormat;
import java.util.Date;
import static com.raven.form.FrmDoThongSo.dtblThongSo;
import java.util.Vector;
import static com.raven.form.FrmDoThongSo.dtblThongSo;
import com.raven.swing.ScrollBarCustom;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author anhtu
 */
public class FrmDoThongSo1 extends javax.swing.JDialog {
    private MigLayout layout;
    public String maKH;
    private String hoTen;
    private String SDT;
    private String imgURL;
    private Connection conn = FrmMain.conn;
    private static CsdlDTS csdlDTS = new CsdlDTS();
    public static DefaultTableModel dtblThongSo;
    public FrmDoThongSo1(String maKH, String hoTen, String SDT, String imgURL) {
        
        super(FrmMain.f, true); //java.awt.Frame parent, boolean modal
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.SDT = SDT;
        this.imgURL = imgURL;
        setMinYMaxY();
        initComponents();
        
        devInit();
        this.setVisible(true);
    }
    public void setMinYMaxY(){
        double minY=100;
        double maxY=0;
        ResultSet rs = csdlDTS.getBMI( maKH);
        try {
            while(rs.next()){
                if(Double.parseDouble(rs.getString(2)) < minY) minY=Double.parseDouble(rs.getString(2));
                if(Double.parseDouble(rs.getString(2)) > maxY) maxY=Double.parseDouble(rs.getString(2));
            }
            BlankPlotChart.minY=Math.floor(minY);
            BlankPlotChart.maxY=Math.ceil(maxY);
        } catch (SQLException ex) {
            Logger.getLogger(FrmDoThongSo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void devInit() {

        lbMaKhachHang.setText(maKH);
        lbHoTen.setText(hoTen);
        lbSDT.setText(SDT);
        
        dtblThongSo = (DefaultTableModel) tblThongSo.getModel();
        DungChung.readImg(lbHinhAnhKhach, imgURL);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        lineChart.addLegend("BMI", new Color(12, 84, 175), new Color(0, 108, 247));
        startLineChart();
        getDataTaBle();
        fixTable(jScrollPane1);
    }
    public void startLineChart(){
   
        ResultSet rs = csdlDTS.getBMI( maKH);
        lineChart.clear();
        try {
            while(rs.next()){
                Double chiso= Double.parseDouble(rs.getString(2));
                lineChart.addData(new ModelChart("Tháng "+rs.getString(1), new double[]{chiso}));
            }
            lineChart.start();
        } catch (SQLException ex) {
            Logger.getLogger(FrmDoThongSo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void fixTable(JScrollPane scroll){
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel p = new JPanel();
        p.setBackground(new Color(245,245,245));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER,p);
        scroll.setBorder(new EmptyBorder(5,10,5,10));
    }
    public void doLanDau() {
        txtCanNang.setText(getRand(40, 100));
        txtTiLeMo.setText(getRand(10, 50));
        txtTiLeNuoc.setText(getRand(50, 80));
        txtChieuCao.setText(getRand(140, 200));
    }

    public void doLanTiepTheo(ResultSet rs) {
        
        double ChieuCao=0;
        double canNang=0;
        double tiLeMo=0;
        double tiLeNuoc=0;
        try {
            while(rs.next()){
                ChieuCao = Double.parseDouble(rs.getString(3));
                canNang = Double.parseDouble(rs.getString(4));
                tiLeMo = Double.parseDouble(rs.getString(5));
                tiLeNuoc = Double.parseDouble(rs.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmDoThongSo.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        txtCanNang.setText(getRand(canNang - canNang * 0.02, canNang + canNang * 0.05));
        txtTiLeMo.setText(getRand(tiLeMo - tiLeMo * 0.03, tiLeMo));
        txtTiLeNuoc.setText(getRand(tiLeNuoc - tiLeNuoc * 0.02, tiLeNuoc + tiLeNuoc * 0.03));
        txtChieuCao.setText(getRand(ChieuCao - ChieuCao * 0.005, ChieuCao + ChieuCao * 0.005));
    }

    public String getRand(int max, int min) {
        return String.format("%.2f", ((Math.random()) * ((max - min) + 1)) + min);
    }

    public String getRand(double min, double max) {
        return String.format("%.2f", ((Math.random()) * ((max - min) + 1)) + min);
    }
    public void getDataTaBle(){
        dtblThongSo.setRowCount(0);
        ResultSet rs = csdlDTS.selectAllThongSo(maKH);
        try {
            while (rs.next()) {
                dtblThongSo.addRow(new Object[]{rs.getObject(2), rs.getObject(3), rs.getObject(4), rs.getObject(5), rs.getObject(6)});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    public void lamTrangText(){
        txtNgayDo.setText("");
        txtChieuCao.setText("");
        txtCanNang.setText("");
        txtTiLeMo.setText("");
        txtTiLeNuoc.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound2 = new com.raven.swing.PanelRound();
        lineChart = new com.raven.chart.LineChart();
        panelRound1 = new com.raven.swing.PanelRound();
        txtTiLeNuoc = new com.raven.swing.TextFieldRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbMaKhachHang = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbHoTen = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbSDT = new javax.swing.JLabel();
        txtChieuCao = new com.raven.swing.TextFieldRound();
        jLabel7 = new javax.swing.JLabel();
        txtTiLeMo = new com.raven.swing.TextFieldRound();
        txtNgayDo = new com.raven.swing.TextFieldRound();
        txtCanNang = new com.raven.swing.TextFieldRound();
        lbHinhAnhKhach = new javax.swing.JLabel();
        btnBatDauDo = new com.raven.swing.KButton();
        btnLuu = new com.raven.swing.KButton();
        btnInLichSu = new com.raven.swing.KButton();
        jButton1 = new com.raven.swing.KButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongSo = new com.raven.swing.TableColumn();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lineChart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lineChart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
        );

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));

        txtTiLeNuoc.setEditable(false);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setText("Mã khách hàng");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("Họ tên");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setText("Chiều cao");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setText("SĐT");

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setText("Tỉ lệ mỡ");

        lbMaKhachHang.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbMaKhachHang.setText("jLabel4");

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setText("Cân nặng");

        lbHoTen.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbHoTen.setText("jLabel5");

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel11.setText("Tỉ lệ nước");

        lbSDT.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbSDT.setText("jLabel6");

        txtChieuCao.setEditable(false);

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setText("Ngày đo");

        txtTiLeMo.setEditable(false);

        txtNgayDo.setEditable(false);

        txtCanNang.setEditable(false);

        lbHinhAnhKhach.setBackground(new java.awt.Color(255, 255, 255));
        lbHinhAnhKhach.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lbHinhAnhKhach.setOpaque(true);

        btnBatDauDo.setText("Bắt đầu đo");
        btnBatDauDo.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnBatDauDo.setkEndColor(new java.awt.Color(153, 153, 255));
        btnBatDauDo.setkStartColor(new java.awt.Color(104, 109, 224));
        btnBatDauDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatDauDoActionPerformed(evt);
            }
        });

        btnLuu.setText("Lưu");
        btnLuu.setEnabled(false);
        btnLuu.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnLuu.setkEndColor(new java.awt.Color(255, 51, 255));
        btnLuu.setkStartColor(new java.awt.Color(224, 86, 253));
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnInLichSu.setText("In lịch sử");
        btnInLichSu.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnInLichSu.setkEndColor(new java.awt.Color(153, 153, 255));
        btnInLichSu.setkStartColor(new java.awt.Color(104, 109, 224));
        btnInLichSu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInLichSuActionPerformed(evt);
            }
        });

        jButton1.setText("Hủy");
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton1.setkEndColor(new java.awt.Color(255, 51, 255));
        jButton1.setkStartColor(new java.awt.Color(224, 86, 253));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel12.setText("Đo thông số");

        tblThongSo.setAutoCreateRowSorter(true);
        tblThongSo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ngày", "Chiều cao", "Cân nặng", "Tỉ lệ mỡ", "Tỉ lệ nước"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThongSo.setHasBtn(false);
        jScrollPane1.setViewportView(tblThongSo);
        if (tblThongSo.getColumnModel().getColumnCount() > 0) {
            tblThongSo.getColumnModel().getColumn(0).setMinWidth(185);
        }

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(108, 108, 108))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound1Layout.createSequentialGroup()
                                .addComponent(txtCanNang, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTiLeNuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTiLeMo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel3))
                        .addGap(34, 34, 34)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbMaKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7)
                    .addComponent(txtChieuCao, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addComponent(txtNgayDo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)))
                .addGap(39, 39, 39)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbHinhAnhKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnInLichSu, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBatDauDo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(lbMaKhachHang))
                                .addGap(1, 1, 1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(lbHoTen))
                                .addGap(30, 30, 30)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(lbSDT))
                                .addGap(27, 27, 27)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtNgayDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(19, 19, 19)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelRound1Layout.createSequentialGroup()
                                        .addComponent(txtChieuCao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11)))
                                    .addComponent(txtTiLeMo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCanNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTiLeNuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(lbHinhAnhKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBatDauDo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnInLichSu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBatDauDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatDauDoActionPerformed
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        txtNgayDo.setText(formatter.format(new Date()));
        btnLuu.setEnabled(true);
        ResultSet rs = csdlDTS.selectAllThongSo(maKH);
        try {
            if(rs.next()){
                doLanTiepTheo(rs);
            }else doLanDau();
            btnLuu.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(FrmDoThongSo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBatDauDoActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        Vector vec = new Vector();
        vec.add(lbMaKhachHang.getText());
        vec.add(txtNgayDo.getText());
        vec.add(txtChieuCao.getText());
        vec.add(txtCanNang.getText());
        vec.add(txtTiLeMo.getText());
        vec.add(txtTiLeNuoc.getText());
        if (csdlDTS.insertThongSo(vec)) {
            JOptionPane.showMessageDialog(this, "Lưu thành công !");
            btnLuu.setEnabled(false);
            vec.remove(0);
            startLineChart();
            getDataTaBle();
            lamTrangText();
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnInLichSuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInLichSuActionPerformed
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(FrmDoThongSo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDoThongSo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDoThongSo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDoThongSo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                FrmDoThongSo1 dialog = new FrmDoThongSo1(new javax.swing.JFrame(), true);
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
    private com.raven.swing.KButton btnLuu;
    private com.raven.swing.KButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbHinhAnhKhach;
    private javax.swing.JLabel lbHoTen;
    private javax.swing.JLabel lbMaKhachHang;
    private javax.swing.JLabel lbSDT;
    private com.raven.chart.LineChart lineChart;
    private com.raven.swing.PanelRound panelRound1;
    private com.raven.swing.PanelRound panelRound2;
    private com.raven.swing.TableColumn tblThongSo;
    private com.raven.swing.TextFieldRound txtCanNang;
    private com.raven.swing.TextFieldRound txtChieuCao;
    private com.raven.swing.TextFieldRound txtNgayDo;
    private com.raven.swing.TextFieldRound txtTiLeMo;
    private com.raven.swing.TextFieldRound txtTiLeNuoc;
    // End of variables declaration//GEN-END:variables
}
