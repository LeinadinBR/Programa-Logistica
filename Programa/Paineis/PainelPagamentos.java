package Programa.Paineis;

import java.util.ArrayList;


public class PainelPagamentos extends PainelBase {
  
  public PainelPagamentos(){
    init();
  }

  private void init(){

    this.setFocusList(new ArrayList<>());
  }

  @Override
  public void mudarTamanhoDosComponentes(float width, float height, boolean aumentando) {
    
  }
}
