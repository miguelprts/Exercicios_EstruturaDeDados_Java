package ex1;

public class Arvore {
    Aluno raiz = null;

    public void adicionar(long matricula, String nome, String curso){
        Aluno novo = new Aluno(matricula, nome, curso);

        if(raiz == null){
            raiz = novo;
        } else{
            adicionar(novo, raiz);
        }
        
    }
    private void adicionar(Aluno novo, Aluno alunoAtual){
        if(alunoAtual.getMatricula() > novo.getMatricula()){
            if(alunoAtual.getEsquerda() != null)
                adicionar(novo, alunoAtual.getEsquerda());
            else
                alunoAtual.setEsquerda(novo);
        }
        else if(alunoAtual.getMatricula() < novo.getMatricula()){
            if(alunoAtual.getDireita() != null)
                adicionar(novo, alunoAtual.getDireita());
            else
                alunoAtual.setDireita(novo);
        }
    }

    public Aluno maiorMatricula() throws Exception{
        if(raiz == null)
            throw new Exception("árvore vazia!");
        
        Aluno alunoAux = raiz;

        while(alunoAux.getDireita() != null)
            alunoAux = alunoAux.getDireita();
        return alunoAux;
    }

    public boolean estaCadastrado(long matricula){
        return estaCadastrado(matricula, raiz);
    }
    private boolean estaCadastrado(long matricula, Aluno aluno){
        if(aluno == null)
            return false;
        if(aluno.getMatricula() == matricula)
            return true;
        if(aluno.getMatricula() < matricula)
            return estaCadastrado(matricula, aluno.getDireita());
        else
            return estaCadastrado(matricula, aluno.getEsquerda());
    }

    public void imprimir(){
        imprimir(raiz);
    }
    private void imprimir(Aluno a){
        if(a != null){
            System.out.println("M: "+a.getMatricula() + " | Aluno: "+a.getNome()+". | Curso: "+a.getCurso()+".");
            imprimir(a.getEsquerda());
            imprimir(a.getDireita());
        }
    }

    public Aluno excluir(String nome) throws Exception{
        Aluno a = buscarPeloNome(nome, raiz);

        if(a == null)
            throw new Exception("Não há esse aluno cadastrado!");
            
        raiz = excluir(a, raiz, null);
        return a;
    }
    private Aluno excluir(Aluno alunoExc, Aluno alunoAtual, Aluno alunoSuperior) {
        if(alunoAtual == null) return null;

       if(alunoAtual.getMatricula() < alunoExc.getMatricula())
            alunoAtual.setDireita(excluir(alunoExc, alunoAtual.getDireita(), alunoAtual));

        else if(alunoAtual.getMatricula() > alunoExc.getMatricula())
            alunoAtual.setEsquerda(excluir(alunoExc, alunoAtual.getEsquerda(), alunoAtual));

        else{
            //se não tiver filhos
            if(alunoAtual.getEsquerda() == null && alunoAtual.getDireita() == null){
               if(alunoSuperior !=null){
                    if(alunoSuperior.getEsquerda().getMatricula() == alunoAtual.getMatricula())
                        alunoSuperior.setEsquerda(null);
                    else
                        alunoSuperior.setDireita(null);
               }
               else
                return null;
            }
            //ele tem dois filhos
            else if(alunoAtual.getEsquerda() != null && alunoAtual.getDireita() != null){
                Aluno alunoSub = pegarMenorMatricula(alunoAtual.getDireita());

                alunoAtual.setCurso(alunoSub.getCurso());
                alunoAtual.setNome(alunoSub.getNome());
                alunoAtual.setMatricula(alunoSub.getMatricula());

                alunoAtual.setDireita(removerMinimo(alunoAtual.getDireita()));
            }
            else{
                if (alunoAtual.getEsquerda() == null) {
                    return alunoAtual.getDireita(); // Substitui pelo filho direito
                } 
                else if (alunoAtual.getDireita() == null) {
                    return alunoAtual.getEsquerda(); // Substitui pelo filho esquerdo
                } 
            }
        } return alunoAtual;
    }

    private Aluno buscarPeloNome(String nome, Aluno a){
        if(a != null){
            if (a.getNome().equals(nome))
            return a;        
            Aluno esquerda = buscarPeloNome(nome, a.getEsquerda());
            if (esquerda != null) return esquerda;
                return buscarPeloNome(nome, a.getDireita());
        }
        return null;
    }   
    private Aluno pegarMenorMatricula(Aluno a){
        if(a.getEsquerda()!= null){
           return pegarMenorMatricula(a.getEsquerda());
        }
        return a;
    }
    private Aluno removerMinimo(Aluno a){
        if(a.getEsquerda() != null){
            a.setEsquerda(removerMinimo(a.getEsquerda()));
            return a;
        }else
            return a.getDireita();
    }
}
