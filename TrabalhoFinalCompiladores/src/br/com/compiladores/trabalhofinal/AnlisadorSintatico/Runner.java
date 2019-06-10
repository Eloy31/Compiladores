package br.com.compiladores.trabalhofinal.AnlisadorSintatico;

import java.io.FileReader;
import java.nio.file.Paths;
import br.com.compiladores.trabalhofinal.AnlisadorLexico.Lexer;

public class Runner {

	public static void main(String[] args) {
		  String rootPath = Paths.get("").toAbsolutePath().toString();
	        String sourcecode = rootPath + "/arquivo.txt";

	        try {
	            Sintatico s = new Sintatico(new Lexer(new FileReader(sourcecode)));
	            Object result = s.parse().value;

	            System.out.println("Compilação Fontosa");
	        } catch (Exception e){
	            e.printStackTrace();
	        }
	    }
	}