public class NoDuplo{
    private int info;
    private NoDuplo anterior;
    private NoDuplo proximo;

    // construtor que inicializa somente info, anterior e proximo são incializados como nulos
    public NoDuplo(int info){
        this.info = info;
    }
    // getters
    public int getInfo(){
        return info;
    }
    public NoDuplo getAnterior(){
        return anterior;
    }
    public NoDuplo getProximo(){
        return proximo;
    }
    // setters
    public void setInfo(int info){
        this.info = info;
    }
    public void setAnterior(NoDuplo anterior){
        this.anterior = anterior;
    }
    public void setProximo(NoDuplo proximo){
        this.proximo = proximo;
    }
    // define a forma textual de como um objeto da classe será representado em uma string 
    @Override
    public String toString(){
        return "["+ info + "]";
    }
}