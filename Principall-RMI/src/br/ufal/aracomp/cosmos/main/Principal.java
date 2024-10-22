package br.ufal.aracomp.cosmos.main;

import br.ufal.aracomp.cosmos.emprestimo.impl.ComponentFactory;
import br.ufal.aracomp.cosmos.emprestimo.spec.dt.UsuarioDT;
import br.ufal.aracomp.cosmos.emprestimo.spec.prov.IEmprestimoOps;
import br.ufal.aracomp.cosmos.emprestimo.spec.prov.IManager;
import br.ufal.aracomp.sft.connRMI.ConnCli;

public class Principal {
	public static void main(String[] args) {
		// CONFIGURACAO ARQUITETURAL
		// Instanciar o componente Emprestimo
		IManager compEmp = ComponentFactory.createInstance();

		// instanciar o Conector
		ConnCli conn = new ConnCli();
		/// fazer os "bindings"
		compEmp.setRequiredInterface("ILimiteReq", conn);

		// EXECUTAR O SISTEMA
		// obter objeto que implementa a interface provida desejada
		for (int i = 0; i < 10; i++) {

			IEmprestimoOps objEmpOps = (IEmprestimoOps) compEmp.getProvidedInterface("IEmprestimoOps");
			UsuarioDT usuario = new UsuarioDT(); // Instanciar um usu�rio, e se e possivel fazer dessa forma pq o
													// UsuarioDT
													// e publico
			usuario.rendimentos = "1500"; // salario
			System.out.println(objEmpOps.liberarEmprestimoAutomatico(usuario));
		}
	}

}

//Satisfazer as dependencias