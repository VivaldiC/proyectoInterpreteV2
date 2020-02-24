/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author VIVALDI
 */
public enum Token {
    MAIN_KEYWORD("Main"),
    DENTERO_KEYWORD ("dEntero"),
    DCONDICION_KEYWORD ("dCondicion"),
    DMIENTRAS_KEYWORD ("dMientras"),
    ELSE_KEYWORD ("else"),
    THEN_KEYWORD("then"),
    DCADENA_KEYWORD("dCadena"),
    DFLOTANTE_KEYWORD("dFlotante"),
    DIMPRIMIR_KEYWORD("dImprimir"),
    DPAQUETE_KEYWORD("dPaquete"),
    PUBLICO_KEYWORD("dPublico"),
    PRIVADO_KEYWORD("dPrivado"),

    SEMICOLON (";"),
    COMMA (","),

    OPEN_BRACKET ("\\{"),
    CLOSE_BRACKET ("\\}"),
    OPEN_PARENTHESIS ("\\("),
    CLOSE_PARENTHESIS ("\\)"),

    EQUAL ("=="),
    DIFFERENT ("<>"),
    GREATER_EQUAL (">="),
    LESSER_EQUAL ("<="),
    ATTRIBUTION ("="),
    GREATER (">"),
    LESSER ("<"),

    ADDITION ("\\+"),
    SUBTRACTION ("-"),
    MULTIPLICATION ("\\*"),
    DIVISION ("/"),

    STRING ("\"[^\"]+\""),
    NUMBER ("\\d+(\\.\\d+)?"),
    IDENTIFIER ("\\w+");    

    private final Pattern pattern;

    Token(String regex) {
        pattern = Pattern.compile("^" + regex);
    }
    //Buscalo los patrones que hemos señalado en la parte de arriba en el codigo

    int endOfMatch(String s) {
        Matcher m = pattern.matcher(s);

        if (m.find()) {
            return m.end();
        }

        return -1;
    }
    //Con el matcher es buscar unicamente las palabras que son 100% relacionadas
    
    
}
