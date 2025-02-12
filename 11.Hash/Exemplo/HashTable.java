import java.util.ArrayList;
import java.util.Iterator;

public class HashTable {
    public static final int M = 13;
    private ArrayList<Livro>[] tabela;
    public HashTable(){
        tabela = (ArrayList<Livro>[]) new ArrayList[M];
    }
    private int hash (String chave){
        int h = 0;
        for (int i = 0; i < chave.length(); ++i)
            h = (31 * h + chave.charAt(i)) % M;
        return h;
        // No lugar do multiplicador 31, poderia usar qualquer outro inteiro R, de preferência primo, mas suficientemente pequeno para que os cálculos não produzam overflow.
    }
    public Livro get(String chave){
        int hash = hash(chave);
        ArrayList<Livro> livros = tabela[hash];
        if (livros == null)
            return null;
        for(Livro livro: livros)
            if (livro.getISBN().equals(chave))
                return livro;
        return null;
    }
    public void put(Livro l){
        int hash = hash(l.getISBN());
        ArrayList<Livro> livros = tabela[hash];
        if (livros == null){
            livros = new ArrayList<Livro>();
            livros.add(l);
            tabela[hash] = livros;
        } else {
            // Conferir se já não existe na lista
            boolean achei = false;
            for (Livro livro : livros)
                if (livro.getISBN().equals(l.getISBN()))
                    achei = true;
            if (!achei)
                livros.add(l);
        }
    }
    public Livro remove(String chave) {
        int hash = hash(chave);
        ArrayList<Livro> livros = this.tabela[hash];
        
        Iterator<Livro> it = livros.iterator();
        Livro atual = null;
        
        while (it.hasNext()) {
            atual = it.next();
            if (atual.getISBN().equals(chave)) {
                it.remove();
                return atual;
            }
        }
        
        return null;
    }
    public void status(){
        for (int i=0;i<M;++i){
            if (tabela[i]!=null){
                ArrayList<Livro> liv = tabela[i];
                System.out.printf("A posição %d possui %d livros\n",i,liv.size());
            } else
                System.out.printf("A posição %d não possui livros cadastrados\n",i);
        }
    }
}
