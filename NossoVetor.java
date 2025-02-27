public class NossoVetor{
    // 1- método construtor (*)
    // 2- método para inserção e método para redimensionar (*)
    // 3- método para verificar se o vetor esta cheio ou vazio (*)
    // 4- método para remoção
    // 5- teste

    private int ocupacao;
    private int[] vetor;

    public NossoVetor(int tamanho){
        vetor = new int[tamanho];
        ocupacao = 0;
    }
    // substitui o construtor padrão do java
    // cria um vetor com 10 elementos por padrão
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
    // o vetor estará vazio se a quantidade de elemtnos for zero
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
}