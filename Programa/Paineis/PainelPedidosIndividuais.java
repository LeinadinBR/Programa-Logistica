package Programa.Paineis;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Programa.Pedido;

public class PainelPedidosIndividuais extends PainelBase {

  private JPanel insidePanel;
  private JButton bRetornar;
  private JTextField tfPesquisa;
  private JComboBox<String> cbPesquisa;
  private JTable tTabela;
  private JScrollPane scrollPane;

  private String[] colunas = new String[]{"Número do Pedido", "Roteiro", "Data", "Cliente", "Valor"};
  private Object[][] dados = null;
  private DefaultTableModel tableModel = new DefaultTableModel(dados, colunas);
  private TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(tableModel); 

  public PainelPedidosIndividuais(){
    init();

    this.add(insidePanel);
    this.add(bRetornar);
    
    insidePanel.add(tfPesquisa);
    insidePanel.add(cbPesquisa);
    insidePanel.add(scrollPane);

    this.getFocusList().add(tfPesquisa);
    this.getFocusList().add(cbPesquisa);
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

    bRetornar = new JButton("Retornar");
    bRetornar.setIcon(new ImageIcon("Programa/res/iconRetorno.png"));
    bRetornar.setFont(font);
    bRetornar.setFocusable(false);
    bRetornar.setBounds(300, 460, 300, 90);

    tfPesquisa = new JTextField();
    tfPesquisa.setFont(font);
    tfPesquisa.setBounds(10, 10, 200, 40);

    String[] listaComboBox = new String[] {"Número do Pedido", "Roteiro", "Data", "Cliente", "Valor"};

    cbPesquisa = new JComboBox<>(listaComboBox);
    cbPesquisa.setBounds(10, 60, 200, 40);

    tTabela = new JTable(tableModel);
    tTabela.setRowSorter(rowSorter);
    tTabela.setDefaultEditor(Object.class, null);

    scrollPane = new JScrollPane();
    scrollPane.setBounds(250, 15, 600, 370);
    scrollPane.getViewport().add(tTabela);
    scrollPane.setBorder(BorderFactory.createLineBorder(Color.black, 3));

    this.setFocusList(new ArrayList<>());
  }

  public void atualizarDados(List<Pedido> listaPedidos){
    Object o[][] = new Object[listaPedidos.size()][5];
    for (int i=0; i<listaPedidos.size(); i++){
      o[i][0] = listaPedidos.get(i).getNumPedido();
      o[i][1] = listaPedidos.get(i).getRoteiro().getRegião();
      o[i][2] = listaPedidos.get(i).getData().getFullData();
      o[i][3] = listaPedidos.get(i).getCliente().getNome();
      o[i][4] = listaPedidos.get(i).getValorTotal();
    }
    this.dados = o;
    tableModel.setDataVector(dados, colunas);
    tTabela.setRowSorter(rowSorter);
  }

  @Override
  public void mudarTamanhoDosComponentes(float width, float height, boolean aumentando) {
    if (aumentando){
      mudarBounds(scrollPane, width, height, 600, 370);
      mudarBounds(cbPesquisa, width, height, 200, 40);
      mudarBounds(tfPesquisa, width, height, 200, 40);
      mudarBounds(bRetornar, width, height, 300, 90);
      mudarBounds(insidePanel, width, height, 880, 450);
    }
    else {
      scrollPane.setBounds(250, 15, 600, 370);
      cbPesquisa.setBounds(10, 60, 200, 40);
      tfPesquisa.setBounds(10, 10, 200, 40);
      bRetornar.setBounds(300, 460, 300, 90);
      insidePanel.setBounds(10, 10, 880, 450);
    }
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

  public JComboBox<String> getCbPesquisa() {
    return cbPesquisa;
  }

  public void setCbPesquisa(JComboBox<String> cbPesquisa) {
    this.cbPesquisa = cbPesquisa;
  }

  public JTable gettTabela() {
    return tTabela;
  }

  public void settTabela(JTable tTabela) {
    this.tTabela = tTabela;
  }

  public TableRowSorter<DefaultTableModel> getRowSorter() {
    return rowSorter;
  }

  public void setRowSorter(TableRowSorter<DefaultTableModel> rowSorter) {
    this.rowSorter = rowSorter;
  }
}
