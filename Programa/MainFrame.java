package Programa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowStateListener;
import java.awt.event.WindowEvent;
import java.util.regex.PatternSyntaxException;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Programa.Paineis.*;

public class MainFrame extends JFrame implements WindowStateListener{

  private PainelInicial painelInicial;
  private PainelCadastros painelCadastros;
  private PainelCadastroProdutos painelCadastroProdutos;
  private PainelCadastroFornecedores painelCadastroFornecedores;
  private PainelCadastroClientes painelCadastroClientes;
  private PainelVerProdutos painelVerProdutos;
  private PainelVerClientes painelVerClientes;
  private PainelVerFornecedores painelVerFornecedores;
  private PainelEstoque painelEstoque;
  private PainelPedidos painelPedidos;
  private PainelPedidosIndividuais painelPedidosIndividuais;
  private PainelRoteiro painelRoteiro;
  private PainelCriarRoteiro painelCriarRoteiro;
  private PainelCriarPedido painelCriarPedido;
  private PainelEstoqueXRoteiro painelEstoqueXRoteiro;
  private PainelSelecionarCliente painelSelecionarCliente;
  private PainelSelecionarRoteiro painelSelecionarRoteiro;
  private PainelAdicionarProduto painelAdicionarProduto;
  private PainelEscolherRoteiro painelEscolherRoteiro;
  private PainelListaDoPedido painelListaDoPedido;
  private PainelRoteiroParaIndividual painelRoteiroParaIndividual;

  private ImageIcon imageIcon;
  private JMenuBar barraMenu;
  private JMenu arquivoMenu;
  private JMenuItem salvarMenu, carregarMenu;
  private Controlador controle;
  private static MainFrame self;
  
  public MainFrame(){
    init();

    this.setBackground(Color.red);

    this.setJMenuBar(barraMenu);
    this.setIconImage(imageIcon.getImage());
    this.setTitle("VCA Utilidades");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(new Dimension(920, 620));
    this.setLocationRelativeTo(null);
    this.setFocusable(true);
    
    this.getContentPane().add(painelInicial);
    
    this.setVisible(true);

    buttonMoveAction();
    buttonEventAction();
    menuAction();

    this.addWindowStateListener(this);    
  }

  private void init(){
    self = this;
    controle = new Controlador();

    imageIcon = new ImageIcon("Programa/res/icon.png");

    painelInicial = new PainelInicial();
    painelCadastros = new PainelCadastros();
    painelCadastroProdutos = new PainelCadastroProdutos();
    painelCadastroFornecedores = new PainelCadastroFornecedores();
    painelCadastroClientes = new PainelCadastroClientes();
    painelVerProdutos = new PainelVerProdutos();
    painelVerClientes = new PainelVerClientes();
    painelVerFornecedores = new PainelVerFornecedores();
    painelEstoque = new PainelEstoque();
    painelPedidos = new PainelPedidos();
    painelPedidosIndividuais = new PainelPedidosIndividuais();
    painelRoteiro = new PainelRoteiro();
    painelCriarRoteiro = new PainelCriarRoteiro();
    painelCriarPedido = new PainelCriarPedido();
    painelEstoqueXRoteiro = new PainelEstoqueXRoteiro();
    painelSelecionarCliente = new PainelSelecionarCliente();
    painelSelecionarRoteiro = new PainelSelecionarRoteiro();
    painelAdicionarProduto = new PainelAdicionarProduto();
    painelEscolherRoteiro = new PainelEscolherRoteiro();
    painelRoteiroParaIndividual = new PainelRoteiroParaIndividual();
    painelListaDoPedido = new PainelListaDoPedido();

    barraMenu = new JMenuBar();
    barraMenu.setBackground(new Color(30, 90, 110));
    barraMenu.setForeground(Color.white);
    
    salvarMenu = new JMenuItem("Salvar");
    salvarMenu.setMnemonic(KeyEvent.VK_S);
    salvarMenu.setBackground(new Color(30, 90, 110));
    salvarMenu.setForeground(Color.white);

    carregarMenu = new JMenuItem("Carregar");
    carregarMenu.setMnemonic(KeyEvent.VK_C);
    carregarMenu.setBackground(new Color(30, 90, 110));
    carregarMenu.setForeground(Color.white);

    arquivoMenu = new JMenu("Arquivo");
    arquivoMenu.add(salvarMenu);
    arquivoMenu.add(carregarMenu);
    arquivoMenu.setBackground(new Color(30, 90, 110));
    arquivoMenu.setForeground(Color.white);
    arquivoMenu.setMnemonic(KeyEvent.VK_A);

    barraMenu.add(arquivoMenu);

  }

  private void buttonMoveAction(){
    //----------------------mudanca de paginas------------------------------------//
    painelInicial.getbCadastros().addActionListener(e -> {
      mudarPainel(painelCadastros, "Cadastros");
    });

    painelInicial.getbEstoque().addActionListener(e ->{
      mudarPainel(painelEstoque, "Estoque");
    });

    painelInicial.getbPedidos().addActionListener(e ->{
      mudarPainel(painelPedidos, "Pedidos");
    });

    painelCadastros.getbRetornar().addActionListener(e -> {
      mudarPainel(painelInicial, "VCA Utilidades");
    });

    painelCadastros.getbCadastroProdutos().addActionListener(e -> {
      mudarPainel(painelCadastroProdutos, "Cadastrar Produtos");
    });

    painelCadastros.getbCadastroFornecedores().addActionListener(e -> {
      mudarPainel(painelCadastroFornecedores, "Cadastrar Fornecedores");
    });

    painelCadastros.getbCadastroClientes().addActionListener(e -> {
      mudarPainel(painelCadastroClientes, "Cadastrar Clientes");
    });

    painelCadastros.getbVerProdutos().addActionListener(e -> {
      mudarPainel(painelVerProdutos, "Ver Produtos");
    });

    painelCadastros.getbVerClientes().addActionListener(e -> {
      mudarPainel(painelVerClientes, "Ver Clientes");
    });

    painelCadastros.getbVerFornecedores().addActionListener(e -> {
      mudarPainel(painelVerFornecedores, "Ver Fornecedores");
    });

    painelCadastroProdutos.getbRetornar().addActionListener(e -> {
      mudarPainel(painelCadastros, "Cadastros");
    });

    painelCadastroFornecedores.getbRetornar().addActionListener(e -> {
      mudarPainel(painelCadastros, "Cadastros");
    });

    painelCadastroClientes.getbRetornar().addActionListener(e -> {
      mudarPainel(painelCadastros, "Cadastros");
    });

    painelVerProdutos.getbRetornar().addActionListener(e ->{
      mudarPainel(painelCadastros, "Cadastros");
    });

    painelVerClientes.getbRetornar().addActionListener(e ->{
      mudarPainel(painelCadastros, "Cadastros");
    });

    painelVerFornecedores.getbRetornar().addActionListener(e ->{
      mudarPainel(painelCadastros, "Cadastros");
    });

    painelEstoque.getbRetornar().addActionListener(e -> {
      mudarPainel(painelInicial, "VCA Utilidades");
    });

    painelPedidos.getbRetornar().addActionListener(e -> {
      mudarPainel(painelInicial, "VCA Utilidades");
    });

    painelPedidos.getbPedidosIndividuais().addActionListener(e -> {
      mudarPainel(painelPedidosIndividuais, "Pedidos Individuais");
    });

    painelPedidos.getbPedidosRoteiro().addActionListener(e -> {
      mudarPainel(painelRoteiro, "Pedidos por Roteiro");
    });

    painelPedidos.getbCriarRoteiro().addActionListener(e -> {
      mudarPainel(painelCriarRoteiro, "Criar Roteiro");
    });

    painelPedidos.getbCriarPedido().addActionListener(e -> {
      mudarPainel(painelCriarPedido, "Criar Pedido");
    });

    painelPedidos.getbEstoqueXRoteiro().addActionListener(e -> {
      mudarPainel(painelEstoqueXRoteiro, "Relação Estoque - Roteiro");
    });

    painelPedidosIndividuais.getbRetornar().addActionListener(e -> {
      mudarPainel(painelPedidos, "Pedidos");
    });

    painelRoteiro.getbRetornar().addActionListener(e -> {
      mudarPainel(painelPedidos, "Pedidos");
    });

    painelCriarRoteiro.getbRetornar().addActionListener(e -> {
      mudarPainel(painelPedidos, "Pedidos");
    });

    painelCriarPedido.getbRetornar().addActionListener(e -> {
      mudarPainel(painelPedidos, "Pedidos");
    });

    painelEstoqueXRoteiro.getbRetornar().addActionListener(e -> {
      mudarPainel(painelPedidos, "Pedidos");
    });
    //----------------------------------------------------------------------------//
  }

  private void mudarPainel(PainelBase painelDestino, String titulo){
    this.getContentPane().removeAll();
    this.getContentPane().add(painelDestino);
    this.setTitle(titulo);
    atualizarOrdemDeFoco(painelDestino);
    this.getContentPane().revalidate();
    this.getContentPane().repaint();
  }

  private void menuAction(){
    salvarMenu.addActionListener(e -> {
      controle.saveDataBase();
    });

    carregarMenu.addActionListener(e -> {
      controle.loadDataBase();

      atualizarTabelasProduto();
      atualizarTabelasEndereco();
      atualizarTabelasFornecedor();
      atualizarTabelasClientes();
      atualizarTabelasPedidos();
      atualizarTabelasRoteiro();
      atualizarTabelasRegioes();
      atualizarTabelasEstoqueXRoteiro();
      atualizarNumPermanentes();
    });
  }

  @SuppressWarnings("static-access")
  private void buttonEventAction(){
    //Cadastrar Produtos----------------------------------------------
    painelCadastroProdutos.getbMaisID().addActionListener(e -> {
      if (painelCadastroProdutos.getTfId().getText() == null || painelCadastroProdutos.getTfId().getText() == ""){
        painelCadastroProdutos.getTfId().setText("1");
      }
      else 
      try {
        painelCadastroProdutos.getTfId().setText(String.valueOf(Integer.parseInt(getSubArray(painelCadastroProdutos.getTfId().getText()))+1));
      }
      catch(Exception ex){
        painelCadastroProdutos.getTfId().setText("1");
      }
    });

    painelCadastroProdutos.getbMenosId().addActionListener(e -> {
      if (painelCadastroProdutos.getTfId().getText() != null || painelCadastroProdutos.getTfId().getText() != ""){
        try {
          painelCadastroProdutos.getTfId().setText(String.valueOf(Integer.parseInt(getSubArray(painelCadastroProdutos.getTfId().getText()))-1));
        }
        catch (Exception ex){
          painelCadastroProdutos.getTfId().setText("1");
        }
      }
    });
   
    painelCadastroProdutos.getbAdicionar().addActionListener(e -> {
      //criar o produto e adicionar na DB
      PainelCadastroProdutos cp = painelCadastroProdutos;
      Produto p = new Produto();

      boolean flag = false;
      try {
        if (cp.getTfId().getText() != null && !cp.getTfId().getText().equals(""))
          p.setCodigo(Integer.parseInt(cp.getTfId().getText()));
        else flag = true;
        if (cp.getTfNome().getText() != null && !cp.getTfNome().getText().equals(""))
          p.setNome(cp.getTfNome().getText());
        else flag = true;
        if (cp.getTfPrecoCompra().getText() != null && !cp.getTfPrecoCompra().getText().equals(""))
          p.setPrecoTotal(Double.parseDouble(cp.getTfPrecoCompra().getText()));
        else flag = true;
        if (cp.getTfPrecoVenda().getText() != null && !cp.getTfPrecoVenda().getText().equals(""))
          p.setPrecoDeVenda(Double.parseDouble(cp.getTfPrecoVenda().getText()));
        else flag = true;
        /*if (cp.getTfDataDeValidade().getText() != null && !cp.getTfDataDeValidade().getText().equals("Data de Validade"))
          p.setDataDeValidade(new Data(cp.getTfDataDeValidade().getText()));*/
        if (procurarFornecedor(cp.getTfFornecedor().getText()))
          p.setFornecedor(controle.getFornecedor(cp.getTfFornecedor().getText()));
        else flag = true;
      }
      catch (NumberFormatException ex){
        JOptionPane.showMessageDialog(this, "Texto no lugar de número", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
      }
      
      if (flag){
        JOptionPane.showMessageDialog(this, "Dados Inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
      }

      if (p.getFornecedor() != null){
        if (p.getFornecedor().getDesconto() != 0f)
          p.setPrecoComDesconto(Math.floor((p.getPrecoTotal()*(1-(p.getFornecedor().getDesconto())/100))*100)/100);
        else 
          p.setPrecoComDesconto(p.getPrecoTotal());
        p.setPorcentagemLucro(100 - calcularPorcentagemLucro(p.getPrecoComDesconto(), p.getPrecoDeVenda()));
        p.setLucroIndividualBruto(p.getPrecoDeVenda()-p.getPrecoComDesconto());
      }
      
      controle.adicionarProduto(p);
      controle.adicionarProdutoNoEstoque(new ProdutoQuantidade(p, 0)); 
      atualizarTabelasProduto();
      cp.getTfNome().setText("Nome");
      cp.getTfNome().setForeground(cp.getCorFiller());
      
      cp.getTfId().setText(String.valueOf(Integer.parseInt(cp.getTfId().getText()) + 1));
      controle.getListaNumPermanentes().set(0, Integer.parseInt(cp.getTfId().getText()));

      cp.getTfFornecedor().setText("Fornecedor");
      cp.getTfPrecoCompra().setText("Preço de Compra");
      cp.getTfPrecoCompra().setForeground(cp.getCorFiller());
      cp.getTfPrecoVenda().setText("Preço de Venda");
      cp.getTfPrecoVenda().setForeground(cp.getCorFiller());
      //cp.getTfDataDeValidade().setText("Data de Validade");
      //cp.getTfDataDeValidade().setForeground(cp.getCorFiller());
    });
    
    painelCadastroProdutos.gettTabela().addMouseListener(new MouseListener() {

      @Override
      public void mouseClicked(MouseEvent e) {
        try {
          int lin = painelCadastroProdutos.gettTabela().rowAtPoint(e.getPoint());
          String s = (String) painelCadastroProdutos.gettTabela().getModel().getValueAt(lin, 0);
          painelCadastroProdutos.getTfFornecedor().setText(s);
        }
        catch (IndexOutOfBoundsException ex1){}
        
      }

      @Override
      public void mousePressed(MouseEvent e) {
      }

      @Override
      public void mouseReleased(MouseEvent e) {
      }

      @Override
      public void mouseEntered(MouseEvent e) {
      }

      @Override
      public void mouseExited(MouseEvent e) {
      }
    });
    //-----------------------------------------------------------------


    //Cadastrar Clientes-----------------------------------------------
    painelCadastroClientes.getbEndereco().addActionListener(e -> {
      PainelCriarEnderecos painelEnderecos = new PainelCriarEnderecos();
      JFrame frameSecundario = new JFrame();
      frameSecundario.setSize(500, 530);
      frameSecundario.getContentPane().add(painelEnderecos);
      frameSecundario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frameSecundario.setLocationRelativeTo(this);
      frameSecundario.setTitle("Adicinar Endereço");
      frameSecundario.setVisible(true);

      painelEnderecos.getbAdicionar().addActionListener(e1 -> {
        Endereco endereco = new Endereco();
        boolean flag = false;
        PainelCriarEnderecos pe = painelEnderecos;

        try {
          if (pe.getTfrua().getText() != null && !pe.getTfrua().getText().equals(""))
            endereco.setRua(pe.getTfrua().getText());
          else flag = true;
          if (pe.getTfbairro().getText() != null && !pe.getTfbairro().getText().equals(""))
            endereco.setBairro(pe.getTfbairro().getText());
          else flag = true;
          if (pe.getTfcidade().getText() != null && !pe.getTfcidade().getText().equals(""))
            endereco.setCidade(pe.getTfcidade().getText());
          else flag = true;
          if (pe.getTfcep().getText() != null && !pe.getTfcep().getText().equals(""))
            endereco.setCep(pe.getTfcep().getText());
          else flag = true;
          if (pe.getTfnum().getText() != null && !pe.getTfnum().getText().equals(""))
            endereco.setNum(Integer.parseInt(pe.getTfnum().getText()));
          else flag = true;
          if (pe.getTftelefone().getText() != null && !pe.getTftelefone().getText().equals(""))
            endereco.setTelefone(pe.getTftelefone().getText());
          else flag = true;
        }
        catch (NumberFormatException ex){
          JOptionPane.showMessageDialog(this, "Formato inválido", "Erro", JOptionPane.ERROR_MESSAGE); 
        }

        if (flag){}
          //Todo optionpane

        controle.adicionarEndereco(endereco);
        atualizarTabelasEndereco();
        frameSecundario.dispose();
      });
    });

    painelCadastroClientes.getbEndereco().addKeyListener(new KeyListener() {

      @Override
      public void keyTyped(KeyEvent e) {
      }

      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
          PainelCriarEnderecos painelEnderecos = new PainelCriarEnderecos();
          JFrame frameSecundario = new JFrame();
          frameSecundario.setSize(500, 530);
          frameSecundario.getContentPane().add(painelEnderecos);
          frameSecundario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          frameSecundario.setLocationRelativeTo(null);
          frameSecundario.setTitle("Adicinar Endereço");
          frameSecundario.setVisible(true);

          painelEnderecos.getbAdicionar().addActionListener(e1 -> {
            Endereco endereco = new Endereco();
            boolean flag = false;
            PainelCriarEnderecos pe = painelEnderecos;

            try {
              if (pe.getTfrua().getText() != null && !pe.getTfrua().getText().equals(""))
                endereco.setRua(pe.getTfrua().getText());
              else flag = true;
              if (pe.getTfbairro().getText() != null && !pe.getTfbairro().getText().equals(""))
                endereco.setBairro(pe.getTfbairro().getText());
              else flag = true;
              if (pe.getTfcidade().getText() != null && !pe.getTfcidade().getText().equals(""))
                endereco.setCidade(pe.getTfcidade().getText());
              else flag = true;
              if (pe.getTfcep().getText() != null && !pe.getTfcep().getText().equals(""))
                endereco.setCep(pe.getTfcep().getText());
              else flag = true;
              if (pe.getTfnum().getText() != null && !pe.getTfnum().getText().equals(""))
                endereco.setNum(Integer.parseInt(pe.getTfnum().getText()));
              else flag = true;
              if (pe.getTftelefone().getText() != null && !pe.getTftelefone().getText().equals(""))
                endereco.setTelefone(pe.getTftelefone().getText());
              else flag = true;
            }
            catch (NumberFormatException ex){
              JOptionPane.showMessageDialog(MainFrame.self, "Formato incorretp", "Erro", JOptionPane.ERROR_MESSAGE);
            }

            if (flag){}
              //Todo optionpane

            controle.adicionarEndereco(endereco);
            atualizarTabelasEndereco();
            frameSecundario.dispose();
          });
        }
      }

      @Override
      public void keyReleased(KeyEvent e) {
      }
      
    });

    painelCadastroClientes.getbAdicionar().addActionListener(e -> {
      PainelCadastroClientes pc = painelCadastroClientes;
      Cliente c = new Cliente();
      boolean flag = false;

      try {
        if (pc.getTfNomeCliente().getText() != null && !pc.getTfNomeCliente().getText().equals(""))
          c.setNome(pc.getTfNomeCliente().getText());
        else flag = true;
        if (pc.getTfNomeFantasia().getText() != null && !pc.getTfNomeFantasia().getText().equals(""))
          c.setNomeFantasia(pc.getTfNomeFantasia().getText());
        else flag = true;
        if (pc.getTfRazaoSocial().getText() != null && !pc.getTfRazaoSocial().getText().equals(""))
          c.setRazaoSocial(pc.getTfRazaoSocial().getText());
        else flag = true;
        if (pc.getTfCnpj().getText() != null && !pc.getTfCnpj().getText().equals(""))
          c.setCnpj(pc.getTfCnpj().getText());
        else flag = true;
        if (pc.getTfEndereco().getText() != null && !pc.getTfEndereco().getText().equals(""))
          c.setEndereco(getEnderecoPorNome(pc.getTfEndereco().getText()));
        else flag = true;
      }
      catch (NumberFormatException ex){
        JOptionPane.showMessageDialog(this, "Texto no lugar de número", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
      }

      if (flag){
        JOptionPane.showMessageDialog(this, "Dados Inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
      }

      if (c.getEndereco() == null){
        JOptionPane.showMessageDialog(this, "Endereço Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
      }
      else {
        controle.adicionarCliente(c);
        atualizarTabelasClientes();
        pc.getTfNomeCliente().setText("Nome do Cliente");
        pc.getTfNomeCliente().setForeground(pc.getCorFiller());
        pc.getTfNomeFantasia().setText("Nome Fantasia");
        pc.getTfNomeFantasia().setForeground(pc.getCorFiller());
        pc.getTfRazaoSocial().setText("Razão Social");
        pc.getTfRazaoSocial().setForeground(pc.getCorFiller());
        pc.getTfCnpj().setText("");
        pc.getTfEndereco().setText("Endereço");
      }
    });

    painelCadastroClientes.gettTabela().addMouseListener(new MouseListener() {

      @Override
      public void mouseClicked(MouseEvent e) {
        try {
          int lin = painelCadastroClientes.gettTabela().rowAtPoint(e.getPoint());
          String s = (String) painelCadastroClientes.gettTabela().getModel().getValueAt(lin, 3);
          painelCadastroClientes.getTfEndereco().setText(s);
        }
        catch (IndexOutOfBoundsException ex){}
        
      }

      @Override
      public void mousePressed(MouseEvent e) {
      }

      @Override
      public void mouseReleased(MouseEvent e) {
      }

      @Override
      public void mouseEntered(MouseEvent e) {
      }

      @Override
      public void mouseExited(MouseEvent e) {
      }
      
    });

    //----------------------------------------------------------------
   

    //Cadastrar Fornecedores------------------------------------------

    painelCadastroFornecedores.getbEndereco().addActionListener(e -> {
      PainelCriarEnderecos painelEnderecos = new PainelCriarEnderecos();
      JFrame frameSecundario = new JFrame();
      frameSecundario.setSize(500, 530);
      frameSecundario.getContentPane().add(painelEnderecos);
      frameSecundario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frameSecundario.setLocationRelativeTo(this);
      frameSecundario.setTitle("Adicinar Endereço");
      frameSecundario.setVisible(true);

      painelEnderecos.getbAdicionar().addActionListener(e1 -> {
        Endereco endereco = new Endereco();
        boolean flag = false;
        PainelCriarEnderecos pe = painelEnderecos;

        try {
          if (pe.getTfrua().getText() != null && !pe.getTfrua().getText().equals(""))
            endereco.setRua(pe.getTfrua().getText());
          else flag = true;
          if (pe.getTfbairro().getText() != null && !pe.getTfbairro().getText().equals(""))
            endereco.setBairro(pe.getTfbairro().getText());
          else flag = true;
          if (pe.getTfcidade().getText() != null && !pe.getTfcidade().getText().equals(""))
            endereco.setCidade(pe.getTfcidade().getText());
          else flag = true;
          if (pe.getTfcep().getText() != null && !pe.getTfcep().getText().equals(""))
            endereco.setCep(pe.getTfcep().getText());
          else flag = true;
          if (pe.getTfnum().getText() != null && !pe.getTfnum().getText().equals(""))
            endereco.setNum(Integer.parseInt(pe.getTfnum().getText()));
          else flag = true;
          if (pe.getTftelefone().getText() != null && !pe.getTftelefone().getText().equals(""))
            endereco.setTelefone(pe.getTftelefone().getText());
          else flag = true;
        }
        catch (NumberFormatException ex){
          JOptionPane.showMessageDialog(this, "Formato Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        if (flag){}
          //Todo optionpane

        controle.adicionarEndereco(endereco);
        atualizarTabelasEndereco();
        frameSecundario.dispose();
      });
    });

    painelCadastroFornecedores.getbEndereco().addKeyListener(new KeyListener(){

      @Override
      public void keyTyped(KeyEvent e) {
      }

      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == (KeyEvent.VK_ENTER)){
          PainelCriarEnderecos painelEnderecos = new PainelCriarEnderecos();
          JFrame frameSecundario = new JFrame();
          frameSecundario.setSize(500, 530);
          frameSecundario.getContentPane().add(painelEnderecos);
          frameSecundario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          frameSecundario.setLocationRelativeTo(null);
          frameSecundario.setTitle("Adicinar Endereço");
          frameSecundario.setVisible(true);

          painelEnderecos.getbAdicionar().addActionListener(e1 -> {
            Endereco endereco = new Endereco();
            boolean flag = false;
            PainelCriarEnderecos pe = painelEnderecos;

            try {
              if (pe.getTfrua().getText() != null && !pe.getTfrua().getText().equals(""))
                endereco.setRua(pe.getTfrua().getText());
              else flag = true;
              if (pe.getTfbairro().getText() != null && !pe.getTfbairro().getText().equals(""))
                endereco.setBairro(pe.getTfbairro().getText());
              else flag = true;
              if (pe.getTfcidade().getText() != null && !pe.getTfcidade().getText().equals(""))
                endereco.setCidade(pe.getTfcidade().getText());
              else flag = true;
              if (pe.getTfcep().getText() != null && !pe.getTfcep().getText().equals(""))
                endereco.setCep(pe.getTfcep().getText());
              else flag = true;
              if (pe.getTfnum().getText() != null && !pe.getTfnum().getText().equals(""))
                endereco.setNum(Integer.parseInt(pe.getTfnum().getText()));
              else flag = true;
              if (pe.getTftelefone().getText() != null && !pe.getTftelefone().getText().equals(""))
                endereco.setTelefone(pe.getTftelefone().getText());
              else flag = true;
            }
            catch (NumberFormatException ex){
              JOptionPane.showMessageDialog(MainFrame.self, "Formato Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
            }

            if (flag){}
              //Todo optionpane

            controle.adicionarEndereco(endereco);
            atualizarTabelasEndereco();
            frameSecundario.dispose();
          });
        }
      }

      @Override
      public void keyReleased(KeyEvent e) {
      }

    });

    painelCadastroFornecedores.gettTabela().addMouseListener(new MouseListener() {

      @Override
      public void mouseClicked(MouseEvent e) {
        try {
          int lin = painelCadastroFornecedores.gettTabela().rowAtPoint(e.getPoint());
          String s = (String) painelCadastroFornecedores.gettTabela().getModel().getValueAt(lin, 3);
          painelCadastroFornecedores.getTfEndereco().setText(s);
        }
        catch (IndexOutOfBoundsException ex){} 
        
      }

      @Override
      public void mousePressed(MouseEvent e) {
      }

      @Override
      public void mouseReleased(MouseEvent e) {
      }

      @Override
      public void mouseEntered(MouseEvent e) {
      }

      @Override
      public void mouseExited(MouseEvent e) {
      }
    });;

    painelCadastroFornecedores.getbAdicionar().addActionListener(e -> {
      PainelCadastroFornecedores cf = painelCadastroFornecedores;
      Fornecedor f = new Fornecedor();
      boolean flag = false;

      try {
        if (cf.getTfNomeFantasia().getText() != null && !cf.getTfNomeFantasia().getText().equals(""))
          f.setNomeFantasia(cf.getTfNomeFantasia().getText());
        else flag = true;
        if (cf.getTfRazaoSocial().getText() != null && !cf.getTfRazaoSocial().getText().equals(""))
          f.setRazaoSocial(cf.getTfRazaoSocial().getText());
        else flag = true;
        if (cf.getTfCnpj().getText() != null && !cf.getTfCnpj().getText().equals(""))
          f.setCnpj(cf.getTfCnpj().getText());
        else flag = true;
        if (cf.getTfEndereco().getText() != null && !cf.getTfEndereco().getText().equals(""))
          f.setEndereco(getEnderecoPorNome(cf.getTfEndereco().getText()));
        else flag = true;
        if (cf.getTfDesconto().getText() != null && !cf.getTfDesconto().getText().equals("")){
          if (cf.getTfDesconto().getText().equals("Desconto"))
            f.setDesconto(0f);
          else
            f.setDesconto(Float.parseFloat(cf.getTfDesconto().getText()));
        }
        else flag = true;
      }
      catch (NumberFormatException ex){
        JOptionPane.showMessageDialog(this, "Texto no lugar de número", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
      }

      if (flag){
        JOptionPane.showMessageDialog(this, "Dados Inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
      }

      if (f.getEndereco() == null){
        JOptionPane.showMessageDialog(this, "Endereço Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
      }
      else {
        controle.adicionarFornecedor(f);
        atualizarTabelasFornecedor();
        cf.getTfNomeFantasia().setText("Nome Fantasia");
        cf.getTfNomeFantasia().setForeground(cf.getCorFiller());
        cf.getTfRazaoSocial().setText("Razão Social");
        cf.getTfRazaoSocial().setForeground(cf.getCorFiller());
        cf.getTfCnpj().setText("");
        cf.getTfEndereco().setText("Endereço");
        cf.getTfDesconto().setText("Desconto");
        cf.getTfDesconto().setForeground(cf.getCorFiller());
      }
    });

    //----------------------------------------------------------------
  
    
    //Ver Produtos----------------------------------------------------
    painelVerProdutos.getTfPesquisa().getDocument().addDocumentListener(new DocumentListener(){

      @Override
      public void insertUpdate(DocumentEvent e) {
        onChange();
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        onChange();
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
        onChange();
      }

      public void onChange(){
        String s = painelVerProdutos.getTfPesquisa().getText();
        if (s.length() == 0)
          painelVerProdutos.getRowSorter().setRowFilter(null);
        else {
          try {
            painelVerProdutos.getRowSorter().setRowFilter(RowFilter.regexFilter("^(?i)" + s, painelVerProdutos.getCbComboBox().getSelectedIndex()));
          }
          catch(PatternSyntaxException ex){
          }
        }
      }

    });

    painelVerProdutos.gettTabela().getModel().addTableModelListener(new TableModelListener() {

      @Override
      public void tableChanged(TableModelEvent e) {
        // Ignora eventos causados por atualizações programáticas
        if (e.getFirstRow() == TableModelEvent.HEADER_ROW) {
          return;
        }

        try {
          int lin = painelVerProdutos.gettTabela().getSelectedRow();
          int col = painelVerProdutos.gettTabela().getSelectedColumn();
          Object obj = painelVerProdutos.gettTabela().getModel().getValueAt(lin, col);

          if (lin != -1 && col != -1){
            
            int id = Integer.parseInt(String.valueOf(painelVerProdutos.gettTabela().getValueAt(lin, 0)));
            atualizarValorBD(id, obj, col, 1);
          }
          
        }
        catch(Exception ex){
        }
      }
      
    });
    //----------------------------------------------------------------
  

    //Ver Clientes----------------------------------------------------
    painelVerClientes.getTfPesquisa().getDocument().addDocumentListener(new DocumentListener(){

      @Override
      public void insertUpdate(DocumentEvent e) {
        onChange();
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        onChange();
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
        onChange();
      }

      public void onChange(){
        String s = painelVerClientes.getTfPesquisa().getText();
        if (s.length() == 0)
          painelVerClientes.getRowSorter().setRowFilter(null);
        else {
          try {
            painelVerClientes.getRowSorter().setRowFilter(RowFilter.regexFilter("^(?i)" + s, painelVerClientes.getCbComboBox().getSelectedIndex()));
          }
          catch(PatternSyntaxException ex){
          }
        }
      }

    });
    //----------------------------------------------------------------
  

    //Ver Fornecedores------------------------------------------------
    painelVerFornecedores.getTfPesquisa().getDocument().addDocumentListener(new DocumentListener(){

      @Override
      public void insertUpdate(DocumentEvent e) {
        onChage();
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        onChage();
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
        onChage();
      }

      public void onChage(){
        String s = painelVerFornecedores.getTfPesquisa().getText();
        if (s.length() == 0)
          painelVerFornecedores.getRowSorter().setRowFilter(null);
        else {
          try {
            painelVerFornecedores.getRowSorter().setRowFilter(RowFilter.regexFilter("^(?i)" + s, painelVerFornecedores.getCbComboBox().getSelectedIndex()));
          }
          catch(PatternSyntaxException ex){
          }
        }
      }

    });
    //----------------------------------------------------------------
  

    //Estoque---------------------------------------------------------
    painelEstoque.getTfPesquisa().getDocument().addDocumentListener(new DocumentListener(){

      @Override
      public void insertUpdate(DocumentEvent e) {
        onChage();
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        onChage();
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
        onChage();
      }

      public void onChage(){
        String s = painelEstoque.getTfPesquisa().getText();
        if (s.length() == 0)
          painelEstoque.getRowSorter().setRowFilter(null);
        else {
          try {
            painelEstoque.getRowSorter().setRowFilter(RowFilter.regexFilter("^(?i)" + s, painelEstoque.getCbClassificacao().getSelectedIndex()));
          }
          catch(PatternSyntaxException ex){
          }
        }
      }

    });

    painelEstoque.gettTabela().getModel().addTableModelListener(new TableModelListener(){

      @Override
      public void tableChanged(TableModelEvent e) {
        // Ignora eventos causados por atualizações programáticas
        if (e.getFirstRow() == TableModelEvent.HEADER_ROW) {
          return;
        }

        try {
          int lin = painelEstoque.gettTabela().getSelectedRow();
          int col = painelEstoque.gettTabela().getSelectedColumn();
          Object obj = painelEstoque.gettTabela().getModel().getValueAt(lin, col);

          if (lin != -1 && col != -1){
            int id = Integer.parseInt(String.valueOf(painelEstoque.gettTabela().getValueAt(lin, 0)));
            atualizarValorBD(id, obj, col, 0);
          }
          
        }
        catch(Exception ex){
        }
      }
      
    });
    //----------------------------------------------------------------
  

    //Pedidos Individ. (01)-------------------------------------------
    painelPedidosIndividuais.getTfPesquisa().getDocument().addDocumentListener(new DocumentListener(){

      @Override
      public void insertUpdate(DocumentEvent e) {
        onChange();
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        onChange();
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
        onChange();
      }

      public void onChange(){
        String s = painelPedidosIndividuais.getTfPesquisa().getText();
        if (s.length() == 0)
          painelPedidosIndividuais.getRowSorter().setRowFilter(null);
        else {
          try {
            painelPedidosIndividuais.getRowSorter().setRowFilter(RowFilter.regexFilter("^(?i)" + s, painelPedidosIndividuais.getCbPesquisa().getSelectedIndex()));
          }
          catch(PatternSyntaxException ex){
          }
        }
      }
    });
    
    painelPedidosIndividuais.gettTabela().addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() >= 2){
          try {
          
            int lin = painelPedidosIndividuais.gettTabela().rowAtPoint(e.getPoint());
            int numPedido = Integer.parseInt(String.valueOf((painelPedidosIndividuais.gettTabela().getModel().getValueAt(lin, 0))));
            String roteiro = (String) painelPedidosIndividuais.gettTabela().getModel().getValueAt(lin, 1);
            
            Pedido p = validarPedido(numPedido, roteiro);
            JFrame frameSecundario = new JFrame(("Pedido " + numPedido));
            frameSecundario.setSize(400, 600);
            frameSecundario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frameSecundario.setIconImage(imageIcon.getImage());
            frameSecundario.setResizable(false);
            frameSecundario.getContentPane().add(painelListaDoPedido);
            frameSecundario.setLocationRelativeTo(MainFrame.self);
            frameSecundario.setVisible(true);
            
            painelListaDoPedido.atualizarDados(p);
            painelListaDoPedido.getbSair().addActionListener(e1 -> {
              frameSecundario.dispose();
            });

          }
          catch (IndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(MainFrame.self, "Erro", "Erro", JOptionPane.ERROR_MESSAGE); 
          }          
          catch (ClassCastException ex){
            JOptionPane.showMessageDialog(MainFrame.self, "Erro", "Erro", JOptionPane.ERROR_MESSAGE); 
          }
        }
      }

      @Override
      public void mousePressed(MouseEvent e) {
      }

      @Override
      public void mouseReleased(MouseEvent e) {
      }

      @Override
      public void mouseEntered(MouseEvent e) {
      }

      @Override
      public void mouseExited(MouseEvent e) {
      }
      
    });
    //----------------------------------------------------------------


    //Roteiro (para pedidos) (02)-------------------------------------
    painelRoteiro.getTfPesquisa().getDocument().addDocumentListener(new DocumentListener(){
      
      @Override
      public void insertUpdate(DocumentEvent e) {
        onChage();
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        onChage();
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
        onChage();
      }

      public void onChage(){
        String s = painelRoteiro.getTfPesquisa().getText();
        if (s.length() == 0)
          painelRoteiro.getRowSorter().setRowFilter(null);
        else {
          try {
            painelRoteiro.getRowSorter().setRowFilter(RowFilter.regexFilter("^(?i)" + s, painelRoteiro.getCbPesquisa().getSelectedIndex()));
          }
          catch(PatternSyntaxException ex){
          }
        }
      }
    });
    
    painelRoteiro.gettTabela().addMouseListener(new MouseListener() {
      
      @Override
      public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() >= 2){
          try {
          
            int lin = painelRoteiro.gettTabela().rowAtPoint(e.getPoint());
            String roteiro = (String) painelRoteiro.gettTabela().getModel().getValueAt(lin, 0);
            String dataInicio = (String) painelRoteiro.gettTabela().getModel().getValueAt(lin, 1);
            String dataFinal = (String) painelRoteiro.gettTabela().getModel().getValueAt(lin, 2);
            Roteiro r = validarRoteiro(roteiro, dataInicio, dataFinal);
            
            JFrame frameSecundario = new JFrame(("Roteiro " + r.getRegião() + " " + r.getDataInicio().getFullData() + " a " + r.getDataTermino().getFullData()));
            frameSecundario.setSize(900, 600);
            frameSecundario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frameSecundario.setIconImage(imageIcon.getImage());
            frameSecundario.setResizable(false);
            frameSecundario.getContentPane().add(painelRoteiroParaIndividual);
            frameSecundario.setLocationRelativeTo(MainFrame.self);
            frameSecundario.setVisible(true);
            
            painelRoteiroParaIndividual.atualizarDados(r.getPedidos());
            painelRoteiroParaIndividual.getbFechar().addActionListener(e1 -> {
              frameSecundario.dispose();
            });

            painelRoteiroParaIndividual.gettTabela().addMouseListener(new MouseListener() {

              @Override
              public void mouseClicked(MouseEvent e2) {
                if (e2.getClickCount() >= 2){
                  try{
                    int lin1 = painelRoteiroParaIndividual.gettTabela().rowAtPoint(e2.getPoint());
                    int numPedido = (Integer) painelRoteiroParaIndividual.gettTabela().getModel().getValueAt(lin1, 0);
                    String roteiro1 = (String) painelRoteiroParaIndividual.gettTabela().getModel().getValueAt(lin1, 1);
                    Pedido p = validarPedido(numPedido, roteiro1);

                    JFrame frameTerciario = new JFrame(("Pedido " + numPedido));
                    frameTerciario.setSize(400, 600);
                    frameTerciario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frameTerciario.setIconImage(imageIcon.getImage());
                    frameTerciario.setResizable(false);
                    frameTerciario.getContentPane().add(painelListaDoPedido);
                    frameTerciario.setLocationRelativeTo(MainFrame.self);
                    frameTerciario.setVisible(true);

                    painelListaDoPedido.atualizarDados(p);
                    painelListaDoPedido.getbSair().addActionListener(e3 -> {
                      frameTerciario.dispose();
                    });
                  }
                  catch (IndexOutOfBoundsException ex){}
                  catch(ClassCastException ex){}
                }
              }

              @Override
              public void mousePressed(MouseEvent e1) {
              }

              @Override
              public void mouseReleased(MouseEvent e1) {
              }

              @Override
              public void mouseEntered(MouseEvent e1) {
              }

              @Override
              public void mouseExited(MouseEvent e1) {
              }
            });


          }
          catch (IndexOutOfBoundsException ex){}
          catch(ClassCastException ex){}
        }
        
      }

      @Override
      public void mousePressed(MouseEvent e) {
      }

      @Override
      public void mouseReleased(MouseEvent e) {
      }

      @Override
      public void mouseEntered(MouseEvent e) {
      }

      @Override
      public void mouseExited(MouseEvent e) {
      }
      
    });
   
    //----------------------------------------------------------------


    //Criar Roteiro  (03)---------------------------------------------
    painelCriarRoteiro.getbAdicionarRegiao().addActionListener(e -> {
      String s = painelCriarRoteiro.getTfAdicionarRegiao().getText();
      painelCriarRoteiro.getCbSelecionarRegiao().addItem(s);
      painelCriarRoteiro.getTfAdicionarRegiao().setText("");
      
      controle.adicionarRegiao(s);
    });

    painelCriarRoteiro.getbCriarRoteiro().addActionListener(e -> {
      PainelCriarRoteiro pc = painelCriarRoteiro;
      boolean flag = false;
      Roteiro r = new Roteiro();

      if (pc.getTfDataInicio().getText() != null && !pc.getTfDataInicio().getText().equals(""))
        r.setDataInicio(new Data(pc.getTfDataInicio().getText()));
      else flag = true;
      if (pc.getTfDataTermino().getText() != null && !pc.getTfDataTermino().getText().equals(""))
        r.setDataTermino(new Data(pc.getTfDataTermino().getText()));
      else flag = true;

      if (flag){
        JOptionPane.showMessageDialog(this, "Campo vazio", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
      }

      try {
        r.setRegião((String) pc.getCbSelecionarRegiao().getSelectedItem());
      }
      catch (Exception ex){
        JOptionPane.showMessageDialog(this, "Região não selecionada", "Erro", JOptionPane.ERROR);
        return;
      }

      controle.adicionarRoteiro(r);
      atualizarTabelasRoteiro();
      pc.getTfDataInicio().setText("");
      pc.getTfDataTermino().setText("");
    });
    //----------------------------------------------------------------


    //Criar Pedidos (04)----------------------------------------------
    painelCriarPedido.getbSelecionarCliente().addActionListener(e -> {
      JFrame frameSecundario = new JFrame();
      frameSecundario.setSize(850, 560);
      frameSecundario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frameSecundario.setTitle("Selecionar Cliente");
      frameSecundario.setResizable(false);
      frameSecundario.setLocationRelativeTo(this);
      frameSecundario.setVisible(true);
      frameSecundario.getContentPane().add(painelSelecionarCliente);
      frameSecundario.setIconImage(imageIcon.getImage());

      //Selecionar Clientes---------------------------------------------
      painelSelecionarCliente.getbSelecionar().addActionListener(e1 -> {
        PainelSelecionarCliente ps = painelSelecionarCliente;
        try {
          Cliente c = validarCliente(ps.gettTabela().getModel().getValueAt(ps.gettTabela().getSelectedRow(), 0), 
                    ps.gettTabela().getModel().getValueAt(ps.gettTabela().getSelectedRow(), 1),
                    ps.gettTabela().getModel().getValueAt(ps.gettTabela().getSelectedRow(), 2));
          painelCriarPedido.setClienteSelecionado(c);
          painelCriarPedido.getTfCliente().setText(painelCriarPedido.getClienteSelecionado().getNome());
          frameSecundario.dispose();
        }
        catch(Exception ex){

        }        
      });
      
      painelSelecionarCliente.getTfBusca().getDocument().addDocumentListener(new DocumentListener() {

        @Override
        public void insertUpdate(DocumentEvent e) {
          onChange();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
          onChange();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
          onChange();
        }

        private void onChange(){
          String s = painelSelecionarCliente.getTfBusca().getText();
          if (s.length() == 0)
            painelSelecionarCliente.getRowSorter().setRowFilter(null);
          else {
            try {
              painelSelecionarCliente.getRowSorter().setRowFilter(RowFilter.regexFilter("^(?i)" + s));
            }
            catch(PatternSyntaxException ex){
            }
        }
        }
        
      });
      //----------------------------------------------------------------
    });

    painelCriarPedido.getbSelecionarRoteiro().addActionListener(e -> {
      JFrame frameSecundario = new JFrame();
      frameSecundario.setSize(850, 560);
      frameSecundario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frameSecundario.setTitle("Selecionar Roteiro");
      frameSecundario.setResizable(false);
      frameSecundario.setLocationRelativeTo(this);
      frameSecundario.setVisible(true);
      frameSecundario.getContentPane().add(painelSelecionarRoteiro);
      frameSecundario.setIconImage(imageIcon.getImage());

      //Selecionar Roteiro----------------------------------------------
      painelSelecionarRoteiro.getbSelecionar().addActionListener(e1 -> {
        PainelSelecionarRoteiro ps = painelSelecionarRoteiro;
        try {
          Roteiro r = validarRoteiro(ps.gettTabela().getModel().getValueAt(ps.gettTabela().getSelectedRow(), 0), 
                    ps.gettTabela().getModel().getValueAt(ps.gettTabela().getSelectedRow(), 1),
                    ps.gettTabela().getModel().getValueAt(ps.gettTabela().getSelectedRow(), 2));
        painelCriarPedido.setRoteiroSelecionado(r);
        painelCriarPedido.getTfRoteiro().setText(painelCriarPedido.getRoteiroSelecionado().getRegião());
        frameSecundario.dispose();
        }
        catch(Exception ex){
        }        
      });
    
      painelSelecionarRoteiro.getTfBusca().getDocument().addDocumentListener(new DocumentListener(){
        @Override
        public void insertUpdate(DocumentEvent e) {
          onChange();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
          onChange();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
          onChange();
        }

        private void onChange(){
          String s = painelSelecionarRoteiro.getTfBusca().getText();
          if (s.length() == 0)
          painelSelecionarRoteiro.getRowSorter().setRowFilter(null);
          else {
            try {
              painelSelecionarRoteiro.getRowSorter().setRowFilter(RowFilter.regexFilter("^(?i)" + s));
            }
            catch(PatternSyntaxException ex){
            }
          }
        }
      });
      //----------------------------------------------------------------
    });
   
    painelCriarPedido.getbAdicionarProduto().addActionListener(e -> {
      JFrame frameSecundario = new JFrame();
      frameSecundario.setSize(850, 560);
      frameSecundario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frameSecundario.setTitle("Adicionar Produtos");
      frameSecundario.setResizable(false);
      frameSecundario.setLocationRelativeTo(MainFrame.self);
      frameSecundario.setVisible(true);
      frameSecundario.getContentPane().add(painelAdicionarProduto);
      frameSecundario.setIconImage(imageIcon.getImage());

      //Tabela--------------------------------------------------------
      painelAdicionarProduto.gettTabela().addMouseListener(new MouseListener(){

        @Override
        public void mouseClicked(MouseEvent e) {
          try {
            int lin = painelAdicionarProduto.gettTabela().rowAtPoint(e.getPoint());
            String s = (String) painelAdicionarProduto.gettTabela().getModel().getValueAt(lin, 0);
            painelAdicionarProduto.getTfProduto().setText(s);
          }
          catch (IndexOutOfBoundsException ex){}
          catch (ClassCastException ex){
            try { 
              int lin = painelAdicionarProduto.gettTabela().rowAtPoint(e.getPoint());
              String s = String.valueOf(painelAdicionarProduto.gettTabela().getModel().getValueAt(lin, 0));
              painelAdicionarProduto.getTfProduto().setText(s);
            }
            catch (Exception ex1){}
          }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

      });
      //--------------------------------------------------------------

      //Text Field Busca----------------------------------------------
      painelAdicionarProduto.getTfProduto().getDocument().addDocumentListener(new DocumentListener(){

        @Override
        public void insertUpdate(DocumentEvent e) {
          onChage();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
          onChage();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
          onChage();
        }

        @SuppressWarnings("unused")
        public void onChage(){
          boolean ehNum = true;
          String s = painelAdicionarProduto.getTfProduto().getText();
          try {
            int teste = Integer.parseInt(s);
          }
          catch (NumberFormatException ex){
            ehNum = false;
          }

          if (s.length() == 0)
            painelAdicionarProduto.getRowSorter().setRowFilter(null);
          else {
            try {
              if (ehNum)
                painelAdicionarProduto.getRowSorter().setRowFilter(RowFilter.regexFilter("^(?i)" + s, 0));
              else 
                painelAdicionarProduto.getRowSorter().setRowFilter(RowFilter.regexFilter("^(?i)" + s, 1));
            }   
            catch(PatternSyntaxException ex){
            }
          }
        }
      });
      //--------------------------------------------------------------

      //Adicionar Produto---------------------------------------------
      painelAdicionarProduto.getbAdicionar().addActionListener(e1 -> {
        ProdutoQuantidade pq = new ProdutoQuantidade();
        try {
          Produto p = validarProduto(painelAdicionarProduto.getTfProduto().getText());
          int q = Integer.parseInt(painelAdicionarProduto.getTfQuantidade().getText());
          pq.setProduto(p);
          pq.setQuantidade(q);
          atualizarTabelaProdutoQuantidade(pq);
          painelAdicionarProduto.getTfProduto().setText("");
          painelAdicionarProduto.getTfQuantidade().setText("");
          painelAdicionarProduto.getTfProduto().requestFocus();
        }
        catch(NumberFormatException ex){
          JOptionPane.showMessageDialog(frameSecundario, "Formato número errado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        catch(NullPointerException ex){
          JOptionPane.showMessageDialog(frameSecundario, "Erro ao selecionar produto", "Erro", JOptionPane.ERROR_MESSAGE);
        }
      });

      painelAdicionarProduto.getbAdicionar().addKeyListener(new KeyListener(){

        @Override
        public void keyTyped(KeyEvent e) {
          if (e.getKeyChar() == KeyEvent.VK_ENTER){
            ProdutoQuantidade pq = new ProdutoQuantidade();
            try {
              Produto p = validarProduto(painelAdicionarProduto.getTfProduto().getText());
              int q = Integer.parseInt(painelAdicionarProduto.getTfQuantidade().getText());
              pq.setProduto(p);
              pq.setQuantidade(q);
              atualizarTabelaProdutoQuantidade(pq);
              painelAdicionarProduto.getTfProduto().setText("");
              painelAdicionarProduto.getTfQuantidade().setText("");
              painelAdicionarProduto.getTfProduto().requestFocus();
            }
            catch(NumberFormatException ex){
              JOptionPane.showMessageDialog(frameSecundario, "Formato número errado", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            catch(NullPointerException ex){
              JOptionPane.showMessageDialog(frameSecundario, "Erro ao selecionar produto", "Erro", JOptionPane.ERROR_MESSAGE);
            }
          }
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

      });
      //--------------------------------------------------------------

      //Fechar--------------------------------------------------------
      painelAdicionarProduto.getbFechar().addActionListener(e1 -> {
        frameSecundario.dispose();
      });
      //--------------------------------------------------------------
    });
    
    painelCriarPedido.getbFecharPedido().addActionListener(e -> {
      Pedido p = new Pedido();
      controle.getListaNumPermanentes().set(1, p.getNumGeralPedido());
      boolean flag = false;
      PainelCriarPedido pc = painelCriarPedido;
      try {
        if (!pc.getListaProdutoQuantidade().isEmpty()){
          for (ProdutoQuantidade pq: pc.getListaProdutoQuantidade()){
            p.addProduto(pq);
          }
        } 
        else{
          flag = true;
        } 
        if (pc.getTfCliente().getText() != null && !pc.getTfCliente().getText().equals("")){
          p.setCliente(pc.getClienteSelecionado());
        }
        else{
          flag = true;
        } 
        if (pc.getTfData().getText() != null && !pc.getTfData().getText().equals("")){
          p.setData(new Data(painelCriarPedido.getTfData().getText()));
        }
        else{ 
          flag = true;
        }
        if (pc.getTfRoteiro().getText() != null && !pc.getTfRoteiro().getText().equals("")){
          p.setRoteiro(painelCriarPedido.getRoteiroSelecionado());
          painelCriarPedido.getRoteiroSelecionado().adicionarPedido(p);
        }
        else{
          flag = true;
        } 

        if (flag){
          JOptionPane.showMessageDialog(this, "Dados incorretos", "Erro", JOptionPane.ERROR_MESSAGE);
          p.diminuirContador();
          return;
        }

        controle.adicionarPedido(p);
        atualizarTabelasPedidoIndividual();

        pc.getTfCliente().setText("");
        pc.getTfRoteiro().setText("");
        pc.getTfData().setText("");
        pc.limparTabela();
      }
      catch(Exception ex){
        p.diminuirContador();
        controle.getListaNumPermanentes().set(1, p.getNumGeralPedido());
        JOptionPane.showMessageDialog(this, "Dados incorretos", "Erro", JOptionPane.ERROR_MESSAGE);
      }
    });
    //----------------------------------------------------------------
  

    //RoteiroXPedido (05)---------------------------------------------
    painelEstoqueXRoteiro.getbEscolherRoteiro().addActionListener(e -> {
      JFrame frameSecundario = new JFrame();
      frameSecundario.setSize(485, 630);
      frameSecundario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frameSecundario.setTitle("Escolher Roteiro");
      frameSecundario.setResizable(false);
      frameSecundario.setLocationRelativeTo(this);
      frameSecundario.setVisible(true);
      frameSecundario.getContentPane().add(painelEscolherRoteiro);
      frameSecundario.setIconImage(imageIcon.getImage());

      //Botao escolher------------------------------------------------
      painelEscolherRoteiro.getbEscolher().addActionListener(e1 -> {
        try {
          Object regiao = (painelEscolherRoteiro.gettTabela().getModel().getValueAt(painelEscolherRoteiro.gettTabela().getSelectedRow(), 0));
          Object dataI = (painelEscolherRoteiro.gettTabela().getModel().getValueAt(painelEscolherRoteiro.gettTabela().getSelectedRow(), 1));
          Object dataF = (painelEscolherRoteiro.gettTabela().getModel().getValueAt(painelEscolherRoteiro.gettTabela().getSelectedRow(), 2));
        
          painelEstoqueXRoteiro.setRoteiroSelecionado(validarRoteiro(regiao, dataI, dataF));
          painelEstoqueXRoteiro.atualizarSelecionado();

          frameSecundario.dispose();
        } 
        catch (Exception ex) {
          return;
        }
      });
      //--------------------------------------------------------------
    });

    painelEstoqueXRoteiro.getbSubtrairEstoque().addActionListener(e -> {
      for(ProdutoQuantidade pq: painelEstoqueXRoteiro.getListaProdutosNoRoteiro()){
        for(int i=0; i<controle.getListaProdutoQuantidade().size(); i++){
          if (pq.getProduto().getCodigo() == controle.getListaProdutoQuantidade().get(i).getProduto().getCodigo()){
            int resultado = controle.getListaProdutoQuantidade().get(i).getQuantidade() - pq.getQuantidade();
            if (resultado >= 0)
              controle.getListaProdutoQuantidade().get(i).setQuantidade(resultado);
            else 
              controle.getListaProdutoQuantidade().get(i).setQuantidade(0);
          }
        }
      }
      atualizarTabelasProduto();
    });
    //----------------------------------------------------------------
  }

  @Override
  public void windowStateChanged(WindowEvent e) {    
    float x = this.getWidth();
    float y = this.getHeight();

    mudarTodosPaineis(x,y);

    this.getContentPane().revalidate();
    this.getContentPane().repaint();
  }

  private void mudarTodosPaineis(float x, float y){
    if (this.getExtendedState() == JFrame.MAXIMIZED_BOTH){
      mudarTamanhoComponentesPainel(painelInicial, x, y, true);
      mudarTamanhoComponentesPainel(painelCadastroClientes, x, y, true);
      mudarTamanhoComponentesPainel(painelCadastroFornecedores, x, y, true);
      mudarTamanhoComponentesPainel(painelCadastroProdutos, x, y, true);
      mudarTamanhoComponentesPainel(painelCadastros, x, y, true);
      mudarTamanhoComponentesPainel(painelCriarPedido, x, y, true);
      mudarTamanhoComponentesPainel(painelCriarRoteiro, x, y, true);
      mudarTamanhoComponentesPainel(painelEstoque, x, y, true);
      mudarTamanhoComponentesPainel(painelEstoqueXRoteiro, x, y, true);
      mudarTamanhoComponentesPainel(painelPedidos, x, y, true);
      mudarTamanhoComponentesPainel(painelPedidosIndividuais, x, y, true);
      mudarTamanhoComponentesPainel(painelRoteiro, x, y, true);
      mudarTamanhoComponentesPainel(painelVerClientes, x, y, true);
      mudarTamanhoComponentesPainel(painelVerFornecedores, x, y, true);
      mudarTamanhoComponentesPainel(painelVerProdutos, x, y, true);
    }
    else {
      mudarTamanhoComponentesPainel(painelInicial, x, y, false);
      mudarTamanhoComponentesPainel(painelCadastroClientes, x, y, false);
      mudarTamanhoComponentesPainel(painelCadastroFornecedores, x, y, false);
      mudarTamanhoComponentesPainel(painelCadastroProdutos, x, y, false);
      mudarTamanhoComponentesPainel(painelCadastros, x, y, false);
      mudarTamanhoComponentesPainel(painelCriarPedido, x, y, false);
      mudarTamanhoComponentesPainel(painelCriarRoteiro, x, y, false);
      mudarTamanhoComponentesPainel(painelEstoque, x, y, false);
      mudarTamanhoComponentesPainel(painelEstoqueXRoteiro, x, y, false);
      mudarTamanhoComponentesPainel(painelPedidos, x, y, false);
      mudarTamanhoComponentesPainel(painelPedidosIndividuais, x, y, false);
      mudarTamanhoComponentesPainel(painelRoteiro, x, y, false);
      mudarTamanhoComponentesPainel(painelVerClientes, x, y, false);
      mudarTamanhoComponentesPainel(painelVerFornecedores, x, y, false);
      mudarTamanhoComponentesPainel(painelVerProdutos, x, y, false);
    }
  }

  private void mudarTamanhoComponentesPainel(PainelBase painel, float x, float y, boolean flag){
    painel.setBounds(0, 0, (int)(x), (int)(y));
    painel.mudarTamanhoDosComponentes(x, y, flag);
  }

  private String getSubArray(String text){
    String retorno = "";
    for (int i=0; i<text.length(); i++){
      if (text.charAt(i) >= 48 && text.charAt(i) < 58){
        retorno += text.charAt(i);
      }
      else 
        break;
    }
    return retorno;
  }

  private boolean procurarFornecedor(String nomeFantasia){
    Fornecedor f = controle.getFornecedor(nomeFantasia);
    if (f == null)
      return false;
    return true;
  }

  private Endereco getEnderecoPorNome(String nome){
    for (Endereco e: controle.getListaEnderecos()){
      if (e.getCep().equals(nome)){
        return e;
      }
    }
    return null;
  }

  private double calcularPorcentagemLucro(double venda, double compra){
    return (venda*100)/compra;
  }

  private void atualizarTabelasProduto(){
    //Atualiza as tabelas sem disparar eventos
    TableModel model = painelEstoque.gettTabela().getModel();
    if (model instanceof DefaultTableModel) {
        ((DefaultTableModel)model).setRowCount(0); // Limpa sem notificar
    }

    this.painelEstoque.atualizarDados(controle.getListaProdutoQuantidade());
    this.painelVerProdutos.atualizarDados(controle.getListaProdutos());   
    this.painelAdicionarProduto.atualizarDados(controle.getListaProdutos());
  }

  private void atualizarTabelaProdutoQuantidade(ProdutoQuantidade pq){
    //Essa função serve para atualizar os valores de quantidade e preço de cada produto dentro do painel de 
    //criar pedido
    boolean flag = false;
    for (ProdutoQuantidade proQ: painelCriarPedido.getListaProdutoQuantidade()){
      if (proQ.getProduto().getNome().equals(pq.getProduto().getNome())){
        proQ.setQuantidade(proQ.getQuantidade()+pq.getQuantidade());
        flag = true;
        break;
      }
    }
    if (!flag)
      painelCriarPedido.getListaProdutoQuantidade().add(pq);
    painelCriarPedido.atualizarDados(painelCriarPedido.getListaProdutoQuantidade());
  }

  private void atualizarTabelasEndereco(){
    this.painelCadastroFornecedores.atualizarDados(controle.getListaEnderecos());
    this.painelCadastroClientes.atualizarDados(controle.getListaEnderecos());
  }

  private void atualizarTabelasFornecedor(){
    this.painelCadastroProdutos.atualizarDados(controle.getListaFornecedores());
    this.painelVerFornecedores.atualizarDados(controle.getListaFornecedores());
  }

  private void atualizarTabelasRoteiro(){
    painelRoteiro.atualizarDados(controle.getListaRoteiros());
    painelSelecionarRoteiro.atualizarDados(controle.getListaRoteiros());
    painelEscolherRoteiro.atualizarDados(controle.getListaRoteiros());
  }

  private void atualizarTabelasRegioes(){
    painelCriarRoteiro.atualizarDados(controle.getListaRegioes());
  }

  private void atualizarTabelasClientes(){
    this.painelVerClientes.atualizarDados(controle.getListaClientes());
    this.painelSelecionarCliente.atualizarDados(controle.getListaClientes());
  }

  private void atualizarTabelasPedidos(){
    atualizarTabelasPedidoIndividual();
  }

  private void atualizarTabelasPedidoIndividual(){
    painelPedidosIndividuais.atualizarDados(controle.getListaPedidos());
  }

  private void atualizarTabelasEstoqueXRoteiro(){
    painelEstoqueXRoteiro.atualizarDados(controle.getEstoque());
  }

  private void atualizarNumPermanentes(){
    //meio feio, mas consegue funcionar
    painelCadastroProdutos.getTfId().setText(String.valueOf(controle.getListaNumPermanentes().get(0)));
    Pedido.setNumGeralPedido(controle.getListaNumPermanentes().get(1));
  }

  private Cliente validarCliente(Object nome, Object nomeF, Object razao){
    for (Cliente c: controle.getListaClientes()){
      if (c.getNome().equals(nome) && c.getNomeFantasia().equals(nomeF) && c.getRazaoSocial().equals(razao)){
        return c;
      }
    }
    return null;
  }

  private Roteiro validarRoteiro(Object regiao, Object inicio, Object fim){
    for (Roteiro r: controle.getListaRoteiros()){
      if (r.getRegião().equals(regiao) && r.getDataInicio().getFullData().equals(inicio) && r.getDataTermino().getFullData().equals(fim)){
        return r;
      }
    }
    return null;
  }

  private Produto validarProduto(String nome){
    boolean ehNum = true;
    int id = -1;
    //tenta ver se a string é número do id ou nome do produto
    try{
      id = Integer.parseInt(nome);
    }
    catch (NumberFormatException ex){
      ehNum = false;
    }

    if (ehNum){
      for (Produto p: controle.getListaProdutos()){
        if (p.getCodigo() == id)
          return p;
      }
    }
    else {
      for (Produto p: controle.getListaProdutos()){
        if (p.getNome().equals(nome))
          return p;
      }
    }
    return null;
  }

  private Pedido validarPedido(int numPedido, String roteiro){
    for (Pedido p: controle.getListaPedidos()){
      if (p.getNumPedido() == numPedido && p.getRoteiro().getRegião().equals(roteiro))
        return p;
    }

    return null;
  }

  private boolean atualizarValorBD(int id, Object valor, int col, int painelOrigem){
    //int painelOrigem vai definir qual função chamar no controlador
    boolean flag = controle.atualizarDadosDB(id, col, valor, painelOrigem); 
    if (flag)
      atualizarTabelasProduto();      
    return flag;
  }

  private void atualizarOrdemDeFoco(PainelBase painelBase){
    this.setFocusTraversalPolicy(new CustomFocusTraversalPolicy(painelBase.getFocusList()));
  }
}