package ex2;

import java.util.LinkedList;
import java.util.Queue;

public class Arvore {
    Altura raiz = null;

    public void adicionar(int valor){
        Altura nova = new Altura(valor);
        if(raiz == null)
            raiz = nova; 
        else
            adicionar(nova, raiz);
    }

    private void adicionar(Altura nova, Altura valorAtual){
        if(valorAtual.valor > nova.valor){
            if(valorAtual.esquerda != null)
                adicionar(nova, valorAtual.esquerda);
            else 
                valorAtual.esquerda = nova;
        }
        else if(valorAtual.valor < nova.valor){
            if(valorAtual.direita != null)
                adicionar(nova, valorAtual.direita);
            else 
                valorAtual.direita = nova;               
        }
    }  

    public void imprimir() {
        if (raiz == null) {
            System.out.println("Árvore vazia!");
            return; 
        }
        
        Queue<Altura> fila = new LinkedList<>();
        fila.add(raiz); 
        imprimir(0, fila); 
    }

    private void imprimir(int nivel, Queue<Altura> fila) {
        if (fila.isEmpty()) return; 

        int tamanhoNivel = fila.size();
        int menorNivel = Integer.MAX_VALUE;

        for (int i = 0; i < tamanhoNivel; i++) {
            Altura no = fila.poll(); 
            menorNivel = Math.min(menorNivel, no.valor); 

            if (no.esquerda != null) {
                fila.add(no.esquerda);
            }
            if (no.direita != null) {
                fila.add(no.direita);
            }
        }

        System.out.println(nivel + " " + menorNivel);

        imprimir(nivel + 1, fila); 
    }
}