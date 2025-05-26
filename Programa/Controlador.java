package Programa;

import java.util.ArrayList;
import java.util.List;

public class Controlador {
  private DataBase dataBase;

  public Controlador(){
    dataBase = new DataBase();
  }

  public void saveDataBase(){
    dataBase.save();
  }

  public void loadDataBase(){
    dataBase.load();
  }

  //PRODUTOS
  public void adicionarProduto(Produto produto){
    dataBase.adicionarProduto(produto);
  }

  public void verProdutos(){
    dataBase.verProdutos();
  }

  public List<Produto> getListaProdutos(){
    return dataBase.getListaProdutos();
  }

  //PRODUTO-QUANTIDADE
  public List<ProdutoQuantidade> getListaProdutoQuantidade(){
    return dataBase.getListaProdutoQuantidade();
  }

  public void verProdutoQuantidade(){
    dataBase.verProdutoQuantidade();
  }

  public boolean atualizarDadosDB(String id, int col, Object valor, int painelOrigem){
    //Essa função funciona para mudanças vindas do painel de estoque, visto o número da coluna
    switch (painelOrigem) {
      //EStoque
      case 0:
        //atualiza lista produto-quantidade
        for (ProdutoQuantidade pq: dataBase.getListaProdutoQuantidade()){
          if (pq.getProduto().getCodigo() == id){
            try {
              //muda de acordo com a coluna selecionada na função
              switch (col) {
                case 0: //mudar id o que é proibido
                  return false;
                case 1: //mudar o nome do item
                  pq.getProduto().setNome(String.valueOf(valor));
                  break;
                case 2: //mudar o fornecedor se ele já existir
                  Fornecedor f = getFornecedor(String.valueOf(valor));
                  if (f != null)
                    pq.getProduto().setFornecedor(f);
                  else 
                    return false;
                  break;
                case 3: //mudar o preço de venda
                  pq.getProduto().setPrecoDeVenda(Double.parseDouble(String.valueOf(valor)));
                  break;
                case 4: //muda a quantidade
                  pq.setQuantidade(Integer.parseInt(String.valueOf(valor)));
                  break;
                default:
                  break;
              }
            }
            catch(NumberFormatException ex){ 
              return false;
            }
          }
        }
        //atualiza lista produtos
        for (Produto p: dataBase.getListaProdutos()){
          if (p.getCodigo() == id){
            try {
              //muda de acordo com a coluna selecionada na função
              switch (col) {
                case 0: //mudar id o que é proibido
                  return false;
                case 1: //mudar o nome do item
                  p.setNome(String.valueOf(valor));
                  break;
                case 2: //mudar o fornecedor se ele já existir
                  Fornecedor f = getFornecedor(String.valueOf(valor));
                  if (f != null)
                    p.setFornecedor(f);
                  else 
                    return false;
                  break;
                case 3: //mudar o preço de venda
                  p.setPrecoDeVenda(Double.parseDouble(String.valueOf(valor)));
                  break;
                default:
                  break;
              }
            }
            catch(NumberFormatException ex){ 
              return false;
            }
          }
        }
        //atualiza lista do estoque
        for (ProdutoQuantidade pq: dataBase.getEstoque().getProdutos()){
          if (pq.getProduto().getCodigo() == id){
            try {
              //muda de acordo com a coluna selecionada na função
              switch (col) {
                case 0: //mudar id o que é proibido
                  return false;
                case 1: //mudar o nome do item
                  pq.getProduto().setNome(String.valueOf(valor));
                  break;
                case 2: //mudar o fornecedor se ele já existir
                  Fornecedor f = getFornecedor(String.valueOf(valor));
                  if (f != null)
                    pq.getProduto().setFornecedor(f);
                  else 
                    return false;
                  break;
                case 3: //mudar o preço de venda
                  pq.getProduto().setPrecoDeVenda(Double.parseDouble(String.valueOf(valor)));
                  break;
                case 4: //muda a quantidade
                  pq.setQuantidade(Integer.parseInt(String.valueOf(valor)));
                  break;
                default:
                  break;
              }
            }
            catch(NumberFormatException ex){ 
              return false;
            }
            return true;
          }
        }
        break;

      //Ver Produtos
      case 1:
        //atualiza lista produto-quantidade
        for (ProdutoQuantidade pq: dataBase.getListaProdutoQuantidade()){
          if (pq.getProduto().getCodigo() == id){
            try {
              //muda de acordo com a coluna selecionada na função
              switch (col) {
                case 0: //mudar id o que é proibido
                  return false;
                case 1: //mudar o nome do item
                  pq.getProduto().setNome(String.valueOf(valor));
                  break;
                case 2: //mudar o preço de compra
                  pq.getProduto().setPrecoTotal(Double.parseDouble(String.valueOf(valor)));
                  break;
                case 3: //mudar o preço de compra com desconto
                  pq.getProduto().setPrecoComDesconto(Double.parseDouble(String.valueOf(valor)));
                  break;
                case 4: //mudar o preço de venda
                  pq.getProduto().setPrecoDeVenda(Double.parseDouble(String.valueOf(valor)));
                  break;
                default:
                  break;
              }
            }
            catch(NumberFormatException ex){ 
              return false;
            }
          }
        }
        //atualiza lista produtos
        for (Produto p: dataBase.getListaProdutos()){
          if (p.getCodigo() == id){
            try {
              //muda de acordo com a coluna selecionada na função
              switch (col) {
                case 0: //mudar id o que é proibido
                  return false;
                case 1: //mudar o nome do item
                  p.setNome(String.valueOf(valor));
                  break;
                case 2: //mudar o preço de compra total
                  p.setPrecoTotal(Double.parseDouble(String.valueOf(valor)));
                  break;
                case 3: //mudar o preço de compra com desconto
                  p.setPrecoComDesconto(Double.parseDouble(String.valueOf(valor)));
                  break;
                case 4: //mudar o preco de venda
                  p.setPrecoDeVenda(Double.parseDouble(String.valueOf(valor)));
                  break;
                default:
                  break;
              }
            }
            catch(NumberFormatException ex){ 
              return false;
            }
          }
        }
        //atualiza lista do estoque
        for (ProdutoQuantidade pq: dataBase.getEstoque().getProdutos()){
          if (pq.getProduto().getCodigo() == id){
            try {
              //muda de acordo com a coluna selecionada na função
              switch (col) {
                case 0: //mudar id o que é proibido
                  return false;
                case 1: //mudar o nome do item
                  pq.getProduto().setNome(String.valueOf(valor));
                  break;
                case 2: //mudar o preço de compra total
                  pq.getProduto().setPrecoTotal(Double.parseDouble(String.valueOf(valor)));                  
                  break;
                case 3: //mudar o preço de compra com desconto
                  pq.getProduto().setPrecoComDesconto(Double.parseDouble(String.valueOf(valor)));
                  break;
                case 4: //mudar o preco de venda
                  pq.getProduto().setPrecoDeVenda(Double.parseDouble(String.valueOf(valor)));
                  break;
                default:
                  break;
              }
            }
            catch(NumberFormatException ex){ 
              return false;
            }
            return true;
          }
        }
        break;
      default:
        break;
    }
    
    return false;
  }

  //CLIENTES
  public void adicionarCliente(Cliente c){
    dataBase.adicionarCliente(c);
  }

  public List<Cliente> getListaClientes(){
    return dataBase.getListaClientes();
  }

  //FORNECEDORES
  public void adicionarFornecedor(Fornecedor fornecedor){
    dataBase.adicionarFornecedor(fornecedor);
  }

  public void verFornecedores(){
    dataBase.verFornecedores();
  }

  public Fornecedor getFornecedor(String nomeFantasia){
    return dataBase.getFornecedorEspecifico(nomeFantasia);
  }

  public List<Fornecedor> getListaFornecedores(){
    return dataBase.getListaFornecedores();
  }

  //ENDERECO
  public void adicionarEndereco(Endereco endereco){
    dataBase.adicionarEndereco(endereco);
  }

  public List<Endereco> getListaEnderecos(){
    return dataBase.getListaEnderecos();
  }

  //ROTEIRO
  public void adicionarRoteiro(Roteiro r){
    dataBase.adicionarRoteiro(r);
  }

  public List<Roteiro> getListaRoteiros(){
    return dataBase.getListaRoteiros();
  }

  //REGIÕES
  public void adicionarRegiao(String s){
    dataBase.adicionarRegiao(s);
  }

  public List<String> getListaRegioes(){
    return dataBase.getListaRegioes();
  }

  //PEDIDOS
  public void adicionarPedido(Pedido p){
    dataBase.adicionarPedido(p);
  }

  public List<Pedido> getListaPedidos(){
    return dataBase.getListaPedidos();
  }

  //ESTOQUE
  public void adicionarProdutoNoEstoque(ProdutoQuantidade pq){
    dataBase.getEstoque().addProdutos(pq);
  }

  public Estoque getEstoque(){
    return dataBase.getEstoque();
  }

  public ArrayList<Integer> getListaNumPermanentes(){
    return dataBase.getListaNumPermanentes();
  }
}
