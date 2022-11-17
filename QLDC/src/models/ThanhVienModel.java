/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Admin
 */
public class ThanhVienModel {
    private int idPerson,tuoi,namSinh,idHo;
    private String hoTen,ngheNghiep;

    public ThanhVienModel() {
    }

    public ThanhVienModel(int idPerson, String hoTen, int tuoi, int namSinh, String ngheNghiep) {
        this.idPerson = idPerson;
        this.tuoi = tuoi;
        this.namSinh = namSinh;
        this.hoTen = hoTen;
        this.ngheNghiep = ngheNghiep;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
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

    public int getIdHo() {
        return idHo;
    }

    public void setIdHo(int idHo) {
        this.idHo = idHo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }
    
}
