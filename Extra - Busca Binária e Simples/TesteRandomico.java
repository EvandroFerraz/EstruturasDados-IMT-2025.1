import java.util.Scanner;

public class TesteRandomico {
    public static void main(String[] args) {
        MeuVetor v1 = new MeuVetor(6);
        MeuVetor v2 = new MeuVetor(6);
 
        v1.preencheVetor();
        System.out.println(v1);

        v2.preencheVetor(20);
        System.out.println(v2);

        /*Scanner sc = new Scanner(System.in);
        System.out.println("Digite um valor para a busca simples: ");
        int valorPesquisado = sc.nextInt();
        int posicao = v1.buscaSimples(valorPesquisado);

        if(posicao != -1){
            System.out.println("Valor encontrado na posição de indice "
             + posicao);
        }else{ //posicao == -1
            System.out.println("Valor não encontrado");
        }

        v2.bubbleSort();

        System.out.println("Digite um valor para a busca binária:");
        valorPesquisado = sc.nextInt();
        int x = v2.buscaBinaria(valorPesquisado);

        if(x != -1){
            System.out.println("Valor encontrado: "
            + x);
        }else{
            System.out.println("Valor nao encontrado"); 
        }*/
    }
}