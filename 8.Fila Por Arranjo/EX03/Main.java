import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        while(true){
            int n = teclado.nextInt();

            if(n==0)
                break;
            else if(n == 1)
                System.out.print("\nRemaining card: 1");

            else if(n >= 2 && n <=50){
                Integer[] vet = op(n);
                System.out.print("Discarted cards: ");
                
                for (int i = 0; i < vet.length-1; i++) {
                    System.out.print(vet[i]);
                    if(i != vet.length-2)
                        System.out.print(", ");
                }

                System.out.print("\nRemaining card: "+vet[vet.length-1]);

            }
        }
    }

    public static Integer[] op(int n){
        int[] cartas = new int[n];
        Integer[] descartadas;
        int topo = 0, base=0, tamanho = n;

        for (int i = 0; i < n; i++) {
            cartas[base++] = i+1;
            System.out.println(cartas[i]);
        }


        descartadas = new Integer[tamanho];

        int pos = 0;

        while (true) {

            if(base >= n)
                base = 0;
                
            descartadas[pos] = cartas[topo++];
            pos++;
            tamanho--;
            if(topo >= n)
                topo = 0;
            if(tamanho == 1)
                break;
            
            cartas[base++] = cartas[topo++];

            if(tamanho == 1)
                break;
        }

        descartadas[pos] = cartas[topo];

        topo = 0; base = 0; tamanho = 0;
        return descartadas;
    }
}
