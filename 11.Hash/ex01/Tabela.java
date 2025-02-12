public class Tabela {
    public static final int M = 13;
    private Livro[] tabela = new Livro[M];
    
    private int hash(String chave){
        int retorno = 0;
        for (int i = 0; i < chave.length(); i++) 
            retorno = (31* retorno + chave.charAt(i)) %M;
        return retorno;
    }
    public Livro get(String chave){
        int hash = hash(chave);
        int salto;

        for (salto = 0; salto < M; salto++) {
           hash = (hash(chave)+salto) % M;

           if(tabela[hash].getISBN().equals(chave))
                return tabela[hash];
        }
        return null;
    }
    public void put(Livro l) throws Exception{
        int hash;
        int salto;

        for(salto = 0; salto < M; salto++){
            hash = (hash(l.getISBN()) +salto) %M;
            if(tabela[hash] == null){
                tabela[hash] =  l;
                break;
            }
        }
        throw new Exception("Tabela Hash cheia!");
    }
    public Livro remove(String chave) {
        int hash;
        int salto;
        
        for (salto = 0; salto < M; salto++) {
            hash = (hash(chave) + salto) % M;
            if (tabela[hash] != null && tabela[hash].getISBN().equals(chave)) {
                Livro removido = tabela[hash];
                tabela[hash] = null;
                return removido;
            }
        }
        return null; // Se não encontrar o livro
    }
    
}