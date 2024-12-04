public class Atividade_2 {
    public static void main(String[] args) {
        int[] vet = new int[100];
        int ultimaPosicao = -1;

        for (int i = 0; i < vet.length; i++) {
            int n = (int)((Math.random()*100)+1);
            int op = (int)(Math.random()*3)+1;

            switch(op){
                case 1: 
                    vet = inicio(vet, i, ultimaPosicao, n);
                    break;
                case 2: 
                   vet = fim(vet, n, ultimaPosicao);
                    break;
                case 3: 
                    vet = meio(vet, n, i, ultimaPosicao);
                    break;
            }
            ++ultimaPosicao;
        }

        for (int i = 0; i < vet.length; i++) {
            System.out.println(""+i+": "+vet[i]);
        }
    }
    public static int[] inicio(int[] vet, int pos, int ultimaPosicao, int n){
        for (int i = ultimaPosicao +1; i > 0; --i )
            vet [i] = vet [i-1];
        vet [0] = n;
        return vet;
    }

    public static int[] fim(int [] vet, int n, int ultimaPosicao){
        vet[++ultimaPosicao] = n ;
        return vet;
    }

    public static int[] meio(int[] vet , int elemento , int pos, int ultimaPosicao){
            for ( int i = ultimaPosicao +1; i > pos; --i)
                vet [i]= vet [i -1];
            vet [pos] = elemento ;
        return vet;
    }
}
