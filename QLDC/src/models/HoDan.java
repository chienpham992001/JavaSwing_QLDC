/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Asus
 */
public class HoDan {

    private int idHo;
    private int soThanhVien;
    private String soNha;
    private String taiKhoan;
    private String matKhau;

    public HoDan() {

    }

    public HoDan(int idHo, int soThanhVien, String soNha, String taiKhoan, String matKhau) {
        this.idHo = idHo;
        this.soThanhVien = soThanhVien;
        this.soNha = soNha;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public HoDan(int soThanhVien, String soNha, String taiKhoan, String matKhau) {
        this.soThanhVien = soThanhVien;
        this.soNha = soNha;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public int getIdHo() {
        return idHo;
    }

    public void setIdHo(int idHo) {
        this.idHo = idHo;
    }

    public int getSoThanhVien() {
        return soThanhVien;
    }

    public void setSoThanhVien(int soThanhVien) {
        this.soThanhVien = soThanhVien;
    }

    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

}
