/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import connection.MysqlConnection;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ChiTietThanhVien;

/**
 *
 * @author Asus
 */
public class TV_Modify {
    
    public static List<ChiTietThanhVien> timKiemTheoTen(String hoTen){
        List<ChiTietThanhVien> thanhVienList = new ArrayList<>();
        
        Connection connection = null;
        
        PreparedStatement statement = null;
        
        try{
            connection = MysqlConnection.getMysqlConnection();
            
            //Query
            String sql = "select*from thanhvien where hoTen like ?";
            statement = (PreparedStatement) connection.prepareCall(sql);
            
            statement.setString(1,"%"+hoTen+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                ChiTietThanhVien thanhvien = new ChiTietThanhVien(resultSet.getInt("idPerson"), resultSet.getString("hoTen"),
                        resultSet.getInt("tuoi"), resultSet.getInt("namSinh"), 
                        resultSet.getString("ngheNghiep"),resultSet.getInt("idHo"));
                thanhVienList.add(thanhvien);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TV_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TV_Modify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TV_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(connection != null){
                try{
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TV_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return thanhVienList;
    }
    public static List<ChiTietThanhVien> hienThi(int idHo){
        List<ChiTietThanhVien> thanhVienList = new ArrayList<>();
        
        Connection connection = null;
        
        PreparedStatement statement = null;
        
        try{
            connection = MysqlConnection.getMysqlConnection();
            
            //Query
            String sql = "select*from thanhvien where idHo=? ";
            statement = (PreparedStatement) connection.prepareCall(sql);
            
            statement.setInt(1,idHo);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                ChiTietThanhVien thanhvien = new ChiTietThanhVien(resultSet.getInt("idPerson"), resultSet.getString("hoTen"),
                        resultSet.getInt("tuoi"), resultSet.getInt("namSinh"), 
                        resultSet.getString("ngheNghiep"),resultSet.getInt("idHo"));
                thanhVienList.add(thanhvien);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TV_Modify.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TV_Modify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TV_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(connection != null){
                try{
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TV_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return thanhVienList;
    }
}