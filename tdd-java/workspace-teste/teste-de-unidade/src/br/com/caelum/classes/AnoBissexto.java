package br.com.caelum.classes;

public class AnoBissexto {
	
	public boolean ehBissexto(int ano) {
		if ((ano%4 != 0) || (ano%400 != 0 && ano%100 == 0)) return false;
		else return true;
	}

}
