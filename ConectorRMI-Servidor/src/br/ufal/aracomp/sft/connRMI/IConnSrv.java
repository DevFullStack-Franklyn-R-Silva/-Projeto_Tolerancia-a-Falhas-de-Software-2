package br.ufal.aracomp.sft.connRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Interface remota

public interface IConnSrv extends Remote {
	public double calcularLimite(ClienteDTSrv client) throws RemoteException;
}
