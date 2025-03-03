package ex1;

public class Aluno {
    long matricula;
    String nome;
    String curso;
    Aluno esquerda, direita;


    
    public Aluno(long matricula, String nome, String curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
        this.esquerda = null;
        this.direita = null;
    }
    public long getMatricula() {
        return matricula;
    }
    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public Aluno getEsquerda() {
        return esquerda;
    }
    public void setEsquerda(Aluno esquerda) {
        this.esquerda = esquerda;
    }
    public Aluno getDireita() {
        return direita;
    }
    public void setDireita(Aluno direita) {
        this.direita = direita;
    }
}