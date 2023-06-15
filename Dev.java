import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class Dev extends Funcionario implements Fun {
    static Gerente gerente;
    private String linguagem;
    private String nivel;
    private double salarioDev;
    public Dev() {
        super();
    }

    @Override
    public void solicitarFerias() {
        gerente.aprovarFerias();
    }
    @Override
    public void promocao() {
        gerente.aprovarPromocao();
    }
    public String getLinguagem() {
        return linguagem;
    }
    public String getNivel() {
        return nivel;
    }
    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public double getSalarioDev() {
        return salarioDev;
    }

    public void setSalarioDev(double salarioDev) {
        this.salarioDev = salarioDev;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dev dev = (Dev) o;
        return Objects.equals(linguagem, dev.linguagem) && Objects.equals(nivel, dev.nivel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), linguagem, nivel);
    }
}