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

import Programa.Cliente;

//TODO ver a possibilidade de apagar/editar itens da tabela
//TODO colocar opção na tabela para expandir detalhes do endereço
//TODO ao clicar em uma linha da tabela duas vezes, abre uma tela com todos os detalhes
public class PainelVerClientes extends PainelBase {
  private JPanel insidePanel;
  private JButton bRetornar;
  private JTextField tfPesquisa;
  private JTable tTabela;
  private JScrollPane scrollPane;
  private JComboBox<String> cbComboBox;

  private Object[] colunas = new Object[]{"Nome", "Nome Fantasia", "Razão Social", "CNPJ", "Endereço"};
  private Object[][] dados = null;
  private DefaultTableModel tableModel = new DefaultTableModel(dados, colunas);
  private TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(tableModel);

  public PainelVerClientes(){
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

    String[] comboBoxList = {"Nome do Cliente", "Nome Fantasia", "Razão Social", "CNPJ", "Endereço [CEP]"};

    cbComboBox = new JComboBox<>(comboBoxList);
    cbComboBox.setBounds(400, 430, 150, 50);

    tTabela = new JTable(tableModel);
    
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

  public void atualizarDados(List<Cliente> listaClientes){
    Object o[][] = new Object[listaClientes.size()][5];
    for (int i=0; i<listaClientes.size(); i++){
      o[i][0] = listaClientes.get(i).getNome();
      o[i][1] = listaClientes.get(i).getNomeFantasia();
      o[i][2] = listaClientes.get(i).getRazaoSocial();
      o[i][3] = listaClientes.get(i).getCnpj();
      o[i][4] = listaClientes.get(i).getEndereco().getCep();
    }
    this.dados = o;
    tableModel.setDataVector(dados, colunas);
    tTabela.setRowSorter(rowSorter);
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
