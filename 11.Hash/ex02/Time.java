package ex02;

public class Time {
    private String nome;
    private String anoFundacao;
    private String codigo;
    private String tecnico;
    private String presidente;
    
    public Time(String nome, String anoFundacao, String codigo, String tecnico, String presidente) {
        this.nome = nome;
        this.anoFundacao = anoFundacao;
        this.codigo = codigo;
        this.tecnico = tecnico;
        this.presidente = presidente;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getAnoFundacao() {
        return anoFundacao;
    }
    public void setAnoFundacao(String anoFundacao) {
        this.anoFundacao = anoFundacao;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getTecnico() {
        return tecnico;
    }
    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }
    public String getPresidente() {
        return presidente;
    }
    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }
    
    
    
}
