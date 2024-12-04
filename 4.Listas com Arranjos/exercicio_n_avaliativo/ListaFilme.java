package exercicio_n_avaliativo;

public class ListaFilme {
    private Filme[] lista;
    private int tamanho;
    private int ultimo = -1;

    // Construtor para inicializar a lista
    public ListaFilme(int tamanhoInicial) {
        this.lista = new Filme[tamanhoInicial];
        this.tamanho = tamanhoInicial;
    }

    public void add(Filme filme, int indice) throws Exception {
        if (ultimo >= lista.length - 1) { // Lista cheia
            lista = aumentarLista(); // Duplicar tamanho
        }
        if (indice < 0 || indice > ultimo + 1) {
            throw new Exception("Índice inválido!");
        }

        // Ajustar posição para inserção
        if (indice <= ultimo) {
            for (int i = ultimo; i >= indice; i--) {
                lista[i + 1] = lista[i]; // Deslocar elementos
            }
        }
        lista[indice] = filme;
        ultimo++;
    }

    public void remove(int indice) throws Exception {
        if (indice < 0 || indice > ultimo) {
            throw new Exception("Índice inválido!");
        }
        for (int i = indice; i < ultimo; i++) {
            lista[i] = lista[i + 1]; // Deslocar elementos para esquerda
        }
        lista[ultimo] = null; // Limpar última posição
        ultimo--;
    }

    private Filme[] aumentarLista() {
        tamanho *= 2; // Dobrar tamanho
        Filme[] listaNova = new Filme[tamanho];
        for (int i = 0; i <= ultimo; i++) {
            listaNova[i] = lista[i];
        }
        return listaNova;
    }

    public Filme localizar(Filme filme) {
        for (int i = 0; i <= ultimo; i++) {
            if (lista[i] != null && lista[i].getTitulo().equals(filme.getTitulo())) {
                return lista[i];
            }
        }
        return null; // Filme não encontrado
    }
}
