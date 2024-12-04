public class App {
    public static void main(String[] args) throws Exception {
        ListaPessoa lista = new ListaPessoa();
        Pessoa p1 = new Pessoa("Pedro", 20);
        try{
            lista.add(0, p1);
            p1 = new Pessoa("Maria", 25);
            lista.add(0,p1);
            p1 = new Pessoa("Carlos",36);
            lista.add(30,p1);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        try {
            for (int i=0;i<lista.tamanho();i++)
                System.out.println("Nome: "+ lista.get(i).nome + " idade: " + lista.get(i).idade );
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        try{
            lista.remove(1);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println();
        
        try {
            for (int i=0;i<lista.tamanho();i++)
                System.out.println("Nome: "+ lista.get(i).nome + " idade: " + lista.get(i).idade );
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
