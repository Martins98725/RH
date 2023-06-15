import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class RHTeste {
    static  Map<String, Funcionario> listaFuncionarios;
    static Map<String, Dev> listaDev;
    static  Map<String, Estagiario>listaEstagio;
    static Map<String, Gerente> listaGerente;
    static Funcionario func;
    static Gerente gerente;
    static Dev dev ;
    static Estagiario estagiario;
    static  Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String nome, cpf, tele, email, cargo, novoNome;
        listaFuncionarios = new HashMap<>();
        listaDev= new HashMap<>();
        listaEstagio= new HashMap<>();
        listaGerente = new HashMap<>();

        func = new Funcionario();

        boolean rodando = true;
        while (rodando) {

            gerente = new Gerente();
            dev = new Dev();
            estagiario = new Estagiario();

            Pattern patternNome = Pattern.compile("[a-zA-Z]{2,10}");
            Pattern patternCpf = Pattern.compile("\\d{11}");
            Pattern patternTele = Pattern.compile("\\d{11}");
            Pattern patternIdade = Pattern.compile("[0-9]{2}");
            Pattern patternEmail = Pattern.compile("\\s");


            System.out.println("\n \uD83D\uDCBB Bem Vindo ao RHC \uD83D\uDCBB");
            System.out.println("""
                    [1] Cadastrar funcionario
                    [2] Listar funcionários 
                    [3] Remover funcionário
                    [4] Atualizar informações
                    [5] Pesquisar funcionário""");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> {
                    System.out.println("\nNome: ");
                    nome = scanner.nextLine();
                    while (!patternNome.matcher(nome).matches()){
                        System.out.println("Nome inválido. Tente novamente");
                        nome = scanner.nextLine();
                    }
                    System.out.println("Idade: ");
                    String idade = scanner.nextLine();
                    while (!patternIdade.matcher(idade).matches()){
                            System.out.println("Idade inválida. Tente novamente");
                            idade = scanner.nextLine();
                   }
                    System.out.println("CPF: ");
                    cpf = scanner.nextLine();
                   while (!patternCpf.matcher(cpf).matches()){
                        System.out.println("CPF inválido. Tente novamente");
                        cpf = scanner.nextLine();
                    }
                    System.out.println("Telefone com DDD: ");
                    tele = scanner.nextLine();
                    while (!patternTele.matcher(tele).matches()){
                        System.out.println("Telefone inválido. Tente novamente");
                        tele = scanner.nextLine();
                    }
                    System.out.println("Email: ");
                    email = scanner.nextLine();
                    func.setNomeFun(nome);
                    func.setIdadeFun(idade);
                    func.setCpfFun(cpf);
                    func.setTelefoneFun(tele);
                    func.setEmailFun(email);
                    System.out.println("Escolha que tipo de funcionário vai ser: (Gerente, Estagiario ou Desenvolvedor(Dev))");
                    cargo = scanner.nextLine();
                    func.setCargo(cargo);
                    if (cargo.equalsIgnoreCase("gerente")){
                        func.setSalario(10000);
                        gerente.setNomeFun(func.getNomeFun());
                        gerente.setIdadeFun(func.getIdadeFun());
                        gerente.setCpfFun(func.getCpfFun());
                        gerente.setTelefoneFun(func.getTelefoneFun());
                        gerente.setEmailFun(func.getEmailFun());
                        gerente.setCargo(func.getCargo());
                        gerente.setSalario(func.getSalario());
                        func.setSalario(gerente.getSalario());
                        listaGerente.put(cpf, gerente);
                        listaFuncionarios.putAll(listaGerente);
                        func.status();
                    } else if (cargo.equalsIgnoreCase("estagiario")) {
                        func.setSalario(1370);
                        estagiario.setNomeFun(func.getNomeFun());
                        estagiario.setIdadeFun(func.getIdadeFun());
                        estagiario.setCpfFun(func.getCpfFun());
                        estagiario.setTelefoneFun(func.getTelefoneFun());
                        estagiario.setEmailFun(func.getEmailFun());
                        estagiario.setCargo(func.getCargo());
                        estagiario.setSalario(func.getSalario());
                        func.setSalario(estagiario.getSalario());
                        listaEstagio.put(cpf, estagiario);
                        listaFuncionarios.putAll(listaEstagio);
                        func.status();
                    } else if (cargo.equalsIgnoreCase("desenvolvedor") || cargo.equalsIgnoreCase("Dev")) {
                     /*   System.out.println("Sua linguagem: ");
                        String linguagem = scanner.nextLine();*/
                        System.out.println("Seu nível (junior, pleno, senior): ");
                        String nivel = scanner.nextLine();
                        //dev.setLinguagem(linguagem);
                        dev.setNivel(nivel);
                        dev.setNomeFun(func.getNomeFun());
                        dev.setIdadeFun(func.getIdadeFun());
                        dev.setCpfFun(func.getCpfFun());
                        dev.setTelefoneFun(func.getTelefoneFun());
                        dev.setEmailFun(func.getEmailFun());
                        dev.setCargo(func.getCargo());
                        if (nivel.equalsIgnoreCase("junior")){
                            func.setSalario(3500);
                            dev.setSalario(func.getSalario());
                            func.setSalario(dev.getSalario());
                        } else if (nivel.equalsIgnoreCase("pleno")) {
                            func.setSalario(6500);
                            dev.setSalario(func.getSalario());
                            func.setSalario(dev.getSalario());
                        } else if (nivel.equalsIgnoreCase("senior")){
                            func.setSalario(8500);
                            dev.setSalario(func.getSalario());
                            func.setSalario(dev.getSalario());
                        }
                        func.setSalario(dev.getSalario());
                        listaDev.put(cpf, dev);
                        listaFuncionarios.putAll(listaDev);
                        func.status();
                    }
                }
                case "2" -> {
                    if (listaFuncionarios.size() == 0) {
                        System.out.println("Sem funcionários. Cadastre um para realizar esta ação");
                    } else {
                        Consumer<Funcionario> print = i -> System.out.println(
                                "============\uD83D\uDD0E \uD83D\uDCDD============" +
                                        "\nFuncionáro: "
                                        + i.getNomeFun()
                                        + "\nCargo: " + i.getCargo()
                                        + "\nIdade: " + i.getIdadeFun()
                                        + "\nCPF: " + i.getCpfFun()
                                        + "\nSalario: " + i.getSalario());
                        System.out.println("");
                        System.out.println("============\uD83D\uDD0E \uD83D\uDCDD============");
                        System.out.println("Esses são todos os funcionários");
                        listaFuncionarios.entrySet().stream().map(Map.Entry::getValue).forEach(print);
                    }
                }
                case "3" -> {
                    if (listaFuncionarios.size() == 0){
                        System.out.println("Não há funcionários para remover. Cadastre um para realizar esta ação");
                    }
                    else {
                        Consumer<Funcionario>print = i -> System.out.println(
                                "============\uD83D\uDD0E \uD83D\uDCDD============" +
                                        "\nFuncionáro: "
                                        + i.getNomeFun()
                                        + "\nCargo: " + i.getCargo()
                                        + "\nIdade: " + i.getIdadeFun()
                                        + "\nCPF: " + i.getCpfFun()
                                        + "\nSalario: " + i.getSalario());
                        listaFuncionarios.entrySet().stream().map(Map.Entry::getValue).forEach(print);
                        System.out.println("\nDigite o cpf do usuário para a remoção");
                        cpf = scanner.nextLine();
                        listaFuncionarios.remove(cpf);
                        System.out.println("\nFuncionário removido com sucesso ✅");
                    }
                }
                case "4" -> {
                    String novoTele, novoEmail;
                    if (listaFuncionarios.size() == 0){
                        System.out.println("Sem funcionários. Cadastre um para realizar esta ação");
                    }
                    else {
                        Consumer<Funcionario>print = i -> System.out.println(
                                "============\uD83D\uDD0E \uD83D\uDCDD============" +
                                        "\nFuncionáro: "
                                        + i.getNomeFun()
                                        + "\nCargo: " + i.getCargo()
                                        + "\nIdade: " + i.getIdadeFun()
                                        + "\nCpf: " + i.getCpfFun());
                             System.out.println("");
                             System.out.println("============\uD83D\uDD0E \uD83D\uDCDD============");
                             System.out.println("Esses são todos os funcionários");
                             listaFuncionarios.entrySet().stream().map(Map.Entry::getValue).forEach(print);
                             System.out.println("\n \uD83D\uDD0E Digite o cpf do funcionário para atualizá-lo:");
                            cpf = scanner.nextLine();
                            listaFuncionarios.get(cpf);
                            System.out.println("\nO novo nome: ");
                            novoNome = scanner.nextLine();
                            System.out.println("O novo telefone com DDD: ");
                            novoTele = scanner.nextLine();
                            System.out.println("O novo email : ");
                            novoEmail = scanner.nextLine();
                            func.setNomeFun(novoNome);
                            func.setTelefoneFun(novoTele);
                            func.setEmailFun(novoEmail);

                          System.out.println("Deseja atualizar o cargo?");
                          System.out.println("""
                           [1]sim
                           [2]não""");
                          opcao = scanner.nextLine();
                         if (opcao.equals("1")){
                            System.out.println("Escolha que tipo de funcionário vai ser: (Gerente, Desenvolvedor(Dev))");
                            cargo = scanner.nextLine();
                            if (cargo.equalsIgnoreCase("Gerente")){
                                gerente.setNomeFun(func.getNomeFun());
                                gerente.setTelefoneFun(func.getTelefoneFun());
                                gerente.setEmailFun(func.getEmailFun());
                                gerente.setCargo(cargo);
                                gerente.setIdadeFun(func.getIdadeFun());
                                gerente.setCpfFun(func.getCpfFun());
                                gerente.setSalario(func.getSalario());
                                listaGerente.put(cpf, gerente);
                                listaFuncionarios.putAll(listaGerente);
                                System.out.println("\nInformações atualizadas com sucesso ✅");
                                gerente.status();
                            } else if (cargo.equalsIgnoreCase("Desenvolvedor") || cargo.equalsIgnoreCase("Dev")) {
                                System.out.println("Seu nível (junior, pleno, senior): ");
                                String nivel = scanner.nextLine();
                                if (nivel.equalsIgnoreCase("junior")){
                                    func.setSalario(3500);
                                    dev.setSalario(func.getSalario());
                                    func.setSalario(dev.getSalario());
                                } else if (nivel.equalsIgnoreCase("pleno")) {
                                    func.setSalario(6500);
                                    dev.setSalario(func.getSalario());
                                    func.setSalario(dev.getSalario());
                                } else if (nivel.equalsIgnoreCase("senior")){
                                    func.setSalario(8500);
                                    dev.setSalario(func.getSalario());
                                    func.setSalario(dev.getSalario());
                                }
                                dev.setNomeFun(func.getNomeFun());
                                dev.setTelefoneFun(func.getTelefoneFun());
                                dev.setEmailFun(func.getEmailFun());
                                dev.setCargo(cargo);
                                dev.setIdadeFun(func.getIdadeFun());
                                dev.setCpfFun(func.getCpfFun());
                                dev.setSalario(func.getSalario());
                                listaDev.put(cpf, dev);
                                listaFuncionarios.putAll(listaDev);
                                System.out.println("\nInformações atualizadas com sucesso ✅");
                                dev.status();
                            }
                        }
                         else {
                             System.out.println("\nInformações atualizadas com sucesso ✅");
                             func.status();
                         }
                    }
                }
                case "5" ->{
                    if (listaFuncionarios.size() == 0){
                        System.out.println("Sem funcionários. Cadastre um para realizar esta ação");
                    }
                    else {
                        System.out.println("\uD83D\uDD0E Digite o cpf do funcionário para pesquisá-lo: ");
                        System.out.println("CPF: ");
                        cpf = scanner.nextLine();
                        func = listaFuncionarios.get(cpf);
                        Predicate<Map.Entry<String, Funcionario>> pesquisar = a -> a.getValue().equals(func);
                        Consumer<Funcionario> print = p -> System.out.println("Nome: " + p.getNomeFun()
                                    + "\nCargo: " + p.getCargo()
                                    + "\nIdade: " + p.getIdadeFun()
                                    + "\nSalario: " + p.getSalario());

                        listaFuncionarios.entrySet().stream().filter(pesquisar).map(Map.Entry::getValue).forEach(print);
                    }
                }
            }
        }
        scanner.close();
    }
}