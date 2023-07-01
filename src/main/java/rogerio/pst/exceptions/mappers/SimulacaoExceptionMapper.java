package rogerio.pst.exceptions.mappers;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.jbosslog.JBossLog;
import rogerio.pst.dtos.ErroDTO;
import rogerio.pst.exceptions.SimuladorEmprestimoException;

@Provider
@JBossLog
public class SimulacaoExceptionMapper implements ExceptionMapper<SimuladorEmprestimoException>{
	
	@Override
    public Response toResponse(SimuladorEmprestimoException e) {
		ErroDTO retorno = new ErroDTO();
		retorno.setCodigo(Status.BAD_REQUEST.getStatusCode());
		retorno.setMensagem(e.getMessage());
		e.printStackTrace();
		log.info(e);
        return Response.status(Status.BAD_REQUEST).entity(retorno).type(MediaType.APPLICATION_JSON).build();
    }
	
	

}

