import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        FilaAvioes fila = new FilaAvioes();

        while(true){
            System.out.println("Senhas disponíveis: "+ (50 - fila.senha));
            System.out.println("1. Solicitar nova senha");
            System.out.println("2. Próximo à ser atendido");
            System.out.println("3. Sair");

            int opc = 0;

            try{
                opc = teclado.nextInt();
            }catch(Exception e){
                System.out.println("Insira apenas números!!!");
            }

            if(opc == 1){
                System.out.print("Nome: ");
                teclado.nextLine();
                String nome = teclado.nextLine();
                try {
                    fila.add(nome);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                System.out.println(nome + " adicionado a fila!");

            }
            else if(opc == 2){
                try{
                    Senha s = fila.remove();
                    System.out.println("Senha: " + s.getId() + ". Nome: " + s.getNome());
                }catch(Exception e){
                   System.out.println( e.getMessage());
                }
            }
            else if(opc == 3)
                System.exit(0);
            
            else
                System.out.println("Opção inválida.");
        }
    }
}
