package rogerio.pst.dtos;

import java.util.Date;
import java.util.List;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RegisterForReflection
public class MovimentacoesDTO {
	
	private Date dia;

	private List<ResumoPorAtivoDTO> resumosPorAtivo;

	public MovimentacoesDTO(Date dia, List<ResumoPorAtivoDTO> resumosPorAtivo) {
		this.dia = dia;
		this.resumosPorAtivo = resumosPorAtivo;
	}

	
	
}
