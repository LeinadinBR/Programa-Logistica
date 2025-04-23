package Programa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DataBase {
  private ArrayList<Produto> listaProdutos;
  private ArrayList<ProdutoQuantidade> listaProdutoQuantidade;
  private ArrayList<Cliente> listaClientes;
  private ArrayList<Fornecedor> listaFornecedores;
  private ArrayList<Endereco> listaEnderecos;
  private ArrayList<Pedido> listaPedidos;
  private ArrayList<Roteiro> listaRoteiros;
  private ArrayList<String> listaRegioes;
  private ArrayList<Integer> listaNumPermanentes;

  private Estoque estoque;

  public DataBase(){
    init();
  }

  private void init(){
    listaProdutos = new ArrayList<>(); //PRONTO
    listaProdutoQuantidade = new ArrayList<>(); //PRONTO
    listaClientes = new ArrayList<>();  //PRONTO
    listaFornecedores = new ArrayList<>(); //PRONTO
    listaEnderecos = new ArrayList<>(); //PRONTO
    listaPedidos = new ArrayList<>(); //PRONTO
    listaRoteiros = new ArrayList<>(); //PRONTO
    listaRegioes = new ArrayList<>(); //PRONTO
    listaNumPermanentes = new ArrayList<>(); //PRONTO

    estoque = new Estoque(); //PRONTO

    listaNumPermanentes.add(0); //Cadastrar Produtos
    listaNumPermanentes.add(1); //Cadastrar Pedidos  
  }

  //PRODUTOS
  public void adicionarProduto(Produto produto){
    listaProdutos.add(produto);
    adicionarProdutoQuantidade(produto);
  }

  public void verProdutos(){
    for (Produto p : listaProdutos){
      System.out.println(p.getNome());
    }
  }

  //PRODUTO-QUANTIDADE
  public void adicionarProdutoQuantidade(Produto produto){
    listaProdutoQuantidade.add(new ProdutoQuantidade(produto, 0));
  }

  public void verProdutoQuantidade(){
    for (ProdutoQuantidade pq: listaProdutoQuantidade){
      System.out.print(pq.getProduto().getNome() + " | ");
      System.out.println(pq.getQuantidade());
    }
  }

  //CLIENTES
  public void adicionarCliente(Cliente c){
    listaClientes.add(c);
  }

  //FORNECEDORES
  public void adicionarFornecedor(Fornecedor fornecedor){
    listaFornecedores.add(fornecedor);
  }

  public void verFornecedores(){
    for (Fornecedor f: listaFornecedores){
      System.out.println(f.getNomeFantasia());
    }
  }

  public Fornecedor getFornecedorEspecifico(String nomeFantasia){
    for (Fornecedor f: listaFornecedores){
      if (f.getNomeFantasia().equals(nomeFantasia))
        return f;
    }
    return null;
  }

  //ENDERECOS
  public void adicionarEndereco(Endereco endereco){
    listaEnderecos.add(endereco);
  }

  //ROTEIRO
  public void adicionarRoteiro(Roteiro roteiro){
    listaRoteiros.add(roteiro);
  }

  //REGIÕES
  public void adicionarRegiao(String regiao){
    listaRegioes.add(regiao);
  }

  //PEDIDOS
  public void adicionarPedido(Pedido p){
    listaPedidos.add(p);
  }

  @SuppressWarnings("unchecked")
  public void load(){
    try {
      ObjectInputStream in = new ObjectInputStream(new FileInputStream("Programa/saves/produtos.txt"));
      ObjectInputStream in1 = new ObjectInputStream(new FileInputStream("Programa/saves/fornecedores.txt"));
      ObjectInputStream in2 = new ObjectInputStream(new FileInputStream("Programa/saves/enderecos.txt"));
      ObjectInputStream in3 = new ObjectInputStream(new FileInputStream("Programa/saves/produtoQuantidade.txt"));
      ObjectInputStream in4 = new ObjectInputStream(new FileInputStream("Programa/saves/cliente.txt"));
      ObjectInputStream in5 = new ObjectInputStream(new FileInputStream("Programa/saves/pedidos.txt"));
      ObjectInputStream in6 = new ObjectInputStream(new FileInputStream("Programa/saves/roteiros.txt"));
      ObjectInputStream in7 = new ObjectInputStream(new FileInputStream("Programa/saves/regioes.txt"));
      ObjectInputStream in8 = new ObjectInputStream(new FileInputStream("Programa/saves/estoque.txt"));
      ObjectInputStream in9 = new ObjectInputStream(new FileInputStream("Programa/saves/numImportantes.txt"));

      listaProdutos = (ArrayList<Produto>) in.readObject();
      listaFornecedores = (ArrayList<Fornecedor>) in1.readObject();
      listaEnderecos = (ArrayList<Endereco>) in2.readObject();
      listaProdutoQuantidade = (ArrayList<ProdutoQuantidade>) in3.readObject();
      listaClientes = (ArrayList<Cliente>) in4.readObject();
      listaPedidos = (ArrayList<Pedido>) in5.readObject();
      listaRoteiros = (ArrayList<Roteiro>) in6.readObject();
      listaRegioes = (ArrayList<String>) in7.readObject();
      estoque = (Estoque) in8.readObject();
      listaNumPermanentes = (ArrayList<Integer>) in9.readObject();
      
      in.close();
      in1.close();
      in2.close();
      in3.close();
      in4.close();
      in5.close();
      in6.close();
      in7.close();
      in8.close();
      in9.close();
    } 
    catch (IOException e) {
      e.printStackTrace();
    } 
    catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    
  }

  public void save(){
    try {
      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Programa/saves/produtos.txt"));
      ObjectOutputStream out1 = new ObjectOutputStream(new FileOutputStream("Programa/saves/fornecedores.txt"));
      ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream("Programa/saves/enderecos.txt"));
      ObjectOutputStream out3 = new ObjectOutputStream(new FileOutputStream("Programa/saves/produtoQuantidade.txt"));
      ObjectOutputStream out4 = new ObjectOutputStream(new FileOutputStream("Programa/saves/cliente.txt"));
      ObjectOutputStream out5 = new ObjectOutputStream(new FileOutputStream("Programa/saves/pedidos.txt"));
      ObjectOutputStream out6 = new ObjectOutputStream(new FileOutputStream("Programa/saves/roteiros.txt"));
      ObjectOutputStream out7 = new ObjectOutputStream(new FileOutputStream("Programa/saves/regioes.txt"));
      ObjectOutputStream out8 = new ObjectOutputStream(new FileOutputStream("Programa/saves/estoque.txt"));
      ObjectOutputStream out9 = new ObjectOutputStream(new FileOutputStream("Programa/saves/numImportantes.txt"));

      out.writeObject(listaProdutos);
      out1.writeObject(listaFornecedores);
      out2.writeObject(listaEnderecos);
      out3.writeObject(listaProdutoQuantidade);
      out4.writeObject(listaClientes);
      out5.writeObject(listaPedidos);
      out6.writeObject(listaRoteiros);
      out7.writeObject(listaRegioes);
      out8.writeObject(estoque);
      out9.writeObject(listaNumPermanentes);
      
      out.close();
      out1.close();
      out2.close();
      out3.close();
      out4.close();
      out5.close();
      out6.close();
      out7.close();
      out8.close();
      out9.close();
    } 
    catch (IOException e) {
      e.printStackTrace();
    }
  }


  //getters e setters
  public ArrayList<Produto> getListaProdutos() {
    return listaProdutos;
  }

  public void setListaProdutos(ArrayList<Produto> listaProdutos) {
    this.listaProdutos = listaProdutos;
  }

  public ArrayList<Cliente> getListaClientes() {
    return listaClientes;
  }

  public void setListaClientes(ArrayList<Cliente> listaClientes) {
    this.listaClientes = listaClientes;
  }

  public ArrayList<Fornecedor> getListaFornecedores() {
    return listaFornecedores;
  }

  public void setListaFornecedores(ArrayList<Fornecedor> listaFornecedores) {
    this.listaFornecedores = listaFornecedores;
  }

  public ArrayList<Endereco> getListaEnderecos() {
    return listaEnderecos;
  }

  public void setListaEnderecos(ArrayList<Endereco> listaEnderecos) {
    this.listaEnderecos = listaEnderecos;
  }

  public ArrayList<Pedido> getListaPedidos() {
    return listaPedidos;
  }

  public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
    this.listaPedidos = listaPedidos;
  }

  public ArrayList<Roteiro> getListaRoteiros() {
    return listaRoteiros;
  }

  public void setListaRoteiros(ArrayList<Roteiro> listaRoteiros) {
    this.listaRoteiros = listaRoteiros;
  }

  public ArrayList<ProdutoQuantidade> getListaProdutoQuantidade() {
    return listaProdutoQuantidade;
  }

  public void setListaProdutoQuantidade(ArrayList<ProdutoQuantidade> listaProdutoQuantidade) {
    this.listaProdutoQuantidade = listaProdutoQuantidade;
  }

  public ArrayList<String> getListaRegioes() {
    return listaRegioes;
  }

  public void setListaRegioes(ArrayList<String> listaRegiões) {
    this.listaRegioes = listaRegiões;
  }

  public Estoque getEstoque() {
    return estoque;
  }

  public void setEstoque(Estoque estoque) {
    this.estoque = estoque;
  }

  public ArrayList<Integer> getListaNumPermanentes() {
    return listaNumPermanentes;
  }

  public void setListaNumPermanentes(ArrayList<Integer> listaNumPermanentes) {
    this.listaNumPermanentes = listaNumPermanentes;
  }   
}
