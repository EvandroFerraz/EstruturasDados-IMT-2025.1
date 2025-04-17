import java.util.Random;
public class TesteFila {
    public static void main(String[] args){
        Fila fila = new Fila(); // capacidade = 10
        Random random = new Random();
    
        for(int i=1; i<=20; i++){ 
            try{
                if(random.nextBoolean()){
                    fila.enfileira(i);
                }else{
                    System.out.println(fila.desenfileira() + " foi atendido.");
                }
                System.out.println(fila);
            }catch(RuntimeException rt){ // se o código do try não funcionar
                System.out.println(rt.getMessage());    
            }
        }
    }
}