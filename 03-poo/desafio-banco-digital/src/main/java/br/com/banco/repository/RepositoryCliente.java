package main.java.br.com.banco.repository;

import main.java.br.com.banco.config.ConnectionFactory;
import main.java.br.com.banco.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class RepositoryCliente implements IRepositoryCliente {

    @Override
    public void cadastrar(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome, cpf) VALUES (?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());

            // Envia o comando INSERT para o MySQL
            stmt.executeUpdate();

            // Pega o ID gerado pelo AUTO_INCREMENT da tabela 'clientes' e preenche no objeto
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    cliente.setId(rs.getLong(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar cliente no banco de dados", e);
        }
    }

    @Override
    public void remover(String obj) {
        // TODO: Implementar
    }

    @Override
    public Optional<Cliente> buscar(String cpf) {
        String sql = "SELECT * FROM clientes WHERE cpf = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapearResultSetParaConta(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar conta", e);
        }
        return Optional.empty();
    }

    // Transforma a linha da tabela SQL de volta em um Objeto Java (Cliente)
    private Cliente mapearResultSetParaConta(ResultSet rs) throws SQLException {

        return  new Cliente(
                rs.getLong("id"),
                rs.getString("nome"),
                rs.getString("cpf")
        );
    }

    @Override
    public boolean existe(String cpf) {
        return buscar(cpf).isPresent();
    }

    @Override
    public List<Cliente> listar() {
        // TODO: Implementar
        return List.of();
    }

    @Override
    public void alterar(Cliente cliente) {

    }
}
