package br.com.compiladores.trabalhofinal.AnlisadorLexico;

import br.com.compiladores.trabalhofinal.AnlisadorSintatico.Sym;
import java_cup.runtime.Symbol;
import java_cup.runtime.XMLElement.Terminal;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Runner {

	public List<Symbol> run(String filename)  throws IOException{
		String rootPath = Paths.get("").toAbsolutePath().toString();

        String file = rootPath +"/" +filename;
        List<Symbol> list = new ArrayList<>();
        Lexer lexico = new Lexer(new FileReader(file));
        Symbol token;
        while((token = lexico.next_token()).sym != 0) {
        	System.out.println(Sym.terminalNames[token.sym]);
        	list.add(token);
        }
        return list;
	}
}