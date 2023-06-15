import java.util.Objects;
// salario o usuario tem que definir

public  class Funcionario {
    static Gerente gerente;
    static Estagiario estagiario;
    static Dev dev;

    private String nome;
    private String email;
    private String cpf;
    private String idade;
    private String telefone;
    private String cargo;
    private double salario;
    public Funcionario() {
    }
    public void status(){
        //fazer algumas condições para cada classe
        System.out.printf("\nNome: %s", this.getNomeFun());
        System.out.printf("\nIdade: %s", this.getIdadeFun());
        System.out.printf("\nEmail: %s", this.getEmailFun());
        System.out.printf("\nTelefone: %s", this.getTelefoneFun());
        System.out.printf("\nCargo: %s", this.getCargo());
        System.out.printf("\nCPF: %s", this.getCpfFun());
       System.out.printf("\nSalário: %.2f\n\n", this.getSalario());
    }

    public String getNomeFun() {
        return nome;
    }
    public void setNomeFun(String nome) {
        this.nome = nome;
    }
    public String getEmailFun() {
        return email;
    }

    public void setEmailFun(String email) {
        this.email = email;
    }

    public String getCpfFun() {
        return cpf;
    }

    public void setCpfFun(String cpf) {
        this.cpf = cpf;
    }

    public String getIdadeFun() {
        return idade;
    }

    public void setIdadeFun(String idade) {
        this.idade = idade;
    }

    public String getTelefoneFun() {
        return telefone;
    }

    public void setTelefoneFun(String telefone) {
        this.telefone = telefone;
    }
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return idade == that.idade && Objects.equals(nome, that.nome) && Objects.equals(email, that.email) && Objects.equals(cpf, that.cpf) && Objects.equals(telefone, that.telefone) && Objects.equals(cargo, that.cargo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, cpf, idade, telefone, cargo);
    }
}