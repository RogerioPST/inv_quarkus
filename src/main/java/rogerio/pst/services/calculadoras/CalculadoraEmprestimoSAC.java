package rogerio.pst.services.calculadoras;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import rogerio.pst.dtos.EntradaSimulacaoDTO;
import rogerio.pst.dtos.InformacaoParcelaDTO;
import rogerio.pst.dtos.TipoEmprestimoDTO;
import rogerio.pst.entities.Produto;
import rogerio.pst.enumerates.TipoEmprestimoEnum;
import rogerio.pst.services.qualifiers.SAC;

@ApplicationScoped
@SAC
public class CalculadoraEmprestimoSAC implements CalculadoraEmprestimo{
	
	public TipoEmprestimoDTO calculaParcelas(EntradaSimulacaoDTO simulacao, Produto produto){
		TipoEmprestimoDTO tipoSAC = new TipoEmprestimoDTO();
		tipoSAC.setTipo(getTipoEmprestimo());
		List<InformacaoParcelaDTO> parcelas = new ArrayList<>();
		
		if (simulacao.getPrazo() > 0) {					
			BigDecimal saldoDevedorAtual = simulacao.getValorDesejado();		
			BigDecimal valorAmortizacao = simulacao.getValorDesejado().divide(new BigDecimal(simulacao.getPrazo()),  6, RoundingMode.HALF_EVEN);
	
			for (int numeroParcela = 1; numeroParcela <= simulacao.getPrazo(); numeroParcela++) {				
				BigDecimal valorJuros = saldoDevedorAtual.multiply(produto.getPercentualTaxaJuros());
				BigDecimal valorPrestacao = valorAmortizacao.add(valorJuros);				
				InformacaoParcelaDTO parcela = new InformacaoParcelaDTO();
				parcela.setNumero(numeroParcela);
				parcela.setValorAmortizacao(valorAmortizacao.setScale(2, RoundingMode.HALF_EVEN));
				parcela.setValorJuros(valorJuros.setScale(2, RoundingMode.HALF_EVEN));
				parcela.setValorPrestacao(valorPrestacao.setScale(2, RoundingMode.HALF_EVEN));				
				saldoDevedorAtual = saldoDevedorAtual.subtract(valorAmortizacao);
				parcelas.add(parcela);				
			}
		}
		tipoSAC.setParcelas(parcelas);
		return tipoSAC;
	}	
	
	public TipoEmprestimoEnum getTipoEmprestimo() {
		return TipoEmprestimoEnum.SAC;
	}

}
