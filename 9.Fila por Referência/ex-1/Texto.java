public class Texto {
    private String elemento;
    private String operacao;
    private Texto proximo;

    public Texto(String elemento, String operacao) {
        this.elemento = elemento;
        this.operacao = operacao;
    }
    public String getElemento() {
        return elemento;
    }
    public void setElemento(String elemento) {
        this.elemento = elemento;
    }
    public Texto getProximo() {
        return proximo;
    }
    public void setProximo(Texto proximo) {
        this.proximo = proximo;
    }
    public String getOperacao() {
        return operacao;
    }
    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }
}