
package proyecto_ordinario;
import java.util.HashMap;
import java.awt.*;
import javax.swing.*;

public class IconManager {
    private static final HashMap<String, ImageIcon> iconCache = new HashMap<>();
    private static final int ICON_SIZE = 80;

    public static ImageIcon getIcon(String path) {
        if (!iconCache.containsKey(path)) {
            ImageIcon original = new ImageIcon(IconManager.class.getResource(path));
            Image img = original.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            iconCache.put(path, new ImageIcon(img));
        }
        return iconCache.get(path);
    }
}
