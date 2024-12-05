package ex_3.telas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ex_3.classes.No;

public class Visualizar extends JFrame implements ActionListener{
    JButton jb_ant = new JButton("<");
    JButton jb_prox = new JButton(">");
    JButton jb_excluir = new JButton("Excluir");

    No noAtual;

    JTextField inputNome = new JTextField(20);
    JTextField inputPais = new JTextField(20);
    JTextField inputAtrativos = new JTextField(20);
    JTextField inputNota = new JTextField(5);

    public Visualizar(){
        super("Insira");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 600);
        //setResizable(false);
        setLocationRelativeTo(null);

        noAtual = Index.lista.cabeca.getProximo();
        inputNome.setEnabled(false);
        inputAtrativos.setEnabled(false);
        inputNota.setEnabled(false);
        inputPais.setEnabled(false);

        setLayout(new GridLayout(6, 2));
        add(new JLabel("Nome: "));
        add(inputNome);
        add(new JLabel("País: "));
        add(inputPais);
        add(new JLabel("Pricipais Atrativos: "));
        add(inputAtrativos);
        add(new JLabel("Nota entre 0 e 10: "));
        add(inputNota);
        add(jb_ant);
        add(jb_prox);

        preencherCampos();

        add(jb_excluir);
        add(new JLabel());

        jb_ant.addActionListener(this);
        jb_prox.addActionListener(this);
        jb_excluir.addActionListener(this);

        setVisible(true);
    }

    private void preencherCampos(){
        if(noAtual.getAnterior() == null){
            JOptionPane.showMessageDialog(Visualizar.this, 
            "Esse é a primeira cidade da lista.", 
            "Opa", JOptionPane.ERROR_MESSAGE);
        }
        else{
            inputNome.setText(noAtual.getElemento().getNome());
            inputAtrativos.setText(noAtual.getElemento().getAtrativos());
            inputPais.setText(noAtual.getElemento().getPais());
            inputNota.setText(String.valueOf(noAtual.getElemento().getNota()));
        }
    }

    public void actionPerformed(ActionEvent ev){
        if (ev.getSource() == jb_ant) {
            if (noAtual != null && noAtual.getAnterior() != null) {
                noAtual = noAtual.getAnterior();
                preencherCampos();
            } else {
                JOptionPane.showMessageDialog(Visualizar.this, 
                    "Esse é a primeira cidade da lista.", 
                    "Opa", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (ev.getSource() == jb_prox) {
            if (noAtual != null && noAtual.getProximo() != null) {
                noAtual = noAtual.getProximo();
                preencherCampos();
            } else {
                JOptionPane.showMessageDialog(Visualizar.this, 
                    "Esse é a última cidade da lista.", 
                    "Opa", JOptionPane.ERROR_MESSAGE);
            }
        }        
        if(ev.getSource() == jb_excluir){
            try{
                No noAnterior = noAtual.getAnterior();
                if (noAnterior.getAnterior() == null)
                    noAnterior = noAtual.getProximo();
                Index.lista.remover(noAtual);
                JOptionPane.showMessageDialog(null, "Apagado!", "ERRO", JOptionPane.INFORMATION_MESSAGE);
                
                noAtual = noAnterior;
                preencherCampos();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}