package pasarela;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CrearBaseDatos {

    private static final String URL =
            "jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "Andres!";

    public static void CreaBaseDatos() {

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            String sql = "CREATE DATABASE IF NOT EXISTS hospital " +
                         "CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci";

            stmt.executeUpdate(sql);

            System.out.println("✅ Base de datos verificada/creada");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}