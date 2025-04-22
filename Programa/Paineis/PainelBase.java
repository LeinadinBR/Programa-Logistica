package Programa.Paineis;

import java.util.List;

import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class PainelBase extends JPanel {
  private List<Component> focusList = null;

  public void mudarTamanhoDosComponentes(float width, float height, boolean aumentando){}

  protected void mudarBounds(JComponent component, float width, float heigth, int w, int h){
    component.setBounds((int)(component.getX()*(width/920)), (int)(component.getY()*(heigth/620)), 
    (int)(w*(width/920)), (int)(h*(heigth/620)));
  }

  public List<Component> getFocusList() {
    return focusList;
  }

  public void setFocusList(List<Component> focusList) {
    this.focusList = focusList;
  }
}
