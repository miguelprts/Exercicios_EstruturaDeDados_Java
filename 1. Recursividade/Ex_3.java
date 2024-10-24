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

        if(n<=1)
            System.out.println("Não tem número primo para " + n+".");
        else{
            boolean ePrimo = realizarCalculo(n);
            System.out.println((ePrimo)? n + " é primo!" : n + " não é primo!"); 
        }
        teclado.close();
    }

    public static boolean realizarCalculo(int n){
        return calculo(n, n-1);
    }

    public static boolean calculo(int num, int divisor){
       // se algum número sem ser 1, ou o próprio n até aquele valor, tiver resto 0, ele n é primo
       if(divisor == 1)
            return true; 
       else if(num%divisor == 0){
            return false;
       } 
       else if(num < 2){
            return false;
       }      
        return calculo(num, divisor-1);       
    } 
}