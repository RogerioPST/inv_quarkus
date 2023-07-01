package rogerio.pst.services;

import java.util.List;

import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import rogerio.pst.dtos.ProventoAnoMesDTO;
import rogerio.pst.dtos.ProventoMesDTO;
import rogerio.pst.entities.Provento;
import rogerio.pst.repositories.ProventoRepository;

@ApplicationScoped
public class ProventoService {
	
	@Inject
	ProventoRepository proventoRepository;

	public List<ProventoAnoMesDTO> findProventoPorAnoMes() {
		return proventoRepository.findProventoPorAnoMes();		
	}

	public List<Provento> findProventoPorMesMapping() {
		return proventoRepository.findProventoPorMesMapping();
	}

	public List<ProventoMesDTO> findProventoPorMes() {
		return proventoRepository.findProventoPorMes();
	}

	public List<Provento> findAll() {
		return proventoRepository.findAll(Sort.by("data").descending()).list();		
	}

}
