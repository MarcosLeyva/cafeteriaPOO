package proyecto_ordinario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInit {

    public static void inicializar() {
        try {
            Connection c = DBConexion.getConexion();
            crearTablas(c);
            sembrarProductos(c);
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null,
                "No se pudo conectar a la base de datos:\n" + e.getMessage(),
                "Error de BD", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void crearTablas(Connection c) throws SQLException {
        try (Statement st = c.createStatement()) {
            st.execute("""
                CREATE TABLE IF NOT EXISTS usuarios (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    nombre VARCHAR(100) NOT NULL,
                    usuario VARCHAR(50) UNIQUE NOT NULL,
                    contrasena VARCHAR(255) NOT NULL
                )""");

            st.execute("""
                CREATE TABLE IF NOT EXISTS productos (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    nombre VARCHAR(100) NOT NULL,
                    descripcion TEXT,
                    categoria ENUM('bebida','alimento') NOT NULL,
                    precio_g DOUBLE,
                    precio_m DOUBLE,
                    precio_p DOUBLE,
                    precio DOUBLE,
                    imagen VARCHAR(50) NOT NULL
                )""");

            st.execute("""
                CREATE TABLE IF NOT EXISTS carrito (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    nombre_producto VARCHAR(100) NOT NULL,
                    subtotal DOUBLE NOT NULL,
                    imagen VARCHAR(50) NOT NULL
                )""");

            st.execute("""
                CREATE TABLE IF NOT EXISTS pedidos (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    usuario VARCHAR(50) NOT NULL,
                    total DOUBLE NOT NULL,
                    iva DOUBLE NOT NULL,
                    fecha DATETIME DEFAULT CURRENT_TIMESTAMP
                )""");

            st.execute("""
                CREATE TABLE IF NOT EXISTS detalle_pedido (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    pedido_id INT NOT NULL,
                    nombre_producto VARCHAR(100) NOT NULL,
                    subtotal DOUBLE NOT NULL,
                    imagen VARCHAR(50) NOT NULL,
                    FOREIGN KEY (pedido_id) REFERENCES pedidos(id)
                )""");
        }
    }

    private static void sembrarProductos(Connection c) throws SQLException {
        // Skip if already seeded
        try (var rs = c.createStatement().executeQuery("SELECT COUNT(*) FROM productos")) {
            rs.next();
            if (rs.getInt(1) > 0) return;
        }

        String sqlBebida = "INSERT INTO productos (nombre,descripcion,categoria,precio_g,precio_m,precio_p,imagen) VALUES (?,?,?,?,?,?,?)";
        String sqlAlimento = "INSERT INTO productos (nombre,descripcion,categoria,precio,imagen) VALUES (?,?,?,?,?)";

        try (PreparedStatement pb = c.prepareStatement(sqlBebida);
             PreparedStatement pa = c.prepareStatement(sqlAlimento)) {

            Object[][] bebidas = {
                {"Latte Clásico","Espresso doble diluido en leche vaporizada y microespuma.",65,55,45,"D1.png"},
                {"Cold Brew Infusion","Café de especialidad extraído en frío por 18 horas, servido sobre hielo.",70,60,50,"D2.png"},
                {"Berry Hibiscus","Infusión de frutos rojos y flor de jamaica, servida con hielo y rodaja de cítricos.",60,50,40,"D4.png"},
                {"Strawberry Cream","Base láctea infusionada con reducción de fresa natural y hielo frappé.",75,65,55,"D3.png"},
                {"Strawberry Matcha","Matcha ceremonial batido con leche de almendra y puré de fresa en capas.",90,75,60,"D6.png"},
                {"Dragon Fruit Refresher","Refrescante de pitaya con notas de lichi y base de té verde.",70,60,50,"D5.png"},
                {"Iced Americano","Espresso doble diluido en agua fría filtrada y servido sobre hielo cristalino.",55,45,35,"D8.png"},
                {"Iced Macchiato","Espresso sobre hielo y leche fría, finalizado con espuma de leche densa.",80,70,60,"D7.png"},
                {"Caramel Frappé","Base de espresso, jarabe de caramelo artesanal y leche, licuado con hielo.",95,80,65,"D10.png"},
                {"Black Hot Coffee","Café de especialidad de origen, método de goteo, perfil balanceado.",50,40,30,"D9.png"},
                {"Vanilla Cream Cold","Base de cold brew con infusión de vainilla natural y espuma de crema dulce.",85,70,55,"D12.png"},
                {"Mocha Iced","Espresso doble, chocolate amargo al 70% y leche fría, sobre hielo.",85,70,55,"D11.png"},
                {"Americano Intenso","Espresso doble cargado con agua caliente a 92°C para resaltar notas tostadas.",50,40,30,"D14.png"},
                {"Espresso Cortado","Espresso doble equilibrado con una porción igual de leche al vapor.",60,50,40,"D13.png"},
                {"Hot Mocha","Espresso, cacao en polvo y leche vaporizada a temperatura controlada.",80,65,50,"D16.png"},
                {"Espresso Doble","Extracción concentrada de café, 60ml de cuerpo y crema densa.",50,40,35,"D15.png"},
                {"Frappé Cookies","Licuado de galleta estilo Oreo, base de crema, leche y jarabe de vainilla.",95,80,65,"D18.png"},
                {"Hot Chocolate","Cacao orgánico al 70% infusionado con leche entera y espuma cremosa.",65,55,45,"D17.png"},
            };

            for (Object[] b : bebidas) {
                pb.setString(1, (String) b[0]);
                pb.setString(2, (String) b[1]);
                pb.setString(3, "bebida");
                pb.setDouble(4, ((Number) b[2]).doubleValue());
                pb.setDouble(5, ((Number) b[3]).doubleValue());
                pb.setDouble(6, ((Number) b[4]).doubleValue());
                pb.setString(7, (String) b[5]);
                pb.addBatch();
            }
            pb.executeBatch();

            Object[][] alimentos = {
                {"Croissant Vegetal","Hojaldre de mantequilla relleno con aguacate fresco, jitomate y lechuga.",55,"A1.png"},
                {"Bagel Caprese","Pan bagel artesanal, queso mozzarella fresco, albahaca y pesto de tomate.",65,"A2.png"},
                {"Ciabatta Pollo","Pan ciabatta crujiente, pechuga de pollo asada, mix de verdes y aderezo cítrico.",85,"A3.png"},
                {"Pain au Chocolat","Hojaldre clásico relleno de dos barras de chocolate oscuro belga al 55%..",45,"A4.png"},
                {"Panini Tres Quesos","Mezcla de quesos fundidos en pan de masa madre con toque de hierbas finas.",70,"A5.png"},
                {"Baguette Serrano","Pan tipo baguette, jamón serrano, aceite de oliva virgen y tomate rallado.",96,"A6.png"},
                {"Sándwich Pan Negro","Pan artesanal de centeno con rellenos de embutidos curados y aderezo de mostaza.",75,"A7.png"},
                {"Sándwich Pavo Gourmet","Pechuga de pavo ahumada, pan integral, queso gouda y espinacas baby.",80,"A8.png"},
                {"Bagel Aguacate","Pan bagel con base de cremoso de aguacate, semillas de sésamo y rábano.",60,"A9.png"},
                {"Tarta de Arándanos","Masa quebrada rellena de crema de almendras y arándanos frescos glaseados.",55,"A10.png"},
                {"Hoja de Hojaldre","Pastelería fina horneada, crujiente, con glaseado ligero y textura ligera.",40,"A11.png"},
                {"Strudel Frutos Rojos","Masa fina enrollada rellena de compota de frutos rojos y un toque de canela.",45,"A12.png"},
                {"Muffin de Chispas","Panqué esponjoso de vainilla con alta densidad de gotas de chocolate semiamargo.",35,"A13.png"},
                {"Cheesecake Frutos","Pastel de queso estilo New York con topping de mermelada artesanal de frutos.",65,"A14.png"},
            };

            for (Object[] a : alimentos) {
                pa.setString(1, (String) a[0]);
                pa.setString(2, (String) a[1]);
                pa.setString(3, "alimento");
                pa.setDouble(4, ((Number) a[2]).doubleValue());
                pa.setString(5, (String) a[3]);
                pa.addBatch();
            }
            pa.executeBatch();
        }
    }
}
