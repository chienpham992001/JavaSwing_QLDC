/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import connection.MysqlConnection;
import models.HoDan;
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

/**
 *
 * @author Asus
 */
public class HoDanModify {
    //Lấy tất cả danh sách hộ dân
    public static List<HoDan> findAll(){
        List<HoDan> hoDanList = new ArrayList<>();
        
        Connection connection = null;
        
        Statement statement = null;
        
        try{
            connection = MysqlConnection.getMysqlConnection();
            
            //Query
            String sql = "select*from hodan";
            String sql_stv = "";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while(resultSet.next()){
                HoDan hodan = new HoDan(resultSet.getInt("idHo"), resultSet.getInt("soThanhVien"),
                        resultSet.getString("soNha"), resultSet.getString("taiKhoan"), 
                        resultSet.getString("matKhau"));
                hoDanList.add(hodan);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(HoDanModify.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HoDanModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoDanModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(connection != null){
                try{
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoDanModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return hoDanList;
    }
    
    public static void insert(HoDan hodan){
        Connection connection = null;
        
        PreparedStatement statement = null;
        
        try{
            connection = MysqlConnection.getMysqlConnection();
            
            //Query
            String sql = "insert into hodan(soThanhVien,soNha,taiKhoan,matKhau) values(?,?,?,?)";
            
            statement = (PreparedStatement) connection.prepareCall(sql);
            
            statement.setInt(1, hodan.getSoThanhVien());
            statement.setString(2, hodan.getSoNha());
            statement.setString(3, hodan.getTaiKhoan());
            statement.setString(4, hodan.getMatKhau());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(HoDanModify.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HoDanModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoDanModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(connection != null){
                try{
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoDanModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void update(HoDan hodan){
        Connection connection = null;
        
        PreparedStatement statement = null;
        
        try{
            connection = MysqlConnection.getMysqlConnection();
            //Query
            String sql = "update hodan set idHo=?, soThanhVien=?,soNha=?,taiKhoan=?,matKhau=? where idHo=?";
            
            statement = (PreparedStatement) connection.prepareCall(sql);
            
            statement.setInt(1, hodan.getIdHo());
            statement.setInt(2, hodan.getSoThanhVien());
            statement.setString(3, hodan.getSoNha());
            statement.setString(4, hodan.getTaiKhoan());
            statement.setString(5, hodan.getMatKhau());
            statement.setInt(6, hodan.getIdHo());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(HoDanModify.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HoDanModify.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void delete(int idHo){
        Connection connection = null;
        
        PreparedStatement statement = null;
        
        try{
            connection = MysqlConnection.getMysqlConnection();
            
            //Query
            String sql = "delete from hodan where idHo=?";
            
            statement = (PreparedStatement) connection.prepareCall(sql);
            
            statement.setInt(1,idHo);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(HoDanModify.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HoDanModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoDanModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(connection != null){
                try{
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoDanModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public static List<HoDan> timKiemTheoSoNha(String soNha){
        List<HoDan> hoDanList = new ArrayList<>();
        
        Connection connection = null;
        
        PreparedStatement statement = null;
        
        try{
            connection = MysqlConnection.getMysqlConnection();
            
            //Query
            String sql = "select*from hodan where soNha like ?";
            statement = (PreparedStatement) connection.prepareCall(sql);
            
            statement.setString(1,"%"+soNha+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                HoDan hodan = new HoDan(resultSet.getInt("idHo"), resultSet.getInt("soThanhVien"),
                        resultSet.getString("soNha"), resultSet.getString("taiKhoan"), 
                        resultSet.getString("matKhau"));
                hoDanList.add(hodan);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(HoDanModify.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HoDanModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoDanModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(connection != null){
                try{
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoDanModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return hoDanList;
    }
}
