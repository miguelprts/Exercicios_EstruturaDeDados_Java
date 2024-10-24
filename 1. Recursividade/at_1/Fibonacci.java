package at_1;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        long valor = 0;
        try {
            System.out.println("Insira um número inteiro: ");
            valor = teclado.nextLong();
        } catch (Exception e) {
            System.out.print("Insira um número inteiro!");
            System.exit(1);
        }

        int count = 0;
        while (count < valor) {
            System.out.println(fibo(count));
            count++;
        }
        teclado.close();
    }

    public static long fibo(long valor) {
        if (valor == 0) return 0;
        if (valor == 1) return 1;
        long p = 0, s = 1, resultado = 0;
        for (long i = 2; i <= valor; i++) {
            resultado = p + s;
            p = s;
            s = resultado;
        }
        return resultado;
    }
}
