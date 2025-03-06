import java.util.Random;

public class TesteNossoVetor{
    public static void main(String[] args){
        
        NossoVetor v1 = new NossoVetor(5);
        NossoVetor v2 = new NossoVetor(); // tamanho padrão = 10

        // inserindo um único elemento
        /*v1.insere(2);
        v2.insere(30);

        // imprimindo o vetor: a forma de impressão foi definida pelo método toString()
        // na classe NossoVetor
        System.out.println("primeiro vetor \n: " + v1);
        System.out.println("segundo vetor \n: " + v2);

        // removendo um único elemento
        v1.remove();
        System.out.println("primeiro elemento excluido de v1: \n" + v1);*/

        // inserindo vários elementos (11) no vetor
        // ocupacao = 11 e tamanho = 20
        for(int i = 0; i <= 10; i++){
            v1.insere(i);
            // System.out.println("Elemento Inserido: " + i + " Tamanho Atual: " + v1.getTamanho());
        }
        // System.out.println("Informações completas do vetor v1: \n " + v1);*/
        
        System.out.println("O numero 7 foi encontrado na posicao: " + v1.pesquisaValor(7));

        // Removendo vários elementos (9) do vetor
        /*for(int i = 0; i < 9; i++){
            int a = v1.remove();
            System.out.println("Elemento Removido: " + a + " Tamanho Atual: " + v1.getTamanho());
        }
        System.out.println("Informações completas do vetor v1: \n " + v1);*/

        // excluindo todos os elementos do vetor v1
        // repete o bloco de código enquanto o vetor v1 não estiver vazio
       /* while(!v1.estaVazio()){
            v1.remove();
        }
        System.out.println("Vetor esvaziado com sucesso");
        System.out.println(" Ocupacao: " + v1.getOcupacao());
        System.out.println(" Tamanho: " + v1.getTamanho());*/

        // teste inserindo 200 números gerados de forma randômica no vetor v2
        /*Random r = new Random();
        String s = "";
        for(int i = 0; i <= 200; i++){
            int n = r.nextInt()+2*+r.nextInt();
            v2.insere(n);
            s += " " + n;
        }
        System.out.println(s);
        System.out.println("O tamanho atual do vetor eh: " + v2.getTamanho());*/
    }
}