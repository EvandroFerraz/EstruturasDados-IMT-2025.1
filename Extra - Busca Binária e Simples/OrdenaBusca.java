import java.util.Scanner;

public class OrdenaBusca {
    public static void main(String[] args){
        // Cria, preencher com valores e imprimir um vetor
        MeuVetor v1 = new MeuVetor(120000);
        v1.preencheVetor();
        System.out.println("vetor gerado: \n" + v1);

        // Fazer a leitura do valor digitado pelo usuario
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um valor para a busca:");
        int x = sc.nextInt();

        // Aplicação da busca simples
        Retorno r = v1.buscaSimples(x);
        if(r.getAchou()){
            System.out.println(x + " encontrado pela busca simples.");
        }else{
            System.out.println(x + " não foi encontrado.");
        }
        System.out.println("foram realizados " + r.getContador() 
        + " testes na busca simples");

        //Aplicação da busca binária
        v1.bubbleSort();
        r = v1.buscaBinaria(x);

        if(r.getAchou()){
            System.out.println(x + "encontrado pela busca binaria");
        }else{
            System.out.println(x + " não foi encontrado.");
        }
        System.out.println("foram realizadas " + r.getContador()
        + " testes pela busca binária");

        sc.close();
    }
}
