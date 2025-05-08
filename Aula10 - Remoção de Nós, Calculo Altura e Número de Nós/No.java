public class No{
    // atributos
    private int info;
    private No esquerda;
    private No direita;

    // construtor
    public No(int info){
        this.info = info;
    }

    // getters
    public int getInfo(){
        return info;
    }
    public No getEsquerda(){
        return esquerda;
    }
    public No getDireita(){
        return direita;
    }
    
    // setters
    public void setInfo(int info){
        this.info = info;
    }
    public void setEsquerda(No esquerda){
        this.esquerda = esquerda;
    }
    public void setDireita(No direita){
        this.direita = direita;
    }

    //toString()
    @Override
    public String toString(){
        return info + "";
    }
}