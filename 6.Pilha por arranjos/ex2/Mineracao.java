package ex2;
import java.util.Scanner;

public class Mineracao{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        while(true){
            int num = teclado.nextInt();
            teclado.nextLine();

            if(num == 0){
                break;
            }

            for(int i = 0; i < num; i++){
                String entrada = teclado.nextLine();
                int rearranjar = minerar(entrada);

                System.out.println(rearranjar);

            }
        }
        teclado.close();
    }

    public static int minerar(String entrada){
        char[] pilha = new char[1000];
        int topo = -1, qtdDiamantes = 0;

        try{

            for(int i = 0; i < entrada.length(); i++){
                if(entrada.charAt(i) == '<' || entrada.charAt(i) == '>'){
                    
                    if(topo != -1 && (pilha[topo]=='<' && entrada.charAt(i)=='>')){
                        topo--;
                        ++qtdDiamantes;
                    }
                    else{
                        pilha[++topo] = entrada.charAt(i);
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return qtdDiamantes;
    }
}
