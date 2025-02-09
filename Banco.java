import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
    private static ArrayList<Conta> contas = new ArrayList<>();
    private static int numeroContaAtual = 1; // Começa no 1 e incrementa a cada nova conta
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Ver saldo");
            System.out.println("3 - Sacar");
            System.out.println("4 - Depositar");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    consultarSaldo();
                    break;
                case 3:
                    realizarSaque();
                    break;
                case 4:
                    realizarDeposito();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void criarConta() {
        scanner.nextLine(); // Limpa o buffer
        System.out.print("Nome do titular: ");
        String nome = scanner.nextLine();

        System.out.print("Saldo inicial: ");
        float saldoInicial = scanner.nextFloat();

        Conta novaConta = new Conta(nome, numeroContaAtual, saldoInicial);
        contas.add(novaConta);
        System.out.println("Conta criada com sucesso! Número da conta: " + numeroContaAtual);
        numeroContaAtual++;
    }

    private static void consultarSaldo() {
        Conta conta = buscarConta();
        if (conta != null) {
            conta.exibirSaldo();
        }
    }

    private static void realizarSaque() {
        Conta conta = buscarConta();
        if (conta != null) {
            System.out.print("Digite o valor para saque: ");
            float valor = scanner.nextFloat();
            conta.sacar(valor);
        }
    }

    private static void realizarDeposito() {
        Conta conta = buscarConta();
        if (conta != null) {
            System.out.print("Digite o valor para depósito: ");
            float valor = scanner.nextFloat();
            conta.depositar(valor);
        }
    }

    private static Conta buscarConta() {
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroConta) {
                return conta;
            }
        }
        System.out.println("Conta não encontrada!");
        return null;
    }
}
