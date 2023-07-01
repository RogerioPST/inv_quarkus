package rogerio.pst.services;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import rogerio.pst.entities.AtivoUsuario;
import rogerio.pst.repositories.AtivoUsuarioRepository;

@ApplicationScoped
public class AtivoUsuarioService {
	
	@Inject		
	AtivoUsuarioRepository ativoUsuarioRepository;

	public List<AtivoUsuario> findAll() {
		return ativoUsuarioRepository.findAll().list();
	}

}
