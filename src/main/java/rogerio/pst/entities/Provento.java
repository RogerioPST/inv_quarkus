package rogerio.pst.entities;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
//@Table(name = "provento")
//@NamedQueries({    
 //   @NamedQuery(name = "P.findProventoPorMes", query = "SELECT new br.rogerio.backend.dto.ProventoMesDTO(substring(p.data, 1, 7) as anoMes, sum(p.valor) ) 	" +
  //  "from Provento p group by anoMes order by p.data asc"),            
 //   @NamedQuery(name = "P.findProventoPorMesMapping", query = "SELECT p from Provento p order by p.data asc"),
  //  @NamedQuery(name = "P.findProventoPorAnoMes", query = "SELECT new br.rogerio.backend.dto.ProventoAnoMesDTO(year(p.data) as ano, substring(p.data, 1, 7) " +
  //  "as anoMes, sum(p.valor) ) from Provento p group by ano, anoMes order by p.data asc")           
//})


public class Provento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	private BigDecimal valor;

	private int quantidadeCotas;

	@JsonFormat(locale="zh", timezone="GMT-3", pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date data;

	@ManyToOne
	private TipoProvento tipoProvento;

	@ManyToOne
	private Usuario usuario;

	@ManyToOne
	private Ativo ativo;
}
