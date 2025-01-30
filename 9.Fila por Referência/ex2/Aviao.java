package ex2;
public class Aviao {
    private Aviao proximo;
    private String numeracao;
    
    public Aviao(Aviao proximo, String numeracao) {
        this.proximo = proximo;
        this.numeracao = numeracao;
    }
    public Aviao getProximo() {
        return proximo;
    }
    public void setProximo(Aviao proximo) {
        this.proximo = proximo;
    }
    public String getNumeracao() {
        return numeracao;
    }
    public void setNumeracao(String numeracao) {
        this.numeracao = numeracao;
    }  
}
