package br.ufal.aracomp.sft.connRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import br.ufal.aracomp.cosmos.emprestimo.spec.dt.UsuarioDT;
import br.ufal.aracomp.cosmos.emprestimo.spec.req.ILimiteReq;

//Implementar a interface requirida do componente limite
public class ConnCli implements ILimiteReq {
	private IConnSrv connSrv;
	private IConnSrv2 connSrv2;

	private List<Integer> peso = Arrays.asList(3, 5);
	int index = 0;
	int contador = 0;

	public ConnCli() {
		// Instaqncia��o do lado servidor via RMI
		try {
			this.connSrv = (IConnSrv) Naming.lookup("rmi://localhost:1099/ConnSrv");
			this.connSrv2 = (IConnSrv2) Naming.lookup("rmi://localhost:1888/ConnSrv2");

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public double estimarLimite(UsuarioDT usuario) {
		try {
			
			if (contador != peso.get(index)) {
				ClienteDTSrv cliente = new ClienteDTSrv();
				cliente.salario = Double.parseDouble(usuario.rendimentos);
				contador += 1;
				System.out.println("Chamou o servidor 1");
				return this.connSrv.calcularLimite(cliente);
			} else {
				ClienteDTSrv2 cliente = new ClienteDTSrv2();
				cliente.salario = Double.parseDouble(usuario.rendimentos);
				contador = 0;
				index += 1;
				System.out.println("Chamou o servidor 2");
				
				return this.connSrv2.calcularLimite(cliente);
			}
		} catch (RemoteException e) {
			// Tentar algo diferente
			// Conector server2
			System.err.println("Conector server2");
			return 0;
		} catch (Exception e) {
			return 0;
		}
	}
}
