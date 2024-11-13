package atividade_3;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela extends JFrame implements ActionListener{
    private DefaultListModel<String> listModel = new DefaultListModel<>();  
    private JList<String> nomeList = new JList<>(listModel);
    Logica logica = new Logica();  

    private JTextField inputNome = new JTextField(20);
    private JButton btnAdicionar = new JButton("Adicionar");               
    private JButton btnExcluir = new JButton("Excluir");                 

    public Tela() {
        super("Lista de Convidados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setResizable(false);
        setLocationRelativeTo(null);

        nomeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
        btnAdicionar.addActionListener(this);
        btnExcluir.addActionListener(this);
        
        JPanel p1 = new JPanel();
        p1.add(new JLabel("Nome:"));
        p1.add(inputNome);
        p1.add(btnAdicionar);
        
        // Adiciona os componentes ao frame
        add(p1, BorderLayout.NORTH);
        add(new JScrollPane(nomeList), BorderLayout.CENTER);
        add(btnExcluir, BorderLayout.SOUTH);

        btnAdicionar.setBackground(Color.PINK);
        btnExcluir.setBackground(Color.PINK);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == btnAdicionar){
            String nome = inputNome.getText();
            if (!nome.isEmpty() && listModel.size() < 10) {
                listModel.addElement(nome);
                try {
                    logica.inserir(nome);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Tela.this, ex.getMessage(), "OPA!", JOptionPane.ERROR_MESSAGE);
                }
                inputNome.setText("");

                String[] n = logica.getNomes();
                for (int i = 0; i < n.length; i++) {
                    System.out.println(n[i]);
                }
            } else if (listModel.size() >= 10) {
                JOptionPane.showMessageDialog(Tela.this, "Você só pode adicionar 10 nomes.", "Limite atingido", JOptionPane.WARNING_MESSAGE);
            }
        }

        else if(e.getSource() == btnExcluir){
            int selectedIndex = nomeList.getSelectedIndex();
                if (selectedIndex != -1) {
                    try {
                        logica.excluir(selectedIndex);
                    } catch (Exception ex) {
                       JOptionPane.showMessageDialog(Tela.this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    String[] n = logica.getNomes();
                    for (int i = 0; i < n.length; i++) {
                        System.out.println(n[i]);
                    }
                    listModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(Tela.this, "Selecione um nome para excluir.", "Nenhum nome selecionado", JOptionPane.WARNING_MESSAGE);
                }
        }
    }
    public static void main(String[] args) {
            new Tela();
    };
}