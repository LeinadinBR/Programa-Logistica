package Programa;

import java.io.Serializable;

public class Produto implements Serializable {
  private int codigo; //essencial
  private String nome; //essencial
  private Fornecedor fornecedor; //essencial
  private double precoTotal; //essencial (preco de compra)
  private double precoComDesconto; //essencial (preco de compra com desconto)
  private double precoDeVenda; //essencial (preco de venda)
  private double porcentagemLucro; //essencial (quanto a mais valeu entre venda e compra)
  private double lucroIndividualBruto; //essencial (auto-explicativo)
  private Data dataDeValidade;


  public Produto(int codigo, String nome, Fornecedor fornecedor, double precoTotal, double precoComDesconto, double precoDeVenda, double porcentagemLucro, double lucroIndividualBruto){
    this.codigo = codigo;
    this.nome = nome;
    this.fornecedor = fornecedor;
    this.precoTotal = precoTotal;
    this.precoComDesconto = precoComDesconto;
    this.precoDeVenda = precoDeVenda;
    this.lucroIndividualBruto = lucroIndividualBruto;
  }

  public Produto(){}  

  //getters e setters
  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Fornecedor getFornecedor() {
    return fornecedor;
  }

  public void setFornecedor(Fornecedor fornecedor) {
    this.fornecedor = fornecedor;
  }

  public double getPrecoTotal() {
    return precoTotal;
  }

  public void setPrecoTotal(double precoTotal) {
    this.precoTotal = precoTotal;
  }

  public double getPrecoComDesconto() {
    return precoComDesconto;
  }

  public void setPrecoComDesconto(double precoComDesconto) {
    this.precoComDesconto = precoComDesconto;
  }

  public double getPrecoDeVenda() {
    return precoDeVenda;
  }

  public void setPrecoDeVenda(double precoDeVenda) {
    this.precoDeVenda = precoDeVenda;
  }

  public double getPorcentagemLucro() {
    return porcentagemLucro;
  }
  
  public void setPorcentagemLucro(double porcentagemLucro) {
    this.porcentagemLucro = porcentagemLucro;
  }

  public double getLucroIndividualBruto() {
    return lucroIndividualBruto;
  }

  public void setLucroIndividualBruto(double lucroIndividualBruto) {
    this.lucroIndividualBruto = lucroIndividualBruto;
  }

  public Data getDataDeValidade() {
    return dataDeValidade;
  }

  public void setDataDeValidade(Data dataDeValidade) {
    this.dataDeValidade = dataDeValidade;
  }
}