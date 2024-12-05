package ex_3.telas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Adicionar extends JFrame implements ActionListener{
    JButton jb_inserir = new JButton("Inserir");
    JTextField inputNome = new JTextField(20);
    JTextField inputPais = new JTextField(20);
    JTextField inputAtrativos = new JTextField(20);
    JTextField inputNota = new JTextField(5);

    public Adicionar(){
        super("Insira");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 600);
        //setResizable(false);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(5, 2));
        add(new JLabel("Nome: "));
        add(inputNome);
        add(new JLabel("País: "));
        add(inputPais);
        add(new JLabel("Pricipais Atrativos: "));
        add(inputAtrativos);
        add(new JLabel("Nota entre 0 e 10: "));
        add(inputNota);
        add(new JLabel());
        add(jb_inserir);

        jb_inserir.addActionListener(this);
    
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ev){
        try{
            Index.lista.adicionar(inputNome.getText(), inputPais.getText(), inputAtrativos.getText(), Integer.parseInt(inputNota.getText()));
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }