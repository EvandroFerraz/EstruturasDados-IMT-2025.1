public class ListaSimples {
    private No primeiro; // Referência para o primeiro nó da lista
    private No ultimo; // Referência para o último nó da lista

    // Método que verifica se a lista está vazia
    public boolean estaVazia() {
        return primeiro == null; // Retorna true se a lista não tiver nós
    }

    // Método para inserir um elemento no início da lista
    public void insereInicio (int elemento) {
        No novo = new No(elemento); // Cria um novo nó com o valor fornecido
        if (estaVazia()) { // Se a lista estiver vazia
            ultimo = novo; // O novo nó será também o último
        }
        else { // Caso contrário
            novo.setProximo(primeiro); // O novo nó aponta para o antigo primeiro nó
        }
        primeiro = novo; // O novo nó se torna o primeiro nó da lista
    }

    // Método para remover um elemento do início da lista
    public int removeInicio() {
        if (estaVazia()) throw new RuntimeException("lista vazia, nao ha o que remover"); // Lança exceção se a lista estiver vazia
        
        int removido = primeiro.getInfo(); // Obtém o valor do primeiro nó
        primeiro = primeiro.getProximo(); // O segundo nó se torna o primeiro nó

        if (primeiro == null) { // Se a lista ficou vazia após a remoção
            ultimo = null; // Atualiza a referência do último nó para null
        }
        return removido; // Retorna o valor removido
    }

    // Método para representar a lista como uma string
    @Override
    public String toString() {
        String s = "lista: ";
        if (estaVazia()) {
            s = s + "vazia"; // Caso a lista esteja vazia, retorna "lista: vazia"
        }
        else {
            No runner = primeiro; // Começa pelo primeiro nó
            while (runner != null) { // Percorre até o final da lista
                s = s + runner + "->"; // Adiciona cada nó à string
                runner = runner.getProximo(); // Avança para o próximo nó
            }
            s = s + runner + " \\\\"; // Indica o final da lista
        }
        return s + "\n"; // Retorna a string formatada
    }

    // Método para inserir um elemento no fim da lista
    public void insereFim (int elemento) {
        No novo = new No(elemento); // Cria um novo nó com o valor fornecido
        if (estaVazia()) { // Se a lista estiver vazia
            primeiro = novo; // O novo nó se torna o primeiro nó
        }
        else { // Caso contrário
            ultimo.setProximo(novo); // O antigo último nó aponta para o novo nó
        }
        ultimo = novo; // O novo nó se torna o último nó da lista
    }

    // Método para remover um elemento do fim da lista
    public int removeFim () {
        if (estaVazia()) throw new RuntimeException("lista vazia, nao ha o que remover"); // Lança exceção se a lista estiver vazia
        
        int removido = ultimo.getInfo(); // Obtém o valor do último nó
        if (primeiro == ultimo) { // Se houver apenas um nó na lista
            primeiro = null; // A lista se torna vazia
            ultimo = null;
        }
        else { // Caso a lista tenha mais de um nó
            No runner = primeiro; // Começa pelo primeiro nó
            while (runner.getProximo() != ultimo) // Percorre até o penúltimo nó
                runner = runner.getProximo();
            
            runner.setProximo(null); // O penúltimo nó não aponta mais para o último
            ultimo = runner; // O penúltimo nó se torna o novo último nó
        }
        return removido; // Retorna o valor removido
    }
}