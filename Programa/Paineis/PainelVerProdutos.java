package Programa.Paineis;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Programa.Produto;

public class PainelVerProdutos extends PainelBase {

  //TODO ver a possibilidade de apagar/editar itens da tabela
  //TODO colocar opção na tabela para expandir detalhes do endereço
  //TODO ao clicar em uma linha da tabela duas vezes, abre uma tela com todos os detalhes
  
  private JPanel insidePanel;
  private JButton bRetornar;
  private JTextField tfPesquisa;
  private JTable tTabela;
  private JScrollPane scrollPane;
  
  private JComboBox<String> cbComboBox;

  private Object[][] dados = null;
  private Object[] colunas = new Object[]{"Id", "Nome", "Preço de Compra", "P.Compra Desconto", "Preço de Venda", 
    "Porcentagem de Lucro", "Lucro Bruto Individual", "Validade"};
  private DefaultTableModel tableModel = new DefaultTableModel(dados, colunas);
  private TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(tableModel); 

  public PainelVerProdutos(){
    init();

    this.add(insidePanel);
    this.add(tfPesquisa);
    this.add(cbComboBox);
    this.add(bRetornar);

    this.getFocusList().add(tfPesquisa);
    this.getFocusList().add(cbComboBox);
    this.getFocusList().add(bRetornar);

    insidePanel.add(scrollPane);
  }

  private void init(){
    this.setBackground(new Color(188, 216, 216));
    this.setLayout(null);
    
    insidePanel = new JPanel();
    insidePanel.setLayout(null);
    insidePanel.setBackground(new Color(230,247,247));
    insidePanel.setBounds(10, 10, 880, 400);
    insidePanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));

    bRetornar = new JButton("Retornar");
    bRetornar.setFont(new Font("Verdana", Font.PLAIN, 25));
    bRetornar.setFocusable(false);
    bRetornar.setBounds(560, 430, 200, 50);

    tfPesquisa = new JTextField();
    tfPesquisa.setFont(new Font("Verdana", Font.PLAIN, 25));
    tfPesquisa.setBounds(90, 430, 300, 50);

    String[] comboBoxList = {"Id", "Nomes", "P.Compra", "P.Compra com Desconto", "P. Venda", "Porcentagem de Lucro",
    "Lucro Bruto Individual", "Validade"};

    cbComboBox = new JComboBox<>(comboBoxList);
    cbComboBox.setBounds(400, 430, 150, 50);

    tTabela = new JTable(tableModel){
      //TODO ver se bloquea a edição da tabela de id
      @Override
      public boolean isCellEditable(int row, int column) {
        return column != 5 && column != 6 && column != 7; 
    }
    };
    tTabela.setRowSorter(rowSorter);
    tTabela.getColumnModel().getColumn(0).setPreferredWidth(4);
    tTabela.getColumnModel().getColumn(1).setPreferredWidth(12);
    tTabela.getColumnModel().getColumn(2).setPreferredWidth(25);
    tTabela.getColumnModel().getColumn(3).setPreferredWidth(45);
    tTabela.getColumnModel().getColumn(4).setPreferredWidth(25);
    
    scrollPane = new JScrollPane();
    scrollPane.setSize(new Dimension(850, 370));
    scrollPane.setBounds(15, 15, 850, 370);
    scrollPane.getViewport().add(tTabela);
    scrollPane.setBorder(BorderFactory.createLineBorder(Color.black, 3));

    this.setFocusList(new ArrayList<>());
  }

  @Override
  public void mudarTamanhoDosComponentes(float width, float height, boolean aumentando) {
    if (aumentando) {
      mudarBounds(scrollPane, width, height, 850, 370);
      mudarBounds(cbComboBox, width, height, 150, 50);
      mudarBounds(tfPesquisa, width, height, 300, 50);
      mudarBounds(bRetornar, width, height, 200, 50);
      mudarBounds(insidePanel, width, height, 880, 400);
    } 
    else {
      scrollPane.setBounds(15, 15, 850, 370);
      cbComboBox.setBounds(400, 430, 150, 50);
      tfPesquisa.setBounds(90, 430, 300, 50);
      bRetornar.setBounds(560, 430, 200, 50);
      insidePanel.setBounds(10, 10, 880, 400);
    }
  }

  public void atualizarDados(List<Produto> listaProdutos){
    Object o [][] = new Object[listaProdutos.size()][8];
    for (int i=0; i<listaProdutos.size(); i++){
      o[i][0] = listaProdutos.get(i).getCodigo();
      o[i][1] = listaProdutos.get(i).getNome();
      o[i][2] = listaProdutos.get(i).getPrecoTotal();
      o[i][3] = listaProdutos.get(i).getPrecoComDesconto();
      o[i][4] = listaProdutos.get(i).getPrecoDeVenda();
      o[i][5] = (100 - calcularPorcentagemLucro((double)o[i][3], (double)o[i][4]));
      o[i][6] = ((double)o[i][4] - (double)o[i][3]);
      //o[i][7] = listaProdutos.get(i).getDataDeValidade().getFullData();
    }
    
    this.dados = o;
    tableModel.setDataVector(dados, colunas);
    tTabela.setRowSorter(rowSorter);
  }

  private double calcularPorcentagemLucro(double venda, double compra){
    return (venda*100)/compra;
  }

  //getters e setters
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

  public JTable gettTabela() {
    return tTabela;
  }

  public void settTabela(JTable tTabela) {
    this.tTabela = tTabela;
  }

  public JScrollPane getScrollPane() {
    return scrollPane;
  }

  public void setScrollPane(JScrollPane scrollPane) {
    this.scrollPane = scrollPane;
  }

  public DefaultTableModel getTableModel() {
    return tableModel;
  }

  public void setTableModel(DefaultTableModel tableModel) {
    this.tableModel = tableModel;
  }

  public JComboBox<String> getCbComboBox() {
    return cbComboBox;
  }

  public void setCbComboBox(JComboBox<String> cbComboBox) {
    this.cbComboBox = cbComboBox;
  }

  public TableRowSorter<DefaultTableModel> getRowSorter() {
    return rowSorter;
  }

  public void setRowSorter(TableRowSorter<DefaultTableModel> rowSorter) {
    this.rowSorter = rowSorter;
  }
 
}
