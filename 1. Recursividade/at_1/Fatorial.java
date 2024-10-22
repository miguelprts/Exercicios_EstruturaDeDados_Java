package at_1;
import java.util.Scanner;

public class Fatorial {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        long valor = 0, resultado = 1;

        try {
            System.out.print("Insira um número inteiro: ");
            valor = teclado.nextLong();

        } catch (Exception e) {
            System.out.println("Insira um número inteiro!");
            System.exit(1);

        }

        for(long i = valor; i > 0; i--){
            resultado *= i;
        }
    
        System.out.printf("%d! = %d", valor, resultado);
        teclado.close();
    }
}
