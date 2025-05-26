package Programa.Paineis;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Programa.Produto;

public class PainelAdicionarProduto extends PainelBase {
  private JPanel insidePanel;
  private JTable tTabela;
  private JTextField tfProduto, tfQuantidade;
  private JLabel lProduto, lQuantidade;
  private JButton bAdicionar, bFechar;
  private JScrollPane scrollPane;

  private Object[] colunas = new Object[] {"ID", "Nome", "Fornecedor", "Preço de Venda"};
  private Object[][] dados = null;
  private DefaultTableModel tableModel = new DefaultTableModel(dados, colunas);
  private TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(tableModel);

  private Color corFiller = new Color(200, 160, 160);

  public PainelAdicionarProduto(){
    init();

    this.setLayout(null);

    insidePanel.add(scrollPane);
    insidePanel.add(lProduto);
    insidePanel.add(tfProduto);
    insidePanel.add(lQuantidade);
    insidePanel.add(tfQuantidade);
    insidePanel.add(bAdicionar);

    this.add(insidePanel);
    this.add(bFechar);
  }

  private void init(){
    this.setBackground(new Color(188, 216, 216));
    this.setSize(new Dimension(850, 560));
    Font verdana = new Font("Verdana", Font.PLAIN, 25);

    insidePanel = new JPanel();
    insidePanel.setBackground(new Color(230,247,247));
    insidePanel.setBounds(10, 10, 810, 430);
    insidePanel.setLayout(null);
    insidePanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));

    tTabela = new JTable(tableModel);
    tTabela.setRowSorter(rowSorter);

    scrollPane = new JScrollPane();
    scrollPane.setBounds(10, 10, 380, 350);
    scrollPane.getViewport().add(tTabela);
    scrollPane.setBorder(BorderFactory.createLineBorder(Color.black, 3));

    lProduto = new JLabel("Produto");
    lProduto.setFont(verdana);
    lProduto.setBounds(540, 15, 200, 30);

    tfProduto = new JTextField();
    tfProduto.setFont(verdana);
    tfProduto.setBounds(450, 50, 300, 30);

    lQuantidade = new JLabel("Quantidade");
    lQuantidade.setFont(verdana);
    lQuantidade.setBounds(540, 100, 200, 30);

    tfQuantidade = new JTextField();
    tfQuantidade.setFont(verdana);
    tfQuantidade.setBounds(450, 140, 300, 30);

    bAdicionar = new JButton("Adicionar");
    bAdicionar.setIcon(new ImageIcon("Programa/res/iconAdicionar.png"));
    bAdicionar.setFont(verdana);
    bAdicionar.setBounds(450, 190, 300, 40);

    bFechar = new JButton("Fechar");
    bFechar.setFont(verdana);
    bFechar.setFocusable(false);
    bFechar.setBounds(280, 450, 300, 60);
  }

  public void atualizarDados(List<Produto> listaProduto){
    Object o [][] = new Object[listaProduto.size()][4];
    for (int i=0; i<listaProduto.size(); i++){
      o[i][0] = listaProduto.get(i).getCodigo();
      o[i][1] = listaProduto.get(i).getNome();
      o[i][2] = listaProduto.get(i).getFornecedor().getNomeFantasia();
      o[i][3] = listaProduto.get(i).getPrecoDeVenda();
    }
    this.dados = o;
    tableModel.setDataVector(dados, colunas);
    tTabela.setRowSorter(rowSorter);
  }

  //getters e setters
  public JTable gettTabela() {
    return tTabela;
  }

  public void settTabela(JTable tTabela) {
    this.tTabela = tTabela;
  }

  public JTextField getTfProduto() {
    return tfProduto;
  }

  public void setTfProduto(JTextField tfProduto) {
    this.tfProduto = tfProduto;
  }

  public JTextField getTfQuantidade() {
    return tfQuantidade;
  }

  public void setTfQuantidade(JTextField tfQuantidade) {
    this.tfQuantidade = tfQuantidade;
  }

  public JButton getbAdicionar() {
    return bAdicionar;
  }

  public void setbAdicionar(JButton bAdicionar) {
    this.bAdicionar = bAdicionar;
  }

  public JButton getbFechar() {
    return bFechar;
  }

  public void setbFechar(JButton bFechar) {
    this.bFechar = bFechar;
  }

  public TableRowSorter<DefaultTableModel> getRowSorter() {
    return rowSorter;
  }

  public void setRowSorter(TableRowSorter<DefaultTableModel> rowSorter) {
    this.rowSorter = rowSorter;
  }

  public Color getCorFiller() {
    return corFiller;
  }

  public void setCorFiller(Color corFiller) {
    this.corFiller = corFiller;
  }  
 
}
