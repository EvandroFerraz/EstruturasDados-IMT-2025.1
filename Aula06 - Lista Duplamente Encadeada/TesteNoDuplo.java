public class TesteNoDuplo{
    public static void main(String[] args){
        NoDuplo no1 = new NoDuplo(10);
        NoDuplo no2 = new NoDuplo(20);

        System.out.println("no1: " + no1);
        System.out.println("no2: " + no2);

        no1.setProximo(no2); // no1 é o primeiro nó da lista [no1 -> no2]
        no2.setAnterior(no1);

        no1.getProximo().setInfo(500); // atribuindo o valor 500 para o atributo info de no2
        no2.getAnterior().setInfo(1000); // atribuindo o valor 1000 para o atributo info de no1

        System.out.println("no1 atualizado: " + no1);
        System.out.println("no2 atualizado: " + no2);
    }
}