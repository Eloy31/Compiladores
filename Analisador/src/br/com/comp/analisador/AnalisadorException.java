 package br.com.comp.analisador;

public class AnalisadorException extends Exception{
int linha, coluna;
	
	public AnalisadorException(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public String toString() {
		return "Caracter invalido na linha "+linha+" e na coluna "+coluna+"!";
	}

}
