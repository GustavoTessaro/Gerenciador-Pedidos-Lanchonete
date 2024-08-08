
package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Classe que representa um cliente cadastrado no sistema.
 * 
 * Esta classe estende a classe Pessoa e implementa a interface InterfaceCliente.
 * Ela representa um cliente com nome, endereço, telefone e data de cadastro.
 */
public class ClienteCadastrado extends Pessoa implements InterfaceCliente{
    
    private String telefone, data;
/**
     * Construtor da classe ClienteCadastrado.
     * 
     * @param telefone O telefone do cliente.
     * @param nome O nome do cliente.
     * @param endereco O endereço do cliente.
     */
    public ClienteCadastrado(String telefone, String nome, String endereco) {
        super(nome, endereco);
        this.telefone = telefone;
        this.data = "";
    }

   /**
     * Método getter para obter o telefone do cliente.
     * 
     * @return O telefone do cliente.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Método setter para definir o telefone do cliente.
     * 
     * @param telefone O telefone do cliente.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Método que calcula a data de cadastro do cliente.
     * 
     * Este método implementa o método definido na interface InterfaceCliente.
     * Ele obtém a data atual e a formata para o formato "dd/MM/yyyy".
     * 
     * @see InterfaceCliente#CalcularData()
     */
    @Override
    public void CalcularData() {
        Date dataAtual = new Date();
        DateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        String dataString = dataFormatada.format(dataAtual);
        setData(dataString);
    }

    /**
     * Método getter para obter a data de cadastro do cliente.
     * 
     * @return A data de cadastro do cliente.
     */
    public String getData() {
        return data;
    }

    /**
     * Método setter para definir a data de cadastro do cliente.
     * 
     * @param data A data de cadastro do cliente.
     */
    public void setData(String data) {
        this.data = data;
    }

}
