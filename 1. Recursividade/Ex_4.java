import java.util.Scanner;

public class Ex_4 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe dois números: ");
        int n1=0, n2=0;
        try {
            n1 = teclado.nextInt();
            n2 = teclado.nextInt();
        } catch (Exception e) {
            System.out.println("Insira um número inteiro! ");
        }
        int resultado = calculo(n1, n2);
        System.out.printf("\n%d*%d = %d",n1,n2, resultado);
        teclado.close();
    }
    public static int calculo(int n1, int n2){
        if (n2 < 0) {
            return -calculo(n1, -n2);
        }
        else if(n2 == 1)
            return n1;
        return n1 + calculo(n1, n2-1);
    }
}