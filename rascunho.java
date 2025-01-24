public class rascunho {
    if(op == "A"){
        a.add(entrada);
        System.out.println(entrada + " é adicionado(a) à fila a.");
    }
    else if(op == "B"){
        b.add(entrada);
        System.out.println(entrada + " é adicionado(a) à fila b.");
    }
    else if(op == "X"){
        if(a.tamanho == b.tamanho)
            System.out.println(entrada + " é descartado! (ambas tem " + a.tamanho + "elementos.");
    }
    else if(op == "S"){
        break;
    }
    else{
        System.out.println("Digite alguma opção válida!");
    }
}
