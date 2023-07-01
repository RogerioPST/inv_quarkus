package rogerio.pst.services;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import rogerio.pst.entities.Ativo;
import rogerio.pst.entities.MovimentacaoPregao;
import rogerio.pst.entities.Pregao;
import rogerio.pst.entities.Provento;
import rogerio.pst.entities.TipoMovimentacao;
import rogerio.pst.entities.TipoProvento;
import rogerio.pst.entities.Usuario;
import rogerio.pst.repositories.AtivoRepository;
import rogerio.pst.repositories.AtivoUsuarioRepository;
import rogerio.pst.repositories.MovimentacaoPregaoRepository;
import rogerio.pst.repositories.PregaoRepository;
import rogerio.pst.repositories.ProventoRepository;
import rogerio.pst.repositories.TipoMovimentacaoRepository;
import rogerio.pst.repositories.TipoProventoRepository;
import rogerio.pst.repositories.UsuarioRepository;

@ApplicationScoped
public class UsuarioService {
	
	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
	
	@Inject
	UsuarioRepository usuarioRepository;
	
	@Inject
	AtivoRepository ativoRepository;  
	
	@Inject
	TipoProventoRepository tipoProventoRepository;
	
	@Inject
	TipoMovimentacaoRepository tipoMovimentacaoRepository;
	
	@Inject
	PregaoRepository pregaoRepository;
	
	@Inject
	ProventoRepository proventoRepository;
	
	@Inject
	MovimentacaoPregaoRepository movimentacaoPregaoRepository;
	
	@Inject
	AtivoUsuarioRepository ativoUsuarioRepository;
	
	

	public List<Usuario> findAll() {
		return usuarioRepository.findAll().list();
	}	
	
	@Transactional
	public void popular() throws ParseException {
		//usuarioRepository.deleteAll();
		//ativoRepository.deleteAll();
		//tipoProventoRepository.deleteAll();
		//tipoMovimentacaoRepository.deleteAll();
		//pregaoRepository.deleteAll();
		//proventoRepository.deleteAll();
		//movimentacaoPregaoRepository.deleteAll();
		//ativoUsuarioRepository.deleteAll();
		
		Usuario u = new Usuario();
		u.setNome("Rogerio");
		u.setLogin("roger");
		usuarioRepository.persist(u);

		Ativo a = new Ativo();
		a.setNome("PETR4");
		ativoRepository.persist(a);						
		Ativo bbas3 = new Ativo();
		bbas3.setNome("BBAS3");
		ativoRepository.persist(bbas3);						
		Ativo enbr3 = new Ativo();
		enbr3.setNome("ENBR3");
		ativoRepository.persist(enbr3);						
		Ativo itsa4 = new Ativo();
		itsa4.setNome("ITSA4");
		ativoRepository.persist(itsa4);						
		Ativo taee11 = new Ativo();
		taee11.setNome("TAEE11");
		ativoRepository.persist(taee11);
		

		TipoProvento tp = new TipoProvento();
		tp.setNome("RENDIMENTO");
		tp.setSigla("REND");
		tipoProventoRepository.persist(tp);

		TipoMovimentacao tm = new TipoMovimentacao();
		tm.setNome("COMPRA");			
		tipoMovimentacaoRepository.persist(tm);

		TipoMovimentacao tm2 = new TipoMovimentacao();
		tm2.setNome("VENDA");			
		tipoMovimentacaoRepository.persist(tm2);


		Pregao p = new Pregao();
		p.setUsuario(u);						
		p.setData(SDF.parse("2021-12-30"));			
		p.setComprasAVista(BigDecimal.valueOf(47723.04));
		p.setVendasAVista(BigDecimal.valueOf(0));
		p.setValorOperacoes(BigDecimal.valueOf(47723.04));
		p.setValorLiquidoOperacoes(BigDecimal.valueOf(47723.04));
		p.setTaxaLiquidacao(BigDecimal.valueOf(11.93));
		p.setTotalCblc(BigDecimal.valueOf(47734.97));			
		p.setEmolumentos(BigDecimal.valueOf(2.38));			
		p.setTaxaOperacional(BigDecimal.valueOf(53.90));			
		p.setImpostos(BigDecimal.valueOf(5.75));			
		p.setOutros(BigDecimal.valueOf(2.10));			
		p.setTotalCustosDespesas(BigDecimal.valueOf(61.75));			
		p.setDataLiquidoPara(SDF.parse("2022-01-04"));			
		p.setValorLiquidoPara(BigDecimal.valueOf(47799.10));			
		pregaoRepository.persist(p);


		Pregao p2 = new Pregao();
		p2.setUsuario(u);						
		p2.setData(SDF.parse("2022-02-27"));			
		p2.setComprasAVista(BigDecimal.valueOf(47723.04));
		p2.setVendasAVista(BigDecimal.valueOf(0));
		p2.setValorOperacoes(BigDecimal.valueOf(47723.04));
		p2.setValorLiquidoOperacoes(BigDecimal.valueOf(47723.04));
		p2.setTaxaLiquidacao(BigDecimal.valueOf(11.93));
		p2.setTotalCblc(BigDecimal.valueOf(47734.97));			
		p2.setEmolumentos(BigDecimal.valueOf(2.38));			
		p2.setTaxaOperacional(BigDecimal.valueOf(53.90));			
		p2.setImpostos(BigDecimal.valueOf(5.75));			
		p2.setOutros(BigDecimal.valueOf(2.10));			
		p2.setTotalCustosDespesas(BigDecimal.valueOf(61.75));			
		p2.setDataLiquidoPara(SDF.parse("2022-03-02"));			
		p2.setValorLiquidoPara(BigDecimal.valueOf(47799.10));			
		pregaoRepository.persist(p2);

		Pregao p3 = new Pregao();
		p3.setUsuario(u);						
		p3.setData(SDF.parse("2022-01-11"));			
		p3.setComprasAVista(BigDecimal.valueOf(47723.04));
		p3.setVendasAVista(BigDecimal.valueOf(0));
		p3.setValorOperacoes(BigDecimal.valueOf(47723.04));
		p3.setValorLiquidoOperacoes(BigDecimal.valueOf(47723.04));
		p3.setTaxaLiquidacao(BigDecimal.valueOf(11.93));
		p3.setTotalCblc(BigDecimal.valueOf(47734.97));			
		p3.setEmolumentos(BigDecimal.valueOf(2.38));			
		p3.setTaxaOperacional(BigDecimal.valueOf(53.90));			
		p3.setImpostos(BigDecimal.valueOf(5.75));			
		p3.setOutros(BigDecimal.valueOf(2.10));			
		p3.setTotalCustosDespesas(BigDecimal.valueOf(61.75));			
		p3.setDataLiquidoPara(SDF.parse("2022-01-13"));			
		p3.setValorLiquidoPara(BigDecimal.valueOf(47799.10));			
		pregaoRepository.persist(p3);

		
		MovimentacaoPregao mp = new MovimentacaoPregao();
		mp.setPregao(p);					
		mp.setAtivo(bbas3);	
		mp.setQuantidade(9);
		mp.setPreco(BigDecimal.valueOf(28.88));
		mp.setValorOperacao(BigDecimal.valueOf(259.92));
		mp.setTipoMovimentacao(tm);	
		movimentacaoPregaoRepository.persist(mp);

		MovimentacaoPregao mp3 = new MovimentacaoPregao();
		mp3.setPregao(p);					
		mp3.setAtivo(bbas3);	
		mp3.setQuantidade(1);
		mp3.setPreco(BigDecimal.valueOf(28.88));
		mp3.setValorOperacao(BigDecimal.valueOf(28.88));
		mp3.setTipoMovimentacao(tm);	
		movimentacaoPregaoRepository.persist(mp3);

		MovimentacaoPregao mp4 = new MovimentacaoPregao();
		mp4.setPregao(p3);					
		mp4.setAtivo(bbas3);	
		mp4.setQuantidade(500);
		mp4.setPreco(BigDecimal.valueOf(28.87));
		mp4.setValorOperacao(BigDecimal.valueOf(14439.32));
		mp4.setTipoMovimentacao(tm);	
		movimentacaoPregaoRepository.persist(mp4);

		MovimentacaoPregao mp5 = new MovimentacaoPregao();
		mp5.setPregao(p3);					
		mp5.setAtivo(bbas3);	
		mp5.setQuantidade(500);
		mp5.setPreco(BigDecimal.valueOf(28.87));
		mp5.setValorOperacao(BigDecimal.valueOf(14439.32));
		mp5.setTipoMovimentacao(tm2);	
		movimentacaoPregaoRepository.persist(mp5);

		MovimentacaoPregao mpPregao2 = new MovimentacaoPregao();
		mpPregao2.setPregao(p2);					
		mpPregao2.setAtivo(a);	
		mpPregao2.setQuantidade(100);
		mpPregao2.setPreco(BigDecimal.valueOf(26.50));
		mpPregao2.setValorOperacao(new BigDecimal(2600));
		mpPregao2.setTipoMovimentacao(tm);	
		movimentacaoPregaoRepository.persist(mpPregao2);
		

		MovimentacaoPregao mp2 = new MovimentacaoPregao();
		mp2.setPregao(p);					
		mp2.setAtivo(a);	
		mp2.setQuantidade(100);
		mp2.setPreco(new BigDecimal(26));
		mp2.setValorOperacao(BigDecimal.valueOf(2600.50));
		mp2.setTipoMovimentacao(tm2);	
		movimentacaoPregaoRepository.persist(mp2);
		
		Provento provento = new Provento();
		provento.setUsuario(u);			
		provento.setTipoProvento(tp);		
		provento.setAtivo(a);					
		provento.setValor(new BigDecimal(70));		
		provento.setQuantidadeCotas(50);			
		provento.setData(SDF.parse("2022-01-30"));			
		proventoRepository.persist(provento);

		Provento provento1 = new Provento();
		provento1.setUsuario(u);			
		provento1.setTipoProvento(tp);		
		provento1.setAtivo(a);					
		provento1.setValor(new BigDecimal(70));		
		provento1.setQuantidadeCotas(50);			
		provento1.setData(SDF.parse("2021-01-30"));			
		proventoRepository.persist(provento1);															

		Provento provento2 = new Provento();
		provento2.setUsuario(u);			
		provento2.setTipoProvento(tp);		
		provento2.setAtivo(a);					
		provento2.setValor(new BigDecimal(50));		
		provento2.setQuantidadeCotas(50);			
		provento2.setData(SDF.parse("2021-03-30"));			
		proventoRepository.persist(provento2);	

		Provento provento3 = new Provento();
		provento3.setUsuario(u);			
		provento3.setTipoProvento(tp);		
		provento3.setAtivo(a);					
		provento3.setValor(new BigDecimal(50));		
		provento3.setQuantidadeCotas(50);			
		provento3.setData(SDF.parse("2022-02-30"));			
		proventoRepository.persist(provento3);	
	}

}
