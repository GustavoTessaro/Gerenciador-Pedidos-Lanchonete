# Gerenciador-Pedidos-Lanchonete
Arquivo README

Desenvolvido por Gustavo Oliveira Tessaro.


Esquinão Lanches - Gerenciador de pedidos para lanchonete.


*Funcionalidade e para que Serve?*

**Registro de Pedidos e Integração com a Cozinha:**
- O programa permite que os atendentes registrem os pedidos dos clientes, incluindo detalhes como itens escolhidos, quantidade e observações especiais.
- Cadastro de lanches, permite que o usuario faça o cadastro de um novo lanche, remova um lanche existente ou edite seu valor, nome ou ingredientes.
- Isso agiliza o processo de atendimento e garante que os pedidos sejam precisos.

**PDV (Ponto de Venda) Integrado:**
- O programa funciona como um PDV, permitindo que os atendentes registrem os pedidos diretamente no sistema.
- Além disso, ele pode calcular automaticamente o valor total do pedido.

**Atendimento no Balcão:**
- Para atendimento no balcão, o Esquinão Lanches permite que os atendentes gerenciem comandas e atendam rapidamente os clientes presenciais.

**Cadastro de Clientes e Histórico de Pedidos:**
- O Esquinão Lanches permite que os atendentes cadastrem informações dos clientes, como nome, telefone e endereço. Isso facilita para um atendimento personalizado.
- Ele também pode mostrar os pedidos do dia, onde ele vai mostrar nome do cliente, telefone, se é cadastrado ou não, valor da compra, total faturado, também sendo possivel a remoção dos pedidos e consultar oque foi pedido. Essas funções permitindo que os proprietários tomem decisões embasadas para decisões futuras.

Em resumo, um programa gerenciador de pedidos como o Esquinão Lanches simplifica as operações diárias de uma lanchonete, otimiza o atendimento aos clientes e ajuda a manter o controle sobre estoque, finanças e pedidos.



*Como instalar*

Baixe o Java(caso não tiver).  
Crie este banco de dados abaixo...

```sql
create database if not exists BancoDeDadosEsquinaoLanches;

use BancoDeDadosEsquinaoLanches;

CREATE TABLE Pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    Ecadastrado VARCHAR(255),
    telefone VARCHAR(20),
    infoPedido TEXT,
    totalGasto FLOAT
);

CREATE TABLE Lanche (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    ingredientes TEXT,
    preco FLOAT
);

CREATE TABLE Cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    endereco VARCHAR(255),
    telefone VARCHAR(20),
    dataCadastro DATE
);
```

...após criar este banco, abra o programa e faça a seguinte modificação nos painéis "cadastrar cliente", "cadastrar lanche" e "cadastrar pedido": modifique todos os métodos que possuem as strings "url", "usuário" e "senha" pelos seus correspondentes, caso não possua senha, utilize "" para representar que estão vazios.
Obs: Use o nome (atendente) e senha (esquinaolanches123) para acessar quando estiver executando o programa.



*Funcionalidades implementadas*

**Internacionalização:**
- Para verificar a mudança de idioma no programa, altere a linguagem do seu dispositivo. O programa se ajusta automaticamente ao idioma do dispositivo, suportando até 6 línguas diferentes: inglês (en-US), espanhol (es-ES), alemão (de-DE), português (pt-BR), russo (ru-RU) e italiano (it-IT).

**Relatório, Tabela e Gráfico:**
- Relatório "Cupom Fiscal", para gerá-lo, é necessário ter previamente cadastrado um lanche na tela "Cadastrar Lanche". Após o cadastro do lanche, vá para a opção "Fazer Pedido", preencha corretamente o seu pedido e clique em confirmar para finalizá-lo. Aparecerá uma mensagem para confirmação, seguida de um painel com seu pedido e, em seguida, opções de pagamento. Por fim, haverá a possibilidade de gerar ou não um PDF do cupom fiscal. Este PDF estará disponível dentro da pasta do programa.
- Tabela, para gerá-la, é necessário ter previamente cadastrado algum cliente na tela "Cadastrar Cliente". Depois de cadastrar o cliente, vá para a opção "Lista de Clientes Cadastrados". Nesta tela, haverá a opção "Gerar PDF". Este PDF estará disponível dentro da pasta do programa.
- Gráfico, para gerá-lo, é necessário ter previamente feito algum pedido na tela "Fazer Pedido". Depois de fazer o pedido, vá para a opção "Pedidos do Dia". Nesta tela, haverá a opção "Imprimir Gráfico". Este gráfico estará disponível dentro da pasta do programa em formato de PDF.
