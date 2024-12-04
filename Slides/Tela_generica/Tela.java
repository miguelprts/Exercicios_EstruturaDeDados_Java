package ex_1;
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
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela extends JFrame implements ActionListener{
    private DefaultListModel<String> listModel = new DefaultListModel<>();  
    private JList<String> listaVisual = new JList<>(listModel);

    private JTextField inputNome = new JTextField(20);
    private JButton btnAdicionar = new JButton("Adicionar");  
    private JButton btnCancelar = new JButton("Cancelar"); 
    private JButton btnExcluir = new JButton("Excluir"); 
    
    JMenuBar barra = new JMenuBar();
    JMenu menu = new JMenu("Opções");
        JMenuItem mn_adicionar = new JMenuItem("Adicionar");
        JMenuItem mn_remover = new JMenuItem("Remover");

    public Tela() {
        super("Lista");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        //setResizable(false);
        setLocationRelativeTo(null);

        //actionListener
        btnAdicionar.addActionListener(this);
        btnExcluir.addActionListener(this);
        mn_adicionar.addActionListener(this);
        mn_remover.addActionListener(this);
        //corzinhas
        btnAdicionar.setBackground(Color.PINK);
        btnExcluir.setBackground(Color.PINK);

        //barra de menu
        menu.add(mn_adicionar);
        menu.add(mn_remover);
        barra.add(menu);
        setJMenuBar(barra);

        //adicionando na tela, e configurando elementos
        listaVisual.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
        //formulário
        JPanel p1 = new JPanel();
        p1.add(new JLabel("Nome:"));
        p1.add(inputNome);

        JPanel p2 = new JPanel();
        p2.add(btnAdicionar);
        p2.add(btnCancelar);

        p1.add(p2);
        
        JPanel p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        p3.add(new JScrollPane(listaVisual), BorderLayout.CENTER);
        p3.add(btnExcluir, BorderLayout.SOUTH);

        // Colocando no Jframe
        add(p1, BorderLayout.NORTH);
        add(p3, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
    }
    public static void main(String[] args) {
            new Tela();
    };
}