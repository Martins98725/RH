
import java.util.Objects;
import java.util.Scanner;

public class Gerente extends Funcionario implements Fun{
    static Estagiario estagiario;
    static  Dev dev;

    private String departamento;
    private int contrato;
    private double salarioGerente;

    public Gerente() {super();;}
    public void aprovarFerias() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Gerente, desaja aprovar?");
        System.out.println("""
                    [1]sim
                    [2]Não""");
        String op = entrada.nextLine();
       if (op.equalsIgnoreCase("1")){
           System.out.println("O gerente " + getNomeFun() + " aprovou suas ferias");
       }
       else {
           System.out.println("O gerente " + getNomeFun() + " negou suas férias" );
       }
       entrada.close();
    }
    public void aprovarPromocao(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Gerente, desaja aprovar?");
        System.out.println("""
                    [1]sim
                    [2]Não""");
        String op = entrada.nextLine();
        if (op.equalsIgnoreCase("1")){
            System.out.println("O gerente " + getNomeFun() + " aprovou sua promoção ");
        }
        else {
            System.out.println("O gerente " + getNomeFun() + " negou sua promoção" );
        }
        entrada.close();

    }
    public void aprovarAumento(){
        System.out.println("Gerente, desaja aprovar?");
        Scanner entrada = new Scanner(System.in);
        System.out.println("Gerente, desaja aprovar?");
        System.out.println("""
                    [1]sim
                    [2]Não""");
        String op = entrada.nextLine();
        if (op.equalsIgnoreCase("1")){
            System.out.println("O gerente " + getNomeFun() + " aprovou suas ferias");
        }
        else {
            System.out.println("O gerente " + getNomeFun() + " negou suas férias" );
        }
        entrada.close();
    }
    @Override
    public void solicitarFerias() {
        System.out.println("O funcinario " + getNomeFun() + "solicitou férias");
        aprovarFerias();
    }
    @Override
    public void promocao() {
        aprovarPromocao();
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getContrato() {
        return contrato;
    }

    public void setContrato(int contrato) {
        this.contrato = contrato;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalarioGerente() {
        return salarioGerente;
    }

    public void setSalarioGerente(double salarioGerente) {
        this.salarioGerente = salarioGerente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Gerente gerente = (Gerente) o;
        return contrato == gerente.contrato && Objects.equals(departamento, gerente.departamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), departamento, contrato);
    }
}