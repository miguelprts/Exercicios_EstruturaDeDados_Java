import java.util.Scanner;
public class Ex_3 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int n = 0;

        System.out.print("Informe um número: ");
        try {
            n = teclado.nextInt();
        } catch (Exception e) {
            System.out.println("Informe um número!!!");
            System.exit(1);
        }

        boolean ePrimo = calculo(n, n-1);

        System.out.println((ePrimo)? n + " é primo!" : n + " não é primo!"); 

        teclado.close();
    }

    public static boolean calculo(int n, int i){
       // se algum número sem ser 1, ou o próprio n, até aquele valor tiver resto 0, ele n é primo

       
    } 
}
