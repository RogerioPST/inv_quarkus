package rogerio.pst.entities;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import lombok.Data;

@Data
@Entity

//@NamedQueries({
    //@NamedQuery(name = "M.findByPregaoGroupByAtivo", query = "select new br.rogerio.backend.dto.StatsDTO(count(v),v.ativo ) from MovimentacaoPregao v where v.pregao = :pregao group by v.ativo order by v.ativo"),
    //@NamedQuery(name = "M.findMovimentacaoPorAtivo", query = "select new br.rogerio.backend.dto.MovimentacaoPorAtivoDTO(CONCAT(m.pregao.data, m.ativo.nome), m.pregao, " +
    //	"m.tipoMovimentacao.nome, m.ativo.nome, m.quantidade, m.preco, m.valorOperacao ) from MovimentacaoPregao m group by m.pregao, m.ativo.nome, m.tipoMovimentacao.nome, " +
    //	"m.quantidade order by m.pregao.data asc"),
    //@NamedQuery(name = "M.findMovimentacaoPorAtivoPregao", query = "select new br.rogerio.backend.dto.MovimentacaoPorAtivoPregaoDTO(CONCAT(m.pregao.data, m.ativo.nome), " +
    //	"m.tipoMovimentacao.nome, m.ativo.nome, m.quantidade, m.preco, m.valorOperacao ) " + 
    //	"from MovimentacaoPregao m group by m.pregao, m.ativo.nome, m.tipoMovimentacao.nome, m.quantidade order by m.pregao.data asc"),
    //@NamedQuery(name = "M.findMovimentacaoPorAtivoq", query = "SELECT sum(m.quantidade)  from MovimentacaoPregao m "),
    //@NamedQuery(name = "M.findMovimentacaoTotalPorAtivoPregao", query = "SELECT new br.rogerio.backend.dto.MovimentacaoTotalPorAtivoPregaoDTO(m.pregao, m.ativo.nome, " +
    //"sum(m.valorOperacao) ) from MovimentacaoPregao m group by m.pregao, m.ativo.nome order by m.pregao.data asc"),        
    //@NamedQuery(name = "M.findTotalAtivoNota", query = "SELECT new br.rogerio.backend.dto.AtivoQuantidadeTotalDTO(m.pregao, m.ativo.nome, sum(m.valorOperacao), sum(m.quantidade))" +
    //"from MovimentacaoPregao m where m.pregao = :pregao and m.ativo.nome = :ativo order by m.pregao, m.ativo.nome"),    
    //@NamedQuery(name = "M.findTotalAtivoNotaMovimentacao", query = "SELECT new br.rogerio.backend.dto.AtivoQuantidadeTotalPregaoDTO(m.pregao, m.ativo.nome, sum(m.valorOperacao), " +
    //"sum(m.quantidade), m.tipoMovimentacao.nome)  from MovimentacaoPregao m where m.pregao = :pregao and m.ativo.nome = :ativo group by m.tipoMovimentacao.nome order by m.pregao, m.ativo.nome "),      
    //@NamedQuery(name = "M.findTotalAtivoNotaPregao", query = "SELECT new br.rogerio.backend.dto.MovimentacaoPorAtivoPregaoDTO(CONCAT(m.pregao.data, m.ativo.nome), " +
    //"m.tipoMovimentacao.nome, m.ativo.nome, m.quantidade, m.preco, m.valorOperacao ) from MovimentacaoPregao m where m.pregao = :pregao and m.ativo.nome = :ativo " +
    //"group by m.pregao, m.ativo.nome, m.tipoMovimentacao.nome, m.quantidade order by m.pregao.data asc")           
    
//})
//@Table(name = "movimentacao_pregao")
public class MovimentacaoPregao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;		

	@ManyToOne
	private Pregao pregao;
	
	@ManyToOne
	private Ativo ativo;		

	@ManyToOne
	private TipoMovimentacao tipoMovimentacao;	

	private int quantidade;

	private BigDecimal preco;
	
	private BigDecimal valorOperacao;

	
}
