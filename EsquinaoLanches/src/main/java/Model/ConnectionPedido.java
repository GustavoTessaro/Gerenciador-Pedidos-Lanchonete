
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Classe responsável pela conexão e operações relacionadas a pedidos no banco de dados.
 */
public class ConnectionPedido {
    
    private static final String INSERT_SQL = "INSERT INTO Pedido (nome, Ecadastrado, telefone, infoPedido, totalGasto) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE Pedido SET nome = ?, Ecadastro = ?, telefone = ?, infoPedido = ?, totalGasto = ?";
    private static final String DELETE_ALL_SQL = "DELETE FROM Pedido";
    
    private String url;
    private String usuario;
    private String senha;
    private String nome;
    private String Ecadastro;
    private String telefone;
    private String infoPedido;
    private float totalGasto;

    /**
     * Construtor da classe ConnectionPedido.
     *
     * @param url         URL de conexão com o banco de dados.
     * @param usuario     Nome de usuário para acesso ao banco de dados.
     * @param senha       Senha para acesso ao banco de dados.
     * @param nome        Nome do pedido.
     * @param Ecadastro   Indica se o cliente está cadastrado.
     * @param telefone    Número de telefone do cliente.
     * @param infoPedido  Informações detalhadas do pedido.
     * @param totalGasto  Total gasto no pedido.
     */
    public ConnectionPedido(String url, String usuario, String senha, String nome, String Ecadastro, String telefone, String infoPedido, float totalGasto) {
        this.url = url;
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;  
        this.Ecadastro = Ecadastro;
        this.telefone = telefone;
        this.infoPedido = infoPedido;
        this.totalGasto = totalGasto;
    }
    
    public ConnectionPedido(String url, String usuario, String senha) {
        this.url = url;
        this.usuario = usuario;
        this.senha = senha;
    }

    /**
     * Adiciona um novo pedido ao banco de dados.
     */
    public void AdicionarPedidoBancoDeDados(){
        
        try (Connection conn = DriverManager.getConnection(this.url, this.usuario, this.senha);
            PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL)) {
            pstmt.setString(1, this.nome);
            pstmt.setString(2, this.Ecadastro);
            pstmt.setString(3, this.telefone);
            pstmt.setString(4, this.infoPedido);
            pstmt.setFloat(5, this.totalGasto);

            // Executar a instrução SQL
            int linhasAfetadas = pstmt.executeUpdate();
            System.out.println("Linhas afetadas: " + linhasAfetadas);
        } catch (SQLException e) {
            System.err.println("Erro ao inserir dados: " + e.getMessage());
        }
    }
    
    /**
     * Deleta um pedido do banco de dados.
     */
    public void DeletarPedido(){
        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
            PreparedStatement pstmt = conn.prepareStatement(DELETE_ALL_SQL)) {

            // Executa a instrução SQL de exclusão
            int linhasAfetadas = pstmt.executeUpdate();
            System.out.println("Linhas afetadas: " + linhasAfetadas);
        } catch (SQLException e) {
            System.err.println("Erro ao excluir dados: " + e.getMessage());
        }
    }
    
    /**
     * Atualiza os dados de um pedido no banco de dados.
     */
    public void AtualizarPedido(){
        
        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement pstmt = conn.prepareStatement(UPDATE_SQL)) {
            // Define os valores dos parâmetros
            pstmt.setString(1, this.nome);
            pstmt.setString(2, this.Ecadastro);
            pstmt.setString(3, this.telefone);
            pstmt.setString(4, this.infoPedido);
            pstmt.setFloat(5, this.totalGasto);
            // Executa a instrução SQL de atualização
            int linhasAfetadas = pstmt.executeUpdate();
            System.out.println("Linhas afetadas: " + linhasAfetadas);
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar dados: " + e.getMessage());
        }
    }
}
