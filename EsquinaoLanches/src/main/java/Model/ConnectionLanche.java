
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe responsável pela conexão e operações relacionadas a lanches no banco de dados.
 */
public class ConnectionLanche {
    
    private static final String INSERT_SQL = "INSERT INTO Lanche (nome, ingredientes, preco) VALUES (?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE Lanche SET nome = ?, ingredientes = ?, preco = ? WHERE nome = ?";
    private static final String DELETE_SQL = "DELETE FROM Lanche WHERE nome =?";
    
    private String url;
    private String usuario;
    private String senha;
    private String nome;
    private String ingredientes;
    private float preco;

    /**
     * Construtor da classe ConnectionLanche.
     *
     * @param url          URL de conexão com o banco de dados.
     * @param usuario      Nome de usuário para acesso ao banco de dados.
     * @param senha        Senha para acesso ao banco de dados.
     * @param nome         Nome do lanche.
     * @param ingredientes Ingredientes do lanche.
     * @param preco        Preço do lanche.
     */
    public ConnectionLanche(String url, String usuario, String senha, String nome, String ingredientes, float preco) {
        this.url = url;
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.preco = preco;
    }

    /**
     * Adiciona um novo lanche ao banco de dados.
     */
    public void AdicionarLancheBancoDeDados(){
        try (Connection conn = DriverManager.getConnection(this.url, this.usuario, this.senha);
             PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL)) {
            pstmt.setString(1, this.nome);
            pstmt.setString(2, this.ingredientes);
            pstmt.setFloat(3, this.preco);

            // Executar a instrução SQL
            int linhasAfetadas = pstmt.executeUpdate();
            System.out.println("Linhas afetadas: " + linhasAfetadas);
        } catch (SQLException e) {
            System.err.println("Erro ao inserir dados: " + e.getMessage());
        }
    }
    
    /**
     * Deleta um lanche do banco de dados.
     */
    public void DeletarLanche(){
        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement pstmt = conn.prepareStatement(DELETE_SQL)) {
            // Define o valor do parâmetro
            pstmt.setString(1, this.nome);

            // Executa a instrução SQL de exclusão
            int linhasAfetadas = pstmt.executeUpdate();
            System.out.println("Linhas afetadas: " + linhasAfetadas);
        } catch (SQLException e) {
            System.err.println("Erro ao excluir dados: " + e.getMessage());
        }
    }
    
    /**
     * Atualiza os dados de um lanche no banco de dados.
     */
    public void AtualizarLanche(){
        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement pstmt = conn.prepareStatement(UPDATE_SQL)) {
            // Define os valores dos parâmetros
            pstmt.setString(1, this.nome);
            pstmt.setString(2, this.ingredientes);
            pstmt.setFloat(3, this.preco);
            pstmt.setString(4, this.nome);

            // Executa a instrução SQL de atualização
            int linhasAfetadas = pstmt.executeUpdate();
            System.out.println("Linhas afetadas: " + linhasAfetadas);
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar dados: " + e.getMessage());
        }
    }
}
