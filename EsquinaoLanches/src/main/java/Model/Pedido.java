
package Model;

import java.io.Serializable;

/**
 * Representa um pedido realizado.
 */
public class Pedido implements Serializable {
    
    private String nome, Ecadastrado, telefone, infoPedido;
    private float totalGasto;

    /**
     * Construtor da classe Pedido.
     * @param nome o nome do cliente
     * @param Ecadastrado se o cliente está cadastrado
     * @param telefone o telefone do cliente
     * @param infoPedido as informações do pedido
     * @param totalGasto o total gasto no pedido
     */
    public Pedido(String nome, String Ecadastrado, String telefone, String infoPedido, float totalGasto) {
        this.nome = nome;
        this.Ecadastrado = Ecadastrado;
        this.telefone = telefone;
        this.infoPedido = infoPedido;
        this.totalGasto = totalGasto;
    }

    /**
     * Obtém o telefone do cliente.
     * @return o telefone do cliente
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do cliente.
     * @param telefone o telefone do cliente
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Obtém o nome do cliente.
     * @return o nome do cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do cliente.
     * @param nome o nome do cliente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o status de cadastro do cliente.
     * @return o status de cadastro do cliente
     */
    public String getEcadastrado() {
        return Ecadastrado;
    }

    /**
     * Define o status de cadastro do cliente.
     * @param Ecadastrado o status de cadastro do cliente
     */
    public void setEcadastrado(String Ecadastrado) {
        this.Ecadastrado = Ecadastrado;
    }

    /**
     * Obtém as informações do pedido.
     * @return as informações do pedido
     */
    public String getInfoPedido() {
        return infoPedido;
    }

    /**
     * Define as informações do pedido.
     * @param infoPedido as informações do pedido
     */
    public void setInfoPedido(String infoPedido) {
        this.infoPedido = infoPedido;
    }

    /**
     * Obtém o total gasto no pedido.
     * @return o total gasto no pedido
     */
    public float getTotalGasto() {
        return totalGasto;
    }

    /**
     * Define o total gasto no pedido.
     * @param totalGasto o total gasto no pedido
     */
    public void setTotalGasto(float totalGasto) {
        this.totalGasto = totalGasto;
    }

}
