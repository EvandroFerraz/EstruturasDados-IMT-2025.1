import java.util.Scanner;
import java.util.Date;

public class TesteOrdenacao{
    public static void main(String[] args){
        NossoVetor v;
        Scanner scanner = new Scanner(System.in);

        int t;
        System.out.println("Escolha o tamanho do vetor, 0 encerra: ");
        t = scanner.nextInt();

        while(t > 0){
            v = new NossoVetor(t);
            v.preencheVetor();
            //System.out.println("O vetor original: " + v);
            long ini = new Date().getTime();
            // chamar o bubble, que vai demorar x segundos
            v.bubbleSort();
            long fim = new Date().getTime();
            //System.out.println("O vetor ordenado: " + v);
            System.out.println("Bubble Demorou: " + (fim-ini)
             + " milisegundos.");

            System.out.println("Escolha o tamanho do vetor, 0 encerra: ");
            t = scanner.nextInt();
        }
        scanner.close();
    }
}