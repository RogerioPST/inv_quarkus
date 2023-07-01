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
import rogerio.pst.services.qualifiers.PRICE;


@ApplicationScoped
@PRICE
public class CalculadoraEmprestimoPRICE implements CalculadoraEmprestimo{
	public TipoEmprestimoDTO calculaParcelas(EntradaSimulacaoDTO simulacao, Produto produto){
		TipoEmprestimoDTO tipoPRICE = new TipoEmprestimoDTO();
		tipoPRICE.setTipo(getTipoEmprestimo());
		List<InformacaoParcelaDTO> parcelas = new ArrayList<>();
		
		if (simulacao.getPrazo() > 0) {			
			BigDecimal saldoDevedorAtual = simulacao.getValorDesejado();
			
			BigDecimal blocoIntermediario = (new BigDecimal(1).add(produto.getPercentualTaxaJuros())).pow(simulacao.getPrazo());
			BigDecimal subTermo = new BigDecimal(1).divide(blocoIntermediario, 6, RoundingMode.HALF_EVEN) ;
			BigDecimal divisor = new BigDecimal(1).subtract(subTermo);
			BigDecimal valorPrestacao = saldoDevedorAtual.multiply(produto.getPercentualTaxaJuros()).divide(divisor,  6, RoundingMode.HALF_EVEN);
			
			for (int numeroParcela = 1; numeroParcela <= simulacao.getPrazo(); numeroParcela++) {								
				BigDecimal valorJuros = saldoDevedorAtual.multiply(produto.getPercentualTaxaJuros());
				BigDecimal valorAmortizacao = valorPrestacao.subtract(valorJuros);				
				InformacaoParcelaDTO parcela = new InformacaoParcelaDTO();
				parcela.setNumero(numeroParcela);
				parcela.setValorAmortizacao(valorAmortizacao.setScale(2, RoundingMode.HALF_EVEN));
				parcela.setValorJuros(valorJuros.setScale(2, RoundingMode.HALF_EVEN));
				parcela.setValorPrestacao(valorPrestacao.setScale(2, RoundingMode.HALF_EVEN));				
				saldoDevedorAtual = saldoDevedorAtual.subtract(valorAmortizacao);
				parcelas.add(parcela);				
			}
		}
		tipoPRICE.setParcelas(parcelas);
		return tipoPRICE;
	}	
	
	public TipoEmprestimoEnum getTipoEmprestimo() {
		return TipoEmprestimoEnum.PRICE;
	}

}
