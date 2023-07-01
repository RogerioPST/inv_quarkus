package rogerio.pst.dtos;

import java.math.BigDecimal;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InformacaoParcelaDTO {

	@Schema (description = "Número da parcela do empréstimo")
	private Integer numero;
	@Schema (description = "Valor da amortização da parcela do empréstimo")
	private BigDecimal valorAmortizacao;
	@Schema (description = "Valor do juros da parcela do empréstimo")
	private BigDecimal valorJuros;
	@Schema (description = "Valor da prestação da parcela do empréstimo")
	private BigDecimal valorPrestacao;

}
