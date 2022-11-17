/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.AdminPage;

import controllers.ThanhVienModify;
import com.mysql.cj.xdevapi.Statement;
import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.MyCombo;
import models.ThanhVien;

public class Admin_QuanLyThanhVien extends javax.swing.JFrame {

    DefaultTableModel tableModel;

    List<ThanhVien> thanhVienList = ThanhVienModify.findAll();

    public Admin_QuanLyThanhVien() {
        initComponents();
        getDataCombo();
        tableModel = (DefaultTableModel) tblThanhVien.getModel();
        showThanhVien();
    }

    public void getDataCombo() {
        Connection connection = null;
        Statement statement = null;
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cboHo.getModel();
        cbbModel.removeAllElements();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qldc", "root", "");
            String sql = "select * from hodan ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);
            while (resultSet.next()) {

                int idHo = resultSet.getInt("idHo");
                String soNha = resultSet.getString("soNha");

                MyCombo mycbb = new MyCombo(idHo, soNha);
                cbbModel.addElement(mycbb);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    private void showThanhVien() {
        Connection connection = null;
        Statement statement = null;
        tableModel.setRowCount(0);
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qldc", "root", "");
            String sql = "select * from thanhvien inner join hodan on thanhvien.idHo = hodan.idHo order by thanhvien.idHo desc";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);
            Object obj[] = new Object[8];
            while (resultSet.next()) {
                obj[0] = tblThanhVien.getRowCount() + 1;
                obj[1] = resultSet.getInt("IdPerson");
                obj[2] = resultSet.getString("hoTen");
                obj[3] = resultSet.getInt("tuoi");
                obj[4] = resultSet.getInt("namSinh");
                obj[5] = resultSet.getString("ngheNghiep");
                obj[6] = resultSet.getString("soNha");

                tableModel.addRow(obj);
                tblThanhVien.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        if (tblThanhVien.getSelectedRow() >= 0) {
                            txtId.setText(tblThanhVien.getValueAt(tblThanhVien.getSelectedRow(), 1) + "");
                            txtTen.setText(tblThanhVien.getValueAt(tblThanhVien.getSelectedRow(), 2) + "");
                            txtTuoi.setText(tblThanhVien.getValueAt(tblThanhVien.getSelectedRow(), 3) + "");
                            txtSinh.setText(tblThanhVien.getValueAt(tblThanhVien.getSelectedRow(), 4) + "");
                            txtNghe.setText(tblThanhVien.getValueAt(tblThanhVien.getSelectedRow(), 5) + "");
                        }

                    }
                });
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtTuoi = new javax.swing.JTextField();
        txtSinh = new javax.swing.JTextField();
        txtNghe = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThanhVien = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnCap = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboHo = new javax.swing.JComboBox<>();
        btnTim = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        jButton4.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("ID thành viên :");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Họ và tên :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Năm sinh :");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Tuổi :");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Nghề nghiệp :");

        txtId.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtId.setEnabled(false);

        txtTen.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtTuoi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtSinh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtNghe.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        tblThanhVien.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblThanhVien.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblThanhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "ID thành viên", "Họ tên", "Tuổi", "Năm sinh", "Nghề nghiệp", "Số nhà"
            }
        ));
        tblThanhVien.setColumnSelectionAllowed(true);
        tblThanhVien.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tblThanhVien);

        btnThem.setBackground(new java.awt.Color(153, 255, 153));
        btnThem.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add-user (1).png"))); // NOI18N
        btnThem.setText("Thêm mới");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCap.setBackground(new java.awt.Color(255, 255, 102));
        btnCap.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnCap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnCap.setText("Cập nhật");
        btnCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 102, 102));
        btnXoa.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reset.png"))); // NOI18N
        btnReset.setText("Nhập lại");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setText("THÔNG TIN THÀNH VIÊN");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Hộ dân:");

        cboHo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btnTim.setBackground(new java.awt.Color(153, 255, 255));
        btnTim.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnTim.setText("Tìm kiếm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/users_family.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTen)
                                        .addComponent(txtNghe, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboHo, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCap, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCap, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboHo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))
                            .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNghe, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(66, 66, 66)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(jLabel7)
                .addGap(180, 180, 180))
        );

        jLabel9.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 881, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 707, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        String input = JOptionPane.showInputDialog(this, "Nhập họ tên muốn tìm kiếm");
        if (input != null && input.length() > 0) {
            thanhVienList = ThanhVienModify.timKiemTheoTen(input);

            tableModel.setRowCount(0);

            thanhVienList.forEach(hoDan -> {
                tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, hoDan.getIdPerson(), hoDan.getHoTen(),
                    hoDan.getTuoi(), hoDan.getNamSinh(), hoDan.getNgheNghiep(), hoDan.getSoNha()});
            });
        } else {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên thành viên");
            showThanhVien();
        }
        if(tableModel.getRowCount()==0){
            JOptionPane.showMessageDialog(this, "Thành viên có tên '"+input +"' không tồn tại");
            showThanhVien();
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtId.setText("");
        txtTen.setText("");
        txtTuoi.setText("");
        txtSinh.setText("");
        txtNghe.setText("");
        cboHo.setSelectedItem(0);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String kq = "";

        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qldc", "root", "");

            int selectedIndex = tblThanhVien.getSelectedRow();
            if (selectedIndex >= 0) {
                ThanhVien thanhVien = thanhVienList.get(selectedIndex);

                int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa thành viên này ?");
                if (option == 0) {
                    ThanhVienModify.delete(thanhVien.getIdPerson());
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                    kq = "Xóa thành công";
                    showThanhVien();
                }
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        if (!kq.equals("")) {
            int idho;
            MyCombo hochon = (MyCombo) cboHo.getSelectedItem();
            idho = hochon.MaInt();
            String query = "update hodan set soThanhVien = soThanhVien -1 where idHo = " + idho;
            PreparedStatement ps;
            try {
                ps = connection.prepareStatement(query);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Admin_QuanLyThanhVien.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapActionPerformed
        int selectedIndex = tblThanhVien.getSelectedRow();
        if (selectedIndex >= 0) {
            ThanhVien thanhVien = thanhVienList.get(selectedIndex);

            //int id = Integer.parseInt(txtId.getText());
            int t = Integer.parseInt(txtTuoi.getText());
            int ns = Integer.parseInt(txtSinh.getText());
            String nghe = txtNghe.getText();
            String ht = txtTen.getText();
            int idho;
            MyCombo hochon = (MyCombo) cboHo.getSelectedItem();
            idho = hochon.MaInt();

            //thanhVien.setIdPerson(id);
            thanhVien.setHoTen(ht);
            thanhVien.setTuoi(t);
            thanhVien.setNamSinh(ns);
            thanhVien.setNgheNghiep(nghe);
            thanhVien.setIdHo(idho);

            ThanhVienModify.update(thanhVien);
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            showThanhVien();
        }
    }//GEN-LAST:event_btnCapActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        //        StringBuilder sb = new StringBuilder();
        String kq = "";
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qldc", "root", "");

            if (!checkValidateForm()) {
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập đủ thông tin");
            } else {
                String hoTen = txtTen.getText();
                int tuoi = Integer.parseInt(txtTuoi.getText());
                int namSinh = Integer.parseInt(txtSinh.getText());
                String ngheNghiep = txtNghe.getText();
                int idho;
                MyCombo hochon = (MyCombo) cboHo.getSelectedItem();
                idho = hochon.MaInt();

                ThanhVien thanhVien = new ThanhVien(hoTen, tuoi, namSinh, ngheNghiep, idho);

                ThanhVienModify.insert(thanhVien);
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                kq = "Thêm thành công";

            }
            showThanhVien();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        if (!kq.equals("")) {
            int idho;
            MyCombo hochon = (MyCombo) cboHo.getSelectedItem();
            idho = hochon.MaInt();
            String query = "update hodan set soThanhVien = soThanhVien + 1 where idHo = " + idho;
            PreparedStatement ps;
            try {
                ps = connection.prepareStatement(query);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Admin_QuanLyThanhVien.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnThemActionPerformed

    public boolean checkValidateForm() {
        if (txtTen.getText().isEmpty()
                || txtTuoi.getText().isEmpty() || txtSinh.getText().isEmpty()
                || txtNghe.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin_QuanLyThanhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_QuanLyThanhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_QuanLyThanhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_QuanLyThanhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_QuanLyThanhVien().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCap;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboHo;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblThanhVien;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNghe;
    private javax.swing.JTextField txtSinh;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables
}
