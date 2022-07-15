import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);
    Scanner sc2 = new Scanner(System.in);

    ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    ArrayList<Funcionario> funcionariosDemitidos = new ArrayList<Funcionario>();

    Menu() {

        System.out.println("\n===================================================================");
        System.out.println("                           NOVA ARAPIRCA ");
        System.out.println("===================================================================\n");

        int opcao = 0;

        do {
            System.out.println("\n*******************************************************************");
            System.out.println("                 -- CONTROLE DE FUNCIONÁRIOS --");
            System.out.println("*******************************************************************");
            System.out.println("1 - Cadastrar funcionário");
            System.out.println("2 - Exibir funcionários cadastrados");
            System.out.println("3 - Exibir quanto a empressa vai pagar aos funcionários cadastrados");
            System.out.println("4 - Mudar a função de um determinado funcionário");
            System.out.println("5 - Demitir funcionário");
            System.out.println("6 - Sair");
            System.out.println("*******************************************************************");
            opcao = sc.nextInt();
            System.out.println("*******************************************************************\n");

            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    if (funcionarios.isEmpty()) {
                        semFuncionarios();
                    } else {
                        exibirFuncionarios();
                    }
                    break;
                case 3:
                    if (funcionarios.isEmpty()) {
                        semFuncionarios();
                    } else {
                        pagarFuncionarios();
                    }
                    break;
                case 4:
                    if (funcionarios.isEmpty()) {
                        semFuncionarios();
                    } else {
                        mudarFuncao();
                    }
                    break;
                case 5:
                    if (funcionarios.isEmpty()) {
                        semFuncionarios();
                    } else {
                        demitirFuncionario();
                    }
                    break;
                case 6:
                    System.out.println("\nSAINDO...");
                    System.out.println("\nPROGRAMA ENCERRADO");
                    break;
                default:
                    System.out.println("\n------------------------");
                    System.out.println("     OPÇÃO INVÁLIDA");
                    System.out.println("------------------------\n");
                    break;
            }

        } while (opcao != 6);

    }

    void cadastrarFuncionario() {
        System.out.println("\n -- CADASTRO DE FUNCIONÁRIOS --");
        Departamento departamentoAux = new Departamento();
        Endereco enderecoAux = new Endereco();
        Funcionario funcionarioAux = new Funcionario(enderecoAux, departamentoAux);
        funcionarios.add(funcionarioAux);
    }

    void exibirFuncionarios() {
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println("\n  === " + (i + 1) + "º Funcionário ===");
            funcionarios.get(i).exibir();
        }
    }

    void pagarFuncionarios() {

        float pagamentoTotal = 0f;

        System.out.println("Digite o mês do pagamento: ");
        String mes = sc2.nextLine();

        System.out.println("\nDigite o valor do salário-mínimo:");
        float salarioMinimo = sc.nextFloat();

        for (int i = 0; i < funcionarios.size(); i++) {

            System.out.println("\n  === " + (i + 1) + "º Funcionário ===");
            pagamentoTotal += funcionarios.get(i).calcularPagamento(salarioMinimo, mes);
        }

        System.out.println("\n--------------------------------------------------------------------------------------------");
        System.out.println("A empresa vai pagar R$ " + pagamentoTotal + " para todos os funcionários cadastrados em " + mes);
        System.out.println("--------------------------------------------------------------------------------------------\n");
    }

    void mudarFuncao() {
        System.out.println("\nDigite o nome do funcionário: ");
        String nome = sc2.nextLine();

        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).nome.equalsIgnoreCase(nome)) {
                System.out.println("\nDigite a nova função do funcionário: ");
                String novaFuncao = sc2.nextLine();
                funcionarios.get(i).atualizarFuncao(novaFuncao);
            }
        }
    }

    void demitirFuncionario() {
        System.out.println("\nDigite o nome do funcionário: ");
        String nome = sc2.nextLine();
        
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).nome.equalsIgnoreCase(nome)) {
                funcionariosDemitidos.add(funcionarios.get(i));
                funcionarios.remove(i);
                System.out.println("\n----------------------------------------------");
                System.out.println("   O funcionário " + nome + " foi demitido!");
                System.out.println("----------------------------------------------\n");
            }
        }
    }

    void semFuncionarios() {
        System.out.println("\n------------------------------------------");
        System.out.println("     Não há funcionários cadastrados!");
        System.out.println("------------------------------------------\n");
    }

}