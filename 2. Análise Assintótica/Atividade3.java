public class Atividade3 {
    public static boolean operacao(int[] v, int valor, int inicio, int fim){
        if(inicio > fim)
            return false;

        int meio = (inicio + fim) / 2;

        if(valor == v[meio])
            return true;
        else if(valor > v[meio])
            return operacao(v, valor, meio+1, fim);
        else
            return operacao(v, valor, inicio, meio-1);
              
    }

    public static void main(String[] args) {
        int[] v = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        boolean o = operacao(v, 11, 0, v.length-1);

        System.out.println(o);
    }
}
