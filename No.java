public class No<Info>{
    private Info info;
    // elemento abaixo do nó na pilha
    private No<Info> proximo;
    // construtor
    public No(Info info){
        this.info = info;
        this.proximo = null;
    }
    // getters
    public Info getInfo(){
        return info;
    }
    public No<Info> getProximo(){
        return proximo;
    }
    // setters
    public void setInfo(Info info){
        this.info = info;
    }
    public void setProximo(No<Info> proximo){
        this.proximo = proximo;
    }
    @Override
    public String toString(){
        return "|" + info + "|";
    }
}