import javax.swing.JOptionPane;

public class PreencherEExibir{
    public static void main(String[] args){
        int[] v = new int[5];
        // automatizar o preenchimento do vetor, utilizando um laço de repetição
        for(int i = 0; i < v.length; i++){
            v[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor: "));
        }
        // exibir o valor de todas as posições do vetor
        int i = 0;
        while(i < v.length){
            System.out.println("A posicao " + i + " eh igual a: " + v[i]);
            i++;
        }
    }
}