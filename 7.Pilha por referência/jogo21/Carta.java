public class Carta {
    private Carta prox;
    private int valor;

    public Carta(int valor){
        this.valor = valor;
    }

    public Carta getProx() {
        return prox;
    }

    public void setProx(Carta prox) {
        this.prox = prox;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    
}
