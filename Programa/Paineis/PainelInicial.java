package Programa.Paineis;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PainelInicial extends PainelBase {
  
  private JButton bCadastros;
  private JButton bEstoque;
  private JButton bPedidos;
  private JButton bPagamentos;
  private JPanel insidePanel;

  public PainelInicial(){
    init();

    this.setSize(new Dimension(900, 600));
  
    this.setLayout(null);

    insidePanel.add(bCadastros);
    insidePanel.add(bEstoque);
    insidePanel.add(bPedidos);
    insidePanel.add(bPagamentos);
    this.add(insidePanel);
  }

  private void init(){
    insidePanel = new JPanel();
    insidePanel.setSize(new Dimension(540, 520));
    insidePanel.setBackground(new Color(230, 247, 247));
    insidePanel.setBounds(180, 10, 550, 530);
    insidePanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));
    insidePanel.setLayout(null);

    bCadastros = new JButton("Cadastros");
    bCadastros.setIcon(new ImageIcon("Programa/res/iconCadastro.png"));
    bCadastros.setFocusable(false);    
    bCadastros.setBounds(80, 15, 400, 100);
    bCadastros.setFont(new Font("Verdana", Font.PLAIN, 25)); 
    
    bEstoque = new JButton("Estoque");
    bEstoque.setIcon(new ImageIcon("Programa/res/iconEstoque.png"));
    bEstoque.setFocusable(false);    
    bEstoque.setBounds(80, 145, 400, 100);
    bEstoque.setFont(new Font("Verdana", Font.PLAIN, 25));
  
    bPedidos = new JButton("Pedidos");
    bPedidos.setIcon(new ImageIcon("Programa/res/iconPedidos.png"));
    bPedidos.setFocusable(false);    
    bPedidos.setBounds(80, 275, 400, 100);
    bPedidos.setFont(new Font("Verdana", Font.PLAIN, 25));
  
    bPagamentos = new JButton("Pagamentos");
    bPagamentos.setIcon(new ImageIcon("Programa/res/iconPagamentos.png"));
    bPagamentos.setFocusable(false);    
    bPagamentos.setBounds(80, 405, 400, 100);
    bPagamentos.setFont(new Font("Verdana", Font.PLAIN, 25));

    this.setBackground(new Color(188, 216, 216));

    this.setFocusList(new ArrayList<>());
  }

  //getters e setters
  public JButton getbCadastros() {
    return bCadastros;
  }

  public void setbCadastros(JButton bCadastros) {
    this.bCadastros = bCadastros;
  }

  public JButton getbEstoque() {
    return bEstoque;
  }

  public void setbEstoque(JButton bEstoque) {
    this.bEstoque = bEstoque;
  }

  public JButton getbPedidos() {
    return bPedidos;
  }

  public void setbPedidos(JButton bPedidos) {
    this.bPedidos = bPedidos;
  }

  public JButton getbPagamentos() {
    return bPagamentos;
  }

  public void setbPagamentos(JButton bPagamentos) {
    this.bPagamentos = bPagamentos;
  }

  @Override
  public void mudarTamanhoDosComponentes(float width, float height, boolean aumentando) {
    if (aumentando){
      mudarBounds(insidePanel, width, height, 550, 530);
      mudarBounds(bCadastros, width, height, 400, 100);
      mudarBounds(bEstoque, width, height, 400, 100);
      mudarBounds(bPagamentos, width, height, 400, 100);
      mudarBounds(bPedidos, width, height, 400, 100);
    }
    else {
      insidePanel.setBounds(180, 10, 550, 530);
      bCadastros.setBounds(80, 15, 400, 100);
      bEstoque.setBounds(80, 145, 400, 100);
      bPedidos.setBounds(80, 275, 400, 100);
      bPagamentos.setBounds(80, 405, 400, 100);
    }
  }
}
