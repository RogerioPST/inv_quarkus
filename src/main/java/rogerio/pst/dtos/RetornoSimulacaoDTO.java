package rogerio.pst.dtos;

import java.math.BigDecimal;
import java.util.List;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RetornoSimulacaoDTO {

	@Schema (description = "Código do produto de empréstimo filtrado na busca")
	private Long codigoProduto;

	@Schema (description = "Descrição do produto de empréstimo filtrado na busca")
	private String descricaoProduto;

	@Schema (description = "Taxa de juros do produto de empréstimo filtrado na busca")
	private BigDecimal taxaJuros;

	@Schema (description = "Dados relacionados aos tipos de empréstimos calculados")
	private List<TipoEmprestimoDTO> resultadoSimulacao;	
	
	@Schema (description = "atributo para identificar o json enviado ao event hub")
	private String correlationId;

}
