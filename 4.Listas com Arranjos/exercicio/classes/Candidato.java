package classes;

public class Candidato {
    private String nome;
    private int inscricao, nota;

    public Candidato(String nome, int inscricao, int nota) {
        this.nome = nome;
        this.inscricao = inscricao;
        this.nota = nota;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getInscricao() {
        return inscricao;
    }
    public void setInscricao(int inscricao) {
        this.inscricao = inscricao;
    }
    public int getNota() {
        return nota;
    }
    public void setNota(int nota) {
        this.nota = nota;
    }
}