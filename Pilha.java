public class Pilha<Info> {
    private No<Info> topo;
    private int tamanho;

    // utilizaremos o construtor padrão

    public int getTamanho() {
        return tamanho;
    }

    public boolean estaVazia(){
        return topo == null;
    }

    //push = método para empilhar/inserir um elemento ao topo da pilha
    // |5| |6| |9| |0|, então topo = |5|
    public void push(Info info){
        No<Info> novo = new No<Info>(info);
        // |7| é o novo nó
        if(!estaVazia()){// se topo != null
            novo.setProximo(topo); // que |5| está abaixo de |7|, então
            // o |7| é o topo da pilha   
        }
        topo = novo; // topo = |7|
        tamanho++; //tamanho = tamanho + 1
    }

    //pop = método que desempilha, ou seja, exclui o nó que está 
    // no topo da pilha
    // |carta1| |carta2| |carta3| |carta4|
    public Info pop(){
        if(estaVazia()){ 
            return null;
        }
        Info info = topo.getInfo(); //info = carta1
        topo = topo.getProximo(); //sobreposicao do nó |carta1| 
        // pelo nó |carta2|
        // pilha atualizada: |carta2| |carta3| |carta4|
        tamanho--; // tamanho = tamanho - 1
        return info; // retronando o objeto que estava guardado no
        // nó que foi excluído, que seria a  carta1
    }
    public Info consultaTopo () {
        if (estaVazia()) return null;
        return topo.getInfo();
    }
    @Override
    public String toString(){
        if(estaVazia()) return "pilha vazia";
        
        No<Info> aux = topo; // aux = |carta1|
        String s = "";
        
        // Considerando a pilha: |carta1| |carta2| |carta3| |carta4|
        while(aux != null){
            s += aux + "\n";
            aux = aux.getProximo();
            // aux = |carta2|, depois da primeira iteração
            // aux = |carta3|, depois da segunda iteração
            // aux = |carta4|, depois da terceira iteração
            // aux = null, depois da quarta iteração
        }
        return s;
    }
}
