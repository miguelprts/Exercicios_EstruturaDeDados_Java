package ex2;

import java.util.Scanner;

public class BrincESabedoria {
    public static void main(String[] args) {
        Arvore arv = new Arvore();
        Scanner sc = new Scanner(System.in);

        int qtd = sc.nextInt();
        sc.nextLine();

        String in = sc.nextLine();
        String[] inDividido = in.split(" "); 

        int[] entradas = new int[qtd]; 
       
        for (int i = 0; i < qtd; i++) {
            entradas[i] = Integer.parseInt(inDividido[i]);
        }

        for (int i = 0; i < qtd; i++) {
            arv.adicionar(entradas[i]); 
        }

        arv.imprimir();
        
        sc.close();
    }
}
