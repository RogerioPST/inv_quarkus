package rogerio.pst.repositories;


import java.util.Date;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import rogerio.pst.entities.AtivoUsuario;



@ApplicationScoped
public class AtivoUsuarioRepository implements PanacheRepository<AtivoUsuario> {
	
	
	
	public AtivoUsuario findByData(Date data) {
		return find("data", data).firstResult();
	}
	
	
}