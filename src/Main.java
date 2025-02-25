import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    Banco banco = new Banco();
    Scanner scanner = new Scanner(System.in);
    int opcao;

    do{
        System.out.println("\n--- Sistema Bancário ---");
            System.out.println("1. Criar Conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Verificar Saldo");
            System.out.println("5. Listar Contas");
            System.out.println("6. Remover Conta");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.print("Digite o número da conta: ");
                    String numeroConta = scanner.nextLine();
                    System.out.print("Digite o nome do titular: ");
                    String titular = scanner.nextLine();
                    ContaBancaria novaConta = new ContaBancaria(numeroConta, titular);
                    banco.adicionarConta(novaConta);
                    break;

                case 2:
                    System.out.print("Digite o número da conta: ");
                    numeroConta = scanner.nextLine();
                    ContaBancaria contaDeposito = banco.encontrarConta(numeroConta);
                    if (contaDeposito != null) {
                        System.out.print("Digite o valor para depositar: ");
                        double valorDeposito = scanner.nextDouble();
                        contaDeposito.depositar(valorDeposito);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o número da conta: ");
                    numeroConta = scanner.nextLine();
                    ContaBancaria contaSaque = banco.encontrarConta(numeroConta);
                    if (contaSaque != null) {
                        System.out.print("Digite o valor para sacar: ");
                        double valorSaque = scanner.nextDouble();
                        contaSaque.sacar(valorSaque);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o número da conta: ");
                    numeroConta = scanner.nextLine();
                    ContaBancaria contaSaldo = banco.encontrarConta(numeroConta);
                    if (contaSaldo != null) {
                        contaSaldo.verificarSaldo();
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 5:
                    banco.listarcontas();
                    break;

                case 6:
                    System.out.print("Digite o número da conta para remover: ");
                    numeroConta = scanner.nextLine();
                    banco.removerConta(numeroConta);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}