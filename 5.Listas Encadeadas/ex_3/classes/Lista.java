package ex_3.classes;

public class Lista {
    public No novoNo, cabeca = new No(), cauda = null;
    int tamanho = 0;  

    public void adicionar(String nome, String pais, String atrativos, int nota) {
        
        novoNo = new No();
        novoNo.setElemento(new Cidade(nome, pais, atrativos, nota));
    
        // Caso a lista esteja vazia
        if (tamanho == 0) {
            cabeca.setProximo(novoNo);
            novoNo.setAnterior(cabeca);
            cauda = novoNo;
        } 
        // nota maior que a primeira
        else if (cabeca.getProximo() == null || cabeca.getProximo().getElemento().getNota() < nota) {
            adicionarNoInicio();
        } 
        // Inserção no meio ou final
        else {
            No noAtual = cabeca.getProximo();
    
            // encontra a posição correta para inserir
            while (noAtual != null && noAtual.getElemento().getNota() >= nota) {
                noAtual = noAtual.getProximo();
            }
    
           //inserir no final
            if (noAtual == null) {
                cauda.setProximo(novoNo);
                novoNo.setAnterior(cauda);
                cauda = novoNo; 
            } 
            // Caso o nó seja inserido entre dois nós
            else {
                novoNo.setAnterior(noAtual.getAnterior());
                novoNo.setProximo(noAtual);
                noAtual.getAnterior().setProximo(novoNo);
                noAtual.setAnterior(novoNo);
            }
        }
        tamanho++; 
    }
    
    public void remover(No no){
        if(no.getAnterior() == cabeca){
            if(no.getProximo() == null){
                cabeca.setProximo(null);
                cauda = null;
            }
            else{
                cabeca.setProximo(no.getProximo());
                no.getProximo().setAnterior(cabeca);
            }
        }
        //se for a cauda
        else if(no.getProximo() == null){
            cauda = no.getAnterior();
            no.getAnterior().setProximo(null);
        }
        else{
        no.getAnterior().setProximo(no.getProximo());
        no.getProximo().setAnterior(no.getAnterior());
        }

        tamanho--;
    }

    private void adicionarNoInicio() {
        novoNo.setProximo(cabeca.getProximo());
        if (cabeca.getProximo() != null) {
            cabeca.getProximo().setAnterior(novoNo);
        }
        cabeca.setProximo(novoNo);
        novoNo.setAnterior(cabeca);
    
        // Atualiza a cauda caso seja o único elemento
        if (cauda == null) {
            cauda = novoNo;
        }
        tamanho++;
    }
}