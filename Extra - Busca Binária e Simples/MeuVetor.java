import java.util.Random;

public class MeuVetor {
    private double[] v;
    private int ultimaPos;

    public MeuVetor (int capacidade) {
        v = new double[capacidade];
        ultimaPos = -1;
    }
    //métodos de acesso
    public int getUltimaPos() {
        return ultimaPos;
    }
    public double[] getV() {
        return v;
    }
    //métodos modificadores
    public void setUltimaPosicao(int pos) {
        if (pos >= 0 && pos < v.length) {
            ultimaPos = pos;
        }
        else {
            ultimaPos = v.length - 1;
        }
    }

    public boolean estaCheio () {
        return ultimaPos == v.length-1;
    }

    public boolean estaVazio () {
        return ultimaPos == -1;
    }

    public void resetVetor() {
        ultimaPos = -1;
    }

    public void adiciona(int elemento) {
        if (estaCheio()) {
            redimensiona(v.length*2);
        }
        v[++ultimaPos] = elemento;
    }

    public void adiciona(double elemento) {
        if (estaCheio()) {
            redimensiona(v.length*2);
        }
        v[++ultimaPos] = elemento;
    }
    
    public double remove() {
        if (estaVazio()) return 0;
        double aux = v[ultimaPos--];
        if (v.length >= 10 && ultimaPos <= v.length / 4) {
            redimensiona(v.length/2);
        }
        return aux;
    }

    private void redimensiona(int novaCapacidade) {
        double[] temp = new double[novaCapacidade];
        for (int i = 0; i <= ultimaPos; i++) {
            temp[i] = v[i];
        }
        v = temp;
    }

    @Override
    public String toString() {
        String s = "";
        if (estaVazio()) {
            s = s + "vetor vazio";
        }
        else {
            for (int i=0; i <= ultimaPos; i++) {
                s = s + String.format("%.0f", v[i]) + " ";
            }
        }
        s = s + "\n";
        return s;
    }

    public void preencheVetor () {
        Random r = new Random();
        for (int i=0; i<v.length; i++) {
            adiciona(r.nextInt(v.length * 10) + 1);
        }
    }
    public void preencheVetor (int limite) {
        Random r = new Random();
        for (int i=0; i<v.length; i++) {
            adiciona(r.nextInt(limite) + 1);
        }
    }
    public int bubbleSort () {
        int cont=0;
        for (int i=1; i<v.length; i++) {
            for (int j=0; j<v.length-i; j++) {
                cont++;
                if (v[j] > v[j+1]) {
                    double aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] = aux;
                }
            }
        }
        return cont;
    }

    // buscaSimples e buscaBinaria retornando valores inteiros
    /*public int buscaSimples(int valorPesquisado){  

        for(int i = 0; i < v.length; i++){
        
            if(v[i] == valorPesquisado){
                return i;
            }
        }
        return -1;
    }
    
    public int buscaBinaria(int valorPesquisado){
        int inicio = 0, fim = ultimaPos;

        while(inicio <= fim){
            int meio = (inicio+fim)/2;

            if(v[meio] == valorPesquisado){
                return valorPesquisado;
            }

            if(valorPesquisado > v[meio]){
                inicio = meio+1;
            }else{ // valorPesquisado <= v[meio]
                fim = meio - 1;
            }
        }
        return -1;
    }*/

    public Retorno buscaSimples(int valorPesquisado){  
        Retorno r = new Retorno();

        for(int i = 0; i < v.length; i++){
            r.incrementaContador();

            if(v[i] == valorPesquisado){
                r.setAchou(true);
                return r;
            }
        }
        return r;
    }

    public Retorno buscaBinaria(int valorPesquisado){
        int inicio = 0, fim = ultimaPos;
        Retorno r = new Retorno();

        while(inicio <= fim){
            int meio = (inicio+fim)/2;
            r.incrementaContador();

            if(v[meio] == valorPesquisado){
                r.setAchou(true);
                return r;
            }

            if(valorPesquisado > v[meio]){
                inicio = meio+1;
            }else{ // valorPesquisado <= v[meio]
                fim = meio - 1;
            }
        }
        return r;
    }
}














