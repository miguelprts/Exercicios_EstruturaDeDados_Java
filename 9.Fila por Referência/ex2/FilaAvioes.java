package ex2;

public class FilaAvioes {
    int tamanho = 0;
    Aviao primeiro = null, ultimo = null;

    public void add(String numeracao){
        Aviao novo = new Aviao(null, numeracao);

        if(tamanho == 0){
            primeiro = novo;
            ultimo = novo;
        }else{
            ultimo.setProximo(novo);
            ultimo = novo;
        }
        
        tamanho++;
    }
    public Aviao remove() throws Exception{
        if(tamanho == 0)
            throw new Exception("Fila vazia");

        Aviao retorno = primeiro; 
        primeiro = primeiro.getProximo();
        tamanho--;
        return retorno;
    }
}