public class Numero {
    private int elemento;
    private Numero proximo;

    public Numero(int elemento){
        this.elemento = elemento;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public Numero getProximo() {
        return proximo;
    }

    public void setProximo(Numero proximo) {
        this.proximo = proximo;
    }

    

}
