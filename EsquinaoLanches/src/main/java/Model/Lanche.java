
package Model;

import java.io.Serializable;

/**
 * Classe que representa um lanche.
 */
public class Lanche implements Serializable {
    
    private String nome; // Nome do lanche
    private String ingredientes; // Ingredientes do lanche
    private float preco; // Preço do lanche

    /**
     * Construtor da classe Lanche.
     * @param nome o nome do lanche
     * @param ingredientes os ingredientes do lanche
     * @param preco o preço do lanche
     */
    public Lanche(String nome, String ingredientes, float preco) {
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.preco = preco;
    }

    /**
     * Obtém o nome do lanche.
     * @return o nome do lanche
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do lanche.
     * @param nome o nome do lanche
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém os ingredientes do lanche.
     * @return os ingredientes do lanche
     */
    public String getIngredientes() {
        return ingredientes;
    }

    /**
     * Define os ingredientes do lanche.
     * @param ingredientes os ingredientes do lanche
     */
    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    /**
     * Obtém o preço do lanche.
     * @return o preço do lanche
     */
    public float getPreco() {
        return preco;
    }

    /**
     * Define o preço do lanche.
     * @param preco o preço do lanche
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }   
}
