package exemplo;

public class No<T>{
    T elemento;
    No<T> esquerda, direita;

    public No(T elemento){
        this.elemento = elemento;
        esquerda = null; direita = null;
    }
    public T getElemento() {
        return elemento;
    }
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }
    public No<T> getEsquerda() {
        return esquerda;
    }
    public void setEsquerda(No<T> esquerda) {
        this.esquerda = esquerda;
    }
    public No<T> getDireita() {
        return direita;
    }
    public void setDireita(No<T> direita) {
        this.direita = direita;
    }
    
    
}
