
package beans;

import java.io.Serializable;

/**
 *
 * @author 18114290048
 */
public class Aluno implements Serializable{
    int matricula; 
    String nome;    

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
