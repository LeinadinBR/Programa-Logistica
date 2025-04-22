package Programa.Paineis;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Programa.ProdutoQuantidade;

public class PainelEstoque extends PainelBase {
  
  private JScrollPane scrollPane;
  private JTable tTabela;
  private JButton bRetornar;
  private JTextField tfPesquisa;
  private JLabel lbl;
  private JComboBox<String> cbClassificacao;
  private JPanel insidePanel;
  private Font regularFont;

  private Object[] colunas = new Object[] {"Id", "Nome", "Fornecedor" , "Preço de Venda", "Quantidade"};
  private Object[][] dados = null;
  private DefaultTableModel tableModel = new DefaultTableModel(dados, colunas);
  private TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(tableModel);

  public PainelEstoque(){
    init();

    insidePanel.add(lbl);
    insidePanel.add(tfPesquisa);
    insidePanel.add(cbClassificacao);
    insidePanel.add(scrollPane);

    this.getFocusList().add(tfPesquisa);
    this.getFocusList().add(cbClassificacao);
    this.getFocusList().add(bRetornar);

    this.add(insidePanel);
    this.add(bRetornar);
  }

  public void init(){
    this.setBackground(new Color(188, 216, 216));
    this.setLayout(null);

    regularFont = new Font("Verdana", Font.PLAIN, 25);

    bRetornar = new JButton("Retornar");
    bRetornar.setIcon(new ImageIcon("Programa/res/iconRetorno.png"));
    bRetornar.setFocusable(false);
    bRetornar.setBounds(300, 480, 300, 60);
    bRetornar.setFont(regularFont);

    lbl = new JLabel("Pesquisar");
    lbl.setFont(regularFont);
    lbl.setBounds(30, 10, 150, 30);

    tfPesquisa = new JTextField();
    tfPesquisa.setBounds(10, 45, 200, 50);
    tfPesquisa.setFont(regularFont);

    String[] comboBoxList = {"Id", "Nome", "Fornecedor", "Preço de Venda", "Quantidade"};

    cbClassificacao = new JComboBox<>(comboBoxList);
    cbClassificacao.setBounds(10, 100, 200, 50);

    tTabela = new JTable(tableModel);
    tTabela.setRowSorter(rowSorter);

    scrollPane = new JScrollPane();
    scrollPane.setBounds(250, 10, 600, 410);
    scrollPane.getViewport().add(tTabela);
    scrollPane.setBorder(BorderFactory.createLineBorder(Color.black, 3));

    insidePanel = new JPanel();
    insidePanel.setBounds(10, 10, 870, 460);
    insidePanel.setBackground(new Color(230, 247, 247));
    insidePanel.setLayout(null);
    insidePanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));

    this.setFocusList(new ArrayList<>());
  }

  @Override
  public void mudarTamanhoDosComponentes(float width, float height, boolean aumentando) {
    if (aumentando){
      mudarBounds(insidePanel, width, height, 870, 460);
      mudarBounds(scrollPane, width, height, 600, 410);
      mudarBounds(cbClassificacao, width, height, 200, 50);
      mudarBounds(tfPesquisa, width, height, 200, 50);
      mudarBounds(lbl, width, height, 150, 30);
      mudarBounds(bRetornar, width, height, 300, 60);
    }
    else {
      insidePanel.setBounds(10, 10, 870, 460);
      scrollPane.setBounds(250, 10, 600, 410);
      cbClassificacao.setBounds(10, 100, 200, 50);
      tfPesquisa.setBounds(10, 45, 200, 50);
      lbl.setBounds(30, 10, 150, 30);
      bRetornar.setBounds(300, 480, 300, 60);

    }
  }

  public void atualizarDados(List<ProdutoQuantidade> listaProdutoQuantidade){
    Object o [][] = new Object[listaProdutoQuantidade.size()][5];
    for (int i=0; i<listaProdutoQuantidade.size(); i++){
      o[i][0] = listaProdutoQuantidade.get(i).getProduto().getCodigo();
      o[i][1] = listaProdutoQuantidade.get(i).getProduto().getNome();
      o[i][2] = listaProdutoQuantidade.get(i).getProduto().getFornecedor().getNomeFantasia();
      o[i][3] = listaProdutoQuantidade.get(i).getProduto().getPrecoDeVenda();
      o[i][4] = listaProdutoQuantidade.get(i).getQuantidade();
    }
    this.dados = o;
    tableModel.setDataVector(dados, colunas);
    tTabela.setRowSorter(rowSorter);
  }

  //getters e setters
  public DefaultTableModel getTableModel() {
    return tableModel;
  }

  public void setTableModel(DefaultTableModel tableModel) {
    this.tableModel = tableModel;
  }

  public JScrollPane getScrollPane() {
    return scrollPane;
  }

  public void setScrollPane(JScrollPane scrollPane) {
    this.scrollPane = scrollPane;
  }

  public JTable gettTabela() {
    return tTabela;
  }

  public void settTabela(JTable tTabela) {
    this.tTabela = tTabela;
  }

  public JButton getbRetornar() {
    return bRetornar;
  }

  public void setbRetornar(JButton bRetornar) {
    this.bRetornar = bRetornar;
  }

  public JTextField getTfPesquisa() {
    return tfPesquisa;
  }

  public void setTfPesquisa(JTextField tfPesquisa) {
    this.tfPesquisa = tfPesquisa;
  }

  public JComboBox<String> getCbClassificacao() {
    return cbClassificacao;
  }

  public void setCbClassificacao(JComboBox<String> cbClassificacao) {
    this.cbClassificacao = cbClassificacao;
  }

  public TableRowSorter<DefaultTableModel> getRowSorter() {
    return rowSorter;
  }

  public void setRowSorter(TableRowSorter<DefaultTableModel> rowSorter) {
    this.rowSorter = rowSorter;
  }
}
