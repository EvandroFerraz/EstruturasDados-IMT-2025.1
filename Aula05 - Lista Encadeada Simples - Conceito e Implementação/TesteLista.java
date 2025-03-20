public class TesteLista {
    public static void main(String[] args) { 
        ListaSimples lista = new ListaSimples(); // Cria uma nova lista encadeada
        System.out.println("lista foi criada!!");

        try {
            //System.out.println(lista.removeInicio() + " foi removido do inicio");
            //System.out.println("lista depois da remocao no inicio\n" + lista); // Exibe a lista após a remoção

            lista.insereInicio(5); // Insere o valor 5 no início
            lista.insereInicio(8); // Insere o valor 8 no início
            lista.insereInicio(15); // Insere o valor 15 no início
            lista.insereInicio(20); // Insere o valor 20 no início
            System.out.println("lista depois das insercoes de inicio\n" + lista); // Exibe a lista após as inserções

            System.out.println(lista.removeFim() + " foi removido do fim"); // Remove o último elemento e exibe o valor removido
            System.out.println("lista depois da remocao no fim\n" + lista); // Exibe a lista após a remoção

            lista.insereFim(7); // Insere o valor 7 no final
            lista.insereFim(11); // Insere o valor 11 no final
            System.out.println("lista depois da insercao no fim\n" + lista); // Exibe a lista após as inserções
        }
        catch (RuntimeException e) { // Captura exceções de remoção em listas vazias
            System.out.println(e.getMessage()); // Exibe a mensagem de erro
        }
    }
}