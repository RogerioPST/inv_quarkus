package rogerio.pst.services;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import rogerio.pst.dtos.AtivoQuantidadeTotalDTO;
import rogerio.pst.dtos.AtivoQuantidadeTotalPregaoDTO;
import rogerio.pst.dtos.MovimentacaoPorAtivoDTO;
import rogerio.pst.dtos.MovimentacaoPorAtivoPregaoDTO;
import rogerio.pst.dtos.MovimentacaoTotalPorAtivoPregaoDTO;
import rogerio.pst.dtos.StatsDTO;
import rogerio.pst.entities.MovimentacaoPregao;
import rogerio.pst.entities.Pregao;
import rogerio.pst.repositories.MovimentacaoPregaoRepository;

@ApplicationScoped
public class MovimentacaoPregaoService {
	
	@Inject		
	MovimentacaoPregaoRepository movimentacaoPregaoRepository;

	public Iterable<MovimentacaoPregao> findAll() {
		return movimentacaoPregaoRepository.findAll().list();
	}

	public List<MovimentacaoTotalPorAtivoPregaoDTO> findMovimentacaoTotalPorAtivoPregao() {
		return movimentacaoPregaoRepository.findMovimentacaoTotalPorAtivoPregao();
	}

	public AtivoQuantidadeTotalDTO findTotalAtivoNota(Pregao pregao, String ativo) {
		return movimentacaoPregaoRepository.findTotalAtivoNota(pregao, ativo);
	}

	public Integer findMovimentacaoPorAtivoq() {
		return movimentacaoPregaoRepository.findMovimentacaoPorAtivoq();
	}

	public List<MovimentacaoPorAtivoPregaoDTO> findMovimentacaoPorAtivoPregao() {
		return movimentacaoPregaoRepository.findMovimentacaoPorAtivoPregao();
	}

	public List<AtivoQuantidadeTotalPregaoDTO> findTotalAtivoNotaMovimentacao(Pregao pregao, String ativo) {
		return movimentacaoPregaoRepository.findTotalAtivoNotaMovimentacao(pregao, ativo);
	}

	public List<MovimentacaoPorAtivoDTO> findMovimentacaoPorAtivo() {
		return movimentacaoPregaoRepository.findMovimentacaoPorAtivo();
	}

	public List<MovimentacaoPregao> findByPregao(Pregao pregao) {
		return movimentacaoPregaoRepository.findByPregao(pregao);
	}

	public List<StatsDTO> findByPregaoGroupByAtivo(Pregao pregao) {
		return movimentacaoPregaoRepository.findByPregaoGroupByAtivo(pregao);
		
	}

}
