
package Controller;

import Model.ClienteCadastrado;
import Model.ClienteNaoCadastrado;
import Model.ConnectionCliente;
import Model.ConnectionLanche;
import Model.ConnectionPedido;
import Model.CupomFiscal;
import Model.InterfaceCliente;
import Model.Lanche;
import Model.Pedido;
import Model.Pessoa;
import View.CadastarLanches;
import View.CadastrarCliente;
import View.FazerPedido;
import View.Janela;
import View.ListaClientesCadastrados;
import View.LoginADM;
import View.PedidosDoDia;
import View.Principal;
import java.awt.BorderLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.sql.Connection;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Controller {
    
    //Objetos das views.
    private LoginADM p1;
    private Principal p2;
    private CadastarLanches p3;
    private CadastrarCliente p4;
    private ListaClientesCadastrados p5;
    private FazerPedido p6;
    private PedidosDoDia p7; 
    private Janela janela;
    private String url;
    private String usuario;
    private String senha;
    
    private Locale currentLocale;
    private ResourceBundle mensagens;
    
    private String imagemBandeira;
    
    private double moeda;
    
    // Lista de clientes cadastrados
    ArrayList<ClienteCadastrado> listaClientes = new ArrayList();
    // Lista de lanches disponíveis
    ArrayList<Lanche> listaLanches = new ArrayList();
    // Lista de pedidos realizados
    ArrayList<Pedido> listaPedidos = new ArrayList();
    // Lista de lanches adicionados ao carrinho
    ArrayList<Lanche> listaCarrinho = new ArrayList();

    public Controller() {
        janela = new Janela();
        janela.setLocationRelativeTo(null); // Centraliza a janela na tela
        janela.setVisible(true); // Torna a janela visível
    }
    
    public void mostraTela(JPanel newPanel){
        this.janela.getContentPane().removeAll();       //Remove o conteúdo atual do frame.
        this.janela.add(newPanel, BorderLayout.CENTER); //Adiciona o novo painel ao frame.
        this.janela.pack();                             //Redimensiona o frame.
        janela.setLocationRelativeTo(null);
    }

    public void start(){
        // Determinar o idioma do usuário
        this.currentLocale = Locale.getDefault();
        
        String linguagem = currentLocale.getLanguage();
        
        // para testar as linguagens comente o código da linha acima e descomente a linha abaixo
        //String lingaguem = "pt";
        
        if(linguagem.equalsIgnoreCase("pt")){
            this.currentLocale = new Locale ("pt", "BR");
            this.imagemBandeira = "/Image/BandeiraBrasil.png";
            this.moeda = 1;
        }
        else{
            if(linguagem.equalsIgnoreCase("en")){
                this.currentLocale = new Locale ("en", "US");
                this.imagemBandeira = "/Image/BandeiraEstadosUnidos.png";
                this.moeda = 0.19;
            }
            else{
                if(linguagem.equalsIgnoreCase("es")){
                    this.currentLocale = new Locale ("es", "ES");
                    this.imagemBandeira = "/Image/BandeiraEspanha.png";
                    this.moeda = 0.18;
                }
                else{
                    if(linguagem.equalsIgnoreCase("it")){
                        this.currentLocale = new Locale ("it", "IT");
                        this.imagemBandeira = "/Image/BandeiraItalia.png";
                        this.moeda = 0.18;
                    }
                    else{
                        if(linguagem.equalsIgnoreCase("ru")){
                            this.currentLocale = new Locale ("ru", "RU");
                            this.imagemBandeira = "/Image/BandeiraRussia.png";
                            this.moeda = 17.85;
                        }
                        else{
                            if(linguagem.equalsIgnoreCase("de")){
                                this.currentLocale = new Locale ("de", "DE");
                                this.imagemBandeira = "/Image/BandeiraAlemanha.png";
                                this.moeda = 0.18;
                            }
                            else{
                                this.currentLocale = new Locale ("pt", "BR");
                                this.imagemBandeira = "/Image/BandeiraBrasil.png";
                                this.moeda = 1;
                            }
                        }
                    }
                }
            }
        }
        
        // Carregar o arquivo de propriedades correspondente ao idioma atual
        this.mensagens = ResourceBundle.getBundle("Languages/messages", currentLocale);
        
        this.p1 = new LoginADM();
        this.mostraTela(this.p1);  
        this.janela.setVisible(true);
        try {
            FileInputStream arquivo1 = new FileInputStream("Clientes.ser");
            ObjectInputStream in = new ObjectInputStream(arquivo1);

            this.listaClientes = (ArrayList<ClienteCadastrado>) in.readObject();
            in.close();
            arquivo1.close();
        } catch (Exception e) {
        }
        try {
            FileInputStream arquivo2 = new FileInputStream("Lanches.ser");
            ObjectInputStream in = new ObjectInputStream(arquivo2);

            this.listaLanches = (ArrayList<Lanche>) in.readObject();
            in.close();
            arquivo2.close();
        } catch (Exception e) {
        }
        try {
            FileInputStream arquivo3 = new FileInputStream("Pedidos.ser");
            ObjectInputStream in = new ObjectInputStream(arquivo3);

            this.listaPedidos = (ArrayList<Pedido>) in.readObject();
            in.close();
            arquivo3.close();
        } catch (Exception e) {
        }
        
        this.url = "jdbc:mysql://localhost:3306/bancodedadosesquinaolanches";
        this. usuario = "root";
        this. senha = "";
    }
    
    public double getMoeda(){
        return this.moeda;
    }
    
    public String getBandeira(){
        return this.imagemBandeira;
    }

    public ArrayList<ClienteCadastrado> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<ClienteCadastrado> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Lanche> getListaLanches() {
        return listaLanches;
    }

    public void setListaLanches(ArrayList<Lanche> listaLanches) {
        this.listaLanches = listaLanches;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
    
    public ArrayList<Lanche> getListaCarrinho() {
        return listaCarrinho;
    }

    public void setListaCarrinho(ArrayList<Lanche> listaCarrinho) {
        this.listaCarrinho = listaCarrinho;
    }
    
    public void TelaPrincipal() throws IOException{
        this.p2 = new Principal();
        this.mostraTela(p2);
    }

    public void TelaCadastarLanches() throws IOException{
        this.p3 = new CadastarLanches();
        this.mostraTela(p3);
    }
    
    public void TelaCadastrarCliente() throws IOException{
        this.p4 = new CadastrarCliente();
        this.mostraTela(p4);
    }
    
    public void TelaListaClientesCadastrados() throws IOException{
        this.p5 = new ListaClientesCadastrados();
        this.mostraTela(p5);
    }
    
    public void TelaFazerPedido() throws IOException{
        this.p6 = new FazerPedido();
        this.mostraTela(p6);
    }
    
    public void TelaPedidosDoDia() throws IOException{
        this.p7 = new PedidosDoDia();
        this.mostraTela(p7);
    }
    
    public String getMensagem(String mensagemP){
        
        String mostrar = this.mensagens.getString(mensagemP);
        
        return mostrar;
        
    }
    
    public void BT_AvancarMouseClickedLoginADM(String senha, String nome) {                                        
        try {
            if(nome.equalsIgnoreCase("Atendente") && senha.equalsIgnoreCase("EsquinaoLanches123")){
                TelaPrincipal();
            }
            else{
                throw new Exception();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, getMensagem("Mensagem1BT_AvancarMouseClickedLoginADM"));
        }
    } 
    
    public void BT_SalvarMouseClickedTelaCadastrarLanches(String nomeP, String ingredientesP, String precoStringP, float precoP){
    try {
        // Obter o nome do lanche do campo de texto
        String nome = nomeP;
        // Obter os ingredientes do lanche do campo de texto
        String ingredientes = ingredientesP;
        // Obter o preço do lanche do campo de texto
        String precoString = precoStringP;
        // Variável para verificar se o lanche já está na lista
        int verificar = 0;
        // Posição do lanche na lista, se já estiver presente
        int posicaoLanche = 0;

        // Verificar se todos os campos foram preenchidos
        if (!nome.equalsIgnoreCase("") && !ingredientes.equalsIgnoreCase("") && !precoString.equalsIgnoreCase("")) {
            // Converter o preço para float
            float preco = precoP;

            // Verificar se o lanche já está na lista de lanches cadastrados
            if (!listaLanches.isEmpty()) {
                for (int i = 0; i < listaLanches.size(); i++) {
                    if (nome.equalsIgnoreCase(listaLanches.get(i).getNome())) {
                        verificar = 1;
                        posicaoLanche = i;
                        break;
                    }
                }
            }

            // Se o lanche já está na lista, atualizar seus dados
            if (verificar == 1) {
                listaLanches.remove(posicaoLanche);
                Lanche lanche = new Lanche(nome, ingredientes, preco);
                listaLanches.add(lanche);

                // Conectar-se ao banco de dados para atualizar o lanche
                ConnectionLanche connectionLanches = new ConnectionLanche(this.url, this.usuario, this.senha, nome, ingredientes, preco);
                connectionLanches.AtualizarLanche();

                // Salvar a lista de lanches em um arquivo
                FileOutputStream arquivo = new FileOutputStream("Lanches.ser");
                ObjectOutputStream out = new ObjectOutputStream(arquivo);
                out.writeObject(this.listaLanches);
                out.close();
                arquivo.close();

                // Exibir mensagem de sucesso
                JOptionPane.showMessageDialog(null, getMensagem("Mensagem1BT_SalvarMouseClickedTelaCadastrarLanches"));

            } else {
                // Se o lanche não está na lista, cadastrar um novo lanche
                Lanche lanche = new Lanche(nome, ingredientes, preco);
                ConnectionLanche connectionLanches = new ConnectionLanche(this.url, this.usuario, this.senha, nome, ingredientes, preco);
                connectionLanches.AdicionarLancheBancoDeDados();
                listaLanches.add(lanche);

                // Salvar a lista de lanches em um arquivo
                FileOutputStream arquivo = new FileOutputStream("Lanches.ser");
                ObjectOutputStream out = new ObjectOutputStream(arquivo);
                out.writeObject(this.listaLanches);
                out.close();
                arquivo.close();

                // Exibir mensagem de sucesso
                JOptionPane.showMessageDialog(null, getMensagem("Mensagem1BT_SalvarMouseClickedTelaCadastrarLanches"));
            }
        } else {
            // Se algum campo não foi preenchido, lançar uma exceção
            throw new Exception();
        }
    } catch (Exception e) {
        // Tratar exceção se algum campo não foi preenchido
        JOptionPane.showMessageDialog(null, getMensagem("Mensagem2BT_SalvarMouseClickedTelaCadastrarLanches"));
    }
    }
    
    public int BT_RemoverMouseClickedTelaCadastrarLanches(String nomeP, String ingredientesP, String precoStringP) {        
        int retornar = 0;
        
        try {
            // Obtém o nome, ingredientes e preço do lanche a ser removido
            String nome = nomeP;
            String ingredientes = ingredientesP;
            String precoString = precoStringP;
            int verificar = 0;

            // Verifica se todos os campos estão preenchidos
            if (!nome.equalsIgnoreCase("") && !ingredientes.equalsIgnoreCase("") && !precoString.equalsIgnoreCase("")) {

                // Itera sobre a lista de lanches cadastrados
                for (int i = 0; i < listaLanches.size(); i++) {
                    // Verifica se o lanche atual corresponde aos parâmetros fornecidos
                    if (nome.equalsIgnoreCase(listaLanches.get(i).getNome()) && ingredientes.equalsIgnoreCase(listaLanches.get(i).getIngredientes())) {
                        verificar = 1;
                        // Remove o lanche da lista
                        listaLanches.remove(i);
                        
                        retornar = 1;
                        
                        int preco = 0;
                        // Cria uma conexão com o banco de dados e remove o lanche
                        ConnectionLanche connectionLanches = new ConnectionLanche(this.url, this.usuario, this.senha, nome, ingredientes, preco);
                        connectionLanches.DeletarLanche();

                        // Salva a lista de lanches em um arquivo
                        FileOutputStream arquivo = new FileOutputStream("Lanches.ser");
                        ObjectOutputStream out = new ObjectOutputStream(arquivo);
                        out.writeObject(this.listaLanches);
                        out.close();
                        arquivo.close();

                        // Exibe uma mensagem de sucesso
                        JOptionPane.showMessageDialog(null, getMensagem("Mensagem1BT_RemoverMouseClickedTelaCadastrarLanches"));
                        break;
                    }
                }

                // Se nenhum lanche correspondente for encontrado, exibe uma mensagem de erro
                if (verificar != 1) {
                    JOptionPane.showMessageDialog(null, getMensagem("Mensagem2BT_RemoverMouseClickedTelaCadastrarLanches"));
                    retornar = 2;
                }

            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            // Trata qualquer exceção que possa ocorrer
            JOptionPane.showMessageDialog(null, getMensagem("Mensagem3BT_RemoverMouseClickedTelaCadastrarLanches"));
        }
        return retornar;
    }
    
    public void BT_SalvarMouseClickedTelaCadastrarCliente(String nomeP, String telefoneP, String enderecoP){
        try {
        String nome = nomeP;
        String telefone = telefoneP;
        String endereco = enderecoP;
        
        // Verifica se todos os campos foram preenchidos
        if (!nome.equalsIgnoreCase("") && !telefone.equalsIgnoreCase("") && !endereco.equalsIgnoreCase("")) {
            // Cria um novo objeto ClienteCadastrado com os dados fornecidos
            ClienteCadastrado cliente = new ClienteCadastrado(telefone, nome, endereco);
            // Calcula a data de cadastro do cliente
            cliente.CalcularData();
            // Adiciona o cliente à lista de clientes cadastrados
            listaClientes.add(cliente);
            
            // Cria uma conexão com o banco de dados para adicionar o cliente
            ConnectionCliente connectionCliente = new ConnectionCliente(this.url, this.usuario, this.senha, nome, endereco, cliente.getData(), telefone);
            
            // Adiciona o cliente ao banco de dados
            connectionCliente.AdicionarClienteBancoDeDados();
            
            // Salva a lista de clientes em um arquivo serializado
            FileOutputStream arquivo = new FileOutputStream("Clientes.ser");
            ObjectOutputStream out = new ObjectOutputStream(arquivo);
            out.writeObject(this.listaClientes);
            out.close();
            arquivo.close();
            
            // Exibe uma mensagem de sucesso
            JOptionPane.showMessageDialog(null, getMensagem("Mensagem1BT_SalvarMouseClickedTelaCadastrarCliente"));
            
            // Retorna à tela principal do sistema
            TelaPrincipal();
            
        } else {
            // Se algum campo não estiver preenchido, lança uma exceção
            throw new Exception();
        }
    } catch (Exception e) {
        // Exibe uma mensagem de erro se algum campo estiver vazio
        JOptionPane.showMessageDialog(null, getMensagem("Mensagem2BT_SalvarMouseClickedTelaCadastrarCliente"));
    }
    }
    
    public int BT_RemoverMouseClickedTelaListaClientesCadastrados(String selecionadoP){
        int retornar = 0;
        
        try {
        int n = 1;
            
        String selecionado = selecionadoP;
        
        for(int i = 0; i < listaClientes.size(); i++){
                if(selecionado.equalsIgnoreCase(listaClientes.get(i).getNome()) || selecionado.equalsIgnoreCase(listaClientes.get(i).getTelefone()) || selecionado.equalsIgnoreCase(listaClientes.get(i).getEndereco()) || selecionado.equalsIgnoreCase(listaClientes.get(i).getData())){
                    n = JOptionPane.showConfirmDialog(null, getMensagem("Mensagem1BT_RemoverMouseClickedTelaListaClientesCadastrados") + listaClientes.get(i).getNome() + "?");
                    break;
                }
            }
        
        if(n == 0){
            for(int i = 0; i < listaClientes.size(); i++){
                if(selecionado.equalsIgnoreCase(listaClientes.get(i).getNome()) || selecionado.equalsIgnoreCase(listaClientes.get(i).getTelefone()) || selecionado.equalsIgnoreCase(listaClientes.get(i).getEndereco()) || selecionado.equalsIgnoreCase(listaClientes.get(i).getData())){
            
                System.out.println(listaClientes.get(i).getNome() + " " + listaClientes.get(i).getEndereco()+ " " + listaClientes.get(i).getData()+ " " + listaClientes.get(i).getTelefone());
                
                ConnectionCliente connectionCliente = new ConnectionCliente(this.url, this.usuario, this.senha, listaClientes.get(i).getNome(), listaClientes.get(i).getEndereco(), listaClientes.get(i).getData(), listaClientes.get(i).getTelefone());
                
                connectionCliente.DeletarCliente();
                
                    listaClientes.remove(i);
                    
                    retornar = 1;
                
                    FileOutputStream arquivo = new FileOutputStream("Clientes.ser");
                    ObjectOutputStream out = new ObjectOutputStream(arquivo);
            
                    out.writeObject(this.listaClientes);
                    out.close();
                    arquivo.close();

                    JOptionPane.showMessageDialog(null, getMensagem("Mensagem2BT_RemoverMouseClickedTelaListaClientesCadastrados"));
                    break;
                }
            }
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, getMensagem("Mensagem3BT_RemoverMouseClickedTelaListaClientesCadastrados"));
        }
        return retornar;
    }
    
    public void BT_InfoMouseClickedTelaPedidosDoDia(String selecionadoP){
        try {

            String selecionado = selecionadoP;

            int verifica = 0;

            for(int i = 0; i < listaPedidos.size(); i++){

                if(selecionado.equalsIgnoreCase(listaPedidos.get(i).getNome())){
                    JOptionPane.showMessageDialog(null, listaPedidos.get(i).getInfoPedido());
                    verifica = 1;
                    break;
                }
            }

            if(verifica == 0){
                throw new Exception();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, getMensagem("Mensagem1BT_InfoMouseClickedTelaPedidosDoDia"));
        }
    }
    
    public int BT_RemoverTodosMouseClickedTelaPedidosDoDia(){
        int retornar = 0;
        
        try {
            int i = JOptionPane.showConfirmDialog(null, getMensagem("Mensagem1BT_RemoverTodosMouseClickedTelaPedidosDoDia"));
            if(i == 0){
                ConnectionPedido connectionPedidos = new ConnectionPedido(this.url, this.usuario, this.senha);

                connectionPedidos.DeletarPedido();
                
                listaPedidos.removeAll(listaPedidos);

                retornar = 1;
                
                FileOutputStream arquivo = new FileOutputStream("Pedidos.ser");
                ObjectOutputStream out = new ObjectOutputStream(arquivo);
            
                out.writeObject(this.listaPedidos);
                out.close();
                arquivo.close();
            
                JOptionPane.showMessageDialog(null, getMensagem("Mensagem2BT_RemoverTodosMouseClickedTelaPedidosDoDia"));

            }
        } catch (Exception e) {

        }
        return retornar;
    }
    
    public void BT_ConfirmarMouseClickedFazerPedido(float totalP, float totalAguaP, float totalSucoP, float totalRefriP, String mostrarpedidoP, String EcadastradoP, String nomeP, String telefoneP, CupomFiscal cupomfiscalP) throws FileNotFoundException, IOException{
        
        
        float total = totalP;
        float totalAgua = totalAguaP;
        float totalSuco = totalSucoP;
        float totalRefri = totalRefriP;
        
        int i = JOptionPane.showConfirmDialog(null, getMensagem("Mensagem1BT_ConfirmarMouseClickedFazerPedido"));
            if (i == 0) {
                String mostrarPedido = mostrarpedidoP;

                JOptionPane.showMessageDialog(null, mostrarPedido);

                // escolher a forma de pagamento
                String[] options = {getMensagem("Mensagem2BT_ConfirmarMouseClickedFazerPedido"), getMensagem("Mensagem3BT_ConfirmarMouseClickedFazerPedido"), getMensagem("Mensagem4BT_ConfirmarMouseClickedFazerPedido")};
                String selectedOption = (String) JOptionPane.showInputDialog(
                        null,
                        getMensagem("Mensagem5BT_ConfirmarMouseClickedFazerPedido"),
                        getMensagem("Mensagem6BT_ConfirmarMouseClickedFazerPedido"),
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]); // Opção padrão selecionada

                // Verificando a opção selecionada  
                int verifica = 0;
                String formaDePagamento = "";
                if (selectedOption != null) {
                    if(selectedOption == getMensagem("Mensagem2BT_ConfirmarMouseClickedFazerPedido")){
                            if(total <= 20){
                            JOptionPane.showMessageDialog(null, getMensagem("Mensagem7BT_ConfirmarMouseClickedFazerPedido"));
                            }else{
                            String input = null;
                            int parcelas = 0;
                            while (parcelas <= 0 || input != null) {
                                input = JOptionPane.showInputDialog(
                                        null,
                                        getMensagem("Mensagem8BT_ConfirmarMouseClickedFazerPedido"),
                                        getMensagem("Controller_BT_ConfirmarMouseClickedFazerPedido1"),
                                        JOptionPane.QUESTION_MESSAGE);
                                try {
                                    parcelas = Integer.parseInt(input);
                                    float precoporparcela = total / parcelas;
                                    int maxParcelas = (int) Math.ceil(total / (this.moeda * 20)) - 1;

                                    if (precoporparcela <= (this.moeda * 20)) {
                                        JOptionPane.showMessageDialog(null, getMensagem("Mensagem9BT_ConfirmarMouseClickedFazerPedido") + maxParcelas + " " + getMensagem("Mensagem10BT_ConfirmarMouseClickedFazerPedido"));
                                        parcelas = 0;
                                    } else {
                                        JOptionPane.showMessageDialog(null, getMensagem("Mensagem11BT_ConfirmarMouseClickedFazerPedido") + ": " + getMensagem("MoedaDinheiro") + precoporparcela);
                                        verifica = 1;
                                        formaDePagamento = getMensagem("Mensagem2BT_ConfirmarMouseClickedFazerPedido");
                                        break;
                                    }

                                } catch (NumberFormatException e) {
                                    parcelas = 0;
                                }
                            }
                            }
                    }else{
                            if(selectedOption == getMensagem("Mensagem3BT_ConfirmarMouseClickedFazerPedido")){
                            verifica = 1;
                            formaDePagamento = getMensagem("Mensagem3BT_ConfirmarMouseClickedFazerPedido");
                            }
                            else{
                        if(selectedOption == getMensagem("Mensagem4BT_ConfirmarMouseClickedFazerPedido"))
                            verifica = 1;
                        formaDePagamento = getMensagem("Mensagem4BT_ConfirmarMouseClickedFazerPedido");
                        }
                    }
                }

                    if(verifica == 1){
                    
                    String Ecadastrado = EcadastradoP;

                    String nome = nomeP;
                    String telefone = telefoneP;

                    Pedido pedido = new Pedido(nome, Ecadastrado, telefone, mostrarPedido, total);

                    ConnectionPedido connectionPedidos = new ConnectionPedido(this.url, this.usuario, this.senha, nome, Ecadastrado, telefone, mostrarPedido, total);

                    connectionPedidos.AdicionarPedidoBancoDeDados();

                    this.listaPedidos.add(pedido);

                    FileOutputStream arquivo = new FileOutputStream("Pedidos.ser");
                    ObjectOutputStream out = new ObjectOutputStream(arquivo);

                    out.writeObject(this.listaPedidos);
                    out.close();
                    arquivo.close();

                    JOptionPane.showMessageDialog(null, getMensagem("Mensagem12BT_ConfirmarMouseClickedFazerPedido"));
                    
                    // Crie os botões personalizados
                    Object[] options2 = {getMensagem("PedidosDoDiapreencherTabela5"), getMensagem("PedidosDoDiapreencherTabela6")};

                    // Mostre o dialog com os botões personalizados
                    int response = JOptionPane.showOptionDialog(
                            null,
                            getMensagem("Controller_BT_ConfirmarMouseClickedFazerPedido2"),
                            getMensagem("Controller_BT_ConfirmarMouseClickedFazerPedido3"),
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options2,
                            options2[0]
                    );

                    if (response == JOptionPane.YES_OPTION) {
                        CupomFiscal cupomfiscal = cupomfiscalP;
                        cupomfiscal.adicionarMensagem(getMensagem("Controller_BT_ConfirmarMouseClickedFazerPedido4") + getMensagem("MoedaDinheiro") + Float.toString(total));
                        cupomfiscal.finishPDF(formaDePagamento);
                        JOptionPane.showMessageDialog(null, getMensagem("ListaClientesCadastrados_BT_GerarPDFMouseClicked") + cupomfiscal.getDestinoArquivo());
                    } else if (response == JOptionPane.NO_OPTION) {
                        
                    } else {
                        
                    }

                    TelaPrincipal();
                    }

                } else {

                }
    }
    
}
