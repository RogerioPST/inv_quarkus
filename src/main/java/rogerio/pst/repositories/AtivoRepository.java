package rogerio.pst.repositories;


import java.util.Date;
import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import rogerio.pst.entities.Ativo;



@ApplicationScoped
public class AtivoRepository implements PanacheRepository<Ativo> {

	public Ativo findByData(Date data) {
		return find("data", data).firstResult();
	}
	
}
