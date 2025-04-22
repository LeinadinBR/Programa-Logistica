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
import Programa.Pedido;
import Programa.Produto;
import Programa.ProdutoQuantidade;
import Programa.Roteiro;

public class PainelEstoqueXRoteiro extends PainelBase{
  
  private JPanel insidePanel;
  private JButton bEscolherRoteiro, bRetornar, bSubtrairEstoque;
  private JTextField tfRoteiro;
  private JTable tTabela;
  private JScrollPane scrollPane;
  private Estoque estoqueLocal = null;
  private Roteiro roteiroSelecionado = null;
  private ArrayList<ProdutoQuantidade> listaProdutosNoRoteiro;

  private Object[] colunas = new Object[] {"Id", "Produto", "Em Estoque", "Nos Pedidos", "Faltando"};
  private Object[][] dados = null;
  private DefaultTableModel tableModel = new DefaultTableModel(dados, colunas);
  private TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(tableModel);

  public PainelEstoqueXRoteiro(){
    init();

    this.add(insidePanel);
    this.add(bRetornar);
    this.add(bSubtrairEstoque);
    
    insidePanel.add(tfRoteiro);
    insidePanel.add(bEscolherRoteiro);
    insidePanel.add(scrollPane);

    this.getFocusList().add(tfRoteiro);
    this.getFocusList().add(bEscolherRoteiro);
    this.getFocusList().add(bRetornar);
    this.getFocusList().add(bSubtrairEstoque);
  }

  private void init(){
    this.setBackground(new Color(188, 216, 216));
    this.setLayout(null);

    listaProdutosNoRoteiro = new ArrayList<>();

    insidePanel = new JPanel();
    insidePanel.setBackground(new Color(230, 247, 247));
    insidePanel.setLayout(null);
    insidePanel.setBounds(10, 10, 880, 450);
    insidePanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));

    Font font = new Font("Verdana", Font.PLAIN, 20);

    bEscolherRoteiro = new JButton("Escolher Roteiro");
    bEscolherRoteiro.setFocusable(false);
    bEscolherRoteiro.setFont(font);
    bEscolherRoteiro.setBounds(10, 65, 300, 45);

    bRetornar = new JButton("Retornar");
    bRetornar.setIcon(new ImageIcon("Programa/res/iconRetorno.png"));
    bRetornar.setFocusable(false);
    bRetornar.setFont(font);
    bRetornar.setBounds(125, 470, 300, 60);

    bSubtrairEstoque = new JButton("Subtrair Estoque");
    bSubtrairEstoque.setFocusable(false);
    bSubtrairEstoque.setFont(font);
    bSubtrairEstoque.setBounds(450, 470, 300, 60);

    tfRoteiro = new JTextField();
    tfRoteiro.setEditable(false);
    tfRoteiro.setFont(font);
    tfRoteiro.setBounds(10, 10, 300, 40);

    tTabela = new JTable(tableModel);
    tTabela.setRowSorter(rowSorter);
    tTabela.setEnabled(false);

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

  public void atualizarDados(Estoque estoque){
    this.estoqueLocal = estoque;

    tableModel.setDataVector(dados, colunas);
    tTabela.setRowSorter(rowSorter);
  }

  public void atualizarSelecionado(){
    tfRoteiro.setText(roteiroSelecionado.getRegião() + " " + roteiroSelecionado.getDataInicio().getFullData() + " " + roteiroSelecionado.getDataTermino().getFullData());
    while (tableModel.getRowCount() > 0)
      tableModel.removeRow(0);
    listaProdutosNoRoteiro.clear();
    dados = null;
    atualizarTabela();
  }

  private void atualizarTabela(){
    for (Pedido p: roteiroSelecionado.getPedidos()){
      for (ProdutoQuantidade pq: p.getProdutos()){
        if (listaProdutosNoRoteiro.isEmpty()){
          listaProdutosNoRoteiro.add(pq);
        }
        else {
          for (int i=0; i<listaProdutosNoRoteiro.size(); i++){
            if (pq.equals(listaProdutosNoRoteiro.get(i))){
              listaProdutosNoRoteiro.get(i).setQuantidade(pq.getQuantidade() + listaProdutosNoRoteiro.get(i).getQuantidade());
              break;
            }
          }
          listaProdutosNoRoteiro.add(pq);
        }
      }
    }

    dados = new Object[listaProdutosNoRoteiro.size()][5];
    for (int i=0; i<listaProdutosNoRoteiro.size(); i++){
      dados[i][0] = listaProdutosNoRoteiro.get(i).getProduto().getCodigo();
      dados[i][1] = listaProdutosNoRoteiro.get(i).getProduto().getNome();
      dados[i][2] = verificarEstoqueItem(listaProdutosNoRoteiro.get(i).getProduto());
      dados[i][3] = listaProdutosNoRoteiro.get(i).getQuantidade();
      dados[i][4] = calcularFalta((int) dados[i][2], (int) dados[i][3]);
    }

    tableModel.setDataVector(dados, colunas);
    tTabela.setRowSorter(rowSorter);
  }

  private int verificarEstoqueItem(Produto produto){
    for (int i=0; i<estoqueLocal.getProdutos().size(); i++){
      if (produto.getCodigo() == estoqueLocal.getProdutos().get(i).getProduto().getCodigo())
        return estoqueLocal.getProdutos().get(i).getQuantidade();
    }
    return 0;
  }

  private int calcularFalta(int estoque, int roteiro){
    if (estoque - roteiro < 0)
      return -(estoque - roteiro);
    else 
      return 0;
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

  public void setRoteiroSelecionado(Roteiro roteiro){
    this.roteiroSelecionado = roteiro;
  }

  public Roteiro getRoteiroSelecionado(){
    return this.getRoteiroSelecionado();
  }

  public JButton getbSubtrairEstoque() {
    return bSubtrairEstoque;
  }

  public void setbSubtrairEstoque(JButton bSubtrairEstoque) {
    this.bSubtrairEstoque = bSubtrairEstoque;
  }
}
