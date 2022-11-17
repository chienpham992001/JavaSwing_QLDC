/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.UserPage;

import connection.MysqlConnection;
//import java.lang.System.Logger;
//import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.HoDanModel;
import models.ThanhVienModel;

import views.Login;
/**
 *
 * @author ASUS
 */
public class TTNhanKhauJPanel extends javax.swing.JPanel {

    /**
     * Creates new form TTNhanKhauJPanel
     */
    ArrayList<ThanhVienModel> list;
    public TTNhanKhauJPanel() throws ClassNotFoundException {
        initComponents();
        ttho();
        txtIdHo.setEditable(false);
        txtSoNha.setEditable(false);
        txtSoTV.setEditable(false);
        all();
        showData(list);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtIdHo = new javax.swing.JTextField();
        txtSoTV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSoNha = new javax.swing.JTextField();

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setText("Thông tin thành viên trong hộ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel2.setText("Thông tin chi tiết hộ dân");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thành viên", "Họ tên", "Tuổi", "Năm sinh", "Nghề nghiệp"
            }
        ));
        jScrollPane2.setViewportView(table);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("ID hộ dân :");

        txtIdHo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtSoTV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setText("Số thành viên :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setText("Số nhà :");

        txtSoNha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoTV, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdHo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoNha, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(252, 252, 252)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSoNha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
public void  all() throws ClassNotFoundException{
		list=new ArrayList<>();
               
		String query="select * from thanhvien, hodan where thanhvien.idHo=hodan.idHo and taiKhoan='"+Login.username.getText()+"'";
		try {
			Connection conn=MysqlConnection.getMysqlConnection();
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(query);			
			while(rs.next()) {
				ThanhVienModel tv=new ThanhVienModel(rs.getInt("idPerson"),rs.getString("hoTen"),rs.getInt("tuoi"),rs.getInt("namSinh"),rs.getString("ngheNghiep"));
				list.add(tv);
			}
		}catch(SQLException e) {
			
		}
		
	}
    void  showData(ArrayList<ThanhVienModel>list){
        
        DefaultTableModel tableModel;
        tableModel = (DefaultTableModel) table.getModel();
        list.forEach(a->{
            tableModel.addRow(new Object[]{
                a.getIdPerson(),a.getHoTen(),a.getTuoi(),a.getNamSinh(),a.getNgheNghiep()
            });
        });
        
    
    }
     public void ttho() throws ClassNotFoundException{
          
                
        String query="select * from hodan,thanhvien where hodan.idHo=thanhvien.Idho and taiKhoan='"+Login.username.getText() +"'";
		try {
			Connection conn=MysqlConnection.getMysqlConnection();
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(query);
                        if(rs.next()){
			HoDanModel hd=new HoDanModel(rs.getInt("idHo"),rs.getInt("soThanhVien"),rs.getString("soNha"),rs.getString("taiKhoan"),rs.getString("matKhau"));
                       
                            txtIdHo.setText(String.valueOf(hd.getIdHo()));
                            txtSoTV.setText(String.valueOf(hd.getSoThanhVien()));
                            txtSoNha.setText(hd.getSoNha());
                       }                       
                }catch(SQLException e) {
			
		}
         
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtIdHo;
    private javax.swing.JTextField txtSoNha;
    private javax.swing.JTextField txtSoTV;
    // End of variables declaration//GEN-END:variables
}
