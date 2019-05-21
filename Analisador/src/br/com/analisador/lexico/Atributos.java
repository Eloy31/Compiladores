package br.com.analisador.lexico;

import java.util.ArrayList;

public class Atributos {
	public static String Arquivo;
	public String conteudoArquivo;
	int i;
	public ArrayList<String> Tokens = new ArrayList<>();
	
	public int getI() {
	       return i;
	   }
	   public ArrayList<String> getTokens() {
	       return Tokens;
	   }
	   public void setTokens(ArrayList<String> tokens) {
	       Tokens = tokens;
	   }
	   public void setI(int i) {
	       this.i = i;
	   }
	   public String getArquivo() {
	       return Arquivo;
	   }
	   public void setArquivo(String arquivo) {
	       Arquivo = arquivo;
	   }
	   public String getConteudoArquivo() {
	       return conteudoArquivo;
	   }
	   public void setTextoArquivo(String textoArquivo) {
	       this.conteudoArquivo = textoArquivo;
}
}
