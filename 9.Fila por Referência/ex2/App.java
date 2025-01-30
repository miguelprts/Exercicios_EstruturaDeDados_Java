package ex2;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        FilaAvioes filaNorte = new FilaAvioes();
        FilaAvioes filaSul = new FilaAvioes();
        FilaAvioes filaLeste = new FilaAvioes();
        FilaAvioes filaOeste = new FilaAvioes();
        FilaAvioes filaFinal = new FilaAvioes();
        int qtdFor = 0;
        
        String opc = teclado.nextLine().trim(); // Lê a primeira opção

        while (!opc.equals("0")) { // Enquanto não for "0", continuar lendo
            if (opc.isEmpty()) continue; // Ignorar entrada vazia

            String nomeA = teclado.nextLine().trim(); // Lê o nome do avião

            if (nomeA.isEmpty()) continue;

            if (nomeA.charAt(0) == '-') { 
                opc = nomeA; // Atualiza a opção para próxima fila
            } else if (nomeA.charAt(0) == '0') { 
                break; // Sai do loop
            } else { 
                // Adiciona o avião à fila correspondente
                switch (opc) {
                    case "-4":
                        filaLeste.add(nomeA);
                        break;
                    case "-3":
                        filaNorte.add(nomeA);
                        break;
                    case "-2":
                        filaSul.add(nomeA);
                        break;
                    case "-1":
                        filaOeste.add(nomeA);
                        break;
                    default:
                        break;
                }

                qtdFor++;
            }
        }

         for (int i = 0; i != qtdFor; i++) {
            try {
                if(filaOeste.tamanho != 0){
                    filaFinal.add(filaOeste.remove().getNumeracao());
                }                
                if(filaNorte.tamanho != 0){
                    filaFinal.add(filaNorte.remove().getNumeracao());
                }
                if(filaSul.tamanho != 0){
                    filaFinal.add(filaSul.remove().getNumeracao());
                }
                if(filaLeste.tamanho != 0){
                    filaFinal.add(filaLeste.remove().getNumeracao());
                }
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
         }   

         try {
            while(filaFinal.tamanho > 0)
                System.out.print(filaFinal.remove().getNumeracao() + " ");
         } catch (Exception e) {
            System.out.println(e.getMessage());
         }
        
    }
}