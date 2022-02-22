package br.ufal.aracomp.sft.connRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Interface remota

public interface IConnSrv2 extends Remote {
	public double calcularLimite(ClienteDTSrv2 client2) throws RemoteException;
}
