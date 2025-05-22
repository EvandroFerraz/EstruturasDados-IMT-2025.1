public class Entrada<K, V>{
    // K e V simbolizam tipo de dado genéricos
    // Ao invés de limitar o par(chave/valor) em um único tipo de dado
    // Temos a possibilidade de usar qualquer tipo, simbolizado por K e V
    K chave;
    V valor;
    Entrada<K, V> proximo;

    public Entrada(K chave, V valor){
        this.chave = chave;
        this.valor = valor;
        this.proximo = null;
    }
}