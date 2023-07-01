package rogerio.pst.entities;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
//@Table(name = "pregao")
public class Pregao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;		

	@JsonFormat(locale="zh", timezone="GMT-3", pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@ManyToOne
	private Usuario usuario;

	private BigDecimal comprasAVista;
	private BigDecimal vendasAVista;
	private BigDecimal valorOperacoes;
	private BigDecimal valorLiquidoOperacoes;
	private BigDecimal taxaLiquidacao;
	private BigDecimal totalCblc;
	private BigDecimal emolumentos;	
	private BigDecimal taxaOperacional;
	private BigDecimal impostos;
	private BigDecimal outros;
	private BigDecimal totalCustosDespesas;
	
	@JsonFormat(locale="zh", timezone="GMT-3", pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dataLiquidoPara;
	private BigDecimal valorLiquidoPara;
}
