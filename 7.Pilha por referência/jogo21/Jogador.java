import java.util.Random;

public class Jogador {
    Carta topo;
    int pontuacao = 0;
    int tamanho = 0;
    Random random = new Random();
    
    public void push(int valor){
        Carta nova = new Carta(valor);
        if(tamanho!=0)
            nova.setProx(topo);
        topo = nova;
        tamanho++;

        if(pontuacao < 21)
            pontuacao += valor;

        else{
            try{
                pop();
            }catch(Exception e){
                System.out.println("Erro: "+e.getMessage());
            }
            pontuacao-= 5;
        }
    }
    public Carta pop() throws Exception{
        if(tamanho == 0)
            throw new Exception("Pilha vazia");
        Carta retorno = topo;
        topo = topo.getProx();
        tamanho--;
        return retorno;
    }
}
