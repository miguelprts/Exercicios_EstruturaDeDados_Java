package ex_3.classes;

public class Cidade {
    private String nome, pais, atrativos;
    private int nota;

    public Cidade(){};
    public Cidade(String nome, String pais, String atrativos, int nota){
        this.nome = nome;
        this.pais = pais;
        this.nota= nota;
        this.atrativos = atrativos;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getAtrativos() {
        return atrativos;
    }
    public void setAtrativos(String atrativos) {
        this.atrativos = atrativos;
    }
    public int getNota() {
        return nota;
    }
    public void setNota(int nota) {
        this.nota = nota;
    }    
}