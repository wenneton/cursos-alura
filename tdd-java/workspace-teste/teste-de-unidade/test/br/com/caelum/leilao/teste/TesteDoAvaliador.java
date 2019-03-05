package br.com.caelum.leilao.teste;

import org.junit.*;

import static org.junit.Assert.assertEquals;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

//Usar hamcrest

import java.util.List;

public class TesteDoAvaliador {
	
	private Avaliador leiloeiro;
	
	@Before
	public void setUp() {
		this.leiloeiro = new Avaliador();
	}
	
	@After
	public void finaliza() {
	  System.out.println("fim");
	}
	
	@BeforeClass
	public static void testandoBeforeClass() {
	  System.out.println("before class");
	}

	@AfterClass
	public static void testandoAfterClass() {
	  System.out.println("after class");
	}
	
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		//cenario: 3 lances em ordem crescente
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");
        
        Leilao leilao = new CriadorDeLeilao().para("Playstation 3")
        		.lance(joao,250.0)
        		.lance(jose,300.0)
        		.lance(maria,350.0)
        		.constroi();

        // executando a acao
        leiloeiro.avalia(leilao);

        // comparando a saida com o esperado
        double maiorEsperado = 350;
        double menorEsperado = 250;
        
        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
    }
	
	@Test
	public void apenasUmLance() {
		
		Usuario marcos = new Usuario("Marcos");
		
		Leilao leilao = new CriadorDeLeilao().para("Playstation 4")
				.lance(marcos,200.0)
				.constroi();
		
        leiloeiro.avalia(leilao);
        
        // comparando a saida com o esperado
        assertEquals(200, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(200, leiloeiro.getMenorLance(), 0.0001);
		
	}
	
	@Test
	public void lancesAleatorios() {
		Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");
        
        Leilao leilao = new CriadorDeLeilao().para("Playstation 4")
				.lance(maria,200.0)
				.lance(joao,450.0)
				.lance(jose,120.0)
				.lance(maria,700.0)
				.lance(joao, 630.0)
				.lance(jose, 230.0)
				.constroi();
        
        leiloeiro.avalia(leilao);
        
        assertEquals(120, leiloeiro.getMenorLance(), 0.0001);
	}
	
	@Test
	public void lancesOrdemDecrescente() {
		Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");
        
        Leilao leilao = new CriadorDeLeilao().para("Playstation 4")
				.lance(maria,400.0)
				.lance(joao,300.0)
				.lance(jose,200.0)
				.lance(maria,100.0)
				.constroi();
        
        leiloeiro.avalia(leilao);
        
        assertEquals(400, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(100, leiloeiro.getMenorLance(), 0.0001);
	}

	@Test
	public void tresMaioresDeCincoLances() {
		Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");
        
        Leilao leilao = new CriadorDeLeilao().para("Playstation 4")
				.lance(maria,400.0)
				.lance(joao,450.0)
				.lance(jose,200.0)
				.lance(maria,100.0)
				.lance(jose, 250.0)
				.constroi();
        
        leiloeiro.avalia(leilao);
        
        List<Lance> maiores = leiloeiro.getTresMaiores();
        
        assertEquals(3, maiores.size());
        assertEquals(450, maiores.get(0).getValor(), 0.00001);
        assertEquals(400, maiores.get(1).getValor(), 0.00001);
        assertEquals(250, maiores.get(2).getValor(), 0.00001);   
        
        
	}
	
	@Test
	public void tresMaioresDeDoisLances() {
		 Usuario joao = new Usuario("João");
		 Usuario maria = new Usuario("Maria");
	     
	     Leilao leilao = new CriadorDeLeilao().para("Playstation 4")
					.lance(maria,400.0)
					.lance(joao,450.0)
					.constroi();
	     
	     leiloeiro.avalia(leilao);
	        
	     List<Lance> maiores = leiloeiro.getTresMaiores();
	     
	     assertEquals(2, maiores.size());
	     assertEquals(450, maiores.get(0).getValor(), 0.00001);
	     assertEquals(400, maiores.get(1).getValor(), 0.00001);	     
	     
	}
	
	@Test(expected=RuntimeException.class)
	public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {
	    Leilao leilao = new CriadorDeLeilao()
	        .para("Playstation 3 Novo")
	        .constroi();

	    leiloeiro.avalia(leilao);
	}
	
/*
	@Test
    public void testaMediaDeZeroLance(){

        // cenario
        Usuario ewertom = new Usuario("Ewertom");

        // acao
        Leilao leilao = new Leilao("Iphone 7");

        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);

        //validacao
        Assert.assertEquals(0, avaliador.getMediaDosLances(), 0.0001);

    }
    */
}
