
package br.com.compiladores.trabalhofinal.AnlisadorLexico;

import static br.com.compiladores.trabalhofinal.AnlisadorLexico.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espaco=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}
%%

int |
if |
else |
while {lexeme=yytext(); return Reservadas;}

{espaco} {/*Ignorar*/}
"//".* {/*Ignorar*/}

"=" |
":=" |
"<=" |
"<" |
">=" |
">" |
"<>" {return Relacional;}

"+" |
"-" |
"*" |
"/" |
"and" |
"or" |
"not" {return Operacionais;}

{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {return ERROR;}
