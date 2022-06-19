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
public class PhieuDangKiPDF {

    public ResultSet getPDF() throws SQLException {
        String sql = "EXEC SP_PDK_TO_PDF ?";
        PreparedStatement pst = com.raven.main.FrmMain.conn.prepareStatement(sql);
        pst.setString(1, maPDK);
        return pst.executeQuery();
    }
    String maPDK = "";
    String hoTen = "";
    String ngayDK = "";
    String hotenNV = "";
    public PhieuDangKiPDF(String maPDK) throws IOException, SQLException {
        PDF pdf = new PDF();
        this.maPDK = maPDK;
        if (this.maPDK.isEmpty()) {
            System.out.println("Mã PDK trống");
            return;
        }
        //header
        pdf.insertImage(-10, 0, "logo.png");
        pdf.insertText(0, 85, "PHIẾU ĐĂNG KÍ DỊCH VỤ", pdf.fontB, pdf.fontSizeB, Color.black, "center");
        String[] date = java.time.LocalDate.now().toString().split("-");
        String ngayThangNam = "Ngày " + date[2] + " Tháng " + date[1] + " Năm " + date[0];
        pdf.insertText(40, 135, ngayThangNam, pdf.fontN, pdf.fontSizeN, Color.black, "right");
        //content

        Vector<Vector> headers = getHeaders();
        Vector<Vector> datas = getDatas();

        int[] colW = {270, 250};
        System.out.println(headers.size() + " " + datas.size());
        pdf.drawTable(40, 550, 30, headers, datas, colW);
        //footer
        pdf.insertText(80, 650, "Chữ Kí Người Đăng Kí", pdf.fontB, pdf.fontSizeN, Color.black, "right");
        pdf.insertText(80, 650, "Chữ Kí Người Lập Phiếu Đăng Kí", pdf.fontB, pdf.fontSizeN, Color.black, "");
        pdf.insertText(110, 720, hotenNV, pdf.fontB, pdf.fontSizeN, Color.black, "");
        pdf.savePDF(hoTen + "_" + ngayDK);  
    }

    private Vector<Vector> getHeaders() throws SQLException {
        Vector<Vector> mainVec = new Vector<>();

        Vector vec = new Vector<>();

        vec = new Vector<>();
        vec.add("Mã Phiếu: ");
        vec.add("Mã Khách Hàng: ");
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add("Họ Tên: ");
        vec.add("Giới Tính: ");
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add("SĐT: ");
        vec.add("CMND: ");
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add("Email: ");
        vec.add("Ngày Sinh: ");
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add("Địa Chỉ: ");
        vec.add("");
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add("Đăng Kí Sử Dụng Dịch Vụ: ");
        vec.add("");
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add("Ngày Đăng Kí: ");
        vec.add("Số Ngày Sử Dụng: ");
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add("Ngày Bắt Đầu: ");
        vec.add("Ngày Kết Thúc: ");
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add("Giá: ");
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add("Thuế: ");
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add("Khuyến Mãi: ");
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add("Thành Tiền");
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
        ngayDK = rs.getString("NGAYDK");
        hotenNV = rs.getString("hotennv");
        Vector vec = new Vector<>();
        vec = new Vector<>();
        vec.add(rs.getString("MAPDK"));
        vec.add(rs.getString("MAKH"));
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add(rs.getString("HOTEN"));
        vec.add(rs.getString("GIOITINH"));
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add(rs.getString("SDT"));
        vec.add(rs.getString("CMND"));
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add(rs.getString("EMAIL"));
        vec.add(rs.getString("NGAYSINH"));
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add(rs.getString("DIACHI"));
        vec.add("");
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add(rs.getString("TENDV"));
        vec.add("");
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add(rs.getString("NGAYDK"));
        vec.add(rs.getString("SONGAYSUDUNG"));
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add(rs.getString("NGAYBD"));
        vec.add(rs.getString("NGAYKT"));
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add(rs.getString("GIA"));
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add(rs.getString("THUE"));
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add(rs.getString("KHUYENMAI"));
        mainVec.add(vec);

        vec = new Vector<>();
        vec.add(rs.getString("TONGTIEN"));
        vec.add("");
        mainVec.add(vec);
        return mainVec;
    }

}
