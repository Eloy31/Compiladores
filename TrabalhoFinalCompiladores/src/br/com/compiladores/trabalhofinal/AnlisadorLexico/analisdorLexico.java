package br.com.compiladores.trabalhofinal.AnlisadorLexico;

import java.io.File;


public class analisdorLexico {
	public static void main(String[] args) {
		String rota = "C:/Users/Alunotgn/Desktop/Compiladores/TrabalhoFinalCompiladores/src/br/com/compiladores/trabalhofinal/AnlisadorLexico/Lexer.flex";
		gerarLexico(rota);
	}
	public static void gerarLexico(String rota) {
		File arquivo = new File(rota);
		jflex.Main.generate(arquivo);
	}
}
