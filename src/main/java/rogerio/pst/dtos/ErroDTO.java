package rogerio.pst.dtos;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErroDTO {

	@Schema (description = "Código de retorno")
	private Integer codigo;
	@Schema (description = "Mensagem de retorno")
	private String mensagem;
}
