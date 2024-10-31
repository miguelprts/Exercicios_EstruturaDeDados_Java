//este é um algorítmo de complexidade Linear
public class Atividade2 {
    
    public static int[] operacao(int[] v){

        int primeiro = v[0], segundo = v[0], terceiro = v[0];

        for (int i = 0; i < v.length; i++) {
            if(v[i] > primeiro){
                terceiro = segundo;
                segundo = primeiro;
                primeiro = v[i];
            }
            else if(v[i] > segundo && v[i]!=primeiro && v[i]!=terceiro){
                terceiro = segundo;
                segundo = v[i];
            }
            else if(v[i] > terceiro && v[i]!=primeiro && v[i]!=segundo)
                terceiro = v[i];
        }
        int[] retorno = {primeiro, segundo, terceiro};
        return retorno;
    }

    public static void main(String[] args) {
        int[] vetor = {100, 100, 100};
        int[] resultado = operacao(vetor);

        System.out.println("1°: " + resultado[0] + ". 2°: "+ resultado[1] +". 3°: "+ resultado[2]);
    }
}
