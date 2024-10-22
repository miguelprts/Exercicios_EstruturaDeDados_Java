import java.util.Scanner;

public class Ex_2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Potência de 2! Informe um número inteiro: ");
        long n = 0;

        try {
          n = teclado.nextLong();  
        } catch (Exception e) {
            System.err.println("Informe um número inteiro!");
            System.exit(1);
        }

        long resultado = calculo(n, 2);
        System.out.println("2^" + n +" = " + resultado);

        teclado.close();
    }

    public static long calculo(long n, long resultado){
        if(n == 1)
            return resultado;

        return calculo(n-1, resultado*2);
    } 
}