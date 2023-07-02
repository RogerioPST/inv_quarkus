package rogerio.pst.dtos;

import java.util.List;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;
import rogerio.pst.entities.Pregao;

@Getter
@Setter
@RegisterForReflection
public class MovimentacoesPregaoDTO {
	
	private Pregao pregao;

	private List<ResumoPorAtivoPregaoDTO> resumosPorAtivo;

	public MovimentacoesPregaoDTO(Pregao pregao, List<ResumoPorAtivoPregaoDTO> resumosPorAtivo) {
		this.pregao = pregao;
		this.resumosPorAtivo = resumosPorAtivo;
	}

	
	
}
