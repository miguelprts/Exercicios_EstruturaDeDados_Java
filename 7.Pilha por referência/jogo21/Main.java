import java.util.Random;
import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Jogador j1 = new Jogador();
        Jogador j2 = new Jogador();

        System.out.println("Jogador 1: ");
        jogar(j1, teclado);

        System.out.println("\nJogador 2: ");
        jogar(j2, teclado);

            System.out.println("\nCartas do jogador 1:");
                imprimirCartas(j1);
            System.out.println("\nCartas do jogador 2:");
                imprimirCartas(j2);

            System.out.println("\n");

        if(j2.pontuacao == j1.pontuacao)
            System.out.println("Empate!");
        else if(j1.pontuacao > 21 && j2.pontuacao > 21)
            System.out.println("Ambos perderam!");
        else if(j1.pontuacao > j2.pontuacao){
            if(j1.pontuacao > 21)
                System.out.println("Jogador 2 ganhou!");
            else
                System.out.println("Jogador 1 ganhou!");
        }
        else if(j2.pontuacao > j1.pontuacao){
            if(j2.pontuacao > 21)
                System.out.println("Jogador 2 ganhou!");
            else
                System.out.println("Jogador 1 ganhou!");
        }
             
        System.out.println("\nJogador 1: "+j1.pontuacao + " pontos. Jogador 2: "+j2.pontuacao+" pontos.");
        teclado.close();
    }

    public static void jogar(Jogador j, Scanner teclado){
        Random random = new Random();

        for (int i = 0; i < 2; i++) {
            int n = random.nextInt(10) + 1;
            j.push(n);
            System.out.println("Você começou com a "+(i+1)+"° carta sendo: "+ n);
        }
        while(j.pontuacao < 21){
            System.out.println("Você possui "+ j.pontuacao+" pontos. Deseja continuar? Digite: \n1.Sim\n2.Não");

            int escolha = -1;

            while (true) {
                if (teclado.hasNextInt()) {
                    escolha = teclado.nextInt();
                    if (escolha == 1 || escolha == 2)
                        break;
                    else
                        System.out.println("Entrada inválida! Por favor, digite 1 (Sim) ou 2 (Não).");
                } else {
                    System.out.println("Entrada inválida! Por favor, digite 1 (Sim) ou 2 (Não).");
                    teclado.next();
                }
            }

            if(escolha == 2)
                break;

            int valor = random.nextInt(10) + 1;
            j.push(valor);
            System.out.println("Sua carta foi: "+valor+".");

            if(j.pontuacao >= 21){
                if(j.pontuacao > 21)
                    System.out.println("Penalidade aplicada, pois você passou de 21 pontos!");
                break;
            }
        }
    }

    public static void imprimirCartas(Jogador j){
        try{
            while(j.tamanho != 0)
                System.out.print(j.pop().getValor() + "| ");
        }catch (Exception e) {
            System.out.println("Erro: "+ e.getMessage());
        }

    }
}