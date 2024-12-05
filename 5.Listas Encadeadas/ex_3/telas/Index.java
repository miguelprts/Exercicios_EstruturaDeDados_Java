package ex_3.telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import ex_3.classes.Lista;

public class Index extends JFrame implements ActionListener{
    JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("Opções");
        JMenuItem mn_adicionar = new JMenuItem("Adicionar Cidade");
        JMenuItem mn_visualizar = new JMenuItem("Visualizar");

        public static Lista lista = new Lista();

    public Index(){
        super("Lista de Cidades");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        //setResizable(false);
        setLocationRelativeTo(null);

        mn_adicionar.addActionListener(this);
        mn_visualizar.addActionListener(this);

        //barra de menu
        menu.add(mn_adicionar);
        menu.add(mn_visualizar);
        barra.add(menu);
        setJMenuBar(barra);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource() == mn_adicionar)
            new Adicionar();
        else{
            try{
                new Visualizar();
            }catch(Exception e){
                JOptionPane.showMessageDialog(Index.this, "Não há cidades registradas!");
            }
        }
    }
}