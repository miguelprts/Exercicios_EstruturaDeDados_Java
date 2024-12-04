public class ListaPessoa {
    private int tam = 20;
    private Pessoa[] A;
    private int ultimo = 0;
    public ListaPessoa(){
        A = new Pessoa[tam];
    }
    public void add(int pos, Pessoa p) throws Exception{
        if (ultimo==A.length)
            throw new Exception("Não há espaço disponível.");

        if (pos > ultimo) // não deixamos espaços vazios
            pos = ultimo;

        if (pos < ultimo){ // move-se todos para a direita
            for (int i=ultimo; i>pos; --i)
                A[i] = A[i-1];
        }
        A[pos] = p;
        ultimo++;
    }

    public Pessoa get(int pos) throws Exception{
        if (pos >= ultimo)
            throw new Exception("Não existe este elemento");
        return A[pos];
    }

    public void remove(int pos) throws Exception {
        if (pos >= ultimo)
            throw new Exception("Não existe este elemento");
        for (int i=pos;i<ultimo;i++)
            A[i] = A[i+1];
        ultimo--;
    }

    public int tamanho(){
        return ultimo;
    }
}