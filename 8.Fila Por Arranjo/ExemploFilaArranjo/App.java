public class App {
    public static void main(String[] args) throws Exception {
        FilaArranjo fila = new FilaArranjo();
        fila.enfileirar(new Pessoa("A",45));
        fila.enfileirar(new Pessoa("B",20));
        fila.enfileirar(new Pessoa("C",20));
        fila.enfileirar(new Pessoa("D",33));
        fila.enfileirar(new Pessoa("E",45));
        fila.enfileirar(new Pessoa("F",20));
        fila.enfileirar(new Pessoa("G",20));
        fila.enfileirar(new Pessoa("H",33));

        Pessoa p;
        while(!fila.isEmpty()){
            p = fila.desenfileirar();
            System.out.println(p.nome);
        }
        System.out.println("-------------");
        fila.enfileirar(new Pessoa("I",45));
        fila.enfileirar(new Pessoa("J",20));
        fila.enfileirar(new Pessoa("K",45));
        fila.enfileirar(new Pessoa("L",45));
        fila.enfileirar(new Pessoa("M",45));        
        fila.enfileirar(new Pessoa("N",45));

        while(!fila.isEmpty()){
            p = fila.desenfileirar();
            System.out.println(p.nome);
        }
        System.out.println("Inicio: " + fila.inicio);
        System.out.println("Fim: " + fila.fim);
    }
}
