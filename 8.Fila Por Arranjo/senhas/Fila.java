public class Fila{
    int primeiro = 0, ultimo = 0, tamanho = 0, senha = 0;
    Senha[] fila = new Senha[50];

    public void add(String nome) throws Exception{
        if(tamanho == 50)
            throw new Exception("Senhas já esgotadas!");

        fila[ultimo++] = new Senha(nome, ++senha);

        if(ultimo == 50)
            ultimo = 0;
        tamanho++;
    }

    public Senha remove() throws Exception{
        if(tamanho == 0)
            throw new Exception("Senhas não distribuídas!");
        
        Senha retorno = fila[primeiro++];
        if(primeiro == 50)
            primeiro = 0;
            
        return retorno;
    }
}