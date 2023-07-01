package rogerio.pst.resources;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import rogerio.pst.dtos.ProventoAnoDTO;
import rogerio.pst.dtos.ProventoAnoMesDTO;
import rogerio.pst.dtos.ProventoMesDTO;
import rogerio.pst.dtos.RetornoSimulacaoDTO;
import rogerio.pst.dtos.StatsDTO;
import rogerio.pst.dtos.TotalProventoDTO;
import rogerio.pst.entities.Ativo;
import rogerio.pst.entities.Provento;
import rogerio.pst.entities.Usuario;
import rogerio.pst.enumerates.MensagensEnum;
import rogerio.pst.services.AtivoService;
import rogerio.pst.services.ProventoService;


@Path("/api/provento")
@Tag(name = "Crédito", description = "Serviço de Simulação de Empréstimo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@APIResponse(responseCode = "200", description = MensagensEnum.OBJETIVO_METODO_SIMULACAO, content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = RetornoSimulacaoDTO.class, type = SchemaType.OBJECT)))
@APIResponse(ref = "erro-400")
@APIResponse(ref = "erro-500")

public class ProventoResource {			
	
	@Inject
	ProventoService proventoService;
	
	@Inject
	AtivoService ativoService;
	
	
	@GET	
	@Operation(summary = "simular um empréstimo")	
	public List<Provento> list(){
		return proventoService.findAll();		
	}
	
	@GET	
	@Operation(summary = "simular um empréstimo")	
	@Path("/tudo2")
	public List<StatsDTO> listTudo(){
		;
	//	List<ProventoMesDTO> todosProventosAgrupadosPorData = proventoRepository.findAllAgrupadoPorData();
	//	for(ProventoMesDTO cada : todosProventosAgrupadosPorData){
			//new SimpleDateFormat("yyyy-MM-dd").parse(cada.getData().toString());
	//	}

		List<StatsDTO> dtos = new ArrayList<StatsDTO>();
		//ativoRepository.findByNome("BBAS3");
		Ativo ativo = new Ativo();
		dtos.add(new StatsDTO(1L, ativo));
		dtos.add(new StatsDTO(1L, ativo));
		return dtos;

		//return proventoRepository.findAllAgrupadoPorData();
	}

	
	/* @GetMapping
		@RequestMapping("/tudoano")
		public List<ProventoAnoDTO> findProventoPorAno(){
			return proventoRepository.findProventoPorAno();	
	} */

	@GET	
	@Path("/mes")
	public List<ProventoMesDTO> findProventoPorMes(){
		return proventoService.findProventoPorMes();	
	}

	@GET
	@Operation(summary = "simular um empréstimo")	
	@Path("/tudo")
	public TotalProventoDTO findProvento(){
		List<ProventoMesDTO> meses = proventoService.findProventoPorMes();	

		//Stream<ProventoMesDTO> sorted = meses.stream().sorted(Comparator.comparing(ProventoMesDTO::getAnoMes).reversed());

		Comparator<ProventoMesDTO> comparadorPorAnoDesc = Comparator.comparing(
			ProventoMesDTO::getAnoMes, (s1, s2) -> { return s2.substring(0,4)
				.compareTo(s1.substring(0,4));});
		
		Collections.sort(meses, comparadorPorAnoDesc);

		List<ProventoAnoDTO> anos = new ArrayList<>();						
		Map<String, List<ProventoMesDTO>> mapasAnosDTO = new HashMap<>();
		
		BigDecimal total = BigDecimal.ZERO;		
		for(ProventoMesDTO mesDTO : meses){			
			total = total.add(mesDTO.getTotal());
			String ano = mesDTO.getAnoMes().substring(0,4);
			String mes = mesDTO.getAnoMes().substring(5,7);
			
			ProventoMesDTO novoMesDTO = new ProventoMesDTO(mes, mesDTO.getTotal());
			
			List<ProventoMesDTO> listaExistente = new ArrayList<>();
			if (mapasAnosDTO.get(ano) != null) {
				listaExistente = mapasAnosDTO.get(ano);				
			} 
			listaExistente.add(novoMesDTO);				
			mapasAnosDTO.put(ano, listaExistente);						
		}				
		for (Map.Entry<String, List<ProventoMesDTO>> entry : mapasAnosDTO.entrySet()) {						
			ProventoAnoDTO anoDTO = new ProventoAnoDTO(Integer.valueOf(entry.getKey()), entry.getValue());
			anos.add(anoDTO);			
		}		
		return 	new TotalProventoDTO( total, anos);
}

	@GET
	@Operation(summary = "simular um empréstimo")	
	@Path("/mapping")
	public TotalProventoDTO findProventoPorMesMapping(){
		//Map<ProventoMesDTO, List<String>> invertGroupByMap = Util.invertGroupByMap(mapasAnosDTO);
		
				
				
				




				//List<ProventoAnoDTO> anos = new ArrayList<>();						
				//BigDecimal total = BigDecimal.ZERO;		
				
				/* for (Map.Entry<String, List<ProventoMesDTO>> entry : mapasAnosDTO.entrySet()) {						
					ProventoAnoDTO anoDTO = new ProventoAnoDTO(Integer.valueOf(entry.getKey()), entry.getValue());
					anos.add(anoDTO);		
					for (ProventoMesDTO mesDTO : entry.getValue()){
						total = total.add(mesDTO.getTotal());
					}	
				}		 */
				
				
				//Stream<Entry<String, List<ProventoMesDTO>>> sorteado = mapasAnosDTO.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey()));
				
				
				//List<Entry<String, List<ProventoMesDTO>>> collect2 = sorteado.collect(Collectors.toList());
				//Map<String, List<ProventoMesDTO>> collect2 = sorteado.collect(Collectors.toMap(e -> e.getKey(),e -> e.getValue()));
				
				
				//Map<String, List<ProventoMesDTO>> collect2 = sorteado.reduce(new HashMap<>(), Util::reduceInto);
				
				
		


				//List<ProventoMesDTO> meses = proventoRepository.findProventoPorMes();	
				
				//Stream<ProventoMesDTO> sorted = meses.stream().sorted(Comparator.comparing(ProventoMesDTO::getAnoMes).reversed());
		
				List<Provento> lista = proventoService.findProventoPorMesMapping();
				//Map<Ativo, List<Provento>> mapa = lista.stream().collect(Collectors.groupingBy(Provento::getAtivo));
				Map<Ativo, List<Usuario>> mapa2 = lista.stream().collect(Collectors.groupingBy(Provento::getAtivo,
				Collectors.mapping(Provento::getUsuario,		Collectors.toList())));
		//lista.stream().collect(Collectors.groupingBy(TotalProventoDTO::getAnos), Collectors.mapping(ProventoAnoDTO::getMeses,
		//Collectors.toList()));				
		Stream<Ativo> ativo = mapa2.entrySet().stream().map(e -> {
			e.getKey().getNome();
				return e.getKey();
			});
			List<Ativo> collectT = ativo.collect(Collectors.toList());		
		/* 
		 * .stream().collect(Collectors.groupingBy(LeilaoDTO::factoryDadosLeilaoDTO,Collectors.mapping(FundosDTO::factoryDadosFundosDTO,
						Collectors.toList()))).entrySet().stream().map(e -> {
							e.getKey().getFundos().addAll(e.getValue());
							return e.getKey();
					})
		 */
		
		
		//return mapasAnosDTO;		

		/* 
		final Set<ProventoMesDTO> customerDTOs = mapasAnosDTO.stream().map(c ->{
		final ProventoAnoDTO customerDTO = new ProventoAnoDTO(c.getId(), c.getFirstName(), c.getLastName());
		return customerDTO;
		}).collect(Collectors.toSet()); */

		//Set<Entry<String, List<ProventoMesDTO>>> entrySet = mapasAnosDTO.entrySet(); 

		List<ProventoMesDTO> meses1 = proventoService.findProventoPorMes();	
		Stream<ProventoMesDTO> anosReverso = meses1.stream().sorted(Comparator.comparing(
		ProventoMesDTO::getAnoMes, (s1, s2) -> 
		s1.substring(0,4).compareTo(s2.substring(0,4))).reversed());														
		TreeMap<String, List<ProventoMesDTO>> mapasAnosDTO = anosReverso.collect(Collectors.groupingBy(p -> p.getAnoMes()
		.substring(0,4), () -> new TreeMap<String, List<ProventoMesDTO>>(Comparator.reverseOrder()), Collectors.toList()));									

		
		List<ProventoAnoDTO> anos = mapasAnosDTO.entrySet().stream().map( 
		mapa -> new ProventoAnoDTO(Integer.valueOf(mapa.getKey()), mapa.getValue()))
		.collect(Collectors.toList());

		Stream<List<ProventoMesDTO>> streamLista = anos.stream().map(ProventoAnoDTO::getMeses);

		//streamLista.flatMap(List::stream) -> transforma em stream a partir de list
		BigDecimal total = streamLista.flatMap(List::stream).map(ProventoMesDTO::getTotal).reduce(BigDecimal.ZERO, BigDecimal::add);

		return 	new TotalProventoDTO( total, anos);
	}
	
	
	@GET
	@Operation(summary = "simular um empréstimo")	
	@Path("/ano-mes")
	public List<ProventoAnoMesDTO> findProventoPorAnoMes(){
		List<ProventoAnoMesDTO> proventoAnoMes = proventoService.findProventoPorAnoMes();

		Comparator<ProventoAnoMesDTO> comparadorPorAnoDesc = Comparator.comparing(
			ProventoAnoMesDTO::getAno, (s1, s2) -> { return s2.compareTo(s1);});
		
			Collections.sort(proventoAnoMes, comparadorPorAnoDesc);
		
		return proventoAnoMes;
}



/* private LeiloesDTO listarLeiloes(Fmpwss01 endpointOfertas) { 
	List<LeilaoDTO> listDadosLeilao = recuperaListDadosLeilao(endpointOfertas)
					.stream().collect(Collectors.groupingBy(LeilaoDTO::factoryDadosLeilaoDTO,Collectors.mapping(FundosDTO::factoryDadosFundosDTO,
						Collectors.toList()))).entrySet().stream().map(e -> {
							e.getKey().getFundos().addAll(e.getValue());
							return e.getKey();
					})
					.collect(Collectors.toList());
	return new LeiloesDTO(listDadosLeilao);
}

private SaldosResponseOpcoesDTO saldosListarContasOpcao(Fmpwss02 endpointFmpMigracao) {
	List<SaldosResponseContaOpcaoDTO> listContasOpcao =	saldosRecuperaListDadosCtOpc(endpointFmpMigracao)
					.stream().collect(Collectors.groupingBy(SaldosResponseContaOpcaoDTO::factoryContaOpcaoDTO,
							Collectors.mapping(SaldosResponseContaFgtsDTO::factorContaFgtsDTO,Collectors.toList())))
					.entrySet().stream().map(e -> {
						e.getKey().getContasFGTS().addAll(e.getValue());
							return e.getKey();
					})
					.collect(Collectors.toList());
	return new SaldosResponseOpcoesDTO(listContasOpcao);
} */
}
