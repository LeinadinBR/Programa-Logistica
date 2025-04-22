package Programa;

import java.io.Serializable;
import java.util.LinkedList;

public class Estoque  implements Serializable {
  
  private LinkedList<ProdutoQuantidade> produtos = new LinkedList<>();

  public LinkedList<ProdutoQuantidade> getProdutos() {
    return produtos;
  }

  public void setProdutos(LinkedList<ProdutoQuantidade> produtos) {
    this.produtos = produtos;
  }

  public void addProdutos(ProdutoQuantidade pq){
    produtos.add(pq);
  }

  public void removerProdutos(ProdutoQuantidade pq){
    for (ProdutoQuantidade prod: produtos){
      if (prod.getProduto().getCodigo() == pq.getProduto().getCodigo()){
        produtos.remove(prod);
        return;
      }
    }
  }

  public void somarProduto(Produto p, int quantidade){
    for (int i=0; i<produtos.size(); i++){
      if (produtos.get(i).getProduto().getCodigo() == p.getCodigo()){
        produtos.get(i).setQuantidade(produtos.get(i).getQuantidade() + quantidade);
        return;
      }
    }
  }

  public void subtrairProduto(Produto p, int quantidade){
    for (int i=0; i<produtos.size(); i++){
      if (produtos.get(i).getProduto().getCodigo() == p.getCodigo()){
        //ISSO PODE RESULTAR EM VALORES NEGATIVOS QUE ESTARÃO SOB RESPONSABILIDADE DO USUARIO DE CONSERTAR
        produtos.get(i).setQuantidade(produtos.get(i).getQuantidade() - quantidade);
        return;
      }
    }
  }
}