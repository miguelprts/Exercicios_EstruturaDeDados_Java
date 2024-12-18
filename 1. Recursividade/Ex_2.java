import java.util.Scanner;

public class Ex_2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Potência de 2! Informe um número inteiro: ");
        long n = 0;

        try {
          n = teclado.nextLong();  
        } catch (Exception e){
            System.err.println("Informe um número inteiro!");
            System.exit(1);
        }

        long resultado = 0;
            resultado = chamarCalculo(n);

        System.out.println("2^" + n +" = " + resultado);
        teclado.close();
    }
    public static long chamarCalculo(long n){
        return calculo(n, 2);
    } 
    private static long calculo(long n, long resultado){
        if(n == 0)
            return 1;
        else if(n == 1)
            return resultado;
        else if(n < 0){
            throw new Error("Insira apenas números positivos");
        }
        else
            return calculo(n-1, resultado*2);
    } 
}