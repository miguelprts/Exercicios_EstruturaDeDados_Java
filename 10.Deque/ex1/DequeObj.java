package ex1;
public class DequeObj<T> {
    private T elemento;
    private DequeObj<T> proximo, anterior;

    public DequeObj(T elemento){
        this.elemento = elemento;
        this.anterior = null;
        this.proximo = null;
    }
    public DequeObj() {
    }
    public T getElemento() {
        return elemento;
    }
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }
    public DequeObj<T> getProximo() {
        return proximo;
    }
    public void setProximo(DequeObj<T> proximo) {
        this.proximo = proximo;
    }
    public DequeObj<T> getAnterior() {
        return anterior;
    }
    public void setAnterior(DequeObj<T> anterior) {
        this.anterior = anterior;
    }
}