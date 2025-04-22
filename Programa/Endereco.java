package Programa;

import java.io.Serializable;

public class Endereco implements Serializable{
  private String rua;
  private String bairro;
  private String cidade;
  private String cep;
  private int num;
  private String telefone;


  //TODO revisar necissade de contato

  //construtor
  public Endereco(String rua, String bairro, String cidade, String cep, int num, String telefone){
    this.rua = rua;
    this.bairro = bairro;
    this.cidade = cidade;
    this.cep = cep;
    this.num = num;
    this.telefone = telefone;
  }

  public Endereco(){}

  //getters e setters
  public String getRua() {
    return rua;
  }
  
  public void setRua(String rua) {
    this.rua = rua;
  }
  
  public String getBairro() {
    return bairro;
  }
  
  public void setBairro(String bairro) {
    this.bairro = bairro;
  }
  
  public String getCidade() {
    return cidade;
  }
  
  public void setCidade(String cidade) {
    this.cidade = cidade;
  }
  
  public String getCep() {
    return cep;
  }
  
  public void setCep(String cep) {
    this.cep = cep;
  }
  
  public int getNum() {
    return num;
  }
  
  public void setNum(int num) {
    this.num = num;
  }
  
  public String getTelefone() {
    return telefone;
  }
  
  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }
}
