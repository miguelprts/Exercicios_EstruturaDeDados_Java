package ex03;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Arvore arv = new Arvore();
        Scanner teclado = new Scanner(System.in);

        while(true){
            int qtdOpcoes = teclado.nextInt();
            teclado.nextLine();

            if(qtdOpcoes == 0)
                break;

            for(int i = 0; i < qtdOpcoes; i++){
                String input = teclado.nextLine();
                
                String[] inFormatado = input.split(" ");
                arv.inserir(Integer.parseInt(inFormatado[0]), Float.parseFloat(inFormatado[1]));
            }

            int qtdApostas = teclado.nextInt();
            teclado.nextLine();

            for (int i = 0; i < qtdApostas; i++) {
                int ano = teclado.nextInt();
                    teclado.nextLine();
                
                System.out.println(arv.conferir(ano) == true ? "Correto" : "Incorreto");
            }
        }
        teclado.close();
    }
}
