import java.util.Scanner;

public class Funcionario {

    String nome;
    String cpf;
    String telefone;
    String genero;
    String funcao;
    String dataAdimissao;
    Endereco endereco;
    Departamento departamento;

    Scanner sc = new Scanner(System.in);
    Scanner sc2 = new Scanner(System.in);

    Funcionario(Endereco endereco, Departamento departamento) {

        System.out.println("\n -- Registre as Informações do Funcionário --");
        System.out.println("\nDigite o nome: ");
        nome = sc2.nextLine();
        System.out.println("\nDigite o cpf: ");
        cpf = sc2.nextLine();
        System.out.println("\nDigite o telefone: ");
        telefone = sc2.nextLine();
        System.out.println("\nDigite o gênero: \nM - Mascunilo \nF - Feminino ");
        genero = sc2.nextLine();
        System.out.println("\nDigite sua função na empresa: ");
        funcao = sc2.nextLine();
        System.out.println("\nDigite sua data de admissão: ");
        dataAdimissao = sc2.nextLine();

        this.endereco = endereco;
        this.departamento = departamento;
    }

    void exibir() {

        System.out.println("\n -- Informações do Funcionário --");
        System.out.println("\nNome: " + nome);
        System.out.println("\nCPF: " + cpf);
        System.out.println("\nTelefone: " + telefone);

        if (genero.equalsIgnoreCase("M")) {
            System.out.println("\nGênero: Masculino");
        } else {
            System.out.println("\nGênero: Feminino");
        }

        System.out.println("\nFunção na empresa: " + funcao);
        System.out.println("\nDigite sua data de admissão: " + dataAdimissao);

        endereco.exibir();

        departamento.exibir();
    }

    float calcularPagamento(float salarioMinimo, String mes) {

        float pagamento = 0;

        if (funcao.equalsIgnoreCase("Vendedor")) {

            System.out.println("\nDigite o valor das vendas do funcionário em " + mes + ": ");
            float vendas = sc.nextFloat();

            if (vendas <= 2000) {
                pagamento = salarioMinimo;
            } else if (vendas <= 5000) {
                pagamento = salarioMinimo + (vendas * 2 / 100);
            } else {
                pagamento = salarioMinimo + (vendas * 3 / 100);
            }

        } else if (funcao.equalsIgnoreCase("Supervisor")) {

            System.out.println("\nDigite a quantida de horas extras trabalhadas pelo funcionário em " + mes + ": ");
            int horaExtra = sc.nextInt();

            pagamento = salarioMinimo + (50 * horaExtra) + 500;

        } else {

            System.out.println("\nDigite a quantida de horas extras trabalhadas pelo funcionário em " + mes + ": ");
            int horaExtra = sc.nextInt();

            pagamento = salarioMinimo + (50 * horaExtra);
        }

        return pagamento;
    }

    void atualizarFuncao(String funcao) {
        this.funcao = funcao;

        System.out.println("\n----------------------------------------------");
        System.out.println("A função do funcionário " + nome + " foi mudada!");
        System.out.println("----------------------------------------------\n");
    }

}