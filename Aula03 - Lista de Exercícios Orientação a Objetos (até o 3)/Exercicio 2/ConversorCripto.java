// Sobrecarga de Métodos
public class ConversorCripto{

    // converter btc em dólar, sendo 90k o preço atual de 1 btc em dólar
    public double converter(double btc){ // 1 único parâmetro do tipo double
        return  90000 * btc;
    }

    // converter btc em ETH, sendo 35.72 ETH o mesmo preço que 1 bitcoin
    public double converter(double btc, String paraOutraMoeda){ // 2 parâmetros, 1 double e 1 String
        return 35.72 * btc;
    }

    // converter o btc para reais e recebe dois valores por parâmetro: o valor em reais que será convertido e o preço atual do bitcoin em reais
    public double converter(double valorReais, double precoBTCemReais){ // 2 parâmetros do tipo double
        return valorReais * precoBTCemReais;
    }
}