
package View;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import Main.Main;
import java.awt.Image;
import javax.swing.ImageIcon;
/**
 * Painel para login de administrador.
 */
public class LoginADM extends javax.swing.JPanel {
/**
     * Construtor da classe LoginADM.
     */
    
    private ImageIcon ImagemBandeira;
    
    public LoginADM() {
        initComponents();
        JL_Login.setText(Main.controller.getMensagem("LoginADMJL_Login"));
        JL_Nome.setText(Main.controller.getMensagem("LoginADMJL_Nome"));
        JL_Senha.setText(Main.controller.getMensagem("LoginADMJL_Senha"));
        BT_Avancar.setText(Main.controller.getMensagem("LoginADMBT_Avancar"));
        
        int larguraMaxima = 88; // Largura máxima da JLabel
        int alturaMaxima = 48; // Altura máxima da JLabel

        ImageIcon icon = new ImageIcon(getClass().getResource(Main.controller.getBandeira()));
        Image img = icon.getImage();

        // Redimensionar a imagem para as dimensões máximas
        Image novaImagem = img.getScaledInstance(larguraMaxima, alturaMaxima, Image.SCALE_SMOOTH);

        ImageIcon imagemRedimensionada = new ImageIcon(novaImagem);
        JL_Bandeira.setIcon(imagemRedimensionada);
        
        larguraMaxima = 83;
        alturaMaxima = 83;
        
        icon = new ImageIcon(getClass().getResource("/Image/EsquinaoLanches.png"));
        img = icon.getImage();

        // Redimensionar a imagem para as dimensões máximas
        novaImagem = img.getScaledInstance(larguraMaxima, alturaMaxima, Image.SCALE_SMOOTH);

        imagemRedimensionada = new ImageIcon(novaImagem);
        JL_ImagemEsquinao.setIcon(imagemRedimensionada);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JL_Login = new javax.swing.JLabel();
        JL_Nome = new javax.swing.JLabel();
        JL_Senha = new javax.swing.JLabel();
        BT_Avancar = new javax.swing.JButton();
        CampoDeTextoNome = new javax.swing.JTextField();
        CampoDeTextoSenha = new javax.swing.JPasswordField();
        JL_Bandeira = new javax.swing.JLabel();
        JL_ImagemEsquinao = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 102));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        setForeground(new java.awt.Color(255, 153, 51));

        JL_Login.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        JL_Login.setText("Login");

        JL_Nome.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        JL_Nome.setText("Nome:");

        JL_Senha.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        JL_Senha.setText("Senha:");

        BT_Avancar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BT_Avancar.setText("Avançar");
        BT_Avancar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_AvancarMouseClicked(evt);
            }
        });

        CampoDeTextoNome.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        CampoDeTextoNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CampoDeTextoNomeKeyPressed(evt);
            }
        });

        CampoDeTextoSenha.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        CampoDeTextoSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CampoDeTextoSenhaKeyPressed(evt);
            }
        });

        JL_Bandeira.setText("Bandeira");

        JL_ImagemEsquinao.setText("ImagemEsquinao");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 168, Short.MAX_VALUE)
                .addComponent(BT_Avancar)
                .addGap(141, 141, 141))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JL_Nome, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(JL_Senha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CampoDeTextoNome)
                            .addComponent(CampoDeTextoSenha)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JL_ImagemEsquinao, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(JL_Login)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JL_Bandeira, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JL_Login)
                            .addComponent(JL_Bandeira, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(JL_ImagemEsquinao, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Nome)
                    .addComponent(CampoDeTextoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_Senha)
                    .addComponent(CampoDeTextoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(BT_Avancar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
/**
     * Método executado quando o botão "Avançar" é clicado.
     * @param evt o evento de clique do mouse
     */
    private void BT_AvancarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_AvancarMouseClicked
        String senha = String.valueOf(CampoDeTextoSenha.getPassword());
        String nome = CampoDeTextoNome.getText();
        Main.controller.BT_AvancarMouseClickedLoginADM(senha, nome);
    }//GEN-LAST:event_BT_AvancarMouseClicked
/**
     * Método executado quando o usuário pressiona a tecla "Enter" no campo de texto do nome.
     * @param evt o evento de pressionar a tecla
     */
    private void CampoDeTextoNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoDeTextoNomeKeyPressed
        if(evt.getKeyChar() == KeyEvent.VK_ENTER){
            CampoDeTextoSenha.requestFocus();
        }
    }//GEN-LAST:event_CampoDeTextoNomeKeyPressed
/**
     * Método executado quando o usuário pressiona a tecla "Enter" no campo de texto da senha.
     * @param evt o evento de pressionar a tecla
     */
    private void CampoDeTextoSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoDeTextoSenhaKeyPressed
        if(evt.getKeyChar() == KeyEvent.VK_ENTER){
            String senha = String.valueOf(CampoDeTextoSenha.getPassword());
            String nome = CampoDeTextoNome.getText();
            Main.controller.BT_AvancarMouseClickedLoginADM(senha, nome);
        }
    }//GEN-LAST:event_CampoDeTextoSenhaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Avancar;
    private javax.swing.JTextField CampoDeTextoNome;
    private javax.swing.JPasswordField CampoDeTextoSenha;
    private javax.swing.JLabel JL_Bandeira;
    private javax.swing.JLabel JL_ImagemEsquinao;
    private javax.swing.JLabel JL_Login;
    private javax.swing.JLabel JL_Nome;
    private javax.swing.JLabel JL_Senha;
    // End of variables declaration//GEN-END:variables
}
