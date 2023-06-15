
import java.util.Objects;

public class Estagiario extends Funcionario{
    static  Gerente gerente;
    static Funcionario func;
    private int duracaoEstagio;
    private String instituicao;
    private String curso;
    private double salarioEstagi;
    public Estagiario() {
        super();
    }

    public void solicitarPromocao(){
        gerente.aprovarPromocao();
    }

    public double getSalarioEstagi() {
        return salarioEstagi;
    }

    public void setSalarioEstagi(double salarioEstagi) {
        this.salarioEstagi = salarioEstagi;
    }

    public double getDuracaoEstagio() {
        return duracaoEstagio;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setDuracaoEstagio(int duracaoEstagio) {
        this.duracaoEstagio = duracaoEstagio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Estagiario that = (Estagiario) o;
        return duracaoEstagio == that.duracaoEstagio && Objects.equals(instituicao, that.instituicao) && Objects.equals(curso, that.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), duracaoEstagio, instituicao, curso);
    }
}