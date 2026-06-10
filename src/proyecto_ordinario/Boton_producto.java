
package proyecto_ordinario;

import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Boton_producto extends JButton {
    public Boton_producto(String nombre, String rutaImagen) {
        setIcon(IconManager.getIcon(rutaImagen));
        setText(nombre);

        setVerticalTextPosition(SwingConstants.BOTTOM);
        setHorizontalTextPosition(SwingConstants.CENTER);
        
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR)); 
    }
}