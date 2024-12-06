package telas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Insercao extends JFrame implements ActionListener{
    JTextField inputNome = new JTextField();
    JTextField inputNota = new JTextField();

    JButton jb_inserir = new JButton("Inserir");
    JButton jb_voltar = new JButton("Voltar");

    public Insercao(){
        super("Adicione");
        setSize(600, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        jb_inserir.addActionListener(this);
        jb_voltar.addActionListener(this);

        setLayout(new GridLayout(3, 2));
        add(new JLabel("Nome:"));
        add(inputNome);
        add(new JLabel("Nota:"));
        add(inputNota);
        add(jb_voltar);
        add(jb_inserir);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource() == jb_inserir){
            try {
                Tela.lista.adicionar(inputNome.getText(), Integer.parseInt(inputNota.getText()));
                JOptionPane.showMessageDialog(Insercao.this, "Inserido com sucesso!", "!!!", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(Insercao.this, "Erro: "+e.getMessage(), "!!!", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(ev.getSource() == jb_voltar){
            dispose();
        }
    }
}
