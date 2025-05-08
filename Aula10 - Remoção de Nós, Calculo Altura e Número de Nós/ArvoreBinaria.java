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
            // se o ramo da direita esta vazio, quer dizer que existe espaço para incluir o novo no
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

    // 1- calcula a altura da arvore
    // Altura da Arvore: o número de níveis no caminho mais longo da raiz até uma folha.
    public int altura(){
        // Se a árvore está vazia ou se a raiz é uma folha (sem filhos), a altura é 0
        if(arvoreVazia() || (raiz.getEsquerda() == null && raiz.getDireita() == null))
            return 0;

        // Caso contrário, chama o método recursivo para calcular a altura a partir da raiz
        return alturaRec(raiz);
    }

    private int alturaRec(No atual){
        // Caso Base(critério de parada): se o nó atual for uma folha, retorna 0
        if(atual.getEsquerda() == null && atual.getDireita() == null)
            return 0;
        
        // Inicializa variáveis para armazenar as alturas da subárvore esquerda e direita
        int alturaEsquerda = 0, alturaDireita = 0;

        // Se existe uma subárvore à esquerda, chamamos o método recursivo para ela
        if(atual.getEsquerda() != null)
            alturaEsquerda = alturaRec(atual.getEsquerda());

        // Se existe uma subárvore à direita, chamamos o método recursivo para ela
        if(atual.getDireita() != null)
            alturaDireita = alturaRec(atual.getDireita());

        // Retorna a maior altura entre a esquerda e a direita, incrementado a altura em +1 (nível do nó atual)
        return alturaDireita > alturaEsquerda ? alturaDireita + 1 : alturaEsquerda + 1;
    }

    // 2- contar quantos nós existem
    public int contaNos(){
        if(arvoreVazia()) return 0; // Se a árvore está vazia então não tem nós

        return contaNosRec2(raiz);
    }

    private int contaNosRec(No atual){
        int nos = 0; // guarda o número de nós atual

        // Percorremos primeiro as subárvores esquerdas e depois as direitas
        if(atual.getEsquerda() != null)
            nos += contaNosRec(atual.getEsquerda());

        if(atual.getDireita() != null)
            nos += contaNosRec(atual.getDireita());

        // Para cada chamada recursiva, que teremos uma para cada nó, incrementamos a variável nos em +1
        return nos + 1;
    }

    private int contaNosRec2(No atual){
        if(atual != null)
            return contaNosRec2(atual.getEsquerda()) + contaNosRec2(atual.getDireita()) + 1;
        return 0; // criterio base
    }
    
    // 3.1 - remover um nó da arvore pesquisando por seu atributo info
    public void removeValor(int info){
        //Se a árvore estiver vazia, não há o que remover
        if(arvoreVazia()) throw new RuntimeException("Falha na Remoção: Árvore Vazia");
        
        // Caso o valor a ser removido está na raiz da árvore
        if(info == raiz.getInfo()){
            // Caso 1: raiz é uma folha (sem filhos)
            if(raiz.getDireita() == null && raiz.getEsquerda() == null){
                raiz = null;
            }
            // Caso 2: raiz só tem um filho a direita
            else if(raiz.getEsquerda() == null){
                raiz = raiz.getDireita(); // sobrepôe o nó na raiz pelo filho à direita
            }
            // Caso 3: raiz só tem um filho a esquerda
            else if(raiz.getDireita() == null){
                raiz = raiz.getEsquerda(); // sobrepôe o nó na raiz pelo filho à esquerda
            }
            // Caso 4: raiz possui os dois filhos
            else{
                // Encontrar o sucessor (menor valor da subárvore direita)
                No suc = sucessor(raiz);
                // Filho esquerdo da raiz agora é filho esquerdo do sucessor
                suc.setEsquerda(raiz.getEsquerda());
                // Substitui a raiz pelo sucessor correto
                raiz = suc;
            }
        }
        // Caso onde o nó a ser removido não está na raiz da árvore
        else{
            // Pra sabermos qual direção percorrer
            // Se info > raiz.info, vamos para a subárvore direta
            // Se info < raiz.info, vamos para a subárvore esquerda
            if(info > raiz.getInfo())
                removeValorRec(info, raiz.getDireita(), raiz, true);
            else
                removeValorRec(info, raiz.getEsquerda(), raiz, false);
        }
    }

    // 3.2 - método para recursivo para remover nós que não estão na raiz
    private void removeValorRec(int info, No atual, No pai, boolean efilhoDireita){
        // Se chegamos em um nó nula, o valor não existe na árvore
        if(atual == null){
            throw new RuntimeException("Falha na Remoção: Valor não existe na árvore!!");
        }

        // Se o nó a ser removido foi encontrado
        if(info == atual.getInfo()){
            // Caso 1: o nó a ser excluído é uma folha
            if(atual.getDireita() == null && atual.getEsquerda() == null){
                if(efilhoDireita)
                    pai.setDireita(null);
                else
                    pai.setEsquerda(null); 
            }
            // Caso 2: só tem filho à esquerda
            else if(atual.getDireita() == null){
                if(efilhoDireita)
                    pai.setDireita(atual.getEsquerda()); // substitui pelo filho esquerdo
                else
                    pai.setEsquerda(atual.getEsquerda());
            }
            // Caso 3: só tem filho à direita
            else if(atual.getEsquerda() == null){
                if(efilhoDireita)
                    pai.setDireita(atual.getDireita()); // substitui pelo filho direito
                else
                    pai.setEsquerda(atual.getDireita());
            }
            // Caso 4: o nó atual possui os dois filhos
            else{
                // Encontramos novamente o sucessor (menor valor da subárvore direita)
                No suc = sucessor(atual);
                // Liga o filho esquerdo ao sucessor
                suc.setEsquerda(atual.getEsquerda());
                // Substitui o atual pelo sucessor no pai
                if(efilhoDireita)
                    pai.setDireita(suc);
                else
                    pai.setEsquerda(suc);
            }
        }else{ // Cenário o nó visitado não tem o valor a ser excluído (info)
            if(info > atual.getInfo()) // percorre a subárvore direita
                removeValorRec(info, atual.getDireita(), atual, true);
            else // percorre a subárvore esquerda
                removeValorRec(info, atual.getEsquerda(), atual, false);
        }
    }

    // 3.3 - método para encontrar o sucessor
    // Encontrar o menor valor maior que o atual (sucessor da subárvore direita)
    private No sucessor(No atual){
        // Começamos pegando o filho direito do atual
        No suc = atual.getDireita();
        // Vamos o mais à esquerda possível a partir da subárvore direita
        No runner = suc.getEsquerda();
        No pai = suc;

        // Percorrer até encontrar o menor valor (mais à esquerda)
        while(runner != null){
            pai = suc;
            suc = runner;
            runner = runner.getEsquerda();
        }

        // Se o sucessor não tiver um filho direito
        if(suc != atual.getDireita()){
            // O pai do sucessor aponta para o filho direito do sucessor
            pai.setEsquerda(suc.getDireita());
            // E o sucessor assume o antigo filho direito do nó atual
            suc.setDireita(atual.getDireita());
        }
        
        // Retorna o sucessor encontrado
        return suc;
    }

}


    /* 5
      / \
     3   8
    /     \
   2      10
Altura do nó 2 = 0
Altura do nó 3 = 1 (pois 2 é filho dele)
Altura do nó 10 = 0
Altura do nó 8 = 1 (pois 10 é filho dele)
Altura do nó 5 = 2 (1 + 1, altura dos filhos + 1)*/