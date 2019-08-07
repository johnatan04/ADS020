package modelo.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Aluno;
import modelo.entidades.DAO;

public class AlunoDAO implements DAO<Aluno> {

    @Override
    public List<Aluno> listar() throws DadosException {
        List<Aluno> lista = new ArrayList<Aluno>();

        try {
            String sql = "SELECT * FROM ALUNOS";
            Connection conexao = ConexaoBD.getConexao();
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(sql);

            while (resultado.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(resultado.getInt(1));
                aluno.setMatricula(resultado.getInt(2));
                aluno.setNome(resultado.getString(3));
                lista.add(aluno);
            }

        } catch (SQLException ex) {
            throw new DadosException("Erro ao listar alunos!");
        }

        return lista;
    }

    @Override
    public void incluir(Aluno entidade) throws DadosException {

    }

    @Override
    public void alterar(Aluno entidade) throws DadosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Aluno entidade) throws DadosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Aluno consultar(int id) throws DadosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
