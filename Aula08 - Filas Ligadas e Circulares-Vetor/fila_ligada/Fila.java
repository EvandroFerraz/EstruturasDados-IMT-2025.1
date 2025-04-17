public class Fila{
    // atributos
    private No primeiro;
    private No ultimo;

    // construtor teremos apenas o padrão

    public boolean filaVazia(){
        return primeiro == null;
    }

    // 4 - 7 - 8 - 19
    // primeiro = 4
    // ultimo = 19
    //enfileira(12)
    // 4 - 7 - 8 - 19 - 12
    // primeiro = 4
    // ultimo = 12
    public void enfileira (int e){ // inserir no Fim
        No novo = new No(e); // proximo = null
        if(filaVazia()){
            primeiro = novo;
        }else{
            ultimo.setProximo(novo);
        }
        ultimo = novo;
    }

    // 4 - 7 - 8 - 19
    // primeiro = 4
    // ultimo = 19
    // desenfileira(), sobrepoe o nó 4 com o 7
    // primeiro = 7
    public int desenfileira() { // removeInicio
        if(filaVazia()) throw new RuntimeException("falha na remocao - fila vazia");
        int temp = primeiro.getInfo();
        primeiro = primeiro.getProximo();
        if(primeiro == null) // esvaziou a fila
            ultimo = null; // retirando a referencia para liberar memória
        return temp;
    }
    @Override
    public String toString() {
        if(filaVazia()) return "fila vazia";
        String s = "";
        No runner = primeiro;
        while(runner != null){
            s += runner + "->";
            runner = runner.getProximo();
        }
        return s;
    }
}

class No{
    // atributos
    private int info;
    private No proximo;
    // construtor
    public No(int info){
        this.info = info;
        proximo = null;
    }
     //getters/setters
    public int getInfo(){
        return info;
    }
    public void setInfo(int info){
        this.info = info;
    }
    public No getProximo(){
        return proximo;
    }
    public void setProximo(No proximo){
        this.proximo = proximo;
    }
    @Override
    public String toString(){
        return "[" + info + "]";
    }
}