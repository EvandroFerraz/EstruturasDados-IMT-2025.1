import java.util.Random;

public class NossoVetor{
    // 1- métodos construtores (*)
    // 2- métodos para verificar se o vetor esta cheio ou vazio (*)
    // 3- método para redimensionar o tamanho do vetor (*)
    // 4- método para inserir um elemento no vetor (*)
    // 5- método para remoção do último elemento inserido (*)
    // 6- programar classe de teste (*)

    private int ocupacao; // numero de elementos que o vetor possui
    private int[] vetor; 

    public NossoVetor(int tamanho){
        vetor = new int[tamanho];
        ocupacao = 0;
    }
    // substitui o construtor padrão do java, criando um vetor com 10 elementos quando o construtor for chama sem parâmetros
    // NossoVetor vetor = new NossoVetor();
    // escolher o tamanho inicial (no exemplo, o tamanho seria 4)
    // NossoVetor vetor = new NossoVetor(4);
    public NossoVetor(){
        this(10);
    }
    
    public void insere(int i){
        // redimensiona o vetor, dobrando seu tamanho quando cheio
        if(estaCheio()) redimensionaVetor(vetor.length*2);   
        vetor[ocupacao++] = i;
    }

    // verificando se a quantidade de elementos no vetor
    // já atingiu o tamanho atual definido
    public boolean estaCheio(){
        return ocupacao == vetor.length;
    }
    // o vetor estará vazio se a quantidade de elementos for zero
    public boolean estaVazio(){
        return ocupacao == 0;
    }

    // método para redimensionar o tamanho do vetor se necessário
    private void redimensionaVetor (int novoTamanho){
        int[] temp = new int[novoTamanho];
        // copiamos os elementos dentro do vetor[] para temp[]
        for(int i = 0; i < ocupacao; i++){
            temp[i] = vetor[i];
        }
        vetor = temp;
    }

    // método para retornar o tamanho máximo atual do vetor
    public int getTamanho(){
        return vetor.length;
    }

    // método para retornar o número de elementos no vetor
    public int getOcupacao(){
        return ocupacao;
    }

    // remove o último elemento inserido no vetor
    public int remove(){
        int i = -1;
        // estraremos no if se o vetor não estiver vazio
        if(!estaVazio()){
            // -- usa o valor e depois aplica o decremento
            // ocupacao = 4, vetor[--ocupacao]
            // primeiro atribui para i o vetor[4], depois ocupacao = 3
            i = vetor[--ocupacao];
            if(vetor.length >= 4 && ocupacao <= vetor.length/4){
                redimensionaVetor(vetor.length/2);
            }
        }
        // se i = -1, quer dizer que o vetor está vazio
        return i;
    } 

    public String toString(){
        String s = "ocupacao = " + ocupacao + "\n tamanho = " + vetor.length + "\n";
        for(int i = 0; i < ocupacao; i++){
            s += vetor[i] + " ";
        }
        return s + "\n";
    }

    // Percorre o vetor buscando por um número específico que foi enviado como 
    // parâmetro (int i), retorna a posição do vetor onde o número foi encontrado
    public int pesquisaValor(int numeroPesquisado){
        if(estaVazio()){
            System.out.println("Vetor esta vazio!!");
        }else{ // buscar o número dentro do vetor
            // busca com complexidade linear
            for(int x = 0; x < ocupacao; x++){
                if(vetor[x] == numeroPesquisado){
                    // número encontrado \o/
                    return x;
                }
            }
        }
        return -1; // -1 quer dizer que o número não foi encontrado no vetor
    }

    public void preencheVetor(){
        Random random = new Random();
        for(int i = 0; i < vetor.length; i++){
            vetor[i] = random.nextInt(vetor.length*10);
        }
        ocupacao = vetor.length;
    }

    // bubbleSort() para ordenação crescente
    public void bubbleSort(){
        // Teste de Mesa
        // vetor = [8, 72, 64, 12, 36]
        // Complexidade quadrática (n^2) no pior caso, sendo n o tamanho do vetor de entrada
        for(int i = 1; i < vetor.length; i++){
            for(int j = 0; j < vetor.length-i; j++){
                // 1.1 iteração: j = 0, vetor[j] = 8
                // 1.2 iteração: j = 1, vetor[j] = 72, 72 e 64 trocam de lugar
                    // vetor = [8, 64, 72, 12, 36]
                // 1.3 iteração: j = 2, vetor[j] = 72, 72 e 12 trocam de lugar
                    // vetor = [8, 64, 12, 72, 36]
                // 1.4 iteração: j = 3, vetor[j] = 72, 72 e 36 trocam de lugar
                    // vetor = [8, 64, 12, 36, 72]
                // 2.1 iteração: j = 0, vetor[j] = 8
                // 2.2 iteração: j = 1, vetor[j] = 64, 64 e 12 trocam de lugar
                    // vetor = [8, 12, 64, 36, 72]
                // 2.3 iteração: j = 2, vetor[j] = 64, 64 e 36 trocam de lugar
                    // vetor = [8, 12, 36, 64, 72]
                // 3.1 iteração: j = 0, vetor[j] = 8
                // 3.2 iteração: j = 1, vetor[j] = 12
                // 4.1 iteração: j = 0, vetor[j] = 8
                    // Ordenação concluída: vetor = [8, 12, 36, 64, 72]
                if(vetor[j] > vetor[j+1]){
                    int temp = vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = temp;
                }
            }
        }
    }
}
