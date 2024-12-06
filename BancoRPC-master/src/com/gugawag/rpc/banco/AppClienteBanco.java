package com.gugawag.rpc.banco;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class AppClienteBanco {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        String ipServidor = args.length > 0 ? args[0] : "127.0.0.1"; // Recebe IP do servidor
        Registry registry = LocateRegistry.getRegistry(ipServidor, 1099);
        BancoServiceIF banco = (BancoServiceIF) registry.lookup("BancoService");

        menu();
        Scanner entrada = new Scanner(System.in);
        int opcao = entrada.nextInt();

        while (opcao != 9) {
            switch (opcao) {
                case 1: {
                    System.out.println("Digite o número da conta:");
                    String conta = entrada.next();
                    System.out.println(banco.saldo(conta));
                    break;
                }
                case 2: {
                    System.out.println("Quantidade de contas: " + banco.quantidadeContas());
                    break;
                }
                case 3: {
                    System.out.println("Digite o número da nova conta:");
                    String conta = entrada.next();
                    System.out.println("Digite o saldo inicial:");
                    double saldo = entrada.nextDouble();
                    System.out.println(banco.cadastroConta(conta, saldo));
                    break;
                }
                case 4: {
                    System.out.println("Digite o número da conta para pesquisar:");
                    String conta = entrada.next();
                    System.out.println(banco.pesquisarConta(conta));
                    break;
                }
                case 5: {
                    System.out.println("Digite o número da conta para remover:");
                    String conta = entrada.next();
                    System.out.println(banco.removerConta(conta));
                    break;
                }
            }
            menu();
            opcao = entrada.nextInt();
        }
    }

    public static void menu() {
        System.out.println("\n=== BANCO GUGAWAG ===");
        System.out.println("1 - Saldo da conta");
        System.out.println("2 - Quantidade de contas");
        System.out.println("3 - Cadastrar nova conta");
        System.out.println("4 - Pesquisar conta");
        System.out.println("5 - Remover conta");
        System.out.println("9 - Sair");
    }
}
