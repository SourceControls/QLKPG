package com.raven.main;

import com.raven.component.Menu;
import com.raven.event.EventMenuSelected;
import com.raven.form.*;
import model.ModelMenu;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import com.raven.form.FrmDoThongSo;
import com.raven.main.Login;
import static com.raven.main.FrmMain.conn;
import javax.swing.JFrame;
import model.ModelNV;

public class FrmMain extends javax.swing.JFrame {

    private Menu menu;
    private JPanel main = new JPanel();
    private MigLayout layout;
    private Animator animator;
    private boolean menuShow;
    public static FrmKH formKH;
    public static FrmPDK formPDK;
    public static FrmQVT formQVT;
    public static FrmNV formNV;
    public static FrmDoiMatKhau frmDoiMK;
    public static final int DAY_PER_MONTH = 30;

    public static Connection conn;
    public static Frame f; //new FrmDangNhap();
    public static FrmDoThongSo frmDoThongSo = null;
    public static FrmDangKiDichVu frmDangKiDichVu = null;
    public static FrmThanhToan frmThanhToan = null;
    public FrmThongKe frmBaoCao = new FrmThongKe();
    public static ModelNV modelNV;
    //public static boolean quanLi = false;
    public FrmMain(ModelNV modelNV) {
        initComponents();
        this.modelNV = modelNV;
        devInit();
        f = this;
        
        init();
    }

    public void devInit() {
        formKH = new FrmKH();
        formPDK = new FrmPDK();
        formQVT = new FrmQVT();
        formNV = new FrmNV();
        frmDoiMK = new FrmDoiMatKhau();
        showData();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    public void showData() {
        formKH.showData();
        formPDK.showData();
        formQVT.showData();
        formNV.showData();
    }

    private void init() {
        this.setMinimumSize(new Dimension(1509, 700));
        layout = new MigLayout("fill", "0[]10[]5", "0[fill]0");
        body.setLayout(layout);
        main.setOpaque(false);
        main.setLayout(new BorderLayout());
        menu = new Menu();
        menu.addEventLogout(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                thoat();
            }
        });
        menu.addEventMenu(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
            }
        });
        menu.setEvent(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    showForm(formKH);
                } else if (index == 1) {
                    showForm(formPDK);
                } else if (index == 2) {
                    showForm(formQVT);
                } else if (index == 3) {
                    if(modelNV.isQuanli())
                        showForm(formNV);
                    else showForm(frmDoiMK);
                } else if (index == 4) {
                    showForm(frmBaoCao);
                } else if (index == 5) {
                    showForm(frmDoiMK);
                }

            }
        });

        menu.addMenu(new ModelMenu("Khách hàng", new ImageIcon(getClass().getResource("/com/raven/icon/user.png"))));
        menu.addMenu(new ModelMenu("Phiếu đăng kí", new ImageIcon(getClass().getResource("/com/raven/icon/card.png"))));
        menu.addMenu(new ModelMenu("Khách vào phòng tập", new ImageIcon(getClass().getResource("/com/raven/icon/door.png"))));
        if (modelNV.isQuanli()) {
            menu.addMenu(new ModelMenu("Nhân viên", new ImageIcon(getClass().getResource("/com/raven/icon/staff.png"))));
            menu.addMenu(new ModelMenu("Thống Kê", new ImageIcon(getClass().getResource("/com/raven/icon/report2.png"))));
        }
        menu.addMenu(new ModelMenu("Đổi mật khẩu", new ImageIcon(getClass().getResource("/com/raven/icon/key2.png"))));
        //menu.addMenu(new ModelMenu("Cài đặt", new ImageIcon(getClass().getResource("/com/raven/icon/setting.png"))));
        body.add(menu, "w 50!");
        body.add(main, "w 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menuShow) {
                    width = 50 + (150 * (1f - fraction));
                    menu.setAlpha(1f - fraction);
                } else {
                    width = 50 + (150 * fraction);
                    menu.setAlpha(fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!");
                body.revalidate();
            }

            @Override
            public void end() {
                menuShow = !menuShow;
            }
        };
        animator = new Animator(400, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        if(!modelNV.isQuanli())
        showForm(formKH);
        else showForm(formNV);
    }

    public void showForm(Component com) {
        main.removeAll();
        main.add(com);
        main.repaint();
        main.revalidate();

    }

    public static ModelNV getModelNV() {
        return modelNV;
    }

    public void setModelNV(ModelNV modelNV) {
        this.modelNV = modelNV;
    }

    public void thoat() {
        new Login(conn).setVisible(true);
        if (frmDoThongSo != null) {
            frmDoThongSo.dispose();
        }
        if (frmThanhToan != null) {
            frmThanhToan.dispose();
        }
        if (frmDangKiDichVu != null) {
            frmDangKiDichVu.dispose();
        }
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1740, 759));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        body.setMaximumSize(new java.awt.Dimension(1080, 660));
        body.setMinimumSize(new java.awt.Dimension(1080, 660));
        body.setName(""); // NOI18N
        body.setPreferredSize(new java.awt.Dimension(1350, 661));
        body.setLayout(new javax.swing.BoxLayout(body, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(body, java.awt.BorderLayout.CENTER);
        body.getAccessibleContext().setAccessibleParent(body);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized

    }//GEN-LAST:event_formComponentResized

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
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    // End of variables declaration//GEN-END:variables
}
