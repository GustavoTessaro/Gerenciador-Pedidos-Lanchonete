
package View;

import Model.Pedido;
import Model.Lanche;
import Model.ClienteCadastrado;
import java.awt.BorderLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import Main.Main;
import java.awt.Image;
import javax.swing.ImageIcon;
/**
 * Classe que representa a tela principal da aplicação.
 */
public class Principal extends javax.swing.JPanel {
    /**
     * Construtor da classe TelaPrincipal.
     * @throws FileNotFoundException se o arquivo não for encontrado
     * @throws IOException se ocorrer algum erro de I/O
     */
    public Principal() throws FileNotFoundException, IOException {
        initComponents();
        CB_Opcoes.addItem(Main.controller.getMensagem("PrincipalCB_Opcoes1"));
        CB_Opcoes.addItem(Main.controller.getMensagem("PrincipalCB_Opcoes2"));
        CB_Opcoes.addItem(Main.controller.getMensagem("PrincipalCB_Opcoes3"));
        CB_Opcoes.addItem(Main.controller.getMensagem("PrincipalCB_Opcoes4"));
        CB_Opcoes.addItem(Main.controller.getMensagem("PrincipalCB_Opcoes5"));
        CB_Opcoes.addItem(Main.controller.getMensagem("PrincipalCB_Opcoes6"));
        JL_TelaPrincipal.setText(Main.controller.getMensagem("PrincipalJL_TelaPrincipal"));
        BT_Avancar.setText(Main.controller.getMensagem("PrincipalBT_Avancar"));
        
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

        JL_TelaPrincipal = new javax.swing.JLabel();
        CB_Opcoes = new javax.swing.JComboBox<>();
        BT_Avancar = new javax.swing.JButton();
        JL_EsquinaoLanches = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 102));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        JL_TelaPrincipal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        JL_TelaPrincipal.setText("Tela Principal");

        CB_Opcoes.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        BT_Avancar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BT_Avancar.setText("Avançar");
        BT_Avancar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_AvancarMouseClicked(evt);
            }
        });

        JL_EsquinaoLanches.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(JL_EsquinaoLanches, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JL_TelaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CB_Opcoes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BT_Avancar)
                .addGap(109, 109, 109))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_TelaPrincipal)
                    .addComponent(JL_EsquinaoLanches, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CB_Opcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(BT_Avancar)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents
/**
     * Evento de clique no botão "Avançar".
     * @param evt evento de clique do mouse
     */
    private void BT_AvancarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_AvancarMouseClicked
        try {
        if(CB_Opcoes.getSelectedItem().toString().equalsIgnoreCase(Main.controller.getMensagem("PrincipalCB_Opcoes2"))){
            Main.controller.TelaCadastarLanches();
        }
        else{
            if(CB_Opcoes.getSelectedItem().toString().equalsIgnoreCase(Main.controller.getMensagem("PrincipalCB_Opcoes3"))){
                Main.controller.TelaCadastrarCliente();
            }
            else{
                if(CB_Opcoes.getSelectedItem().toString().equalsIgnoreCase(Main.controller.getMensagem("PrincipalCB_Opcoes4"))){
                    Main.controller.TelaListaClientesCadastrados();
                }
                else{
                    if(CB_Opcoes.getSelectedItem().toString().equalsIgnoreCase(Main.controller.getMensagem("PrincipalCB_Opcoes5"))){
                        Main.controller.TelaFazerPedido();
                    }
                    else{
                        if(CB_Opcoes.getSelectedItem().toString().equalsIgnoreCase(Main.controller.getMensagem("PrincipalCB_Opcoes6"))){
                            Main.controller.TelaPedidosDoDia();
                        }
                        else{
                            throw new Exception();
                        }
                    } 
                }  
            }
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, Main.controller.getMensagem("PrincipalBT_Avancar1"));
        }
    }//GEN-LAST:event_BT_AvancarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Avancar;
    private javax.swing.JComboBox<String> CB_Opcoes;
    private javax.swing.JLabel JL_EsquinaoLanches;
    private javax.swing.JLabel JL_TelaPrincipal;
    // End of variables declaration//GEN-END:variables
}
