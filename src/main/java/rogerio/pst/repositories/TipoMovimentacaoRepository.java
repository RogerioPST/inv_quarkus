package rogerio.pst.repositories;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import rogerio.pst.entities.TipoMovimentacao;



@ApplicationScoped
public class TipoMovimentacaoRepository implements PanacheRepository<TipoMovimentacao> {
	
}

