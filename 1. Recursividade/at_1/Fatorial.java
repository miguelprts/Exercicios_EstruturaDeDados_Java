package at_1;
import java.util.Scanner;

public class Fatorial {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        long valor = 0;
        try {
            System.out.print("Insira um número inteiro: ");
            valor = teclado.nextLong();
        } catch (Exception e) {
            System.out.println("Insira um número inteiro!");
            System.exit(1);
        }    
        System.out.printf("%d! = %d", valor, fatorial(valor));
        teclado.close();
    }

    public static long fatorial(long valor){
        long resultado = 1;
        if(valor < 0){
            throw new Error("Insira números positivos");
        }
        else{
            for(long i = valor; i > 0; i--){
                resultado *= i;
            }
        }
        return resultado;
    }
}
