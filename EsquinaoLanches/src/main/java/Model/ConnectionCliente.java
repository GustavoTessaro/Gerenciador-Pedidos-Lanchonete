
package Model;

import java.sql.Connection;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Classe responsável pela conexão e operações relacionadas a clientes no banco de dados.
 */
public class ConnectionCliente {

    private static final String INSERT_SQL = "INSERT INTO Cliente (nome, endereco, telefone, dataCadastro) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE Cliente SET nome = ?, endereco = ?, telefone = ?, dataCadastro = ? WHERE nome = ?";
    private static final String DELETE_SQL = "DELETE FROM Cliente WHERE nome = ?";
    
    private String url;
    private String usuario;
    private String senha;
    private String nome;
    private String endereco;
    private String dataString;
    private String telefone;
    private String dataFormatada;

    /**
     * Construtor da classe ConnectionCliente.
     *
     * @param url      URL de conexão com o banco de dados.
     * @param usuario  Nome de usuário para acesso ao banco de dados.
     * @param senha    Senha para acesso ao banco de dados.
     * @param nome     Nome do cliente.
     * @param endereco Endereço do cliente.
     * @param data     Data de cadastro do cliente no formato "dd/MM/yyyy".
     * @param telefone Número de telefone do cliente.
     */
    public ConnectionCliente(String url, String usuario, String senha, String nome, String endereco, String data, String telefone) {
        this.url = url;
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.endereco = endereco;
        this.dataString = data;
        this.telefone = telefone;
    }

    /**
     * Adiciona um novo cliente ao banco de dados.
     */
    public void AdicionarClienteBancoDeDados() {
        // Formato da string de data original
        String formatoOriginal = "dd/MM/yyyy";

        // Formato desejado para a string de data
        String formatoDesejado = "yyyy/MM/dd";

        try {
            // Criar um objeto SimpleDateFormat para o formato original
            SimpleDateFormat sdfOriginal = new SimpleDateFormat(formatoOriginal);

            // Converter a string para um objeto Date
            Date dataA = sdfOriginal.parse(dataString);

            // Criar um objeto SimpleDateFormat para o formato desejado
            SimpleDateFormat sdfDesejado = new SimpleDateFormat(formatoDesejado);

            // Converter o objeto Date de volta para uma string no formato desejado
            dataFormatada = sdfDesejado.format(dataA);

            // Exibir a data formatada
            System.out.println("Data formatada: " + dataFormatada);

            try (Connection conn = DriverManager.getConnection(this.url, this.usuario, this.senha);
                 PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL)) {
                pstmt.setString(1, this.nome);
                pstmt.setString(2, this.endereco);
                pstmt.setString(3, this.telefone);
                pstmt.setString(4, this.dataFormatada);

                // Executar a instrução SQL
                int linhasAfetadas = pstmt.executeUpdate();
                System.out.println("Linhas afetadas: " + linhasAfetadas);
            } catch (SQLException e) {
                System.err.println("Erro ao inserir dados: " + e.getMessage());
            }
        } catch (ParseException e) {
            // Tratar qualquer erro de parsing da data
            System.err.println("Erro ao converter a data: " + e.getMessage());
        }
    }

    /**
     * Deleta um cliente do banco de dados.
     */
    public void DeletarCliente() {
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
     * Atualiza os dados de um cliente no banco de dados.
     */
    public void AtualizarClietne() {
        // Formato da string de data original
        String formatoOriginal = "dd/MM/yyyy";

        // Formato desejado para a string de data
        String formatoDesejado = "yyyy/MM/dd";

        try {
            // Criar um objeto SimpleDateFormat para o formato original
            SimpleDateFormat sdfOriginal = new SimpleDateFormat(formatoOriginal);

            // Converter a string para um objeto Date
            Date dataA = sdfOriginal.parse(dataString);

            // Criar um objeto SimpleDateFormat para o formato desejado
            SimpleDateFormat sdfDesejado = new SimpleDateFormat(formatoDesejado);

            // Converter o objeto Date de volta para uma string no formato desejado
            dataFormatada = sdfDesejado.format(dataA);

            // Exibir a data formatada
            System.out.println("Data formatada: " + dataFormatada);

            try (Connection conn = DriverManager.getConnection(url, usuario, senha);
                 PreparedStatement pstmt = conn.prepareStatement(UPDATE_SQL)) {
                // Define os valores dos parâmetros
                pstmt.setString(1, this.nome);
                pstmt.setString(2, this.endereco);
                pstmt.setString(3, this.telefone);
                pstmt.setString(4, this.dataFormatada);
                pstmt.setString(5, this.nome);

                // Executa a instrução SQL de atualização
                int linhasAfetadas = pstmt.executeUpdate();
                System.out.println("Linhas afetadas: " + linhasAfetadas);
            } catch (SQLException e) {
                System.err.println("Erro ao atualizar dados: " + e.getMessage());
            }
        } catch (ParseException e) {
            // Tratar qualquer erro de parsing da data
            System.err.println("Erro ao converter a data: " + e.getMessage());
        }
    }
}
