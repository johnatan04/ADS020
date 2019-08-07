package modelo.entidades;

import java.util.List;
import modelo.persistencia.DadosException;

public interface DAO<T> {

    List<T> listar() throws DadosException;

    void incluir(T entidade) throws DadosException;

    void alterar(T entidade) throws DadosException;

    void excluir(T entidade) throws DadosException;

    T consultar(int id) throws DadosException;
}

