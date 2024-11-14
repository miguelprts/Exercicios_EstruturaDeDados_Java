public class Atividade_5 {
    public static void main(String[] args) {
        int[] vet = {0, 999, 1099, 1, 2, 4, -1, 990, 18};
        System.out.println("Ordenando o vetor: ");
        ordenar_sem_ordenar(vet);

    }
    public static void ordenar_sem_ordenar(int[] vet){
        int min = 0, max = 0;
        for (int i = 0; i < vet.length; i++) {
            for (int j = 0; j < vet.length; j++) {
                if(vet[i] < vet[j])
                    min = vet[i];
                if(vet[i] > vet[j])
                    max = vet[i];
            }
        System.out.println(""+ min + "|"+max);
        }
    }
}
