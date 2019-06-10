package br.com.compiladores.trabalhofinal.AnlisadorLexico;
import java_cup.runtime.Symbol;
import br.com.compiladores.trabalhofinal.AnlisadorSintatico.Sym;

%%
%cup
%public
%unicode
%class Lexer
%line
%column
%{
   private Symbol symbol(int type, Object o){
      return new Symbol(type, yyline+1, yycolumn+1, o);
    }
    private Symbol symbol(int type){
      return new Symbol(type, yyline+1, yycolumn+1);
    }
%}

IGNORE = [\n|\t|\r]
ESPACO = [ ]
//Identificador
ID = [a-z][a-zA-Z_|0-9]*

//Caracter literal
CHARL = \'[0-9|a-zA-Z|\n|\t| |:|\(|\)|,]\'

//Simbolos
SETAR = :=
MENORQUE = <
MAIORQUE = >
MENORIGUAL = <=
MAIORIGUAL = >=
IGUAL = =
DIFERENTE = <>
MAIS = \+
MENOS = -
VEZES = \*
DIVISAO = \/
MOD = %
AND = "and"
OR = "or"
NOT = "not"
PAREESQUE = \(
PAREDIREI = \)
VIRG = ,
PONTVIRG = ;
CHAVESQ = \{
CHAVDIREI = \}

//Numeros
INTL = [+-]{1}[0-9]+|[0-9]+
FLOATL = [[0-9]*,[0-9]+] | [[0-9]*,[0-9]+E[+-]{1}[0-9]*,[0-9]+]

//Comentarios
LINHA = \*{2}[\x20-\xED]*[\n|\r]
MULTILINHA = >{2}[\x20-\xED|\x09-\x0D]+<{2}


//Palavras chaves
IF = "if"
ELSE = "else"
WHILE = "while"
RETURN = "return"
FLOAT = "float"
CHAR = "char"
VOID = "void"
PRINT = "prnt"
INT = "int"
FUNCTION = "proc"
VAR = "var"
%%

<YYINITIAL>{

{IF} { return symbol(Sym.IF,yytext()); }
{ELSE} { return symbol(Sym.ELSE,yytext()); }
{WHILE} { return symbol(Sym.WHILE,yytext()); }
{RETURN} { return symbol(Sym.RETURN,yytext()); }
{FLOAT} { return symbol(Sym.FLOAT,yytext()); }
{CHAR} { return symbol(Sym.CHAR,yytext()); }
{VOID} { return symbol(Sym.VOID,yytext()); }
{PRINT} { return symbol(Sym.PRINT,yytext()); }
{INT} { return symbol(Sym.INT,yytext()); }
{FUNCTION} { return symbol(Sym.FUNC,yytext()); }
{VAR} { return symbol(Sym.VAR,yytext()); }
{ID} { return symbol(Sym.ID,yytext());}
{CHARL} {return symbol(Sym.CHARL,yytext());}
{SETAR} {return symbol(Sym.SETAR,yytext());}
{MENORQUE} {return symbol(Sym.MENORQUE,yytext());}
{MAIORQUE} {return symbol(Sym.MAIORQUE,yytext());}
{MENORIGUAL} {return symbol(Sym.MENORIGUAL,yytext());}
{MAIORIGUAL} {return symbol(Sym.MAIORIGUAL,yytext());}
{IGUAL} {return symbol(Sym.IGUAL,yytext());}
{DIFERENTE} {return symbol(Sym.DIFERENTE,yytext());}
{MAIS} {return symbol(Sym.MAIS,yytext());}
{MENOS} {return symbol(Sym.MENOS,yytext());}
{VEZES} {return symbol(Sym.VEZES,yytext());}
{DIVISAO} {return symbol(Sym.DIVISAO,yytext());}
{MOD} {return symbol(Sym.MOD,yytext());}
{AND} {return symbol(Sym.ADD,yytext());}
{OR} {return symbol(Sym.OR,yytext());}
{NOT} {return symbol(Sym.NOT,yytext());}
{PAREESQUE} {return symbol(Sym.PAREESQUE,yytext());}
{PAREDIREI} {return symbol(Sym.PAREDIREI,yytext());}
{VIRG} {return symbol(Sym.VIRG,yytext());}
{PONTVIRG} {return symbol(Sym.PONTVIRG,yytext());}
{CHAVESQ} {return symbol(Sym.CHAVESQ,yytext());}
{CHAVDIREI} {return symbol(Sym.CHAVDIREI,yytext());}
{INTL} { return symbol(Sym.INTL,yytext()); }
{FLOATL} {return symbol(Sym.FLOATL,yytext()); }
{LINHA} {}
{MULTILINHA} {}
{IGNORE} {}
{ESPACO} {}
}
<<EOF>> {return symbol(Sym.EOF);}

[^] {throw new Error("Caractere invalido " + yytext() + " na linha " + (yyline+1) + ", coluna " + (yycolumn+1));}