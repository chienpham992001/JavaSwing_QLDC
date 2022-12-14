/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.AdminPage;
import DanhMuc.DanhMucTC;
import controllers.ChuyenManHinhController;
import controllers.YKienModify;
import java.util.ArrayList;
import java.util.List;
import javax.mail.Message;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import models.YKien;
/**
 *
 * @author Asus
 */
public class XemYKienJPanel extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    

    List<YKien> yKienList = new ArrayList<>();
    /**
     * Creates new form XemYKien
     */
    public XemYKienJPanel() {
        initComponents();
        tableModel = (DefaultTableModel) tblYKien.getModel();
        
        showYKien();
        
    }
private void showYKien() {
        yKienList = YKienModify.findAll();

        tableModel.setRowCount(0);

        yKienList.forEach(yKien -> {
            tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, yKien.getIdHo(),
                yKien.getThoigian(), yKien.getTieude(), yKien.getNoidung()});
        });
            tblYKien.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tblYKien.getSelectedRow() >= 0) {
                    txtTest.setText(tblYKien.getValueAt(tblYKien.getSelectedRow(), 1) + "");
                }
            }
            
        });
            
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblYKien = new javax.swing.JTable();
        btnPhanHoi = new javax.swing.JButton();
        txtTest = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(640, 464));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setText("?? ki???n c???a ng?????i d??n");

        tblYKien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "ID H??? d??n", "Th???i gian", "Ti??u ?????", "N???i dung"
            }
        ));
        jScrollPane1.setViewportView(tblYKien);

        btnPhanHoi.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnPhanHoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/phanhoi.png"))); // NOI18N
        btnPhanHoi.setText("Ph???n h???i ?? ki???n");
        btnPhanHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhanHoiActionPerformed(evt);
            }
        });

        txtTest.setForeground(new java.awt.Color(255, 255, 255));
        txtTest.setBorder(null);
        txtTest.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtTest.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel1))
                    .addComponent(btnPhanHoi)
                    .addComponent(txtTest, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(txtTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPhanHoi)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPhanHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhanHoiActionPerformed
        // TODO add your handling code here:
//       PhanHoiYKien p = new PhanHoiYKien();
//       p.setVisible(true);
        
        if(txtTest.getText()==""){
            GuiPhanHoi_JFrame g = new GuiPhanHoi_JFrame();
            g.setVisible(true);
        }
        else {
            int s = Integer.parseInt(txtTest.getText());
            GuiPhanHoi_JFrame g = new GuiPhanHoi_JFrame(s);
            g.setVisible(true);
        }
        
    }//GEN-LAST:event_btnPhanHoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPhanHoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblYKien;
    private javax.swing.JTextField txtTest;
    // End of variables declaration//GEN-END:variables
}
