package br.com.analisador.lexico;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

public class Programa extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public Programa () throws IOException{
		Metodos me = new Metodos();
		Atributos at = new Atributos();
		File arquivo = new File(Atributos.Arquivo);
		String str, txt = "";
		
	}
}
