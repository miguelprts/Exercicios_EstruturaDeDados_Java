package telas;
    
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import classes.Candidato;
import classes.Lista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela extends JFrame implements ActionListener{
    private DefaultListModel<String> listModel = new DefaultListModel<>();  
    private JList<String> listaVisual = new JList<>(listModel);

    private JTextField inputNome = new JTextField(20);
    private JButton btnAdicionar = new JButton("Adicionar");  
    private JButton btnPesquisar = new JButton("Pesquisar"); 
    private JButton btnExcluir = new JButton("Excluir"); 
    private JButton btnRecarregar = new JButton("Recarregar"); 

    public static Lista lista = new Lista();
    
    JMenuBar barra = new JMenuBar();
    JMenu menu = new JMenu("Opções");
        JMenuItem mn_adicionar = new JMenuItem("Adicionar");

    public Tela() {
        super("Candidatos do Concurso");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        //setResizable(false);
        setLocationRelativeTo(null);

        //actionListener
        btnAdicionar.addActionListener(this);
        btnRecarregar.addActionListener(this);

        btnExcluir.addActionListener(this);
        btnPesquisar.addActionListener(this);

        mn_adicionar.addActionListener(this);
        //corzinhas
        btnAdicionar.setBackground(Color.GREEN);
        btnPesquisar.setBackground(Color.CYAN);
        btnExcluir.setBackground(Color.PINK);

        //barra de menu
        menu.add(mn_adicionar);
        barra.add(menu);
        setJMenuBar(barra);

        //adicionando na tela, e configurando elementos
        listaVisual.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
        //formulário
        JPanel p1 = new JPanel();
        p1.add(new JLabel("Pesquise por Nome:"));
        p1.add(inputNome);

        JPanel p2 = new JPanel();
        p2.add(btnPesquisar);
        p2.add(btnAdicionar);
        p2.add(btnRecarregar);

        p1.add(p2);
        
        JPanel p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        p3.add(new JScrollPane(listaVisual), BorderLayout.CENTER);
        p3.add(btnExcluir, BorderLayout.SOUTH);

        // Colocando no Jframe
        add(p1, BorderLayout.NORTH);
        add(p3, BorderLayout.CENTER);

        setVisible(true);

        preencherJlist(lista.lista);
    }

    private void preencherJlist(Candidato[] l){
            listModel.clear();
            if(l!=null)
                for(Candidato c : l){
                    if(c != null)
                        listModel.addElement("Inscrição: " + c.getInscricao() + ". | Nome: " + c.getNome() + ". | Nota: " + c.getNota());
                }
        }
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource() == btnAdicionar || ev.getSource() == mn_adicionar){
           new Insercao();
        }

        if(ev.getSource() == btnRecarregar){
            preencherJlist(lista.lista);
            inputNome.setText("");
        }

        if(ev.getSource() == btnPesquisar){
            if(inputNome.getText() == null){
                JOptionPane.showMessageDialog(Tela.this, "Digite um nome!", "!", JOptionPane.INFORMATION_MESSAGE);                  
            }
            else
                preencherJlist(lista.consultar(inputNome.getText()));
        }

        if(ev.getSource() == btnExcluir){
            try {
                String selecionado = listaVisual.getSelectedValue(); // Pega o valor selecionado
                if (selecionado != null) {
                    String[] partes = selecionado.split("\\|");
                    if (partes.length >= 1) {
                        String nomeParte = partes[0].trim();
                        String numInscricao = nomeParte.replace("Inscrição: ", "").replace(".", "").trim();

                        lista.remover(Integer.parseInt(numInscricao));
                        JOptionPane.showMessageDialog(Tela.this, "Removido! Pesquise novamente para ver os outros candidatos com esse nome!", "!", JOptionPane.INFORMATION_MESSAGE);
                        preencherJlist(lista.lista);                 
                    }else{
                        JOptionPane.showMessageDialog(this, "Formato inválido de entrada.");
                    }
                }else{
                    JOptionPane.showMessageDialog(Tela.this, "Selecione algum candidato!", "!", JOptionPane.ERROR_MESSAGE);                  
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(Tela.this, "Não foi possível remover!", "!", JOptionPane.ERROR_MESSAGE);    
                e.printStackTrace();              
            }
        }
    }
}