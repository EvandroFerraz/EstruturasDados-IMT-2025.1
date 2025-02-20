public class TesteComHeranca{
    public static void main(String[] args){
        AlunoDeGraduacao aluno = new AlunoDeGraduacao();

        aluno.setNome("Evandro");
        aluno.setIdade(30);
        System.out.println("Nome: " + aluno.getNome() + " Idade: " + aluno.getIdade());


        // sobrecarga de métodos

        // soma(int,int)
        // soma(double, double, double)
        // soma(String, String)
    }
}