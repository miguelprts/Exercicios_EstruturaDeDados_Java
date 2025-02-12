package ex02;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tabela tabela = new Tabela();
        while(true){
            System.out.println("1.Cadastro\n2.Consulta\n3.Encerrar");
            int opc = 0;

            try{
                opc = sc.nextInt();
                sc.nextLine();
            }catch(Exception e){
                System.out.println("Informe apenas números!");
            }

            if(opc == 1){
                System.out.print("\nCódigo: ");
                String cod = sc.nextLine();

                System.out.print("\nNome: ");
                String nome = sc.nextLine();

                System.out.print("\nPresidente: ");
                String pres = sc.nextLine();

                System.out.print("\nAno de Fundação: ");
                String ano = sc.nextLine();

                System.out.print("\nTécnico: ");
                String tecn = sc.nextLine();

                Time novo = new Time(nome, ano, cod, tecn, pres);
                tabela.add(novo);

                System.out.println("Inserido com sucesso!");
                
            } else if(opc == 2){
                System.out.println("Insira o código do time que deseja consultar: ");
                String cod = sc.nextLine();

                Time retorno = tabela.get(cod);

                if(retorno!=null){
                    System.out.println("Nome: "+retorno.getNome()+". Ano de Fundação: "+retorno.getAnoFundacao() + ". Técnico: "+retorno.getTecnico()+". Presidente: "+retorno.getPresidente()+". ");
                }else{
                    System.out.println("Não encontrado!");
                }

            } else if(opc==3){
                break;
            }
            else{
                System.out.println("Entrada inválida!");
            }
        }
        sc.close();
    }
}
