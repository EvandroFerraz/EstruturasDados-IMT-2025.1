import javax.swing.JOptionPane;

public class TestesElementaresComVetores {
    public static void main(String[] args){
        // as posições vão de 0 até 3 totalizando 4 elementos
        int[] v1 = new int[4]; // int v2[];
        v1[0] = 2;
        System.out.println("A primeira posicao eh: " + v1[0]);
        v1[1] = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor para a 2 posicao"));
        System.out.println("A segunda posicao eh: " + v1[1]);
        int r = v1[0] + v1[1];
        System.out.println("A soma das posicoes: " + r);
    }
}