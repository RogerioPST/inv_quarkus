package rogerio.pst.exceptions.mappers;

import com.fasterxml.jackson.core.JsonProcessingException;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.jbosslog.JBossLog;
import rogerio.pst.dtos.ErroDTO;
import rogerio.pst.enumerates.MensagensEnum;

@Provider
@JBossLog
public class JsonProcessingExceptionMapper implements ExceptionMapper<JsonProcessingException>{

    @Override
    public Response toResponse(JsonProcessingException e) {       
    	ErroDTO retorno = new ErroDTO();
		retorno.setCodigo(Status.INTERNAL_SERVER_ERROR.getStatusCode());
		retorno.setMensagem(MensagensEnum.FORMATO_INVALIDO.getMensagem());	
		e.printStackTrace();
		log.info(e);
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity(retorno).type(MediaType.APPLICATION_JSON).build();                
    }        
}