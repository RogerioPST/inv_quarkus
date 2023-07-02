package rogerio.pst.dtos;

import java.math.BigDecimal;

import io.quarkus.runtime.annotations.RegisterForReflection;


@RegisterForReflection
public class ProventoAnoMesDTO {	
	private int ano;
	private String anoMes;
	private BigDecimal total;
	public String getAnoMes() {
		return anoMes;
	}
	public void setAnoMes(String anoMes) {
		this.anoMes = anoMes;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public ProventoAnoMesDTO(int ano, String anoMes, BigDecimal total) {
		this.ano = ano;
		this.anoMes = anoMes;
		this.total = total;
	}
	
	
	
}
