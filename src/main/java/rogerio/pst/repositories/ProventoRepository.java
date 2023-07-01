package rogerio.pst.repositories;


import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import rogerio.pst.dtos.MovimentacaoPorAtivoDTO;
import rogerio.pst.dtos.ProventoAnoMesDTO;
import rogerio.pst.dtos.ProventoMesDTO;
import rogerio.pst.entities.Provento;



@ApplicationScoped
public class ProventoRepository implements PanacheRepository<Provento> {

	//@Query(value = "SELECT new br.rogerio.backend.dto.ProventoMesDTO(sum(p.valor),to_char(p.data, 'YYYY-MM') as n )   from Provento p group by n")	
	//@Query(value = "SELECT new br.rogerio.backend.dto.ProventoMesDTO(sum(p.valor),extract(month  from p.data) as n )   from Provento p group by n")
	//@Query(value = "SELECT EXTRACT (month FROM p.data) as date from Provento p")
	public List<ProventoMesDTO> findProventoPorMes(){
		return find("#P.findProventoPorMes").project(ProventoMesDTO.class).list();
	}
	
	//@Query(value = "SELECT new br.rogerio.backend.dto.ProventoMesDTO(sum(p.valor),extract(month  from p.data) as n )   from Provento p group by n")
	//@Query(value = "SELECT EXTRACT (month FROM p.data) as date from Provento p")
	public List<Provento> findProventoPorMesMapping(){
		return find("#P.findProventoPorMesMapping").list();		
	}	
	
	//@Query(value = "SELECT new br.rogerio.backend.dto.ProventoMesDTO(sum(p.valor),extract(month  from p.data) as n )   from Provento p group by n")
	//@Query(value = "SELECT EXTRACT (month FROM p.data) as date from Provento p")
	public List<ProventoAnoMesDTO> findProventoPorAnoMes(){
		return find("#P.findProventoPorAnoMes").project(ProventoAnoMesDTO.class).list();
		
	}

	//@Query(value = "SELECT new br.rogerio.backend.dto.ProventoAnoDTO(year(p.data) as ano, " +
	//"new br.rogerio.backend.dto.ProventoMesDTO(substring(p.data, 1, 7) as anoMes, sum(p.valor) ) " +
	//"from Provento p group by ano, anoMes order by p.data desc")
	//@Query(value = "SELECT new br.rogerio.backend.dto.ProventoMesDTO(sum(p.valor),extract(month  from p.data) as n )   from Provento p group by n")
	//@Query(value = "SELECT EXTRACT (month FROM p.data) as date from Provento p")
	//List<ProventoAnoDTO> findProventoPorAno();

	//@Query(value = "SELECT new br.rogerio.backend.dto.ProventoAnoDTO(year(p.data) as ano, sum(p.valor) ) " +
	//"from Provento p group by ano order by p.data desc")
	//@Query(value = "SELECT new br.rogerio.backend.dto.ProventoMesDTO(sum(p.valor),extract(month  from p.data) as n )   from Provento p group by n")
	//@Query(value = "SELECT EXTRACT (month FROM p.data) as date from Provento p")
//	List<ProventoAnoDTO> findProventoPorAno();

	/*  @Query(value = "SELECT new br.rogerio.backend.dto.ProventoMesDTO(sum(p.valor), DATE_FORMAT(p.data,'%Y-%m')) FROM Provento p " +
        "GROUP BY DATE_FORMAT(p.data,'%Y-%m') order by p.data desc") */
	 //@Query(value = "SELECT new br.rogerio.backend.dto.ProventoMesDTO(sum(p.valor), function('date_format', p.data, '%Y, %m')) FROM Provento p " +
     //   "GROUP BY function('date_format', p.data, '%Y, %m') order by p.data desc")
//	List<ProventoMesDTO> findAllAgrupado2();	 


	/*  @Query("select new br.rogerio.backend.dto.ProventoMesDTO(sum(p.valor),p.data )   from Provento p " + 
	"group by p.data order by p.data desc")
	List<ProventoMesDTO> findAllAgrupadoPorData();	  */
	
}