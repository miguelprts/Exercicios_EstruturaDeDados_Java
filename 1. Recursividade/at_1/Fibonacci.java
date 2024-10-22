package at_1;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        long valor = 0, resultado = 0;

        try {
            System.out.println("Insira um número inteiro: ");
            valor = teclado.nextLong();
        } catch (Exception e) {
            System.out.print("Insira um número inteiro!");
            System.exit(1);
        }

        long p = 0, s = 1;

        for (long i = 1; i < valor; i++) {

            resultado = p + s;
            p = s;
            s = resultado;
        }

        System.out.printf("fibo(%d) = %d", valor, resultado);

        teclado.close();
    }

}