package rogerio.pst.services.calculadoras;

import rogerio.pst.dtos.EntradaSimulacaoDTO;
import rogerio.pst.dtos.TipoEmprestimoDTO;
import rogerio.pst.entities.Produto;
import rogerio.pst.enumerates.TipoEmprestimoEnum;

public interface CalculadoraEmprestimo {	
	
	public TipoEmprestimoDTO calculaParcelas(EntradaSimulacaoDTO simulacao, Produto produto);			
	public TipoEmprestimoEnum getTipoEmprestimo();	
}
