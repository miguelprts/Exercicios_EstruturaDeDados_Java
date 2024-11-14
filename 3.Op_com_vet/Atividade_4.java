import java.util.Scanner;

public class Atividade_4 {
    static int[] vet = new int[10];
    static int ulPosicao = -1; 
    static boolean condicao = false;   

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        System.out.println("Manipule um vetor!");

        int posicao = -1;
        
        try {
            
        while (!condicao) {
            System.out.print("\n1-Insira algum valor\n2-Apague algum valor\n3-Sair\nEscolha: ");
            int opcao = tec.nextInt();

            if (opcao == 1) {
                System.out.print("Valor: ");
                int valor = tec.nextInt();

                System.out.println("Em qual posição você quer inserir? Entre 0 e " + (ulPosicao + 1));
                posicao = tec.nextInt();

                while (posicao < 0 || posicao > ulPosicao + 1) {
                    System.out.println("Em qual posição você quer inserir? Entre 0 e " + (ulPosicao + 1));
                    posicao = tec.nextInt();
                }

                inserir_no_vetor(posicao, valor);
            }  
            else if (opcao == 2) {
                if(ulPosicao != -1 ){
                    System.out.println("Qual posição você quer excluir? Entre 0 e " + (ulPosicao++));
                    posicao = tec.nextInt();
                    while (posicao < 0 || posicao > ulPosicao) {
                        System.out.println("Qual posição você quer excluir? Entre 0 e " + ulPosicao);
                        posicao = tec.nextInt();
                    }
                    deletar_no_vetor(posicao);
                }else{
                    System.out.println("Não há posições para serem excluídas!");
                }
            }
            else if (opcao == 3) {
                condicao = true;
            }
            else {
                System.out.println("Opção inválida!");
            }

            System.out.println("Vetor atualizado:");
            for (int i = 0; i <= ulPosicao; i++) {
                System.out.print(vet[i] + "|");
            }
            System.out.println();
        }
    } catch (Exception e) {
        System.out.println("Reinicie o programa, e informe valores numéricos inteiros dessa vez!");
    }
        tec.close();
    }

    public static void inserir_no_vetor(int posicao, int valor) {
        if (ulPosicao >= vet.length - 1){
            condicao = true;
            return;
        }
        for (int i = ++ulPosicao; i > posicao; i--) {
            vet[i] = vet[i - 1];
        }
        vet[posicao] = valor;
    }

    public static void deletar_no_vetor(int posicao) {
        if (ulPosicao == -1) {
            System.out.println("Vetor vazio!");
            return;
        }
        for (int i = posicao; i < ulPosicao; i++) {
            vet[i] = vet[i + 1];
        }
        ulPosicao--;
    }
}
