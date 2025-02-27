public class NossoVetor{
    // 1- método construtor (*)
    // 2- método para inserção e método para redimensionar
    // 3- método para verificar se o vetor esta cheio ou não (*)
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
        // verificar se o vetor esta cheio
        // se o vetor estiver cheio, a gente vai redimensionar 
        // o tamanho
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

}