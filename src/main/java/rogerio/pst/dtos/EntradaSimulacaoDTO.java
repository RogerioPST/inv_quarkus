package rogerio.pst.dtos;

import java.math.BigDecimal;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntradaSimulacaoDTO {

	@NotNull
	@Schema (description = "Valor desejado para pegar de empréstimo")
	private BigDecimal valorDesejado;

	@Schema (description = "Prazo para pagamento do empréstimo")
	private Integer prazo;	
}
