package proyecto_ordinario;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BEBIDAS extends javax.swing.JFrame {
    int contadorg=0,contadorm=0,contadorp=0;
    double G=0,M=0,P=0,ctotal=0;
    String imagen;
    JFrame f;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(BEBIDAS.class.getName());

    /**
     * Creates new form PRODUCTO
     */
    public BEBIDAS() {
        initComponents();
    }
    
    public BEBIDAS(String nombre, String descripcion, double preciog, double preciom, double preciop,String imagen, JFrame frame) {
        initComponents();
        producto_label.setText(nombre);
        descripcion_label.setText("<html><p style='width:1470px;'>"+descripcion+"</p></html>");
        preciog_l.setText(""+preciog);
        preciom_l.setText(""+preciom);
        preciop_l.setText(""+preciop);
        G=preciog;
        M=preciom;
        P=preciop;
        f=frame;
        this.imagen=imagen;
        FONDO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/"+imagen)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        preciog_l1 = new javax.swing.JLabel();
        preciom_l1 = new javax.swing.JLabel();
        preciop_l1 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        producto_label = new javax.swing.JLabel();
        descripcion = new javax.swing.JLabel();
        descripcion_label1 = new javax.swing.JLabel();
        volver = new javax.swing.JButton();
        descripcion14 = new javax.swing.JLabel();
        COMPRAR = new javax.swing.JButton();
        descripcion2 = new javax.swing.JLabel();
        descripcion_label = new javax.swing.JLabel();
        Gsuma = new javax.swing.JButton();
        ContadorG = new javax.swing.JLabel();
        Gresta = new javax.swing.JButton();
        Presta = new javax.swing.JButton();
        ContadorP = new javax.swing.JLabel();
        Psuma = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        descripcion3 = new javax.swing.JLabel();
        descripcion4 = new javax.swing.JLabel();
        preciog_l = new javax.swing.JLabel();
        preciom_l = new javax.swing.JLabel();
        preciop_l = new javax.swing.JLabel();
        descripcion8 = new javax.swing.JLabel();
        descripcion9 = new javax.swing.JLabel();
        descripcion10 = new javax.swing.JLabel();
        descripcion12 = new javax.swing.JLabel();
        descripcion13 = new javax.swing.JLabel();
        Mresta = new javax.swing.JButton();
        ContadorM = new javax.swing.JLabel();
        Msuma = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        descripcion11 = new javax.swing.JLabel();
        VERDE = new javax.swing.JLabel();
        FONDO = new javax.swing.JLabel();
        COMPRAR1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preciog_l1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        preciog_l1.setForeground(new java.awt.Color(255, 255, 255));
        preciog_l1.setText("$");
        getContentPane().add(preciog_l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 610, -1, -1));

        preciom_l1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        preciom_l1.setForeground(new java.awt.Color(255, 255, 255));
        preciom_l1.setText("$");
        getContentPane().add(preciom_l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 670, -1, -1));

        preciop_l1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        preciop_l1.setForeground(new java.awt.Color(255, 255, 255));
        preciop_l1.setText("$");
        getContentPane().add(preciop_l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 730, -1, -1));

        total.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        total.setForeground(new java.awt.Color(255, 255, 255));
        total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        total.setText("00.00");
        total.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                totalFocusGained(evt);
            }
        });
        getContentPane().add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 645, 200, 80));

        producto_label.setFont(new java.awt.Font("Serif", 3, 70)); // NOI18N
        producto_label.setForeground(new java.awt.Color(255, 255, 255));
        producto_label.setText("PRODUCTO");
        getContentPane().add(producto_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 1470, 80));

        descripcion.setFont(new java.awt.Font("Times New Roman", 1, 55)); // NOI18N
        descripcion.setForeground(new java.awt.Color(255, 255, 255));
        descripcion.setText("Tamaño");
        getContentPane().add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, -1, -1));

        descripcion_label1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        descripcion_label1.setForeground(new java.awt.Color(255, 255, 255));
        descripcion_label1.setText("Volver");
        descripcion_label1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        descripcion_label1.setPreferredSize(new java.awt.Dimension(1470, 100));
        descripcion_label1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        descripcion_label1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                descripcion_label1FocusGained(evt);
            }
        });
        getContentPane().add(descripcion_label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 110, 40));

        volver.setBackground(new java.awt.Color(114, 141, 141));
        volver.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        volver.setForeground(new java.awt.Color(255, 255, 255));
        volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/volver_producto.png"))); // NOI18N
        volver.setBorderPainted(false);
        volver.setContentAreaFilled(false);
        volver.setFocusPainted(false);
        volver.addActionListener(this::volverActionPerformed);
        getContentPane().add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 100));

        descripcion14.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        descripcion14.setForeground(new java.awt.Color(255, 255, 255));
        descripcion14.setText("Añadir al carrito   $");
        descripcion14.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                descripcion14FocusGained(evt);
            }
        });
        getContentPane().add(descripcion14, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 645, -1, 80));

        COMPRAR.setBackground(new java.awt.Color(114, 141, 141));
        COMPRAR.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        COMPRAR.setForeground(new java.awt.Color(255, 255, 255));
        COMPRAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/BOTON_COMPRAR.png"))); // NOI18N
        COMPRAR.setBorderPainted(false);
        COMPRAR.setContentAreaFilled(false);
        COMPRAR.addActionListener(this::COMPRARActionPerformed);
        getContentPane().add(COMPRAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 640, 500, -1));

        descripcion2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        descripcion2.setForeground(new java.awt.Color(255, 255, 255));
        descripcion2.setText("Pequeño");
        getContentPane().add(descripcion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 730, -1, -1));

        descripcion_label.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        descripcion_label.setForeground(new java.awt.Color(255, 255, 255));
        descripcion_label.setText("Descripcion");
        descripcion_label.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        descripcion_label.setPreferredSize(new java.awt.Dimension(1470, 100));
        descripcion_label.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(descripcion_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));

        Gsuma.setBackground(new java.awt.Color(114, 141, 141));
        Gsuma.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        Gsuma.setForeground(new java.awt.Color(255, 255, 255));
        Gsuma.setText("+");
        Gsuma.setBorderPainted(false);
        Gsuma.setContentAreaFilled(false);
        Gsuma.addActionListener(this::GsumaActionPerformed);
        getContentPane().add(Gsuma, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 610, 60, 40));

        ContadorG.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        ContadorG.setForeground(new java.awt.Color(255, 255, 255));
        ContadorG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ContadorG.setText("0");
        getContentPane().add(ContadorG, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 610, 50, -1));

        Gresta.setBackground(new java.awt.Color(114, 141, 141));
        Gresta.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        Gresta.setForeground(new java.awt.Color(255, 255, 255));
        Gresta.setText("-");
        Gresta.setBorderPainted(false);
        Gresta.setContentAreaFilled(false);
        Gresta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Gresta.addActionListener(this::GrestaActionPerformed);
        getContentPane().add(Gresta, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 610, 50, 40));

        Presta.setBackground(new java.awt.Color(114, 141, 141));
        Presta.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        Presta.setForeground(new java.awt.Color(255, 255, 255));
        Presta.setText("-");
        Presta.setBorderPainted(false);
        Presta.setContentAreaFilled(false);
        Presta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Presta.addActionListener(this::PrestaActionPerformed);
        getContentPane().add(Presta, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 730, 50, 40));

        ContadorP.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        ContadorP.setForeground(new java.awt.Color(255, 255, 255));
        ContadorP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ContadorP.setText("0");
        getContentPane().add(ContadorP, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 730, 50, -1));

        Psuma.setBackground(new java.awt.Color(114, 141, 141));
        Psuma.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        Psuma.setForeground(new java.awt.Color(255, 255, 255));
        Psuma.setText("+");
        Psuma.setBorderPainted(false);
        Psuma.setContentAreaFilled(false);
        Psuma.addActionListener(this::PsumaActionPerformed);
        getContentPane().add(Psuma, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 730, 60, 40));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/linea_productos.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 1550, 20));

        descripcion3.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        descripcion3.setForeground(new java.awt.Color(255, 255, 255));
        descripcion3.setText("Mediano");
        getContentPane().add(descripcion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 670, -1, -1));

        descripcion4.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        descripcion4.setForeground(new java.awt.Color(255, 255, 255));
        descripcion4.setText("Grande");
        getContentPane().add(descripcion4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, -1, -1));

        preciog_l.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        preciog_l.setForeground(new java.awt.Color(255, 255, 255));
        preciog_l.setText("00.00");
        getContentPane().add(preciog_l, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 610, -1, -1));

        preciom_l.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        preciom_l.setForeground(new java.awt.Color(255, 255, 255));
        preciom_l.setText("00.00");
        getContentPane().add(preciom_l, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 670, -1, -1));

        preciop_l.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        preciop_l.setForeground(new java.awt.Color(255, 255, 255));
        preciop_l.setText("00.00");
        getContentPane().add(preciop_l, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 730, -1, -1));

        descripcion8.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        descripcion8.setForeground(new java.awt.Color(255, 255, 255));
        descripcion8.setText("700ml");
        getContentPane().add(descripcion8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 610, -1, -1));

        descripcion9.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        descripcion9.setForeground(new java.awt.Color(255, 255, 255));
        descripcion9.setText("500ml");
        getContentPane().add(descripcion9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 670, -1, -1));

        descripcion10.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        descripcion10.setForeground(new java.awt.Color(255, 255, 255));
        descripcion10.setText("300ml");
        getContentPane().add(descripcion10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 730, -1, -1));

        descripcion12.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        descripcion12.setForeground(new java.awt.Color(255, 255, 255));
        descripcion12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/cantidad_producto.png"))); // NOI18N
        descripcion12.setToolTipText("");
        getContentPane().add(descripcion12, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 610, -1, -1));

        descripcion13.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        descripcion13.setForeground(new java.awt.Color(255, 255, 255));
        descripcion13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/cantidad_producto.png"))); // NOI18N
        descripcion13.setToolTipText("");
        getContentPane().add(descripcion13, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 730, -1, -1));

        Mresta.setBackground(new java.awt.Color(114, 141, 141));
        Mresta.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        Mresta.setForeground(new java.awt.Color(255, 255, 255));
        Mresta.setText("-");
        Mresta.setBorderPainted(false);
        Mresta.setContentAreaFilled(false);
        Mresta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Mresta.addActionListener(this::MrestaActionPerformed);
        getContentPane().add(Mresta, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 670, 50, 40));

        ContadorM.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        ContadorM.setForeground(new java.awt.Color(255, 255, 255));
        ContadorM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ContadorM.setText("0");
        getContentPane().add(ContadorM, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 670, 50, -1));

        Msuma.setBackground(new java.awt.Color(114, 141, 141));
        Msuma.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        Msuma.setForeground(new java.awt.Color(255, 255, 255));
        Msuma.setText("+");
        Msuma.setBorderPainted(false);
        Msuma.setContentAreaFilled(false);
        Msuma.addActionListener(this::MsumaActionPerformed);
        getContentPane().add(Msuma, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 670, 60, 40));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 210, 80));

        descripcion11.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        descripcion11.setForeground(new java.awt.Color(255, 255, 255));
        descripcion11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/cantidad_producto.png"))); // NOI18N
        descripcion11.setToolTipText("");
        getContentPane().add(descripcion11, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 670, -1, -1));

        VERDE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VERDE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/verde_productos.png"))); // NOI18N
        getContentPane().add(VERDE, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 340, 1570, 470));
        getContentPane().add(FONDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1550, 810));

        COMPRAR1.setBackground(new java.awt.Color(114, 141, 141));
        COMPRAR1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        COMPRAR1.setForeground(new java.awt.Color(255, 255, 255));
        COMPRAR1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/BOTON_COMPRAR.png"))); // NOI18N
        COMPRAR1.setBorderPainted(false);
        COMPRAR1.setContentAreaFilled(false);
        COMPRAR1.addActionListener(this::COMPRAR1ActionPerformed);
        getContentPane().add(COMPRAR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 640, 500, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GsumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GsumaActionPerformed
        contadorg++;
        ContadorG.setText(contadorg+"");
        ctotal+=G;
        total.setText(""+ctotal);
    }//GEN-LAST:event_GsumaActionPerformed

    private void GrestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GrestaActionPerformed
        if (contadorg>0){
            contadorg--;
            ContadorG.setText(contadorg+"");
            ctotal-=G;
            total.setText(""+ctotal);
        }
    }//GEN-LAST:event_GrestaActionPerformed

    private void MrestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MrestaActionPerformed
        if (contadorm>0){
            contadorm--;
            ContadorM.setText(contadorm+"");
            ctotal-=M;
        total.setText(""+ctotal);
        }
    }//GEN-LAST:event_MrestaActionPerformed

    private void MsumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MsumaActionPerformed
        contadorm++;
        ContadorM.setText(contadorm+"");
        ctotal+=M;
        total.setText(""+ctotal);
    }//GEN-LAST:event_MsumaActionPerformed

    private void PrestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrestaActionPerformed
        if (contadorp>0){
            contadorp--;
            ContadorP.setText(contadorp+"");
            ctotal-=P;
        total.setText(""+ctotal);
        }
    }//GEN-LAST:event_PrestaActionPerformed

    private void PsumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PsumaActionPerformed
        contadorp++;
        ContadorP.setText(contadorp+"");
        ctotal+=P;
        total.setText(""+ctotal);
    }//GEN-LAST:event_PsumaActionPerformed

    private void COMPRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_COMPRARActionPerformed
        if (ctotal != 0) {
            String imgCarrito;
            if (imagen.charAt(2) == '.') {
                imgCarrito = "b" + imagen.charAt(1) + ".png";
            } else {
                imgCarrito = "b" + imagen.charAt(1) + imagen.charAt(2) + ".png";
            }
            try {
                java.sql.Connection c = DBConexion.getConexion();
                java.sql.PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO carrito (nombre_producto, subtotal, imagen) VALUES (?,?,?)");
                ps.setString(1, producto_label.getText());
                ps.setDouble(2, Double.parseDouble(total.getText()));
                ps.setString(3, imgCarrito);
                ps.executeUpdate();
            } catch (java.sql.SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al agregar al carrito: " + e.getMessage());
            }
            f.setEnabled(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No tiene productos seleccionados");
        }
    }//GEN-LAST:event_COMPRARActionPerformed

    private void COMPRAR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_COMPRAR1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_COMPRAR1ActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
       f.setEnabled(true);
       this.dispose();
       
    }//GEN-LAST:event_volverActionPerformed

    private void descripcion_label1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descripcion_label1FocusGained
        volver.doClick();
    }//GEN-LAST:event_descripcion_label1FocusGained

    private void totalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_totalFocusGained
        COMPRAR.doClick();
    }//GEN-LAST:event_totalFocusGained

    private void descripcion14FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descripcion14FocusGained
        COMPRAR.doClick();
        
    }//GEN-LAST:event_descripcion14FocusGained

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new BEBIDAS().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton COMPRAR;
    private javax.swing.JButton COMPRAR1;
    private javax.swing.JLabel ContadorG;
    private javax.swing.JLabel ContadorM;
    private javax.swing.JLabel ContadorP;
    private javax.swing.JLabel FONDO;
    private javax.swing.JButton Gresta;
    private javax.swing.JButton Gsuma;
    private javax.swing.JButton Mresta;
    private javax.swing.JButton Msuma;
    private javax.swing.JButton Presta;
    private javax.swing.JButton Psuma;
    private javax.swing.JLabel VERDE;
    private javax.swing.JLabel descripcion;
    private javax.swing.JLabel descripcion10;
    private javax.swing.JLabel descripcion11;
    private javax.swing.JLabel descripcion12;
    private javax.swing.JLabel descripcion13;
    private javax.swing.JLabel descripcion14;
    private javax.swing.JLabel descripcion2;
    private javax.swing.JLabel descripcion3;
    private javax.swing.JLabel descripcion4;
    private javax.swing.JLabel descripcion8;
    private javax.swing.JLabel descripcion9;
    private javax.swing.JLabel descripcion_label;
    private javax.swing.JLabel descripcion_label1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel preciog_l;
    private javax.swing.JLabel preciog_l1;
    private javax.swing.JLabel preciom_l;
    private javax.swing.JLabel preciom_l1;
    private javax.swing.JLabel preciop_l;
    private javax.swing.JLabel preciop_l1;
    private javax.swing.JLabel producto_label;
    private javax.swing.JLabel total;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
