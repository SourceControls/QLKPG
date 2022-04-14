package model;

import javax.swing.Icon;

public class ModelNV {
    private String manv;
    private String ten;
    private boolean quanli;
    private Icon anh;
    
    public ModelNV(String manv,String ten, boolean quanli, Icon anh) {
        this.manv=manv;
        this.ten = ten;
        this.quanli = quanli;
        this.anh = anh;
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
