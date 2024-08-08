
package Model;

import java.io.Serializable;

/**
 * Classe abstrata que representa uma pessoa.
 */
public abstract class Pessoa implements Serializable {
    
    private String nome, endereco;

    /**
     * Construtor da classe Pessoa.
     * @param nome o nome da pessoa
     * @param endereco o endereço da pessoa
     */
    public Pessoa(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    /**
     * Obtém o nome da pessoa.
     * @return o nome da pessoa
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da pessoa.
     * @param nome o nome da pessoa
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o endereço da pessoa.
     * @return o endereço da pessoa
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o endereço da pessoa.
     * @param endereco o endereço da pessoa
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
