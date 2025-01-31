package ex1;

public class Deque<T> {
    DequeObj<T> cabeca = new DequeObj<T>();
    int tamanho = 0;

    public void addInicio(T elemento){
        DequeObj<T> novo = new DequeObj<T>(elemento);

        if(verifica()){
            cabeca.setProximo(novo);
            cabeca.setAnterior(novo);
        }
        else{
            novo.setProximo(cabeca.getProximo());
            cabeca.getProximo().setAnterior(novo);
            novo.setAnterior(cabeca);
            cabeca.setProximo(novo);
        }
        tamanho++;
    }
    public void addFim(T elemento){
        DequeObj<T> novo = new DequeObj<T>(elemento);

        if(verifica()){
            cabeca.setProximo(novo);
            cabeca.setAnterior(novo);
        }
        else{
            novo.setAnterior(cabeca.getAnterior());
            cabeca.getAnterior().setProximo(novo);
            novo.setProximo(cabeca);
            cabeca.setAnterior(novo);           
        }
        tamanho++;
    }
    public T removeInicio() throws Exception{
        if(verifica())
            throw new Exception("Lista Vazia");
        
        T retorno = cabeca.getProximo().getElemento();
        cabeca.setProximo(cabeca.getProximo().getProximo());
        cabeca.getProximo().setAnterior(cabeca);
        tamanho--;
        return retorno;
    }   
    public T removeFim() throws Exception{
        if(verifica())
            throw new Exception("Lista Vazia");

        T retorno = cabeca.getAnterior().getElemento();
        cabeca.setAnterior(cabeca.getAnterior().getAnterior());
        cabeca.getAnterior().setProximo(cabeca);
        tamanho--;
        return retorno;
    }

    public boolean verifica(){
        return (tamanho == 0);
    }
}