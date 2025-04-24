public class ArvoreBinaria{
    private No raiz;

    // construtor padrão do java

    public boolean arvoreVazia(){
        return raiz == null;
    }

    public void insere(int info){
        No novo = new No(info);
        if(arvoreVazia())
            raiz = novo;
        else
            insereRec(novo, raiz);
    }
    // default = acessivel somente pela classe que pertence e tambem as outras classes no mesmo pacote
    void insereRec(No novo, No atual){
        if(novo.getInfo() > atual.getInfo()){ // iriamos para o ramo a direita
            // se o ramo da direita esta vazio, quer dizer que eu tenho espaço para incluir o novo no
            if(atual.getDireita() == null){
                // incluir novo nó a direita do atual
                atual.setDireita(novo);
            }else{
                // chamamos o método recursivo novamente, atualizando o valor do No atual
                insereRec(novo, atual.getDireita());
            }
        }else{ // novo <= atual, então a gente vai pro ramo a esquerda do atual
            if(atual.getEsquerda() == null){
                atual.setEsquerda(novo);
            }else{
                insereRec(novo, atual.getEsquerda());
            }
        } 
    }

    public void insereRepeticao(int info){
        NoRepeticao novo = new NoRepeticao(info);
        if(arvoreVazia()) raiz = novo;
        else insereRepeticaoRec(novo, raiz);
    }

    void insereRepeticaoRec(No novo, No atual){
        // comando de cast
        NoRepeticao noAtualRepeticao = (NoRepeticao)atual;
        // verifica se configura repetição
        if(atual.getInfo() == novo.getInfo())
            // incrementa o valor de ocorrencias
            noAtualRepeticao.setOcorrencias(noAtualRepeticao.getOcorrencias() + 1);
        // devemos percorrer a subarvore direita 
        else if(novo.getInfo() > atual.getInfo()){ 
            if(atual.getDireita() == null) // se existe um espaço vazio a direita do atual 
                atual.setDireita(novo);
            else // se o espaço a direita do nó atual já estiver ocupado
                insereRepeticaoRec(novo, atual.getDireita());
        }else{ // novo < atual, devemos percorrer a subárvore esquerda
            if(atual.getEsquerda() == null){ // se existe um espaço vazio a esquerda do atual 
                atual.setEsquerda(novo);
            }else{ // se o espaço a esquerda do nó atual já estiver ocupado
                insereRepeticaoRec(novo, atual.getEsquerda());
            }
        }
    }
    
    // Percorremos em ordem para criar o toString()
    @Override
    public String toString(){
        if(arvoreVazia()) return "arvore vazia";

        return stringEmOrdemRec(raiz);
    }
    // Percorrer Em Ordem
    String stringEmOrdemRec(No atual){
        String s = "";
        // 1- Acessa a Esquerda
        if(atual.getEsquerda() != null) // se existir um nó a esquerda
            s += stringEmOrdemRec(atual.getEsquerda());
        //2- Acessa o Atual
        s += atual + " ";
        //3- Acessa a Direita
        if(atual.getDireita() != null) // se existir um nó a direita
            s += stringEmOrdemRec(atual.getDireita());
        return s;
    }
}