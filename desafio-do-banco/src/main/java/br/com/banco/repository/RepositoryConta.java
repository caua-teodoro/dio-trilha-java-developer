package main.java.br.com.banco.repository;

import main.java.br.com.banco.config.ConnectionFactory;
import main.java.br.com.banco.model.Cliente;
import main.java.br.com.banco.model.Conta;
import main.java.br.com.banco.model.TipoConta;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositoryConta implements IRepositoryConta {

    @Override
    public void cadastrar(Optional<Conta> conta) {
        if  (!existe(conta.get().getNumero())) {
            String sql = "INSERT INTO contas (numero, tipo_conta, saldo, cliente_id) VALUES (?, ?, ?, ?)";
            try (Connection conn = ConnectionFactory.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {


                stmt.setString(1, conta.get().getNumero());
                stmt.setString(2, conta.get().getTipoConta().name()); // "CORRENTE" ou "POUPANCA"
                stmt.setBigDecimal(3, conta.get().getSaldo());
                stmt.setLong(4, conta.get().getTitular().getId());    // <-- Chave estrangeira (ID do Cliente)!

                stmt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void remover(String numero) {
        if (existe(numero)) {
            String sql = "DELETE FROM contas WHERE numero = ?";

            try (Connection conn = ConnectionFactory.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, numero);
                stmt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Optional<Conta> buscar(String numero) {

        String sql = "SELECT c.*, cli.id, cli.nome, cli.cpf " +
                "FROM contas c " +
                "INNER JOIN clientes cli ON c.cliente_id = cli.id " +
                "WHERE c.numero = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, numero);
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

    @Override
    public boolean existe(String numero) {
        return buscar(numero).isPresent();
    }

    @Override
    public void alterar(Optional<Conta> conta) {
        if  (existe(conta.get().getNumero())) {
            String sql = "UPDATE contas SET saldo = ?, senha = ? WHERE numero = ?";

            try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);){
                stmt.setBigDecimal(1, conta.get().getSaldo());
                stmt.setString(2, conta.get().getSenha());
                stmt.setString(3, conta.get().getNumero());
                stmt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Optional<Conta>> listar() {
        List<Optional<Conta>> contas = new ArrayList<>();
        String sql = "SELECT c.*, cli.id, cli.nome, cli.cpf " +
                "FROM contas c " +
                "INNER JOIN clientes cli ON c.cliente_id = cli.id";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Optional<Conta> conta = Optional.of(mapearResultSetParaConta(rs));
                contas.add(conta);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar contas", e);
        }

        return contas;
    }

    // Transforma a linha da tabela SQL de volta em um Objeto Java (Conta)
    private Conta mapearResultSetParaConta(ResultSet rs) throws SQLException {

        Cliente titular = new Cliente(
                rs.getLong("id"),
                rs.getString("nome"),
                rs.getString("cpf")
        );

        TipoConta tipo = TipoConta.valueOf(rs.getString("tipo_conta"));

        return new Conta(
                rs.getString("numero"),
                titular,
                tipo,
                rs.getBigDecimal("saldo")
        );
    }

    @Override
    public void depositar(String numero, BigDecimal valor) {
        if (existe(numero)) {
            Optional<Conta> conta = buscar(numero);
            conta.get().setSaldo(conta.get().getSaldo().add(valor));
            alterar(conta);
        }
    }
    @Override
    public void sacar(String numero, BigDecimal valor) {
        if (existe(numero)) {
            Optional<Conta> conta = buscar(numero);
            conta.get().setSaldo(conta.get().getSaldo().subtract(valor));
            alterar(conta);
        }
    }
    @Override
    public void transferir(BigDecimal valor, String numRemetente, String numDestinatario) {
        if (existe(numRemetente) && existe(numDestinatario)) {
            Optional<Conta> contaRemetente = buscar(numRemetente);
            Optional<Conta> contaDestinatario = buscar(numDestinatario);

            if (contaRemetente.get().getTipoConta().equals(TipoConta.CORRENTE) &&  contaDestinatario.get().getTipoConta().equals(TipoConta.CORRENTE)) {
                contaRemetente.get().setSaldo(contaRemetente.get().getSaldo().subtract(valor));
                contaDestinatario.get().setSaldo(contaDestinatario.get().getSaldo().add(valor));

                alterar(contaDestinatario);
                alterar(contaRemetente);
            }
        }
    }

    @Override
    public void definirSenha(String numero, String senha) {
         if (existe(numero)) {
             Optional<Conta> conta = buscar(numero);
             conta.get().setSenha(senha);
             alterar(conta);
         }
    }
}
