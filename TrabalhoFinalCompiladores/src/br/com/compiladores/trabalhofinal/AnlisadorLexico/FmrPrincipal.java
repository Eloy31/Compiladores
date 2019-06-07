package br.com.compiladores.trabalhofinal.AnlisadorLexico;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.DropMode;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class FmrPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textEntrada;
	private JTextField textField;
	private JTextArea TxtResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FmrPrincipal frame = new FmrPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FmrPrincipal() {
		
		textField = new JTextField();
		getContentPane().add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textEntrada = new JTextField();
		textEntrada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textEntrada.setToolTipText("");
		textEntrada.setEditable(true);
		textEntrada.setBackground(Color.WHITE);
		textEntrada.setColumns(10);
		
		JTextArea TxtResultado = new JTextArea();
		TxtResultado.setDropMode(DropMode.INSERT);
		
		/*Aqui configuro o fmr para receber as informações do usuario e aplicar minhas regras de analisador*/
		JButton btnAnalisar = new JButton("Analisar");
		btnAnalisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File arquivo = new File("arquivo.txt");
				PrintWriter escrever;
				try {
					escrever = new PrintWriter(arquivo);
					escrever.print(textEntrada.getText());
					escrever.close(); // aqui salvo o que o usuario digitou em um txt
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Reader leitor = new BufferedReader(new FileReader("arquivo.txt"));//aqui leio o txt para analisar
					Lexer lexer = new Lexer(leitor);
					String resultado = "";
					while (true) {
						Tokens tokens = lexer.yylex();
						if (tokens == null) {
							resultado += " fim";
							TxtResultado.setText(resultado);
							return;
						}
						switch (tokens) {
						case ERROR:
							resultado += "o simbolo não é valido \n";
							break;
							
						case Numero:
						case Identificador:
						case Reservadas:
							resultado += lexer.lexeme + " é um "+ tokens +"\n";
							break;
							
						case Operacionais:
							resultado += lexer.lexeme +" é um operador matematico";
							break;
						
						case Relacional:
							resultado += lexer.lexeme +" é uma atribuição";
							break;

						default:
							resultado += " o simbolo não é valido \n";
							break;
						}
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAnalisar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textEntrada, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(btnAnalisar, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
						.addComponent(TxtResultado, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(212, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textEntrada, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAnalisar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(TxtResultado, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
