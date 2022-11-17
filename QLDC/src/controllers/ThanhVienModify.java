/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import connection.MysqlConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.ThanhVien;
/**
 *
 * @author pc
 */
public class ThanhVienModify {
    public static List<ThanhVien> findAll(){
        List<ThanhVien> thanhVienList = new ArrayList<>();
        
        Statement statement = null;
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            
            //Query
            String sql = "select * from thanhvien";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while(resultSet.next()){
                ThanhVien thanhvien = new ThanhVien(resultSet.getInt("idPerson"), resultSet.getString("hoTen"), resultSet.getInt("tuoi"),
                        resultSet.getInt("namSinh"),resultSet.getString("ngheNghiep"), resultSet.getInt("idHo"));
                thanhVienList.add(thanhvien);
            }
        } catch (Exception ex) {
                Logger.getLogger(ThanhVienModify.class.getName()).log(Level.SEVERE, null, ex);
                
        } finally {
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThanhVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

                
        }
        return thanhVienList;
    }
    
    public static void insert(ThanhVien thanhvien){
        
        PreparedStatement statement = null;
        
        try{
           
            Connection connection = MysqlConnection.getMysqlConnection();
            //Query
            String sql = "insert into thanhvien(hoTen,tuoi,namSinh,ngheNghiep,idHo) values(?,?,?,?,?)";
            
            statement = (PreparedStatement) connection.prepareCall(sql);
            
            //statement.setInt(1, thanhvien.getIdPerson());
            statement.setString(1, thanhvien.getHoTen());
            statement.setInt(2, thanhvien.getTuoi());
            statement.setInt(3, thanhvien.getNamSinh());
            statement.setString(4, thanhvien.getNgheNghiep());
            statement.setInt(5, thanhvien.getIdHo());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ThanhVienModify.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex){
            Logger.getLogger(ThanhVienModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThanhVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public static void update(ThanhVien thanhvien){
        
        
        PreparedStatement statement = null;
        
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            //Query
            String sql = "update thanhvien set hoTen=?,tuoi=?,namSinh=?,ngheNghiep=?, idHo = ? where idPerson=?";
            
            statement = (PreparedStatement) connection.prepareCall(sql);
            
            
            statement.setString(1, thanhvien.getHoTen());
            statement.setInt(2, thanhvien.getTuoi());
            statement.setInt(3, thanhvien.getNamSinh());
            statement.setString(4, thanhvien.getNgheNghiep());
            statement.setInt(5, thanhvien.getIdHo());
            statement.setInt(6, thanhvien.getIdPerson());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ThanhVienModify.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex){
            Logger.getLogger(ThanhVienModify.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void delete(int idPerson){
       
        
        PreparedStatement statement = null;
        
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            
            //Query
            String sql = "delete from thanhvien where idPerson=?";
            
            statement = (PreparedStatement) connection.prepareCall(sql);
            
            statement.setInt(1,idPerson);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ThanhVienModify.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex){
            Logger.getLogger(ThanhVienModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThanhVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
           
        }
    }
    
    public static List<ThanhVien> timKiemTheoTen(String hoTen){
        List<ThanhVien> thanhVienList = new ArrayList<>();

        PreparedStatement statement = null;
        
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            
            //Query
            String sql = "select*from thanhvien inner join hodan on thanhvien.idHo = hodan.idHo where thanhvien.hoTen like ?";
            statement = (PreparedStatement) connection.prepareCall(sql);
            
            statement.setString(1,"%"+hoTen+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                ThanhVien thanhVien;
                thanhVien = new ThanhVien(resultSet.getInt("idPerson"), resultSet.getString("hoTen"),resultSet.getInt("tuoi"),
                        resultSet.getInt("namSinh"), resultSet.getString("ngheNghiep"),
                        resultSet.getString("soNha"));
                thanhVienList.add(thanhVien);
                
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ThanhVienModify.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex){
            Logger.getLogger(ThanhVienModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThanhVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        return thanhVienList;
    }
    
}
