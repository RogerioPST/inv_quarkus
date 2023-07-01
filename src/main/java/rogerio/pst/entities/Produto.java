package rogerio.pst.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;



//@Entity
@Getter
public class Produto {

	//@Column(name="CO_PRODUTO")
	//@Id
	//@GeneratedValue
    private Long idProduto;
		
	//@Column(name="NO_PRODUTO")
    private String nomeProduto;
		
//	@Column(name="PC_TAXA_JUROS")
	private BigDecimal percentualTaxaJuros;
	
//	@Column(name="NU_MINIMO_MESES")
	private Integer numeroMinimoMeses;

	//@Column(name="NU_MAXIMO_MESES", nullable = true)
	private Integer numeroMaximoMeses;
	
	//@Column(name="VR_MAXIMO", nullable = true)
	private BigDecimal valorMaximo;
	
	//@Column(name="VR_MINIMO")
	private BigDecimal valorMinimo;

}
