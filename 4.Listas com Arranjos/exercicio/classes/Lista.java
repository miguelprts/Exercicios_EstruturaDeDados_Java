package classes;

public class Lista {
    public Candidato[] lista;
    private int tamanho = 10;
    private int ultimaPosicao = -1;
    private int nInsc = 1;

    public Lista(){
        lista = new Candidato[tamanho];
    }

    public void adicionar(String nome, int nota){
        Candidato novCandidato = new Candidato(nome, nInsc, nota);
        nInsc++;

        if(ultimaPosicao == -1){
            ultimaPosicao = 0;
        }
        else if(ultimaPosicao >= tamanho){
           aumentarLista();
        }

        lista[ultimaPosicao] = novCandidato;
        ultimaPosicao++;
    }

    private void aumentarLista(){
        Candidato[] novaLista = new Candidato[tamanho*2];
        for (int i = 0; i < tamanho; i++) {
            novaLista[i] = lista[i];
        }
        lista = novaLista;
        tamanho*=2;
    }
    
    public void remover(int nInsc){
        Candidato c;
        int pos = -1;

        for(int i = 0; i < tamanho; i++){
            if(lista[i].getInscricao() == nInsc){
                c = lista[i];
                pos = i;
                break;
            }
        }
        
        for (int i = pos; i < ultimaPosicao; i++) {
            lista[i] = lista[i+1];
        }     
        ultimaPosicao--;   
    }

    public Candidato[] consultar(String nome){
        int tam = 0;
        for(int i = 0; i < ultimaPosicao; i++){
            if(lista[i].getNome().equals(nome))
                tam ++;
        }
        if(tam == 0){
            return null;
        }
        else{
            Candidato[] listaConsultas = new Candidato[tam];
            int pos = 0;

            for (int i = 0; i < ultimaPosicao; i++) {
                if(lista[i].getNome().equals(nome)){
                    listaConsultas[pos] = lista[i];
                    pos++;
                }
            }
            return listaConsultas;
        }
    }
}