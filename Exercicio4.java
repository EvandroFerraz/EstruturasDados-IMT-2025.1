// Classe genérica que representa uma lista dinâmica para armazenar recomendações de produtos
class ListaRecomendacoes<T> {
    private Object[] elementos; // Array interno para armazenar os elementos
    private int tamanho; // Contador de tamanho da lista
    
    // Construtor que inicializa o array com tamanho 10 e define tamanho como 0
    public ListaRecomendacoes() {
        this.elementos = new Object[10]; // Tamanho inicial da lista
        this.tamanho = 0;
    }
    
    // Método para adicionar um item à lista
    public void adicionar(T item) {
        if (tamanho == elementos.length) {
            expandirCapacidade(); // Expande a capacidade do array quando necessário
        }
        elementos[tamanho++] = item; // Adiciona o item na próxima posição disponível
    }
    
    // Método para remover um item da lista
    public void remover(T item) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].equals(item)) { // Encontra o item na lista
                for (int j = i; j < tamanho - 1; j++) {
                    elementos[j] = elementos[j + 1]; // Desloca os elementos para preencher o espaço
                }
                elementos[--tamanho] = null; // Reduz o tamanho e remove a última referência
                return;
            }
        }
    }
    
    // Método para obter um item da lista pelo índice
    public T obter(int indice) {
        if (indice >= 0 && indice < tamanho) {
            return (T) elementos[indice]; // Retorna o item na posição solicitada
        }
        throw new IndexOutOfBoundsException("Índice fora dos limites."); // Exceção para índice inválido
    }
    
    // Método que retorna o tamanho atual da lista
    public int tamanho() {
        return tamanho;
    }
    
    // Método privado para dobrar a capacidade do array quando necessário
    private void expandirCapacidade() {
        Object[] novoArray = new Object[elementos.length * 2]; // Cria um novo array com o dobro do tamanho
        System.arraycopy(elementos, 0, novoArray, 0, elementos.length); // Copia os elementos antigos para o novo array
        elementos = novoArray; // Atualiza a referência para o novo array
    }
}

// Classe que utiliza a ListaRecomendacoes para armazenar recomendações de produtos
class RecomendadorAI {
    private ListaRecomendacoes<String> recomendacoes; // Lista de recomendações de produtos
    
    // Construtor que inicializa a lista de recomendações
    public RecomendadorAI() {
        this.recomendacoes = new ListaRecomendacoes<>();
    }
    
    // Método para adicionar um produto recomendado
    public void adicionarRecomendacao(String produto) {
        recomendacoes.adicionar(produto);
    }
    
    // Método para remover um produto recomendado
    public void removerRecomendacao(String produto) {
        recomendacoes.remover(produto);
    }
    
    // Método para exibir todas as recomendações armazenadas
    public void exibirRecomendacoes() {
        System.out.println("Recomendações de Produtos:");
        for (int i = 0; i < recomendacoes.tamanho(); i++) {
            System.out.println((i + 1) + ". " + recomendacoes.obter(i)); // Exibe os produtos com numeração
        }
    }
}

// Classe principal que contém o método main
public class Exercicio4 {
    public static void main(String[] args) {
        RecomendadorAI recomendador = new RecomendadorAI(); // Criação de um objeto de RecomendadorAI
        
        // Adiciona recomendações passadas como argumentos de linha de comando
        for (String produto : args) {
            recomendador.adicionarRecomendacao(produto);
        }
        
        recomendador.exibirRecomendacoes(); // Exibe as recomendações
        
        // Caso existam recomendações, remove a primeira recomendação da lista
        if (args.length > 0) {
            recomendador.removerRecomendacao(args[0]); // Remove o primeiro produto adicionado
            System.out.println("\nApós remover a primeira recomendação:");
            recomendador.exibirRecomendacoes(); // Exibe a lista após a remoção
        }
    }
}
