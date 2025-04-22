package Programa.Paineis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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

import Programa.Pedido;

public class PainelRoteiroParaIndividual extends PainelBase {
  private JPanel insidePanel;
  private JButton bFechar;
  private JTextField tfPesquisa;
  private JComboBox<String> cbPesquisa;
  private JTable tTabela;
  private JScrollPane scrollPane;

  private String[] colunas = new String[]{"Número do Pedido", "Roteiro", "Data", "Cliente", "Valor"};
  private Object[][] dados = null;
  private DefaultTableModel tableModel = new DefaultTableModel(dados, colunas);
  private TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(tableModel); 

  private Color corFiller = new Color(200, 160, 160);

  public PainelRoteiroParaIndividual(){
    init();

    this.setLayout(null);
    this.add(insidePanel);
    this.add(bFechar);

    insidePanel.add(tfPesquisa);
    insidePanel.add(cbPesquisa);
    insidePanel.add(scrollPane);

    this.getFocusList().add(tfPesquisa);
    this.getFocusList().add(cbPesquisa);
    this.getFocusList().add(bFechar);
  }

  private void init(){
    this.setBackground(new Color(188, 216, 216));

    insidePanel = new JPanel();
    insidePanel.setLayout(null);
    insidePanel.setBackground(new Color(230, 247, 247));
    insidePanel.setBounds(10, 10, 880, 450);
    insidePanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));

    Font font = new Font("Verdana", Font.PLAIN, 25);

    bFechar = new JButton("Retornar");
    bFechar.setFont(font);
    bFechar.setFocusable(false);
    bFechar.setBounds(300, 460, 300, 90);

    tfPesquisa = new JTextField("Pesquisa");
    tfPesquisa.setFont(font);
    tfPesquisa.setBounds(10, 20, 220, 40);
    tfPesquisa.setForeground(corFiller);
    fillerText("Pesquisa", tfPesquisa);

    String[] listaComboBox = new String[] {"Número do Pedido", "Roteiro", "Data", "Cliente", "Valor"};

    cbPesquisa = new JComboBox<>(listaComboBox);
    cbPesquisa.setBounds(10, 75, 200, 40);

    tTabela = new JTable(tableModel);
    tTabela.setRowSorter(rowSorter);
    tTabela.setDefaultEditor(Object.class, null);

    scrollPane = new JScrollPane();
    scrollPane.setBounds(250, 15, 600, 410);
    scrollPane.getViewport().add(tTabela);
    scrollPane.setBorder(BorderFactory.createLineBorder(Color.black, 3));

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

  //getters e setters
  public JButton getbFechar() {
    return bFechar;
  }

  public void setbFechar(JButton bFechar) {
    this.bFechar = bFechar;
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

  public TableRowSorter<DefaultTableModel> getRowSorter() {
    return rowSorter;
  }

  public void setRowSorter(TableRowSorter<DefaultTableModel> rowSorter) {
    this.rowSorter = rowSorter;
  }

  public JTable gettTabela() {
    return tTabela;
  }

  public void settTabela(JTable tTabela) {
    this.tTabela = tTabela;
  }

  
}
