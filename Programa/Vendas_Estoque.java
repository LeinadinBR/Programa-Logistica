package Programa;

public class Vendas_Estoque {
  
  private ProdutoQuantidade produtosQueTem;
  private ProdutoQuantidade produtosQueFaltam;
  private Estoque estoque;
  private Roteiro roteiro;
  
  public Vendas_Estoque(Estoque estoque, Roteiro roteiro){
    this.estoque = estoque;
    this.roteiro = roteiro;
  }
  
  //getters e setters
  public ProdutoQuantidade getProdutosQueTem() {
    return produtosQueTem;
  }
  
  public void setProdutosQueTem(ProdutoQuantidade produtosQueTem) {
    this.produtosQueTem = produtosQueTem;
  }
  
  public ProdutoQuantidade getProdutosQueFaltam() {
    return produtosQueFaltam;
  }
  
  public void setProdutosQueFaltam(ProdutoQuantidade produtosQueFaltam) {
    this.produtosQueFaltam = produtosQueFaltam;
  }
  
  public Estoque getEstoque() {
    return estoque;
  }
  
  public void setEstoque(Estoque estoque) {
    this.estoque = estoque;
  }
  
  public Roteiro getRoteiro() {
    return roteiro;
  }
  
  public void setRoteiro(Roteiro roteiro) {
    this.roteiro = roteiro;
  }
}
