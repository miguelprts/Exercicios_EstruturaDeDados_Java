package ex_1.classes;

public class No {
    private No proximo;
    private No anterior;
    private Cliente elemento;

    public No getProximo() {
        return proximo;
    }
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
    public No getAnterior() {
        return anterior;
    }
    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
    public Cliente getElemento() {
        return elemento;
    }
    public void setElemento(Cliente elemento) {
        this.elemento = elemento;
    }
   
}