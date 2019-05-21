package br.com.analisador.lexico;

public class Metodos {
	public String Tokens () {
		Atributos at = new Atributos();
		at.Tokens.add("if");
		at.Tokens.add("else");
		at.Tokens.add("while");
		at.Tokens.add("return");
		at.Tokens.add("float");
		at.Tokens.add("char");
		at.Tokens.add("void");
		at.Tokens.add("prnt");
		at.Tokens.add("int");
		at.Tokens.add("and");
		at.Tokens.add("or");
		at.Tokens.add("not");
		at.Tokens.add("proc");
		at.Tokens.add("var");
		
		at.Tokens.add("<");
		at.Tokens.add(">");
		at.Tokens.add("<=");
		at.Tokens.add(">=");
		at.Tokens.add("=");
		at.Tokens.add("<>");
		
		at.Tokens.add("+");
		at.Tokens.add("-");
		at.Tokens.add("*");
		at.Tokens.add("/");
		at.Tokens.add("%");
		
		at.Tokens.add(":=");
		
		at.Tokens.add("(");
		at.Tokens.add(")");
		at.Tokens.add(",");
		at.Tokens.add(";");
		at.Tokens.add("{");
		at.Tokens.add("}");
		
		
		return at.Tokens.toString();
	}
	 public void Analizador(){}

}
