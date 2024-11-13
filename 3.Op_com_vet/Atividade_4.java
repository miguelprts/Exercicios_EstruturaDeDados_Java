import java.util.Scanner;

public class Atividade_4 {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        int[] vet = new int[10];
        int valor = 0, opc = 0, uPosicao = -1;        
        System.out.println("Preencha um vetor!");

        for (int i = 0; i < vet.length; i++) {
            System.out.print("Insira um valor: ");
            valor = tec.nextInt();
            System.out.println("Em qual posição você quer inserir? ");

            if(i == 0){
                System.out.println("1-Início\n2-Fim");
                opc = tec.nextInt();
            }

        }
    }


}