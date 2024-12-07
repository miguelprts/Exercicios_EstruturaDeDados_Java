public class Pilha {
    int[] pilha;
    int topo = -1, tamanho;

    public Pilha(int tamanho){
        this.pilha = new int[tamanho];
        this.tamanho = tamanho;
    }
    
    public void push(int v) throws Exception{
        if(topo == tamanho-1){
            throw new Exception("Pilha cheia!");
        }
        pilha[++topo] = v;
    }
    public int pop() throws Exception{
        if(topo == -1){
            throw new Exception("Pilha vazia!");
        }
        return pilha[topo--];
    }
}
