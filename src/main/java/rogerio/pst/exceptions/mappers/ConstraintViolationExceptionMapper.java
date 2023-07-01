package rogerio.pst.exceptions.mappers;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
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
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException>{

    @Override
    public Response toResponse(ConstraintViolationException e) {
       
    	ErroDTO retorno = new ErroDTO();
		retorno.setCodigo(Status.BAD_REQUEST.getStatusCode());
		retorno.setMensagem(MensagensEnum.FORMATO_INVALIDO.getMensagem());	
		e.printStackTrace();
		log.info(e);
        return Response.status(Status.BAD_REQUEST).entity(retorno).type(MediaType.APPLICATION_JSON).build();   
        
        
        //return Response.status(Response.Status.BAD_REQUEST)        .entity(createErrorMessage(exception))        .type(MediaType.APPLICATION_JSON)        .build();
    }    
    
    private JsonArray createErrorMessage(ConstraintViolationException exc) {
    	 JsonArrayBuilder errors = Json.createArrayBuilder();
    	 for (ConstraintViolation<?> violation : exc.getConstraintViolations()) {
    	 errors.add(
    	 Json.createObjectBuilder()
    	 .add("path", violation.getPropertyPath().toString())
    	 .add("message", violation.getMessage())
    	 );
    	 }
    	 return errors.build();
    	 }
    
}