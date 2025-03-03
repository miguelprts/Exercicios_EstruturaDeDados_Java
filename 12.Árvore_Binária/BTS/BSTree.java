public class BSTree {
    Node raiz = null;
    public void inserir (Node no, int valor){
        if (no!=null){
            if (valor < no.valor){
                if (no.esquerda != null)
                    inserir(no.esquerda, valor);
                else
                    no.esquerda = new Node(valor);
            }else{
                if (no.direita!=null)
                    inserir(no.direita, valor);
                else
                    no.direita = new Node(valor);
            }
        } else {
            raiz = new Node(valor);
        }
    }
    public Node remover(int valor) throws Exception{
        return remover(this.raiz,valor);
    }
    private Node remover(Node no, int valor)throws Exception{
        boolean ajuste = false;
        if (no == null) throw new Exception("Valor não encontrado");
        if (this.raiz == null) throw new Exception("Árvore vazia");
        else{
            if (valor < no.valor){
                no.esquerda = remover(no.esquerda,valor);
            } else if (valor > no.valor){
                no.direita = remover(no.direita,valor);
            } else { // achamos
                // Se ele tiver dois filhos
                if (no.direita!= null && no.esquerda!=null){
                    // O substituto será o menor da arvore direita (sucessor)
                    no.valor = minimo(no.direita).valor; 
                    // Removemos o mínimo da subarvore da direita
                    // Que agora é a raiz desa subarvrore
                    no.direita = removeMinimo(no.direita);
                } else { // ele só tem um filho, o filho o substitui
                    // Caso o no seja a raiz com filho só para um lado
                    // Precisamos atualizar o ponteiro da raiz
                    if (no == raiz){
                       ajuste = true;
                    }
                    no = (no.esquerda!=null) ? no.esquerda : no.direita;
                    if (ajuste) raiz = no;
                }
            }
            return no;
        }
    }
    // retorna o menor no de uma subarvore
    private Node minimo(Node no) throws Exception{
        if (no==null)
            throw new Exception ("Raiz nula");
        if (no.esquerda!=null)
            return minimo(no.esquerda);
        else
            return no;
    }
    // Remove o menor no de uma subarvore
    private Node removeMinimo(Node no)throws Exception{
        if (no == null) 
            throw new Exception("Raiz nula");
        else 
            if (no.esquerda!=null){
                no.esquerda = (removeMinimo(no.esquerda));
                return no;
            }else{
                return no.direita;
            }
    }

    public void preOrdem (Node no){
        if (no!=null){
            System.out.print(no + " ");
            preOrdem(no.esquerda);
            preOrdem(no.direita);
        }
    }
    public void inOrdem(Node no){
        if (no!=null){
            inOrdem(no.esquerda);
            System.out.print(no + " ");
            inOrdem(no.direita);
        }
    }
    public void posOrdem(Node no){
        if (no!=null){
            posOrdem(no.esquerda);
            posOrdem(no.direita);
            System.out.print(no + " ");
        }
    }
}
