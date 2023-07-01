package rogerio.pst;

import org.eclipse.microprofile.openapi.annotations.Components;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import rogerio.pst.dtos.ErroDTO;


@OpenAPIDefinition(
		
    info = @Info(
        title="API de Simulação de Empréstimo",
        description = "Simular Empréstimo do tipo SAC e PRICE",
        version = "1.0.0",
        contact = @Contact(name = "Rogerio Stapait", email = "rogerio.stapait@caixa.gov.br")
    ),
	components = @Components(
		schemas = {
				@Schema(name="Erro", implementation=ErroDTO.class)
		},
		responses = {				
				@APIResponse(name="erro-400", responseCode = "400", description = "Parâmetros inválidos", 
				content= @Content(mediaType = MediaType.APPLICATION_JSON, schema= @Schema(ref = "Erro"))),
				@APIResponse(name="erro-500",responseCode = "500", description = "Erro interno", 
				content= @Content(mediaType = MediaType.APPLICATION_JSON, schema= @Schema(ref = "Erro")))
		}		
	)                 
)
							
public class InvApplication extends Application{		

}
