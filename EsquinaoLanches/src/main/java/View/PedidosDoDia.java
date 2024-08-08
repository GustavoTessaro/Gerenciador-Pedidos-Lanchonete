
package View;

import Model.Pedido;
import java.awt.BorderLayout;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import Main.Main;
import Model.GerarPDFComGrafico;
import java.awt.Image;
import javax.swing.ImageIcon;
/**
 * Representa a interface gráfica para exibir os pedidos do dia.
 */
public class PedidosDoDia extends javax.swing.JPanel {

    ArrayList <Pedido> listaPedidos = new ArrayList();
    DefaultTableModel modeloTabela = new DefaultTableModel();
    int totalNaoCadastrado;
    float total;
    float totalFaturadoCadastrado;
    float totalFaturadoNaoCadastrado;

    /**
     * Preenche a tabela com os pedidos do dia.
     */
    public void preencherTabela(){
        int n = this.listaPedidos.size();
        String Colunas[] = {Main.controller.getMensagem("PedidosDoDiapreencherTabela1"), Main.controller.getMensagem("PedidosDoDiapreencherTabela2"), Main.controller.getMensagem("PedidosDoDiapreencherTabela3"), Main.controller.getMensagem("PedidosDoDiapreencherTabela4")};
        String Linhas[][] = new String[n][4];
        int j = 0;

        for(int i = 0; i < n; i++){
            Linhas[i][j] = listaPedidos.get(i).getNome();
            j++;
            Linhas[i][j] = listaPedidos.get(i).getTelefone();
            j++;
            String Ecadastrado = "";
            // nao muda o Cadastrado
            if(listaPedidos.get(i).getEcadastrado().equalsIgnoreCase("Cadastrado")){
                Ecadastrado = Main.controller.getMensagem("PedidosDoDiapreencherTabela5");
                this.totalFaturadoCadastrado += listaPedidos.get(i).getTotalGasto();
            }
            else{
                Ecadastrado = Main.controller.getMensagem("PedidosDoDiapreencherTabela6");
                totalNaoCadastrado++;
                this.totalFaturadoNaoCadastrado += listaPedidos.get(i).getTotalGasto();
            }
            Linhas[i][j] = Ecadastrado;
            j++;
            Linhas[i][j] = Float.toString(listaPedidos.get(i).getTotalGasto());
            total += listaPedidos.get(i).getTotalGasto();
            j = 0;
        }
        
        this.modeloTabela = new DefaultTableModel(Linhas, Colunas){
            public boolean isCellEditable(int rowIndex, int mColIndex){
                return false;
            }
        };
        
        TabelaPedidos.setModel(modeloTabela);
    }
    /**
     * Construtor da classe PedidosDoDia.
     * @param listaPedidos a lista de pedidos do dia
     */
    public PedidosDoDia() {
        initComponents();
        this.listaPedidos = Main.controller.getListaPedidos();
        this.totalNaoCadastrado = 0;
        this.total = 0;
        preencherTabela();
        CampoDeTextoTotal.setEditable(false);
        CampoDeTextoTotal.setText(Float.toString(total));
        CampoDeTextoTotalNaoCadastrado.setEditable(false);
        CampoDeTextoTotalNaoCadastrado.setText(Float.toString(totalNaoCadastrado));
        JL_PedidosDoDia.setText(Main.controller.getMensagem("PedidosDoDiaJL_PedidosDoDia"));
        JL_Total.setText(Main.controller.getMensagem("PedidosDoDiaJL_Total"));
        jLabel1.setText(Main.controller.getMensagem("PedidosDoDiajLabel1"));
        BT_Info.setText(Main.controller.getMensagem("PedidosDoDiaBT_Info"));
        BT_RemoverTodos.setText(Main.controller.getMensagem("PedidosDoDiaBT_RemoverTodos"));
        BT_Voltar.setText(Main.controller.getMensagem("PedidosDoDiaBT_Voltar"));
        BT_ImprimirGrafico.setText(Main.controller.getMensagem("PedidosDoDia_BT_ImprimirGrafico"));
        
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

        JL_PedidosDoDia = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaPedidos = new javax.swing.JTable();
        JL_Total = new javax.swing.JLabel();
        CampoDeTextoTotal = new javax.swing.JTextField();
        BT_Voltar = new javax.swing.JButton();
        BT_Info = new javax.swing.JButton();
        CampoDeTextoTotalNaoCadastrado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        BT_RemoverTodos = new javax.swing.JButton();
        JL_EsquinaoLanches = new javax.swing.JLabel();
        BT_ImprimirGrafico = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 102));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        JL_PedidosDoDia.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        JL_PedidosDoDia.setText("Pedidos do Dia");

        TabelaPedidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TabelaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TabelaPedidos);

        JL_Total.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JL_Total.setText("Total:");

        CampoDeTextoTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        BT_Voltar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BT_Voltar.setText("Voltar");
        BT_Voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_VoltarMouseClicked(evt);
            }
        });

        BT_Info.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BT_Info.setText("Info");
        BT_Info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_InfoMouseClicked(evt);
            }
        });

        CampoDeTextoTotalNaoCadastrado.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Total Não Cadastrado:");

        BT_RemoverTodos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BT_RemoverTodos.setText("Remover Todos");
        BT_RemoverTodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_RemoverTodosMouseClicked(evt);
            }
        });

        JL_EsquinaoLanches.setText("jLabel2");

        BT_ImprimirGrafico.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BT_ImprimirGrafico.setText("Imprimir Gráfico");
        BT_ImprimirGrafico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_ImprimirGraficoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BT_ImprimirGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(BT_Info, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JL_Total))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BT_RemoverTodos)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CampoDeTextoTotalNaoCadastrado)
                            .addComponent(CampoDeTextoTotal)
                            .addComponent(BT_Voltar, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JL_EsquinaoLanches, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(JL_PedidosDoDia))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(JL_PedidosDoDia))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JL_EsquinaoLanches, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Total)
                    .addComponent(CampoDeTextoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Info))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoDeTextoTotalNaoCadastrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BT_Voltar)
                    .addComponent(BT_RemoverTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BT_ImprimirGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents
/**
     * Evento ao clicar no botão de obter informações do pedido.
     */
    private void BT_InfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_InfoMouseClicked
        String selecionado = (String) TabelaPedidos.getValueAt(TabelaPedidos.getSelectedRow(), TabelaPedidos.getSelectedColumn());
        
        Main.controller.BT_InfoMouseClickedTelaPedidosDoDia(selecionado);
    }//GEN-LAST:event_BT_InfoMouseClicked
/**
     * Evento ao clicar no botão de voltar.
     */
    private void BT_VoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_VoltarMouseClicked
        try {
            Main.controller.TelaPrincipal();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_BT_VoltarMouseClicked
/**
     * Evento ao clicar no botão de remover todos os pedidos.
     */
    private void BT_RemoverTodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_RemoverTodosMouseClicked
        int verifica = Main.controller.BT_RemoverTodosMouseClickedTelaPedidosDoDia();
        
        if(verifica == 1){
            listaPedidos = Main.controller.getListaPedidos();
            CampoDeTextoTotal.setText("");
            CampoDeTextoTotalNaoCadastrado.setText("");
            preencherTabela();
        }
    }//GEN-LAST:event_BT_RemoverTodosMouseClicked

    private void BT_ImprimirGraficoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_ImprimirGraficoMouseClicked
        int toaldeclientescadastrados = this.listaPedidos.size() - this.totalNaoCadastrado;
        System.out.println(this.listaPedidos.size());
        System.out.println(this.totalNaoCadastrado);
        System.out.println(toaldeclientescadastrados);
        GerarPDFComGrafico gerarGrafico = new GerarPDFComGrafico(toaldeclientescadastrados, this.totalNaoCadastrado, this.total, this.totalFaturadoCadastrado, this.totalFaturadoNaoCadastrado);
        gerarGrafico.gerarPDFComGrafico();
        JOptionPane.showMessageDialog(this, Main.controller.getMensagem("ListaClientesCadastrados_BT_GerarPDFMouseClicked") + gerarGrafico.getDestinoArquivo());
    }//GEN-LAST:event_BT_ImprimirGraficoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_ImprimirGrafico;
    private javax.swing.JButton BT_Info;
    private javax.swing.JButton BT_RemoverTodos;
    private javax.swing.JButton BT_Voltar;
    private javax.swing.JTextField CampoDeTextoTotal;
    private javax.swing.JTextField CampoDeTextoTotalNaoCadastrado;
    private javax.swing.JLabel JL_EsquinaoLanches;
    private javax.swing.JLabel JL_PedidosDoDia;
    private javax.swing.JLabel JL_Total;
    private javax.swing.JTable TabelaPedidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
