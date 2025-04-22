package Programa.Paineis;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PainelCadastros extends PainelBase {
  private JButton bCadastroProdutos;
  private JButton bCadastroFornecedores;
  private JButton bCadastroClientes;
  private JButton bVerProdutos;
  private JButton bVerFornecedores;
  private JButton bVerClientes;
  private JButton bRetornar;
  private JPanel insidePanel;

  public PainelCadastros(){
    init();

    this.setLayout(null);

    this.add(insidePanel);

    insidePanel.add(bCadastroProdutos);
    insidePanel.add(bVerProdutos);
    insidePanel.add(bCadastroClientes);
    insidePanel.add(bVerClientes);
    insidePanel.add(bCadastroFornecedores);
    insidePanel.add(bVerFornecedores);
    
    this.add(bRetornar);
  }

  private void init(){
    insidePanel = new JPanel();
    insidePanel.setSize(new Dimension(800, 400));
    insidePanel.setBackground(new Color(230, 247, 247));
    insidePanel.setBounds(50, 10, 800, 400);
    insidePanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));
    insidePanel.setLayout(null);

    bCadastroProdutos = new JButton("Cadastro Produtos");
    bCadastroProdutos.setIcon(new ImageIcon("Programa/res/iconCadastroProduto.png"));
    bCadastroProdutos.setFocusable(false);
    bCadastroProdutos.setBounds(60, 20, 300, 100);
    bCadastroProdutos.setFont(new Font("Verdana", Font.PLAIN, 16));

    bVerProdutos = new JButton("Ver Produtos");
    bVerProdutos.setIcon(new ImageIcon("Programa/res/iconVerProduto.png"));
    bVerProdutos.setFocusable(false);
    bVerProdutos.setBounds(440, 20, 300, 100);
    bVerProdutos.setFont(new Font("Verdana", Font.PLAIN, 18));
    
    bCadastroClientes = new JButton("Cadastro Clientes");
    bCadastroClientes.setIcon(new ImageIcon("Programa/res/iconCadastroCliente.png"));
    bCadastroClientes.setFocusable(false);
    bCadastroClientes.setBounds(60, 150, 300, 100);
    bCadastroClientes.setFont(new Font("Verdana", Font.PLAIN, 17));

    bVerClientes = new JButton("Ver Clientes");
    bVerClientes.setIcon(new ImageIcon("Programa/res/iconVerCliente.png"));
    bVerClientes.setFocusable(false);
    bVerClientes.setBounds(440, 150, 300, 100);
    bVerClientes.setFont(new Font("Verdana", Font.PLAIN, 19));

    bCadastroFornecedores = new JButton("Cadastro Fornecedores");
    bCadastroFornecedores.setIcon(new ImageIcon("Programa/res/iconCadastroFornecedor.png"));
    bCadastroFornecedores.setFocusable(false);
    bCadastroFornecedores.setBounds(60, 280, 300, 100);
    bCadastroFornecedores.setFont(new Font("Verdana", Font.PLAIN, 15));

    bVerFornecedores = new JButton("Ver Fornecedores");
    bVerFornecedores.setIcon(new ImageIcon("Programa/res/iconVerFornecedor.png"));
    bVerFornecedores.setFocusable(false);
    bVerFornecedores.setBounds(440, 280, 300, 100);
    bVerFornecedores.setFont(new Font("Verdana", Font.PLAIN, 18));


    bRetornar = new JButton("Retornar");
    bRetornar.setIcon(new ImageIcon("Programa/res/iconRetorno.png"));
    bRetornar.setFocusable(false);
    bRetornar.setBounds(300, 435, 300, 100);
    bRetornar.setFont(new Font("Verdana", Font.PLAIN, 25));

    this.setBackground(new Color(188, 216, 216));

    this.setFocusList(new ArrayList<>());
  }

  @Override
  public void mudarTamanhoDosComponentes(float width, float height, boolean aumentando) {
    if (aumentando){
      mudarBounds(insidePanel, width, height, 800, 400);
      mudarBounds(bCadastroProdutos, width, height, 300, 100);
      mudarBounds(bVerProdutos, width, height, 300, 100);
      mudarBounds(bCadastroClientes, width, height, 300, 100);
      mudarBounds(bVerClientes, width, height, 300, 100);
      mudarBounds(bCadastroFornecedores, width, height, 300, 100);
      mudarBounds(bVerFornecedores, width, height, 300, 100);
      mudarBounds(bRetornar, width, height, 300, 100);
    }
    else {
      insidePanel.setBounds(50, 10, 800, 400);
      bCadastroProdutos.setBounds(60, 20, 300, 100);
      bVerProdutos.setBounds(440, 20, 300, 100);
      bCadastroClientes.setBounds(60, 150, 300, 100);
      bVerClientes.setBounds(440, 150, 300, 100);
      bCadastroFornecedores.setBounds(60, 280, 300, 100);
      bVerFornecedores.setBounds(440, 280, 300, 100);
      bRetornar.setBounds(300, 435, 300, 100);
    }
  }

  //getters e setters
  public JButton getbCadastroProdutos() {
    return bCadastroProdutos;
  }

  public void setbCadastroProdutos(JButton bCadastroProdutos) {
    this.bCadastroProdutos = bCadastroProdutos;
  }

  public JButton getbCadastroFornecedores() {
    return bCadastroFornecedores;
  }

  public void setbCadastroFornecedores(JButton bCadastroFornecedores) {
    this.bCadastroFornecedores = bCadastroFornecedores;
  }

  public JButton getbCadastroClientes() {
    return bCadastroClientes;
  }

  public void setbCadastroClientes(JButton bCadastroClientes) {
    this.bCadastroClientes = bCadastroClientes;
  }

  public JButton getbRetornar() {
    return bRetornar;
  }

  public void setbRetornar(JButton bRetornar) {
    this.bRetornar = bRetornar;
  }

  public JButton getbVerProdutos() {
    return bVerProdutos;
  }

  public void setbVerProdutos(JButton bVerProdutos) {
    this.bVerProdutos = bVerProdutos;
  }

  public JButton getbVerFornecedores() {
    return bVerFornecedores;
  }

  public void setbVerFornecedores(JButton bVerFornecedores) {
    this.bVerFornecedores = bVerFornecedores;
  }

  public JButton getbVerClientes() {
    return bVerClientes;
  }

  public void setbVerClientes(JButton bVerClientes) {
    this.bVerClientes = bVerClientes;
  } 
}
