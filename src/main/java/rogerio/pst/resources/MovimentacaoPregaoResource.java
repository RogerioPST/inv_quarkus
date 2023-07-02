package rogerio.pst.resources;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
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
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import rogerio.pst.dtos.AtivoQuantidadeTotalDTO;
import rogerio.pst.dtos.AtivoQuantidadeTotalPregaoDTO;
import rogerio.pst.dtos.MovimentacaoPorAtivoDTO;
import rogerio.pst.dtos.MovimentacaoPorAtivoPregaoDTO;
import rogerio.pst.dtos.MovimentacaoTotalPorAtivoPregaoDTO;
import rogerio.pst.dtos.MovimentacoesDTO;
import rogerio.pst.dtos.MovimentacoesPregaoDTO;
import rogerio.pst.dtos.PregaoComAtivoDTO;
import rogerio.pst.dtos.ResumoPorAtivoDTO;
import rogerio.pst.dtos.ResumoPorAtivoPregaoDTO;
import rogerio.pst.dtos.StatsDTO;
import rogerio.pst.dtos.TotalMovimentacaoPregaoDTO;
import rogerio.pst.entities.MovimentacaoPregao;
import rogerio.pst.entities.Pregao;
import rogerio.pst.enumerates.MensagensEnum;
import rogerio.pst.services.MovimentacaoPregaoService;
import rogerio.pst.services.PregaoService;


@Path("/api/movimentacao_pregao")
@Tag(name = "Crédito", description = "Serviço de Simulação de Empréstimo")

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@APIResponse(responseCode = "200", description = MensagensEnum.OBJETIVO_METODO_SIMULACAO, 
content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = StatsDTO.class, type = SchemaType.OBJECT)))
@APIResponse(ref = "erro-400")
@APIResponse(ref = "erro-500")

public class MovimentacaoPregaoResource {

	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

		
	
	@Inject
	MovimentacaoPregaoService movimentacaoPregaoService;
	
	@Inject
	PregaoService pregaoService;
	

	@GET	
	@Operation(summary = "simular um empréstimo")
	public List<MovimentacaoPregao> list(){
		List<MovimentacaoPregao> students = new ArrayList<>();
		movimentacaoPregaoService.findAll().forEach(students::add);
		return students;

	
	}

	@GET	
	@Path("/total")
	@Operation(summary = "simular um empréstimo")
	public List<MovimentacaoTotalPorAtivoPregaoDTO> findMovimentacaoTotalPorAtivoPregao(){		
		return movimentacaoPregaoService.findMovimentacaoTotalPorAtivoPregao();	
	}

	@GET
	@Operation(summary = "simular um empréstimo")
	@Path("/ativo-nota")
	public AtivoQuantidadeTotalDTO findTotalAtivoNota(PregaoComAtivoDTO pregao){		
		return movimentacaoPregaoService.findTotalAtivoNota(pregao.getPregao(), pregao.getAtivo());	
	}

	@GET
	@Operation(summary = "simular um empréstimo")

	@Path("/totalq")
	public TotalMovimentacaoPregaoDTO findMovimentacaoPorAtivoq(){		
		return movimentacaoPregaoService.findMovimentacaoPorAtivoq();	
	}

	@GET
	@Operation(summary = "simular um empréstimo")

	@Path("/mapping")
	public List<MovimentacoesDTO> findMovimentacaoPorAtivoMapping(){
		List<MovimentacaoPorAtivoDTO> movimentacoesAtivo = this.findMovimentacaoPorAtivo1();

		TreeMap<String, List<MovimentacaoPorAtivoDTO>> mapaDTO = movimentacoesAtivo.stream()
		.collect(Collectors.groupingBy(MovimentacaoPorAtivoDTO::getDiaAtivo,TreeMap::new, Collectors.toList()));

/* 
		BigDecimal proporcaoValorAtivoNaNotaTaxa = devolveOValorDaProporcaoDaNota(movDTO, totalAtivoNotaDTO.getTotal());
		BigDecimal totalTaxaLiquidacaoPorAtivoPregao = pregao.getTaxaLiquidacao().multiply(proporcaoValorAtivoNaNotaTaxa);
		BigDecimal totalEmolumentosPorAtivoPregao = pregao.getEmolumentos().multiply(proporcaoValorAtivoNaNotaTaxa);
		BigDecimal totalOutrasTaxasComOperacional = pregao.getTaxaOperacional().add(pregao.getOutros());
		BigDecimal totalOutrasTaxasPorAtivoPregao = totalOutrasTaxasComOperacional.multiply(proporcaoValorAtivoNaNotaTaxa);								
		
		List<MovimentacaoPorAtivoDTO> unmodifiableList = List.copyOf(listaExistente);					
		ResumoPorAtivoDTO resumo = new ResumoPorAtivoDTO(ativo, totalOutrasTaxasPorAtivoPregao, totalEmolumentosPorAtivoPregao,
		totalTaxaLiquidacaoPorAtivoPregao, totalAtivoNotaDTO.getTotal(), unmodifiableList  );	
 */


		BigDecimal z = BigDecimal.ZERO;
		List<ResumoPorAtivoDTO> resumos = mapaDTO.entrySet().stream().map( 
		mapa -> new ResumoPorAtivoDTO(mapa.getKey(), z,z,z,z, mapa.getValue()))
		.collect(Collectors.toList());		

		Stream<ResumoPorAtivoDTO> streamResumo = resumos.stream();
		Map<String, List<ResumoPorAtivoDTO>> mapaResumo = streamResumo.collect(Collectors.groupingBy(p -> p.getAtivo().substring(0,10)));

		List<MovimentacoesDTO> movs = mapaResumo.entrySet().stream().map( 
			mapa -> {
				Date date = null;
				try {
					date =  SDF.parse(mapa.getKey());
				} catch (ParseException e) {					
					e.printStackTrace();
				}								
				return new MovimentacoesDTO(date
			,resumos.stream().filter(c -> c.getAtivo().substring(0,10).equals(mapa.getKey()))
			.collect(Collectors.toList()));
			})
			.collect(Collectors.toList());		

		return	movs.stream().sorted(Comparator.comparing(
				MovimentacoesDTO::getDia)).collect(Collectors.toList());
		
	}
	
	//esse eh o ultimo e mais correto - 08/10/2022
	@GET
	@Operation(summary = "simular um empréstimo")

	@Path("/mapping-pregao")
	public List<MovimentacoesPregaoDTO> findMovimentacaoPorAtivoMappingPorPregao(){
		List<MovimentacaoPorAtivoPregaoDTO> movimentacoesAtivo = movimentacaoPregaoService.findMovimentacaoPorAtivoPregao();

		TreeMap<String, List<MovimentacaoPorAtivoPregaoDTO>> mapaDTO = movimentacoesAtivo.stream()
		.collect(Collectors.groupingBy(MovimentacaoPorAtivoPregaoDTO::getDiaAtivo,TreeMap::new, Collectors.toList()));			 						
		
		List<ResumoPorAtivoPregaoDTO> resumos = mapaDTO.entrySet().stream().map( 
			mapa -> {
				Date date = null;
				try {
					date =  SDF.parse(mapa.getKey().substring(0,10));
				} catch (ParseException e) {					
					e.printStackTrace();
				}							
				String ativo = mapa.getKey().substring(10,15);
				Pregao pregao = pregaoService.findByData(date);				
				//to do - precisa ver o q fazer qdo tiver pregao de outra corretora e calcular
				List<AtivoQuantidadeTotalPregaoDTO> totalAtivoNotaDTO = movimentacaoPregaoService.findTotalAtivoNotaMovimentacao(pregao, ativo);								
				BigDecimal proporcaoValorAtivoNaNotaTaxa = BigDecimal.ZERO;
				BigDecimal totalAtivoNotaResumo	= BigDecimal.ZERO;

				if (totalAtivoNotaDTO.size() > 1){
					//to do - precisa ver o q fazer no daytrade e calcular

					//imagino q precisa pegar o total da compra e de venda, ver qual eh maior e colocar a diferença e operacao do maior no metodo abaixo
					proporcaoValorAtivoNaNotaTaxa = devolveOValorDaProporcaoDaNotaPregao(pregao, totalAtivoNotaDTO.get(0).getOperacao(), totalAtivoNotaDTO.get(0).getTotal());
					totalAtivoNotaResumo				 = totalAtivoNotaDTO.get(0).getTotal();						
				} else{
					proporcaoValorAtivoNaNotaTaxa = devolveOValorDaProporcaoDaNotaPregao(pregao, totalAtivoNotaDTO.get(0).getOperacao(), totalAtivoNotaDTO.get(0).getTotal());
					totalAtivoNotaResumo				 = totalAtivoNotaDTO.get(0).getTotal();						
				}
				BigDecimal totalTaxaLiquidacaoPorAtivoPregao = pregao.getTaxaLiquidacao().multiply(proporcaoValorAtivoNaNotaTaxa);
				BigDecimal totalEmolumentosPorAtivoPregao = pregao.getEmolumentos().multiply(proporcaoValorAtivoNaNotaTaxa);
				BigDecimal totalOutrasTaxasComOperacional = pregao.getTaxaOperacional().add(pregao.getOutros());
				BigDecimal totalOutrasTaxasPorAtivoPregao = totalOutrasTaxasComOperacional.multiply(proporcaoValorAtivoNaNotaTaxa);		

				return new ResumoPorAtivoPregaoDTO(mapa.getKey(), totalOutrasTaxasPorAtivoPregao, totalEmolumentosPorAtivoPregao,
					totalTaxaLiquidacaoPorAtivoPregao, totalAtivoNotaResumo, mapa.getValue());
			})
			.collect(Collectors.toList());		

		Stream<ResumoPorAtivoPregaoDTO> streamResumo = resumos.stream();
		Map<String, List<ResumoPorAtivoPregaoDTO>> mapaResumo = streamResumo
			.collect(Collectors.groupingBy(p -> p.getDiaAtivo().substring(0,10)));

		List<MovimentacoesPregaoDTO> movs = mapaResumo.entrySet().stream().map( 
			mapa -> {
				Date date = null;
				try {
					date =  SDF.parse(mapa.getKey());
				} catch (ParseException e) {					
					e.printStackTrace();
				}								
				
				Pregao pregao = pregaoService.findByData(date);
				return new MovimentacoesPregaoDTO(pregao
			,resumos.stream().filter(c -> c.getDiaAtivo().substring(0,10).equals(mapa.getKey()))
			.collect(Collectors.toList()));
			})
			.collect(Collectors.toList());		

		return	movs.stream().sorted(Comparator.comparing(l->l.getPregao().getData())).collect(Collectors.toList());				
	}


	@GET
	@Operation(summary = "simular um empréstimo")

	@Path("/ativo")
	public List<ResumoPorAtivoDTO> findMovimentacaoPorAtivo(){		
		List<MovimentacaoPorAtivoDTO> movimentacoesAtivo = this.findMovimentacaoPorAtivo1();

		Map<String, List<MovimentacaoPorAtivoDTO>> mapaAtivoPregao = new HashMap<>();
		Map<Date, List<ResumoPorAtivoDTO>> mapaResumoAtivoPregao = new HashMap<>();

		List<MovimentacoesDTO> movs = new ArrayList<>();
		
		//List<MovimentacaoTotalPorAtivoPregaoDTO> movimentacoesTotaisAtivo = this.findMovimentacaoTotalPorAtivoPregao();				
		
		List<ResumoPorAtivoDTO> resumos = new ArrayList<>();
		List<MovimentacaoPorAtivoDTO> listaExistente = new ArrayList<>();					
		List<ResumoPorAtivoDTO> listaExistenteResumo = new ArrayList<>();

		int quantidadeDeCadaAtivo = 0;					

		for (MovimentacaoPorAtivoDTO movDTO : movimentacoesAtivo){			
			
			String ativo = movDTO.getAtivo();
			Pregao pregao = movDTO.getPregao();
			Long id = movDTO.getPregao().getId();
			String chave = String.valueOf(id)+ativo;											
			System.out.println("ativo: " + ativo);
			
			listaExistente.add(movDTO);							
			
			//if (mapaAtivoPregao.get(chave) == null){				
				
			PregaoComAtivoDTO pregaoComAtivoDTO = new PregaoComAtivoDTO();
			pregaoComAtivoDTO.setPregao(pregao);
			pregaoComAtivoDTO.setAtivo(ativo);
			
				AtivoQuantidadeTotalDTO totalAtivoNotaDTO = this.findTotalAtivoNota(pregaoComAtivoDTO);
				
				
				
				quantidadeDeCadaAtivo += movDTO.getQuantidade();
				
				BigDecimal proporcaoValorAtivoNaNotaTaxa = devolveOValorDaProporcaoDaNota(movDTO, totalAtivoNotaDTO.getTotal());
				BigDecimal totalTaxaLiquidacaoPorAtivoPregao = pregao.getTaxaLiquidacao().multiply(proporcaoValorAtivoNaNotaTaxa);
				BigDecimal totalEmolumentosPorAtivoPregao = pregao.getEmolumentos().multiply(proporcaoValorAtivoNaNotaTaxa);
				BigDecimal totalOutrasTaxasComOperacional = pregao.getTaxaOperacional().add(pregao.getOutros());
				BigDecimal totalOutrasTaxasPorAtivoPregao = totalOutrasTaxasComOperacional.multiply(proporcaoValorAtivoNaNotaTaxa);								
				
				List<MovimentacaoPorAtivoDTO> unmodifiableList = List.copyOf(listaExistente);					
				ResumoPorAtivoDTO resumo = new ResumoPorAtivoDTO(ativo, totalOutrasTaxasPorAtivoPregao, totalEmolumentosPorAtivoPregao,
				totalTaxaLiquidacaoPorAtivoPregao, totalAtivoNotaDTO.getTotal(), unmodifiableList  );		
											
				if (totalAtivoNotaDTO.getTotalQuantidade() == quantidadeDeCadaAtivo ){
					quantidadeDeCadaAtivo = 0;
														
					resumos.add(resumo);
					listaExistente.clear();								
				} 			

				
			
	 		if (mapaResumoAtivoPregao.get(pregao.getData()) == null) {
				List<ResumoPorAtivoDTO> copyOf = List.copyOf(listaExistenteResumo);
				if (!listaExistenteResumo.isEmpty()){
					MovimentacoesDTO mov = new MovimentacoesDTO(pregao.getData(), copyOf);
					movs.add(mov);
				}
				listaExistenteResumo.clear();
			}  else{
				listaExistenteResumo = mapaResumoAtivoPregao.get(pregao.getData());				
			}
			listaExistenteResumo.add(resumo);				
			mapaResumoAtivoPregao.put(pregao.getData(), listaExistenteResumo);	 								
		}										
		
		return  resumos;

	}

	@GET
	@Operation(summary = "simular um empréstimo")

	@Path("/teste")
	public List<MovimentacaoPorAtivoDTO> findMovimentacaoPorAtivo1(){		
		return movimentacaoPregaoService.findMovimentacaoPorAtivo();		
	}

	

	@Path("/{data}")
	@GET
	@Operation(summary = "simular um empréstimo")

	public List<StatsDTO> listarMovimentacoesDoDia(@PathParam("data") String data){
		Date dataD = new Date();
		Pregao pregao = new Pregao();
		try {
			dataD = new SimpleDateFormat("yyyy-MM-dd").parse(data);
			pregao = pregaoService.findByData(dataD);			
		} catch	 (ParseException e) {			
			e.printStackTrace();
		}	

		if (movimentacaoPregaoService.findByPregao(pregao).isEmpty()){
			try {
				dataD = new SimpleDateFormat("yyyy-MM-dd").parse(data);				
				pregao = pregaoService.findByData(dataD);
			} catch (ParseException e) {			
				e.printStackTrace();
			}
		}
		return movimentacaoPregaoService.findByPregaoGroupByAtivo(pregao);	
	}

	private BigDecimal devolveOValorDaProporcaoDaNota(MovimentacaoPorAtivoDTO negocio, BigDecimal valorAcumuladoOperacaoDeCadaAtivo) {
		Pregao nota = negocio.getPregao();
		BigDecimal proporcaoNegocioAtivoNaNota = BigDecimal.ZERO;
		if ( nota.getVendasAVista().compareTo(nota.getComprasAVista()) > 0) {
			if (negocio.getOperacao().equals("VENDA")) {
				proporcaoNegocioAtivoNaNota = valorAcumuladoOperacaoDeCadaAtivo.divide(nota.getVendasAVista(), 2, RoundingMode.HALF_UP);
			}
		} else if  (nota.getVendasAVista().compareTo(nota.getComprasAVista()) <= 0){
			if (negocio.getOperacao().equals("COMPRA")) {
				proporcaoNegocioAtivoNaNota = valorAcumuladoOperacaoDeCadaAtivo.divide(nota.getComprasAVista(), 2, RoundingMode.HALF_UP);
			}
		}
		return proporcaoNegocioAtivoNaNota;
}

	private BigDecimal devolveOValorDaProporcaoDaNotaPregao(Pregao nota, String operacao, BigDecimal valorAcumuladoOperacaoDeCadaAtivo) {
		
		BigDecimal proporcaoNegocioAtivoNaNota = BigDecimal.ZERO;
		if ( nota.getVendasAVista().compareTo(nota.getComprasAVista()) > 0) {
			if (operacao.equals("VENDA")) {
				proporcaoNegocioAtivoNaNota = valorAcumuladoOperacaoDeCadaAtivo.divide(nota.getVendasAVista(), 2, RoundingMode.HALF_UP);
			}
		} else if  (nota.getVendasAVista().compareTo(nota.getComprasAVista()) <= 0){
			if (operacao.equals("COMPRA")) {
				proporcaoNegocioAtivoNaNota = valorAcumuladoOperacaoDeCadaAtivo.divide(nota.getComprasAVista(), 2, RoundingMode.HALF_UP);
			}
		}
		return proporcaoNegocioAtivoNaNota;
	}	
}
