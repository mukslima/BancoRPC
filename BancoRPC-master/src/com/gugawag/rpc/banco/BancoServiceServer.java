package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private final Map<String, Double> saldoContas;

    public BancoServiceServer() throws RemoteException {
        saldoContas = new HashMap<>();
        saldoContas.put("1", 100.0);
        saldoContas.put("2", 156.0);
        saldoContas.put("3", 950.0);
    }

    @Override
    public double saldo(String conta) throws RemoteException {
        return saldoContas.getOrDefault(conta, 0.0);
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return saldoContas.size();
    }

    @Override
    public String cadastroConta(String conta, double saldoInicial) throws RemoteException {
        if (saldoContas.containsKey(conta)) {
            return "Conta já existente!";
        }
        saldoContas.put(conta, saldoInicial);
        return "Conta cadastrada com sucesso!";
    }

    @Override
    public String pesquisarConta(String conta) throws RemoteException {
        if (saldoContas.containsKey(conta)) {
            return "Conta: " + conta + ", Saldo: R$" + saldoContas.get(conta);
        }
        return "Conta não encontrada!";
    }

    @Override
    public String removerConta(String conta) throws RemoteException {
        if (saldoContas.remove(conta) != null) {
            return "Conta removida com sucesso!";
        }
        return "Conta não encontrada!";
    }
}