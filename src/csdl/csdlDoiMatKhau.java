/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csdl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.raven.main.FrmMain;

/**
 *
 * @author TuanHung
 */
public class CsdlDoiMatKhau {
    Connection conn = FrmMain.conn;
    public void doiMatKhau(String matKhauCu, String matKhauMoi) throws SQLException{
        String sql = "exec sp_doi_MK ?,?,?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,FrmMain.modelNV.getManv());
        pst.setString(2,matKhauCu);
        pst.setString(3,matKhauMoi);
        
        pst.execute();
        
    }
    
    
}
