public class Atividade_1 {
    public static void main(String[] args) {
        int[] vet = new int[10];

        for(int i = 0; i < 10; i++) {
            vet[i] = (int)(Math.random()*100)-1;
            System.out.println("" + i + ": " + vet[i]);
        }
        int ultimaPosicao = 9;

        for(int i = 0; i < 10; i++){
            if(vet[i]%2==0 && vet[i] != 0){
                vet = excluir(vet, i, ultimaPosicao);
                --ultimaPosicao;
               i--;
            }
        }
        System.out.println("\nRemovendo os n° pares, temos: ");
        for(int i = 0; i <= ultimaPosicao; i++)
            System.out.println(vet[i]);
    }

    public static int[] excluir(int[] vet, int pos, int ultimaPosicao){
        for(int i = pos; i < ultimaPosicao; i++){
            vet[i] = vet[i+1];
        }
        return vet;       
    }  
}