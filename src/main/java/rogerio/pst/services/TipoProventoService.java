package rogerio.pst.services;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import rogerio.pst.entities.TipoProvento;
import rogerio.pst.repositories.TipoProventoRepository;

@ApplicationScoped
public class TipoProventoService {
	
	@Inject
	TipoProventoRepository tipoProventoRepository;

	public List<TipoProvento> findAll() {
		return tipoProventoRepository.findAll().list();
	}

}
