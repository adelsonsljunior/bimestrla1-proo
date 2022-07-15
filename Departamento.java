import java.util.Scanner;

public class Departamento {

    int codigo;
    String nome;
    String responsavel;

    Scanner sc = new Scanner(System.in);
    Scanner sc2 = new Scanner(System.in);

    Departamento() {

        System.out.println("\n -- Registre as Informações do Departameneto --");
        System.out.println("\nDigite o código:");
        codigo = sc.nextInt();
        System.out.println("\nDigite o nome:");
        nome = sc2.nextLine();
        System.out.println("\nDigite o nome do resonsável:");
        responsavel = sc2.nextLine();
    }

    void exibir() {

        System.out.println("\n -- Informações do Departameneto --");
        System.out.println("\nCódigo: " + codigo);
        System.out.println("\nNome: " + nome);
        System.out.println("\nResonsável:" + responsavel);
    }
}