/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package shoppingoline.View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import shoppingoline.MainJFrame;
import shoppingoline.Service.Impl.MainServiceImpl;
import shoppingoline.Service.MainService;
import shoppingoline.Utils.ActionUtils;
import shoppingoline.model.CartDTO;
import shoppingoline.model.ProductDTO;

/**
 *
 * @author choco
 */
public class CartPanel extends javax.swing.JPanel {

    ActionUtils actionUtils = new ActionUtils();
    JPopupMenu popupMenu = new JPopupMenu();
    DefaultTableModel cartTableModel;
    MainService mainService = new MainServiceImpl();
    String cartSelectedId = "";
    String productSelectedId = "";
    String productSelectedName = "";
    MainJFrame mainJFrame;

    /**
     * Creates new form Cart
     */
    public CartPanel(MainJFrame mainJ) {
        initComponents();
        this.mainJFrame = mainJ;
        cartTableModel = (DefaultTableModel) tableCart.getModel();
        // ẩn cột code(id)
        tableCart.getColumnModel().getColumn(0).setMinWidth(0);
        tableCart.getColumnModel().getColumn(0).setMaxWidth(0);
        tableCart.getColumnModel().getColumn(1).setMinWidth(0);
        tableCart.getColumnModel().getColumn(1).setMaxWidth(0);
        tableCart.getColumnModel().getColumn(2).setMaxWidth(100);
        tableCart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evt) {
                int r = tableCart.rowAtPoint(evt.getPoint());
                if (r >= 0 && r < tableCart.getRowCount()) {
                    tableCart.setRowSelectionInterval(r, r);
                } else {
                    tableCart.clearSelection();
                }
            }

        });

        JMenuItem detailItem = new JMenuItem("Detail ");
        JMenuItem deleteItem = new JMenuItem("Delele ");
        popupMenu.add(detailItem);
        popupMenu.add(deleteItem);
        detailItem.addActionListener((e) -> {
            // chuột phải xem chi tiết
            showDetail();
        });
        deleteItem.addActionListener((e) -> {
            //xóa khỏi giỏ hàng
            deleteProductInCart();
        });

        // fill data into table
        showTable(mainService.getCart(MainJFrame.currentUserId));
        dialogDetail.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                CartPanel.this.mainJFrame.setEnabled(true);
                CartPanel.this.mainJFrame.setVisible(true);
            }
        });

    }

    public void showTable(List<CartDTO> list) {
        cartTableModel.setRowCount(0);
        int no = 1;
        double total = 0.0;
        for (CartDTO lts : list) {
            total += lts.getQuantity() * Double.parseDouble(lts.getPrice());
            cartTableModel.addRow(new Object[]{
                lts.getId(), lts.getProductId(), no++, lts.getProductName(), lts.getQuantity(), lts.getPrice(), actionUtils.doubleToDecimal(lts.getQuantity() * Double.parseDouble(lts.getPrice()))
            });
        }
        txtTotal.setText(actionUtils.doubleToDecimal(total) + "");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogDetail = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        txtDetailImage = new javax.swing.JLabel();
        txtDetailTitle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDetailDesc = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtDetailQuantity = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDetailPrice = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnCheckOut = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCart = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();

        dialogDetail.setAlwaysOnTop(true);
        dialogDetail.setSize(new java.awt.Dimension(800, 600));
        dialogDetail.setType(java.awt.Window.Type.POPUP);

        txtDetailTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDetailTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtDetailDesc.setColumns(20);
        txtDetailDesc.setLineWrap(true);
        txtDetailDesc.setRows(20);
        txtDetailDesc.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtDetailDesc);

        jLabel3.setText("Số lượng còn lại:");

        jLabel4.setText("Đơn giá");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtDetailTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDetailImage, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDetailPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDetailQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDetailTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtDetailImage, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDetailPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtDetailQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(274, 274, 274))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout dialogDetailLayout = new javax.swing.GroupLayout(dialogDetail.getContentPane());
        dialogDetail.getContentPane().setLayout(dialogDetailLayout);
        dialogDetailLayout.setHorizontalGroup(
            dialogDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogDetailLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dialogDetailLayout.setVerticalGroup(
            dialogDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Cart");

        btnCheckOut.setText("Check out all");
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });

        tableCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "productId", "#", "Name", "Quantity", "Price", "Money"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCartMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCart);
        if (tableCart.getColumnModel().getColumnCount() > 0) {
            tableCart.getColumnModel().getColumn(0).setResizable(false);
            tableCart.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel2.setText("Total:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCheckOut)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCheckOut)
                    .addComponent(jLabel2)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
        // thanh toan order\

        if (mainService.transactionCheckOut(MainJFrame.currentUserId)) {
            JOptionPane.showMessageDialog(this, "Checkout success");
            showTable(mainService.getCart(MainJFrame.currentUserId));
        } else {
            JOptionPane.showMessageDialog(this, "Checkout fail");
        }
    }//GEN-LAST:event_btnCheckOutActionPerformed

    private void tableCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCartMouseClicked
        if (SwingUtilities.isRightMouseButton(evt)) {
            cartSelectedId = "";
            productSelectedId = "";
            productSelectedName = "";

            int i = tableCart.getSelectedRow();
            cartSelectedId = cartTableModel.getValueAt(i, 0).toString();
            productSelectedId = cartTableModel.getValueAt(i, 1).toString();
            productSelectedName = cartTableModel.getValueAt(i, 3).toString();

            popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tableCartMouseClicked

    private void showDetail() {

        ProductDTO product = mainService.getProductById(productSelectedId);
        txtDetailTitle.setText(product.getTitle());
        txtDetailQuantity.setText(product.getQuantity() + "");
        txtDetailPrice.setText(product.getPrice() + "");
        actionUtils.fillImageOnline(product.getUrlImage(), txtDetailImage, 600, 400);
        txtDetailDesc.setText(product.getDesc());
        dialogDetail.setLocation(this.getLocation());
        dialogDetail.setVisible(true);
        this.mainJFrame.setEnabled(false);
    }

    private void deleteProductInCart() {

        int opt = JOptionPane.showConfirmDialog(null, "Bạn có chắc xoá sản phẩm ' " + productSelectedName + " ' không?", "Xoá sản phẩm", JOptionPane.YES_NO_OPTION);
        if (opt == JOptionPane.YES_OPTION) {
            // Integer total = SPController.getTotalSPDetail(codeSPDetailS.substring(0, 32));
            if (mainService.deleteItemCart(cartSelectedId)) {
                JOptionPane.showMessageDialog(null, "Xoá sản phẩm thành công");

                showTable(mainService.getCart(MainJFrame.currentUserId));
            } else {
                JOptionPane.showMessageDialog(null, "Xoá sản phẩm thất bại");
            }

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JDialog dialogDetail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableCart;
    private javax.swing.JTextArea txtDetailDesc;
    private javax.swing.JLabel txtDetailImage;
    private javax.swing.JLabel txtDetailPrice;
    private javax.swing.JLabel txtDetailQuantity;
    private javax.swing.JLabel txtDetailTitle;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
