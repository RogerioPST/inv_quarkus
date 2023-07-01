package rogerio.pst.dtos;

import java.math.BigDecimal;

import jakarta.inject.Named;

@Named
public class ProventoMesDTO {	
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
	public ProventoMesDTO(String anoMes, BigDecimal total) {
		this.anoMes = anoMes;
		this.total = total;
	}							
}
