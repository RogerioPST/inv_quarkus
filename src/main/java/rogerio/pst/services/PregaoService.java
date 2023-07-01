package rogerio.pst.services;

import java.util.Date;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import rogerio.pst.entities.Pregao;
import rogerio.pst.repositories.PregaoRepository;

@ApplicationScoped
public class PregaoService {
	
	@Inject
	PregaoRepository pregaoRepository;

	public List<Pregao> findAll() {
		return pregaoRepository.findAll().list();
		
	}

	public Pregao findByData(Date date) {
		return pregaoRepository.findByData(date);
	}

}
