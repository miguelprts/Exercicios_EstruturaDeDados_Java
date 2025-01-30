import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        FilaAvioes a = new FilaAvioes();
        FilaAvioes b = new FilaAvioes();
        FilaAvioes q = new FilaAvioes();

        while(true){
            System.out.println("Insira um nome: ");
            String entrada = teclado.nextLine();
            System.out.println("A - Insira na fila A. \nB - Insira na fila B.\nX - Insira na fila com menos elementos.\nS - Sair");
            String op = teclado.nextLine();

            if(op.equals("S"))
                break;
            else if(!op.equals("A") && !op.equals("B") && !op.equals("C")){
                System.out.println("Opção inválida.");
            }

            q.add(entrada, op);
        }

        while(q.tamanho != 0){
            Texto texto = new Texto(null, null);

            try{
                texto = q.remove();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            
            if(texto.getOperacao().equals("A")){
                a.add(texto.getElemento(), texto.getOperacao());
                System.out.println(texto.getElemento() +" inserido na fila A.");
            }
            else if(texto.getOperacao().equals("B")){
                b.add(texto.getElemento(), texto.getOperacao());
                System.out.println(texto.getElemento() +" inserido na fila B.");
            }
            else{
                if(b.tamanho == a.tamanho)
                    System.out.println(texto.getElemento() + " foi removido. (ambas as filas possuem " + b.tamanho+ " elementos).");
                else if(b.tamanho > a.tamanho){
                    b.add(texto.getElemento(), texto.getOperacao());
                    System.out.println(texto.getElemento() +" inserido na fila B.");
                }
                else{
                    a.add(texto.getElemento(), texto.getOperacao());
                    System.out.println(texto.getElemento() +" inserido na fila A.");
                }
            }
        }
        System.out.print("Fila A: [");
        
        while(a.tamanho != 0){
            try {
                System.out.print(""+a.remove().getElemento() + "; ");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("]. Fila B: [");

        while(b.tamanho != 0){
            try {
                System.out.print(""+b.remove().getElemento() + "; ");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("].");

    }
}