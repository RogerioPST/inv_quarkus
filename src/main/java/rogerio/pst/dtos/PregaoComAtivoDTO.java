package rogerio.pst.dtos;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;
import rogerio.pst.entities.Pregao;

@Data
@RegisterForReflection
public class PregaoComAtivoDTO {
	Pregao pregao;
	String ativo;

}
