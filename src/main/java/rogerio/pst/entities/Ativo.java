package rogerio.pst.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
//@Table(name = "ativos")
public class Ativo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;		
	
	@Column(length = 200, nullable = false)
	private String nome;
	
	@JsonFormat(locale="zh", timezone="GMT-3", pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@JsonFormat(locale="zh", timezone="GMT-3", pattern="HH:mm")
	@Temporal(TemporalType.TIME)
	private Date horaAbertura;

	@JsonFormat(locale="zh", timezone="GMT-3", pattern="HH:mm")
	@Temporal(TemporalType.TIME)
	private Date horaFechamento;
	
}
