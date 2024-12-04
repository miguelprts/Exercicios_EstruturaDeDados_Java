package ex_1.classes;

public class Cliente {
    private int codigo;
    private String nome;
    private long telefone;

    public Cliente(){}
    public Cliente(int codigo, String nome, long telefone){
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public long getTelefone() {
        return telefone;
    }
    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }   
}