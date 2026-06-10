package proyecto_ordinario;

import javax.swing.JOptionPane;

public class CARRITO extends javax.swing.JFrame {
    Double total_f=0.0, iva_f=0.0;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CARRITO.class.getName());

    public CARRITO() {
        initComponents();
        cargarDesdeDB();

        javax.swing.JButton finalizar = new javax.swing.JButton("Finalizar compra");
        finalizar.setBackground(new java.awt.Color(104, 45, 3));
        finalizar.setForeground(java.awt.Color.WHITE);
        finalizar.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 24));
        finalizar.setBorderPainted(false);
        finalizar.setOpaque(true);
        finalizar.addActionListener(e -> finalizarCompra());
        getContentPane().add(finalizar,
            new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 740, 650, 45));
        getContentPane().setComponentZOrder(finalizar, 0);
    }

    public void recalcular() {
        total_f = 0.0;
        resumen.setText("");
        precios.setText("");
        for (java.awt.Component comp : Panel_productos.getComponents()) {
            if (comp instanceof CarritoProducto cp) {
                total_f += Double.parseDouble(cp.subtotal);
                resumen.setText(resumen.getText() + "+ " + cp.nombres + "\n");
                precios.setText(precios.getText() + "$" + cp.subtotal + "\n");
            }
        }
        iva_f = total_f * 0.16;
        IVA.setText(String.format("%.2f", iva_f));
        total.setText(String.format("%.2f", total_f + iva_f));
    }

    private void cargarDesdeDB() {
        resumen.setText("");
        precios.setText("");
        Panel_productos.removeAll();
        total_f = 0.0;
        try {
            java.sql.Connection c = DBConexion.getConexion();
            java.sql.ResultSet rs = c.createStatement().executeQuery(
                "SELECT nombre_producto, subtotal, imagen FROM carrito ORDER BY id");
            while (rs.next()) {
                String nombre  = rs.getString("nombre_producto");
                String subtotal = String.valueOf(rs.getDouble("subtotal"));
                String imagen  = rs.getString("imagen");
                Panel_productos.add(new CarritoProducto(nombre, subtotal, imagen));
                total_f += rs.getDouble("subtotal");
                resumen.setText(resumen.getText() + "+ " + nombre + "\n");
                precios.setText(precios.getText() + "$" + rs.getDouble("subtotal") + "\n");
            }
        } catch (java.sql.SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar carrito: " + e.getMessage());
        }
        iva_f = total_f * 0.16;
        IVA.setText(String.format("%.2f", iva_f));
        total.setText(String.format("%.2f", total_f + iva_f));
        Panel_productos.revalidate();
        Panel_productos.repaint();
    }

    private void finalizarCompra() {
        if (total_f == 0) {
            JOptionPane.showMessageDialog(this, "El carrito está vacío.");
            return;
        }
        try {
            java.sql.Connection c = DBConexion.getConexion();
            java.sql.PreparedStatement psPedido = c.prepareStatement(
                "INSERT INTO pedidos (usuario, total, iva) VALUES (?,?,?)",
                java.sql.Statement.RETURN_GENERATED_KEYS);
            psPedido.setString(1, Sesion.usuario);
            psPedido.setDouble(2, total_f + iva_f);
            psPedido.setDouble(3, iva_f);
            psPedido.executeUpdate();
            java.sql.ResultSet keys = psPedido.getGeneratedKeys();
            keys.next();
            int pedidoId = keys.getInt(1);

            java.sql.PreparedStatement psDetalle = c.prepareStatement(
                "INSERT INTO detalle_pedido (pedido_id, nombre_producto, subtotal, imagen) VALUES (?,?,?,?)");
            java.sql.ResultSet rs = c.createStatement().executeQuery(
                "SELECT nombre_producto, subtotal, imagen FROM carrito");
            while (rs.next()) {
                psDetalle.setInt(1, pedidoId);
                psDetalle.setString(2, rs.getString("nombre_producto"));
                psDetalle.setDouble(3, rs.getDouble("subtotal"));
                psDetalle.setString(4, rs.getString("imagen"));
                psDetalle.addBatch();
            }
            psDetalle.executeBatch();

            c.createStatement().execute("DELETE FROM carrito");
            JOptionPane.showMessageDialog(this,
                "¡Compra finalizada!\nTotal: $" + String.format("%.2f", total_f + iva_f));
            Panel_productos.removeAll();
            Panel_productos.revalidate();
            Panel_productos.repaint();
            total_f = 0.0; iva_f = 0.0;
            IVA.setText("0.00"); total.setText("0.00");
            resumen.setText(""); precios.setText("");
        } catch (java.sql.SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al finalizar: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        Login = new javax.swing.JButton();
        x = new javax.swing.JLabel();
        x1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Panel_productos = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        IVA = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        precios = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        resumen = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Serif", 3, 70)); // NOI18N
        jLabel2.setText("Carrito");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 2, 350, 80));

        Login.setBackground(new java.awt.Color(172, 127, 94));
        Login.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        Login.setForeground(new java.awt.Color(255, 255, 255));
        Login.setText("Log in");
        Login.setPreferredSize(new java.awt.Dimension(140, 50));
        Login.addActionListener(this::LoginActionPerformed);
        getContentPane().add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 15, 300, -1));

        x.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/borde_gris.png"))); // NOI18N
        x.setText("jLabel1");
        getContentPane().add(x, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 733, -1, 100));

        x1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/borde_gris.png"))); // NOI18N
        x1.setText("jLabel1");
        getContentPane().add(x1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/Divisor_menu.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1550, 20));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/Divisor_menu.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 620, 660, 20));

        Panel_productos.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane2.setViewportView(Panel_productos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 630, 520));

        jLabel9.setFont(new java.awt.Font("Serif", 2, 36)); // NOI18N
        jLabel9.setText("IVA");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 640, -1, -1));

        jLabel11.setFont(new java.awt.Font("Serif", 3, 42)); // NOI18N
        jLabel11.setText("Total ");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 690, -1, -1));

        IVA.setFont(new java.awt.Font("Serif", 2, 36)); // NOI18N
        IVA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        IVA.setText("IVA");
        getContentPane().add(IVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 640, 230, -1));

        total.setFont(new java.awt.Font("Serif", 3, 42)); // NOI18N
        total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        total.setText("Total ");
        getContentPane().add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 690, 220, -1));

        jLabel12.setFont(new java.awt.Font("Serif", 3, 48)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("R e s u m e n   d e   c o m p r a");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(836, 160, 660, -1));

        precios.setEditable(false);
        precios.setColumns(20);
        precios.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        precios.setLineWrap(true);
        precios.setRows(5);
        precios.setText("Resumen\n");
        precios.setWrapStyleWord(true);
        precios.setFocusable(false);
        precios.setOpaque(false);
        jScrollPane1.setViewportView(precios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 240, 150, 370));

        resumen.setEditable(false);
        resumen.setColumns(20);
        resumen.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        resumen.setRows(5);
        resumen.setText("Resumen\n");
        resumen.setFocusable(false);
        resumen.setOpaque(false);
        jScrollPane3.setViewportView(resumen);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 240, 460, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        Inicio i= new Inicio();
        i.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LoginActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new CARRITO().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IVA;
    private javax.swing.JButton Login;
    private javax.swing.JPanel Panel_productos;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea precios;
    private javax.swing.JTextArea resumen;
    private javax.swing.JLabel total;
    private javax.swing.JLabel x;
    private javax.swing.JLabel x1;
    // End of variables declaration//GEN-END:variables
}
