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
//@Table(name = "ativo_usuario")
public class AtivoUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	private BigDecimal precoMedio;

	private int quantidadeCotas;

	@JsonFormat(locale="zh", timezone="GMT-3", pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date data;	

	@ManyToOne
	private Usuario usuario;

	@ManyToOne
	private Ativo ativo;
}
