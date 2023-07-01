package rogerio.pst.services;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import rogerio.pst.entities.TipoMovimentacao;
import rogerio.pst.repositories.TipoMovimentacaoRepository;

@ApplicationScoped
public class TipoMovimentacaoService {
	
	@Inject
	TipoMovimentacaoRepository tipoMovimentacaoRepository;

	public List<TipoMovimentacao> findAll() {
		return tipoMovimentacaoRepository.findAll().list();
	}

}
