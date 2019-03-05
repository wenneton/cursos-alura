package br.com.caelum.classes.teste;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import br.com.caelum.classes.AnoBissexto;

public class AnoBissextoTest {
	
	@Test
	public void deveSerBissexto() {
		AnoBissexto ano = new AnoBissexto();
		
		assertEquals(true, ano.ehBissexto(2016));
		assertEquals(true, ano.ehBissexto(1944));
		assertEquals(true, ano.ehBissexto(4));
		
	}
	
	@Test
	public void naoDeveSerBissexto() {
		AnoBissexto ano = new AnoBissexto();
		
		assertEquals(false, ano.ehBissexto(2100));
		assertEquals(false, ano.ehBissexto(2018));
		assertEquals(false, ano.ehBissexto(1900));
	}
}
