package rogerio.pst.dtos;

import jakarta.inject.Named;
import lombok.Data;
import rogerio.pst.entities.Pregao;

@Data
@Named
public class PregaoComAtivoDTO {
	Pregao pregao;
	String ativo;

}
