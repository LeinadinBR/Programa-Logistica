package Programa.Paineis;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PainelPedidos extends PainelBase {
  private JPanel insidePanel;
  private JButton bPedidosIndividuais, bPedidosRoteiro, bEstoqueXRoteiro, bRetornar, bCriarRoteiro, bCriarPedido;

  public PainelPedidos(){
    init();

    this.add(insidePanel);

    insidePanel.add(bPedidosIndividuais);
    insidePanel.add(bPedidosRoteiro);
    insidePanel.add(bCriarRoteiro);
    insidePanel.add(bCriarPedido);
    insidePanel.add(bEstoqueXRoteiro);
    insidePanel.add(bRetornar);
  }

  private void init(){
    this.setBackground(new Color(188, 216, 216));
    this.setLayout(null);

    insidePanel = new JPanel();
    insidePanel.setBackground(new Color(230, 247, 247));
    insidePanel.setLayout(null);
    insidePanel.setBounds(150, 10, 600, 520);
    insidePanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));
    
    Font font = new Font("Verdana", Font.PLAIN, 25);

    bPedidosIndividuais = new JButton("Procurar Pedidos Individuais");
    bPedidosIndividuais.setFont(font);
    bPedidosIndividuais.setBounds(90, 20, 450, 70);
    bPedidosIndividuais.setFocusable(false);

    bPedidosRoteiro = new JButton("Procurar Pedidos por Roteiro");
    bPedidosRoteiro.setFont(font);
    bPedidosRoteiro.setBounds(90, 100, 450, 70);
    bPedidosRoteiro.setFocusable(false);

    bCriarRoteiro = new JButton("Criar Novo Roteiro");
    bCriarRoteiro.setFont(font);
    bCriarRoteiro.setBounds(90, 180, 450, 70);
    bCriarRoteiro.setFocusable(false);

    bCriarPedido = new JButton("Criar Novo Pedido");
    bCriarPedido.setFont(font);
    bCriarPedido.setBounds(90, 260, 450, 70);
    bCriarPedido.setFocusable(false);

    bEstoqueXRoteiro = new JButton("Relação Estoque x Roteiro");
    bEstoqueXRoteiro.setFont(font);
    bEstoqueXRoteiro.setBounds(90, 340, 450, 70);
    bEstoqueXRoteiro.setFocusable(false);

    bRetornar = new JButton("Retornar");
    bRetornar.setIcon(new ImageIcon("Programa/res/iconRetorno.png"));
    bRetornar.setFont(font);
    bRetornar.setBounds(90, 420, 450, 70);
    bRetornar.setFocusable(false);

    this.setFocusList(new ArrayList<>());
  }

  @Override
  public void mudarTamanhoDosComponentes(float width, float height, boolean aumentando) {
    if (aumentando){
      mudarBounds(bRetornar, width, height, 450, 70);
      mudarBounds(bEstoqueXRoteiro, width, height, 450, 70);
      mudarBounds(bCriarPedido, width, height, 450, 70);
      mudarBounds(bCriarRoteiro, width, height, 450, 70);
      mudarBounds(bPedidosRoteiro, width, height, 450, 70);
      mudarBounds(bPedidosIndividuais, width, height, 450, 70);
      mudarBounds(insidePanel, width, height, 600, 520);
    }
    else {
      bRetornar.setBounds(90, 420, 450, 70);
      bEstoqueXRoteiro.setBounds(90, 340, 450, 70);
      bCriarPedido.setBounds(90, 260, 450, 70);
      bCriarRoteiro.setBounds(90, 180, 450, 70);
      bPedidosRoteiro.setBounds(90, 100, 450, 70);
      bPedidosIndividuais.setBounds(90, 20, 450, 70);
      insidePanel.setBounds(150, 10, 600, 520);
    }
  }

  //getters e setters
  public JButton getbPedidosIndividuais() {
    return bPedidosIndividuais;
  }

  public void setbPedidosIndividuais(JButton bPedidosIndividuais) {
    this.bPedidosIndividuais = bPedidosIndividuais;
  }

  public JButton getbPedidosRoteiro() {
    return bPedidosRoteiro;
  }

  public void setbPedidosRoteiro(JButton bPedidosRoteiro) {
    this.bPedidosRoteiro = bPedidosRoteiro;
  }

  public JButton getbEstoqueXRoteiro() {
    return bEstoqueXRoteiro;
  }

  public void setbEstoqueXRoteiro(JButton bEstoqueXRoteiro) {
    this.bEstoqueXRoteiro = bEstoqueXRoteiro;
  }

  public JButton getbRetornar() {
    return bRetornar;
  }

  public void setbRetornar(JButton bRetornar) {
    this.bRetornar = bRetornar;
  }

  public JButton getbCriarRoteiro() {
    return bCriarRoteiro;
  }

  public void setbCriarRoteiro(JButton bCriarRoteiro) {
    this.bCriarRoteiro = bCriarRoteiro;
  }

  public JButton getbCriarPedido() {
    return bCriarPedido;
  }

  public void setbCriarPedido(JButton bCriarPedido) {
    this.bCriarPedido = bCriarPedido;
  } 
}
