package rogerio.pst.dtos;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Getter;
import lombok.Setter;
import rogerio.pst.enumerates.TipoEmprestimoEnum;

@Getter
@Setter
public class TipoEmprestimoDTO {
	
	@Schema (description = "Tipo de empréstimo: SAC, PRICE")
	private TipoEmprestimoEnum tipo;

	@Schema (description = "Dados relacionados às parcelas de cada tipo de empréstimo")
	private List<InformacaoParcelaDTO> parcelas;

}
