/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Asus
 */
public class ChiTietThanhVien {
    private int idPerson;
    private String hoTen;
    private int tuoi;
    private int namSinh;
    private String ngheNghiep;
    private int idHo;
    
    public ChiTietThanhVien(){
 
    }

    public ChiTietThanhVien(int idPerson, String hoTen, int tuoi, int namSinh, String ngheNghiep, int idHo) {
        this.idPerson = idPerson;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.namSinh = namSinh;
        this.ngheNghiep = ngheNghiep;
        this.idHo = idHo;
    }


    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public int getIdHo() {
        return idHo;
    }

    public void setIdHo(int idHo) {
        this.idHo = idHo;
    }
    
}
