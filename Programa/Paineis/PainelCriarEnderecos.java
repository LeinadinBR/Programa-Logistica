package Programa.Paineis;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelCriarEnderecos extends PainelBase {
  private JTextField tfrua;
  private JTextField tfbairro;
  private JTextField tfcidade;
  private JTextField tfcep;
  private JTextField tfnum;
  private JTextField tftelefone;
  private JButton bAdicionar;
  private JPanel insidePanel;

  public PainelCriarEnderecos(){
    init();

    this.setLayout(null);
  
    insidePanel.add(tfrua);
    insidePanel.add(tfbairro);
    insidePanel.add(tfcidade);
    insidePanel.add(tfcep);
    insidePanel.add(tfnum);
    insidePanel.add(tftelefone);
    insidePanel.add(bAdicionar);

    this.add(insidePanel);
  }

  private void init(){
    this.setBackground(new Color(188, 216, 216));
    this.setSize(new Dimension(500, 530));
    Font verdana = new Font("Verdana", Font.PLAIN, 25);

    tfrua = new JTextField("Rua");
    tfrua.setFont(verdana);
    tfrua.setBounds(15, 10, 425, 50);

    tfbairro = new JTextField("Bairro");
    tfbairro.setFont(verdana);
    tfbairro.setBounds(15, 70, 425, 50);

    tfcidade = new JTextField("Cidade");
    tfcidade.setFont(verdana);
    tfcidade.setBounds(15, 130, 425, 50);

    tfcep = new JTextField("CEP");
    tfcep.setFont(verdana);
    tfcep.setBounds(15, 190, 425, 50);

    tfnum = new JTextField("Número");
    tfnum.setFont(verdana);
    tfnum.setBounds(15, 250, 425, 50);

    tftelefone = new JTextField("Telefone");
    tftelefone.setFont(verdana);
    tftelefone.setBounds(15, 310, 425, 50);

    bAdicionar = new JButton("Adicionar");
    bAdicionar.setIcon(new ImageIcon("Programa/res/iconAdicionar.png"));
    bAdicionar.setFont(verdana);
    bAdicionar.setBounds(15, 380, 425, 50);
    bAdicionar.setFocusable(false);
    
    insidePanel = new JPanel();
    insidePanel.setLayout(null);
    insidePanel.setBackground(new Color(230,247,247));
    insidePanel.setBounds(10, 10, 460, 480);
    insidePanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));
  }

  //getters e setters
  public JTextField getTfrua() {
    return tfrua;
  }

  public void setTfrua(JTextField tfrua) {
    this.tfrua = tfrua;
  }

  public JTextField getTfbairro() {
    return tfbairro;
  }

  public void setTfbairro(JTextField tfbairro) {
    this.tfbairro = tfbairro;
  }

  public JTextField getTfcidade() {
    return tfcidade;
  }

  public void setTfcidade(JTextField tfcidade) {
    this.tfcidade = tfcidade;
  }

  public JTextField getTfcep() {
    return tfcep;
  }

  public void setTfcep(JTextField tfcep) {
    this.tfcep = tfcep;
  }

  public JTextField getTfnum() {
    return tfnum;
  }

  public void setTfnum(JTextField tfnum) {
    this.tfnum = tfnum;
  }

  public JTextField getTftelefone() {
    return tftelefone;
  }

  public void setTftelefone(JTextField tftelefone) {
    this.tftelefone = tftelefone;
  }

  public JButton getbAdicionar() {
    return bAdicionar;
  }

  public void setbAdicionar(JButton bAdicionar) {
    this.bAdicionar = bAdicionar;
  }
}
