package rogerio.pst.dtos;

import java.math.BigDecimal;

import io.quarkus.runtime.annotations.RegisterForReflection;
import rogerio.pst.entities.Pregao;


@RegisterForReflection
public class AtivoQuantidadeTotalDTO {

	private Pregao pregao;

	private String ativo;

	private BigDecimal total;
	
	private long totalQuantidade;

	public Pregao getPregao() {
		return pregao;
	}

	public void setPregao(Pregao pregao) {
		this.pregao = pregao;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public long getTotalQuantidade() {
		return totalQuantidade;
	}

	public void setTotalQuantidade(long totalQuantidade) {
		this.totalQuantidade = totalQuantidade;
	}

	public AtivoQuantidadeTotalDTO(Pregao pregao, String ativo, BigDecimal total, long totalQuantidade) {
		this.pregao = pregao;
		this.ativo = ativo;
		this.total = total;
		this.totalQuantidade = totalQuantidade;
	}
	
	
}
