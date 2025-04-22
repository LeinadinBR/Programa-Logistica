package Programa;

import java.io.Serializable;

public class Fornecedor implements Serializable {
  private String nomeFantasia;
  private String razaoSocial;
  private String cnpj;
  private Endereco endereco;
  private Float desconto = 0f;


  public Fornecedor(String nomeFantasia, String razaoSocial, String cnpj, Endereco endereco){
    this.nomeFantasia = nomeFantasia;
    this.razaoSocial = razaoSocial;
    this.cnpj = cnpj;
    this.endereco = endereco;
  }

  public Fornecedor(String nomeFantasia, String razaoSocial, String cnpj, Endereco endereco, Float desconto){
    this.nomeFantasia = nomeFantasia;
    this.razaoSocial = razaoSocial;
    this.cnpj = cnpj;
    this.endereco = endereco;
    this.desconto = desconto;
  }

  public Fornecedor(){}

  public String getNomeFantasia() {
    return nomeFantasia;
  }
  
  public void setNomeFantasia(String nomeFantasia) {
    this.nomeFantasia = nomeFantasia;
  }
  
  public String getRazaoSocial() {
    return razaoSocial;
  }
  
  public void setRazaoSocial(String razaoSocial) {
    this.razaoSocial = razaoSocial;
  }
  
  public String getCnpj() {
    return cnpj;
  }
  
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }
  
  public Endereco getEndereco() {
    return endereco;
  }
  
  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public Float getDesconto() {
    return desconto;
  }

  public void setDesconto(Float desconto) {
    this.desconto = desconto;
  }
}
