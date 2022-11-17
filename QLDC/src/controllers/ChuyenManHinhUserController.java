/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DanhMuc.DanhMucTC;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.UserPage.GuiYKienJPanel;
import view.UserPage.TTNhanKhauJPanel;
import view.UserPage.TrangChuUser;

/**
 *
 * @author Admin
 */
public class ChuyenManHinhUserController {
    private JPanel root;
    private String kindSelected = "";
    private List<DanhMucTC> listItem = null;
    public ChuyenManHinhUserController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) throws ClassNotFoundException {
        kindSelected = "TrangChu";
        jpnItem.setBackground(new Color(96, 100, 191));
        jlbItem.setBackground(new Color(96, 100, 191));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuUser());
        root.validate();
        root.repaint();

    }

    public void setEvent(List<DanhMucTC> listItem){
        this.listItem = listItem;
        for(DanhMucTC item: listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    class LabelEvent implements MouseListener{
        
        private JPanel node;
        private String kind;

        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
      }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
               case "TrangChuNguoiDung":
                {
                    try {
                        node = new TrangChuUser();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ChuyenManHinhController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;
               case "TTNhanKhauND":
                {
                    try {
                        node = new TTNhanKhauJPanel();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ChuyenManHinhController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                   break;
                   
                case "GuiYKien":
                    node = new GuiYKienJPanel();
                    break;

                default:
                {
                    try {
                        node = new TrangChuUser();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ChuyenManHinhUserController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

            }
           root.removeAll();
           root.setLayout(new BorderLayout());
           root.add(node);
           root.validate();
           root.repaint();
           setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(76,175,80));
                jlbItem.setBackground(new Color(76,175,80));
            }
        }
        
    }
    private void setChangeBackground(String kind) {
        for(DanhMucTC item : listItem) {
            if(item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(96,100,191));
                item.getJlb().setBackground(new Color(96,100,191));
            } else {
                item.getJpn().setBackground(new Color(76,175,80));
                item.getJlb().setBackground(new Color(76,175,80));
            }
        }
    }

}
