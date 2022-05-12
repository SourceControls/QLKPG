package model;

import javax.swing.Icon;

public class ModelNV {
    private String manv;
    private String ten;
    private boolean quanli;
    private Icon anh;
    private String password;
    public ModelNV(String manv,String ten, boolean quanli, Icon anh,String pass) {
        this.manv=manv;
        this.ten = ten;
        this.quanli = quanli;
        this.anh = anh;
        password=pass;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTen() {
        if(ten.split(" ").length>2) return ten.split(" ")[ten.split(" ").length-2]+" "+ ten.split(" ")[ten.split(" ").length-1];
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean isQuanli() {
        return quanli;
    }

    public void setQuanli(boolean quanli) {
        this.quanli = quanli;
    }
    public Icon getAnh() {
        return anh;
    }

    public void setAnh(Icon anh) {
        this.anh = anh;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public ModelNV() {
    }

  
}
