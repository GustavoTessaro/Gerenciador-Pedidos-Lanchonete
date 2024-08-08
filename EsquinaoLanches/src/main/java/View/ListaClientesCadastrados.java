
package View;

import Model.ConnectionCliente;
import Model.ClienteCadastrado;
import java.awt.BorderLayout;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import Main.Main;
import Model.GerarTabelaPDF;
import java.awt.Image;
import javax.swing.ImageIcon;
/**
 * Painel que exibe a lista de clientes cadastrados.
 */
public class ListaClientesCadastrados extends javax.swing.JPanel {

    ArrayList <ClienteCadastrado> listaClientes = new ArrayList();
    DefaultTableModel modeloTabela = new DefaultTableModel();

    /**
     * Preenche a tabela com os dados dos clientes cadastrados.
     */
    public void preencherTabela(){
        int n = this.listaClientes.size();
        String Colunas[] = {Main.controller.getMensagem("ListaClientesCadastradospreencherTabela1"), Main.controller.getMensagem("ListaClientesCadastradospreencherTabela2"), Main.controller.getMensagem("ListaClientesCadastradospreencherTabela3"), Main.controller.getMensagem("ListaClientesCadastradospreencherTabela4")};
        String Linhas[][] = new String[n][4];
        int j = 0;

        for(int i = 0; i < n; i++){
            Linhas[i][j] = listaClientes.get(i).getNome();
            j++;
            Linhas[i][j] = listaClientes.get(i).getTelefone();
            j++;
            Linhas[i][j] = listaClientes.get(i).getEndereco();
            j++;
            Linhas[i][j] = listaClientes.get(i).getData();
            j = 0;
        }
        
        this.modeloTabela = new DefaultTableModel(Linhas, Colunas){
            public boolean isCellEditable(int rowIndex, int mColIndex){
                return false;
            }
        };
        
        TabelaClientes.setModel(modeloTabela);
    }
    /**
     * Construtor da classe ListaClientesCadastrados.
     * @param listaClientes a lista de clientes cadastrados
     */
    public ListaClientesCadastrados() {
        initComponents();
        this.listaClientes = Main.controller.getListaClientes();
        preencherTabela();
        LB_ListaClientesCadastrados.setText(Main.controller.getMensagem("ListaClientesCadastradosLB_ListaClientesCadastrados"));
        BT_Remover.setText(Main.controller.getMensagem("ListaClientesCadastradosBT_Remover"));
        BT_Voltar.setText(Main.controller.getMensagem("ListaClientesCadastradosBT_Voltar"));
        BT_GerarPDF.setText(Main.controller.getMensagem("ListaClientesCadastrados_BTGerarPDF"));
        
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

        LB_ListaClientesCadastrados = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaClientes = new javax.swing.JTable();
        BT_Remover = new javax.swing.JButton();
        BT_Voltar = new javax.swing.JButton();
        JL_EsquinaoLanches = new javax.swing.JLabel();
        BT_GerarPDF = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 102));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        LB_ListaClientesCadastrados.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LB_ListaClientesCadastrados.setText("<html>Lista de Clientes<br/>Cadastrados<html>");

        TabelaClientes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TabelaClientes);

        BT_Remover.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BT_Remover.setText("Remover");
        BT_Remover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_RemoverMouseClicked(evt);
            }
        });

        BT_Voltar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BT_Voltar.setText("Voltar");
        BT_Voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_VoltarMouseClicked(evt);
            }
        });

        JL_EsquinaoLanches.setText("jLabel1");

        BT_GerarPDF.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BT_GerarPDF.setText("Gerar PDF");
        BT_GerarPDF.setPreferredSize(new java.awt.Dimension(127, 37));
        BT_GerarPDF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_GerarPDFMouseClicked(evt);
            }
        });
        BT_GerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_GerarPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BT_Remover)
                        .addGap(18, 18, 18)
                        .addComponent(BT_GerarPDF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JL_EsquinaoLanches, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LB_ListaClientesCadastrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LB_ListaClientesCadastrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_EsquinaoLanches, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BT_Remover)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BT_Voltar)
                        .addComponent(BT_GerarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
/**
     * Método executado quando o botão de remover cliente é clicado.
     * @param evt o evento de clique do mouse
     */
    private void BT_RemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_RemoverMouseClicked
        String selecionado = (String) TabelaClientes.getValueAt(TabelaClientes.getSelectedRow(), TabelaClientes.getSelectedColumn());
        
        int verifica = Main.controller.BT_RemoverMouseClickedTelaListaClientesCadastrados(selecionado);
        
        if(verifica == 1){
            modeloTabela.removeRow(TabelaClientes.getSelectedRow());
        } 
    }//GEN-LAST:event_BT_RemoverMouseClicked
/**
     * Método executado quando o botão de voltar é clicado.
     * @param evt o evento de clique do mouse
     */
    private void BT_VoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_VoltarMouseClicked
        try {
            Main.controller.TelaPrincipal();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_BT_VoltarMouseClicked

    private void BT_GerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_GerarPDFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BT_GerarPDFActionPerformed

    private void BT_GerarPDFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_GerarPDFMouseClicked
        String destinoArquivo = "./clientes_cadastrados.pdf";
        GerarTabelaPDF gerarTabelaPDF = new GerarTabelaPDF(destinoArquivo);

        int n = this.listaClientes.size();
        String Colunas[] = {Main.controller.getMensagem("FazerPedidoJL_Nome"), Main.controller.getMensagem("FazerPedidoJL_Telefone"), Main.controller.getMensagem("FazerPedidoJL_Endereco"), Main.controller.getMensagem("ListaClientesCadastradospreencherTabela4")};
        String Linhas[][] = new String[n][4];
        int j = 0;

        for (int i = 0; i < n; i++) {
            Linhas[i][j] = listaClientes.get(i).getNome();
            j++;
            Linhas[i][j] = listaClientes.get(i).getTelefone();
            j++;
            Linhas[i][j] = listaClientes.get(i).getEndereco();
            j++;
            Linhas[i][j] = listaClientes.get(i).getData();
            j = 0;
        }

        gerarTabelaPDF.adicionarTabela(Colunas, Linhas);
        gerarTabelaPDF.fecharDocumento();
        
        JOptionPane.showMessageDialog(this, Main.controller.getMensagem("ListaClientesCadastrados_BT_GerarPDFMouseClicked") + destinoArquivo);
    }//GEN-LAST:event_BT_GerarPDFMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_GerarPDF;
    private javax.swing.JButton BT_Remover;
    private javax.swing.JButton BT_Voltar;
    private javax.swing.JLabel JL_EsquinaoLanches;
    private javax.swing.JLabel LB_ListaClientesCadastrados;
    private javax.swing.JTable TabelaClientes;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
