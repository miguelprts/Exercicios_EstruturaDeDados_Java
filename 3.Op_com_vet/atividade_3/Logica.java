package atividade_3;

public class Logica {
    private String[] nomes; 
    private int ultimaPosicao; 

    public Logica(){
        this.nomes = new String[10];
        this.ultimaPosicao = -1;  
    }  
    public String[] getNomes() {
        return nomes;
    }
    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }
    public int getUltimaPosicao() {
        return ultimaPosicao;
    }
    public void setUltimaPosicao(int ultimaPosicao) {
        this.ultimaPosicao = ultimaPosicao;
    }

    public void inserir(String nome) throws Exception{
        if(this.nomes.length == this.ultimaPosicao)
            throw new Exception("Atingiu o máximo de convidados!");
        else{
            int u = getUltimaPosicao();
            u++;
            setUltimaPosicao(u);
            this.nomes[u] = nome;
            System.out.println(this.nomes[u]);
        }
    }

    public void excluir(int pos){
        int ul = getUltimaPosicao();

        for (int i = pos; i != ul; i++)
            this.nomes[i] = this.nomes[i+1];
        this.nomes[ul] = null;
        ul--;
        setUltimaPosicao(ul);
    }
}