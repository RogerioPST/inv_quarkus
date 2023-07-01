package rogerio.pst.dtos;

import java.util.Date;
import java.util.List;

import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named
public class MovimentacoesDTO {
	
	private Date dia;

	private List<ResumoPorAtivoDTO> resumosPorAtivo;

	public MovimentacoesDTO(Date dia, List<ResumoPorAtivoDTO> resumosPorAtivo) {
		this.dia = dia;
		this.resumosPorAtivo = resumosPorAtivo;
	}

	
	
}
