
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
import view.AdminPage.HoDan;
import view.AdminPage.QuanLyThanhVien;
import view.AdminPage.SendEmailJPanel;
import view.AdminPage.TrangChuAdmin;
import view.AdminPage.XemYKienJPanel;
import view.UserPage.TTNhanKhauJPanel;
import view.UserPage.TrangChuUser;

/**
 *
 * @author Admin
 */
public class ChuyenManHinhController {
    private JPanel root;
    private String kindSelected = "";
    private List<DanhMucTC> listItem = null;
    public ChuyenManHinhController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "TrangChu";
        jpnItem.setBackground(new Color(96, 100, 191));
        jlbItem.setBackground(new Color(96, 100, 191));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuAdmin());
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
                case "TrangChu":
                    node = new TrangChuAdmin();
                    break;
                case "NhanKhau":
                    node = new QuanLyThanhVien();
                    break;
                case "HoKhau":
                    node = new HoDan();
                    break;
          
                case "YKien":
                    node = new XemYKienJPanel();
                    break;
                case "Email":
                    node = new SendEmailJPanel();
                    break;
                default:
                    node = new TrangChuAdmin();
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
