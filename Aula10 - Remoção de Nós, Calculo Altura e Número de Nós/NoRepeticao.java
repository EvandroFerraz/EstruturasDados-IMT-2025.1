public class NoRepeticao extends No{
    private int ocorrencias;

    public NoRepeticao(int info){
        super(info); // chamando o construtor da classe Mãe, que é No
        ocorrencias = 1;
    }
    public int getOcorrencias(){
        return ocorrencias;
    }
    public void setOcorrencias(int ocorrencias){
        this.ocorrencias = ocorrencias;
    }
    @Override
    public String toString(){
        return super.toString() + ", ocorre " + ocorrencias + " vezes | ";
    }
}