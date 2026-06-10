/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_ordinario;

/**
 *
 * @author Ganda
 */
public class PROYECTO_ORDINARIO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBInit.inicializar();
        try (java.sql.Connection c = DBConexion.getConexion();
             java.sql.Statement st = c.createStatement()) {
            st.execute("DELETE FROM carrito");
        } catch (java.sql.SQLException e) {
            System.out.println("Error al limpiar carrito: " + e.getMessage());
        }
        Inicio n= new Inicio();
        n.setVisible(true);
    }
    
}
