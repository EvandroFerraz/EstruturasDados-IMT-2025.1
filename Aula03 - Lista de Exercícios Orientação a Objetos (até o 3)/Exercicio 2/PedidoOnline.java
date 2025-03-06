// Item 2.1
public class PedidoOnline{
    private String produto;
    private double precoUnitario;
    private int quantidade;
    
    // inicializa a quantidade = 1
    public PedidoOnline(String produto, double precoUnitario){
        quantidade = 1;
        this.produto = produto;
        this.precoUnitario = precoUnitario;
    }

    // inicializa a quantidade a partir do parâmetro recebido
    public PedidoOnline(String produto, double precoUnitario, int quantidade){
        this.quantidade = quantidade;
        this.produto = produto;
        this.precoUnitario = precoUnitario;
    }

    public static void main(String[] args){
        PedidoOnline pedido1 = new PedidoOnline("goiaba", 1.5); // foi comprada só 1 goiaba
        PedidoOnline pedido2 = new PedidoOnline("maca", 1, 10); // foram compradas 10 maças
        System.out.println("Pedido1: \n Produto: " + pedido1.produto + 
        " Preco: " + pedido1.precoUnitario + " Quantidade: " + pedido1.quantidade);
        System.out.println("Pedido2: \n Produto: " + pedido2.produto + 
        " Preco: " + pedido2.precoUnitario + " Quantidade: " + pedido2.quantidade);
    }
}