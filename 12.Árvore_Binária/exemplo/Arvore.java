package exemplo;

@SuppressWarnings("rawtypes")
public class Arvore<T extends Comparable>{
    No<T> raiz = null;

    // método que apenas chama o inserir
    public void adicionar(T valor){
        No<T> novo = new No<T>(valor);
        adicionar(novo, raiz);
    }
    @SuppressWarnings("unchecked")  
    private void adicionar(No<T> novo, No<T> noAtual){
        if(noAtual == null)
            raiz = novo;
        else{
            if(novo.getElemento().compareTo(noAtual) == -1){
                if(noAtual.getEsquerda() != null)                    
                    adicionar(novo, noAtual.getEsquerda());
                else 
                    noAtual.setEsquerda(novo);
            }
            else if(novo.getElemento().compareTo(noAtual) == 1){
                if(noAtual.getDireita() != null)                    
                    adicionar(novo, noAtual.getDireita());
                else 
                    noAtual.setDireita(novo);
            }
        }
    }
    public void remover(T valor) throws Exception{
        remover(valor, raiz, null);
    }

    @SuppressWarnings("unchecked")
    private No remover(T valor, No<T> noAtual, No<T> noPai) throws Exception{
            if(noAtual == null) throw new Exception("Valor não registrado!");
           
            //se o nó atual não for nulo (ou seja, ainda está sendo procurado);
            else {
                if(noAtual.getElemento().compareTo(valor) == -1)    
                    noAtual.setEsquerda(remover(valor, noAtual.getEsquerda(), noAtual));

                else if(noAtual.getElemento().compareTo(valor) == 1)
                    noAtual.setDireita(remover(valor, noAtual.getDireita(), noAtual));

                else{
                    //se for folha
                    if(noAtual.getDireita() == null && noAtual.getEsquerda() == null){
                        if (noPai.getEsquerda() == noAtual) {
                            noPai.setEsquerda(null);
                        } else {
                            noPai.setDireita(null);
                        }          
                    }
                    //se o elemento tiver dois filhos
                    else if(noAtual.getDireita() != null && noAtual.getEsquerda() != null){
                       
                        //pegar o nó mais à esquerda da subárvore direita
                        No<T> sucessor = noAtual.getDireita();
                        while (sucessor.getEsquerda() != null) { 
                            sucessor = sucessor.getEsquerda();
                        }
                        noAtual.setElemento(sucessor.getElemento());
                        remover(sucessor.getElemento(), noAtual.getDireita(), noAtual);
                    }  
                    //se o elemento tiver um filho só              
                    else{
                        No noFilho = (noAtual.getEsquerda()!=null) ? noAtual.getEsquerda() : noAtual.getDireita();
                        if(noPai == null)
                            raiz = noFilho;
                        else if(noPai.getEsquerda() == noAtual)
                            noPai.setEsquerda(noFilho);
                        else
                            noPai.setDireita(noFilho);
                    }
                }
            }
        return noAtual;
    }

    public boolean naoTaVazio(){
        return this.raiz != null;
    }

    public void ordem(No<T> no){
        if(no != null){
            ordem(no.getEsquerda());
            //realiza as operações
            ordem(no.getDireita());
        }
    }
    public void preOrdem(No<T> no){
        if(no != null){
             //realiza as operações
            preOrdem(no.getEsquerda());
            preOrdem(no.getDireita());
        }
    }
    public void posOrdem(No<T> no){
        if(no != null){
           posOrdem(no.getEsquerda());
           posOrdem(no.getDireita());
           //realiza as operações

       }
    }
}

//pre ordem: cima, esquerda, direita (Raiz, nó à esquerda, nó à direita)
//ordem: esquerda, cima, direita. (Nó à esquerda, raiz, nó à direita)
//pos ordem: esquerda, direita, cima.
