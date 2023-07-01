package rogerio.pst.repositories;


import java.util.Date;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import rogerio.pst.entities.Pregao;



@ApplicationScoped
public class PregaoRepository implements PanacheRepository<Pregao> {		
	
	public Pregao findByData(Date data) {
		return find("data", data).firstResult();
	}
	
}