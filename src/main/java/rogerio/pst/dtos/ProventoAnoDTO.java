package rogerio.pst.dtos;

import java.util.List;

import jakarta.inject.Named;


@Named
public class ProventoAnoDTO {	
	private int ano;
	private List<ProventoMesDTO> meses;
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public List<ProventoMesDTO> getMeses() {
		return meses;
	}
	public void setMeses(List<ProventoMesDTO> meses) {
		this.meses = meses;
	}
	public ProventoAnoDTO(int ano, List<ProventoMesDTO> meses) {
		this.ano = ano;
		this.meses = meses;
	}

	
}
