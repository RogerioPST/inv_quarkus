package rogerio.pst.exceptions.mappers;

import jakarta.ws.rs.WebApplicationException;
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
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException>{

    @Override
    public Response toResponse(WebApplicationException e) {    	    	
       
    	ErroDTO retorno = new ErroDTO();
		retorno.setCodigo(Status.BAD_REQUEST.getStatusCode());
		retorno.setMensagem(MensagensEnum.FORMATO_INVALIDO.getMensagem());	
		e.printStackTrace();
		log.info(e);
        return Response.status(Status.BAD_REQUEST).entity(retorno).type(MediaType.APPLICATION_JSON).build();                
    }    
    
}