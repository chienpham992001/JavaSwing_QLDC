/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;


import connection.MysqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.YKien;

/**
 *
 * @author Asus
 */
public class YKienModify {
    public static List<YKien> findAll(){
        List<YKien> yKienList = new ArrayList<>();
        
        Connection connection = null;
        
        Statement statement = null;
        
        try{
            connection = MysqlConnection.getMysqlConnection();
            
            //Query
            String sql = "select*from ykien";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while(resultSet.next()){
                YKien ykien = new YKien(resultSet.getInt("id_ykien"),resultSet.getInt("idHo"),resultSet.getString("thoigian"),
                        resultSet.getString("tieude"),resultSet.getString("noidung"));
                yKienList.add(ykien);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(YKienModify.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(YKienModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(YKienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(connection != null){
                try{
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(YKienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return yKienList;
    }
    public static void insert(YKien ykien){
        
        PreparedStatement statement = null;
        
        try{
            Connection connection = MysqlConnection.getMysqlConnection();
            
            //Query
            String sql = "insert into ykien(tieude,noidung,thoigian,idHo) values(?,?,?,?)";
            
            statement = (PreparedStatement) connection.prepareCall(sql);
            
            statement.setString(1, ykien.getTieude());
            statement.setString(2, ykien.getNoidung());
            statement.setString(3, ykien.getThoigian());
            statement.setInt(4, ykien.getIdHo());
            
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
}
