public class Recursao{
    static long fatorialIterativo(int n){
        long f  = 1;
        /*for(int i = 2; i <= n; i++){
            f *= i; // f = f * i
        }*/
        while(n > 1){
            f *= n--;
        }
        return f;
    }

    static long fatorialRecursivo(int n){
        // Parte 1: Critério Base, que é a condição de parada
        if (n <= 1) return 1;
        // Parte 2: Recursão, retorna um cálculo que depende do resultado de outra 
        // chamada da função
        return n * fatorialRecursivo(n-1);
    }
    // Teste de mesa considerando n = 4
    // 1º fatorialRecursivo(4); 4 <= 1 é falso, então chamamos fatorialRecursivo(3)
    // 2º fatorialRecursivo(3); 3 <= 1 é falso, então chamamos fatorialRecursivo(2)
    // 3º fatorialRecursivo(2); 2 <= 1 é falso, então chamamos fatorialRecursivo(1)
    // 4º fatorialRecursivo(1); 1 <= 1 é verdadeira, então retorna 1 quebrando a recursão
    // Resolvemos fatorialRecursivo(1), voltamos nas chamadas empilhadas resolvendo uma a uma.
    // Voltamos para a 3ª chamada empilhada: retorna 2 * 1 = 2, que seria n * fatorialRecursivo(1)
    // Resolvemos fatorialRecursivo(2), voltamos para a 2ª chamada.
    // Voltamos para 2º fatorialRecursivo(3): retorna 3 * 2 = 6, que seria n * fatorialRecursivo(2)
    // Resolvemos fatorialRecursivo(3), voltamos para a 1ª chamada.
    // Voltamos para 1º fatorialRecursivo(4): retorna 4 * 6 = 24.

    static long fibonacciIterativo(int n){
        // fib(n) = fib(n-1) + fib(n-2)
        if(n < 2) return 1;
        long[] v = new long[n];
        v[0] = 1;
        v[1] = 1;
        for(int i = 2; i < n; i++){
            v[i] = v[i-1] + v[i-2];
        }
        return v[n-1];
    }

    static long fibonacciRecursivo(int n){
        // Parte 1: Critério Base
        if(n <= 1) return 1;
        // Parte 2: Recursividade
        return fibonacciRecursivo(n-1) + fibonacciRecursivo(n-2);
    }
    
    // Soma de 1 até n 
    static int somaIterativa(int n){
        int soma = 0;
        for(int i = 1; i <= n; i++){
            soma += i;
        }
        return soma;
    }
    static int somaRecursiva(int n){
        // Parte 1: Critério Base
        if(n == 1) return 1;
        // Parte 2: Recursividade
        return n + somaRecursiva(n - 1);
    }
    // Teste de Mesa para n = 4
    // 1ª chamada: soma(4) = 4 + soma(3)
    // 2ª chamada: soma(3) = 3 + soma(2)
    // 3ª chamada: soma(2) = 2 + soma(1)
    // 4ª chamada: soma(1) = 1, atinge o critério base e volta resolvendo as chamadas empilhadas:
    // Resolve 3ª chamada: soma(2) = 2 + 1 = 3
    // Resolve 2ª chamada: soma(3) = 3 + 3 = 6
    // Resolve 1º chamada: soma(4) = 4 + 6 = 10, resultado de soma(4) = 10

    // Imprime o inverso de uma string usando recursão
    static void imprimeInvertido(String s){
        //Parte 1: Critério Base
        if(s.isEmpty()) return;
        //Parte 2: Recursividade
        imprimeInvertido(s.substring(1));
        System.out.println(s.charAt(0));
    }
    // Teste de mesa para s = "ABC"
    // 1ª chamada imprimeInvertido("ABC")
    // 2ª chamada imprimeInvertido("BC")
    // 3ª chamada imprimeInvertido("C")
    // 4ª chamada imprimeInvertido(""), atinge o critério base
    // Impressão após o retorno, ele volta e execute as chamadas de 3 até 1
    // Executa 3ª chamada: imprimir o "C"
    // Executa 2ª chamada: imprimir o "B"
    // Executa 1ª chamada: imprimir o "A"

    public static void main(String[] args){

        // Teste de impressão do inverso de uma string
        imprimeInvertido("ABCDE");

        // Teste da soma recursiva
        /*for(int i = 4; i <= 10; i++){
            System.out.println("Soma dos numeros entre 1 e " + i + ": " + somaRecursiva(i));
        }*/

        // Imprime a sequencia de fibonacci de 5 até 10
        /*for(int i = 6; i <= 11; i++){
            System.out.println("Fibonacci Iterativo de " + (i - 1) + " = " + 
                fibonacciIterativo(i));
        }
        for(int i = 5; i <= 10; i++){
            System.out.println("Fibonacci Recursivo de " + i + " = " + 
                fibonacciRecursivo(i));
        }*/
        // Imprime o fatorial de 5 até 10
        /*for(int i = 5; i <= 10; i++){
            System.out.println("Fatorial Iterativo de " + i + " = " + 
                fatorialIterativo(i));
        }
        for(int i = 5; i <= 10; i++){
            System.out.println("Fatorial Recursivo de " + i + " = " + 
                fatorialRecursivo(i));
        }*/
    }
}