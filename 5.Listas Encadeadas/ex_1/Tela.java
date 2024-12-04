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
import javax.swing.text.MaskFormatter;
import ex_1.classes.Cliente;
import ex_1.classes.Lista;
import javax.swing.JFormattedTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Tela extends JFrame implements ActionListener{
    private DefaultListModel<String> listModel = new DefaultListModel<>();  
    private JList<String> listaVisual = new JList<>(listModel);

    private JTextField inputNome = new JTextField(20);
    private JTextField inputCodigo = new JTextField(20);
    private JFormattedTextField inputTelefone;
    private Lista l = new Lista();
    private ArrayList<Cliente> lista = new ArrayList<Cliente>();

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

        try {
            MaskFormatter telep = new MaskFormatter("(##)######-####");
            inputTelefone = new JFormattedTextField(telep);
        } catch (Exception e) {
            // TODO: handle exception
        }

        //adicionando na tela, e configurando elementos
        listaVisual.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
        //formulário
        JPanel p1 = new JPanel();
        p1.add(new JLabel("Nome:"));
        p1.add(inputNome);
        p1.add(new JLabel("Código do cliente:"));
        p1.add(inputCodigo);
        p1.add(new JLabel("Telefone"));
        p1.add(inputTelefone);

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
        if(e.getSource() == btnAdicionar || e.getSource() == mn_adicionar){
            try{
                long telefone = Long.parseLong(inputTelefone.getText().replaceAll("[()-]", ""));
                l.inserir(inputNome.getText(), Integer.parseInt(inputCodigo.getText()), telefone);
                lista = l.exibir();
                listModel.clear();
                for (int i = 0; i < lista.size(); i++) {
                listModel.addElement("Nome: "+ lista.get(i).getNome() + ". Telefone: " + lista.get(i).getTelefone() + ". Código: "+lista.get(i).getCodigo());
                }
                JOptionPane.showMessageDialog(null, "Inserido com sucesso!", "Sucesso", JOptionPane.ERROR_MESSAGE);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public static void main(String[] args) {
            new Tela();
    };
}