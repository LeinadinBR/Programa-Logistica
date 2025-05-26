package Programa.Paineis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import Programa.Endereco;

public class PainelCadastroFornecedores extends PainelBase {
  //TODO fazer scroll pane para a tabela
  private JTextField tfNomeFantasia;
  private JTextField tfRazaoSocial;
  private JTextField tfEndereco;
  private MaskFormatter maskCnpj;
  private JFormattedTextField tfCnpj;
  private JTextField tfDesconto;
  private JButton bEndereco;
  private JButton bRetornar;
  private JButton bAdicionar;
  private JLabel lblCnpj;
  private JLabel lblTabela;
  private JTable tTabela;
  private JPanel insidePanel;

  private Object[][] dados = null;
  private Object[] colunas = new Object[]{"Rua", "Bairro", "Cidade", "CEP", "Número", "Telefone"};
  private DefaultTableModel tableModel = new DefaultTableModel(dados, colunas);

  private Color corFiller = new Color(200, 160, 160);

  private boolean isEnderecoPopUp = false;

  public PainelCadastroFornecedores(){
    init();

    this.setLayout(null);

    this.add(insidePanel);
    this.add(bAdicionar);
    this.add(bRetornar);

    this.getFocusList().add(tfNomeFantasia);
    insidePanel.add(tfNomeFantasia);
    this.getFocusList().add(tfRazaoSocial);
    insidePanel.add(tfRazaoSocial);
    insidePanel.add(lblCnpj);
    this.getFocusList().add(tfCnpj);
    insidePanel.add(tfCnpj);
    insidePanel.add(tfEndereco);
    this.getFocusList().add(bEndereco);
    insidePanel.add(bEndereco);
    this.getFocusList().add(tfDesconto);
    insidePanel.add(tfDesconto);
    insidePanel.add(lblTabela);
    this.getFocusList().add(tTabela);
    insidePanel.add(tTabela);
  }

  private void init(){
    this.setBackground(new Color(188, 216, 216));
    Font verdana = new Font("Verdana", Font.PLAIN, 25);

    insidePanel = new JPanel();
    insidePanel.setBackground(new Color(230,247,247));
    insidePanel.setBounds(10, 10, 880, 400);
    insidePanel.setLayout(null);
    insidePanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));

    tfNomeFantasia = new JTextField("Nome Fantasia");
    tfNomeFantasia.setBounds(15, 15, 290, 45);
    tfNomeFantasia.setFont(verdana);
    tfNomeFantasia.setForeground(corFiller);
    tfNomeFantasia.setFocusable(true);
    fillerText("Nome Fantasia", tfNomeFantasia);

    tfRazaoSocial = new JTextField("Razão Social");
    tfRazaoSocial.setBounds(15, 70, 290, 45);
    tfRazaoSocial.setFont(verdana);
    tfRazaoSocial.setForeground(corFiller);
    tfRazaoSocial.setFocusable(true);
    fillerText("Razão Social", tfRazaoSocial);

    lblCnpj = new JLabel("CNPJ");
    lblCnpj.setFont(verdana);
    lblCnpj.setBounds(15,125,290,30); 

    try {
      maskCnpj = new MaskFormatter("##.###.###/000#-##");
    } 
    catch (ParseException e) {
      e.printStackTrace();
    }

    tfCnpj = new JFormattedTextField(maskCnpj);
    tfCnpj.setBounds(15, 165, 290, 45);
    tfCnpj.setFocusable(true);
    tfCnpj.setFont(verdana);

    tfEndereco = new JTextField("Endereço");
    tfEndereco.setEditable(false);
    tfEndereco.setFont(verdana);
    tfEndereco.setBounds(15, 220, 290, 45);

    bEndereco = new JButton("Adicionar Novo Endereço");
    bEndereco.setBounds(15, 275, 290, 45);
    bEndereco.setFocusable(true);

    tfDesconto = new JTextField("Desconto");
    tfDesconto.setFont(verdana);
    tfDesconto.setBounds(15, 330, 290, 45); 
    tfDesconto.setForeground(corFiller);
    tfDesconto.setFocusable(true);
    fillerText("Desconto", tfDesconto);

    lblTabela = new JLabel("Endereços");
    lblTabela.setFont(verdana);
    lblTabela.setBounds(465, 15, 290, 30);

    tTabela = new JTable();
    tTabela.setBounds(465, 46, 390, 340);    
    tTabela.setBorder(BorderFactory.createLineBorder(Color.black, 2));

    bAdicionar = new JButton("Adicionar Fornecedor");
    bAdicionar.setIcon(new ImageIcon("Programa/res/iconAdicionar.png"));
    bAdicionar.setBounds(110, 430, 300, 100);
    bAdicionar.setFocusable(false);
    bAdicionar.setFont(new Font("Verdana", Font.PLAIN, 20));

    bRetornar = new JButton("Retornar");
    bRetornar.setIcon(new ImageIcon("Programa/res/iconRetorno.png"));
    bRetornar.setBounds(490, 430, 300, 100);  
    bRetornar.setFocusable(false);
    bRetornar.setFont(verdana);

    this.setFocusList(new ArrayList<>());
  }

  private void fillerText(String texto, JTextField tf){
    tf.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        if (tf.getForeground().equals(corFiller)){
          tf.setText("");
          tf.setForeground(Color.black);
        }
      }

      @Override
      public void focusLost(FocusEvent e) {
        if (tf.getText().equals("") || tf.getText() == null){
          tf.setForeground(corFiller);
          tf.setText(texto);
        }
      }
    });
  }

  public void atualizarDados(List<Endereco> listaEnderecos){
    Object o [][] = new Object[listaEnderecos.size()][6];
    for (int i=0; i<listaEnderecos.size(); i++){
      o[i][0] = listaEnderecos.get(i).getRua();
      o[i][1] = listaEnderecos.get(i).getBairro();
      o[i][2] = listaEnderecos.get(i).getCidade();
      o[i][3] = listaEnderecos.get(i).getCep();
      o[i][4] = listaEnderecos.get(i).getNum();
      o[i][5] = listaEnderecos.get(i).getTelefone();
    }
    this.dados = o;
    tableModel = new DefaultTableModel(dados, colunas);
    tTabela.setModel(tableModel);
  }

  
  @Override
  public void mudarTamanhoDosComponentes(float width, float height, boolean aumentando) {
    if (aumentando){
      mudarBounds(insidePanel, width, height, 880, 400);
      mudarBounds(tfCnpj, width, height, 290, 45);
      mudarBounds(tfEndereco, width, height, 290, 45);
      mudarBounds(tfNomeFantasia, width, height, 290, 45);
      mudarBounds(tfRazaoSocial, width, height, 290, 45);
      mudarBounds(bAdicionar, width, height, 300, 100);
      mudarBounds(bEndereco, width, height, 290, 45);
      mudarBounds(tfDesconto, width, height, 290, 45);
      mudarBounds(bRetornar, width, height, 300, 100);
      mudarBounds(lblCnpj, width, height, 290, 30);
      mudarBounds(lblTabela, width, height, 290, 30);
      mudarBounds(tTabela, width, height, 390, 340);
    }
    else {
      insidePanel.setBounds(10, 10, 880, 400);
      tfNomeFantasia.setBounds(15, 15, 290, 45);
      tfRazaoSocial.setBounds(15, 70, 290, 45);
      lblCnpj.setBounds(15,125,290,30); 
      tfCnpj.setBounds(15, 165, 290, 45);
      tfEndereco.setBounds(15, 220, 290, 45);
      bEndereco.setBounds(15, 275, 290, 45);
      tfDesconto.setBounds(15, 330, 290, 45);
      lblTabela.setBounds(465, 15, 290, 30);
      tTabela.setBounds(465, 46, 390, 340);    
      bAdicionar.setBounds(110, 430, 300, 100);
      bRetornar.setBounds(490, 430, 300, 100);  
    }
  }


  //getters e setters
  public JButton getbEndereco() {
    return bEndereco;
  }

  public void setbEndereco(JButton bEndereco) {
    this.bEndereco = bEndereco;
  }

  public JButton getbRetornar() {
    return bRetornar;
  }

  public void setbRetornar(JButton bRetornar) {
    this.bRetornar = bRetornar;
  }

  public JTextField getTfNomeFantasia() {
    return tfNomeFantasia;
  }

  public void setTfNomeFantasia(JTextField tfNomeFantasia) {
    this.tfNomeFantasia = tfNomeFantasia;
  }

  public JTextField getTfRazaoSocial() {
    return tfRazaoSocial;
  }

  public void setTfRazaoSocial(JTextField tfRazaoSocial) {
    this.tfRazaoSocial = tfRazaoSocial;
  }

  public JTextField getTfEndereco() {
    return tfEndereco;
  }

  public void setTfEndereco(JTextField tfEndereco) {
    this.tfEndereco = tfEndereco;
  }

  public JFormattedTextField getTfCnpj() {
    return tfCnpj;
  }

  public void setTfCnpj(JFormattedTextField tfCnpj) {
    this.tfCnpj = tfCnpj;
  }

  public JButton getbAdicionar() {
    return bAdicionar;
  }

  public void setbAdicionar(JButton bAdicionar) {
    this.bAdicionar = bAdicionar;
  }

  public JTable gettTabela() {
    return tTabela;
  }

  public void settTabela(JTable tTabela) {
    this.tTabela = tTabela;
  }

  public JTextField getTfDesconto() {
    return tfDesconto;
  }

  public void setTfDesconto(JTextField tfDesconto) {
    this.tfDesconto = tfDesconto;
  }

  public Color getCorFiller() {
    return corFiller;
  }

  public void setCorFiller(Color corFiller) {
    this.corFiller = corFiller;
  }

  public boolean isEnderecoPopUp() {
    return isEnderecoPopUp;
  }

  public void setEnderecoPopUp(boolean isEnderecoPopUp) {
    this.isEnderecoPopUp = isEnderecoPopUp;
  }
}