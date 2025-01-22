import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        FilaDeProcessos f = new FilaDeProcessos();

        while(true){
            System.out.println("1. Adicionar novo processo");
            System.out.println("2. Próximo processo");
            System.out.println("3. Imprimir os processos");
            System.out.println("4. Localizar um processo");
            System.out.println("5. Sair");

            int opc = 0;
            try {
                opc = teclado.nextInt();
            } catch (Exception e) {
                System.out.println("Digite apenas números!");
            }

            if(opc == 1){
                System.out.print("Nome do processo: ");
                String esp = teclado.nextLine();
                String nome = teclado.nextLine();

                try {
                    f.add(nome);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("Adicionado com sucesso!");
            }
            else if(opc == 2){
                try {
                    Processo p = f.remove();
                    System.out.println("Processo: "+p.getNome() + ". Id: "+p.getId()+".");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else if(opc == 3){
                Processo[] vet = f.imprimir();

                for (int i = 0; i < vet.length; i++) {
                    System.out.println("Processo: "+vet[i].getNome() + ". Id: "+vet[i].getId()+".");
                }
            }
            else if(opc == 4){
                System.out.println("Digite o ID: ");
                int id = 0;
                try {
                    id = teclado.nextInt();
                    System.out.println(f.localizar(id));
                } catch (Exception e) {
                    System.out.println("Bota número!");
                }
            }
            else if(opc == 5){
                break;
            }
            else
                System.out.println("Opção inválida.");
        }
    }
}
