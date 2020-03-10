/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.util.ArrayList;

/**
 *
 * @author VIVALDI
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lexer lexer = new Lexer("font.txt");
        Syntax ns;
        ArrayList<Tokens> nl = new ArrayList<Tokens>();
        
        while (!lexer.isExausthed()) {
            System.out.printf("%-18s %s\n", lexer.currentToken(), lexer.currentLexema());
            Tokens nt = new Tokens();
            nt.setLexema(lexer.currentLexema());
            nt.setLinea(1);
            String aux3;
            aux3 = lexer.currentToken().toString();
            nt.setToken(aux3);
            nl.add(nt);
            lexer.moveAhead();
        }
        
        for (int i = 0; i < nl.size(); i++) {
            System.out.println("-----------------------");
            System.out.println(nl.get(i).getToken());
            System.out.println(nl.get(i).getLexema());
            System.out.println(nl.get(i).getLinea());
            System.out.println("-----------------------");
        }
        ns = new Syntax(nl);
        System.out.println(ns.Imprimir());
        

        if (lexer.isSuccessful()) {
            System.out.println("Ok! :D");
        } else {
            System.out.println(lexer.errorMessage());
        }
    }
    
}
