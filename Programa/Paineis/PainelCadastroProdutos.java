package Programa.Paineis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Programa.Fornecedor;

public class PainelCadastroProdutos extends PainelBase {
  private JTextField tfId;
  private JTextField tfNome;
  private JTextField tfPrecoCompra;
  private JTextField tfPrecoVenda; 
  private JTextField tfDataDeValidade;
  private JTextField tfFornecedor;
  private JPanel insidePanel;
  private JButton bRetornar;
  private JButton bAdicionar;
  private JButton bMaisID;
  private JButton bMenosId;
  private JLabel lbl;
  private JLabel lblId;
  private JTable tTabela;

  private Color corFiller = new Color(200, 160, 160);

  private Object[][] dados = null;
  private Object[] colunas = new Object[]{"Nome Fantasia", "Razão Social", "CNPJ", "Endereço", "Desconto"};
  private DefaultTableModel tableModel = new DefaultTableModel(dados, colunas);
  
  public PainelCadastroProdutos(){
    //TODO adicionar Scrollpanes para as tabelas daqui e dos outros cadastros
    init();

    this.setLayout(null);

    this.add(insidePanel);
    this.add(bAdicionar);
    this.add(bRetornar);

    insidePanel.add(lblId);
    this.getFocusList().add(tfId);
    insidePanel.add(tfId);
    insidePanel.add(bMaisID);
    insidePanel.add(bMenosId);
    this.getFocusList().add(tfNome);
    insidePanel.add(tfNome);
    this.getFocusList().add(tfPrecoCompra);
    insidePanel.add(tfPrecoCompra);
    this.getFocusList().add(tfPrecoVenda);
    insidePanel.add(tfPrecoVenda);
    //insidePanel.add(tfDataDeValidade);
    insidePanel.add(tfFornecedor);
    insidePanel.add(lbl);
    this.getFocusList().add(tTabela);
    insidePanel.add(tTabela);
  }

  private void init(){
    this.setBackground(new Color(188, 216, 216));

    insidePanel = new JPanel();
    insidePanel.setBounds(10, 10, 880, 400);
    insidePanel.setBackground(new Color(230, 247, 247));
    insidePanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));
    insidePanel.setLayout(null);

    bAdicionar = new JButton("Adicionar");
    bAdicionar.setIcon(new ImageIcon("Programa/res/iconAdicionar.png"));
    bAdicionar.setFocusable(false);
    bAdicionar.setBounds(110, 430, 300, 100);
    bAdicionar.setFont(new Font("Verdana", Font.PLAIN, 25));

    bRetornar = new JButton("Retornar");
    bRetornar.setIcon(new ImageIcon("Programa/res/iconRetorno.png"));
    bRetornar.setFocusable(false);
    bRetornar.setBounds(490, 430, 300, 100);
    bRetornar.setFont(new Font("Verdana", Font.PLAIN, 25));

    lblId = new JLabel("ID");
    lblId.setFont(new Font("Verdana", Font.PLAIN, 20));
    lblId.setBounds(15, 10, 100, 20);

    tfId = new JTextField();
    tfId.setText("1");
    tfId.setSelectedTextColor(Color.red);
    tfId.setBounds(15, 35, 340, 50);
    tfId.setFont(new Font("Verdana", Font.PLAIN, 25));
   
  
    bMaisID = new JButton("+");
    bMaisID.setFocusable(false);
    bMaisID.setBounds(360, 30, 50, 30);
    bMaisID.setFont(new Font("Verdana", Font.PLAIN, 20));

    bMenosId = new JButton("-");
    bMenosId.setFocusable(false);
    bMenosId.setBounds(360, 60, 50, 30);
    bMenosId.setFont(new Font("Verdana", Font.BOLD, 20));

    tfNome = new JTextField("Nome");
    tfNome.setSelectedTextColor(Color.red);
    tfNome.setBounds(15, 95, 340, 50);
    tfNome.setFont(new Font("Verdana", Font.PLAIN, 25));
    tfNome.setForeground(corFiller);
    fillerText("Nome", tfNome);

    tfPrecoCompra = new JTextField("Preço de Compra");
    tfPrecoCompra.setSelectedTextColor(Color.red);
    tfPrecoCompra.setBounds(15, 155, 340, 50);
    tfPrecoCompra.setFont(new Font("Verdana", Font.PLAIN, 25));
    tfPrecoCompra.setForeground(corFiller);
    fillerText("Preço de Compra", tfPrecoCompra);

    tfPrecoVenda = new JTextField("Preço de Venda");
    tfPrecoVenda.setSelectedTextColor(Color.red);
    tfPrecoVenda.setBounds(15, 215, 340, 50);
    tfPrecoVenda.setFont(new Font("Verdana", Font.PLAIN, 25));
    tfPrecoVenda.setForeground(corFiller);
    fillerText("Preço de Venda", tfPrecoVenda);

    /*
    Data de validade descontinuada

    tfDataDeValidade = new JTextField("Data de Validade");
    tfDataDeValidade.setSelectedTextColor(Color.red);
    tfDataDeValidade.setBounds(15, 275, 340, 50);
    tfDataDeValidade.setFont(new Font("Verdana", Font.PLAIN, 25));
    tfDataDeValidade.setForeground(corFiller);
    fillerText("Data de Validade", tfDataDeValidade);*/

    tfFornecedor = new JTextField("Fornecedor");
    tfFornecedor.setSelectedTextColor(Color.red);
    tfFornecedor.setBounds(15, 275, 340, 50);
    tfFornecedor.setFont(new Font("Verdana", Font.PLAIN, 25));
    tfFornecedor.setEditable(false);

    lbl = new JLabel("Fornecedores");
    lbl.setBounds(465, 15, 290, 30);
    lbl.setFont(new Font("Verdana", Font.PLAIN, 25));

    tTabela = new JTable();
    tTabela.setEnabled(false);
    tTabela.setBounds(465, 46, 385, 340);    
    tTabela.setBorder(BorderFactory.createLineBorder(Color.black, 2));

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

  @Override
  public void mudarTamanhoDosComponentes(float width, float height, boolean aumentando) {
    if (aumentando){
      mudarBounds(insidePanel, width, height, 880, 400);
      mudarBounds(bAdicionar, width, height, 300, 100);
      mudarBounds(bRetornar, width, height, 300, 100);
      mudarBounds(lblId, width, height, 100, 20);
      mudarBounds(tfId, width, height, 340, 50);
      mudarBounds(bMaisID, width, height, 50, 30);
      mudarBounds(bMenosId, width, height, 50, 30);
      mudarBounds(tfNome, width, height, 340, 50);
      mudarBounds(tfPrecoCompra, width, height, 340, 50);
      mudarBounds(tfPrecoVenda, width, height, 340, 50);
      mudarBounds(tfFornecedor, width, height, 340, 50);
      mudarBounds(lbl, width, height, 290, 30);
      mudarBounds(tTabela, width, height, 385, 340);
      //mudarBounds(tfDataDeValidade, width, height, 340, 50);
    }
    else {
      insidePanel.setBounds(10, 10, 880, 400);
      bAdicionar.setBounds(110, 430, 300, 100);
      bRetornar.setBounds(490, 430, 300, 100);
      lblId.setBounds(15, 10, 100, 20);
      tfId.setBounds(15, 35, 340, 50);
      bMaisID.setBounds(360, 30, 50, 30);
      bMenosId.setBounds(360, 60, 50, 30);
      tfNome.setBounds(15, 95, 340, 50);
      tfPrecoCompra.setBounds(15, 155, 340, 50);
      tfPrecoVenda.setBounds(15, 215, 340, 50);
      tfFornecedor.setBounds(15, 275, 340, 50);
      lbl.setBounds(465, 15, 290, 30);
      tTabela.setBounds(465, 46, 385, 340);    
      //tfDataDeValidade.setBounds(15, 275, 340, 50);
    }
  }

  public void atualizarDados(List<Fornecedor> listaFornecedores){
    Object o [][] = new Object[listaFornecedores.size()][5];
    for (int i=0; i<listaFornecedores.size(); i++){
      o[i][0] = listaFornecedores.get(i).getNomeFantasia();
      o[i][1] = listaFornecedores.get(i).getRazaoSocial();
      o[i][2] = listaFornecedores.get(i).getCnpj();
      o[i][3] = listaFornecedores.get(i).getEndereco().getCep();
      o[i][4] = listaFornecedores.get(i).getDesconto();
    }
    this.dados = o;
    tableModel = new DefaultTableModel(dados, colunas);
    tTabela.setModel(tableModel);
  }

  //getters e setters
  public JButton getbRetornar() {
    return bRetornar;
  }

  public void setbRetornar(JButton bRetornar) {
    this.bRetornar = bRetornar;
  }

  public JTextField getTfId() {
    return tfId;
  }

  public void setTfId(JTextField tfId) {
    this.tfId = tfId;
  }

  public JTextField getTfNome() {
    return tfNome;
  }

  public void setTfNome(JTextField tfNome) {
    this.tfNome = tfNome;
  }

  public JTextField getTfPrecoCompra() {
    return tfPrecoCompra;
  }

  public void setTfPrecoCompra(JTextField tfPrecoCompra) {
    this.tfPrecoCompra = tfPrecoCompra;
  }

  public JTextField getTfPrecoVenda() {
    return tfPrecoVenda;
  }

  public void setTfPrecoVenda(JTextField tfPrecoVenda) {
    this.tfPrecoVenda = tfPrecoVenda;
  }

  public JTextField getTfFornecedor() {
    return tfFornecedor;
  }

  public void setTfFornecedor(JTextField tfFornecedor) {
    this.tfFornecedor = tfFornecedor;
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

  public JButton getbMaisID() {
    return bMaisID;
  }

  public void setbMaisID(JButton bMaisID) {
    this.bMaisID = bMaisID;
  }

  public JButton getbMenosId() {
    return bMenosId;
  }

  public void setbMenosId(JButton bMenosId) {
    this.bMenosId = bMenosId;
  }

  public Color getCorFiller() {
    return corFiller;
  }

  public void setCorFiller(Color corFiller) {
    this.corFiller = corFiller;
  }

  public JTextField getTfDataDeValidade() {
    return tfDataDeValidade;
  }

  public void setTfDataDeValidade(JTextField tfDataDeValidade) {
    this.tfDataDeValidade = tfDataDeValidade;
  }
}
