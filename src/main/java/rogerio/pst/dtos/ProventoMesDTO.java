package rogerio.pst.dtos;

import java.math.BigDecimal;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

@RegisterForReflection
@Getter
@Setter
public class ProventoMesDTO {	
	private String anoMes;
	private BigDecimal total;
	
	public ProventoMesDTO(String anoMes, BigDecimal total) {
		this.anoMes = anoMes;
		this.total = total;
	}							
}
