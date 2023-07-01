package rogerio.pst.services;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import rogerio.pst.entities.Ativo;
import rogerio.pst.repositories.AtivoRepository;

@ApplicationScoped
public class AtivoService {

	
	@Inject		
	AtivoRepository ativoRepository;
	
	public List<Ativo> findAll() {
		return ativoRepository.findAll().list();
	}

}
