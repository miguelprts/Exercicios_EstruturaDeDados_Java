package ex03;
public class Ano {
    private int ano;
    private float temp;
    private Ano esquerda, direita;   

    public Ano(int ano, float temp) {
        this.ano = ano;
        this.temp = temp;
        this.esquerda = null;
        this.direita = null;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public float getTemp() {
        return temp;
    }
    public void setTemp(float temp) {
        this.temp = temp;
    }
    public Ano getEsquerda() {
        return esquerda;
    }
    public void setEsquerda(Ano esquerda) {
        this.esquerda = esquerda;
    }
    public Ano getDireita() {
        return direita;
    }
    public void setDireita(Ano direita) {
        this.direita = direita;
    }
}
