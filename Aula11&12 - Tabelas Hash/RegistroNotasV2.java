import java.util.List;

public class RegistroNotasV2{

    private NossoHash<String,Double> boletim;

    public RegistroNotasV2(){
        boletim = new NossoHash<>();
    }

    // Usa o método put da classe NossoHash para adicionar um novo valor em boletim
    public void cadastraNotas(String aluno, Double nota){
        boletim.put(aluno, nota);
    }

    // Método para pegar as notas de um aluno específico
    public List<Double> getNotas(String aluno){
        return boletim.getListaValores(aluno);
    }

    // Método para imprimir as notas do aluno
    public String notasAluno(String aluno){
        List<Double> notas = getNotas(aluno);

        if(notas == null || notas.isEmpty()) // lista de notas vazia ou não obtida
            return aluno + " nao realizou nenhuma prova";
        
        String s = "";
        for(double nota : notas)
            s += nota + " ";
        return s + "\n";
    }

    // Método para mostrar a média do aluno
    public double mediaAluno(String aluno){
        List<Double> notas = getNotas(aluno);

        if(notas.isEmpty()) return 0.0;

        double soma = 0.0;
        for(double nota : notas)
            soma += nota;

        return soma / notas.size(); // vamos programar uma função para retornar a quantidade de notas
    }

    // Retornar a quantidade de notas
    public int size(){
        return boletim.size();
    }

    // Método que mostra o boletim completo
    public void mostraBoletim(){
        boletim.imprime();
    }

    public static void main(String[] args){
        RegistroNotasV2 registroNotas = new RegistroNotasV2();

        registroNotas.cadastraNotas("Bia", 2.0);
        registroNotas.cadastraNotas("Carlos", 4.0);
        registroNotas.cadastraNotas("Ana", 8.0);
        registroNotas.cadastraNotas("Bia", 7.0);
        registroNotas.cadastraNotas("Carlos", 5.0);
        registroNotas.cadastraNotas("Ana", 6.0);
        registroNotas.cadastraNotas("Denis", 5.0);

        registroNotas.mostraBoletim();

        System.out.println("Notas da Ana: \n" + registroNotas.notasAluno("Ana"));
        System.out.println("Media da Ana: \n" + registroNotas.mediaAluno("Ana"));
    }
}