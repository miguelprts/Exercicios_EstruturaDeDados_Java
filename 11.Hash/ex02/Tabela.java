package ex02;
import java.util.ArrayList;

public class Tabela {
    public static final int M = 17;
    private ArrayList<Time>[] tabela;
    public Tabela(){
        tabela = (ArrayList<Time>[]) new ArrayList[M];
    }
    private int hash(String codigo){
        int retorno = 0;
        for(int i = 0; i < codigo.length(); ++i){
            retorno = (31*retorno+codigo.charAt(i)) % M;
        }
        return retorno;
    }
    public void add(Time t){
        int hash = hash(t.getCodigo());
        ArrayList<Time> elemento = tabela[hash];
        if(elemento == null){
            elemento = new ArrayList<Time>();
            elemento.add(t);
            tabela[hash] = elemento;
        }
        else{
            boolean verifica = false;
            for (Time time : elemento)
                if (time.getCodigo().equals(t.getCodigo())) 
                    verifica = true;
            if(!verifica)
                elemento.add(t);
        }
    }
    public Time remove(String codigo){
        int hash = hash(codigo);
        ArrayList<Time> times = this.tabela[hash];
        Time retorno = null;

        for(Time time : times){
            if(time.getCodigo().equals(codigo)){
            retorno = time;
            times.remove(time);
            }
        }
        return retorno;
    }
    public Time get(String codigo){
        int hash = hash(codigo);
        ArrayList<Time> times = tabela[hash];
        if(times == null)
            return null;
        for(Time t : times)
            if(t.getCodigo().equals(codigo))
                return t;
        return null;
    }
}
