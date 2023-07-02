package rogerio.pst.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TotalMovimentacaoPregaoDTO {
	private long total;

	public TotalMovimentacaoPregaoDTO(long total) {
		
		this.total = total;
	}
	
	

}
