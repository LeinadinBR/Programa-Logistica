package Programa;

import java.io.Serializable;

public class Data implements Serializable{
  private String fullData;
  private int dia;
  private int mes;
  private int ano;

  public Data(String data){
    this.fullData = data;
    if (data.length() == 8){
      dia = Integer.parseInt(getSubString(data, 0, 2));
      mes = Integer.parseInt(getSubString(data, 3, 5));
      ano = Integer.parseInt(getSubString(data, 6, 8));
    } 
    else if (data.length() == 6){
      dia = Integer.parseInt(getSubString(data, 0, 2));
      mes = Integer.parseInt(getSubString(data, 2, 4));
      ano = Integer.parseInt(getSubString(data, 4, 6));
    }   
  }

  public Data(){}

  //getters e setters
  public String getFullData() {
    return fullData;
  }

  private String getSubString(String base, int init, int fim){
    String retorno = "";
    for (int i=init; i<fim; i++){
      retorno += base.charAt(i);
    }
    return retorno;
  }

  public String getMesEAno(){
    return mes + "/" + ano;       
  }

  public void setFullData(String fullData) {
    this.fullData = fullData;
  }

  public int getDia() {
    return dia;
  }

  public void setDia(int dia) {
    this.dia = dia;
  }

  public int getMes() {
    return mes;
  }

  public void setMes(int mes) {
    this.mes = mes;
  }

  public int getAno() {
    return ano;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }
}