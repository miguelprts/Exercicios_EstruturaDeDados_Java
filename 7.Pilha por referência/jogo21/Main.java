import java.util.Random;
import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
        Random random = new Random();
        Scanner teclado = new Scanner(System.in);
        Jogador j1 = new Jogador();
        Jogador j2 = new Jogador();

        System.out.println("Jogador 1: ");

        while(j1.pontuacao < 21){
            int valor = random.nextInt(10) + 1;
            j1.push(valor);
            System.out.println("Sua carta foi: "+valor+". Você possui "+ j1.pontuacao+" pontos.");

            if(j1.pontuacao >= 21){
                if(j1.pontuacao > 21)
                    System.out.println("Penalidade aplicada!");
                break;
            }

            System.out.println("Deseja continuar? Digite: \n1.Sim\n2.Não");

            int escolha = teclado.nextInt();
            
            if(escolha == 2)
                break;
        }

        System.out.println("\nJogador 2: ");

        while(j2.pontuacao < 21){
            int valor = random.nextInt(10) + 1;
            j2.push(valor);
            System.out.println("Sua carta foi: "+valor+". Você possui "+ j2.pontuacao+" pontos.");
        
            if(j2.pontuacao >= 21){
                if(j2.pontuacao > 21)
                    System.out.println("Penalidade aplicada!");
            break;
            }

            System.out.println("Deseja continuar? Digite: \n1.Sim\n2.Não");

            int escolha = teclado.nextInt();
            
            if(escolha == 2)
                break;
        }

        try {
            System.out.println("Cartas do jogador 1:");

        while(j1.tamanho != 0)
            System.out.print(j1.pop().getValor() + "| ");


        System.out.println("\nCartas do jogador 2:");
        while(j2.tamanho != 0)
            System.out.print(j2.pop().getValor() + "| ");

        } catch (Exception e) {
            System.out.println("Erro: "+ e.getMessage());
        }

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
             
        System.out.println("Jogador 1: "+j1.pontuacao + ". Jogador 2: "+j2.pontuacao+".");
    teclado.close();
    }
}