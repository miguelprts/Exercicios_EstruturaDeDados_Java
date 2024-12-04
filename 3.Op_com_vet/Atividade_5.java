public class Atividade_5 {
    public static void main(String[] args) {
        int[] vet = {0, 999, 1099, 1, 2, 4, -1, 990, 18};
        System.out.println("Ordenando o vetor: ");
        ordenar_sem_ordenar(vet);
    }

    public static void ordenar_sem_ordenar(int[] vet) {
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < vet.length; i++) {
            if (vet[i] < min) {
                min = vet[i];
            }
        }

        int ultimoImpresso = min;
        
        for (int count = 0; count < vet.length; count++) {
            int proximoMin = Integer.MAX_VALUE;
            boolean encontrouProximo = false;

            for (int j = 0; j < vet.length; j++) {
                if (vet[j] > ultimoImpresso && vet[j] < proximoMin) {
                    proximoMin = vet[j];
                    encontrouProximo = true;
                }
            }
            System.out.print(ultimoImpresso + " ");
            
            if (encontrouProximo) {
                ultimoImpresso = proximoMin;
            } else {
                break;
            }
        }
    }
}
