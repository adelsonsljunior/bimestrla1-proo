import java.util.Scanner;
// teste
public class Endereco {

    String rua;
    String bairro;
    String cep;
    String cidade;

    Scanner sc = new Scanner(System.in);

    Endereco() {

        System.out.println("\n -- Registre o Endereço do Funcionário --");
        System.out.println("\nDigite o nome da cidade: ");
        cidade = sc.nextLine();
        System.out.println("\nDigite o nome do bairro: ");
        bairro = sc.nextLine();
        System.out.println("\nDigite o nome da rua: ");
        rua = sc.nextLine();
        System.out.println("\nDigite o CEP: ");
        cep = sc.nextLine();
    }

    void exibir() {
        
        System.out.println("\n -- Endereço do Funcionário --");
        System.out.println("\nCidade: " + cidade);
        System.out.println("\nBairro: " + bairro);
        System.out.println("\nRua: " + rua);
        System.out.println("\nCEP: " + cep);
    }

}
