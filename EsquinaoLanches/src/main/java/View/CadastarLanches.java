package View;

import Model.Lanche;
import Model.ConnectionLanche;
import java.awt.BorderLayout;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import Main.Main;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Esta classe representa um painel para cadastrar lanches.
 */
public class CadastarLanches extends javax.swing.JPanel {
/**
 * Lista de lanches.
 * 
 * Esta lista armazena objetos do tipo Lanche, que representam os lanches cadastrados.
 * É utilizada para armazenar os lanches durante a execução do programa, permitindo
 * o acesso e manipulação dos dados dos lanches.
 */
    ArrayList<Lanche> listaLanches = new ArrayList();

    /**
     * Adiciona os nomes dos lanches ao ComboBox.
     */
    public void AdicionarComboBox() {
        try {
            for (int i = 0; i < listaLanches.size(); i++) {
                CB_LanchesCadastrados.addItem(listaLanches.get(i).getNome());
            }
        } catch (Exception e) {
            // Tratar qualquer exceção que possa ocorrer ao adicionar os itens ao ComboBox
        }
    }

    /**
     * Construtor da classe CadastarLanches.
     * @param listaLanches Lista de lanches a serem cadastrados.
     */
    public CadastarLanches() {
        // Inicializar componentes gráficos
        initComponents();
        // Receber a lista de lanches passada como parâmetro
        this.listaLanches = Main.controller.getListaLanches();
        // Adicionar um item padrão ao ComboBox
        CB_LanchesCadastrados.addItem(Main.controller.getMensagem("FazerPedidoCB_Lanches"));
        // Adicionar os lanches ao ComboBox
        AdicionarComboBox();
        JL_Nome.setText(Main.controller.getMensagem("CadastrarLanchesJL_Nome"));
        JL_CadastrarLanches.setText(Main.controller.getMensagem("CadastrarLanchesJL_CadastrarLanches"));
        JL_Ingredientes.setText(Main.controller.getMensagem("CadastrarLanchesJL_Ingredientes"));
        JL_Preco.setText(Main.controller.getMensagem("CadastrarLanchesJL_Preco"));
        BT_Remover.setText(Main.controller.getMensagem("CadastrarLanchesBT_Remover"));
        BT_Salvar.setText(Main.controller.getMensagem("CadastrarLanchesBT_Salvar"));
        BT_Voltar.setText(Main.controller.getMensagem("CadastrarLanchesBT_Voltar"));
        
        int larguraMaxima = 100;
        int alturaMaxima = 100;
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/EsquinaoLanches.png"));
        Image img = icon.getImage();

        // Redimensionar a imagem para as dimensões máximas
        Image novaImagem = img.getScaledInstance(larguraMaxima, alturaMaxima, Image.SCALE_SMOOTH);

        ImageIcon imagemRedimensionada = new ImageIcon(novaImagem);
        JL_EsquinaoLanches.setIcon(imagemRedimensionada);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JL_CadastrarLanches = new javax.swing.JLabel();
        JL_Nome = new javax.swing.JLabel();
        JL_Ingredientes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CampoDeTextoIngredientes = new javax.swing.JTextArea();
        CampoDeTextoNome = new javax.swing.JTextField();
        BT_Salvar = new javax.swing.JButton();
        CB_LanchesCadastrados = new javax.swing.JComboBox<>();
        BT_Voltar = new javax.swing.JButton();
        BT_Remover = new javax.swing.JButton();
        JL_Preco = new javax.swing.JLabel();
        CampoDeTextoPreco = new javax.swing.JTextField();
        JL_EsquinaoLanches = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 102));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        JL_CadastrarLanches.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        JL_CadastrarLanches.setText("Cadastrar Lanches");

        JL_Nome.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        JL_Nome.setText("Nome:");

        JL_Ingredientes.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        JL_Ingredientes.setText("Ingredientes:");

        CampoDeTextoIngredientes.setColumns(20);
        CampoDeTextoIngredientes.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        CampoDeTextoIngredientes.setRows(5);
        jScrollPane1.setViewportView(CampoDeTextoIngredientes);

        CampoDeTextoNome.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        BT_Salvar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BT_Salvar.setText("Salvar/Editar");
        BT_Salvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_SalvarMouseClicked(evt);
            }
        });

        CB_LanchesCadastrados.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        CB_LanchesCadastrados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CB_LanchesCadastradosMouseClicked(evt);
            }
        });

        BT_Voltar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BT_Voltar.setText("Voltar");
        BT_Voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_VoltarMouseClicked(evt);
            }
        });

        BT_Remover.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BT_Remover.setText("Remover");
        BT_Remover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_RemoverMouseClicked(evt);
            }
        });

        JL_Preco.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JL_Preco.setText("Preço:");

        CampoDeTextoPreco.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        JL_EsquinaoLanches.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JL_EsquinaoLanches, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(JL_CadastrarLanches))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(JL_Ingredientes)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JL_Preco)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(CampoDeTextoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(JL_Nome)
                            .addGap(26, 26, 26)
                            .addComponent(CampoDeTextoNome))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(BT_Remover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BT_Salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(CB_LanchesCadastrados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BT_Voltar, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_CadastrarLanches)
                    .addComponent(JL_EsquinaoLanches, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Nome)
                    .addComponent(CampoDeTextoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Ingredientes)
                    .addComponent(JL_Preco)
                    .addComponent(CampoDeTextoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BT_Salvar)
                    .addComponent(CB_LanchesCadastrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BT_Voltar)
                    .addComponent(BT_Remover))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
/**
 * Método executado quando o botão "Salvar" é clicado para cadastrar um novo lanche.
 * @param evt O evento de mouse associado ao clique no botão "Salvar".
 */
    private void BT_SalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_SalvarMouseClicked
        // Obter o nome do lanche do campo de texto
        String nome = CampoDeTextoNome.getText();
        // Obter os ingredientes do lanche do campo de texto
        String ingredientes = CampoDeTextoIngredientes.getText();
        // Obter o preço do lanche do campo de texto
        String precoString = CampoDeTextoPreco.getText();
        // Converter o preço para float
        float preco = Float.parseFloat(CampoDeTextoPreco.getText());
        
        Main.controller.BT_SalvarMouseClickedTelaCadastrarLanches(nome, ingredientes, precoString, preco);
        
        this.listaLanches = Main.controller.getListaLanches();
        
        // Limpar e atualizar o ComboBox de lanches cadastrados
        CB_LanchesCadastrados.removeAllItems();
        CB_LanchesCadastrados.addItem(Main.controller.getMensagem("FazerPedidoCB_Lanches"));
        AdicionarComboBox();
        
    }//GEN-LAST:event_BT_SalvarMouseClicked
/**
 * Método executado quando o ComboBox de lanches cadastrados é clicado.
 * Atualiza os campos de texto com os detalhes do lanche selecionado no ComboBox.
 * @param evt O evento de mouse associado ao clique no ComboBox de lanches cadastrados.
 */
    private void CB_LanchesCadastradosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CB_LanchesCadastradosMouseClicked
        try {
        // Itera sobre a lista de lanches cadastrados
        for (int i = 0; i < listaLanches.size(); i++) {
            // Verifica se o item selecionado no ComboBox corresponde ao nome de um lanche cadastrado
            if (CB_LanchesCadastrados.getSelectedItem().toString().equalsIgnoreCase(listaLanches.get(i).getNome())) {
                // Define os campos de texto com os detalhes do lanche selecionado
                CampoDeTextoNome.setText(listaLanches.get(i).getNome());
                CampoDeTextoIngredientes.setText(listaLanches.get(i).getIngredientes());
                CampoDeTextoPreco.setText(Float.toString(listaLanches.get(i).getPreco()));
                break; // Sai do loop após encontrar o lanche correspondente
            }
        }
    } catch (Exception e) {
        // Se ocorrer uma exceção ao selecionar o lanche, seleciona o primeiro item do ComboBox
        CB_LanchesCadastrados.setSelectedIndex(0);
    }
    }//GEN-LAST:event_CB_LanchesCadastradosMouseClicked
/**
 * Método executado quando o botão "Voltar" é clicado.
 * Retorna à tela principal da aplicação.
 * @param evt O evento de mouse associado ao clique no botão "Voltar".
 */
    private void BT_VoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_VoltarMouseClicked
        try {
        Main.controller.TelaPrincipal();
        } catch (Exception e) {
            // Trata qualquer exceção que possa ocorrer
        }
    }//GEN-LAST:event_BT_VoltarMouseClicked
/**
 * Método executado quando o botão "Remover" é clicado.
 * Remove um lanche cadastrado com base nos parâmetros fornecidos.
 * @param evt O evento de mouse associado ao clique no botão "Remover".
 */
    private void BT_RemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_RemoverMouseClicked
        String nome = CampoDeTextoNome.getText();
        String ingredientes = CampoDeTextoIngredientes.getText();
        String precoString = CampoDeTextoPreco.getText();
        
        int verifica = Main.controller.BT_RemoverMouseClickedTelaCadastrarLanches(nome, ingredientes, precoString);
        
        if(verifica == 1){
            // Remove o lanche do ComboBox
            CB_LanchesCadastrados.removeItemAt(CB_LanchesCadastrados.getSelectedIndex());
        }
        
        if(verifica == 2){
            // Limpa os campos de texto e o ComboBox
            CampoDeTextoNome.setText("");
            CampoDeTextoIngredientes.setText("");
            CB_LanchesCadastrados.setSelectedIndex(0);
        }

    }//GEN-LAST:event_BT_RemoverMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Remover;
    private javax.swing.JButton BT_Salvar;
    private javax.swing.JButton BT_Voltar;
    private javax.swing.JComboBox<String> CB_LanchesCadastrados;
    private javax.swing.JTextArea CampoDeTextoIngredientes;
    private javax.swing.JTextField CampoDeTextoNome;
    private javax.swing.JTextField CampoDeTextoPreco;
    private javax.swing.JLabel JL_CadastrarLanches;
    private javax.swing.JLabel JL_EsquinaoLanches;
    private javax.swing.JLabel JL_Ingredientes;
    private javax.swing.JLabel JL_Nome;
    private javax.swing.JLabel JL_Preco;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
