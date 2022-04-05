package model;

import javax.swing.Icon;

public class ModelUser {
    private String ten;
    private String chucvu;
    private Icon anh;
    
    public ModelUser(String ten, String chucvu, Icon anh) {
        this.ten = ten;
        this.chucvu = chucvu;
        this.anh = anh;
    }

    public String getTen() {
        if(ten.split(" ").length>2) return ten.split(" ")[ten.split(" ").length-2]+" "+ ten.split(" ")[ten.split(" ").length-1];
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public Icon getAnh() {
        return anh;
    }

    public void setAnh(Icon anh) {
        this.anh = anh;
    }

    public ModelUser() {
    }

  
}
