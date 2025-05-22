public class TesteHash{

    public static void main(String[] args){
        NossoHash<Integer, String> mapa = new NossoHash<>();
        mapa.put(522448246, "São Caetano do Sul");
        mapa.put(2173713, "São Bernardo do Campo");
        mapa.put(2173713, "Santo Andre");
        System.out.println(mapa.get(2173713));
        mapa.imprime();
        String cidade = mapa.remove(2173713);
        if(cidade != null){
            System.out.println(cidade + " removida");
        }else{
            System.out.println("chave não foi encontrada");
        }
        mapa.imprime();
        if(mapa.containsKey(1266838)){
            System.out.println(1266838 + " está no mapa");
        }else{
            System.out.println(1266838 + " não está no mapa");
        }
        if(mapa.containsValue("Santo Andre")){
            System.out.println("estã no mapa");
        }else{
            System.out.println("não está no mapa");
        }
    }

    // Fila pronta do Java = Queue
    // Queue<String> fila = new LinkedList<>();
    // fila.add("Ana");
    // fila.add("Pedro");
    // fila.contains("Ana"); // true
    // fila.poll(); // remove o primeiro elemento da fila, no caso a Ana

    // Pilha pronta do Java = Stack
    // Stack<Integer> pilha = new Stack<>();
    // pilha.push(10); // inserir um novo elemento na pilha
    // pilha.push(11);
    // pilha.contains(10); // true
    // pilha.pop(); // remove o último elemento da pilha, no caso o 11

    // Lista Ligada do Java = ArrayList
    // ArrayList<String> lista = new ArrayList<>();
    // lista.add("Evandro");
    // lista.add("Carol");
    // lista.contains("Joao"); // false
    // lista.remove("Evandro"); // remove um elemento da lista e ja recalcula as posicoes
}