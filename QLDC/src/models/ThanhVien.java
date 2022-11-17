/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package models;

/**
 *
 * @author pc
 */
public class ThanhVien {
    private int idPerson;
    private String hoTen;
    private int tuoi;
    private int namSinh;
    private String ngheNghiep;
    private int idHo;
    private String soNha;
    
    public ThanhVien(){
        
    }
    public ThanhVien(String hoTen, int tuoi, int namSinh, String ngheNghiep, int idHo) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.namSinh = namSinh;
        this.ngheNghiep = ngheNghiep;
        this.idHo = idHo;
    }
    public ThanhVien(int idPerson, String hoTen, int tuoi, int namSinh, String ngheNghiep, int idHo) {
        this.idPerson = idPerson;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.namSinh = namSinh;
        this.ngheNghiep = ngheNghiep;
        this.idHo = idHo;
    }
    public ThanhVien( int idPerson,String hoTen, int tuoi, int namSinh, String ngheNghiep, String soNha) {
        this.idPerson = idPerson;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.namSinh = namSinh;
        this.ngheNghiep = ngheNghiep;
        this.soNha = soNha;
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
    public int getIdHo(){
        return idHo;
    }
    public void setIdHo(int idHo){
        this.idHo = idHo;
    }
    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }
//    String getIdHo() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
    
}

