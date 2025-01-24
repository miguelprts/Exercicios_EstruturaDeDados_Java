public class Fila {
    int tamanho = 0;
    Texto cabeca = null, cauda = null;

    public void add(String elemento, String operacao){
        Texto t = new Texto(elemento, operacao);
        if(tamanho == 0){
            cabeca = t;
            cauda = t;
        }
        else{
            cauda.setProximo(t);
            cauda = t;
        }
        tamanho++;
    }
    public Texto remove() throws Exception{
        if(tamanho == 0)
            throw new Exception("Fila vazia!");
        
        Texto retorno = cabeca;
        cabeca = cabeca.getProximo();
        tamanho--;

        return retorno;
    }
}