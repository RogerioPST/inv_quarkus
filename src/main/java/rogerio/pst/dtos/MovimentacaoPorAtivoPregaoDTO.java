package rogerio.pst.dtos;
import java.math.BigDecimal;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RegisterForReflection
public class MovimentacaoPorAtivoPregaoDTO {	

	private String diaAtivo;	
	private String operacao;
	private String ativo;	

	private int quantidade;
	
	private BigDecimal preco;
	
	private BigDecimal valorOperacao;

	public MovimentacaoPorAtivoPregaoDTO(String diaAtivo, String operacao, String ativo, int quantidade,
			BigDecimal preco, BigDecimal valorOperacao) {
		this.diaAtivo = diaAtivo;		
		this.operacao = operacao;
		this.ativo = ativo;
		this.quantidade = quantidade;
		this.preco = preco;
		this.valorOperacao = valorOperacao;
	}						
}
