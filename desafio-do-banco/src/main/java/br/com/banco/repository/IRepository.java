package main.java.br.com.banco.repository;

import java.util.List;
import java.util.Optional;

public interface IRepository<T> {
    void cadastrar(Optional<T> obj);

    void remover(String obj);

    Optional<T> buscar(String numero);

    boolean existe(String obj);

    void alterar(Optional<T> obj);

    List<Optional<T>> listar();
}
