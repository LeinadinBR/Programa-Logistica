package Programa.Paineis;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Programa.Cliente;

public class PainelSelecionarCliente extends PainelBase{
  private JPanel insidePanel;
  private JTable tTabela;
  private JButton bSelecionar;
  private JTextField tfBusca;
  private JScrollPane scrollPane;

  private String[] colunas = new String[] {"Cliente", "Nome Fantasia", "Razão Social"};
  private Object[][] dados = null;
  private DefaultTableModel tableModel = new DefaultTableModel(dados, colunas);
  private TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(tableModel);

  private Color corFiller = new Color(200, 160, 160);

  public PainelSelecionarCliente(){
    init();

    this.setLayout(null);

    insidePanel.add(tfBusca);
    insidePanel.add(bSelecionar);
    insidePanel.add(scrollPane);

    this.add(insidePanel);
  }

  private void init(){
    this.setBackground(new Color(188, 216, 216));
    this.setSize(new Dimension(850, 560));
    Font verdana = new Font("Verdana", Font.PLAIN, 25);
    
    tfBusca = new JTextField("Buscar");
    tfBusca.setFont(verdana);
    tfBusca.setBounds(40, 35, 260, 35);
    tfBusca.setForeground(corFiller);
    fillerText("Buscar", tfBusca);

    bSelecionar = new JButton("Selecionar");
    bSelecionar.setFont(verdana);
    bSelecionar.setBounds(60, 85, 220, 40);
    bSelecionar.setFocusable(false);

    tTabela = new JTable(tableModel){
      @Override
      public boolean isCellEditable(int row, int column){
        return column != 0 && column != 1 && column != 2; 
    }};

    scrollPane = new JScrollPane();
    scrollPane.setBounds(330, 30, 460, 450);
    scrollPane.getViewport().add(tTabela);
    scrollPane.setBorder(BorderFactory.createLineBorder(Color.black, 2));

    insidePanel = new JPanel();
    insidePanel.setBackground(new Color(230,247,247));
    insidePanel.setBounds(10, 10, 810, 500);
    insidePanel.setLayout(null);
    insidePanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));

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

  public void atualizarDados(List<Cliente> listaClientes){
    Object o [][] = new Object[listaClientes.size()][3];
    for (int i=0; i<listaClientes.size(); i++){
      o[i][0] = listaClientes.get(i).getNome();
      o[i][1] = listaClientes.get(i).getNomeFantasia();
      o[i][2] = listaClientes.get(i).getRazaoSocial();
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

  public JButton getbSelecionar() {
    return bSelecionar;
  }

  public void setbSelecionar(JButton bSelecionar) {
    this.bSelecionar = bSelecionar;
  }

  public JTextField getTfBusca() {
    return tfBusca;
  }

  public void setTfBusca(JTextField tfBusca) {
    this.tfBusca = tfBusca;
  }

  public TableRowSorter<DefaultTableModel> getRowSorter() {
    return rowSorter;
  }

  public void setRowSorter(TableRowSorter<DefaultTableModel> rowSorter) {
    this.rowSorter = rowSorter;
  }
}
