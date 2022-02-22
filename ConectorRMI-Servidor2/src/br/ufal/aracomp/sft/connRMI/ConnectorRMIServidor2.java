package br.ufal.aracomp.sft.connRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import br.ufal.aracomp.cosmos.limite.spec.dt.ClienteDT;
import br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps;

//Classe que implementa a interface remota

public class ConnectorRMIServidor2 extends UnicastRemoteObject implements IConnSrv2 {
	private static final long serialVersionUID = 5534335014110610733L;
	
	private ILimiteOps limiteOps;
	protected ConnectorRMIServidor2(ILimiteOps limiteOps) throws RemoteException {
		super();
		this.limiteOps = limiteOps;
	}
	@Override 
	public double calcularLimite(ClienteDTSrv2 clientSrv) throws RemoteException {
		try {	
			ClienteDT client = new ClienteDT();
			client.salario = clientSrv.salario;
			return this.limiteOps.calcularLimite(client);
		} catch (Exception e) {
			return 0;
		}
	}
}


//Criar uma lista de servidores, pesos que cada servidor vai aguentar, contadores, index do servidor atual, para controller 
