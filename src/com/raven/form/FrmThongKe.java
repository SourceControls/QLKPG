/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import com.raven.chart.ModelChart;
import com.raven.chart.blankchart.BlankPlotChart;
import csdl.CsdlThongKe;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.DungChung;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.internal.series.Series;
import org.knowm.xchart.style.Styler;

/**
 *
 * @author anhtu
 */
public class FrmThongKe extends javax.swing.JPanel {

    /**
     * Creates new form FrmBaoCao
     */
    private DefaultTableModel dtblDoanhThu;
    private CsdlThongKe csdlThongKe;

    public FrmThongKe() {
        initComponents();
        devInit();
        this.setVisible(true);

    }

    private void devInit() {

        csdlThongKe = new CsdlThongKe();
        dtblDoanhThu = (DefaultTableModel) tblDoanhThu.getModel();
        try {
//            setMinYMaxY();
            lineChart.addLegend("Số Lượt Vào Ra", new Color(12, 84, 175), new Color(0, 108, 247));
            startLineChart();
            pieChart(pnGioiTinh, "Giới Tính", csdlThongKe.thongKeGioiTinh());
            pieChart(pnDoTuoi, "Độ Tuổi", csdlThongKe.thongKeDoTuoi());
            DungChung.fillTable(dtblDoanhThu, csdlThongKe.selectAllThongKeDoanhThu());
            ResultSet rs = csdlThongKe.selectAllThongKeKhachHang();
            if (rs.next()) {
                lbTongSoKhachHang.setText(rs.getObject(1).toString());
                lbKhachLanDau.setText(rs.getObject(2).toString());
                lbKhachHangCu.setText(rs.getObject(3).toString());

            }
            setTongDoanhThu();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        txtTuNgay.setText("1900-01-01");
        addListener();

    }

    private void pieChart(JPanel panel, String title, ResultSet rs) {
        panel.removeAll();
        panel.repaint();
        org.knowm.xchart.PieChart chart = new PieChartBuilder().width(100).height(100).title(title).theme(Styler.ChartTheme.GGPlot2).build();

        // Customize Chart
        chart.getStyler().setPlotContentSize(.7);
//        chart.getStyler().setStartAngleInDegrees(90);
        chart.getStyler().setChartTitleFont(new Font("Arial", Font.BOLD, 25));
        chart.getStyler().setLabelsFont(new Font("Arial", Font.BOLD, 15));
        chart.getStyler().setLegendFont(new Font("Arial", Font.BOLD, 15));
        chart.getStyler().setLabelsDistance(1.2);
        chart.getStyler().setPlotBackgroundColor(Color.white);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.OutsideS);
        chart.getStyler().setLegendLayout(Styler.LegendLayout.Horizontal);
        chart.getStyler().setChartTitleBoxBackgroundColor(Color.white);
        chart.getStyler().setChartTitleBoxBorderColor(Color.white);
//        chart.getStyler().setSeriesColors(new Color[]{new Color(95, 189, 105), new Color(244, 117, 72), new Color(26, 129, 196), new Color(250, 162, 62), new Color(240, 66, 75)});
        try {
            ResultSetMetaData rsm = rs.getMetaData();
            int i = 1;
            if (rs.next()) {
                while (i <= rsm.getColumnCount()) {
                    if (rs.getInt(i) > 0) {
                        chart.addSeries(rsm.getColumnName(i), rs.getInt(i));
                    }
                    i++;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        chart.getStyler().setForceAllLabelsVisible(true);
        // Series
        XChartPanel xpanel = new XChartPanel<>(chart);
        xpanel.setSize(new Dimension(475, 400));
        panel.add(xpanel);

    }

    private void addListener() {
        txtTuNgay.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                loc();

            }

        });
        txtDenNgay.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                loc();
            }
        });

    }

    public void loc() {

        String tuNgay = txtTuNgay.getText();
        String denNgay = txtDenNgay.getText();

        try {
            DungChung.fillTable(dtblDoanhThu, csdlThongKe.selectAllDoanhThuTrongKhoang(tuNgay, denNgay));
            setTongDoanhThu();
        } catch (SQLException ex) {
            Logger.getLogger(FrmThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void startLineChart() throws SQLException {
        lineChart.clear();
        ResultSet rs = csdlThongKe.selectAllThongKeVaoRa();
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            rs.next();
            for (int i = 1; i < rsmd.getColumnCount(); i++) {
                Double chiso = Double.parseDouble(rs.getString(i));
                lineChart.addData(new ModelChart(rsmd.getColumnLabel(i), new double[]{chiso}));
            }

            lineChart.start();
        } catch (SQLException ex) {
            Logger.getLogger(FrmDoThongSo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void setTongDoanhThu() {
        double doanhThu = 0;
        String formatter = "#,###,###,###.00";
        for (int i = 0; i < tblDoanhThu.getRowCount(); i++) {
            doanhThu += Double.parseDouble(dtblDoanhThu.getValueAt(i, dtblDoanhThu.getColumnCount() - 1).toString().replace(",", ""));
        }
        DecimalFormat df = new DecimalFormat(formatter);

        // printed the formatted number
        lbTongDoanhThu.setText("Tổng: " + df.format(doanhThu) + " VNĐ");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooserTuNgay = new com.raven.datechooser.DateChooser();
        dateChooserDenNgay = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbKhachHangCu = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbKhachLanDau = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbTongSoKhachHang = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        pnGioiTinh = new javax.swing.JPanel();
        pnDoTuoi = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lineChart = new com.raven.chart.LineChart();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lbTongDoanhThu = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtDenNgay = new com.raven.swing.TextFieldRound();
        btnHuyLoc = new com.raven.swing.KButton();
        jLabel23 = new javax.swing.JLabel();
        txtTuNgay = new com.raven.swing.TextFieldRound();
        btnLamMoi = new com.raven.swing.KButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoanhThu = new com.raven.swing.TableColumn();

        dateChooserTuNgay.setTextRefernce(txtTuNgay);

        dateChooserDenNgay.setForeground(new java.awt.Color(102, 102, 255));
        dateChooserDenNgay.setTextRefernce(txtDenNgay);

        setBackground(new java.awt.Color(250, 249, 249));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(104, 109, 224));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(104, 109, 224));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Khách Hàng Cũ:");

        lbKhachHangCu.setBackground(new java.awt.Color(104, 109, 224));
        lbKhachHangCu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbKhachHangCu.setForeground(new java.awt.Color(255, 255, 255));
        lbKhachHangCu.setText("NaN");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbKhachHangCu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbKhachHangCu, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(104, 109, 224));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(104, 109, 224));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Khách Hàng Mới:");

        lbKhachLanDau.setBackground(new java.awt.Color(104, 109, 224));
        lbKhachLanDau.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbKhachLanDau.setForeground(new java.awt.Color(255, 255, 255));
        lbKhachLanDau.setText("NaN");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbKhachLanDau, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbKhachLanDau, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(104, 109, 224));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(104, 109, 224));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tổng Số Khách Hàng:");
        jLabel2.setToolTipText("Tổng số khách có đăng kí dịch vụ");

        lbTongSoKhachHang.setBackground(new java.awt.Color(104, 109, 224));
        lbTongSoKhachHang.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbTongSoKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        lbTongSoKhachHang.setText("NaN");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTongSoKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTongSoKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel4, jPanel5, jPanel6});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel4, jPanel5, jPanel6});

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Số Liệu Khách Hàng Đã Từng Đăng Kí Dịch Vụ ");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        pnGioiTinh.setBackground(new java.awt.Color(255, 255, 255));
        pnGioiTinh.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout pnGioiTinhLayout = new javax.swing.GroupLayout(pnGioiTinh);
        pnGioiTinh.setLayout(pnGioiTinhLayout);
        pnGioiTinhLayout.setHorizontalGroup(
            pnGioiTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnGioiTinhLayout.setVerticalGroup(
            pnGioiTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 357, Short.MAX_VALUE)
        );

        pnDoTuoi.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnDoTuoiLayout = new javax.swing.GroupLayout(pnDoTuoi);
        pnDoTuoi.setLayout(pnDoTuoiLayout);
        pnDoTuoiLayout.setHorizontalGroup(
            pnDoTuoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnDoTuoiLayout.setVerticalGroup(
            pnDoTuoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(pnGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnDoTuoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnDoTuoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thống Kê Số Lượt Vào Ra Theo Các Múi Giờ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lineChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lineChart, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Bảng Doanh Thu Theo Khách Hàng");

        lbTongDoanhThu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTongDoanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTongDoanhThu.setText("Tổng:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Từ ngày:");

        txtDenNgay.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDenNgay.setOpaque(true);
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

        btnHuyLoc.setText("Hủy Lọc");
        btnHuyLoc.setkEndColor(new java.awt.Color(255, 51, 255));
        btnHuyLoc.setkHoverEndColor(new java.awt.Color(153, 153, 255));
        btnHuyLoc.setkHoverForeGround(new java.awt.Color(255, 0, 255));
        btnHuyLoc.setkHoverStartColor(new java.awt.Color(104, 109, 224));
        btnHuyLoc.setkStartColor(new java.awt.Color(224, 86, 253));
        btnHuyLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyLocActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Đến ngày:");

        txtTuNgay.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTuNgay.setOpaque(true);
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

        btnLamMoi.setText("Làm Mới");
        btnLamMoi.setkEndColor(new java.awt.Color(255, 51, 255));
        btnLamMoi.setkHoverEndColor(new java.awt.Color(153, 153, 255));
        btnLamMoi.setkHoverForeGround(new java.awt.Color(255, 0, 255));
        btnLamMoi.setkHoverStartColor(new java.awt.Color(104, 109, 224));
        btnLamMoi.setkStartColor(new java.awt.Color(224, 86, 253));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        tblDoanhThu.setAutoCreateRowSorter(true);
        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Họ Tên", "SĐT", "Hạng Khách", "Tổng Doanh Thu(VNĐ)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDoanhThu.setHasBtn(false);
        jScrollPane1.setViewportView(tblDoanhThu);
        if (tblDoanhThu.getColumnModel().getColumnCount() > 0) {
            tblDoanhThu.getColumnModel().getColumn(0).setMaxWidth(150);
        }

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuyLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDenNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHuyLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtDenNgayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDenNgayMousePressed
        dateChooserDenNgay.showPopup();
    }//GEN-LAST:event_txtDenNgayMousePressed

    private void txtDenNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDenNgayActionPerformed

    }//GEN-LAST:event_txtDenNgayActionPerformed
// Listen for changes in the text

    private void btnHuyLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyLocActionPerformed

        txtTuNgay.setText("1900-01-01");
        txtDenNgay.setText(java.time.LocalDate.now().toString());
        try {
            DungChung.fillTable(FrmQVT.dtblLSQVT, csdlThongKe.selectAllThongKeDoanhThu());
        } catch (SQLException ex) {
            Logger.getLogger(FrmThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnHuyLocActionPerformed

    private void txtTuNgayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTuNgayMouseClicked

    }//GEN-LAST:event_txtTuNgayMouseClicked

    private void txtTuNgayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTuNgayMousePressed
        dateChooserTuNgay.showPopup();
    }//GEN-LAST:event_txtTuNgayMousePressed

    private void txtTuNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTuNgayActionPerformed

    }//GEN-LAST:event_txtTuNgayActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        loc();
        try {
            startLineChart();
            pieChart(pnGioiTinh, "Giới Tính", csdlThongKe.thongKeGioiTinh());
            pieChart(pnDoTuoi, "Độ Tuổi", csdlThongKe.thongKeDoTuoi());
            ResultSet rs = csdlThongKe.selectAllThongKeKhachHang();
            if (rs.next()) {
                lbTongSoKhachHang.setText(rs.getObject(1).toString());
                lbKhachLanDau.setText(rs.getObject(2).toString());
                lbKhachHangCu.setText(rs.getObject(3).toString());

            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnLamMoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.KButton btnHuyLoc;
    private com.raven.swing.KButton btnLamMoi;
    private com.raven.datechooser.DateChooser dateChooserDenNgay;
    private com.raven.datechooser.DateChooser dateChooserTuNgay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbKhachHangCu;
    private javax.swing.JLabel lbKhachLanDau;
    private javax.swing.JLabel lbTongDoanhThu;
    private javax.swing.JLabel lbTongSoKhachHang;
    private com.raven.chart.LineChart lineChart;
    private javax.swing.JPanel pnDoTuoi;
    private javax.swing.JPanel pnGioiTinh;
    private com.raven.swing.TableColumn tblDoanhThu;
    private com.raven.swing.TextFieldRound txtDenNgay;
    private com.raven.swing.TextFieldRound txtTuNgay;
    // End of variables declaration//GEN-END:variables
}
