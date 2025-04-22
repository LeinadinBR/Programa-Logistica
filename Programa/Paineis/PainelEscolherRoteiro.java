package Programa.Paineis;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Programa.Roteiro;

public class PainelEscolherRoteiro extends PainelBase {
  
  private JTable tTabela;
  private JScrollPane scrollPane;
  private JButton bEscolher;
  private Font regularFont;
  private JPanel insidePanel;

  private Object[] colunas = new Object[] {"Região", "Data Início", "Data de fim"};
  private Object[][] dados = null;
  private DefaultTableModel tableModel = new DefaultTableModel(dados, colunas);
  private TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(tableModel);

  private Roteiro roteiroLocal;

  public PainelEscolherRoteiro(){
    init();

    insidePanel.add(scrollPane);
    insidePanel.add(bEscolher);

    this.getFocusList().add(tTabela);
    this.getFocusList().add(bEscolher);

    this.add(insidePanel);
  }

  private void init(){
    this.setBackground(new Color(188, 216, 216));
    this.setLayout(null);

    regularFont = new Font("Verdana", Font.PLAIN, 25);

    tTabela = new JTable(tableModel){
      @Override
      public boolean isCellEditable(int row, int column){
        return column != 0 && column != 1 && column != 2; 
      }
    };
    tTabela.setRowSorter(rowSorter);

    scrollPane = new JScrollPane();
    scrollPane.setBounds(15, 10, 410, 500); //TODO mudar
    scrollPane.getViewport().add(tTabela);
    scrollPane.setBorder(BorderFactory.createLineBorder(Color.black, 3));

    bEscolher = new JButton("Escolher");
    bEscolher.setBounds(95, 520, 250, 35);
    bEscolher.setFont(regularFont);

    insidePanel = new JPanel();
    insidePanel.setBounds(10, 10, 445, 570);
    insidePanel.setBackground(new Color(230, 247, 247));
    insidePanel.setLayout(null);
    insidePanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));

    this.setFocusList(new ArrayList<>());
  }

  @Override
  public void mudarTamanhoDosComponentes(float width, float height, boolean aumentando) {
    if (aumentando){
      mudarBounds(insidePanel, width, height, 455, 580);
      mudarBounds(scrollPane, width, height, 410, 500);
      mudarBounds(bEscolher, width, height, 250, 35);
    }
    else {
      insidePanel.setBounds(10, 10, 455, 570);
      scrollPane.setBounds(15, 10, 410, 500);
      bEscolher.setBounds(95, 520, 250, 35);
    }
  }

  public void atualizarDados(List<Roteiro> listaRoteiros){
    Object o [][] = new Object[listaRoteiros.size()][3];
    for (int i=0; i<listaRoteiros.size(); i++){
      o[i][0] = listaRoteiros.get(i).getRegião();
      o[i][1] = listaRoteiros.get(i).getDataInicio().getFullData();
      o[i][2] = listaRoteiros.get(i).getDataTermino().getFullData();
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

  public JButton getbEscolher() {
    return bEscolher;
  }

  public void setbEscolher(JButton bEscolher) {
    this.bEscolher = bEscolher;
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

  public Roteiro getRoteiroLocal() {
    return roteiroLocal;
  }

  public void setRoteiroLocal(Roteiro roteiroLocal) {
    this.roteiroLocal = roteiroLocal;
  }
}
