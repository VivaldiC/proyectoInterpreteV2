/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

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

        while (!lexer.isExausthed()) {
            System.out.printf("%-18s %s\n", lexer.currentToken(), lexer.currentLexema());
            lexer.moveAhead();
        }

        if (lexer.isSuccessful()) {
            System.out.println("Ok! :D");
        } else {
            System.out.println(lexer.errorMessage());
        }
    }
    
}
