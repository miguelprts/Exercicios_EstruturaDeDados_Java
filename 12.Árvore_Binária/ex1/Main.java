package ex1;

public class Main {
        public static void main(String[] args) {
            Arvore arvore = new Arvore();
            arvore.adicionar(5, "Ana", "Sistemas de Informação");
            arvore.adicionar(9, "Marcelo", "Sistemas de Informação");
            arvore.adicionar(3, "Roger", "Sistemas de Informação");
            arvore.adicionar(1, "Clark", "Formação da Terra");
            arvore.adicionar(20, "Miguel", "Sistemas de Informação");
            arvore.adicionar(80, "Diego", "Sistemas de Informação");
            arvore.adicionar(30, "Carol", "Jornalismo");
            arvore.adicionar(2, "Pedro", "Química");
            arvore.adicionar(4, "Laura", "Matemática");
            arvore.adicionar(21, "Daniel", "Sistemas de Informação");
    
            // Testando maior matrícula
            try {
                Aluno maior = arvore.maiorMatricula();
                System.out.println("Maior matrícula: " + maior.getMatricula() + " - " + maior.getNome());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    
            // Testando busca de matrícula
            long matriculaTeste = 9;
            System.out.println("Aluno com matrícula " + matriculaTeste + " está cadastrado? " + arvore.estaCadastrado(matriculaTeste));
            
            matriculaTeste = 100;
            System.out.println("Aluno com matrícula " + matriculaTeste + " está cadastrado? " + arvore.estaCadastrado(matriculaTeste));
    
            // Testando impressão da árvore
            System.out.println("\nImpressão da árvore:");
            arvore.imprimir();
    
            // Testando exclusão de um aluno
            try {
                System.out.println("\nExcluindo aluno: Marcelo");
                arvore.excluir("Marcelo");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    
            // Imprimindo novamente após exclusão
            System.out.println("\nÁrvore após exclusão:");
            arvore.imprimir();
        }
    }