/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Asus
 */
public class YKien {
    private int id_ykien;
    private int idHo;
    private String thoigian;
    private String tieude;
    private String noidung;
    
    public YKien(){
        
    }

    public YKien(int id_ykien, int idHo, String thoigian, String tieude, String noidung) {
        this.id_ykien = id_ykien;
        this.idHo = idHo;
        this.tieude = tieude;
        this.noidung = noidung;
        this.thoigian = thoigian;
    }
public YKien( String tieude, String noidung,String thoigian,int idHo) {
        this.idHo = idHo;
        this.tieude = tieude;
        this.noidung = noidung;
        this.thoigian = thoigian;
    }
    
    public int getId_ykien() {
        return id_ykien;
    }

    public void setId_ykien(int id_ykien) {
        this.id_ykien = id_ykien;
    }

    public int getIdHo() {
        return idHo;
    }

    public void setIdHo(int idHo) {
        this.idHo = idHo;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }
    
    
}
