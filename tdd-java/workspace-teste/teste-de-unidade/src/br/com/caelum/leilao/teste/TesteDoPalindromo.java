package br.com.caelum.leilao.teste;

import org.junit.Test;
import org.junit.Assert;

import br.com.caelum.leilao.servico.Palindromo;

public class TesteDoPalindromo {
	
	@Test
	public void deveSerPalindromo() {
		Palindromo pal = new Palindromo();
		
		//cenario
		String frase = "Anotaram a data da maratona";
		
		//comparando saida com o esperado
		
		Assert.assertEquals(true, pal.ehPalindromo(frase));
	}
}
