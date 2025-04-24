import java.util.Random;

public class TesteArvore{
    public static void main(String[] args){
        // criando um objeto de Random para gerar números aleatórios
        Random random = new Random();
        // criando um objeto da classe ArvoreBinaria
        ArvoreBinaria abb = new ArvoreBinaria();
        // criar outro objeto da classe ArvoreBinaria, que vai representar a arvore sem repetições
        ArvoreBinaria abbZip = new ArvoreBinaria(); 

        // preencher a árvore
        for(int i = 1; i <= 100; i++){
            int n = random.nextInt(100); // 0 ate 99
            abb.insere(n);
            // insere n se ele já não estiver na árvore; se n for repetido entao incrementa ocupacao
            abbZip.insereRepeticao(n);
        }
        // imprime todos os nós da árvore em ordem crescente
        System.out.println("Arvore Original: " + abb);
        System.out.println("Arvore Compactada: " + abbZip);
    }
}