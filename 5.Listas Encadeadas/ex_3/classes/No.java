package ex_3.classes;

public class No {
    private No anterior, proximo;
    private Cidade elemento;

    public No getAnterior() {
        return anterior;
    }
    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
    public No getProximo() {
        return proximo;
    }
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
    public Cidade getElemento() {
        return elemento;
    }
    public void setElemento(Cidade elemento) {
        this.elemento = elemento;
    }   
}