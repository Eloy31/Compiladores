package br.com.analisador.lexico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws IOException {
		ArrayList<String> arq1 = new ArrayList<String>();
        ArrayList<String> arq2 = new ArrayList<String>();
        
        FileReader fr1 = new FileReader("original.txt");
        String file = JOptionPane.showInputDialog("Digita o Arquivo");
        FileReader fr2 = new FileReader(file +".txt");
        
        BufferedReader bf1 = new BufferedReader(fr1);
        BufferedReader bf2 = new BufferedReader(fr2);
        String txt = null;
        String txt2 = null;
        
        while((txt = bf1.readLine()) != null) {
            arq1.add(txt);
            
        }
        
        while((txt2 = bf2.readLine()) != null) {
            arq2.add(txt2);
        }
    
        
        Boolean igual = true;
        for (int i = 0; i < arq2.size(); i ++) {
            if (!(arq1.contains(arq2.get(i)))) {
                igual = false;
                System.out.println("Erro na Linha:" + (i+1));
                break;
            }
        }
        
        if(igual) {
            System.out.println("Compilado com Sucesso");
        }
        
    }

}
