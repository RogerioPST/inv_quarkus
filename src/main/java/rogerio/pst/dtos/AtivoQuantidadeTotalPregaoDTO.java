package rogerio.pst.dtos;

import java.math.BigDecimal;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;
import rogerio.pst.entities.Pregao;


@Getter
@Setter
@RegisterForReflection
public class AtivoQuantidadeTotalPregaoDTO {

	private Pregao pregao;

	private String ativo;

	private BigDecimal total;
	
	private long totalQuantidade;

	private String operacao;

	public AtivoQuantidadeTotalPregaoDTO(Pregao pregao, String ativo, BigDecimal total, long totalQuantidade,
			String operacao) {
		this.pregao = pregao;
		this.ativo = ativo;
		this.total = total;
		this.totalQuantidade = totalQuantidade;
		this.operacao = operacao;
	}			
}
