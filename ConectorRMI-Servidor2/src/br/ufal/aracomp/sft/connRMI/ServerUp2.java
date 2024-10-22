package br.ufal.aracomp.sft.connRMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.ufal.aracomp.cosmos.limite.impl.ComponentFactory;
import br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps;
import br.ufal.aracomp.cosmos.limite.spec.prov.IManager;
//Programa principal para levantar o servidor

public class ServerUp2 {
	public static void main(String[] args) {
		// distribui��o de parte da configura��o arquitetural
		// Limite
		IManager compLimite = ComponentFactory.createInstance();

		// Conector
		ILimiteOps limiteOps;
		limiteOps = (ILimiteOps) compLimite.getProvidedInterface("ILimiteOps"); // Instancia do objeto que de fato � o
																				// conector
		try {
			IConnSrv2 connSrv = new ConnectorRMIServidor2(limiteOps);
			Registry rgsty = LocateRegistry.createRegistry(1888);
			rgsty.rebind("ConnSrv2", connSrv);
//			LocateRegistry.createRegistry(1098); // Cria��o da porta para levantar o servidor
//			Naming.rebind("rmi://localhost/ConnSrv", connSrv);
			
			System.out.println("Conector RMI (servidor 2) OK");
		} catch (RemoteException e) {
			e.printStackTrace();
		} 
	}
}
