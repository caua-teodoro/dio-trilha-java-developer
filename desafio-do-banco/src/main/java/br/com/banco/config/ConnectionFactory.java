package main.java.br.com.banco.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {
        Properties props = carregarPropriedades();
        return DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.user"),
                props.getProperty("db.password")
        );
    }

    private static Properties carregarPropriedades() {
        Properties props = new Properties();
        // Busca o arquivo direto da pasta src/main/resources
        try (InputStream input = ConnectionFactory.class.getClassLoader().getResourceAsStream("database/properties")) {
            if (input == null) {
                throw new RuntimeException("Arquivo database.properties não encontrado em src/main/resources");
            }
            props.load(input);
            return props;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar database.properties", e);
        }
    }
}