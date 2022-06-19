/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDF;

import PDF.PDF;
import java.awt.Color;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author TuanHung
 */
public class PhieuThuTienPDF {

    public ResultSet getPDF() throws SQLException {
        String sql = "EXEC SP_PTT_TO_PDF ?";
        PreparedStatement pst = com.raven.main.FrmMain.conn.prepareStatement(sql);
        pst.setString(1, MAPTT);
        return pst.executeQuery();
    }
    String MAPTT = "";
    String hoTen = "";
    String ngayThu = "";
    String hotenNV = "";
    public PhieuThuTienPDF(String MAPTT) throws IOException, SQLException {
        PDF pdf = new PDF();
        this.MAPTT = MAPTT;
        if (this.MAPTT.isEmpty()) {
            System.out.println("Mã PTT trống");
            return;
        }
        //header
        pdf.insertImage(-10, 0, "logo.png");
        pdf.insertText(0, 85, "PHIẾU THU TIỀN", pdf.fontB, pdf.fontSizeB, Color.black, "center");
        String[] date = java.time.LocalDate.now().toString().split("-");
        String ngayThangNam = "Ngày " + date[2] + " Tháng " + date[1] + " Năm " + date[0];
        pdf.insertText(40, 135, ngayThangNam, pdf.fontN, pdf.fontSizeN, Color.black, "right");
        //content

        Vector<Vector> headers = getHeaders();
        Vector<Vector> datas = getDatas();

        int[] colW = {270, 250};

        pdf.drawTable(40, 450, 30, headers, datas, colW);
        //footer
        pdf.insertText(80, 550, "Chữ Kí Người Nộp Tiền", pdf.fontB, pdf.fontSizeN, Color.black, "right");
        pdf.insertText(80, 550, "Chữ Kí Người Lập Phiếu Thu", pdf.fontB, pdf.fontSizeN, Color.black, "");
        pdf.insertText(110, 620, hotenNV, pdf.fontB, pdf.fontSizeN, Color.black, "");

        pdf.savePDF(hoTen + "_" + ngayThu);
    }

    private Vector<Vector> getHeaders() throws SQLException {
        Vector<Vector> mainVec = new Vector<>();

        Vector vec = new Vector<>();

        vec = new Vector<>();
        vec.add("Mã Phiếu Thu: ");
        vec.add("Mã Nhân Viên Thu: ");
        mainVec.add(vec);
        
        vec = new Vector<>();
        vec.add("Mã Khách Hàng: ");
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add("Họ Tên: ");
        vec.add("SĐT: ");
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add("Địa Chỉ: ");
        vec.add("");
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add("Thu Tiền Cho Phiếu Đăng Kí: ");
        vec.add("Ngày Thu: ");
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add("Tên Dịch Vụ Đăng Kí: ");
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add("Số Tiền Khách Trả: ");
        vec.add("Số Tiền Còn Nợ: ");
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add("Hạn Thu Lần Tới: ");
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add("Ghi Chú: ");
        vec.add("");
        mainVec.add(vec);
        return mainVec;
    }

    private Vector<Vector> getDatas() throws SQLException {
        Vector<Vector> mainVec = new Vector<>();
        ResultSet rs = getPDF();
        if (!rs.next()) {
            System.out.println("Không tìm được phiếu đăng kí");
            return null;
        }
        hoTen = rs.getString("HOTEN");
        ngayThu = rs.getString("NGAYTHU");
        hotenNV = rs.getString("HOTENNV");
        Vector vec = new Vector<>();
        vec = new Vector<>();
        vec.add(rs.getString("MAPTT"));
        vec.add(rs.getString("MANV"));
        mainVec.add(vec);
        
        vec = new Vector<>();
        vec.add(rs.getString("MAKH"));
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add(rs.getString("HOTEN"));
        vec.add(rs.getString("SDT"));
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add(rs.getString("DIACHI"));
        vec.add("");
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add(rs.getString("MAPDK"));
        vec.add(rs.getString("NGAYTHU"));

        mainVec.add(vec);

        vec = new Vector<>();
        vec.add(rs.getString("TENDV"));
        mainVec.add(vec);


        vec = new Vector<>();
        vec.add(rs.getString("TIENKHACHTRA"));
        vec.add(rs.getString("TIENCONNO"));
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add(rs.getString("HANLANTOI"));
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add(rs.getString("GHICHU"));
        vec.add("");
        mainVec.add(vec);
        return mainVec;
    }
}
