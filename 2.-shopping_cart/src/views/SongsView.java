/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;


//import static views.ListPanel.getRandomJPanel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

import controllers.SongsController;
import model.Product;
import network.PackageNotReceivedException;
import network.PackageNotSentException;
import session.Session;


/**
 *
 * @author angel
 */
public class SongsView extends javax.swing.JFrame {
    private final SongsController songsController;

    /**
     * Creates new form Songs
     */
    public SongsView() {
        initComponents();
        setVisible(true);
        final ListPanel listPanel = new ListPanel();
        songsController = new SongsController();
//        userLabel.setText("Hello " + songsController.getUser());


//        SongView sv = new SongView(product);
//        SongView sv1 = new SongView(product);
//        SongView sv2 = new SongView(product);
//        JPanel panel = sv.getPanel();
//        panel.setBackground(new Color(new Random().nextFloat(), new Random().nextFloat(), new Random().nextFloat()));
//        listPanel.addPanel(sv.getPanel());
//        listPanel.addPanel(sv1.getPanel());
//        listPanel.addPanel(sv2.getPanel());
//        this.scrollPanel.setViewportView(listPanel);
        try {
            loadingField.setVisible(true);
            List<Product> songs = songsController.getSongs();
            songs.forEach(song -> {
                SongInCatalogueView sv = new SongInCatalogueView(song, new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        addToCartActionPerformed(evt, song);
                    }
                });
                JPanel panel = sv.getPanel();
                sv.setBackground(new Color(new Random().nextFloat(), new Random().nextFloat(), new Random().nextFloat()));
                listPanel.addPanel(panel);
            });
            this.scrollPanel.setViewportView(listPanel);
            loadingField.setVisible(false);
            userLabel.setText("User: " + songsController.getUser());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (PackageNotSentException e) {
            throw new RuntimeException(e);
        } catch (PackageNotReceivedException e) {
            throw new RuntimeException(e);
        }
    }

    private void addToCartActionPerformed(java.awt.event.ActionEvent evt, Product song) {
        System.out.println("Clicked");
        songsController.addToCart(song);
        JOptionPane.showMessageDialog(goToCartButton, "Product added to cart");
    }
    private void cartButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        CartView cartView = new CartView();
        cartView.setVisible(true);
    }

    private void transactionsButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        TransactionsView transactionsView = new TransactionsView();
        transactionsView.setVisible(true);
    }

    private void logoutButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        Session.getInstance().clearSession();
        Login loginView = new Login();
        loginView.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        goToCartButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        scrollPanel = new javax.swing.JScrollPane();
        userLabel = new javax.swing.JLabel();
        loadingField = new javax.swing.JLabel();
        transactionsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Songs");

        goToCartButton.setText("Cart");

        logoutButton.setText("Logout");

        userLabel.setText("User:");

        loadingField.setText("Loading...");

        goToCartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartButton1ActionPerformed(evt);
            }
        });

        transactionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionsButton1ActionPerformed(evt);
            }
        });

        transactionsButton.setText("Transactions");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPanel)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loadingField)
                            .addComponent(userLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(transactionsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(goToCartButton)
                        .addGap(4, 4, 4)
                        .addComponent(logoutButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(goToCartButton)
                            .addComponent(logoutButton)
                            .addComponent(transactionsButton)
                            .addComponent(jLabel1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(userLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadingField)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(SongsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SongsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SongsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SongsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SongsView().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton goToCartButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loadingField;
    private javax.swing.JButton logoutButton;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JButton transactionsButton;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
