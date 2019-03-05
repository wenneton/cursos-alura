package br.com.caelum.leilao.teste;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.FiltroDeLances;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FiltroDeLancesTest {

    @Test
    public void deveSelecionarLancesEntre1000E3000() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao,2000), 
                new Lance(joao,1000), 
                new Lance(joao,3000), 
                new Lance(joao, 800)));

        assertEquals(1, resultado.size());
        assertEquals(2000, resultado.get(0).getValor(), 0.00001);
    }

    @Test
    public void deveSelecionarLancesEntre500E700() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao,600), 
                new Lance(joao,500), 
                new Lance(joao,700), 
                new Lance(joao, 800)));

        assertEquals(1, resultado.size());
        assertEquals(600, resultado.get(0).getValor(), 0.00001);
    }
    
    @Test
    public void deveSelecionarLancesMaioresQue5000() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao,5000), 
                new Lance(joao,5500), 
                new Lance(joao,700), 
                new Lance(joao, 800)));

        assertEquals(1, resultado.size());
        assertEquals(5500, resultado.get(0).getValor(), 0.00001);
    }
    
    @Test
    public void deveSelecionarOsLancesEspecificadosNosFiltros() {
    	Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao,5000), 
                new Lance(joao,500), 
                new Lance(joao,700),
                new Lance(joao,1000),
                new Lance(joao,3000),
                new Lance(joao, 600),
                new Lance(joao,2500),
                new Lance(joao,5700)));

        assertEquals(3, resultado.size());
        assertEquals(600, resultado.get(0).getValor(), 0.00001);
        assertEquals(2500, resultado.get(1).getValor(), 0.00001);
        assertEquals(5700, resultado.get(2).getValor(), 0.00001);
    }
    
    @Test
    public void naoDeveSelecionarNenhumLance() {
    	Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao,5000), 
                new Lance(joao,400), 
                new Lance(joao,700),
                new Lance(joao,1000),
                new Lance(joao,3000)));
        
        assertEquals(0, resultado.size());
    }
    
    
}