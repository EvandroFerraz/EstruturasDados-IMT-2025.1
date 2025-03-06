public class CarteiraCripto{
    // final deixa o valor de um atributo imutável: Assim que o primeiro valor é recebido, ele não pode mais ser alterado.
    private final String enderecoCarteira;
    private String dono;
    private double saldoBitcoin;

    public CarteiraCripto(String enderecoCarteira, String dono, double saldoBitcoin){
        this.enderecoCarteira = enderecoCarteira;
        this.dono = dono;
        this.saldoBitcoin = saldoBitcoin;
    }

    public void adicionarSaldo(double acrescimo){
        saldoBitcoin += acrescimo;
    }

    public void sacarSaldo(double decrescimo){
        if(saldoBitcoin >= decrescimo){
            saldoBitcoin -= decrescimo;
        }else{
            System.out.println("Saldo Insuficiente");
        }
    }

    public String getEnderecoCarteira(){
        return enderecoCarteira;
    }

    public String getDono(){
        return dono;
    }

    public void setDono(String dono){
        if(dono == ""){
            System.out.println("O valor de dono não pode ser vazio");
        }else{
            this.dono = dono;
        }
    }

    public double getSaldoBitcoin(){
        return saldoBitcoin;
    }

    public static void main (String[] args){
        CarteiraCripto carteira = new CarteiraCripto("1X","Evandro", 1);

        carteria.adicionarSaldo(2); // saldo = 3
        System.out.println("Valor atual na carterira: " + carteira.getSaldoBitcoin());
        carteria.sacarSaldo(1); // saldo = 2
        System.out.println("Valor atual na carterira: " + carteira.getSaldoBitcoin());
        carteria.setDono("Evandro2");
        System.out.println("Novo Dono: " + carteira.getDono());
    }
}