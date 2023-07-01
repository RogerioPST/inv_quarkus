package rogerio.pst.enumerates;

public enum MensagensEnum {	
	
	ERRO_INTERNO("Erro interno. Por favor, tente mais tarde"),	
	MENSAGEM_NAO_LOCALIZADO("Não há produtos disponiveis para os parâmetros informados"),
	FORMATO_INVALIDO("Erro ao converter os parâmetros. Por favor, verifique os parâmetros de entrada");		
	
	private String mensagem;
	
	MensagensEnum(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }        
    
    public static final String OBJETIVO_METODO_SIMULACAO = "retorna uma simulação de empréstimo em SAC e PRICE";
	

}
