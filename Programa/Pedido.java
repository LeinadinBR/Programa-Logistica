package Programa;

import java.io.Serializable;
import java.util.LinkedList;

public class Pedido implements Serializable {
  
  private int numPedido;
  public static int numGeralPedido = 1;
  private LinkedList<ProdutoQuantidade> produtos = new LinkedList<>();
  private Data data;
  private Cliente cliente;
  private Roteiro roteiro;
  private double valorTotal = 0;

  public Pedido(Data data, Cliente cliente, Roteiro roteiro){
    this.numPedido = numGeralPedido;
    numGeralPedido++;
    this.data = data;
    this.cliente = cliente;
  }

  public Pedido(){
    this.numPedido = numGeralPedido;
    numGeralPedido++;
  }

  public void addProduto(Produto produto, int quantidade){
    produtos.add(new ProdutoQuantidade(produto, quantidade));
    valorTotal += produto.getPrecoDeVenda() * quantidade;
  }

  public void addProduto(ProdutoQuantidade pq){
    produtos.add(pq);
    valorTotal += pq.getProduto().getPrecoDeVenda() * pq.getQuantidade();
  }

  public void diminuirContador(){
    if (numGeralPedido > 2)
      numGeralPedido--;
  }

  public int getNumPedido() {
    return numPedido;
  }
  
  public void setNumPedido(int numPedido) {
    this.numPedido = numPedido;
  }
  
  public Data getData() {
    return data;
  }
  
  public void setData(Data data) {
    this.data = data;
  }
  
  public Cliente getCliente() {
    return cliente;
  }
  
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public LinkedList<ProdutoQuantidade> getProdutos() {
    return produtos;
  }

  public void setProdutos(LinkedList<ProdutoQuantidade> produtos) {
    this.produtos = produtos;
  }

  public Roteiro getRoteiro() {
    return roteiro;
  }

  public void setRoteiro(Roteiro roteiro) {
    this.roteiro = roteiro;
  }

  public double getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(double valorTotal) {
    this.valorTotal = valorTotal;
  }

  public static int getNumGeralPedido() {
    return numGeralPedido;
  }

  public static void setNumGeralPedido(int numGeralPedido) {
    Pedido.numGeralPedido = numGeralPedido;
  }
}
