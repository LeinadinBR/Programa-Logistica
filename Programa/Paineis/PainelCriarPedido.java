package Programa.Paineis;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import Programa.Cliente;
import Programa.Roteiro;
import Programa.ProdutoQuantidade;

public class PainelCriarPedido extends PainelBase {
  
  private JPanel insidePanel;
  private JButton bSelecionarCliente, bAdicionarProduto, bFecharPedido, bRetornar, bSelecionarRoteiro;
  private JTextField tfCliente, tfRoteiro;
  private JFormattedTextField tfData;
  private MaskFormatter mask;
  private JLabel lbData;
  private JTable tTabela;
  private JScrollPane scrollPane;
  private Cliente clienteSelecionado;
  private Roteiro roteiroSelecionado;
  private List<ProdutoQuantidade> listaProdutoQuantidade = new LinkedList<>();

  private String[] colunas = new String[]{"Produto", "Quantidade", "Preço", "Preço Total"};
  private Object[][] dados = null;
  private DefaultTableModel tableModel = new DefaultTableModel(dados, colunas);
  private TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(tableModel);

  public PainelCriarPedido(){
    init();

    this.add(insidePanel);
    this.add(bFecharPedido);
    this.add(bRetornar);

    insidePanel.add(tfCliente);
    this.getFocusList().add(bSelecionarCliente);
    insidePanel.add(bSelecionarCliente);
    insidePanel.add(lbData);
    this.getFocusList().add(tfData);
    insidePanel.add(tfData);
    insidePanel.add(tfRoteiro);
    this.getFocusList().add(bSelecionarRoteiro);
    insidePanel.add(bSelecionarRoteiro);
    this.getFocusList().add(bAdicionarProduto);
    insidePanel.add(bAdicionarProduto);
    insidePanel.add(scrollPane);
  }

  private void init(){
    this.setBackground(new Color(188, 216, 216));
    this.setLayout(null);

    Font font = new Font("Verdana", Font.PLAIN, 25);
    
    insidePanel = new JPanel();
    insidePanel.setBackground(new Color(230, 247, 247));
    insidePanel.setLayout(null);
    insidePanel.setBounds(10, 10, 880, 450);
    insidePanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));

    bSelecionarCliente = new JButton("Selecionar Cliente");
    bSelecionarCliente.setFocusable(true);
    bSelecionarCliente.setFont(font);
    bSelecionarCliente.setBounds(10, 60, 300, 35);

    bSelecionarRoteiro = new JButton("Selecionar Roteiro");
    bSelecionarRoteiro.setFocusable(true);
    bSelecionarRoteiro.setFont(font);
    bSelecionarRoteiro.setBounds(10, 300, 300, 35);

    bAdicionarProduto = new JButton("Adicionar Produto");
    bAdicionarProduto.setIcon(new ImageIcon("Programa/res/iconAdicionar.png"));
    bAdicionarProduto.setFocusable(true);
    bAdicionarProduto.setFont(font);
    bAdicionarProduto.setBounds(10, 370, 300, 50);

    bFecharPedido = new JButton("Fechar Pedido");
    bFecharPedido.setFocusable(false);
    bFecharPedido.setFont(font);
    bFecharPedido.setBounds(120, 470, 300, 60);

    bRetornar = new JButton("Retornar");
    bRetornar.setIcon(new ImageIcon("Programa/res/iconRetorno.png"));
    bRetornar.setFocusable(false);
    bRetornar.setFont(font);
    bRetornar.setBounds(480, 470, 300, 60);

    tfCliente = new JTextField();
    tfCliente.setEditable(false);
    tfCliente.setFont(font);
    tfCliente.setBounds(10, 10, 300, 35);

    try {
      mask = new MaskFormatter("##/##/####");
    } 
    catch (ParseException e) {
      e.printStackTrace();
    }
    
    tfData = new JFormattedTextField(mask);
    tfData.setFont(font);
    tfData.setBounds(10, 180, 300, 35);
    
    tfRoteiro = new JTextField();
    tfRoteiro.setFont(font);
    tfRoteiro.setEditable(false);
    tfRoteiro.setBounds(10, 250, 300, 35);

    lbData = new JLabel("Data de Venda");
    lbData.setFont(font);
    lbData.setBounds(10, 140, 300, 35);

    tTabela = new JTable(tableModel);

    scrollPane = new JScrollPane();
    scrollPane.getViewport().add(tTabela);
    scrollPane.setBorder(BorderFactory.createLineBorder(Color.black, 3));
    scrollPane.setBounds(370, 10, 490, 430);

    this.setFocusList(new ArrayList<>());
  }

  public void atualizarDados(List<ProdutoQuantidade> listaProdutoQuantitade){
    Object o [][] = new Object[listaProdutoQuantitade.size()][4];
    for (int i=0; i<listaProdutoQuantitade.size(); i++){
      o[i][0] = listaProdutoQuantitade.get(i).getProduto().getNome();
      o[i][1] = listaProdutoQuantitade.get(i).getQuantidade();
      o[i][2] = listaProdutoQuantitade.get(i).getProduto().getPrecoDeVenda();
      o[i][3] = listaProdutoQuantitade.get(i).getProduto().getPrecoDeVenda()*listaProdutoQuantitade.get(i).getQuantidade();
    }
    this.dados = o;
    tableModel.setDataVector(dados, colunas);
    tTabela.setRowSorter(rowSorter);
  }

  public void limparTabela(){
    listaProdutoQuantidade.clear();
    this.dados = null;
    tableModel.setDataVector(dados, colunas);
    clienteSelecionado = null;
    roteiroSelecionado = null;
  }

  @Override
  public void mudarTamanhoDosComponentes(float width, float height, boolean aumentando) {
    if(aumentando){
      mudarBounds(scrollPane, width, height, 490, 430);
      mudarBounds(lbData, width, height, 300, 35);
      mudarBounds(tfRoteiro, width, height, 300, 35);
      mudarBounds(tfData, width, height, 300, 35);
      mudarBounds(tfCliente, width, height, 300, 35);
      mudarBounds(bRetornar, width, height, 300, 60);
      mudarBounds(bFecharPedido, width, height, 300, 60);
      mudarBounds(bAdicionarProduto, width, height, 300, 50);
      mudarBounds(bSelecionarRoteiro, width, height, 300, 35);
      mudarBounds(bSelecionarCliente, width, height, 300, 35);
      mudarBounds(insidePanel, width, height, 880, 450);
    }
    else {
      scrollPane.setBounds(370, 10, 490, 430);
      lbData.setBounds(10, 140, 300, 35);
      tfRoteiro.setBounds(10, 250, 300, 35);
      tfData.setBounds(10, 180, 300, 35);
      tfCliente.setBounds(10, 10, 300, 35);
      bRetornar.setBounds(480, 470, 300, 60);
      bFecharPedido.setBounds(120, 470, 300, 60);
      bAdicionarProduto.setBounds(10, 370, 300, 50);
      bSelecionarRoteiro.setBounds(10, 300, 300, 35);
      bSelecionarCliente.setBounds(10, 60, 300, 35);
      insidePanel.setBounds(10, 10, 880, 450);
    }
  }

  //getters e setters
  public JButton getbSelecionarCliente() {
    return bSelecionarCliente;
  }

  public void setbSelecionarCliente(JButton bSelecionarCliente) {
    this.bSelecionarCliente = bSelecionarCliente;
  }

  public JButton getbAdicionarProduto() {
    return bAdicionarProduto;
  }

  public void setbAdicionarProduto(JButton bAdicionarProduto) {
    this.bAdicionarProduto = bAdicionarProduto;
  }

  public JButton getbFecharPedido() {
    return bFecharPedido;
  }

  public void setbFecharPedido(JButton bFecharPedido) {
    this.bFecharPedido = bFecharPedido;
  }

  public JButton getbRetornar() {
    return bRetornar;
  }

  public void setbRetornar(JButton bRetornar) {
    this.bRetornar = bRetornar;
  }

  public JTextField getTfCliente() {
    return tfCliente;
  }

  public void setTfCliente(JTextField tfCliente) {
    this.tfCliente = tfCliente;
  }

  public JFormattedTextField getTfData() {
    return tfData;
  }

  public void setTfData(JFormattedTextField tfData) {
    this.tfData = tfData;
  }

  public JTable gettTabela() {
    return tTabela;
  }

  public void settTabela(JTable tTabela) {
    this.tTabela = tTabela;
  }

  public Cliente getClienteSelecionado() {
    return clienteSelecionado;
  }

  public void setClienteSelecionado(Cliente clienteSelecionado) {
    this.clienteSelecionado = clienteSelecionado;
  }

  public JButton getbSelecionarRoteiro() {
    return bSelecionarRoteiro;
  }

  public void setbSelecionarRoteiro(JButton bSelecionarRoteiro) {
    this.bSelecionarRoteiro = bSelecionarRoteiro;
  }

  public Roteiro getRoteiroSelecionado() {
    return roteiroSelecionado;
  }

  public void setRoteiroSelecionado(Roteiro roteiroSelecionado) {
    this.roteiroSelecionado = roteiroSelecionado;
  }

  public JTextField getTfRoteiro() {
    return tfRoteiro;
  }

  public void setTfRoteiro(JTextField tfRoteiro) {
    this.tfRoteiro = tfRoteiro;
  }

  public List<ProdutoQuantidade> getListaProdutoQuantidade() {
    return listaProdutoQuantidade;
  }

  public void setListaProdutoQuantidade(List<ProdutoQuantidade> listaProdutoQuantidade) {
    this.listaProdutoQuantidade = listaProdutoQuantidade;
  }

  public TableRowSorter<DefaultTableModel> getRowSorter() {
    return rowSorter;
  }

  public void setRowSorter(TableRowSorter<DefaultTableModel> rowSorter) {
    this.rowSorter = rowSorter;
  }  
}
