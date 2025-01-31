package ex1;

public class App {
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<Integer>();

        for (int i = 10; i > 0; i--) {
            if((i+1)%2 == 0)
                deque.addInicio(i);
            else
                deque.addFim(i);
        }
        try {
            while(!deque.verifica()){
                System.out.println(""+deque.removeInicio().toString());
            }
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }       
    }
}