
import java.io.File;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Johami
 */
public class MenuPokemon extends javax.swing.JFrame {

    /**
     * Creates new form MenuPokemon
     */
    public MenuPokemon() {
        initComponents();
        String gifRuta = "gifs/pikachu-saltando.gif";
        String imgRuta = "imgs/Pokebatalla-Titulo.png";
    
    // Cargar el GIF
    ImageIcon gifIcon = new ImageIcon(gifRuta);
    lblImagenMenu.setIcon(gifIcon); // Asigna el GIF a lblImagenMenu
    
    // Cargar el icono de título
    ImageIcon tituloIcon = new ImageIcon(imgRuta);
    lblTituloPokemon.setIcon(tituloIcon); // Asigna la im

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFondo = new javax.swing.JPanel();
        lblTituloMenu1 = new javax.swing.JLabel();
        lblImagenMenu = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        lblTituloPokemon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(211, 237, 234));
        setPreferredSize(new java.awt.Dimension(600, 500));

        lblFondo.setBackground(new java.awt.Color(211, 237, 234));
        lblFondo.setPreferredSize(new java.awt.Dimension(600, 500));

        lblTituloMenu1.setBackground(new java.awt.Color(211, 237, 234));
        lblTituloMenu1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        lblTituloMenu1.setForeground(new java.awt.Color(0, 60, 114));
        lblTituloMenu1.setText("Bienvenid@ a...");

        jComboBox1.setEditable(true);
        jComboBox1.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Iniciar Batalla", "Gestionar Pokemones", "Entrenas Pokemones" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lblFondoLayout = new javax.swing.GroupLayout(lblFondo);
        lblFondo.setLayout(lblFondoLayout);
        lblFondoLayout.setHorizontalGroup(
            lblFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblFondoLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(lblImagenMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
            .addGroup(lblFondoLayout.createSequentialGroup()
                .addGroup(lblFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblFondoLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(lblTituloMenu1))
                    .addGroup(lblFondoLayout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(lblTituloPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lblFondoLayout.setVerticalGroup(
            lblFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblFondoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblTituloMenu1)
                .addGap(18, 18, 18)
                .addComponent(lblTituloPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(lblFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImagenMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(105, 105, 105))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPokemon().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel lblFondo;
    private javax.swing.JLabel lblImagenMenu;
    private javax.swing.JLabel lblTituloMenu1;
    private javax.swing.JLabel lblTituloPokemon;
    // End of variables declaration//GEN-END:variables
}