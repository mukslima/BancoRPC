package com.gugawag.rpc.banco;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BancoServiceIF extends Remote {
    double saldo(String conta) throws RemoteException;
    int quantidadeContas() throws RemoteException;
    String cadastroConta(String conta, double saldoInicial) throws RemoteException;
    String pesquisarConta(String conta) throws RemoteException;
    String removerConta(String conta) throws RemoteException;
}
