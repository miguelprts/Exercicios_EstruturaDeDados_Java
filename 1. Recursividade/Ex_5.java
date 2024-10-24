import java.util.Scanner;

public class Ex_5 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int n1 = 0, n2 = 0;
            
        System.out.println("Insira dois números inteiros: ");
        try {
            n1 = teclado.nextInt();
            n2 = teclado.nextInt();
        } catch (Exception e) {
        System.out.println("Insira números inteiros!");        
        }
            int resultado = calculo(n1, n2);
            System.out.printf("MDC(%d, %d) = %d", n1, n2, resultado);
        teclado.close();
    }

    public static int calculo(int n1, int n2){
        if(n1 >= n2 || n1%n2 == 0)
            return n2;
        else if(n1 == 0 || n2==0)
            throw new Error("Não há MDC para 0");
        else if(n1 < n2)
            return calculo(n2, n1);
        else
            return calculo(n2, n1%n2);
}
}