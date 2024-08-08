package View;

import Model.Pedido;
import Model.Lanche;
import Model.ConnectionPedido;
import Model.ClienteCadastrado;
import java.awt.BorderLayout;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import Main.Main;
import Model.CupomFiscal;
import java.awt.Image;
import javax.swing.ImageIcon;
/**
 * Painel para fazer pedidos de lanches.
 */
public class FazerPedido extends javax.swing.JPanel {

    // Lista de clientes cadastrados
    ArrayList<ClienteCadastrado> listaClientes = new ArrayList();
    // Lista de lanches disponíveis
    ArrayList<Lanche> listaLanches = new ArrayList();
    // Lista de pedidos realizados
    ArrayList<Pedido> listaPedidos = new ArrayList();
    // Lista de lanches adicionados ao carrinho
    ArrayList<Lanche> listaCarrinho = new ArrayList();
    // Nome do lanche selecionado
    String nomeLanche;
    // Total do pedido
    float total, totalAgua, totalSuco, totalRefri;

    /**
     * Adiciona lanches ao ComboBox de lanches disponíveis.
     */
    public void AdicionarComboBoxLanches() {
        try {
            for (int i = 0; i < listaLanches.size(); i++) {
                CB_Lanches.addItem(listaLanches.get(i).getNome());
            }
        } catch (Exception e) {
        }
    }

    /**
     * Adiciona clientes ao ComboBox de clientes cadastrados.
     */
    public void AdicionarComboBoxCliente() {
        try {
            for (int i = 0; i < listaClientes.size(); i++) {
                CB_Clientes.addItem(listaClientes.get(i).getNome());
            }
        } catch (Exception e) {
        }
    }

    /**
     * Adiciona opções de quantidade de bebidas aos ComboBoxes de quantidade.
     */
    public void AdicionarQuantidadeBebidas() {
        for (int i = 1; i <= 10; i++) {
            CB_QuantidadeAgua.addItem(Integer.toString(i));
            CB_QuantidadeSuco.addItem(Integer.toString(i));
            CB_QuantidadeRefrigerante.addItem(Integer.toString(i));
        }
    }

    /**
     * Adiciona lanches ao ComboBox de carrinho de compras.
     */
    public void AdicionarCarrinho() {
        try {
            for (int i = 0; i < listaCarrinho.size(); i++) {
                CB_Carrinho.addItem(listaCarrinho.get(i).getNome());
            }
        } catch (Exception e) {
        }
    }

    /**
     * Construtor da classe FazerPedido.
     *
     * @param listaClientes Lista de clientes cadastrados.
     * @param listaLanches  Lista de lanches disponíveis.
     * @param listaPedidos  Lista de pedidos realizados.
     */
    public FazerPedido() {
        initComponents();
        this.listaClientes = Main.controller.getListaClientes();
        this.listaLanches = Main.controller.getListaLanches();
        this.listaPedidos = Main.controller.getListaPedidos();
        this.nomeLanche = "";
        this.total = 0;
        this.totalAgua = 0;
        this.totalSuco = 0;
        this.totalRefri = 0;
        CB_Lanches.addItem(Main.controller.getMensagem("FazerPedidoCB_Lanches"));
        AdicionarComboBoxLanches();
        CB_Clientes.addItem(Main.controller.getMensagem("FazerPedidoCB_Clientes"));
        AdicionarComboBoxCliente();
        CampoDeTextoPreco.setEditable(false);
        AdicionarQuantidadeBebidas();
        CB_QuantidadeAgua.setEnabled(false);
        CB_QuantidadeRefrigerante.setEnabled(false);
        CB_QuantidadeSuco.setEnabled(false);
        CB_Carrinho.addItem(Main.controller.getMensagem("FazerPedidoCB_Carrinho"));
        CB_Carrinho.setEnabled(false);
        CB_Clientes.setEnabled(false);
        CampoDeTextoNome.setEditable(false);
        CampoDeTextoEndereco.setEditable(false);
        CampoDeTextoTelefone.setEditable(false);
        CampoDeTextoTotal.setEditable(false);
        CampoDeTextoPrecoAgua.setEditable(false);
        CampoDeTextoPrecoSuco.setEditable(false);
        CampoDeTextoPrecoRefri.setEditable(false);
        JL_FazerPedido.setText(Main.controller.getMensagem("FazerPedidoJL_FazerPedido"));
        JL_Nome.setText(Main.controller.getMensagem("FazerPedidoJL_Nome"));
        JL_Endereco.setText(Main.controller.getMensagem("FazerPedidoJL_Endereco"));
        JL_Telefone.setText(Main.controller.getMensagem("FazerPedidoJL_Telefone"));
        JL_Preco.setText(Main.controller.getMensagem("FazerPedidoJL_Preco"));
        JL_Ingredientes.setText(Main.controller.getMensagem("FazerPedidoJL_Ingredientes"));
        JL_Carrinho.setText(Main.controller.getMensagem("FazerPedidoJL_Carrinho"));
        JL_Bebidas.setText(Main.controller.getMensagem("FazerPedidoJL_Bebidas"));
        JL_Total.setText(Main.controller.getMensagem("FazerPedidoJL_Total"));
        BT_Adicionar.setText(Main.controller.getMensagem("FazerPedidoBT_Adicionar"));
        BT_Cancelar.setText(Main.controller.getMensagem("FazerPedidoBT_Cancelar"));
        BT_Confirmar.setText(Main.controller.getMensagem("FazerPedidoBT_Confirmar"));
        BT_ClienteCadastrado.setText(Main.controller.getMensagem("FazerPedidoBT_ClienteCadastrado"));
        BT_ClienteNaoCadastrado.setText(Main.controller.getMensagem("FazerPedidoBT_ClienteNaoCadastrado"));
        BT_Remover.setText(Main.controller.getMensagem("FazerPedidoBT_Remover"));
        RB_Agua.setText(Main.controller.getMensagem("FazerPedidoRB_Agua"));
        RB_Refrigerante.setText(Main.controller.getMensagem("FazerPedidoRB_Refrigerante"));
        RB_Suco.setText(Main.controller.getMensagem("FazerPedidoRB_Suco"));
        
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        JL_FazerPedido = new javax.swing.JLabel();
        BT_ClienteCadastrado = new javax.swing.JRadioButton();
        BT_ClienteNaoCadastrado = new javax.swing.JRadioButton();
        CB_Clientes = new javax.swing.JComboBox<>();
        JL_Nome = new javax.swing.JLabel();
        JL_Endereco = new javax.swing.JLabel();
        JL_Telefone = new javax.swing.JLabel();
        CampoDeTextoNome = new javax.swing.JTextField();
        CampoDeTextoEndereco = new javax.swing.JTextField();
        CampoDeTextoTelefone = new javax.swing.JTextField();
        CB_Lanches = new javax.swing.JComboBox<>();
        JL_Preco = new javax.swing.JLabel();
        CampoDeTextoPreco = new javax.swing.JTextField();
        JL_Ingredientes = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CampoDeTextoIngredientes = new javax.swing.JTextArea();
        BT_Adicionar = new javax.swing.JButton();
        JL_Bebidas = new javax.swing.JLabel();
        RB_Agua = new javax.swing.JRadioButton();
        RB_Suco = new javax.swing.JRadioButton();
        RB_Refrigerante = new javax.swing.JRadioButton();
        CB_QuantidadeAgua = new javax.swing.JComboBox<>();
        CB_QuantidadeSuco = new javax.swing.JComboBox<>();
        CB_QuantidadeRefrigerante = new javax.swing.JComboBox<>();
        CB_Carrinho = new javax.swing.JComboBox<>();
        BT_Remover = new javax.swing.JButton();
        BT_Cancelar = new javax.swing.JButton();
        BT_Confirmar = new javax.swing.JButton();
        JL_Carrinho = new javax.swing.JLabel();
        CampoDeTextoTotal = new javax.swing.JTextField();
        JL_Total = new javax.swing.JLabel();
        CampoDeTextoPrecoAgua = new javax.swing.JTextField();
        CampoDeTextoPrecoSuco = new javax.swing.JTextField();
        CampoDeTextoPrecoRefri = new javax.swing.JTextField();
        JL_EsquinaoLanches = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 204, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setPreferredSize(new java.awt.Dimension(732, 1010));

        JL_FazerPedido.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        JL_FazerPedido.setText("Fazer Pedido");

        BT_ClienteCadastrado.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BT_ClienteCadastrado.setText("Cliente Cadastrado");
        BT_ClienteCadastrado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_ClienteCadastradoMouseClicked(evt);
            }
        });

        BT_ClienteNaoCadastrado.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BT_ClienteNaoCadastrado.setText("Cliente Não Cadastrado");
        BT_ClienteNaoCadastrado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_ClienteNaoCadastradoMouseClicked(evt);
            }
        });

        CB_Clientes.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        CB_Clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CB_ClientesMouseClicked(evt);
            }
        });

        JL_Nome.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JL_Nome.setText("Nome:");

        JL_Endereco.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JL_Endereco.setText("Endereço:");

        JL_Telefone.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JL_Telefone.setText("Telefone:");

        CampoDeTextoNome.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        CampoDeTextoEndereco.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        CampoDeTextoTelefone.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        CB_Lanches.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        CB_Lanches.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CB_LanchesMouseClicked(evt);
            }
        });

        JL_Preco.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JL_Preco.setText("Preço:");

        CampoDeTextoPreco.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        CampoDeTextoPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoDeTextoPrecoActionPerformed(evt);
            }
        });

        JL_Ingredientes.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JL_Ingredientes.setText("Ingredientes:");

        CampoDeTextoIngredientes.setColumns(20);
        CampoDeTextoIngredientes.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        CampoDeTextoIngredientes.setRows(5);
        jScrollPane2.setViewportView(CampoDeTextoIngredientes);

        BT_Adicionar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BT_Adicionar.setText("Adicionar");
        BT_Adicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_AdicionarMouseClicked(evt);
            }
        });

        JL_Bebidas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JL_Bebidas.setText("Bebidas:");

        RB_Agua.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        RB_Agua.setText("Água");
        RB_Agua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RB_AguaMouseClicked(evt);
            }
        });

        RB_Suco.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        RB_Suco.setText("Suco");
        RB_Suco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RB_SucoMouseClicked(evt);
            }
        });

        RB_Refrigerante.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        RB_Refrigerante.setText("Refrigerante");
        RB_Refrigerante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RB_RefrigeranteMouseClicked(evt);
            }
        });

        CB_QuantidadeAgua.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        CB_QuantidadeAgua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CB_QuantidadeAguaMouseClicked(evt);
            }
        });

        CB_QuantidadeSuco.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        CB_QuantidadeSuco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CB_QuantidadeSucoMouseClicked(evt);
            }
        });

        CB_QuantidadeRefrigerante.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        CB_QuantidadeRefrigerante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CB_QuantidadeRefrigeranteMouseClicked(evt);
            }
        });
        CB_QuantidadeRefrigerante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_QuantidadeRefrigeranteActionPerformed(evt);
            }
        });

        CB_Carrinho.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        CB_Carrinho.setPreferredSize(new java.awt.Dimension(140, 35));
        CB_Carrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CB_CarrinhoMouseClicked(evt);
            }
        });

        BT_Remover.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BT_Remover.setText("Remover");
        BT_Remover.setPreferredSize(new java.awt.Dimension(129, 37));
        BT_Remover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_RemoverMouseClicked(evt);
            }
        });

        BT_Cancelar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BT_Cancelar.setText("Cancelar");
        BT_Cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_CancelarMouseClicked(evt);
            }
        });

        BT_Confirmar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BT_Confirmar.setText("Confirmar");
        BT_Confirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_ConfirmarMouseClicked(evt);
            }
        });

        JL_Carrinho.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JL_Carrinho.setText("Carrinho:");

        CampoDeTextoTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        JL_Total.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JL_Total.setText("Total:");

        CampoDeTextoPrecoAgua.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        CampoDeTextoPrecoSuco.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        CampoDeTextoPrecoRefri.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        JL_EsquinaoLanches.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JL_EsquinaoLanches, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(239, 239, 239)
                        .addComponent(JL_FazerPedido))
                    .addComponent(JL_Bebidas)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(RB_Suco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RB_Agua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RB_Refrigerante, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CB_QuantidadeAgua, 0, 111, Short.MAX_VALUE)
                            .addComponent(CB_QuantidadeSuco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CB_QuantidadeRefrigerante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(CampoDeTextoPrecoSuco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(CampoDeTextoPrecoRefri)
                            .addComponent(CampoDeTextoPrecoAgua)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(BT_Adicionar)
                            .addGap(18, 18, 18)
                            .addComponent(BT_Remover, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JL_Carrinho)
                            .addGap(27, 27, 27)
                            .addComponent(CB_Carrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(JL_Ingredientes, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(JL_Total))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(BT_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(BT_Confirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CampoDeTextoTotal)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(CB_Lanches, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JL_Preco)
                                    .addGap(18, 18, 18))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(JL_Nome)
                                                .addComponent(JL_Endereco)
                                                .addComponent(JL_Telefone))
                                            .addGap(31, 31, 31)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(CampoDeTextoNome)
                                                .addComponent(CampoDeTextoEndereco)
                                                .addComponent(CampoDeTextoTelefone)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(BT_ClienteCadastrado, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(BT_ClienteNaoCadastrado)))
                                    .addGap(27, 27, 27)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(CB_Clientes, 0, 140, Short.MAX_VALUE)
                                .addComponent(CampoDeTextoPreco)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_FazerPedido)
                    .addComponent(JL_EsquinaoLanches, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BT_ClienteCadastrado)
                    .addComponent(BT_ClienteNaoCadastrado)
                    .addComponent(CB_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Nome)
                    .addComponent(CampoDeTextoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Endereco)
                    .addComponent(CampoDeTextoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Telefone)
                    .addComponent(CampoDeTextoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CB_Lanches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_Preco)
                    .addComponent(CampoDeTextoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(JL_Ingredientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BT_Adicionar)
                    .addComponent(CB_Carrinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Remover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_Carrinho))
                .addGap(18, 18, 18)
                .addComponent(JL_Bebidas)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(RB_Agua)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RB_Suco)
                            .addComponent(CB_QuantidadeSuco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoDeTextoPrecoSuco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RB_Refrigerante)
                            .addComponent(CB_QuantidadeRefrigerante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoDeTextoPrecoRefri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CB_QuantidadeAgua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CampoDeTextoPrecoAgua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoDeTextoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_Total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BT_Cancelar)
                    .addComponent(BT_Confirmar))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
/**
     * Método executado quando o botão de cliente cadastrado é clicado.
     *
     * @param evt O evento de clique do mouse.
     */
    private void BT_ClienteCadastradoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_ClienteCadastradoMouseClicked
        if (BT_ClienteCadastrado.isSelected()) {
            CB_Clientes.setEnabled(true);
            BT_ClienteNaoCadastrado.setEnabled(false);
        } else {
            CB_Clientes.setEnabled(false);
            BT_ClienteNaoCadastrado.setEnabled(true);
            CampoDeTextoTelefone.setText("");
            CampoDeTextoNome.setText("");
            CampoDeTextoEndereco.setText("");
            CB_Clientes.setSelectedIndex(0);
        }
    }//GEN-LAST:event_BT_ClienteCadastradoMouseClicked
/**
     * Método executado quando o botão de cliente não cadastrado é clicado.
     *
     * @param evt O evento de clique do mouse.
     */
    private void BT_ClienteNaoCadastradoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_ClienteNaoCadastradoMouseClicked
        if (BT_ClienteNaoCadastrado.isSelected()) {
            BT_ClienteCadastrado.setEnabled(false);
            CampoDeTextoNome.setEditable(true);
            CampoDeTextoEndereco.setEditable(true);
            CampoDeTextoTelefone.setEditable(true);
        } else {
            BT_ClienteCadastrado.setEnabled(true);
            BT_ClienteCadastrado.setEnabled(true);
            CampoDeTextoNome.setEditable(false);
            CampoDeTextoEndereco.setEditable(false);
            CampoDeTextoTelefone.setEditable(false);
            CampoDeTextoTelefone.setText("");
            CampoDeTextoNome.setText("");
            CampoDeTextoEndereco.setText("");
        }
    }//GEN-LAST:event_BT_ClienteNaoCadastradoMouseClicked
/**
     * Método executado quando um item do ComboBox de clientes é clicado.
     *
     * @param evt O evento de clique do mouse.
     */
    private void CB_ClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CB_ClientesMouseClicked
        try {
            for (int i = 0; i < listaClientes.size(); i++) {
                if (CB_Clientes.getSelectedItem().toString().equalsIgnoreCase(listaClientes.get(i).getNome())) {
                    CampoDeTextoNome.setText(listaClientes.get(i).getNome());
                    CampoDeTextoEndereco.setText(listaClientes.get(i).getEndereco());
                    CampoDeTextoTelefone.setText(listaClientes.get(i).getTelefone());
                    break;
                }
            }
        } catch (Exception e) {
            CampoDeTextoTelefone.setText("");
            CampoDeTextoNome.setText("");
            CampoDeTextoTelefone.setText("");
            CB_Clientes.setSelectedIndex(0);
        }
    }//GEN-LAST:event_CB_ClientesMouseClicked
 /**
     * Método executado quando um item do ComboBox de lanches é clicado.
     *
     * @param evt O evento de clique do mouse.
     */
    private void CB_LanchesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CB_LanchesMouseClicked
        try {
            for (int i = 0; i < listaLanches.size(); i++) {
                if (CB_Lanches.getSelectedItem().toString().equalsIgnoreCase(listaLanches.get(i).getNome())) {
                    this.nomeLanche = listaLanches.get(i).getNome();
                    CampoDeTextoIngredientes.setText(listaLanches.get(i).getIngredientes());
                    CampoDeTextoPreco.setText(Float.toString(listaLanches.get(i).getPreco()));
                    CampoDeTextoIngredientes.setEditable(true);
                    break;
                }
            }
        } catch (Exception e) {
            this.nomeLanche = "";
            CampoDeTextoIngredientes.setText("");
            CampoDeTextoPreco.setText("");
            CB_Lanches.setSelectedIndex(0);
        }
    }//GEN-LAST:event_CB_LanchesMouseClicked

    private void CampoDeTextoPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoDeTextoPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoDeTextoPrecoActionPerformed
/**
     * Método executado quando o botão de adicionar é clicado para adicionar um lanche ao carrinho.
     *
     * @param evt O evento de clique do mouse.
     */
    private void BT_AdicionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_AdicionarMouseClicked
        try {
            if (CB_Lanches.getSelectedIndex() != 0) {
                String nomeLanche = (String) CB_Lanches.getSelectedItem();
                String nomeLancheRepetido = "";

                for (int i = 0; i < CB_Carrinho.getItemCount(); i++) {

                    if (nomeLanche.equalsIgnoreCase(CB_Carrinho.getItemAt(i))) {
                        nomeLancheRepetido = nomeLanche + " " + Integer.toString(i);
                    } else {
                        if (nomeLancheRepetido.equalsIgnoreCase((CB_Carrinho.getItemAt(i)))) {
                            nomeLancheRepetido = nomeLanche + " " + Integer.toString(i);
                        }
                    }
                }

                String ingredientes = CampoDeTextoIngredientes.getText();
                float preco = Float.parseFloat(CampoDeTextoPreco.getText());
                if (nomeLancheRepetido.equalsIgnoreCase("")) {
                    Lanche lanche = new Lanche(nomeLanche, ingredientes, preco);
                    listaCarrinho.add(lanche);
                    Main.controller.setListaCarrinho(listaCarrinho);
                    CB_Carrinho.removeAllItems();
                    CB_Carrinho.addItem(Main.controller.getMensagem("FazerPedidoBT_AdicionarMouseClicked1"));
                    AdicionarCarrinho();
                    CB_Carrinho.setSelectedIndex(0);
                    CampoDeTextoPreco.setText("");
                    CampoDeTextoIngredientes.setText("");
                    CB_Lanches.setSelectedIndex(0);
                    CB_Carrinho.setEnabled(true);
                    this.total += preco;
                    CampoDeTextoTotal.setText(Float.toString(this.total));
                } else {
                    Lanche lanche = new Lanche(nomeLancheRepetido, ingredientes, preco);
                    listaCarrinho.add(lanche);
                    Main.controller.setListaCarrinho(listaCarrinho);
                    CB_Carrinho.removeAllItems();
                    CB_Carrinho.addItem(Main.controller.getMensagem("FazerPedidoBT_AdicionarMouseClicked2"));
                    AdicionarCarrinho();
                    CB_Carrinho.setSelectedIndex(0);
                    CampoDeTextoPreco.setText("");
                    CampoDeTextoIngredientes.setText("");
                    CB_Lanches.setSelectedIndex(0);
                    CB_Carrinho.setEnabled(true);
                    this.total += preco;
                    CampoDeTextoTotal.setText(Float.toString(this.total));
                }
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, Main.controller.getMensagem("FazerPedidoBT_AdicionarMouseClicked3"));
        }
    }//GEN-LAST:event_BT_AdicionarMouseClicked
/**
     * Método executado quando o RadioButton de água é clicado para selecionar a quantidade de água.
     *
     * @param evt O evento de clique do mouse.
     */
    private void RB_AguaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RB_AguaMouseClicked
        if (RB_Agua.isSelected()) {
            CB_QuantidadeAgua.setEnabled(true);
            this.totalAgua += (Main.controller.getMoeda() * 2.50);
            this.total += this.totalAgua;
            CampoDeTextoTotal.setText(Float.toString(this.total));
            CampoDeTextoPrecoAgua.setText(Float.toString(this.totalAgua));
        } else {
            CB_QuantidadeAgua.setEnabled(false);
            CB_QuantidadeAgua.setSelectedIndex(0);
            this.total -= this.totalAgua;
            this.totalAgua = 0;
            CampoDeTextoTotal.setText(Float.toString(this.total));
            CampoDeTextoPrecoAgua.setText(Float.toString(this.totalAgua));
        }
    }//GEN-LAST:event_RB_AguaMouseClicked
/**
     * Método executado quando o RadioButton de suco é clicado para selecionar a quantidade de suco.
     *
     * @param evt O evento de clique do mouse.
     */
    private void RB_SucoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RB_SucoMouseClicked
        if (RB_Suco.isSelected()) {
            CB_QuantidadeSuco.setEnabled(true);
            this.totalSuco += (Main.controller.getMoeda() * 3.50);
            this.total += this.totalSuco;
            CampoDeTextoTotal.setText(Float.toString(this.total));
            CampoDeTextoPrecoSuco.setText(Float.toString(this.totalSuco));
        } else {
            CB_QuantidadeSuco.setEnabled(false);
            CB_QuantidadeSuco.setSelectedIndex(0);
            this.total -= this.totalSuco;
            this.totalSuco = 0;
            CampoDeTextoTotal.setText(Float.toString(this.total));
            CampoDeTextoPrecoSuco.setText(Float.toString(this.totalSuco));
        }
    }//GEN-LAST:event_RB_SucoMouseClicked
/**
     * Método executado quando o RadioButton de refrigerante é clicado para selecionar a quantidade de refrigerante.
     *
     * @param evt O evento de clique do mouse.
     */
    private void RB_RefrigeranteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RB_RefrigeranteMouseClicked
        if (RB_Refrigerante.isSelected()) {
            CB_QuantidadeRefrigerante.setEnabled(true);
            this.totalRefri += (Main.controller.getMoeda() * 4.50);
            this.total += this.totalRefri;
            CampoDeTextoTotal.setText(Float.toString(this.total));
            CampoDeTextoPrecoRefri.setText(Float.toString(this.totalRefri));
        } else {
            CB_QuantidadeRefrigerante.setEnabled(false);
            CB_QuantidadeRefrigerante.setSelectedIndex(0);
            this.total -= this.totalRefri;
            this.totalRefri = 0;
            CampoDeTextoTotal.setText(Float.toString(this.total));
            CampoDeTextoPrecoRefri.setText(Float.toString(this.totalRefri));
        }
    }//GEN-LAST:event_RB_RefrigeranteMouseClicked
/**
     * Método executado quando a ComboBox de quantidade de água é clicada para selecionar a quantidade de água.
     *
     * @param evt O evento de clique do mouse.
     */
    private void CB_QuantidadeAguaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CB_QuantidadeAguaMouseClicked
        String quantidadeString = CB_QuantidadeAgua.getSelectedItem().toString();
        float quantidade = Float.parseFloat(quantidadeString);
        this.total -= this.totalAgua;
        this.totalAgua = 0;
        this.totalAgua = (float) ((Main.controller.getMoeda() * 2.50) * quantidade);
        this.total += this.totalAgua;
        CampoDeTextoTotal.setText(Float.toString(this.total));
        CampoDeTextoPrecoAgua.setText(Float.toString(this.totalAgua));
    }//GEN-LAST:event_CB_QuantidadeAguaMouseClicked
/**
     * Método executado quando a ComboBox de quantidade de suco é clicada para selecionar a quantidade de suco.
     *
     * @param evt O evento de clique do mouse.
     */
    private void CB_QuantidadeSucoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CB_QuantidadeSucoMouseClicked
        String quantidadeString = CB_QuantidadeSuco.getSelectedItem().toString();
        float quantidade = Float.parseFloat(quantidadeString);
        this.total -= this.totalSuco;
        this.totalSuco = 0;
        this.totalSuco = (float) ((Main.controller.getMoeda() * 3.50) * quantidade);
        this.total += this.totalSuco;
        CampoDeTextoTotal.setText(Float.toString(this.total));
        CampoDeTextoPrecoSuco.setText(Float.toString(this.totalSuco));
    }//GEN-LAST:event_CB_QuantidadeSucoMouseClicked
/**
     * Método executado quando a ComboBox de quantidade de refrigerante é clicada para selecionar a quantidade de refrigerante.
     *
     * @param evt O evento de clique do mouse.
     */
    private void CB_QuantidadeRefrigeranteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CB_QuantidadeRefrigeranteMouseClicked
        String quantidadeString = CB_QuantidadeRefrigerante.getSelectedItem().toString();
        float quantidade = Float.parseFloat(quantidadeString);
        this.total -= this.totalRefri;
        this.totalRefri = 0;
        this.totalRefri = (float) ((Main.controller.getMoeda() * 4.50) * quantidade);
        this.total += this.totalRefri;
        CampoDeTextoTotal.setText(Float.toString(this.total));
        CampoDeTextoPrecoRefri.setText(Float.toString(this.totalRefri));
    }//GEN-LAST:event_CB_QuantidadeRefrigeranteMouseClicked

    private void CB_QuantidadeRefrigeranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_QuantidadeRefrigeranteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_QuantidadeRefrigeranteActionPerformed
/**
     * Método executado quando a ComboBox do carrinho é clicada para selecionar um item do carrinho.
     *
     * @param evt O evento de clique do mouse.
     */
    private void CB_CarrinhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CB_CarrinhoMouseClicked
        try {
            if (CB_Carrinho.getSelectedIndex() != 0) {
                for (int i = 0; i < listaCarrinho.size(); i++) {
                    if (CB_Carrinho.getSelectedItem().toString().equalsIgnoreCase(listaCarrinho.get(i).getNome())) {
                        CampoDeTextoPreco.setText(Float.toString(listaCarrinho.get(i).getPreco()));
                        CampoDeTextoIngredientes.setText(listaCarrinho.get(i).getIngredientes());
                        CampoDeTextoIngredientes.setEditable(false);
                        break;
                    }
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_CB_CarrinhoMouseClicked
/**
     * Método executado quando o botão de remover é clicado para remover um item do carrinho.
     *
     * @param evt O evento de clique do mouse.
     */
    private void BT_RemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_RemoverMouseClicked

        try {
            if (CB_Carrinho.getSelectedIndex() != 0) {
                for (int i = 0; i < listaCarrinho.size(); i++) {
                    if (CB_Carrinho.getSelectedItem().toString().equalsIgnoreCase(listaCarrinho.get(i).getNome())) {
                        this.total -= listaCarrinho.get(i).getPreco();
                        CampoDeTextoTotal.setText(Float.toString(this.total));
                        listaCarrinho.remove(listaCarrinho.get(i));
                        Main.controller.setListaCarrinho(listaCarrinho);
                        CB_Carrinho.removeItemAt(CB_Carrinho.getSelectedIndex());
                        CB_Carrinho.setSelectedIndex(0);
                        CampoDeTextoPreco.setText("");
                        CampoDeTextoIngredientes.setText("");
                        break;
                    }
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_BT_RemoverMouseClicked
/**
     * Método executado quando o botão de cancelar é clicado para cancelar o pedido.
     *
     * @param evt O evento de clique do mouse.
     */
    private void BT_CancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_CancelarMouseClicked
        try {
            int i = JOptionPane.showConfirmDialog(null, Main.controller.getMensagem("FazerPedidoBT_CancelarMouseClicked"));
            if (i == 0) {
                Main.controller.TelaPrincipal();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_BT_CancelarMouseClicked
/**
     * Método executado quando o botão de confirmar é clicado para confirmar um pedido.
     *
     * @param evt O evento de clique do mouse.
     */
    private void BT_ConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_ConfirmarMouseClicked
        
        try {

            if (!BT_ClienteCadastrado.isSelected() && !BT_ClienteNaoCadastrado.isSelected()) {
                JOptionPane.showMessageDialog(null, Main.controller.getMensagem("FazerPedidoBT_ConfirmarMouseClicked1"));
                throw new Exception();
            }

            if (BT_ClienteNaoCadastrado.isSelected() && CampoDeTextoNome.getText().equalsIgnoreCase("") && CampoDeTextoEndereco.getText().equalsIgnoreCase("") && CampoDeTextoTelefone.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, Main.controller.getMensagem("FazerPedidoBT_ConfirmarMouseClicked2"));
                throw new Exception();
            }

            if (listaCarrinho.isEmpty()) {
                JOptionPane.showMessageDialog(null, Main.controller.getMensagem("FazerPedidoBT_ConfirmarMouseClicked3"));
                throw new Exception();
            }

            System.out.println("Antes de criar o cupom fiscal");
            
            CupomFiscal cupomfiscal = new CupomFiscal();
            
            System.out.println("Depois de Criar o Objeto Cupom Fiscal");
            
            String mostrarPedido = "";
            String comecoCupomFiscal = Main.controller.getMensagem("FazerPedidoBT_ConfirmarMouseClicked7") + ": " + CampoDeTextoNome.getText() + "\n" + Main.controller.getMensagem("FazerPedidoBT_ConfirmarMouseClicked8") + ": " + CampoDeTextoEndereco.getText() + "\n" + Main.controller.getMensagem("FazerPedidoBT_ConfirmarMouseClicked9") + ": " + CampoDeTextoTelefone.getText();
            cupomfiscal.adicionarMensagem(comecoCupomFiscal);
            System.out.println("Teste para ver se passou do primeiro add do Cupom Fiscal");
                for (Lanche lanche : listaCarrinho) {
                    mostrarPedido = mostrarPedido + lanche.getNome() + ": " + Main.controller.getMensagem("MoedaDinheiro") + Float.toString(lanche.getPreco()) + "\n";
                    String addCupomFiscal = lanche.getNome() + ": " + Main.controller.getMensagem("MoedaDinheiro") + Float.toString(lanche.getPreco()) + "\n";
                    cupomfiscal.adicionarMensagem(addCupomFiscal);
                }
                if (totalAgua != 0) {
                    mostrarPedido += CB_QuantidadeAgua.getSelectedItem().toString() + "X " + Main.controller.getMensagem("FazerPedidoBT_ConfirmarMouseClicked4") + ": " + Main.controller.getMensagem("MoedaDinheiro") + this.totalAgua + "\n";
                    String addCupomFiscal = CB_QuantidadeAgua.getSelectedItem().toString() + "X " + Main.controller.getMensagem("FazerPedidoBT_ConfirmarMouseClicked4") + ": " + Main.controller.getMensagem("MoedaDinheiro") + this.totalAgua + "\n";
                    cupomfiscal.adicionarMensagem(addCupomFiscal);
                }
                if (this.totalSuco != 0) {
                    mostrarPedido += CB_QuantidadeSuco.getSelectedItem().toString() + "X " + Main.controller.getMensagem("FazerPedidoBT_ConfirmarMouseClicked5") + ": " + Main.controller.getMensagem("MoedaDinheiro") + this.totalSuco + "\n";
                    String addCupomFiscal = CB_QuantidadeSuco.getSelectedItem().toString() + "X " + Main.controller.getMensagem("FazerPedidoBT_ConfirmarMouseClicked5") + ": " + Main.controller.getMensagem("MoedaDinheiro") + this.totalSuco + "\n";
                    cupomfiscal.adicionarMensagem(addCupomFiscal);
                }
                if (this.totalRefri != 0) {
                    mostrarPedido += CB_QuantidadeRefrigerante.getSelectedItem().toString() + "X " + Main.controller.getMensagem("FazerPedidoBT_ConfirmarMouseClicked6") + ": " + Main.controller.getMensagem("MoedaDinheiro") + this.totalRefri + "\n";
                    String addCupomFiscal = CB_QuantidadeRefrigerante.getSelectedItem().toString() + "X " + Main.controller.getMensagem("FazerPedidoBT_ConfirmarMouseClicked6") + ": " + Main.controller.getMensagem("MoedaDinheiro") + this.totalRefri + "\n";
                    cupomfiscal.adicionarMensagem(addCupomFiscal);
                }
                mostrarPedido = Main.controller.getMensagem("FazerPedidoBT_ConfirmarMouseClicked7") + ": " + CampoDeTextoNome.getText() + "\n" + Main.controller.getMensagem("FazerPedidoBT_ConfirmarMouseClicked8") + ": " + CampoDeTextoEndereco.getText() + "\n" + Main.controller.getMensagem("FazerPedidoBT_ConfirmarMouseClicked9") + ": " + CampoDeTextoTelefone.getText() + "\n" + mostrarPedido + "\n" + Main.controller.getMensagem("FazerPedidoBT_ConfirmarMouseClicked10") + ": " + Main.controller.getMensagem("MoedaDinheiro") + this.total;
            
            String Ecadastrado = "";

                    if (BT_ClienteCadastrado.isSelected()) {
                        Ecadastrado = "Cadastrado";
                    } else {
                        Ecadastrado = Main.controller.getMensagem("FazerPedidoBT_ConfirmarMouseClicked12");
                    }
            
            String nome = CampoDeTextoNome.getText();
            String telefone = CampoDeTextoTelefone.getText();
                    
            Main.controller.BT_ConfirmarMouseClickedFazerPedido(this.total, this.totalAgua, this.totalSuco, this.totalRefri, mostrarPedido, Ecadastrado, nome, telefone, cupomfiscal);
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_BT_ConfirmarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Adicionar;
    private javax.swing.JButton BT_Cancelar;
    private javax.swing.JRadioButton BT_ClienteCadastrado;
    private javax.swing.JRadioButton BT_ClienteNaoCadastrado;
    private javax.swing.JButton BT_Confirmar;
    private javax.swing.JButton BT_Remover;
    private javax.swing.JComboBox<String> CB_Carrinho;
    private javax.swing.JComboBox<String> CB_Clientes;
    private javax.swing.JComboBox<String> CB_Lanches;
    private javax.swing.JComboBox<String> CB_QuantidadeAgua;
    private javax.swing.JComboBox<String> CB_QuantidadeRefrigerante;
    private javax.swing.JComboBox<String> CB_QuantidadeSuco;
    private javax.swing.JTextField CampoDeTextoEndereco;
    private javax.swing.JTextArea CampoDeTextoIngredientes;
    private javax.swing.JTextField CampoDeTextoNome;
    private javax.swing.JTextField CampoDeTextoPreco;
    private javax.swing.JTextField CampoDeTextoPrecoAgua;
    private javax.swing.JTextField CampoDeTextoPrecoRefri;
    private javax.swing.JTextField CampoDeTextoPrecoSuco;
    private javax.swing.JTextField CampoDeTextoTelefone;
    private javax.swing.JTextField CampoDeTextoTotal;
    private javax.swing.JLabel JL_Bebidas;
    private javax.swing.JLabel JL_Carrinho;
    private javax.swing.JLabel JL_Endereco;
    private javax.swing.JLabel JL_EsquinaoLanches;
    private javax.swing.JLabel JL_FazerPedido;
    private javax.swing.JLabel JL_Ingredientes;
    private javax.swing.JLabel JL_Nome;
    private javax.swing.JLabel JL_Preco;
    private javax.swing.JLabel JL_Telefone;
    private javax.swing.JLabel JL_Total;
    private javax.swing.JRadioButton RB_Agua;
    private javax.swing.JRadioButton RB_Refrigerante;
    private javax.swing.JRadioButton RB_Suco;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
