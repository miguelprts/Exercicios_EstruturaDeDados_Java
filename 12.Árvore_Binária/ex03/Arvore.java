package ex03;

public class Arvore {
    Ano raiz = null;

    public void inserir(int ano, float temp){
        Ano novo = new Ano(ano, temp);
        if(raiz == null)
            raiz = novo;

        else
            inserir(novo, raiz);
    }
    private void inserir(Ano novo, Ano noAtual){
        if(novo.getTemp() > noAtual.getTemp()){
            if(noAtual.getDireita() !=null)
                inserir(novo, noAtual.getDireita());
            else
                noAtual.setDireita(novo);
        } 
        else if(novo.getTemp() < noAtual.getTemp()){
            if(noAtual.getEsquerda() !=null)
                inserir(novo, noAtual.getEsquerda());
            else
                noAtual.setEsquerda(novo);
        }
    }
    public boolean conferir(int ano){
       Ano anoAtual = raiz;
       while (anoAtual.getDireita()!=null) {
            anoAtual = anoAtual.getDireita();
       }
       if(anoAtual.getAno() == ano)
            return true;
       else
            return false;
    }
}
