import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Estacao estacao;

        //testes
        while(true){
            int nVagoes = teclado.nextInt();
            teclado.nextLine(); 

            if(nVagoes == 0)
                break;

            //rearranjar
            while (true) {
                String val = teclado.nextLine();
                if(val.equals("0"))
                    break;

                String[] stringValores = val.replaceAll(" ", "-").split("-");

                int[] valoresDeSaida = new int[stringValores.length];
                for(int i = 0; i < valoresDeSaida.length; i++) {
                    valoresDeSaida[i] = Integer.parseInt(stringValores[i]);
                }
                estacao = new Estacao(nVagoes);
                boolean verifica = estacao.comparar(nVagoes, valoresDeSaida);

                if(verifica)
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }            
        }
    teclado.close();
    }
}