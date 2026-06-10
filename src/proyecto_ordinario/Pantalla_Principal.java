/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto_ordinario;

/**
 *
 * @author Ganda
 */
public class Pantalla_Principal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Pantalla_Principal.class.getName());

    public Pantalla_Principal(boolean invitado) {
        initComponents();
        if(!invitado){
            Login.setVisible(false);
        }
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    public Pantalla_Principal() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        carrito = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Login = new javax.swing.JButton();
        x = new javax.swing.JLabel();
        x1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bebida2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        bebida1 = new javax.swing.JButton();
        bebida3 = new javax.swing.JButton();
        bebida4 = new javax.swing.JButton();
        bebida5 = new javax.swing.JButton();
        bebida6 = new javax.swing.JButton();
        bebida7 = new javax.swing.JButton();
        bebida8 = new javax.swing.JButton();
        bebida9 = new javax.swing.JButton();
        bebida10 = new javax.swing.JButton();
        bebida11 = new javax.swing.JButton();
        bebida12 = new javax.swing.JButton();
        bebida13 = new javax.swing.JButton();
        bebida14 = new javax.swing.JButton();
        bebida15 = new javax.swing.JButton();
        bebida16 = new javax.swing.JButton();
        bebida17 = new javax.swing.JButton();
        bebida18 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        alimento13 = new javax.swing.JButton();
        alimento14 = new javax.swing.JButton();
        alimento9 = new javax.swing.JButton();
        alimento10 = new javax.swing.JButton();
        alimento11 = new javax.swing.JButton();
        alimento12 = new javax.swing.JButton();
        alimento5 = new javax.swing.JButton();
        alimento6 = new javax.swing.JButton();
        alimento7 = new javax.swing.JButton();
        alimento8 = new javax.swing.JButton();
        alimento3 = new javax.swing.JButton();
        alimento4 = new javax.swing.JButton();
        alimento2 = new javax.swing.JButton();
        alimento1 = new javax.swing.JButton();
        BLANCO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Serif", 0, 36)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/carrito.png"))); // NOI18N
        jLabel13.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabel13FocusGained(evt);
            }
        });
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 90, 40, 50));

        jLabel12.setFont(new java.awt.Font("Serif", 0, 36)); // NOI18N
        jLabel12.setText("Ver carrito");
        jLabel12.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabel12FocusGained(evt);
            }
        });
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 90, -1, -1));

        carrito.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        carrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/boton_carrito.png"))); // NOI18N
        carrito.setBorderPainted(false);
        carrito.setContentAreaFilled(false);
        carrito.setFocusPainted(false);
        carrito.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        carrito.setPreferredSize(new java.awt.Dimension(140, 50));
        carrito.addActionListener(this::carritoActionPerformed);
        getContentPane().add(carrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 80, 300, 70));

        jLabel5.setFont(new java.awt.Font("Serif", 0, 36)); // NOI18N
        jLabel5.setText("¡Disfrutalos! Conoce nuestros alimentos y bebidas");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Serif", 3, 70)); // NOI18N
        jLabel2.setText("Menú");
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
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1550, 20));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/Divisor_menu.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 1550, 20));

        bebida2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/b2.png"))); // NOI18N
        bebida2.setBorderPainted(false);
        bebida2.setContentAreaFilled(false);
        bebida2.setFocusPainted(false);
        bebida2.addActionListener(this::bebida2ActionPerformed);
        getContentPane().add(bebida2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, -1));

        jLabel8.setFont(new java.awt.Font("Serif", 2, 36)); // NOI18N
        jLabel8.setText("Bebidas");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        bebida1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/Circulo_producto_externo.png"))); // NOI18N
        bebida1.setBorderPainted(false);
        bebida1.setContentAreaFilled(false);
        bebida1.setFocusPainted(false);
        bebida1.addActionListener(this::bebida1ActionPerformed);
        getContentPane().add(bebida1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        bebida3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/b4.png"))); // NOI18N
        bebida3.setBorderPainted(false);
        bebida3.setContentAreaFilled(false);
        bebida3.setFocusPainted(false);
        bebida3.addActionListener(this::bebida3ActionPerformed);
        getContentPane().add(bebida3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, -1, -1));

        bebida4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/b3.png"))); // NOI18N
        bebida4.setBorderPainted(false);
        bebida4.setContentAreaFilled(false);
        bebida4.setFocusPainted(false);
        bebida4.addActionListener(this::bebida4ActionPerformed);
        getContentPane().add(bebida4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, -1, -1));

        bebida5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/b6.png"))); // NOI18N
        bebida5.setBorderPainted(false);
        bebida5.setContentAreaFilled(false);
        bebida5.setFocusPainted(false);
        bebida5.addActionListener(this::bebida5ActionPerformed);
        getContentPane().add(bebida5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 210, -1, -1));

        bebida6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/b5.png"))); // NOI18N
        bebida6.setBorderPainted(false);
        bebida6.setContentAreaFilled(false);
        bebida6.setFocusPainted(false);
        bebida6.addActionListener(this::bebida6ActionPerformed);
        getContentPane().add(bebida6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, -1, -1));

        bebida7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/b8.png"))); // NOI18N
        bebida7.setBorderPainted(false);
        bebida7.setContentAreaFilled(false);
        bebida7.setFocusPainted(false);
        bebida7.addActionListener(this::bebida7ActionPerformed);
        getContentPane().add(bebida7, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 210, -1, -1));

        bebida8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/b7.png"))); // NOI18N
        bebida8.setBorderPainted(false);
        bebida8.setContentAreaFilled(false);
        bebida8.setFocusPainted(false);
        bebida8.addActionListener(this::bebida8ActionPerformed);
        getContentPane().add(bebida8, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 210, -1, -1));

        bebida9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/b10.png"))); // NOI18N
        bebida9.setBorderPainted(false);
        bebida9.setContentAreaFilled(false);
        bebida9.setFocusPainted(false);
        bebida9.addActionListener(this::bebida9ActionPerformed);
        getContentPane().add(bebida9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 210, -1, -1));

        bebida10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/b9.png"))); // NOI18N
        bebida10.setBorderPainted(false);
        bebida10.setContentAreaFilled(false);
        bebida10.setFocusPainted(false);
        bebida10.addActionListener(this::bebida10ActionPerformed);
        getContentPane().add(bebida10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 210, -1, -1));

        bebida11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/b12.png"))); // NOI18N
        bebida11.setBorderPainted(false);
        bebida11.setContentAreaFilled(false);
        bebida11.setFocusPainted(false);
        bebida11.addActionListener(this::bebida11ActionPerformed);
        getContentPane().add(bebida11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 210, -1, -1));

        bebida12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/b11.png"))); // NOI18N
        bebida12.setBorderPainted(false);
        bebida12.setContentAreaFilled(false);
        bebida12.setFocusPainted(false);
        bebida12.addActionListener(this::bebida12ActionPerformed);
        getContentPane().add(bebida12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 210, -1, -1));

        bebida13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/b14.png"))); // NOI18N
        bebida13.setBorderPainted(false);
        bebida13.setContentAreaFilled(false);
        bebida13.setFocusPainted(false);
        bebida13.addActionListener(this::bebida13ActionPerformed);
        getContentPane().add(bebida13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, -1, -1));

        bebida14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/b13.png"))); // NOI18N
        bebida14.setBorderPainted(false);
        bebida14.setContentAreaFilled(false);
        bebida14.setFocusPainted(false);
        bebida14.addActionListener(this::bebida14ActionPerformed);
        getContentPane().add(bebida14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        bebida15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/b16.png"))); // NOI18N
        bebida15.setBorderPainted(false);
        bebida15.setContentAreaFilled(false);
        bebida15.setFocusPainted(false);
        bebida15.addActionListener(this::bebida15ActionPerformed);
        getContentPane().add(bebida15, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, -1, -1));

        bebida16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/b15.png"))); // NOI18N
        bebida16.setBorderPainted(false);
        bebida16.setContentAreaFilled(false);
        bebida16.setFocusPainted(false);
        bebida16.addActionListener(this::bebida16ActionPerformed);
        getContentPane().add(bebida16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, -1, -1));

        bebida17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/b18.png"))); // NOI18N
        bebida17.setBorderPainted(false);
        bebida17.setContentAreaFilled(false);
        bebida17.setFocusPainted(false);
        bebida17.addActionListener(this::bebida17ActionPerformed);
        getContentPane().add(bebida17, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 330, -1, -1));

        bebida18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/b17.png"))); // NOI18N
        bebida18.setBorderPainted(false);
        bebida18.setContentAreaFilled(false);
        bebida18.setFocusPainted(false);
        bebida18.addActionListener(this::bebida18ActionPerformed);
        getContentPane().add(bebida18, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, -1, -1));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/Divisor_menu.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 1550, 20));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/Divisor_menu.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 1550, 20));

        jLabel11.setFont(new java.awt.Font("Serif", 2, 36)); // NOI18N
        jLabel11.setText("Alimentos");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, -1, -1));

        alimento13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/c13.png"))); // NOI18N
        alimento13.setBorderPainted(false);
        alimento13.setContentAreaFilled(false);
        alimento13.setFocusPainted(false);
        alimento13.addActionListener(this::alimento13ActionPerformed);
        getContentPane().add(alimento13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 630, -1, -1));

        alimento14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/c14.png"))); // NOI18N
        alimento14.setBorderPainted(false);
        alimento14.setContentAreaFilled(false);
        alimento14.setFocusPainted(false);
        alimento14.addActionListener(this::alimento14ActionPerformed);
        getContentPane().add(alimento14, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 630, -1, -1));

        alimento9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/c9.png"))); // NOI18N
        alimento9.setBorderPainted(false);
        alimento9.setContentAreaFilled(false);
        alimento9.setFocusPainted(false);
        alimento9.addActionListener(this::alimento9ActionPerformed);
        getContentPane().add(alimento9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 510, -1, -1));

        alimento10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/c10.png"))); // NOI18N
        alimento10.setBorderPainted(false);
        alimento10.setContentAreaFilled(false);
        alimento10.setFocusPainted(false);
        alimento10.addActionListener(this::alimento10ActionPerformed);
        getContentPane().add(alimento10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 510, -1, -1));

        alimento11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/c11.png"))); // NOI18N
        alimento11.setBorderPainted(false);
        alimento11.setContentAreaFilled(false);
        alimento11.setFocusPainted(false);
        alimento11.addActionListener(this::alimento11ActionPerformed);
        getContentPane().add(alimento11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 510, -1, -1));

        alimento12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/c12.png"))); // NOI18N
        alimento12.setBorderPainted(false);
        alimento12.setContentAreaFilled(false);
        alimento12.setFocusPainted(false);
        alimento12.addActionListener(this::alimento12ActionPerformed);
        getContentPane().add(alimento12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 510, -1, -1));

        alimento5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/c5.png"))); // NOI18N
        alimento5.setBorderPainted(false);
        alimento5.setContentAreaFilled(false);
        alimento5.setFocusPainted(false);
        alimento5.addActionListener(this::alimento5ActionPerformed);
        getContentPane().add(alimento5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 510, -1, -1));

        alimento6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/c6.png"))); // NOI18N
        alimento6.setBorderPainted(false);
        alimento6.setContentAreaFilled(false);
        alimento6.setFocusPainted(false);
        alimento6.addActionListener(this::alimento6ActionPerformed);
        getContentPane().add(alimento6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 510, -1, -1));

        alimento7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/c7.png"))); // NOI18N
        alimento7.setBorderPainted(false);
        alimento7.setContentAreaFilled(false);
        alimento7.setFocusPainted(false);
        alimento7.addActionListener(this::alimento7ActionPerformed);
        getContentPane().add(alimento7, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 510, -1, -1));

        alimento8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/c8.png"))); // NOI18N
        alimento8.setBorderPainted(false);
        alimento8.setContentAreaFilled(false);
        alimento8.setFocusPainted(false);
        alimento8.addActionListener(this::alimento8ActionPerformed);
        getContentPane().add(alimento8, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 510, -1, -1));

        alimento3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/c3.png"))); // NOI18N
        alimento3.setBorderPainted(false);
        alimento3.setContentAreaFilled(false);
        alimento3.setFocusPainted(false);
        alimento3.addActionListener(this::alimento3ActionPerformed);
        getContentPane().add(alimento3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 510, -1, -1));

        alimento4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/c4.png"))); // NOI18N
        alimento4.setBorderPainted(false);
        alimento4.setContentAreaFilled(false);
        alimento4.setFocusPainted(false);
        alimento4.addActionListener(this::alimento4ActionPerformed);
        getContentPane().add(alimento4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 510, -1, -1));

        alimento2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/c2.png"))); // NOI18N
        alimento2.setBorderPainted(false);
        alimento2.setContentAreaFilled(false);
        alimento2.setFocusPainted(false);
        alimento2.addActionListener(this::alimento2ActionPerformed);
        getContentPane().add(alimento2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, -1, -1));

        alimento1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/c1.png"))); // NOI18N
        alimento1.setBorderPainted(false);
        alimento1.setContentAreaFilled(false);
        alimento1.setFocusPainted(false);
        alimento1.addActionListener(this::alimento1ActionPerformed);
        getContentPane().add(alimento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, -1, -1));

        BLANCO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_ordinario/imagenes/BLANCO.png"))); // NOI18N
        BLANCO.setText("jLabel3");
        getContentPane().add(BLANCO, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        Inicio i= new Inicio();
        i.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LoginActionPerformed

    private void abrirBebida(String nombre) {
        try {
            java.sql.Connection c = DBConexion.getConexion();
            java.sql.PreparedStatement ps = c.prepareStatement(
                "SELECT descripcion,precio_g,precio_m,precio_p,imagen FROM productos WHERE nombre=? AND categoria='bebida'");
            ps.setString(1, nombre);
            java.sql.ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                BEBIDAS p = new BEBIDAS(nombre, rs.getString("descripcion"),
                    rs.getDouble("precio_g"), rs.getDouble("precio_m"), rs.getDouble("precio_p"),
                    rs.getString("imagen"), this);
                p.setVisible(true);
                p.setExtendedState(MAXIMIZED_BOTH);
                this.setEnabled(false);
            }
        } catch (java.sql.SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error BD: " + e.getMessage());
        }
    }

    private void abrirAlimento(String nombre) {
        try {
            java.sql.Connection c = DBConexion.getConexion();
            java.sql.PreparedStatement ps = c.prepareStatement(
                "SELECT descripcion,precio,imagen FROM productos WHERE nombre=? AND categoria='alimento'");
            ps.setString(1, nombre);
            java.sql.ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ALIMENTOS a = new ALIMENTOS(nombre, rs.getString("descripcion"),
                    rs.getDouble("precio"), rs.getString("imagen"), this);
                a.setVisible(true);
                a.setExtendedState(MAXIMIZED_BOTH);
                this.setEnabled(false);
            }
        } catch (java.sql.SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error BD: " + e.getMessage());
        }
    }

    private void bebida2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida2ActionPerformed
        abrirBebida("Cold Brew Infusion");
    }//GEN-LAST:event_bebida2ActionPerformed

    private void bebida1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida1ActionPerformed
        abrirBebida("Latte Clásico");
    }//GEN-LAST:event_bebida1ActionPerformed

    private void bebida3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida3ActionPerformed
        abrirBebida("Berry Hibiscus");
    }//GEN-LAST:event_bebida3ActionPerformed

    private void bebida4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida4ActionPerformed
        abrirBebida("Strawberry Cream");
    }//GEN-LAST:event_bebida4ActionPerformed

    private void bebida5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida5ActionPerformed
        abrirBebida("Strawberry Matcha");
    }//GEN-LAST:event_bebida5ActionPerformed

    private void bebida6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida6ActionPerformed
        abrirBebida("Dragon Fruit Refresher");
    }//GEN-LAST:event_bebida6ActionPerformed

    private void bebida7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida7ActionPerformed
        abrirBebida("Iced Americano");
    }//GEN-LAST:event_bebida7ActionPerformed

    private void bebida8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida8ActionPerformed
        abrirBebida("Iced Macchiato");
    }//GEN-LAST:event_bebida8ActionPerformed

    private void bebida9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida9ActionPerformed
        abrirBebida("Caramel Frappé");
    }//GEN-LAST:event_bebida9ActionPerformed

    private void bebida10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida10ActionPerformed
        abrirBebida("Black Hot Coffee");
    }//GEN-LAST:event_bebida10ActionPerformed

    private void bebida11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida11ActionPerformed
        abrirBebida("Vanilla Cream Cold");
    }//GEN-LAST:event_bebida11ActionPerformed

    private void bebida12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida12ActionPerformed
        abrirBebida("Mocha Iced");
    }//GEN-LAST:event_bebida12ActionPerformed

    private void bebida13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida13ActionPerformed
        abrirBebida("Americano Intenso");
    }//GEN-LAST:event_bebida13ActionPerformed

    private void bebida14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida14ActionPerformed
        abrirBebida("Espresso Cortado");
    }//GEN-LAST:event_bebida14ActionPerformed

    private void bebida15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida15ActionPerformed
        abrirBebida("Hot Mocha");
    }//GEN-LAST:event_bebida15ActionPerformed

    private void bebida16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida16ActionPerformed
        abrirBebida("Espresso Doble");
    }//GEN-LAST:event_bebida16ActionPerformed

    private void bebida17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida17ActionPerformed
        abrirBebida("Frappé Cookies");
    }//GEN-LAST:event_bebida17ActionPerformed

    private void bebida18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida18ActionPerformed
        abrirBebida("Hot Chocolate");
    }//GEN-LAST:event_bebida18ActionPerformed

    private void alimento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alimento1ActionPerformed
        abrirAlimento("Croissant Vegetal");
    }//GEN-LAST:event_alimento1ActionPerformed

    private void alimento2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alimento2ActionPerformed
        abrirAlimento("Bagel Caprese");
    }//GEN-LAST:event_alimento2ActionPerformed

    private void alimento3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alimento3ActionPerformed
        abrirAlimento("Ciabatta Pollo");
    }//GEN-LAST:event_alimento3ActionPerformed

    private void alimento4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alimento4ActionPerformed
        abrirAlimento("Pain au Chocolat");
    }//GEN-LAST:event_alimento4ActionPerformed

    private void alimento5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alimento5ActionPerformed
        abrirAlimento("Panini Tres Quesos");
    }//GEN-LAST:event_alimento5ActionPerformed

    private void alimento6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alimento6ActionPerformed
        abrirAlimento("Baguette Serrano");
    }//GEN-LAST:event_alimento6ActionPerformed

    private void alimento7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alimento7ActionPerformed
        abrirAlimento("Sándwich Pan Negro");
    }//GEN-LAST:event_alimento7ActionPerformed

    private void alimento8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alimento8ActionPerformed
        abrirAlimento("Sándwich Pavo Gourmet");
    }//GEN-LAST:event_alimento8ActionPerformed

    private void alimento9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alimento9ActionPerformed
        abrirAlimento("Bagel Aguacate");
    }//GEN-LAST:event_alimento9ActionPerformed

    private void alimento10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alimento10ActionPerformed
        abrirAlimento("Tarta de Arándanos");
    }//GEN-LAST:event_alimento10ActionPerformed

    private void alimento11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alimento11ActionPerformed
        abrirAlimento("Hoja de Hojaldre");
    }//GEN-LAST:event_alimento11ActionPerformed

    private void alimento12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alimento12ActionPerformed
        abrirAlimento("Strudel Frutos Rojos");
    }//GEN-LAST:event_alimento12ActionPerformed

    private void alimento13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alimento13ActionPerformed
        abrirAlimento("Muffin de Chispas");
    }//GEN-LAST:event_alimento13ActionPerformed

    private void alimento14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alimento14ActionPerformed
        abrirAlimento("Cheesecake Frutos");
    }//GEN-LAST:event_alimento14ActionPerformed

    private void carritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carritoActionPerformed
        CARRITO C = new CARRITO();
        C.setVisible(true);
    }//GEN-LAST:event_carritoActionPerformed

    private void jLabel13FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel13FocusGained
        carrito.doClick();
    }//GEN-LAST:event_jLabel13FocusGained

    private void jLabel12FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel12FocusGained
        carrito.doClick();
    }//GEN-LAST:event_jLabel12FocusGained

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
        java.awt.EventQueue.invokeLater(() -> new Pantalla_Principal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BLANCO;
    private javax.swing.JButton Login;
    private javax.swing.JButton alimento1;
    private javax.swing.JButton alimento10;
    private javax.swing.JButton alimento11;
    private javax.swing.JButton alimento12;
    private javax.swing.JButton alimento13;
    private javax.swing.JButton alimento14;
    private javax.swing.JButton alimento2;
    private javax.swing.JButton alimento3;
    private javax.swing.JButton alimento4;
    private javax.swing.JButton alimento5;
    private javax.swing.JButton alimento6;
    private javax.swing.JButton alimento7;
    private javax.swing.JButton alimento8;
    private javax.swing.JButton alimento9;
    private javax.swing.JButton bebida1;
    private javax.swing.JButton bebida10;
    private javax.swing.JButton bebida11;
    private javax.swing.JButton bebida12;
    private javax.swing.JButton bebida13;
    private javax.swing.JButton bebida14;
    private javax.swing.JButton bebida15;
    private javax.swing.JButton bebida16;
    private javax.swing.JButton bebida17;
    private javax.swing.JButton bebida18;
    private javax.swing.JButton bebida2;
    private javax.swing.JButton bebida3;
    private javax.swing.JButton bebida4;
    private javax.swing.JButton bebida5;
    private javax.swing.JButton bebida6;
    private javax.swing.JButton bebida7;
    private javax.swing.JButton bebida8;
    private javax.swing.JButton bebida9;
    private javax.swing.JButton carrito;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel x;
    private javax.swing.JLabel x1;
    // End of variables declaration//GEN-END:variables
}
