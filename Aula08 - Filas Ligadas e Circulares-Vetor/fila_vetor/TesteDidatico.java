import java.util.Random;

public class TesteDidatico{
    public static void main(String[] args){
        Fila fila = new Fila(); // capacidade = 10
        Random random = new Random();

        // laço para inserir ou retirar numeros aleatorias na fila
        for(int i = 1; i <= 100; i++){
            try {
                if(random.nextBoolean()){ // 50% de chance de gerar true e 50% de gerar false
                    fila.enfileira(random.nextInt(10));
                }else{
                    System.out.println(fila.desenfileira() + " saiu");
                }
                System.out.println(fila);
                System.out.println("primeiro: " + fila.primeiro + "\nultimo: " + fila.ultimo);
                System.out.println(fila.stringVetor());
            }catch (RuntimeException rt){ // se nao conseguir executar

            }
        }
    }
}