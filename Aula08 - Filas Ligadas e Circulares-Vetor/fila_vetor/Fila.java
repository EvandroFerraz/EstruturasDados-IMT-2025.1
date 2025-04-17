public class Fila{
    int[] dados;
    int primeiro, ultimo, ocupacao;
    // Fila fila = new Fila(); // cria fila com capacidade = 10
    // Fila fila = new Fila(20); // cria fila com capacidade = 20
    public Fila(int capacidade){
        dados = new int[capacidade];
        primeiro = 0;
        ultimo = 0;
        ocupacao = 0;
    }
    public Fila(){
        this(10);
    }
    public boolean filaVazia(){
        return ocupacao == 0;
    }
    public boolean filaCheia(){
        return ocupacao == dados.length;
    }
    private int proxima(int pos){ // pos = indice do ultimo elemento inserido na fila
        return (pos + 1) % dados.length;
    }

    public void enfileira(int e){ // inserir no final
        if(filaCheia()) throw new RuntimeException("falha na insercao");
        dados[ultimo] = e;
        ultimo = proxima(ultimo);
        ocupacao++;
    }

    public int desenfileira(){ // retirar do inicio
        if(filaVazia()) throw new RuntimeException("falha na remocao");
        int temp = dados[primeiro];
        primeiro = proxima(primeiro);
        ocupacao--;
        return temp;
    }

    @Override
    public String toString(){
        if(filaVazia()) return ("fila vazia");
        String s = "";
        for(int i = primeiro, cont = 0; cont < ocupacao; cont++){
            s = s + dados[i] + " ";
            i = proxima(i);
        }
        return s;
    }

    public String stringVetor(){
        String s = "";
        if(filaVazia()){
            for(int i = 0; i < dados.length; i++)
                s += "_ ";
        }else if(filaCheia()){
            for(int i = 0; i < dados.length; i++)
                s += dados[i] + " ";
        }else if(primeiro < ultimo){
            for(int i = 0; i < primeiro; i++)
                s += "_ ";
            for(int i = primeiro; i < ultimo; i++)
                s += dados[i] + " ";
            for(int i = ultimo; i < dados.length; i++)
                s += "_ ";
        }else{ // primeiro >= ultimo
            for(int i=0; i < ultimo; i++)
                s += dados[i] + " ";
            for(int i=ultimo; i < primeiro; i++)
                s += "_ ";
            for(int i=primeiro; i < dados.length; i++)
                s += dados[i] + " ";
        }
        return s;
    }


        // primeira = 10
        // | 10 | 11 | 12 | -- | -- |
        //   0     1     2
        // depois de remover o 10
        // | -- | 11 | 12 |
        //   0     1     2
        // primeira = 11
        
        // 2º exemplo
        // primeira = 12
        // | 10 | 11 | 12 |
        //   0     1    2
        // depois de remover o 12
        // | 10 | 11 | -- |
        //   0     1    2
        // calculo de proxima:
        // primeira + 1 % 3 = 3 % 3 = 0
        // primeira = 10
 


}