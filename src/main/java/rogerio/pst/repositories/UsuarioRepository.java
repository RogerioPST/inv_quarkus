package rogerio.pst.repositories;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import rogerio.pst.entities.Usuario;



@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {
	
}