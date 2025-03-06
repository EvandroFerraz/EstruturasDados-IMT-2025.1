// AssistenteFinanceiro herda o método responderPergunta(String pergunta)
public class AssistenteFinanceiro extends AssistenteVirtual{
    // sobrescrevendo o método (de mesmo nome) da classe mãe
    public void responderPergunta(String pergunta){
        System.out.println("Resposta Financeira");
    }
}