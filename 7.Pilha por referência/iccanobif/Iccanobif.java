public class Iccanobif {
    int tamanho = 0;
    Numero topo;

    public void push(Numero novo){
        if(tamanho!=0)
            novo.proximo = topo;
        topo = novo;
        ++tamanho;
    }
    public Numero pop() throws Exception{
        if(tamanho == 0)
            throw new Exception("Lista sem elementos");
        Numero retorno = topo;
        topo = topo.proximo;
        --tamanho;
        return retorno;
    }   

    public boolean isVazia(){
        return tamanho == 0;
    }

    public void calcularIcannobif(int valor){
        if (valor == 0 || valor == 1){
            push(new Numero(1));
        }
        else{
            int p = 0, s = 1, resultado = 0;

            push(new Numero(1));

        for (int i = 2; i <= valor; i++) {
            resultado = p + s;
            p = s;
            s = resultado;

            push(new Numero(resultado));
        }
        }
    }
}
