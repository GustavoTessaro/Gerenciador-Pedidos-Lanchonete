
package View;

import java.awt.BorderLayout;
/**
 * Classe responsável por criar e gerenciar a janela principal da aplicação.
 */
public class Janela extends javax.swing.JFrame {
// Declaração de painéis estáticos para diferentes telas da aplicação
    static LoginADM p1;
    static Principal p2;
    static CadastarLanches p3;
    static CadastrarCliente p4;
    static ListaClientesCadastrados p5;
    static FazerPedido p6;
    static PedidosDoDia p7;
    /**
     * Construtor da classe Janela.
     */
    public Janela() {
        initComponents();
        // Inicialização da primeira tela (LoginADM) e adição à janela principal
        this.setLayout(new BorderLayout());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * Método principal que inicializa a aplicação.
     * @param args os argumentos da linha de comando (não utilizados neste caso)
     */
    public static void main(String args[]) {
// Invoca a interface de evento do AWT (Abstract Window Toolkit) para execução na fila de eventos da AWT.
        java.awt.EventQueue.invokeLater(new Runnable() {
            // Implementação do método run da interface Runnable para iniciar a execução da aplicação.
            public void run() {
                // Cria uma instância da classe Janela e torna a janela visível.
                new Janela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
