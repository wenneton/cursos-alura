package br.com.caelum.leilao.teste;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Usuario;

public class LanceTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void lanceDeveSerInvalido() {
		Lance lance = new Lance(new Usuario("Marcos"), 0);
	}

}
