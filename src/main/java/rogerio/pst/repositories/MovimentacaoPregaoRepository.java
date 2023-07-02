package rogerio.pst.repositories;


import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import rogerio.pst.dtos.AtivoQuantidadeTotalDTO;
import rogerio.pst.dtos.AtivoQuantidadeTotalPregaoDTO;
import rogerio.pst.dtos.MovimentacaoPorAtivoDTO;
import rogerio.pst.dtos.MovimentacaoPorAtivoPregaoDTO;
import rogerio.pst.dtos.MovimentacaoTotalPorAtivoPregaoDTO;
import rogerio.pst.dtos.StatsDTO;
import rogerio.pst.dtos.TotalMovimentacaoPregaoDTO;
import rogerio.pst.entities.MovimentacaoPregao;
import rogerio.pst.entities.Pregao;



@ApplicationScoped

public class MovimentacaoPregaoRepository implements PanacheRepository<MovimentacaoPregao> {
	
	public List<MovimentacaoPregao> findByPregao(Pregao pregao){
		return list("pregao", pregao);
	}
	
	public List<StatsDTO> findByPregaoGroupByAtivo(Pregao pregao){
		return find("select count(v),v.ativo from MovimentacaoPregao v where v.pregao = :pregao group by v.ativo order by v.ativo", Parameters.with("pregao", pregao)).project(StatsDTO.class).list();
		
		//return find("#M.findByPregaoGroupByAtivo", Parameters.with("pregao", pregao)).project(StatsDTO.class).list();
	}
		
	public List<MovimentacaoPorAtivoDTO> findMovimentacaoPorAtivo(){
		return find("select CONCAT(m.pregao.data, m.ativo.nome), m.pregao, m.tipoMovimentacao.nome, m.ativo.nome, m.quantidade, m.preco, m.valorOperacao from MovimentacaoPregao m group by m.pregao, m.ativo.nome, m.tipoMovimentacao.nome, m.quantidade order by m.pregao.data asc").project(MovimentacaoPorAtivoDTO.class).list();
//		return .project(MovimentacaoPorAtivoDTO.class).list();
//		return find("#M.findMovimentacaoPorAtivo").project(MovimentacaoPorAtivoDTO.class).list();
	}	
	
	public List<MovimentacaoPorAtivoPregaoDTO> findMovimentacaoPorAtivoPregao(){
		return find("select CONCAT(m.pregao.data, m.ativo.nome), m.tipoMovimentacao.nome, m.ativo.nome, m.quantidade, m.preco, m.valorOperacao from MovimentacaoPregao m group by m.pregao, m.ativo.nome, m.tipoMovimentacao.nome, m.quantidade order by m.pregao.data asc").project(MovimentacaoPorAtivoPregaoDTO.class).list();
		//return find("#M.findMovimentacaoPorAtivoPregao").project(MovimentacaoPorAtivoPregaoDTO.class).list();
	}

	public TotalMovimentacaoPregaoDTO findMovimentacaoPorAtivoq() {		
		return find("SELECT sum(m.quantidade)  from MovimentacaoPregao m ").project(TotalMovimentacaoPregaoDTO.class).singleResult();
		
		//return find("#M.findMovimentacaoPorAtivoq").project(Integer.class).singleResult();
	}
		
	public List<MovimentacaoTotalPorAtivoPregaoDTO> findMovimentacaoTotalPorAtivoPregao(){
		return find("SELECT m.pregao, m.ativo.nome, sum(m.valorOperacao)  from MovimentacaoPregao m group by m.pregao, m.ativo.nome order by m.pregao.data asc").project(MovimentacaoTotalPorAtivoPregaoDTO.class).list();
//		return find("SELECT new br.rogerio.backend.dto.MovimentacaoTotalPorAtivoPregaoDTO(m.pregao, m.ativo.nome, sum(m.valorOperacao) ) from MovimentacaoPregao m group by m.pregao, m.ativo.nome order by m.pregao.data asc").project(MovimentacaoTotalPorAtivoPregaoDTO.class).list();
//		return find("#M.findMovimentacaoTotalPorAtivoPregao").project(MovimentacaoTotalPorAtivoPregaoDTO.class).list();
	}
		
	public AtivoQuantidadeTotalDTO findTotalAtivoNota(Pregao pregao, String ativo) {
		return find("SELECT m.pregao, m.ativo.nome, sum(m.valorOperacao), sum(m.quantidade) from MovimentacaoPregao m where m.pregao = :pregao and m.ativo.nome = :ativo order by m.pregao, m.ativo.nome", Parameters.with("pregao", pregao).and("ativo", ativo)).project(AtivoQuantidadeTotalDTO.class).singleResult();
//		return find("#M.findTotalAtivoNota", Parameters.with("pregao", pregao).and(ativo, ativo)).project(AtivoQuantidadeTotalDTO.class).singleResult();
	}
		
	public List<AtivoQuantidadeTotalPregaoDTO> findTotalAtivoNotaMovimentacao(Pregao pregao, String ativo){
		return find("SELECT m.pregao, m.ativo.nome, sum(m.valorOperacao), sum(m.quantidade), m.tipoMovimentacao.nome from MovimentacaoPregao m where m.pregao = :pregao and m.ativo.nome = :ativo group by m.tipoMovimentacao.nome order by m.pregao, m.ativo.nome", Parameters.with("pregao", pregao).and("ativo", ativo)).project(AtivoQuantidadeTotalPregaoDTO.class).list();
//		return find("#M.findTotalAtivoNotaMovimentacao", Parameters.with("pregao", pregao).and(ativo, ativo)).project(AtivoQuantidadeTotalPregaoDTO.class).list();
	}
		
	public List<MovimentacaoPorAtivoPregaoDTO> findTotalAtivoNotaPregao( Pregao pregao, String ativo){
		return find("SELECT CONCAT(m.pregao.data, m.ativo.nome), m.tipoMovimentacao.nome, m.ativo.nome, m.quantidade, m.preco, m.valorOperacao from MovimentacaoPregao m where m.pregao = :pregao and m.ativo.nome = :ativo group by m.pregao, m.ativo.nome, m.tipoMovimentacao.nome, m.quantidade order by m.pregao.data asc", Parameters.with("pregao", pregao).and(ativo, ativo)).project(MovimentacaoPorAtivoPregaoDTO.class).list();
//		return find("#M.findTotalAtivoNotaPregao", Parameters.with("pregao", pregao).and(ativo, ativo)).project(MovimentacaoPorAtivoPregaoDTO.class).list();		
	}
}