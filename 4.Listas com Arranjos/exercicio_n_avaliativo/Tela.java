package exercicio_n_avaliativo;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela extends JFrame implements ActionListener{
    DefaultListModel<String> model = new DefaultListModel<>();
    JList<String> lista = new JList<>(model);


    public Tela(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        add(new JScrollPane(lista), );
    }

    public void actionPerformed(ActionEvent ev){

    }
}