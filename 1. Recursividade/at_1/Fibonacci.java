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
            System.out.println(fibo(valor));
            count++;
       }
        teclado.close();
    }

    public static long fibo(long valor){
        long resultado = 0, p = 0, s = 0;
        for (long i = 1; i < valor; i++) {
            resultado = p + s;
            p = s;
            s = resultado;
        }
        return resultado;
    }
}