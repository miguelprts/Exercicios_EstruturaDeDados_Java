public class Estacao{
    Pilha pilhaEstacao;

    public Estacao(int tamanho){
        pilhaEstacao = new Pilha(1000);
    }
    public void adicionarEntrada(int qtdVagoes){
        try{
            for(int i = 1; i <= qtdVagoes; i++){
                pilhaEstacao.push(i);
            }
        }catch(Exception e){
            e.getMessage();
        }
    }

    public boolean comparar(int nVagoes, int[] valoresDeSaida) {
        Pilha pilha = new Pilha(nVagoes);
        int proximoVagao = 1;

        for (int desejado : valoresDeSaida) {
            while (proximoVagao <= nVagoes && (pilha.topo == -1 || pilha.pilha[pilha.topo] != desejado)) {
                try {
                    pilha.push(proximoVagao);
                    proximoVagao++;
                } catch (Exception e) {
                    return false;
                }
            }

            if (pilha.topo != -1 && pilha.pilha[pilha.topo] == desejado) {
                try {
                    pilha.pop();
                } catch (Exception e) {
                    return false;
                }
            } else {
                return false; 
            }
        }

        return true;
    }
}