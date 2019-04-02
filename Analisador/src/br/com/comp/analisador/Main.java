package br.com.comp.analisador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JOptionPane;

public class Main {
	static boolean igual = true;
	static boolean igual2 = false;

	static void comp(Character c1, Character c2) {
		if (Character.isLetter(c1)) {
			Character.toLowerCase(c1);
		}
		if (Character.isLetter(c2)) {
			Character.toLowerCase(c2);
		}
		if (c1.equals(c2)) {
			igual2 = true;
		}
	}

	static void erro(int linha, int coluna) throws AnalisadorException {
		if (!igual2) {
			igual = false;
			throw new AnalisadorException(linha, coluna);
		}
	}

	public static void main(String[] args) throws IOException {

		Set<Character> arq1 = new LinkedHashSet<>();
		String file = JOptionPane.showInputDialog("Digita o Arquivo");
		String txt ,txt2;
try {
	FileReader fr1 = new FileReader("original.txt");
	FileReader fr2 = new FileReader(file + ".txt");
	BufferedReader bf1 = new BufferedReader(fr1);
	BufferedReader bf2 = new BufferedReader(fr2);
		while ((txt = bf1.readLine()) != null) {
			txt.chars().forEachOrdered(i -> arq1.add((char) i));

		}

		for (int i = 0; (txt2 = bf2.readLine()) != null; i++) {
			for (int j = 0; j < txt2.length(); j++) {
				for (char c : arq1) {
					igual2 = false;
					comp(txt2.charAt(j), c);
					if (igual2) {
						break;
					}
					
				}
				try {
					erro(i+1, j+1);
				} catch (AnalisadorException e) {
					e.printStackTrace();
				}
			}
		}
		if (igual) {
			System.out.println("Compilado com Sucesso.");
		}
		bf1.close();
		bf2.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
