public class Atividade_6 {
    public static int[] preencher(int[] v1, int[] v2){
        int[] vet = new int[v1.length-1];
        int ultimaPosicao = -1;

        int i_v1 = 0, i_v2 = 0;

        for (int i = 0; i < vet.length; i++) {
            int opc = (int)(Math.random() * 2) +1;
            if(opc == 1){
                vet[++ultimaPosicao] = v1[i_v1];
                ++i_v1;
            }
            else{
                vet[++ultimaPosicao] = v2[i_v2];
                ++i_v2;
            }
        }
        return vet;
    }

    public static void main(String[] args) {
        int[] v1 = {0, 1, 2, 3, 4, 5};
        int[] v2 = {5, 7, 8, 9, 10, 11};

        int[] v = preencher(v1, v2);

        for (int i = 0; i < v.length; i++) {
            System.out.println(v[i]);            
        }
    }
}
