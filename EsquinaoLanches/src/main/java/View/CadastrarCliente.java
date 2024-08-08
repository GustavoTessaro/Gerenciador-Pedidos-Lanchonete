
package View;

import Model.ConnectionCliente;
import Model.ClienteCadastrado;
import java.awt.BorderLayout;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import Main.Main;
import java.awt.Image;
import javax.swing.ImageIcon;

public class CadastrarCliente extends javax.swing.JPanel {
    /**
 * Construtor da classe CadastrarCliente.
 * 
 * Inicializa uma instância da classe CadastrarCliente, associando a lista de clientes
 * cadastrados passada como parâmetro à variável de instância listaClientes.
 * 
 */
    public CadastrarCliente() {
        initComponents();
        jLabel1.setText(Main.controller.getMensagem("CadastrarClientejLabel1"));
        jLabel2.setText(Main.controller.getMensagem("CadastrarClientejLabel2"));
        jLabel3.setText(Main.controller.getMensagem("CadastrarClientejLabel3"));
        jLabel4.setText(Main.controller.getMensagem("CadastrarClientejLabel4"));
        BT_Cancelar.setText(Main.controller.getMensagem("CadastrarClienteBT_Cancelar"));
        BT_Salvar.setText(Main.controller.getMensagem("CadastrarClienteBT_Salvar"));
        
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BT_Salvar = new javax.swing.JButton();
        CampoDetextoNome = new javax.swing.JTextField();
        CampoDeTextoTelefone = new javax.swing.JTextField();
        CampoDeTextoEndereco = new javax.swing.JTextField();
        BT_Cancelar = new javax.swing.JButton();
        JL_EsquinaoLanches = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 102));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Cadastrar Cliente");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Telefone:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Endereço:");

        BT_Salvar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BT_Salvar.setText("Salvar");
        BT_Salvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_SalvarMouseClicked(evt);
            }
        });

        CampoDetextoNome.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        CampoDeTextoTelefone.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        CampoDeTextoEndereco.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        BT_Cancelar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BT_Cancelar.setText("Cancelar");
        BT_Cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_CancelarMouseClicked(evt);
            }
        });

        JL_EsquinaoLanches.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BT_Cancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BT_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(CampoDeTextoEndereco))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(CampoDeTextoTelefone))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(JL_EsquinaoLanches, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 71, Short.MAX_VALUE))
                            .addComponent(CampoDetextoNome))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JL_EsquinaoLanches, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CampoDetextoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CampoDeTextoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CampoDeTextoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BT_Salvar)
                    .addComponent(BT_Cancelar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
/**
 * Evento acionado quando o botão "Salvar" é clicado.
 * 
 * Este método é chamado quando o usuário clica no botão "Salvar" para cadastrar um novo cliente.
 * Ele verifica se os campos de nome, telefone e endereço foram preenchidos, e se sim, cria um objeto
 * ClienteCadastrado com os dados fornecidos, adiciona-o à lista de clientes cadastrados, salva os dados
 * do cliente no banco de dados e em um arquivo serializado, exibe uma mensagem de sucesso e retorna
 * à tela principal do sistema.
 * 
 * Se algum dos campos não estiver preenchido, uma exceção é lançada e exibida uma mensagem de erro.
 * 
 * @param evt O evento do mouse que acionou o método.
 */
    private void BT_SalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_SalvarMouseClicked
        String nome = CampoDetextoNome.getText();
        String telefone = CampoDeTextoTelefone.getText();
        String endereco = CampoDeTextoEndereco.getText();
        
        Main.controller.BT_SalvarMouseClickedTelaCadastrarCliente(nome, telefone, endereco);
    }//GEN-LAST:event_BT_SalvarMouseClicked
/**
 * Evento acionado quando o botão "Cancelar" é clicado.
 * 
 * Este método é chamado quando o usuário clica no botão "Cancelar" para cancelar o cadastro de um novo cliente.
 * Ele retorna à tela principal do sistema sem salvar nenhum dado.
 * 
 * @param evt O evento do mouse que acionou o método.
 */
    private void BT_CancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_CancelarMouseClicked
        try { 
        // Retorna à tela principal do sistema
        Main.controller.TelaPrincipal();
        } catch (IOException ex) {
            // Exibe uma mensagem de erro se ocorrer uma exceção ao retornar à tela principal
        }
    }//GEN-LAST:event_BT_CancelarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Cancelar;
    private javax.swing.JButton BT_Salvar;
    private javax.swing.JTextField CampoDeTextoEndereco;
    private javax.swing.JTextField CampoDeTextoTelefone;
    private javax.swing.JTextField CampoDetextoNome;
    private javax.swing.JLabel JL_EsquinaoLanches;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
