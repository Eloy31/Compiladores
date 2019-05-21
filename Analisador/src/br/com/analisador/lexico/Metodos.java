package br.com.analisador.lexico;

public class Metodos {
	public String Tokens () {
		Atributos at = new Atributos();
		at.getTokens().add("if");
		at.getTokens().add("else");
		at.getTokens().add("while");
		at.getTokens().add("return");
		at.getTokens().add("float");
		at.getTokens().add("char");
		at.getTokens().add("void");
		at.getTokens().add("prnt");
		at.getTokens().add("int");
		at.getTokens().add("and");
		at.getTokens().add("or");
		at.getTokens().add("not");
		at.getTokens().add("proc");
		at.getTokens().add("var");
		
		at.getTokens().add("<");
		at.getTokens().add(">");
		at.getTokens().add("<=");
		at.getTokens().add(">=");
		at.getTokens().add("=");
		at.getTokens().add("<>");
		
		at.getTokens().add("+");
		at.getTokens().add("-");
		at.getTokens().add("*");
		at.getTokens().add("/");
		at.getTokens().add("%");
		
		at.getTokens().add(":=");
		
		at.getTokens().add("(");
		at.getTokens().add(")");
		at.getTokens().add(",");
		at.getTokens().add(";");
		at.getTokens().add("{");
		at.getTokens().add("}");
		
		
		return at.getTokens().toString();
	}
	 public void Analizador(){}

}
