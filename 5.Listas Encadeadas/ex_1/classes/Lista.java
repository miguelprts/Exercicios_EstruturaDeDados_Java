package ex_1.classes;
import java.util.ArrayList;

public class Lista {
    No cabeca = new No(), cauda, novoNo;
    int tamanho = 0;

    // Método para inserir mantendo a ordem pelo código
    public void inserir(String nome, int codigo, long telefone) {
        novoNo = new No();
        novoNo.setElemento(new Cliente(codigo, nome, telefone));

        if (tamanho == 0) {
            adicionarNoInicio(novoNo);
        } else if (cabeca.getProximo().getElemento().getCodigo() > novoNo.getElemento().getCodigo()) {
            adicionarNoInicio(novoNo, cabeca.getProximo());
        } else {
            No atual = cabeca.getProximo();
            while (atual != null && atual.getElemento().getCodigo() < novoNo.getElemento().getCodigo()) {
                atual = atual.getProximo();
            }

            if (atual == null) {
                adicionarNoFim(novoNo);
            } else {
                adicionarEntre(novoNo, atual.getAnterior(), atual);
            }
        }
    }

    // Método para adicionar no início
    public void adicionarNoInicio(No no) {
        no.setAnterior(cabeca);
        cabeca.setProximo(no);
        tamanho++;
        if (tamanho == 1) {
            cauda = no;
            no.setProximo(null);
        }
    }

    // Sobrecarga  de adicionarNoInicio para adicionar entre a cabeça e outro nó
    public void adicionarNoInicio(No no, No noProximo) {
        no.setProximo(noProximo);
        noProximo.setAnterior(no);
        cabeca.setProximo(no);
        no.setAnterior(cabeca);
        tamanho++;
    }

    // Método para adicionar no fim da lista
    public void adicionarNoFim(No no) {
        no.setAnterior(cauda);
        cauda.setProximo(no);
        cauda = no;
        tamanho++;
    }

    // Método para adicionar entre um nó e outro
    public void adicionarEntre(No no, No anterior, No proximo) {
        no.setAnterior(anterior);
        no.setProximo(proximo);
        anterior.setProximo(no);
        proximo.setAnterior(no);
        tamanho++;
    }

    //Método que retorna os clientes da lista.
    public ArrayList<Cliente> exibir() {
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        No atual = cabeca.getProximo(); 

        while (atual != null) {
            listaClientes.add(atual.getElemento()); 
            atual = atual.getProximo(); 
        }
        return listaClientes; 
    }
}