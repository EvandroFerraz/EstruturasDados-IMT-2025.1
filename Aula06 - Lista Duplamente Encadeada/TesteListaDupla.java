public class TesteListaDupla{
    public static void main(String[] args){
        ListaDupla listaDupla = new ListaDupla();
        System.out.println("lista foi construida: " + listaDupla);
        listaDupla.insereInicio(10);
        listaDupla.insereInicio(20);
        listaDupla.insereInicio(30);
        System.out.println("lista depois das insercoes no inicio: \n" + listaDupla);
        listaDupla.insereFim(15);
        listaDupla.insereFim(25);
        listaDupla.insereFim(35);
        System.out.println("lista depois das insercoes no fim: \n" + listaDupla);
        try{
            System.out.println(listaDupla.removeInicio() + " foi removido do Inicio");
            System.out.println(listaDupla);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
        try{
            System.out.println(listaDupla.removeFim() + " foi removido do Fim");
            System.out.println(listaDupla);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}