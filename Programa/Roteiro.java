package Programa;

import java.io.Serializable;
import java.util.LinkedList;

public class Roteiro implements Serializable {
  
  private LinkedList<Pedido> pedidos = new LinkedList<>();
  private String região;
  private Data dataInicio;
  private Data dataTermino;

  public Roteiro(String regiao, Data dataInicio, Data dataTermino){
    this.região = regiao;
    this.dataInicio = dataInicio;
    this.dataTermino = dataTermino;
  }

  public Roteiro(){}

  public void adicionarPedido(Pedido pedido){
    pedidos.add(pedido);
  }

  public void removerPedido(Pedido pedido){
    for (Pedido p : pedidos){
      if (p.equals(pedido))
        pedidos.remove(p);
    }
  }

  //getters e setters
  public LinkedList<Pedido> getPedidos() {
    return pedidos;
  }

  public void setPedidos(LinkedList<Pedido> pedidos) {
    this.pedidos = pedidos;
  }

  public String getRegião() {
    return região;
  }

  public void setRegião(String região) {
    this.região = região;
  }

  public Data getDataInicio() {
    return dataInicio;
  }

  public void setDataInicio(Data dataInicio) {
    this.dataInicio = dataInicio;
  }

  public Data getDataTermino() {
    return dataTermino;
  }

  public void setDataTermino(Data dataTermino) {
    this.dataTermino = dataTermino;
  } 
}
