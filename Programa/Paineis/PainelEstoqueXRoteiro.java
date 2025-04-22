package Programa.Paineis;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Programa.Estoque;
import Programa.Roteiro;

public class PainelEstoqueXRoteiro extends PainelBase{
  
  private JPanel insidePanel;
  private JButton bEscolherRoteiro, bRetornar;
  private JTextField tfRoteiro;
  private JTable tTabela;
  private JScrollPane scrollPane;
  private Estoque estoqueLocal = null;
  private List<Roteiro> listaRoteiros = null;

  private Object[] colunas = new Object[] {"Id", "Produto", "Quantidade em Estoque", "Quantidade nos Pedidos", "Quantidade Faltando"};
  private Object[][] dados = null;
  private DefaultTableModel tableModel = new DefaultTableModel(dados, colunas);
  private TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(tableModel);

  public PainelEstoqueXRoteiro(){
    init();

    this.add(insidePanel);
    this.add(bRetornar);
    
    insidePanel.add(tfRoteiro);
    insidePanel.add(bEscolherRoteiro);
    insidePanel.add(scrollPane);

    this.getFocusList().add(tfRoteiro);
    this.getFocusList().add(bEscolherRoteiro);
    this.getFocusList().add(bRetornar);
  }

  private void init(){
    this.setBackground(new Color(188, 216, 216));
    this.setLayout(null);

    insidePanel = new JPanel();
    insidePanel.setBackground(new Color(230, 247, 247));
    insidePanel.setLayout(null);
    insidePanel.setBounds(10, 10, 880, 450);
    insidePanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));

    Font font = new Font("Verdana", Font.PLAIN, 25);

    bEscolherRoteiro = new JButton("Escolher Roteiro");
    bEscolherRoteiro.setFocusable(false);
    bEscolherRoteiro.setFont(font);
    bEscolherRoteiro.setBounds(10, 65, 300, 45);

    bRetornar = new JButton("Retornar");
    bRetornar.setIcon(new ImageIcon("Programa/res/iconRetorno.png"));
    bRetornar.setFocusable(false);
    bRetornar.setFont(font);
    bRetornar.setBounds(300, 470, 300, 60);

    tfRoteiro = new JTextField();
    tfRoteiro.setEditable(false);
    tfRoteiro.setFont(font);
    tfRoteiro.setBounds(10, 10, 300, 40);

    tTabela = new JTable(tableModel);
    tTabela.setRowSorter(rowSorter);

    scrollPane = new JScrollPane();
    scrollPane.getViewport().add(tTabela);
    scrollPane.setBorder(BorderFactory.createLineBorder(Color.black, 3));
    scrollPane.setBounds(340, 10, 500, 430);

    this.setFocusList(new ArrayList<>());
  }

  @Override
  public void mudarTamanhoDosComponentes(float width, float height, boolean aumentando) {
    if (aumentando){
      mudarBounds(scrollPane, width, height, 500, 430);
      mudarBounds(tfRoteiro, width, height, 300, 40);
      mudarBounds(bRetornar, width, height, 300, 60);
      mudarBounds(bEscolherRoteiro, width, height, 300, 45);
      mudarBounds(insidePanel, width, height, 880, 450);
    }
    else {
      scrollPane.setBounds(340, 10, 500, 430);
      tfRoteiro.setBounds(10, 10, 300, 40);
      bRetornar.setBounds(300, 470, 300, 60);
      bEscolherRoteiro.setBounds(10, 65, 300, 45);
      insidePanel.setBounds(10, 10, 880, 450);
    }
  }

  public void atualizarDados(Estoque estoque, List<Roteiro> listaRoteiros){
    this.estoqueLocal = estoque;
    this.listaRoteiros = listaRoteiros;

    tableModel.setDataVector(dados, colunas);
    tTabela.setRowSorter(rowSorter);
  }

  public void atualizarDados(Estoque estoque, Roteiro roteiro){
    //TODO
  }

  //getters e setters
  public JButton getbEscolherRoteiro() {
    return bEscolherRoteiro;
  }

  public void setbEscolherRoteiro(JButton bEscolherRoteiro) {
    this.bEscolherRoteiro = bEscolherRoteiro;
  }

  public JButton getbRetornar() {
    return bRetornar;
  }

  public void setbRetornar(JButton bRetornar) {
    this.bRetornar = bRetornar;
  }

  public JTextField getTfRoteiro() {
    return tfRoteiro;
  }

  public void setTfRoteiro(JTextField tfRoteiro) {
    this.tfRoteiro = tfRoteiro;
  }

  public JTable gettTabela() {
    return tTabela;
  }

  public void settTabela(JTable tTabela) {
    this.tTabela = tTabela;
  }

  public DefaultTableModel getTableModel() {
    return tableModel;
  }

  public void setTableModel(DefaultTableModel tableModel) {
    this.tableModel = tableModel;
  }

  public TableRowSorter<DefaultTableModel> getRowSorter() {
    return rowSorter;
  }

  public void setRowSorter(TableRowSorter<DefaultTableModel> rowSorter) {
    this.rowSorter = rowSorter;
  }
}
