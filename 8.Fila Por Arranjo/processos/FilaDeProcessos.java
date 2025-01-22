public class FilaDeProcessos{
    int tamFila = 1000;
    Processo[] fila = new Processo[tamFila];
    int primeiro = 0, ultimo = 0, tamanho = 0, id = 0;

    public void add(String nome) throws Exception{
        if(tamanho == tamFila)
            throw new Exception("A fila de processos já está cheia!");
        
        fila[ultimo++] = new Processo(++id, nome);
        tamanho++;

        if(ultimo == tamFila)
            ultimo = 0;
    }

    public Processo remove() throws Exception{
        if(tamanho == 0)
            throw new Exception("Fila de processos vazia!");

        Processo retorno = fila[primeiro++];
        tamanho--;

        if(primeiro == tamFila)
            primeiro = 0;

        return retorno;
    }

    public Processo[] imprimir(){
        Processo[] retorno = new Processo[tamanho];

        int indice = 0;
        for(int i = primeiro; i != ultimo; i++){
            retorno[indice++] = fila[i];

            if(i == tamFila)
                i = 0;
        }
        return retorno;
    }

    public String localizar(int id){
        for (int i = primeiro; i != ultimo; i++) {
            if(fila[i].getId() == id){
               return ("Encontrado! "+ fila[i].getNome()+ ", com id: "+fila[i].getId());
            }
        }
        return ("Não encontrado!");
    }

    public void excluirTodos(){
        tamanho = 0;
        primeiro = 0;
        ultimo = 0;
    }
}