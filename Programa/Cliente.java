package Programa;

import java.io.Serializable;

public class Cliente implements Serializable {
  
  private String nome;
  private String nomeFantasia;
  private Endereco endereco;
  private String razaoSocial;
  private String cnpj;

  public Cliente(String nome, String nomeFantasia, String razaoSocial, String cnpj, Endereco endereco){
    this.nome = nome;
    this.nomeFantasia = nomeFantasia;
    this.razaoSocial = razaoSocial;
    this.cnpj = cnpj;
    this.endereco = endereco;
  }

  public Cliente(){}

  //getters e setters
  public String getNomeFantasia() {
    return nomeFantasia;
  }
  
  public void setNomeFantasia(String nomeFantasia) {
    this.nomeFantasia = nomeFantasia;
  }
  
  public Endereco getEndereco() {
    return endereco;
  }
  
  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
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

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
