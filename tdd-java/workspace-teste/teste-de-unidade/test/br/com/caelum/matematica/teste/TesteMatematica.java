package br.com.caelum.matematica.teste;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import br.com.caelum.matematica.MatematicaMaluca;

public class TesteMatematica {
	@Test
	public void testaFuncionamento() {
		MatematicaMaluca conta = new MatematicaMaluca();
		
		assertEquals(31*4 , conta.contaMaluca(31));
		assertEquals(15*3, conta.contaMaluca(15));
		assertEquals(2*2, conta.contaMaluca(2));
	}

}
