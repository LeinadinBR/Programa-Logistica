package Programa.Paineis;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Programa.Pedido;

public class PainelListaDoPedido extends PainelBase{
  private JPanel insidePanel;
  private JTable tTabela;
  private JScrollPane scrollPane;
  private JButton bSair;
  private JLabel lValorTotal;

  private Object[] colunas = new Object[] {"Id", "Nome", "Quantidade" , "Preço Unitário", "Preço Total"};
  private Object[][] dados = null;
  private DefaultTableModel tableModel = new DefaultTableModel(dados, colunas);
  
  public PainelListaDoPedido(){
    init();

    insidePanel.add(scrollPane);
    insidePanel.add(lValorTotal);
    insidePanel.add(bSair);

    this.add(insidePanel);
  }

  private void init(){
    this.setBackground(new Color(188, 216, 216));
    this.setLayout(null);

    insidePanel = new JPanel();
    insidePanel.setBounds(10, 10, 365, 545);
    insidePanel.setBackground(new Color(230, 247, 247));
    insidePanel.setLayout(null);
    insidePanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));

    tTabela = new JTable();
    tTabela.setModel(tableModel);
    tTabela.setEnabled(false);

    scrollPane = new JScrollPane();
    scrollPane.setBounds(15, 10, 335, 410);
    scrollPane.getViewport().add(tTabela);
    scrollPane.setBorder(BorderFactory.createLineBorder(Color.black, 2));

    lValorTotal = new JLabel("Valor Total: ");
    lValorTotal.setFont(new Font("Verdana", Font.PLAIN, 20));
    lValorTotal.setBounds(80, 430, 255, 20);

    bSair = new JButton("S a i r");
    bSair.setBounds(65, 470, 255, 30);
    bSair.setFocusable(false);
    bSair.setFont(new Font("Verdana", Font.BOLD, 15));
  }

  public void atualizarDados(Pedido pedido){
    Object o [][] = new Object[pedido.getProdutos().size()][5];
    for (int i=0; i<pedido.getProdutos().size(); i++){
      o[i][0] = pedido.getProdutos().get(i).getProduto().getCodigo();
      o[i][1] = pedido.getProdutos().get(i).getProduto().getNome();
      o[i][2] = pedido.getProdutos().get(i).getQuantidade();
      o[i][3] = pedido.getProdutos().get(i).getProduto().getPrecoDeVenda();
      o[i][4] = (pedido.getProdutos().get(i).getProduto().getPrecoDeVenda() * pedido.getProdutos().get(i).getQuantidade());
    }
    this.dados = o;
    tableModel.setDataVector(dados, colunas);
    this.lValorTotal.setText(("Valor Total: R$" + String.valueOf(pedido.getValorTotal())));
  }

  //getters e setters
  public JTable gettTabela() {
    return tTabela;
  }

  public void settTabela(JTable tTabela) {
    this.tTabela = tTabela;
  }

  public JButton getbSair() {
    return bSair;
  }

  public void setbSair(JButton bSair) {
    this.bSair = bSair;
  }

  public JLabel getlValorTotal() {
    return lValorTotal;
  }

  public void setlValorTotal(JLabel lValorTotal) {
    this.lValorTotal = lValorTotal;
  }  
}
