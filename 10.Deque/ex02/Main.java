package ex02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Deque<Double> deque = new Deque<Double>();

        System.out.println("Financie seu eletrônico aqui!");
        System.out.print("Informe o valor que deseja financiar: ");
        double valor = teclado.nextDouble();

        System.out.println("Em quantas parcelas? ");
        int qtd = teclado.nextInt();

        double parcelas = valor/qtd;
        int mesAtual = 1;

        for (int i = 0; i != qtd; i++) {
            deque.addInicio(parcelas);
        }

        for(int i = deque.tamanho; i > 0; i--){
            System.out.println("Mês "+mesAtual+". Digite a opção desejada: \n1-Pagar parcela atual.\n2-Pagar última parcela");
            int opc = 0;
            try{
                opc = teclado.nextInt();
            }
            catch(Exception e){
                System.out.println("Digite apenas números!");
            }

            if(opc == 1){
                try {
                    Double v = deque.removerInicio();
                    v += (parcelas * (0.01*mesAtual));
                    System.out.println("Valor: R$"+v +". \n");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                mesAtual++;
            }
            else if(opc == 2){
                try {
                    double v = deque.removerFim();
                    System.out.println("Valor: R$"+v +". \n");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                mesAtual++;
            }
            else{
                System.out.println("opção inválida!");
            }
        }
        teclado.close();
    }
}
