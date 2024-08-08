
package Model;

/**
 * Classe que representa um cliente não cadastrado no sistema.
 * 
 * Esta classe estende a classe Pessoa e serve para representar clientes que ainda não foram cadastrados
 * no sistema, possuindo apenas nome e endereço.
 */
public class ClienteNaoCadastrado extends Pessoa {
    
    /**
     * Construtor da classe ClienteNaoCadastrado.
     * 
     * @param nome O nome do cliente não cadastrado.
     * @param endereco O endereço do cliente não cadastrado.
     */
    public ClienteNaoCadastrado(String nome, String endereco) {
        super(nome, endereco);
    }
    
}
