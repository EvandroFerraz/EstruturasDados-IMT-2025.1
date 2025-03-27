public class ListaDupla{
    private NoDuplo primeiro;
    private NoDuplo ultimo;

    // utilizaremos o construtor padrão do java

    public boolean listaVazia(){
        return primeiro == null;
    }

    public void insereInicio(int info){
        // [2] [3] [5]
        // insiro o [7]
        NoDuplo novo = new NoDuplo(info);
        if(listaVazia()){ // é o primeiro nó sendo inserido na lista
            ultimo = novo;
        }else{ // não é o primeiro nó sendo inserido na lista
            // ate a linha 23, primeiro = [2]
            novo.setProximo(primeiro); // [7] -> [2]
            primeiro.setAnterior(novo); // [7] <- [2]
            // lista atualizada: [7] [2] [3] [5]
        }
        primeiro = novo; // o nó apontado pelo atributo primeiro passa a ser o [7]
    }

    public void insereFim(int info){
        NoDuplo novo = new NoDuplo(info);
        if(listaVazia()){
            primeiro = novo;
        }else{
            // lista inicial: [2] [3] [5], novo nó: [7], ate a linha 35 ultimo = [5]
            novo.setAnterior(ultimo); // [7] <- [5]
            ultimo.setProximo(novo); // [5] -> [7], // lista atualizada: [2] [3] [5] [7]
        }
        ultimo = novo; // o nó apontado pelo atributo ultimo passa a ser o [7]
    }

    public int removeInicio(){
        if(listaVazia()) throw new RuntimeException("lista vazia, não exitem nós para remover");
        int info = primeiro.getInfo();
        if(primeiro == ultimo){ // se existe somente um nó, atribuimos nulo para "primeiro" e "ultimo" esvaziando a lista
            primeiro = null;
            ultimo = null;
        }else{ // existe mais de um nó
            // lista inicial: [2] [3] [5], o nó que será removido será o [2]
            primeiro = primeiro.getProximo(); // sobrepor o valor de [2] com o valor de [3]
            primeiro.setAnterior(null); // agora que o [3] é o primeiro da lista, seu atributo anterior deve ser nulo
        }
        return info;
    }

    public int removeFim(){
        if(listaVazia()) throw new RuntimeException("lista vazia, não exitem nós para remover");
        int info = ultimo.getInfo();
        if(primeiro == ultimo){
            primeiro = null;
            ultimo = null;
        }else{ // existe mais de um nó
            // lista inicial: [2] [3] [5], o nó que será removido será o [5]
            ultimo = ultimo.getAnterior(); // sobrepor o valor de [5] com o valor de [3], e [3] passa a ser o ultimo nó da lista
            ultimo.setProximo(null); // agora que o [3] é o ultimo da lista, seu atributo proximo deve ser nulo
        }
        return info;
    }

    @Override
    public String toString(){
        if(listaVazia()) return "lista vazia \n";

        String s = "";

        // percorre todos os nós da lista até a última posição
        for(NoDuplo runner = primeiro; runner != null; runner = runner.getProximo()){
            s += runner + " = ";
        }
        return s + "\n";
    }
}