public class No {
    public No proximo;
    public Pessoa elemento;
    public No (Pessoa elemento, No proximo){
        this.elemento = elemento;
        this.proximo = proximo;
    }
    public No(){
        this.elemento = null;
        this.proximo = null;
    }
}