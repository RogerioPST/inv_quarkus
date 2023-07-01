package rogerio.pst.resources;

import java.util.List;

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
import rogerio.pst.dtos.RetornoSimulacaoDTO;
import rogerio.pst.entities.Ativo;
import rogerio.pst.enumerates.MensagensEnum;
import rogerio.pst.services.AtivoService;



@Path("/api/ativo")
@Tag(name = "Crédito", description = "Serviço de Simulação de Empréstimo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@APIResponse(responseCode = "200", description = MensagensEnum.OBJETIVO_METODO_SIMULACAO, content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = RetornoSimulacaoDTO.class, type = SchemaType.OBJECT)))
@APIResponse(ref = "erro-400")
@APIResponse(ref = "erro-500")
public class AtivoResource {

	@Inject		
	AtivoService ativoService;

	
	@GET
	@Operation(summary = "simular um empréstimo")
	public List<Ativo> list(){
		return ativoService.findAll();
	}
	
}
