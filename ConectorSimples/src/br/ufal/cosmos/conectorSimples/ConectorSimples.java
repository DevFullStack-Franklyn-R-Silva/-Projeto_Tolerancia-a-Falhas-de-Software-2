package br.ufal.cosmos.conectorSimples;
//corretor de adapta��o simples, pq ele nao tem requisito nao funcional, nao implementa distribui��o
import br.ufal.aracomp.cosmos.emprestimo.spec.dt.UsuarioDT;
import br.ufal.aracomp.cosmos.emprestimo.spec.req.ILimiteReq;
import br.ufal.aracomp.cosmos.limite.spec.dt.ClienteDT;
import br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps;

public class ConectorSimples implements ILimiteReq{
	ILimiteOps limiteOps;
	
	public ConectorSimples(ILimiteOps limiteOps) {
		this.limiteOps = limiteOps;
	}
	

	@Override
	public double estimarLimite(UsuarioDT usuario) {
		try {
		ClienteDT cliente = new ClienteDT();   //instanciou um ClienteDT
		cliente.salario = Double.parseDouble(usuario.rendimentos); //Conversor de tipo
		return this.limiteOps.calcularLimite(cliente); //Disparar a interface chamada 
		}
		catch(Exception e) {
			return 0;
		}
	}
}