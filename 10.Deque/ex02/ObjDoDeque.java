package ex02;

public class ObjDoDeque<T>{
    private ObjDoDeque<T> proximo = null, anterior = null;
    private T elemento;
    
    public ObjDoDeque(T elemento) {
        this.elemento = elemento;
    }
   
    public ObjDoDeque<T> getProximo() {
        return proximo;
    }


    public ObjDoDeque() {
    }

    public void setProximo(ObjDoDeque<T> proximo) {
        this.proximo = proximo;
    }



    public ObjDoDeque<T> getAnterior() {
        return anterior;
    }



    public void setAnterior(ObjDoDeque<T> anterior) {
        this.anterior = anterior;
    }



    public T getElemento() {
        return elemento;
    }
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }


    
}
