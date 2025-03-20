public class No { 
    private int info; // Armazena o valor do nó
    private No proximo; // Referência para o próximo nó na lista

    // Construtor da classe N 
    public No (int info) {
        setInfo(info); // Atribui o valor ao campo info
        setProximo(null); // Inicializa a referência do próximo nó como null
    }
    
    // Método que retorna o valor armazenado no nó
    public int getInfo() {
        return info;
    }

    // Método que define um novo valor para o nó
    public void setInfo(int info) {
        this.info = info;
    }

    // Método que retorna a referência para o próximo nó
    public No getProximo() {
        return proximo;
    }

    // Método que define a referência para o próximo nó
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    // Método toString para representação do nó como string
    @Override
    public String toString() {
        return "["+info+"]"; // Retorna o valor do nó dentro de colchetes
    }   
}