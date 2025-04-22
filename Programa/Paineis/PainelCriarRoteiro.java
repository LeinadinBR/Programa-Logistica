package Programa.Paineis;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelCriarRoteiro extends PainelBase {

  private JPanel insidePanel;
  private JButton bRetornar, bCriarRoteiro, bAdicionarRegiao;
  private JTextField tfDataInicio, tfDataTermino, tfAdicionarRegiao;
  private JComboBox<String> cbSelecionarRegiao;
  private JLabel lbSelecionarRegiao, lbDataInicio, lbDataTermino, lbImage;
  private BufferedImage barraLateral;
  
  public PainelCriarRoteiro(){
    init();

    this.add(insidePanel);
    this.add(bRetornar);

    insidePanel.add(lbSelecionarRegiao);
    this.getFocusList().add(cbSelecionarRegiao);
    insidePanel.add(cbSelecionarRegiao);
    insidePanel.add(lbDataInicio);
    this.getFocusList().add(tfDataInicio);
    insidePanel.add(tfDataInicio);
    insidePanel.add(lbDataTermino);
    this.getFocusList().add(tfDataTermino);
    insidePanel.add(tfDataTermino);
    this.getFocusList().add(tfAdicionarRegiao);
    this.getFocusList().add(bAdicionarRegiao);
    this.getFocusList().add(bCriarRoteiro);
    insidePanel.add(bCriarRoteiro);
    insidePanel.add(lbImage);
    insidePanel.add(tfAdicionarRegiao);
    insidePanel.add(bAdicionarRegiao);
  }

  private void init(){
    this.setBackground(new Color(188, 216, 216));
    this.setLayout(null);
    
    insidePanel = new JPanel();
    insidePanel.setBackground(new Color(230, 247, 247));
    insidePanel.setLayout(null);
    insidePanel.setBounds(150, 10, 600, 420);
    insidePanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));
    

    Font font = new Font("Verdana", Font.PLAIN, 20);

    bRetornar = new JButton("Retornar");
    bRetornar.setIcon(new ImageIcon("Programa/res/iconRetorno.png"));
    bRetornar.setFont(font);
    bRetornar.setFocusable(false);
    bRetornar.setBounds(300, 460, 300, 90);

    bCriarRoteiro = new JButton("Criar Roteiro");
    bCriarRoteiro.setFont(font);
    bCriarRoteiro.setFocusable(true);
    bCriarRoteiro.setBounds(15, 300, 250, 50);

    bAdicionarRegiao = new JButton("Adicionar Região");
    bAdicionarRegiao.setIcon(new ImageIcon("Programa/res/iconAdicionar.png"));
    bAdicionarRegiao.setFont(font);
    bAdicionarRegiao.setFocusable(true);
    bAdicionarRegiao.setBounds(325, 65, 250, 35);

    tfDataInicio = new JTextField();
    tfDataInicio.setFont(font);
    tfDataInicio.setBounds(15, 135, 250, 35);

    tfDataTermino = new JTextField();
    tfDataTermino.setFont(font);
    tfDataTermino.setBounds(15, 220, 250, 35);

    tfAdicionarRegiao = new JTextField();
    tfAdicionarRegiao.setFont(font);
    tfAdicionarRegiao.setBounds(325, 20, 250, 35);


    cbSelecionarRegiao = new JComboBox<>();
    cbSelecionarRegiao.setBounds(15, 50, 250, 35);

    lbSelecionarRegiao = new JLabel("Selecionar Região");
    lbSelecionarRegiao.setFont(font);
    lbSelecionarRegiao.setBounds(15, 10, 250, 30);

    lbDataInicio = new JLabel("Data de Início");
    lbDataInicio.setFont(font);
    lbDataInicio.setBounds(15, 95, 250, 30);

    lbDataTermino = new JLabel("Data de Término");
    lbDataTermino.setFont(font);
    lbDataTermino.setBounds(15, 180, 250, 30);

    try {
      barraLateral = ImageIO.read(new File("Programa/res/barra.png"));
    } 
    catch (IOException e) {
      e.printStackTrace();
    }

    lbImage = new JLabel(new ImageIcon(barraLateral));
    lbImage.setBounds(300, 0, 3, 420);

    this.setFocusList(new ArrayList<>());
  }

  @Override
  public void mudarTamanhoDosComponentes(float width, float height, boolean aumentando) {
    if (aumentando){
      mudarBounds(lbImage, width, height, 3, 420);
      mudarBounds(lbDataTermino, width, height, 250, 30);
      mudarBounds(lbDataInicio, width, height, 250, 30);
      mudarBounds(lbSelecionarRegiao, width, height, 250, 30);
      mudarBounds(cbSelecionarRegiao, width, height, 250, 35);
      mudarBounds(tfAdicionarRegiao, width, height, 250, 35);
      mudarBounds(tfDataTermino, width, height, 250, 35);
      mudarBounds(tfDataInicio, width, height, 250, 35);
      mudarBounds(bAdicionarRegiao, width, height, 250, 35);
      mudarBounds(bCriarRoteiro, width, height, 250, 50);
      mudarBounds(bRetornar, width, height, 300, 90);
      mudarBounds(insidePanel, width, height, 600, 420);
    }
    else {
      lbImage.setBounds(300, 0, 3, 420);
      lbDataTermino.setBounds(15, 180, 250, 30);
      lbDataInicio.setBounds(15, 95, 250, 30);
      lbSelecionarRegiao.setBounds(15, 10, 250, 30);
      cbSelecionarRegiao.setBounds(15, 50, 250, 35);
      tfAdicionarRegiao.setBounds(325, 20, 250, 35);
      tfDataTermino.setBounds(15, 220, 250, 35);
      tfDataInicio.setBounds(15, 135, 250, 35);
      bAdicionarRegiao.setBounds(325, 65, 250, 35);
      bCriarRoteiro.setBounds(15, 300, 250, 50);
      bRetornar.setBounds(300, 460, 300, 90);
      insidePanel.setBounds(150, 10, 600, 420);
    }
  }

  public void atualizarDados(List<String> listaRegioes){
    for (String s: listaRegioes){
      cbSelecionarRegiao.addItem(s);
    }
  }

  //getters e setters
  public JButton getbRetornar() {
    return bRetornar;
  }

  public void setbRetornar(JButton bRetornar) {
    this.bRetornar = bRetornar;
  }

  public JButton getbCriarRoteiro() {
    return bCriarRoteiro;
  }

  public void setbCriarRoteiro(JButton bCriarRoteiro) {
    this.bCriarRoteiro = bCriarRoteiro;
  }

  public JButton getbAdicionarRegiao() {
    return bAdicionarRegiao;
  }

  public void setbAdicionarRegiao(JButton bAdicionarRegiao) {
    this.bAdicionarRegiao = bAdicionarRegiao;
  }

  public JTextField getTfDataInicio() {
    return tfDataInicio;
  }

  public void setTfDataInicio(JTextField tfDataInicio) {
    this.tfDataInicio = tfDataInicio;
  }

  public JTextField getTfDataTermino() {
    return tfDataTermino;
  }

  public void setTfDataTermino(JTextField tfDataTermino) {
    this.tfDataTermino = tfDataTermino;
  }

  public JTextField getTfAdicionarRegiao() {
    return tfAdicionarRegiao;
  }

  public void setTfAdicionarRegiao(JTextField tfAdicionarRegiao) {
    this.tfAdicionarRegiao = tfAdicionarRegiao;
  }

  public JComboBox<String> getCbSelecionarRegiao() {
    return cbSelecionarRegiao;
  }

  public void setCbSelecionarRegiao(JComboBox<String> cbSelecionarRegiao) {
    this.cbSelecionarRegiao = cbSelecionarRegiao;
  }
}
