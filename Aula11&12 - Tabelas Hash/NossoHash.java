import java.util.List;
import java.util.ArrayList;

// Tabela Hash será específica para uma combinação de K e V
public class NossoHash <K, V> {
    // Representa a Tabela Hash
    private Entrada<K, V> [] tabela;
    private int capacidade = 10;

    // Inicializar a Tabela Hash
    public NossoHash(){
        tabela = new Entrada[capacidade];
    }

    // Calcular o índice da tabela, utilizando o valor da chave como base,
    // Onde será guardado o objeto Entrada<K, V>
    private int hash(K chave){
        return Math.abs(chave.hashCode()) % capacidade;
    }

    // Colocar um novo valor na Tabela
    public void put(K chave, V valor){
        // Encontrar o índice da tabela onde o novo valor será inserido   
        int indice = hash(chave);
        Entrada<K,V> novo = new Entrada<>(chave, valor);

        //inserção de ínicio
        // Inserindo ("banana", 12) no indice 3
        // Ja temos no indice 3, ("manga", 10)
        // Nesse caso, novo.proximo = ("manga", 10); ("banana", 12) > ("manga", 10)
        // tabela[indice] =  ("banana", 12) > ("manga", 10)
        novo.proximo = tabela[indice];
        tabela[indice] = novo;
    }

    // método de busca
    public V get(K chave){
        int indice = hash(chave);
        Entrada<K, V> atual = tabela[indice]; // busca O(1)
        while(atual != null){ // percorrer a lista ligada
            if(atual.chave.equals(chave))
                return atual.valor;
            atual = atual.proximo;
        }
        return null;
    }

    // Verificar se a tabela tem uma chave específica
    public boolean containsKey(K chave){
        int indice = hash(chave);

        Entrada<K, V> atual = tabela[indice];
        while(atual != null){ // percorre a lista ligada
            if(atual.chave.equals(chave)){
                return true;
            }
            atual = atual.proximo;
        }
        return false; // chave não existe
    }

    // Verificar se a tabela tem um valor específico, sem saber a chave
    public boolean containsValue(V valor){ // Complexidade O(n)
        for(int indice = 0; indice < capacidade; indice++){
            Entrada<K, V> atual = tabela[indice];
            while(atual != null){ // percorrer toda a lista ligada
                if(atual.valor.equals(valor))
                    return true;
                atual = atual.proximo;
            }
        }
        return false; // o valor não existe na tabela
    }

    // imprime todos os pares chave/valor na tabela
    public void imprime(){
        for(int i=0; i < capacidade; i++){ // percorrendo os índices da tabela
            System.out.println("Posicao: " + i);
            Entrada<K, V> atual = tabela[i];
            while(atual != null){
                System.out.println("{chave: " + atual.chave 
                    + ", valor: " + atual.valor + "}");
                atual = atual.proximo;
            }
            System.out.println("-------------");
        }
    }

    // Remove um par chave/valor da tabela
    public V remove(K chave){
        int indice = hash(chave);
        V valor = null;
        // O valor que será removido esta na primeira posição da lista ligada
        if(tabela[indice].chave.equals(chave)){
            valor = tabela[indice].valor;
            // Removendo a ("banana", 12) em ("banana", 12) > ("manga", 10), teriamos
            // ("manga", 10) sobrepoe ("banana", 12) e se torna a primeira posicao
            // da lista ligada
            tabela[indice] = tabela[indice].proximo;
            return valor;
        }
        // O valor que será removido esta da segunda posição em diante
        Entrada<K, V> atual = tabela[indice].proximo; // segundo
        Entrada<K, V> anterior = tabela[indice];
        while(atual != null){
            if(atual.chave.equals(chave)){
                valor = atual.valor;
                anterior.proximo = atual.proximo; // sobrepondo o atual pelo proximo
                return valor;
            }
            anterior = atual;
            atual = atual.proximo;
        }
        return valor; // valor nulo, então o par chave/valor não esta na tabela
    }

    // Verificar se a tabela está vazia ou não
    public boolean isEmpty(){
        for(int i=0; i<capacidade; i++){
            if(tabela[i] != null)
                return false; // nao esta vaiza se existir pelo menos um par
        }
        return true; // percorremos toda a tabela e nao econtramos nenhum valor
    }

    // Retornar todos os valores (V) de uma lista ligada em uma posicao tabela[indice] que possuem a mesma chave
    // tabela[indice] = ("banana", 12) > ("manga", 10) > ("abacaxi", 7) > ("abacaxi", 14)
    public List<V> getListaValores(K chave){ // chave = "abacaxi"
        List<V> lista = new ArrayList<>();
        int indice = hash(chave);

        Entrada atual = tabela[indice]; // atual = ("banana", 12)
        while(atual != null){
            if(chave.equals(atual.chave))
                lista.add((V)atual.valor);
            atual = atual.proximo;
        }
        // 1 iteracao: atual = ("banana", 12)
        // 2 iteracao: atual = ("manga", 10)
        // 3 iteracao: atual = ("abacaxi", 7), lista = [7]
        // 4 iteracao: atual = ("abacaxi", 14), lista = [7, 14]
        return lista;
    }

    // Encontra o tamanho da tabela hash = número de elementos (objetos da classe Entrada) dentro dela
    public int size(){
        int s = 0;
        for(int i=0; i < capacidade; i++){
            Entrada<K,V> atual = tabela[i];
            while(atual != null){
                s++;
                atual = atual.proximo;
            }
        }
        return s;
    }
}