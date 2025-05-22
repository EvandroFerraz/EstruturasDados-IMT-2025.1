import java.util.Scanner;

public class ExtracaoDiamantes{
    public static int contarDiamantes(String entrada){
        int diamantes = 0;
        Pilha p = new Pilha(); // Stack()
        // percorremos todos os caracteres da string de entrada
        for(int i = 0; i < entrada.length(); i++){
            char c = entrada.charAt(i);
            if(c == '<'){
                p.push(c);
            }else if(c == '>'){
                // se a pilha não esta vazia
                if(!p.estaVazia()){
                    p.pop(); // desempilhar
                    diamantes++;
                }
            }
        }
        return diamantes;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número de amostras (N):");

        int n = scanner.nextInt();
        scanner.nextLine();

        for(int i = 1; i <= n; i++){
            System.out.println("Digite a " + i + " amostra: ");
            String entrada = scanner.nextLine();
            int diamantes = contarDiamantes(entrada);
            System.out.println("Foram encontrados " + diamantes + " diamantes.");
        }
    }
}