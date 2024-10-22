package br.ufal.aracomp.sft.connRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import br.ufal.aracomp.cosmos.limite.impl.ComponentFactory;
import br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps;
import br.ufal.aracomp.cosmos.limite.spec.prov.IManager;
//Programa principal para levantar o servidor

public class ServerUp {
	public static void main(String[] args) {
		//distribui��o de parte da configura��o arquitetural
		//Limite
		IManager compLimite = ComponentFactory.createInstance();
		
		//Conector
		ILimiteOps limiteOps;
		limiteOps = (ILimiteOps)compLimite.getProvidedInterface("ILimiteOps"); //Instancia do objeto que de fato � o conector 
		try {
			IConnSrv connSrv = new ConnectorRMIServidor(limiteOps);
			LocateRegistry.createRegistry(1099); //Cria��o da porta para levantar o servidor
			Naming.rebind("rmi://localhost/ConnSrv", connSrv);
			System.out.println("Conector RMI (servidor 1) OK");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} 
	}
}
