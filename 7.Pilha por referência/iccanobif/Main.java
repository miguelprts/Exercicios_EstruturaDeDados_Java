import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Iccanobif iccanobif = new Iccanobif();

        int valor = 0;

        try{
            System.out.print("Icannobif de: ");
            valor = teclado.nextInt();
        }
        catch(Exception e){
            System.out.println("Digite um número! Tente de novo!");
        }

        iccanobif.calcularIcannobif(valor);

        try{
            while(!iccanobif.isVazia()){
                System.out.println(iccanobif.pop().elemento);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

    teclado.close();
    }
}