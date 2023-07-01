package rogerio.pst.repositories;


import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import rogerio.pst.dtos.AtivoQuantidadeTotalDTO;
import rogerio.pst.dtos.AtivoQuantidadeTotalPregaoDTO;
import rogerio.pst.dtos.MovimentacaoPorAtivoDTO;
import rogerio.pst.dtos.MovimentacaoPorAtivoPregaoDTO;
import rogerio.pst.dtos.MovimentacaoTotalPorAtivoPregaoDTO;
import rogerio.pst.dtos.StatsDTO;
import rogerio.pst.entities.MovimentacaoPregao;
import rogerio.pst.entities.Pregao;



@ApplicationScoped

public class MovimentacaoPregaoRepository implements PanacheRepository<MovimentacaoPregao> {
	
	public List<MovimentacaoPregao> findByPregao(Pregao pregao){
		return list("pregao", pregao);
	}
	
	public List<StatsDTO> findByPregaoGroupByAtivo(Pregao pregao){
		return find("#M.findByPregaoGroupByAtivo", Parameters.with("pregao", pregao)).project(StatsDTO.class).list();
	}
		
	public List<MovimentacaoPorAtivoDTO> findMovimentacaoPorAtivo(){
		return find("#M.findMovimentacaoPorAtivo").project(MovimentacaoPorAtivoDTO.class).list();
	}	
	
	public List<MovimentacaoPorAtivoPregaoDTO> findMovimentacaoPorAtivoPregao(){
		return find("#M.findMovimentacaoPorAtivoPregao").project(MovimentacaoPorAtivoPregaoDTO.class).list();
	}

	public Integer findMovimentacaoPorAtivoq() {
		return find("#M.findMovimentacaoPorAtivoq").project(Integer.class).singleResult();
	}
		
	public List<MovimentacaoTotalPorAtivoPregaoDTO> findMovimentacaoTotalPorAtivoPregao(){
		return find("#M.findMovimentacaoTotalPorAtivoPregao").project(MovimentacaoTotalPorAtivoPregaoDTO.class).list();
	}
		
	public AtivoQuantidadeTotalDTO findTotalAtivoNota(Pregao pregao, String ativo) {
		return find("#M.findTotalAtivoNota", Parameters.with("pregao", pregao).and(ativo, ativo)).project(AtivoQuantidadeTotalDTO.class).singleResult();
	}
		
	public List<AtivoQuantidadeTotalPregaoDTO> findTotalAtivoNotaMovimentacao(Pregao pregao, String ativo){
		return find("#M.findTotalAtivoNotaMovimentacao", Parameters.with("pregao", pregao).and(ativo, ativo)).project(AtivoQuantidadeTotalPregaoDTO.class).list();
	}
		
	public List<MovimentacaoPorAtivoPregaoDTO> findTotalAtivoNotaPregao( Pregao pregao, String ativo){
		return find("#M.findTotalAtivoNotaPregao", Parameters.with("pregao", pregao).and(ativo, ativo)).project(MovimentacaoPorAtivoPregaoDTO.class).list();		
	}
}