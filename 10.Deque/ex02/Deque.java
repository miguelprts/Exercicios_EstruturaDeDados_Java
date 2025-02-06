package ex02;

public class Deque<T> {

    int tamanho = 0;
    ObjDoDeque<T> cabeca = new ObjDoDeque<T>();

    public void addInicio(T elemento){
        ObjDoDeque<T> novo = new ObjDoDeque<T>(elemento);
        if(tamanho == 0){
            cabeca.setProximo(novo);
            cabeca.setAnterior(novo);
            novo.setAnterior(cabeca);
            novo.setProximo(cabeca);
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
        ObjDoDeque<T> novo = new ObjDoDeque<T>(elemento);
        if(tamanho == 0){
            addInicio(elemento);
        }

        else{
            novo.setAnterior(cabeca.getAnterior());
            cabeca.getAnterior().setProximo(novo);
            novo.setProximo(cabeca);
            cabeca.setAnterior(novo);
            tamanho++;
        }
    }
    public T removerInicio() throws Exception{
        if(tamanho == 0)
            throw new Exception("Vazio!");
        
        T retorno = cabeca.getProximo().getElemento();
        cabeca.setProximo(cabeca.getProximo().getProximo());
        cabeca.getProximo().setAnterior(cabeca);
        tamanho--;
        return retorno;
    }   
    public T removerFim() throws Exception{
        if(tamanho == 0)
            throw new Exception("Vazio!");
    
        T retorno = cabeca.getAnterior().getElemento();
        cabeca.setAnterior(cabeca.getAnterior().getAnterior());
        cabeca.getAnterior().setProximo(cabeca);
        tamanho--;
        return retorno;
    }
}
