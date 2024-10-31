public class Atividade1 {
// tal algoritmo possui complexidade assintótica Linear.
    public static void main(String[] args) {
        int[] vetor = {0, 3, 99,999, 1099, 13, -9, 55};
        int[] resultado = operacao(vetor);

        System.out.println("Menor: " + resultado[0] + ". Maior: "+ resultado[1]);
    }

    public static int[] operacao(int[] v){
        int menor = v[0], maior = v[0];
        for(int i = 0; i < v.length; i++){
            if(v[i] < menor)
                menor = v[i];
            else if(v[i] > maior)
                maior = v[i];
            else
                continue;
        }
        int[] retorno = {menor, maior};
        return retorno;
    }
    
}